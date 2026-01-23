package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissions2;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtils {

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1 */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final class C104081 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $isVideo;
        public final /* synthetic */ WeakReference $weakContext;

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass1<T, R> implements Func1<RtcConnection.StateChange, Boolean> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(RtcConnection.StateChange stateChange) {
                return Boolean.valueOf(stateChange.state == RtcConnection.State.C5612f.f18814a);
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(RtcConnection.StateChange stateChange) {
                return call2(stateChange);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Channel, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Channel channel) {
                return Long.valueOf(channel != null ? channel.getId() : -1L);
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Long call(Channel channel) {
                return call2(channel);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass3<T1, T2, R> implements Func2<RtcConnection.StateChange, Long, Long> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(RtcConnection.StateChange stateChange, Long l) {
                return l;
            }

            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Long call(RtcConnection.StateChange stateChange, Long l) {
                return call2(stateChange, l);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Long, Boolean> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                return Boolean.valueOf(invoke2(l));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Long l) {
                return l != null && l.longValue() == C104081.this.$channelId;
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
            public AnonymousClass5() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                Context context;
                if (l.longValue() <= 0 || (context = (Context) C104081.this.$weakContext.get()) == null) {
                    return;
                }
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(context, "it");
                Intrinsics3.checkNotNullExpressionValue(l, "voiceChannelId");
                WidgetCallFullscreen.Companion.launch$default(companion, context, l.longValue(), false, null, null, 28, null);
                if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    return;
                }
                WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1, reason: invalid class name */
            /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStream.INSTANCE.getMediaEngine().selectVideoInputDevice(null);
                }
            }

            public AnonymousClass6() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreCalls calls = StoreStream.INSTANCE.getCalls();
                C104081 c104081 = C104081.this;
                calls.call(c104081.$appComponent, c104081.$context, c104081.$fragmentManager, c104081.$channelId, AnonymousClass1.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass7 extends Lambda implements Function1<String, Unit> {
            public final /* synthetic */ AnonymousClass6 $doCall$6;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(AnonymousClass6 anonymousClass6) {
                super(1);
                this.$doCall$6 = anonymousClass6;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str != null) {
                    this.$doCall$6.invoke2();
                } else {
                    AppToast.m169g(C104081.this.$context, C5419R.string.no_video_devices, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104081(long j, WeakReference weakReference, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2) {
            super(0);
            this.$channelId = j;
            this.$weakContext = weakReference;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$isVideo = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableM11100Z = Observable.m11076j(companion.getRtcConnection().getConnectionState().m11118y(AnonymousClass1.INSTANCE), companion.getVoiceChannelSelected().observeSelectedChannel().m11083G(AnonymousClass2.INSTANCE), AnonymousClass3.INSTANCE).m11108k(C0879o.m177c(new AnonymousClass4(), -1L, 250L, TimeUnit.MILLISECONDS)).m11100Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "Observable\n        .comb…       )\n        .take(1)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.m8518ui(observableM11100Z), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
            AnonymousClass6 anonymousClass6 = new AnonymousClass6();
            if (this.$isVideo) {
                companion.getMediaEngine().selectDefaultVideoDevice(new AnonymousClass7(anonymousClass6));
            } else {
                anonymousClass6.invoke2();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$2 */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final /* synthetic */ class C104092 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ C104081 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104092(C104081 c104081) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = c104081;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$3 */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final /* synthetic */ class C104103 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ C104081 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104103(C104081 c104081) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = c104081;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    public static final void callAndLaunch(long j, boolean z2, AppPermissions2 appPermissions2, Context context, AppComponent appComponent, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        C104081 c104081 = new C104081(j, new WeakReference(context), appComponent, context, fragmentManager, z2);
        if (z2) {
            appPermissions2.requestVideoCallPermissions(new C104092(c104081));
        } else {
            AnimatableValueParser.m473S1(appPermissions2, null, new C104103(c104081), 1, null);
        }
    }
}
