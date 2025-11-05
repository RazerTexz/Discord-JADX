package com.discord.widgets.voice;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.app.AppPermissionsRequests;
import com.discord.app.AppTransitionActivity;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stage.StageChannelUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.stage.StageChannelAPI;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: VoiceUtils.kt */
/* loaded from: classes.dex */
public final class VoiceUtils {
    public static final VoiceUtils INSTANCE = new VoiceUtils();

    /* compiled from: VoiceUtils.kt */
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleCallChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $hasUserSeenVoiceChannelOnboarding;
        public final /* synthetic */ boolean $isNewUser;
        public final /* synthetic */ Channel $selectedVoiceChannel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Channel channel, AppPermissionsRequests appPermissionsRequests, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2, boolean z3, Channel channel2) {
            super(0);
            this.$channel = channel;
            this.$appPermissionsRequests = appPermissionsRequests;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$hasUserSeenVoiceChannelOnboarding = z2;
            this.$isNewUser = z3;
            this.$selectedVoiceChannel = channel2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (ChannelUtils.B(this.$channel)) {
                new PrivateCallLauncher(this.$appPermissionsRequests, this.$appComponent, this.$context, this.$fragmentManager).launchVoiceCall(this.$channel.getId());
                return;
            }
            if (ChannelUtils.D(this.$channel)) {
                StageChannelUtils.INSTANCE.connectToStageChannel(this.$channel, this.$context, this.$fragmentManager);
                return;
            }
            if (!this.$hasUserSeenVoiceChannelOnboarding && this.$isNewUser) {
                WidgetGuildCallOnboardingSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId());
                return;
            }
            if (!TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            Channel channel = this.$selectedVoiceChannel;
            if (channel == null || ChannelUtils.B(channel) || this.$selectedVoiceChannel.getId() != this.$channel.getId()) {
                WidgetCallPreviewFullscreen.INSTANCE.launch(this.$context, this.$channel.getId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 12, null);
            }
        }
    }

    /* compiled from: VoiceUtils.kt */
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: VoiceUtils.kt */
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: VoiceUtils.kt */
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public final /* synthetic */ AppPermissionsRequests $appPermissionsRequests;
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Function0 $onEventStarted;

        /* compiled from: VoiceUtils.kt */
        /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {

            /* compiled from: VoiceUtils.kt */
            /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$3$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C04761 extends o implements Function1<Void, Unit> {
                public static final C04761 INSTANCE = new C04761();

                public C04761() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                    invoke2(r1);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Void r1) {
                }
            }

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(StageChannelAPI.setUserSuppressedInChannel$default(StageChannelAPI.INSTANCE, AnonymousClass3.this.$channel, StoreStream.INSTANCE.getUsers().getMeSnapshot().getId(), false, 0L, 8, null), false, 1, null), VoiceUtils.INSTANCE.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C04761.INSTANCE, 62, (Object) null);
                AnonymousClass3.this.$onEventStarted.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AppPermissionsRequests appPermissionsRequests, Channel channel, Function0 function0) {
            super(0);
            this.$appPermissionsRequests = appPermissionsRequests;
            this.$channel = channel;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            d.S1(this.$appPermissionsRequests, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: VoiceUtils.kt */
    /* renamed from: com.discord.widgets.voice.VoiceUtils$handleConnectToEventChannel$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ Function0 $onEventStarted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Channel channel, Context context, FragmentManager fragmentManager, Function0 function0) {
            super(0);
            this.$channel = channel;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$onEventStarted = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(this.$channel.getId());
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(this.$channel.getGuildId()))) {
                WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, this.$context, this.$channel.getId(), false, null, null, 28, null);
            } else {
                WidgetVoiceBottomSheet.INSTANCE.show(this.$fragmentManager, this.$channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
            this.$onEventStarted.invoke();
        }
    }

    private VoiceUtils() {
    }

    public static final void handleCallChannel(Channel channel, AppBottomSheet appBottomSheet) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        Context contextRequireContext = appBottomSheet.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleCallChannel(channel, appBottomSheet, appBottomSheet, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppBottomSheet appBottomSheet, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appBottomSheet, "appBottomSheet");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appBottomSheet.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "appBottomSheet.requireContext()");
        FragmentManager parentFragmentManager = appBottomSheet.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appBottomSheet.parentFragmentManager");
        handleConnectToEventChannel(channel, appBottomSheet, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppBottomSheet appBottomSheet, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass1.INSTANCE;
        }
        handleConnectToEventChannel(channel, appBottomSheet, (Function0<Unit>) function0);
    }

    public static /* synthetic */ void handleConnectToEventChannel$default(Channel channel, AppFragment appFragment, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = AnonymousClass2.INSTANCE;
        }
        handleConnectToEventChannel(channel, appFragment, (Function0<Unit>) function0);
    }

    public static final void handleCallChannel(Channel channel, AppFragment appFragment) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appFragment, "appFragment");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleCallChannel(channel, appFragment, appFragment, contextRequireContext, parentFragmentManager);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppFragment appFragment, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appFragment, "appFragment");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        Context contextRequireContext = appFragment.requireContext();
        FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
        handleConnectToEventChannel(channel, appFragment, contextRequireContext, parentFragmentManager, onEventStarted);
    }

    public static final void handleCallChannel(Channel channel, AppComponent appComponent, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        UserUtils userUtils = UserUtils.INSTANCE;
        StoreStream.Companion companion = StoreStream.INSTANCE;
        boolean zIsNewUser$default = UserUtils.isNewUser$default(userUtils, companion.getUsers().getMeSnapshot(), null, 1, null);
        Channel selectedVoiceChannel = companion.getVoiceChannelSelected().getSelectedVoiceChannel();
        MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new AnonymousClass1(channel, appPermissionsRequests, appComponent, context, fragmentManager, WidgetGuildCallOnboardingSheet.INSTANCE.hasUserSeenVoiceChannelOnboarding(context), zIsNewUser$default, selectedVoiceChannel), 48, null);
    }

    public static final void handleConnectToEventChannel(Channel channel, AppPermissionsRequests appPermissionsRequests, Context context, FragmentManager fragmentManager, Function0<Unit> onEventStarted) {
        m.checkNotNullParameter(channel, "channel");
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onEventStarted, "onEventStarted");
        if (ChannelUtils.D(channel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, new AnonymousClass3(appPermissionsRequests, channel, onEventStarted), 504, null);
        } else if (ChannelUtils.J(channel)) {
            d.S1(appPermissionsRequests, null, new AnonymousClass4(channel, context, fragmentManager, onEventStarted), 1, null);
        }
    }
}
