package com.discord.stores;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.DeviceDescription5;
import co.discord.media_engine.RtcRegion;
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
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.error.Error;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.hammerandchisel.libdiscord.Discord;
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
import p007b.p008a.p041q.MediaEngineExecutorService;
import p007b.p008a.p041q.ThermalDetector;
import p007b.p008a.p041q.p042k0.EchoCancellation;
import p007b.p008a.p041q.p044m0.p045c.C1233k;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Arrays;
import p507d0.p580t._ArraysJvm;
import p507d0.p580t._Collections;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.ContinuationImpl3;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p643a.OnSubscribeRefCount3;
import p637j0.p642l.p643a.OperatorPublish;
import p637j0.p642l.p643a.OperatorPublish2;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.SerializedSubject;
import p659s.p660a.Builders5;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.CoroutineScope2;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

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
    private final ListenerCollection2<Listener> listenerSubject;
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
    private DeviceDescription4 selectedVideoInputDevice;
    private final BehaviorSubject<DeviceDescription4> selectedVideoInputDeviceSubject;
    private final StoreStream storeStream;
    private long userId;
    private DeviceDescription4[] videoInputDevices;
    private final BehaviorSubject<List<DeviceDescription4>> videoInputDevicesSubject;
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
    public final class EngineListener implements MediaEngine.InterfaceC5642c {
        private final LowMemoryDetector lowMemoryDetector = new LowMemoryDetector();
        private long debugPrintableId = -1;

        public EngineListener() {
        }

        private final Context getContext() {
            return ApplicationProvider.INSTANCE.get();
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onConnected() {
            StoreMediaEngine.access$getListenerSubject$p(StoreMediaEngine.this).notify(StoreMediaEngine$EngineListener$onConnected$1.INSTANCE);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onConnecting() {
            StoreMediaEngine.access$getListenerSubject$p(StoreMediaEngine.this).notify(StoreMediaEngine$EngineListener$onConnecting$1.INSTANCE);
        }

        public void onDestroy() {
            getContext().unregisterComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                ThermalDetector thermalDetector = ThermalDetector.f1633n;
                synchronized (thermalDetector) {
                    if (ThermalDetector.f1630k) {
                        AnimatableValueParser.m501b1("ThermalDetector", "unregister");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).removeThermalStatusListener(thermalDetector);
                        ThermalDetector.f1630k = false;
                        ThermalDetector.f1631l = false;
                        if (ThermalDetector.f1632m) {
                            ((Handler) ThermalDetector.f1629j.getValue()).removeCallbacks(thermalDetector);
                            ThermalDetector.f1632m = false;
                        }
                    }
                }
                SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().remove(this.debugPrintableId);
                this.debugPrintableId = -1L;
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onNativeEngineInitialized() {
            getContext().registerComponentCallbacks(this.lowMemoryDetector);
            if (Build.VERSION.SDK_INT >= 29) {
                ThermalDetector thermalDetector = ThermalDetector.f1633n;
                synchronized (thermalDetector) {
                    if (!ThermalDetector.f1630k) {
                        AnimatableValueParser.m501b1("ThermalDetector", "register");
                        Object systemService = ApplicationProvider.INSTANCE.get().getSystemService("power");
                        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        ((PowerManager) systemService).addThermalStatusListener(thermalDetector);
                        ThermalDetector.f1630k = true;
                    }
                }
                this.debugPrintableId = SystemLogUtils.INSTANCE.getDebugPrintables$app_productionGoogleRelease().add(thermalDetector, "ThermalDetector");
            }
            StoreMediaEngine.access$handleNativeEngineInitialized(StoreMediaEngine.this);
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngine.InterfaceC5642c
        public void onNewConnection(MediaEngineConnection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
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
    @DebugMetadata(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {264}, m10087m = "awaitVideoInputDevicesNativeAsync")
    /* renamed from: com.discord.stores.StoreMediaEngine$awaitVideoInputDevicesNativeAsync$1 */
    public static final class C61641 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61641(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.awaitVideoInputDevicesNativeAsync(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$enableLocalVoiceStatusListening$1 */
    public static final /* synthetic */ class C61651 extends FunctionReferenceImpl implements Function1<MediaEngine.LocalVoiceStatus, Unit> {
        public C61651(SerializedSubject serializedSubject) {
            super(1, serializedSubject, SerializedSubject.class, "onNext", "onNext(Ljava/lang/Object;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            invoke2(localVoiceStatus);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MediaEngine.LocalVoiceStatus localVoiceStatus) {
            ((SerializedSubject) this.receiver).f27653k.onNext(localVoiceStatus);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @DebugMetadata(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {209}, m10087m = "getDefaultVideoDeviceGUID")
    /* renamed from: com.discord.stores.StoreMediaEngine$getDefaultVideoDeviceGUID$1 */
    public static final class C61661 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61661(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.getDefaultVideoDeviceGUID(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$getRankedRtcRegions$1 */
    public static final class C61671 extends Lambda implements Function1<String[], Unit> {
        public final /* synthetic */ Function1 $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61671(Function1 function1) {
            super(1);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String[] strArr) {
            invoke2(strArr);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String[] strArr) {
            Intrinsics3.checkNotNullParameter(strArr, "it");
            this.$callback.invoke(_Arrays.toList(strArr));
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$getVideoInputDevicesNative$1 */
    public static final /* synthetic */ class C61681 extends FunctionReferenceImpl implements Function1<DeviceDescription4[], Unit> {
        public C61681(Function1 function1) {
            super(1, function1, Function1.class, "invoke", "invoke(Ljava/lang/Object;)Ljava/lang/Object;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "p1");
            ((Function1) this.receiver).invoke(deviceDescription4Arr);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleMicrophonePermissionGranted$1 */
    public static final class C61691 extends Lambda implements Function1<Boolean, Unit> {
        public C61691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            Intrinsics3.checkNotNullExpressionValue(bool, "isInitialized");
            if (bool.booleanValue()) {
                StoreMediaEngine.access$restartLocalMicrophone(StoreMediaEngine.this);
            }
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$1 */
    public static final class C61701 extends MediaEngineConnection.AbstractC5645a {
        public C61701() {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onDestroy(MediaEngineConnection connection) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            if (_Collections.minus(StoreMediaEngine.this.getMediaEngine().getConnections(), connection).isEmpty()) {
                StoreMediaEngine.access$getMediaSettingsStore$p(StoreMediaEngine.this).revertTemporaryDisableKrisp();
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onKrispStatus(MediaEngineConnection connection, KrispOveruseDetector.Status status) {
            Intrinsics3.checkNotNullParameter(connection, "connection");
            Intrinsics3.checkNotNullParameter(status, "status");
            AppLog.m8358i("onKrispStatus(" + status + ')');
            StoreMediaEngine.access$getOnKrispStatusSubject$p(StoreMediaEngine.this).f27650k.onNext(status);
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
    /* renamed from: com.discord.stores.StoreMediaEngine$handleNewConnection$2 */
    public static final class C61712 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public C61712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "devices");
            StoreMediaEngine storeMediaEngine = StoreMediaEngine.this;
            DeviceDescription4 deviceDescription4Access$getSelectedVideoInputDevice$p = StoreMediaEngine.access$getSelectedVideoInputDevice$p(storeMediaEngine);
            StoreMediaEngine.handleVideoInputDevices$default(storeMediaEngine, deviceDescription4Arr, deviceDescription4Access$getSelectedVideoInputDevice$p != null ? deviceDescription4Access$getSelectedVideoInputDevice$p.getGuid() : null, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$handleVoiceChannelSelected$1 */
    public static final class C61721 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public C61721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "it");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, deviceDescription4Arr, null, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$init$1 */
    public static final class C61731 extends Lambda implements Function1<Experiment, Unit> {
        public C61731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Experiment experiment) {
            invoke2(experiment);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Experiment experiment) {
            int bucket = experiment.getBucket();
            StoreMediaEngine.this.getMediaEngine().mo328h((bucket == 1 || bucket == 3) ? MediaEngine.OpenSLUsageMode.EXCLUDE_LIST : MediaEngine.OpenSLUsageMode.ALLOW_LIST);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @DebugMetadata(m10084c = "com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1", m10085f = "StoreMediaEngine.kt", m10086l = {Opcodes.ANEWARRAY}, m10087m = "invokeSuspend")
    /* renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDevice$1 */
    public static final class C61751 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1 $onSelected;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61751(Function1 function1, Continuation continuation) {
            super(2, continuation);
            this.$onSelected = function1;
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return StoreMediaEngine.this.new C61751(this.$onSelected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C61751) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
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
                Result3.throwOnFailure(obj);
            }
            DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) obj;
            StoreMediaEngine.access$handleVideoInputDevices(StoreMediaEngine.this, deviceDescription4Arr, StoreMediaEngine.access$pickDefaultDeviceGUID(StoreMediaEngine.this, deviceDescription4Arr), this.$onSelected);
            return Unit.f27425a;
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    @DebugMetadata(m10084c = "com.discord.stores.StoreMediaEngine", m10085f = "StoreMediaEngine.kt", m10086l = {202}, m10087m = "selectDefaultVideoDeviceAsync")
    /* renamed from: com.discord.stores.StoreMediaEngine$selectDefaultVideoDeviceAsync$1 */
    public static final class C61761 extends ContinuationImpl3 {
        public Object L$0;
        public int label;
        public /* synthetic */ Object result;

        public C61761(Continuation continuation) {
            super(continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StoreMediaEngine.this.selectDefaultVideoDeviceAsync(this);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$selectVideoInputDevice$1 */
    public static final class C61771 extends Lambda implements Function1<DeviceDescription4[], Unit> {
        public final /* synthetic */ String $deviceGUID;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61771(String str) {
            super(1);
            this.$deviceGUID = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(DeviceDescription4[] deviceDescription4Arr) {
            invoke2(deviceDescription4Arr);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(DeviceDescription4[] deviceDescription4Arr) {
            Intrinsics3.checkNotNullParameter(deviceDescription4Arr, "devices");
            StoreMediaEngine.handleVideoInputDevices$default(StoreMediaEngine.this, deviceDescription4Arr, this.$deviceGUID, null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1 */
    public static final class C61781 extends Lambda implements Function1<StoreMediaSettings.VoiceConfiguration, Unit> {

        /* compiled from: StoreMediaEngine.kt */
        /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ StoreMediaSettings.VoiceConfiguration $voiceConfig;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
                super(0);
                this.$voiceConfig = voiceConfiguration;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreMediaEngine.access$handleVoiceConfigChanged(StoreMediaEngine.this, this.$voiceConfig);
            }
        }

        public C61781() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            invoke2(voiceConfiguration);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
            Intrinsics3.checkNotNullParameter(voiceConfiguration, "voiceConfig");
            StoreMediaEngine.access$getDispatcher$p(StoreMediaEngine.this).schedule(new AnonymousClass1(voiceConfiguration));
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$2 */
    public static final class C61792 extends Lambda implements Function1<Error, Unit> {
        public static final C61792 INSTANCE = new C61792();

        public C61792() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            Logger.e$default(AppLog.f14950g, "handleVoiceConfigChanged", error.getThrowable(), null, 4, null);
        }
    }

    /* compiled from: StoreMediaEngine.kt */
    /* renamed from: com.discord.stores.StoreMediaEngine$setupMediaEngineSettingsSubscription$3 */
    public static final class C61803 extends Lambda implements Function1<Subscription, Unit> {
        public C61803() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreMediaEngine.access$setMediaEngineSettingsSubscription$p(StoreMediaEngine.this, subscription);
        }
    }

    public StoreMediaEngine(StoreMediaSettings storeMediaSettings, StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeMediaSettings, "mediaSettingsStore");
        Intrinsics3.checkNotNullParameter(storeStream, "storeStream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.mediaSettingsStore = storeMediaSettings;
        this.storeStream = storeStream;
        this.dispatcher = dispatcher;
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        SerializedSubject<MediaEngine.LocalVoiceStatus, MediaEngine.LocalVoiceStatus> serializedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(LOCAL_VOICE_STATUS_DEFAULT));
        this.localVoiceStatusSubject = serializedSubject;
        Boolean bool = Boolean.FALSE;
        this.pttActiveSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.preferredVideoInputDeviceGUID = "";
        this.preferredVideoInputDeviceGuidCache = new Persister<>("PREFERRED_VIDEO_INPUT_DEVICE_GUID", this.preferredVideoInputDeviceGUID);
        this.selectedVideoInputDeviceSubject = BehaviorSubject.m11130l0(this.selectedVideoInputDevice);
        DeviceDescription4[] deviceDescription4Arr = new DeviceDescription4[0];
        this.videoInputDevices = deviceDescription4Arr;
        this.videoInputDevicesSubject = BehaviorSubject.m11130l0(_ArraysJvm.asList(deviceDescription4Arr));
        this.openSLESConfigSubject = new SerializedSubject<>(BehaviorSubject.m11129k0());
        this.isNativeEngineInitializedSubject = new SerializedSubject<>(BehaviorSubject.m11130l0(bool));
        this.userId = -1L;
        this.hasNativeEngineEverInitializedCache = new Persister<>("CACHE_KEY_NATIVE_ENGINE_EVER_INITIALIZED", Boolean.valueOf(this.hasNativeEngineEverInitialized));
        this.onKrispStatusSubject = PublishSubject.m11133k0();
        Observable observableM11117w = ObservableExtensionsKt.computationLatest(serializedSubject).m11112r().m11116v(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$1(this))).m11117w(new StoreMediaEngine$sam$rx_functions_Action0$0(new StoreMediaEngine$localVoiceStatus$2(this)));
        AtomicReference atomicReference = new AtomicReference();
        Observable<MediaEngine.LocalVoiceStatus> observableM11074h0 = Observable.m11074h0(new OnSubscribeRefCount3(new OperatorPublish2(new OperatorPublish(atomicReference), observableM11117w, atomicReference)));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "localVoiceStatusSubject\n…ening)\n          .share()");
        this.localVoiceStatus = observableM11074h0;
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

    public static final /* synthetic */ ListenerCollection2 access$getListenerSubject$p(StoreMediaEngine storeMediaEngine) {
        return storeMediaEngine.listenerSubject;
    }

    public static final /* synthetic */ MediaEngine access$getMediaEngine$p(StoreMediaEngine storeMediaEngine) {
        MediaEngine mediaEngine = storeMediaEngine.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
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

    public static final /* synthetic */ DeviceDescription4 access$getSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine) {
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

    public static final /* synthetic */ void access$handleVideoInputDevices(StoreMediaEngine storeMediaEngine, DeviceDescription4[] deviceDescription4Arr, String str, Function1 function1) {
        storeMediaEngine.handleVideoInputDevices(deviceDescription4Arr, str, function1);
    }

    public static final /* synthetic */ void access$handleVoiceConfigChanged(StoreMediaEngine storeMediaEngine, StoreMediaSettings.VoiceConfiguration voiceConfiguration) {
        storeMediaEngine.handleVoiceConfigChanged(voiceConfiguration);
    }

    public static final /* synthetic */ String access$pickDefaultDeviceGUID(StoreMediaEngine storeMediaEngine, DeviceDescription4[] deviceDescription4Arr) {
        return storeMediaEngine.pickDefaultDeviceGUID(deviceDescription4Arr);
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

    public static final /* synthetic */ void access$setSelectedVideoInputDevice$p(StoreMediaEngine storeMediaEngine, DeviceDescription4 deviceDescription4) {
        storeMediaEngine.selectedVideoInputDevice = deviceDescription4;
    }

    private final synchronized void disableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo332l(null);
    }

    private final synchronized void enableLocalVoiceStatusListening() {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo332l(new C61651(this.localVoiceStatusSubject));
    }

    private final synchronized void getVideoInputDevicesNative(Function1<? super DeviceDescription4[], Unit> callback) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo330j(new C61681(callback));
    }

    private final synchronized void handleNativeEngineInitialized() {
        this.hasNativeEngineEverInitialized = true;
        Persister<Boolean> persister = this.hasNativeEngineEverInitializedCache;
        Boolean bool = Boolean.TRUE;
        persister.set(bool, true);
        this.isNativeEngineInitializedSubject.f27653k.onNext(bool);
    }

    private final synchronized void handleNewConnection(MediaEngineConnection connection) {
        setupMediaEngineSettingsSubscription();
        connection.mo306l(new C61701());
        getVideoInputDevicesNative(new C61712());
    }

    private final synchronized void handleVideoInputDevices(DeviceDescription4[] videoInputDevices, String deviceGUID, Function1<? super String, Unit> onSelected) {
        String guid;
        int length = videoInputDevices.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (Intrinsics3.areEqual(videoInputDevices[i].getGuid(), deviceGUID)) {
                break;
            } else {
                i++;
            }
        }
        boolean z2 = i >= 0;
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo326f(-1);
        MediaEngine mediaEngine2 = this.mediaEngine;
        if (mediaEngine2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine2.mo326f(i);
        MediaEngine mediaEngine3 = this.mediaEngine;
        if (mediaEngine3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        for (MediaEngineConnection mediaEngineConnection : mediaEngine3.getConnections()) {
            if (mediaEngineConnection.getType().ordinal() == 0) {
                mediaEngineConnection.mo304j(z2);
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
        this.videoInputDevicesSubject.onNext(_ArraysJvm.asList(videoInputDevices));
        DeviceDescription4 deviceDescription4 = this.selectedVideoInputDevice;
        if (deviceDescription4 != null) {
            if (deviceDescription4 == null || (guid = deviceDescription4.getGuid()) == null) {
                guid = "";
            }
            this.preferredVideoInputDeviceGUID = guid;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void handleVideoInputDevices$default(StoreMediaEngine storeMediaEngine, DeviceDescription4[] deviceDescription4Arr, String str, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        storeMediaEngine.handleVideoInputDevices(deviceDescription4Arr, str, function1);
    }

    @Store3
    private final synchronized void handleVoiceConfigChanged(StoreMediaSettings.VoiceConfiguration voiceConfig) {
        if (voiceConfig != null) {
            MediaEngine mediaEngine = this.mediaEngine;
            if (mediaEngine == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
            }
            mediaEngine.mo324d(voiceConfig.toMediaEngineVoiceConfig());
        }
    }

    private final String pickDefaultDeviceGUID(DeviceDescription4[] deviceDescription4Arr) {
        boolean z2;
        DeviceDescription4 deviceDescription4;
        int length = deviceDescription4Arr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z2 = false;
                break;
            }
            if (Intrinsics3.areEqual(deviceDescription4Arr[i].getGuid(), this.preferredVideoInputDeviceGUID)) {
                z2 = true;
                break;
            }
            i++;
        }
        if (z2) {
            return this.preferredVideoInputDeviceGUID;
        }
        int length2 = deviceDescription4Arr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                deviceDescription4 = null;
                break;
            }
            deviceDescription4 = deviceDescription4Arr[i2];
            if (deviceDescription4.getFacing() == DeviceDescription5.Front) {
                break;
            }
            i2++;
        }
        if (deviceDescription4 == null) {
            deviceDescription4 = (DeviceDescription4) _Arrays.firstOrNull(deviceDescription4Arr);
        }
        if (deviceDescription4 != null) {
            return deviceDescription4.getGuid();
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
        C61781 c61781 = new C61781();
        ObservableExtensionsKt.appSubscribe$default(voiceConfig, cls, (Context) null, new C61803(), C61792.INSTANCE, (Function0) null, (Function0) null, c61781, 50, (Object) null);
    }

    private final synchronized void updateSelectedVideoInputDevice(DeviceDescription4 selectedVideoInputDevice) {
        this.selectedVideoInputDevice = selectedVideoInputDevice;
        this.selectedVideoInputDeviceSubject.onNext(selectedVideoInputDevice);
        this.storeStream.handleVideoInputDeviceSelected(selectedVideoInputDevice);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object awaitVideoInputDevicesNativeAsync(Continuation<? super DeviceDescription4[]> continuation) {
        C61641 c61641;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61641) {
            c61641 = (C61641) continuation;
            int i = c61641.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61641.label = i - Integer.MIN_VALUE;
            } else {
                c61641 = new C61641(continuation);
            }
        }
        Object objM11283b = c61641.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c61641.label;
        boolean z2 = true;
        if (i2 == 0) {
            Result3.throwOnFailure(objM11283b);
            StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1 = new StoreMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1(this, null);
            c61641.L$0 = this;
            c61641.label = 1;
            objM11283b = Builders5.m11283b(MAX_WAIT_FOR_DEVICES_MS, storeMediaEngine$awaitVideoInputDevicesNativeAsync$devices$1, c61641);
            if (objM11283b == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61641.L$0;
            Result3.throwOnFailure(objM11283b);
        }
        DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) objM11283b;
        if (!storeMediaEngine.hasTimedOutAwaitingDevice && deviceDescription4Arr != null) {
            z2 = false;
        }
        storeMediaEngine.hasTimedOutAwaitingDevice = z2;
        return deviceDescription4Arr != null ? deviceDescription4Arr : new DeviceDescription4[0];
    }

    public final synchronized void cycleVideoInputDevice() {
        int iIndexOf = _Arrays.indexOf(this.videoInputDevices, this.selectedVideoInputDevice);
        if (iIndexOf < 0) {
            return;
        }
        selectVideoInputDevice(this.videoInputDevices[iIndexOf == _Arrays.getLastIndex(this.videoInputDevices) ? 0 : iIndexOf + 1].getGuid());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getDefaultVideoDeviceGUID(Continuation<? super String> continuation) {
        C61661 c61661;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61661) {
            c61661 = (C61661) continuation;
            int i = c61661.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61661.label = i - Integer.MIN_VALUE;
            } else {
                c61661 = new C61661(continuation);
            }
        }
        Object objAwaitVideoInputDevicesNativeAsync = c61661.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c61661.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            c61661.L$0 = this;
            c61661.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(c61661);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61661.L$0;
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        return storeMediaEngine.pickDefaultDeviceGUID((DeviceDescription4[]) objAwaitVideoInputDevicesNativeAsync);
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
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine;
    }

    public final Observable<MediaEngine.OpenSLESConfig> getOpenSLESConfig() {
        return this.openSLESConfigSubject;
    }

    public final synchronized void getRankedRtcRegions(List<ModelRtcLatencyRegion> regionsWithIps, Function1<? super List<String>, Unit> callback) {
        Intrinsics3.checkNotNullParameter(regionsWithIps, "regionsWithIps");
        Intrinsics3.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(regionsWithIps, 10));
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
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo322b(rtcRegionArr, new C61671(callback));
    }

    public final Observable<DeviceDescription4> getSelectedVideoInputDevice() {
        Observable<DeviceDescription4> observableM11112r = this.selectedVideoInputDeviceSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "selectedVideoInputDevice…  .distinctUntilChanged()");
        return observableM11112r;
    }

    /* renamed from: getSelectedVideoInputDeviceBlocking, reason: from getter */
    public final DeviceDescription4 getSelectedVideoInputDevice() {
        return this.selectedVideoInputDevice;
    }

    public final Observable<List<DeviceDescription4>> getVideoInputDevices() {
        Observable<List<DeviceDescription4>> observableM11112r = this.videoInputDevicesSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "videoInputDevicesSubject…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Object getVideoInputDevicesNativeAsync(Continuation<? super DeviceDescription4[]> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        access$getVideoInputDevicesNative(this, new StoreMediaEngine$getVideoInputDevicesNativeAsync$2$1(cancellableContinuationImpl5));
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public final synchronized Discord getVoiceEngineNative() {
        MediaEngine mediaEngine;
        mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        return mediaEngine.mo329i();
    }

    public final synchronized void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.userId = payload.getMe().getId();
    }

    public final void handleMicrophonePermissionGranted() {
        Observable<Boolean> observableM11100Z = this.isNativeEngineInitializedSubject.m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "isNativeEngineInitializedSubject\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableM11100Z, StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C61691(), 62, (Object) null);
    }

    public final synchronized void handleVoiceChannelSelected(long channelId) {
        Long l = this.previousVoiceChannelId;
        if (l != null && (l == null || l.longValue() != 0)) {
            if (channelId == 0) {
                getVideoInputDevicesNative(new C61721());
            }
        }
        this.previousVoiceChannelId = Long.valueOf(channelId);
    }

    public final synchronized boolean hasNativeEngineEverInitialized() {
        return this.hasNativeEngineEverInitialized;
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.preferredVideoInputDeviceGUID = this.preferredVideoInputDeviceGuidCache.get();
        this.hasNativeEngineEverInitialized = this.hasNativeEngineEverInitializedCache.get().booleanValue();
        SharedPreferences prefsSessionDurable = getPrefsSessionDurable();
        MediaEngine.OpenSLESConfig openSLESConfig = DEFAULT_OPENSLES_CONFIG;
        String string = prefsSessionDurable.getString("OPEN_SLES", openSLESConfig.name());
        if (string == null) {
            string = openSLESConfig.name();
        }
        Intrinsics3.checkNotNullExpressionValue(string, "prefsSessionDurable\n    …AULT_OPENSLES_CONFIG.name");
        MediaEngine.OpenSLESConfig openSLESConfigValueOf = MediaEngine.OpenSLESConfig.valueOf(string);
        this.openSLESConfigSubject.f27653k.onNext(openSLESConfigValueOf);
        StoreMediaEngine$init$echoCancellationCallback$1 storeMediaEngine$init$echoCancellationCallback$1 = new StoreMediaEngine$init$echoCancellationCallback$1(this);
        EngineListener engineListener = new EngineListener();
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics3.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "Executors.newSingleThreadExecutor()");
        AppLog appLog = AppLog.f14950g;
        EchoCancellation.a aVar = EchoCancellation.f1662c;
        EchoCancellation echoCancellation = EchoCancellation.f1661b;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(engineListener, "listener");
        Intrinsics3.checkNotNullParameter(executorServiceNewSingleThreadExecutor, "singleThreadExecutorService");
        Intrinsics3.checkNotNullParameter(openSLESConfigValueOf, "openSLESConfig");
        Intrinsics3.checkNotNullParameter(appLog, "logger");
        Intrinsics3.checkNotNullParameter(echoCancellation, "echoCancellation");
        Intrinsics3.checkNotNullParameter(storeMediaEngine$init$echoCancellationCallback$1, "echoCancellationCallback");
        this.mediaEngine = new C1233k(context, engineListener, new MediaEngineExecutorService(executorServiceNewSingleThreadExecutor, false), openSLESConfigValueOf, appLog, echoCancellation, storeMediaEngine$init$echoCancellationCallback$1, null, null, 384);
        Observable<R> observableM11083G = this.storeStream.getExperiments().observeUserExperiment("2021-05_opensl_default_enable_android", true).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11100Z = observableM11083G.m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "storeStream.experiments.…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(observableM11100Z), StoreMediaEngine.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C61731(), 62, (Object) null);
    }

    public final Observable<KrispOveruseDetector.Status> onKrispStatusEvent() {
        PublishSubject<KrispOveruseDetector.Status> publishSubject = this.onKrispStatusSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "onKrispStatusSubject");
        return publishSubject;
    }

    public final void selectDefaultVideoDevice(Function1<? super String, Unit> onSelected) {
        CoroutineScope2 coroutineScope2 = CoroutineScope2.f27919j;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        C3404f.m4211H0(coroutineScope2, MainDispatchers.f27700b.mo11194H(), null, new C61751(onSelected, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object selectDefaultVideoDeviceAsync(Continuation<? super String> continuation) {
        C61761 c61761;
        StoreMediaEngine storeMediaEngine;
        if (continuation instanceof C61761) {
            c61761 = (C61761) continuation;
            int i = c61761.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c61761.label = i - Integer.MIN_VALUE;
            } else {
                c61761 = new C61761(continuation);
            }
        }
        Object objAwaitVideoInputDevicesNativeAsync = c61761.result;
        Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
        int i2 = c61761.label;
        if (i2 == 0) {
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
            c61761.L$0 = this;
            c61761.label = 1;
            objAwaitVideoInputDevicesNativeAsync = awaitVideoInputDevicesNativeAsync(c61761);
            if (objAwaitVideoInputDevicesNativeAsync == coroutine_suspended) {
                return coroutine_suspended;
            }
            storeMediaEngine = this;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            storeMediaEngine = (StoreMediaEngine) c61761.L$0;
            Result3.throwOnFailure(objAwaitVideoInputDevicesNativeAsync);
        }
        DeviceDescription4[] deviceDescription4Arr = (DeviceDescription4[]) objAwaitVideoInputDevicesNativeAsync;
        String strPickDefaultDeviceGUID = storeMediaEngine.pickDefaultDeviceGUID(deviceDescription4Arr);
        handleVideoInputDevices$default(storeMediaEngine, deviceDescription4Arr, strPickDefaultDeviceGUID, null, 4, null);
        return strPickDefaultDeviceGUID;
    }

    public final void selectVideoInputDevice(String deviceGUID) {
        getVideoInputDevicesNative(new C61771(deviceGUID));
    }

    public final synchronized void setAudioInputEnabled(boolean audioInputEnabled) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        mediaEngine.mo331k(audioInputEnabled);
    }

    @SuppressLint({"ApplySharedPref"})
    public final synchronized void setOpenSLESConfig(MediaEngine.OpenSLESConfig openSLESConfig) {
        Intrinsics3.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        this.openSLESConfigSubject.f27653k.onNext(openSLESConfig);
        getPrefsSessionDurable().edit().putString("OPEN_SLES", openSLESConfig.name()).commit();
    }

    public final synchronized void setPttActive(boolean active) {
        MediaEngine mediaEngine = this.mediaEngine;
        if (mediaEngine == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("mediaEngine");
        }
        Iterator<T> it = mediaEngine.getConnections().iterator();
        while (it.hasNext()) {
            ((MediaEngineConnection) it.next()).mo311q(active);
        }
        SerializedSubject<Boolean, Boolean> serializedSubject = this.pttActiveSubject;
        serializedSubject.f27653k.onNext(Boolean.valueOf(active));
    }
}
