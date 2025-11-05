package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import b.a.q.i0;
import b.a.q.k0.g;
import b.c.a.a0.d;
import b.i.a.f.e.o.f;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import co.discord.media_engine.VideoInputDeviceFacing;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelRtcLatencyRegion;
import com.discord.models.experiments.domain.Experiment;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.LowMemoryDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreMediaSettings;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.error.Error;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.hammerandchisel.libdiscord.Discord;
import d0.l;
import d0.t.j;
import d0.t.u;
import d0.w.h.b;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.g;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.l.a.c0;
import j0.l.a.g1;
import j0.l.a.h1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import s.a.a.n;
import s.a.h;
import s.a.k0;
import s.a.x0;

/* compiled from: StoreMediaEngine.kt */
/* loaded from: classes2.dex */
public final class StoreMediaEngine extends Store {
    private static final String DEFAULT_VIDEO_DEVICE_GUID = "";
    private static final long MAX_WAIT_FOR_DEVICES_MS = 750;
    private final Dispatcher dispatcher;
    private boolean hasNativeEngineEverInitialized;
    private Persister<Boolean> hasNativeEngineEverInitializedCache;
    private boolean hasTimedOutAwaitingDevice;
    private final SerializedSubject<Boolean, Boolean> isNativeEngineInitializedSubject;
    private final ListenerCollectionSubject<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
    private final Observable<MediaEngine.LocalVoiceStatus> localVoiceStatus;
    private final SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> localVoiceStatusSubject;
    private MediaEngine mediaEngine;
    private Subscription mediaEngineSettingsSubscription;
    private final StoreMediaSettings mediaSettingsStore;
    private final PublishSubject<KrispOveruseDetector.Status> onKrispStatusSubject;
    private final SerializedSubject<MediaEngine.OpenSLESConfig, MediaEngine.OpenSLESConfig> openSLESConfigSubject;
    private String preferredVideoInputDeviceGUID;
    private final Persister<String> preferredVideoInputDeviceGuidCache;
    private Long previousVoiceChannelId;
    private final SerializedSubject<Boolean, Boolean> pttActiveSubject;
    private VideoInputDeviceDescription selectedVideoInputDevice;
    private final BehaviorSubject<VideoInputDeviceDescription> selectedVideoInputDeviceSubject;
    private final StoreStream storeStream;
    private long userId;
    private VideoInputDeviceDescription[] videoInputDevices;
    private final BehaviorSubject<List<VideoInputDeviceDescription>> videoInputDevicesSubject;
    private static final MediaEngine.LocalVoiceStatus LOCAL_VOICE_STATUS_DEFAULT = new MediaEngine.LocalVoiceStatus(-100.0f, false);
    private static final MediaEngine.OpenSLESConfig DEFAULT_OPENSLES_CONFIG = MediaEngine.OpenSLESConfig.DEFAULT;

    /* compiled from: StoreMediaEngine.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.stores.StoreMediaEngine.Listener
        public void onConnected() {
        }

        @Override // com.discord.stores.StoreMediaEngine.Listener
        public void onConnecting() {
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    public final class EngineListener implements MediaEngine.c {
        private final LowMemoryDetector lowMemoryDetector = new LowMemoryDetector();
        private long debugPrintableId = -1;

        public EngineListener() {
        }

        private final Context getContext() {
            return ApplicationProvider.INSTANCE.get();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onConnected() {
            StoreMediaEngine.access$getListenerSubject$p(StoreMediaEngine.this).notify(StoreMediaEngine$EngineListener$onConnected$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onConnecting() {
            StoreMediaEngine.access$getListenerSubject$p(StoreMediaEngine.this).notify(StoreMediaEngine$EngineListener$onConnecting$1.INSTANCE);
        }

        public void onDestroy() {
            getContext().unregisterComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                i0 i0Var = i0.n;
                synchronized (i0Var) {
                    if (i0.k) {
                        d.b1("ThermalDetector", "unregister");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).removeThermalStatusListener(i0Var);
                        i0.k = false;
                        i0.l = false;
                        if (i0.m) {
                            ((Handler) i0.j.getValue()).removeCallbacks(i0Var);
                            i0.m = false;
                        }
                    }
                }
                SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().remove(this.debugPrintableId);
                this.debugPrintableId = -1L;
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onNativeEngineInitialized() {
            getContext().registerComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                i0 i0Var = i0.n;
                synchronized (i0Var) {
                    if (!i0.k) {
                        d.b1("ThermalDetector", "register");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).addThermalStatusListener(i0Var);
                        i0.k = true;
                    }
                }
                this.debugPrintableId = SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().add(i0Var, "ThermalDetector");
            }
            StoreMediaEngine.access$handleNativeEngineInitialized(StoreMediaEngine.this);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.c
        public void onNewConnection(MediaEngineConnection connection) {
            m.checkNotNullParameter(connection, "connection");
            StoreMediaEngine.access$handleNewConnection(StoreMediaEngine.this, connection);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    public interface Listener {
        void onConnected();

        void onConnecting();
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            KrispOveruseDetector.Status.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[KrispOveruseDetector.Status.FAILED.ordinal()] = 1;
            iArr[KrispOveruseDetector.Status.CPU_OVERUSE.ordinal()] = 2;
            iArr[KrispOveruseDetector.Status.VAD_CPU_OVERUSE.ordinal()] = 3;
            MediaEngineConnection.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[MediaEngineConnection.Type.DEFAULT.ordinal()] = 1;
            iArr2[MediaEngineConnection.Type.STREAM.ordinal()] = 2;
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @e(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {264}, m = "awaitVideoInputDevicesNativeAsync")
    /* renamed from: com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.w.i.a.d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.awaitVideoInputDevicesNativeAsync(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$enableLocalVoiceStatusListening$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<MediaEngine.LocalVoiceStatus, Unit> {
        public AnonymousClass1(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            invoke2(localVoiceStatus);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            ((SerializedSubject) this.receiver).k.onNext(localVoiceStatus);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @e(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {209}, m = "getDefaultVideoDeviceGUID")
    /* renamed from: com.discord.stores.StoreMediaEngine$getDefaultVideoDeviceGUID$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.w.i.a.d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.getDefaultVideoDeviceGUID(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$getRankedRtcRegions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String[], Unit> {
        public final /* synthetic */ Function1 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
            invoke2(strArr);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String[] strArr) {
            m.checkNotNullParameter(strArr, "it");
            this.$callback.invoke(d0.t.k.toList(strArr));
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$getVideoInputDevicesNative$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<VideoInputDeviceDescription[], Unit> {
        public AnonymousClass1(Function1 function1) {
            super(1, function1, Function1.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            m.checkNotNullParameter(videoInputDeviceDescriptionArr, "p1");
            ((Function1) this.receiver).invoke(videoInputDeviceDescriptionArr);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleMicrophonePermissionGranted$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            m.checkNotNullExpressionValue(bool, "isInitialized");
            if (bool.booleanValue()) {
                StoreMediaEngine.access$restartLocalMicrophone(StoreMediaEngine.this);
            }
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$1, reason: invalid class name */
    public static final class AnonymousClass1 extends MediaEngineConnection.a {
        public AnonymousClass1() {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onDestroy(MediaEngineConnection connection) {
            m.checkNotNullParameter(connection, "connection");
            if (u.minus(StoreMediaEngine.this.getMediaEngine().getConnections(), connection).isEmpty()) {
                StoreMediaEngine.access$getMediaSettingsStore$p(StoreMediaEngine.this).revertTemporaryDisableKrisp();
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onKrispStatus(MediaEngineConnection connection, KrispOveruseDetector.Status status) {
            m.checkNotNullParameter(connection, "connection");
            m.checkNotNullParameter(status, "status");
            AppLog.i("onKrispStatus(" + status + ')');
            StoreMediaEngine.access$getOnKrispStatusSubject$p(StoreMediaEngine.this).k.onNext(status);
            int iOrdinal = status.ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                StoreMediaEngine.access$getMediaSettingsStore$p(StoreMediaEngine.this).setNoiseProcessing(StoreMediaSettings.NoiseProcessing.CancellationTemporarilyDisabled);
            } else {
                if (iOrdinal != 2) {
                    return;
                }
                StoreMediaEngine.access$getMediaSettingsStore$p(StoreMediaEngine.this).setVADUseKrisp(StoreMediaSettings.VadUseKrisp.TemporarilyDisabled);
            }
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<VideoInputDeviceDescription[], Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            m.checkNotNullParameter(videoInputDeviceDescriptionArr, "devices");
            StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
            VideoInputDeviceDescription videoInputDeviceDescriptionAccess$getSelectedVideoInputDevice$p = StoreMediaEngine.access$getSelectedVideoInputDevice$p(storeMediaEngine);
            StoreMediaEngine.handleVideoInputDevices$default(storeMediaEngine, videoInputDeviceDescriptionArr, videoInputDeviceDescriptionAccess$getSelectedVideoInputDevice$p != null ? videoInputDeviceDescriptionAccess$getSelectedVideoInputDevice$p.getGuid() : null, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleVoiceChannelSelected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<VideoInputDeviceDescription[], Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            m.checkNotNullParameter(videoInputDeviceDescriptionArr, "it");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, videoInputDeviceDescriptionArr, null, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$init$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Experiment, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            int bucket = experiment.getBucket();
            StoreMediaEngine.this.getMediaEngine().h((bucket == 1 || bucket == 3) ? MediaEngine.OpenSLUsageMode.EXCLUDE_LIST : MediaEngine.OpenSLUsageMode.ALLOW_LIST);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @e(c = "com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1", f = "StoreMediaEngine.kt", l = {Opcodes.ANEWARRAY}, m = "invokeSuspend")
    /* renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.w.i.a.k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1 $onSelected;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$onSelected = function1;
        }

        @Override // d0.w.i.a.a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            m.checkNotNullParameter(continuation, "completion");
            return StoreMediaEngine.this.new AnonymousClass1(this.$onSelected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                l.throwOnFailure(obj);
                StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
                this.label = 1;
                obj = storeMediaEngine.awaitVideoInputDevicesNativeAsync(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                l.throwOnFailure(obj);
            }
            VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) obj;
            StoreMediaEngine.access$handleVideoInputDevices(StoreMediaEngine.this, videoInputDeviceDescriptionArr, StoreMediaEngine.access$pickDefaultDeviceGUID(StoreMediaEngine.this, videoInputDeviceDescriptionArr), this.$onSelected);
            return Unit.a;
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @e(c = "com.discord.stores.StoreMediaEngine", f = "StoreMediaEngine.kt", l = {202}, m = "selectDefaultVideoDeviceAsync")
    /* renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDeviceAsync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.w.i.a.d {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // d0.w.i.a.a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.selectDefaultVideoDeviceAsync(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$selectVideoInputDevice$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<VideoInputDeviceDescription[], Unit> {
        public final /* synthetic */ String $deviceGUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$deviceGUID = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            invoke2(videoInputDeviceDescriptionArr);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
            m.checkNotNullParameter(videoInputDeviceDescriptionArr, "devices");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, videoInputDeviceDescriptionArr, this.$deviceGUID, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<StoreMediaSettings.VoiceConfiguration, Unit> {

        /* compiled from: StoreMediaEngine.kt */
        /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02681 extends o implements Function0<Unit> {
            public final /* synthetic */ StoreMediaSettings.VoiceConfiguration $voiceConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02681(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
                super(0);
                this.$voiceConfig = voiceConfiguration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMediaEngine.access$handleVoiceConfigChanged(StoreMediaEngine.this, this.$voiceConfig);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            invoke2(voiceConfiguration);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            m.checkNotNullParameter(voiceConfiguration, "voiceConfig");
            StoreMediaEngine.access$getDispatcher$p(StoreMediaEngine.this).schedule(new C02681(voiceConfiguration));
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            Logger.e$default(AppLog.g, "handleVoiceConfigChanged", error.getThrowable(), null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Subscription, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            m.checkNotNullParameter(subscription, "it");
            StoreMediaEngine.access$setMediaEngineSettingsSubscription$p(StoreMediaEngine.this, subscription);
        }
    }

    public StoreMediaEngine(StoreMediaSettings storeMediaSettings, StoreStream storeStream, Dispatcher dispatcher) {
        m.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        m.checkNotNullParameter(storeStream, "storeStream");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.mediaSettingsStore = storeMediaSettings;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        ListenerCollectionSubject<Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> serializedSubject = new SerializedSubject<>(BehaviorSubject.l0(LOCAL_VOICE_STATUS_DEFAULT));
        this.localVoiceStatusSubject = serializedSubject;
        Boolean bool = Boolean.FALSE;
        this.pttActiveSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.preferredVideoInputDeviceGUID = "";
        this.preferredVideoInputDeviceGuidCache = new Persister<>("PREFERRED_VIDEO_INPUT_DEVICE_GUID", this.preferredVideoInputDeviceGUID);
        this.selectedVideoInputDeviceSubject = BehaviorSubject.l0(this.selectedVideoInputDevice);
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = new VideoInputDeviceDescription[0];
        this.videoInputDevices = videoInputDeviceDescriptionArr;
        this.videoInputDevicesSubject = BehaviorSubject.l0(j.asList(videoInputDeviceDescriptionArr));
        this.openSLESConfigSubject = new SerializedSubject<>(BehaviorSubject.k0());
        this.isNativeEngineInitializedSubject = new SerializedSubject<>(BehaviorSubject.l0(bool));
        this.userId = -1L;
        this.hasNativeEngineEverInitializedCache = new Persister<>("CACHE_KEY_NATIVE_ENGINE_EVER_INITIALIZED", Boolean.valueOf(this.hasNativeEngineEverInitialized));
        this.onKrispStatusSubject = PublishSubject.k0();
        Observable observableW = ObservableExtensionsKt.computationLatest(serializedSubject).r().v(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$1(this))).w(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$2(this)));
        AtomicReference atomicReference = new AtomicReference();
        Observable<MediaEngine.LocalVoiceStatus> observableH0 = Observable.h0(new c0(new h1(new g1(atomicReference), observableW, atomicReference)));
        m.checkNotNullExpressionValue(observableH0, "localVoiceStatusSubject\n…ening)\n          .share()");
        this.localVoiceStatus = observableH0;
    }

    public static final /* synthetic */ void access$disableLocalVoiceStatusListening(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.disableLocalVoiceStatusListening();
    }

    public static final /* synthetic */ void access$enableLocalVoiceStatusListening(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.enableLocalVoiceStatusListening();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.dispatcher;
    }

    public static final /* synthetic */ boolean access$getHasTimedOutAwaitingDevice$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.hasTimedOutAwaitingDevice;
    }

    public static final /* synthetic */ ListenerCollectionSubject access$getListenerSubject$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.listenerSubject;
    }

    public static final /* synthetic */ MediaEngine access$getMediaEngine$p(StoreMediaEngine storeMediaEngine) {
        MediaEngine mediaEngine = storeMediaEngine.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public static final /* synthetic */ Subscription access$getMediaEngineSettingsSubscription$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.mediaEngineSettingsSubscription;
    }

    public static final /* synthetic */ StoreMediaSettings access$getMediaSettingsStore$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.mediaSettingsStore;
    }

    public static final /* synthetic */ PublishSubject access$getOnKrispStatusSubject$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.onKrispStatusSubject;
    }

    public static final /* synthetic */ VideoInputDeviceDescription access$getSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.selectedVideoInputDevice;
    }

    public static final /* synthetic */ void access$getVideoInputDevicesNative(StoreMediaEngine storeMediaEngine, Function1 function1) {
        storeMediaEngine.getVideoInputDevicesNative(function1);
    }

    public static final /* synthetic */ void access$handleNativeEngineInitialized(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.handleNativeEngineInitialized();
    }

    public static final /* synthetic */ void access$handleNewConnection(StoreMediaEngine storeMediaEngine, MediaEngineConnection mediaEngineConnection) {
        storeMediaEngine.handleNewConnection(mediaEngineConnection);
    }

    public static final /* synthetic */ void access$handleVideoInputDevices(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr, String str, Function1 function1) {
        storeMediaEngine.handleVideoInputDevices(videoInputDeviceDescriptionArr, str, function1);
    }

    public static final /* synthetic */ void access$handleVoiceConfigChanged(StoreMediaEngine storeMediaEngine, StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
        storeMediaEngine.handleVoiceConfigChanged(voiceConfiguration);
    }

    public static final /* synthetic */ String access$pickDefaultDeviceGUID(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        return storeMediaEngine.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr);
    }

    public static final /* synthetic */ void access$restartLocalMicrophone(StoreMediaEngine storeMediaEngine) {
        storeMediaEngine.restartLocalMicrophone();
    }

    public static final /* synthetic */ void access$setHasTimedOutAwaitingDevice$p(StoreMediaEngine storeMediaEngine, boolean z2) {
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
    }

    public static final /* synthetic */ void access$setMediaEngine$p(StoreMediaEngine storeMediaEngine, MediaEngine mediaEngine) {
        storeMediaEngine.mediaEngine = mediaEngine;
    }

    public static final /* synthetic */ void access$setMediaEngineSettingsSubscription$p(StoreMediaEngine storeMediaEngine, Subscription subscription) {
        storeMediaEngine.mediaEngineSettingsSubscription = subscription;
    }

    public static final /* synthetic */ void access$setSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription videoInputDeviceDescription) {
        storeMediaEngine.selectedVideoInputDevice = videoInputDeviceDescription;
    }

    private final synchronized void disableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(null);
    }

    private final synchronized void enableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.l(new AnonymousClass1(this.localVoiceStatusSubject));
    }

    private final synchronized void getVideoInputDevicesNative(Function1<? super VideoInputDeviceDescription[], Unit> callback) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.j(new AnonymousClass1(callback));
    }

    private final synchronized void handleNativeEngineInitialized() {
        this.hasNativeEngineEverInitialized = true;
        Persister<Boolean> persister = this.hasNativeEngineEverInitializedCache;
        Boolean bool = Boolean.TRUE;
        persister.set(bool, true);
        this.isNativeEngineInitializedSubject.k.onNext(bool);
    }

    private final synchronized void handleNewConnection(MediaEngineConnection connection) {
        setupMediaEngineSettingsSubscription();
        connection.l(new AnonymousClass1());
        getVideoInputDevicesNative(new AnonymousClass2());
    }

    private final synchronized void handleVideoInputDevices(VideoInputDeviceDescription[] videoInputDevices, String deviceGUID, Function1<? super String, Unit> onSelected) {
        String guid;
        int length = videoInputDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (m.areEqual(videoInputDevices[i].getGuid(), deviceGUID)) {
                break;
            } else {
                i++;
            }
        }
        boolean z2 = i >= 0;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.f(-1);
        MediaEngine mediaEngine2 = this.mediaEngine;
        if (mediaEngine2 == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine2.f(i);
        MediaEngine mediaEngine3 = this.mediaEngine;
        if (mediaEngine3 == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        for (MediaEngineConnection mediaEngineConnection : mediaEngine3.getConnections()) {
            if (mediaEngineConnection.getType().ordinal() == 0) {
                mediaEngineConnection.j(z2);
            }
        }
        if (onSelected != null) {
            if (!z2) {
                deviceGUID = null;
            }
            onSelected.invoke(deviceGUID);
        }
        updateSelectedVideoInputDevice(z2 ? videoInputDevices[i] : null);
        this.videoInputDevices = videoInputDevices;
        this.videoInputDevicesSubject.onNext(j.asList(videoInputDevices));
        VideoInputDeviceDescription videoInputDeviceDescription = this.selectedVideoInputDevice;
        if (videoInputDeviceDescription != null) {
            if (videoInputDeviceDescription == null || (guid = videoInputDeviceDescription.getGuid()) == null) {
                guid = "";
            }
            this.preferredVideoInputDeviceGUID = guid;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleVideoInputDevices$default(StoreMediaEngine storeMediaEngine, VideoInputDeviceDescription[] videoInputDeviceDescriptionArr, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        storeMediaEngine.handleVideoInputDevices(videoInputDeviceDescriptionArr, str, function1);
    }

    @StoreThread
    private final synchronized void handleVoiceConfigChanged(StoreMediaSettings.VoiceConfiguration voiceConfig) {
        if (voiceConfig != null) {
            MediaEngine mediaEngine = this.mediaEngine;
            if (mediaEngine == null) {
                m.throwUninitializedPropertyAccessException("mediaEngine");
            }
            mediaEngine.d(voiceConfig.toMediaEngineVoiceConfig());
        }
    }

    private final String pickDefaultDeviceGUID(VideoInputDeviceDescription[] videoInputDeviceDescriptionArr) {
        boolean z2;
        VideoInputDeviceDescription videoInputDeviceDescription;
        int length = videoInputDeviceDescriptionArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z2 = false;
                break;
            }
            if (m.areEqual(videoInputDeviceDescriptionArr[i].getGuid(), this.preferredVideoInputDeviceGUID)) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z2) {
            return this.preferredVideoInputDeviceGUID;
        }
        int length2 = videoInputDeviceDescriptionArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                videoInputDeviceDescription = null;
                break;
            }
            videoInputDeviceDescription = videoInputDeviceDescriptionArr[i2];
            if (videoInputDeviceDescription.getFacing() == VideoInputDeviceFacing.Front) {
                break;
            }
            i2++;
        }
        if (videoInputDeviceDescription == null) {
            videoInputDeviceDescription = (VideoInputDeviceDescription) d0.t.k.firstOrNull(videoInputDeviceDescriptionArr);
        }
        if (videoInputDeviceDescription != null) {
            return videoInputDeviceDescription.getGuid();
        }
        return null;
    }

    private final synchronized void restartLocalMicrophone() {
        enableLocalVoiceStatusListening();
        disableLocalVoiceStatusListening();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void selectDefaultVideoDevice$default(StoreMediaEngine storeMediaEngine, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        storeMediaEngine.selectDefaultVideoDevice(function1);
    }

    private final synchronized void setupMediaEngineSettingsSubscription() {
        Subscription subscription = this.mediaEngineSettingsSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = this.mediaSettingsStore.getVoiceConfig();
        Class<?> cls = getClass();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        ObservableExtensionsKt.appSubscribe$default(voiceConfig, cls, (Context) null, new AnonymousClass3(), AnonymousClass2.INSTANCE, (Function0) null, (Function0) null, anonymousClass1, 50, (Object) null);
    }

    private final synchronized void updateSelectedVideoInputDevice(VideoInputDeviceDescription selectedVideoInputDevice) {
        this.selectedVideoInputDevice = selectedVideoInputDevice;
        this.selectedVideoInputDeviceSubject.onNext(selectedVideoInputDevice);
        this.storeStream.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object awaitVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objB = anonymousClass1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        boolean z2 = true;
        if (i2 == 0) {
            l.throwOnFailure(objB);
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this, null);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objB = h.b(MAX_WAIT_FOR_DEVICES_MS, storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1, anonymousClass1);
            if (objB == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            l.throwOnFailure(objB);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objB;
        if (!storeMediaEngine.hasTimedOutAwaitingDevice && videoInputDeviceDescriptionArr != null) {
            z2 = false;
        }
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
        return videoInputDeviceDescriptionArr != null ? videoInputDeviceDescriptionArr : new VideoInputDeviceDescription[0];
    }

    public final synchronized void cycleVideoInputDevice() {
        int iIndexOf = d0.t.k.indexOf(this.videoInputDevices, this.selectedVideoInputDevice);
        if (iIndexOf < 0) {
            return;
        }
        selectVideoInputDevice(this.videoInputDevices[iIndexOf == d0.t.k.getLastIndex(this.videoInputDevices) ? 0 : iIndexOf + 1].getGuid());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDefaultVideoDeviceGUID(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitVideoInputDevicesNativeAsync = anonymousClass1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(anonymousClass1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        return storeMediaEngine.pickDefaultDeviceGUID((VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync);
    }

    public final Observable<Boolean> getIsNativeEngineInitialized() {
        return this.isNativeEngineInitializedSubject;
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final Observable<MediaEngine.LocalVoiceStatus> getLocalVoiceStatus() {
        return this.localVoiceStatus;
    }

    public final MediaEngine getMediaEngine() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public final Observable<MediaEngine.OpenSLESConfig> getOpenSLESConfig() {
        return this.openSLESConfigSubject;
    }

    public final synchronized void getRankedRtcRegions(List<ModelRtcLatencyRegion> regionsWithIps, Function1<? super List<String>, Unit> callback) {
        m.checkNotNullParameter(regionsWithIps, "regionsWithIps");
        m.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(regionsWithIps, 10));
        for (ModelRtcLatencyRegion modelRtcLatencyRegion : regionsWithIps) {
            String region = modelRtcLatencyRegion.getRegion();
            Object[] array = modelRtcLatencyRegion.getIps().toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            arrayList.add(new RtcRegion(region, (String[]) array));
        }
        Object[] array2 = arrayList.toArray(new RtcRegion[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        RtcRegion[] rtcRegionArr = (RtcRegion[]) array2;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.b(rtcRegionArr, new AnonymousClass1(callback));
    }

    public final Observable<VideoInputDeviceDescription> getSelectedVideoInputDevice() {
        Observable<VideoInputDeviceDescription> observableR = this.selectedVideoInputDeviceSubject.r();
        m.checkNotNullExpressionValue(observableR, "selectedVideoInputDevice…  .distinctUntilChanged()");
        return observableR;
    }

    /* renamed from: getSelectedVideoInputDeviceBlocking, reason: from getter */
    public final VideoInputDeviceDescription getSelectedVideoInputDevice() {
        return this.selectedVideoInputDevice;
    }

    public final Observable<List<VideoInputDeviceDescription>> getVideoInputDevices() {
        Observable<List<VideoInputDeviceDescription>> observableR = this.videoInputDevicesSubject.r();
        m.checkNotNullExpressionValue(observableR, "videoInputDevicesSubject…  .distinctUntilChanged()");
        return observableR;
    }

    public final Object getVideoInputDevicesNativeAsync(Continuation<? super VideoInputDeviceDescription[]> continuation) {
        s.a.l lVar = new s.a.l(b.intercepted(continuation), 1);
        lVar.A();
        access$getVideoInputDevicesNative(this, new StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(lVar));
        Object objU = lVar.u();
        if (objU == c.getCOROUTINE_SUSPENDED()) {
            g.probeCoroutineSuspended(continuation);
        }
        return objU;
    }

    public final synchronized Discord getVoiceEngineNative() {
        MediaEngine mediaEngine;
        mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine.i();
    }

    public final synchronized void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.userId = payload.getMe().getId();
    }

    public final void handleMicrophonePermissionGranted() {
        Observable<Boolean> observableZ = this.isNativeEngineInitializedSubject.Z(1);
        m.checkNotNullExpressionValue(observableZ, "isNativeEngineInitializedSubject\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final synchronized void handleVoiceChannelSelected(long channelId) {
        Long l = this.previousVoiceChannelId;
        if (l != null && (l == null || l.longValue() != 0)) {
            if (channelId == 0) {
                getVideoInputDevicesNative(new AnonymousClass1());
            }
        }
        this.previousVoiceChannelId = Long.valueOf(channelId);
    }

    public final synchronized boolean hasNativeEngineEverInitialized() {
        return this.hasNativeEngineEverInitialized;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.preferredVideoInputDeviceGUID = this.preferredVideoInputDeviceGuidCache.get();
        this.hasNativeEngineEverInitialized = this.hasNativeEngineEverInitializedCache.get().booleanValue();
        SharedPreferences prefsSessionDurable = getPrefsSessionDurable();
        MediaEngine.OpenSLESConfig openSLESConfig = DEFAULT_OPENSLES_CONFIG;
        String string = prefsSessionDurable.getString("OPEN_SLES", openSLESConfig.name());
        if (string == null) {
            string = openSLESConfig.name();
        }
        m.checkNotNullExpressionValue(string, "prefsSessionDurable\n    …AULT_OPENSLES_CONFIG.name");
        MediaEngine.OpenSLESConfig openSLESConfigValueOf = MediaEngine.OpenSLESConfig.valueOf(string);
        this.openSLESConfigSubject.k.onNext(openSLESConfigValueOf);
        StoreMediaEngine$init$echoCancellationCallback$1 storeMediaEngine$init$echoCancellationCallback$1 = new StoreMediaEngine$init$echoCancellationCallback$1(this);
        EngineListener engineListener = new EngineListener();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        m.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        AppLog appLog = AppLog.g;
        g.a aVar = b.a.q.k0.g.c;
        b.a.q.k0.g gVar = b.a.q.k0.g.f264b;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(engineListener, "listener");
        m.checkNotNullParameter(executorServiceNewSingleThreadExecutor, "singleThreadExecutorService");
        m.checkNotNullParameter(openSLESConfigValueOf, "openSLESConfig");
        m.checkNotNullParameter(appLog, "logger");
        m.checkNotNullParameter(gVar, "echoCancellation");
        m.checkNotNullParameter(storeMediaEngine$init$echoCancellationCallback$1, "echoCancellationCallback");
        this.mediaEngine = new b.a.q.m0.c.k(context, engineListener, new b.a.q.c(executorServiceNewSingleThreadExecutor, false), openSLESConfigValueOf, appLog, gVar, storeMediaEngine$init$echoCancellationCallback$1, null, null, 384);
        Observable<R> observableG = this.storeStream.getExperiments().observeUserExperiment("2021-05_opensl_default_enable_android", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        m.checkNotNullExpressionValue(observableZ, "storeStream.experiments.…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableZ), StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final Observable<KrispOveruseDetector.Status> onKrispStatusEvent() {
        PublishSubject<KrispOveruseDetector.Status> publishSubject = this.onKrispStatusSubject;
        m.checkNotNullExpressionValue(publishSubject, "onKrispStatusSubject");
        return publishSubject;
    }

    public final void selectDefaultVideoDevice(Function1<? super String, Unit> onSelected) {
        x0 x0Var = x0.j;
        CoroutineDispatcher coroutineDispatcher = k0.a;
        f.H0(x0Var, n.f3830b.H(), null, new AnonymousClass1(onSelected, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectDefaultVideoDeviceAsync(Continuation<? super String> continuation) {
        AnonymousClass1 anonymousClass1;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objAwaitVideoInputDevicesNativeAsync = anonymousClass1.result;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(anonymousClass1);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) anonymousClass1.L$0;
            l.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        VideoInputDeviceDescription[] videoInputDeviceDescriptionArr = (VideoInputDeviceDescription[]) objAwaitVideoInputDevicesNativeAsync;
        String strPickDefaultDeviceGUID = storeMediaEngine.pickDefaultDeviceGUID(videoInputDeviceDescriptionArr);
        handleVideoInputDevices$default(storeMediaEngine, videoInputDeviceDescriptionArr, strPickDefaultDeviceGUID, null, 4, null);
        return strPickDefaultDeviceGUID;
    }

    public final void selectVideoInputDevice(String deviceGUID) {
        getVideoInputDevicesNative(new AnonymousClass1(deviceGUID));
    }

    public final synchronized void setAudioInputEnabled(boolean audioInputEnabled) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.k(audioInputEnabled);
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized void setOpenSLESConfig(MediaEngine.OpenSLESConfig openSLESConfig) {
        m.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        this.openSLESConfigSubject.k.onNext(openSLESConfig);
        getPrefsSessionDurable().edit().putString("OPEN_SLES", openSLESConfig.name()).commit();
    }

    public final synchronized void setPttActive(boolean active) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            m.throwUninitializedPropertyAccessException("mediaEngine");
        }
        Iterator<T> it = mediaEngine.getConnections().iterator();
        while (it.hasNext()) {
            ((MediaEngineConnection) it.next()).q(active);
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.pttActiveSubject;
        serializedSubject.k.onNext(Boolean.valueOf(active));
    }
}
