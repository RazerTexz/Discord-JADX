package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissionsRequests;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: PrivateCallLaunchUtils.kt */
/* loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt {

    /* compiled from: PrivateCallLaunchUtils.kt */
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $isVideo;
        public final /* synthetic */ WeakReference $weakContext;

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04771<T, R> implements b<RtcConnection.StateChange, Boolean> {
            public static final C04771 INSTANCE = new C04771();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(RtcConnection.StateChange stateChange) {
                return Boolean.valueOf(stateChange.state == RtcConnection.State.f.a);
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Boolean call(RtcConnection.StateChange stateChange) {
                return call2(stateChange);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$2, reason: invalid class name */
        public static final class AnonymousClass2<T, R> implements b<Channel, Long> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Channel channel) {
                return Long.valueOf(channel != null ? channel.getId() : -1L);
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Long call(Channel channel) {
                return call2(channel);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$3, reason: invalid class name */
        public static final class AnonymousClass3<T1, T2, R> implements Func2<RtcConnection.StateChange, Long, Long> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(RtcConnection.StateChange stateChange, Long l) {
                return l;
            }

            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Long call(RtcConnection.StateChange stateChange, Long l) {
                return call2(stateChange, l);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends o implements Function1<Long, Boolean> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                return Boolean.valueOf(invoke2(l));
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Long l) {
                return l != null && l.longValue() == AnonymousClass1.this.$channelId;
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends o implements Function1<Long, Unit> {
            public AnonymousClass5() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                Context context;
                if (l.longValue() <= 0 || (context = (Context) AnonymousClass1.this.$weakContext.get()) == null) {
                    return;
                }
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                m.checkNotNullExpressionValue(context, "it");
                m.checkNotNullExpressionValue(l, "voiceChannelId");
                WidgetCallFullscreen.Companion.launch$default(companion, context, l.longValue(), false, null, null, 28, null);
                if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    return;
                }
                WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6, reason: invalid class name */
        public static final class AnonymousClass6 extends o implements Function0<Unit> {

            /* compiled from: PrivateCallLaunchUtils.kt */
            /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1, reason: invalid class name and collision with other inner class name */
            public static final class C04781 extends o implements Function0<Unit> {
                public static final C04781 INSTANCE = new C04781();

                public C04781() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
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
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreCalls calls = StoreStream.INSTANCE.getCalls();
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                calls.call(anonymousClass1.$appComponent, anonymousClass1.$context, anonymousClass1.$fragmentManager, anonymousClass1.$channelId, C04781.INSTANCE);
            }
        }

        /* compiled from: PrivateCallLaunchUtils.kt */
        /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$7, reason: invalid class name */
        public static final class AnonymousClass7 extends o implements Function1<String, Unit> {
            public final /* synthetic */ AnonymousClass6 $doCall$6;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(AnonymousClass6 anonymousClass6) {
                super(1);
                this.$doCall$6 = anonymousClass6;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str != null) {
                    this.$doCall$6.invoke2();
                } else {
                    b.a.d.m.g(AnonymousClass1.this.$context, R.string.no_video_devices, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, WeakReference weakReference, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2) {
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
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableZ = Observable.j(companion.getRtcConnection().getConnectionState().y(C04771.INSTANCE), companion.getVoiceChannelSelected().observeSelectedChannel().G(AnonymousClass2.INSTANCE), AnonymousClass3.INSTANCE).k(b.a.d.o.c(new AnonymousClass4(), -1L, 250L, TimeUnit.MILLISECONDS)).Z(1);
            m.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       )\n        .take(1)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass5(), 62, (Object) null);
            AnonymousClass6 anonymousClass6 = new AnonymousClass6();
            if (this.$isVideo) {
                companion.getMediaEngine().selectDefaultVideoDevice(new AnonymousClass7(anonymousClass6));
            } else {
                anonymousClass6.invoke2();
            }
        }
    }

    /* compiled from: PrivateCallLaunchUtils.kt */
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends k implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    /* compiled from: PrivateCallLaunchUtils.kt */
    /* renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends k implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    public static final void callAndLaunch(long j, boolean z2, AppPermissionsRequests appPermissionsRequests, Context context, AppComponent appComponent, FragmentManager fragmentManager) {
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(j, new WeakReference(context), appComponent, context, fragmentManager, z2);
        if (z2) {
            appPermissionsRequests.requestVideoCallPermissions(new AnonymousClass2(anonymousClass1));
        } else {
            d.S1(appPermissionsRequests, null, new AnonymousClass3(anonymousClass1), 1, null);
        }
    }
}
