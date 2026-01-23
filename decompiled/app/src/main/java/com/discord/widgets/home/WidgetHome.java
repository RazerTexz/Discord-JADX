package com.discord.widgets.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.interaction.InteractionModalCreate;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.panels.OverlappingPanelsLayout;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreUser;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.accessibility.AccessibilityDetectionNavigator;
import com.discord.widgets.botuikit.ModalComponent;
import com.discord.widgets.channels.WidgetChannelOnboarding;
import com.discord.widgets.chat.input.SmoothKeyboardReactionHelper;
import com.discord.widgets.chat.list.WidgetChatList;
import com.discord.widgets.directories.WidgetDirectoryChannel;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventUpsellBottomSheet;
import com.discord.widgets.home.WidgetHomeModel;
import com.discord.widgets.home.WidgetHomeViewModel;
import com.discord.widgets.home.WidgetMainSurveyDialog;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.notice.WidgetNoticeNuxSamsungLink;
import com.discord.widgets.playstation.WidgetPlaystationIntegrationUpsellBottomSheet;
import com.discord.widgets.servers.guild_role_subscription.upsell.WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.google.android.material.appbar.AppBarLayout;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.WidgetUrgentMessageDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.WidgetHomePanelCenterBinding;
import p007b.p008a.p025i.WidgetHomePanelCenterChatBinding;
import p007b.p008a.p025i.WidgetHomePanelCenterContentUnreadBinding;
import p007b.p008a.p025i.WidgetHomePanelLeftBinding;
import p007b.p008a.p025i.WidgetHomePanelRightBinding;
import p007b.p008a.p039o.LocaleProvider;
import p007b.p008a.p039o.PanelsChildGestureRegionObserver;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.SetsJVM;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Func0;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: WidgetHome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHome extends AppFragment implements OnTabSelectedListener, PanelsChildGestureRegionObserver.a {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetHome.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHomeBinding;", 0)};
    private static final long DELAY_DRAWER_OPEN_FINISH = 2000;
    private static final long DELAY_DRAWER_OPEN_START = 1000;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Set<Integer> fixedPositionViewIds;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private final LeftPanelManager leftPanelManager;
    private final LocaleManager localeManager;
    private Function1<? super View, Unit> onGuildListAddHintCreate;
    private WidgetHomePanelLoading panelLoading;
    private WidgetHomePanelNsfw panelNsfw;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            OverlappingPanelsLayout.Panel.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[OverlappingPanelsLayout.Panel.END.ordinal()] = 1;
            iArr[OverlappingPanelsLayout.Panel.CENTER.ordinal()] = 2;
            iArr[OverlappingPanelsLayout.Panel.START.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$animatePeek$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class RunnableC89391 implements Runnable {
        public final /* synthetic */ WidgetChatList $fragmentChatList;

        public RunnableC89391(WidgetChatList widgetChatList) {
            this.$fragmentChatList = widgetChatList;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageView imageView = WidgetHome.access$getBinding$p(WidgetHome.this).f17130g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
            imageView.setVisibility(8);
            this.$fragmentChatList.enableItemAnimations();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89401<T1, T2, R> implements Func2<Boolean, Map<Long, ? extends Channel>, Boolean> {
        public static final C89401 INSTANCE = new C89401();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(Boolean bool, Map<Long, ? extends Channel> map) {
            return call2(bool, (Map<Long, Channel>) map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(Boolean bool, Map<Long, Channel> map) {
            Intrinsics3.checkNotNullExpressionValue(bool, "connectionOpen");
            if (bool.booleanValue()) {
                return Boolean.valueOf(map.isEmpty());
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89412 extends Lambda implements Function1<Boolean, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                return invoke2(nuxState);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
                Intrinsics3.checkNotNullParameter(nuxState, "it");
                return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 55, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetHome.access$getBinding$p(WidgetHome.this).f17126c.openStartPanel();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

            /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$3$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetHome.kt */
            public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                    return invoke2(nuxState);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final StoreNux.NuxState invoke2(StoreNux.NuxState nuxState) {
                    Intrinsics3.checkNotNullParameter(nuxState, "it");
                    return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, true, null, 39, null);
                }
            }

            public AnonymousClass3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureFirstOpen$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetHome.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Function0<? extends Unit>, Unit> {
            public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Function0<? extends Unit> function0) {
                invoke2((Function0<Unit>) function0);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Function0<Unit> function0) {
                function0.invoke();
            }
        }

        public C89412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke2(bool);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Boolean bool) {
            if (bool == null) {
                return;
            }
            if (!bool.booleanValue()) {
                StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                return;
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new AnonymousClass2());
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            Observable observableM11064I = Observable.m11064I(scalarSynchronousObservable.m11111q(1000L, timeUnit), new ScalarSynchronousObservable(AnonymousClass3.INSTANCE).m11111q(WidgetHome.DELAY_DRAWER_OPEN_FINISH, timeUnit));
            Intrinsics3.checkNotNullExpressionValue(observableM11064I, "Observable\n             …, TimeUnit.MILLISECONDS))");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11064I, WidgetHome.this, null, 2, null), WidgetHome.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass4.INSTANCE, 62, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureLeftPanel$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89421 extends Lambda implements Function1<OverlappingPanelsLayout.LockState, Unit> {
        public C89421() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(OverlappingPanelsLayout.LockState lockState) {
            invoke2(lockState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(OverlappingPanelsLayout.LockState lockState) {
            Intrinsics3.checkNotNullParameter(lockState, "lockState");
            WidgetHome.access$getBinding$p(WidgetHome.this).f17126c.setStartPanelUseFullPortraitWidth(lockState == OverlappingPanelsLayout.LockState.OPEN);
            WidgetHome.access$getBinding$p(WidgetHome.this).f17126c.setStartPanelLockState(lockState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureNavigationDrawerAction$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89431 extends Lambda implements Function1<StoreNavigation.PanelAction, Unit> {
        public final /* synthetic */ StoreNavigation $this_configureNavigationDrawerAction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89431(StoreNavigation storeNavigation) {
            super(1);
            this.$this_configureNavigationDrawerAction = storeNavigation;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNavigation.PanelAction panelAction) {
            invoke2(panelAction);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNavigation.PanelAction panelAction) {
            Intrinsics3.checkNotNullParameter(panelAction, "it");
            this.$this_configureNavigationDrawerAction.setNavigationPanelAction(panelAction, WidgetHome.access$getBinding$p(WidgetHome.this).f17126c);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureOverlappingPanels$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89441 implements OverlappingPanelsLayout.PanelStateListener {
        public C89441() {
        }

        @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
        public void onPanelStateChange(PanelState panelState) {
            Intrinsics3.checkNotNullParameter(panelState, "panelState");
            WidgetHome.access$getViewModel$p(WidgetHome.this).onStartPanelStateChange(panelState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$configureOverlappingPanels$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89452 implements OverlappingPanelsLayout.PanelStateListener {
        public C89452() {
        }

        @Override // com.discord.panels.OverlappingPanelsLayout.PanelStateListener
        public void onPanelStateChange(PanelState panelState) {
            Intrinsics3.checkNotNullParameter(panelState, "panelState");
            WidgetHome.access$getViewModel$p(WidgetHome.this).onEndPanelStateChange(panelState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$handleViewState$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C89461 extends FunctionReferenceImpl implements Function1<Boolean, Unit> {
        public C89461(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetHome.access$onNsfwToggle((WidgetHome) this.receiver, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$maybeShowHubEmailUpsell$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89471 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final C89471 INSTANCE = new C89471();

        public C89471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            AppScreen2.m156d(fragmentActivity, WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onCreate$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89481 extends Lambda implements Function1<Context, Locale> {
        public C89481() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Locale invoke(Context context) {
            return invoke2(context);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Locale invoke2(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return WidgetHome.access$getLocaleManager$p(WidgetHome.this).getPrimaryLocale(context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89491<R> implements Func0<Boolean> {
        public C89491() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetHome.access$handleBackPressed(WidgetHome.this));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89502<T, R> implements Func1<StoreNux.NuxState, Boolean> {
        public C89502() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(StoreNux.NuxState nuxState) {
            return call2(nuxState);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(StoreNux.NuxState nuxState) {
            FragmentActivity activity = WidgetHome.this.getActivity();
            if (!(activity instanceof AppActivity)) {
                activity = null;
            }
            AppActivity appActivity = (AppActivity) activity;
            return Boolean.valueOf(appActivity != null && appActivity.m8348h(Reflection2.getOrCreateKotlinClass(WidgetTabsHost.class)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89513 extends Lambda implements Function1<StoreNux.NuxState, Unit> {
        public C89513() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNux.NuxState nuxState) {
            boolean z2;
            boolean z3 = false;
            if (!nuxState.getFirstOpen()) {
                Collection<Guild> collectionValues = StoreStream.INSTANCE.getGuilds().getGuilds().values();
                if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                    z2 = true;
                    if (z2) {
                        z3 = true;
                    }
                } else {
                    Iterator<T> it = collectionValues.iterator();
                    while (it.hasNext()) {
                        if (!(!((Guild) it.next()).isHub())) {
                            z2 = false;
                            break;
                        }
                    }
                    z2 = true;
                    if (z2 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled()) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                WidgetHome.access$maybeShowHubEmailUpsell(WidgetHome.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89521 extends Lambda implements Function1<WidgetHomeViewModel.ViewState, Unit> {
        public C89521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetHome.access$handleViewState(WidgetHome.this, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$10 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C895310<T, R> implements Func1<MeUser, Boolean> {
        public static final C895310 INSTANCE = new C895310();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            UserUtils userUtils = UserUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(meUser, "it");
            return Boolean.valueOf(userUtils.getHasUnreadUrgentMessages(meUser));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$11 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C895411 extends Lambda implements Function1<MeUser, Unit> {
        public C895411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MeUser meUser) {
            invoke2(meUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MeUser meUser) {
            WidgetHome.access$showUrgentMessageDialog(WidgetHome.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$12 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C895512 extends Lambda implements Function1<InteractionModalCreate, Unit> {
        public C895512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InteractionModalCreate interactionModalCreate) {
            invoke2(interactionModalCreate);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InteractionModalCreate interactionModalCreate) {
            Intrinsics3.checkNotNullParameter(interactionModalCreate, "it");
            WidgetHome.access$showInteractionModal(WidgetHome.this, interactionModalCreate);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$13 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C895613 extends FunctionReferenceImpl implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public C895613(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "handleGlobalStatusIndicatorState", "handleGlobalStatusIndicatorState(Lcom/discord/widgets/status/WidgetGlobalStatusIndicatorState$State;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "p1");
            WidgetHome.access$handleGlobalStatusIndicatorState((WidgetHome) this.receiver, state);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89572 extends Lambda implements Function1<WidgetHomeViewModel.Event, Unit> {
        public C89572() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetHome.access$handleEvent(WidgetHome.this, event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89583 extends Lambda implements Function1<WidgetHomeModel, Unit> {
        public C89583() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            Intrinsics3.checkNotNullParameter(widgetHomeModel, "it");
            WidgetHome.access$configureUI(WidgetHome.this, widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89594<T1, T2, R> implements Func2<WidgetHomeModel, WidgetHomeModel, Boolean> {
        public static final C89594 INSTANCE = new C89594();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Boolean call(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
            return call2(widgetHomeModel, widgetHomeModel2);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(WidgetHomeModel widgetHomeModel, WidgetHomeModel widgetHomeModel2) {
            return Boolean.valueOf(widgetHomeModel.getChannelId() == widgetHomeModel2.getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$5 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89605 extends Lambda implements Function1<WidgetHomeModel, Unit> {
        public C89605() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetHomeModel widgetHomeModel) {
            invoke2(widgetHomeModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetHomeModel widgetHomeModel) {
            WidgetHome widgetHome = WidgetHome.this;
            Intrinsics3.checkNotNullExpressionValue(widgetHomeModel, "it");
            WidgetHome.access$maybeToggleChannel(widgetHome, widgetHomeModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$6 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89616<T, R> implements Func1<SurveyUtils.Survey, Boolean> {
        public static final C89616 INSTANCE = new C89616();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(SurveyUtils.Survey survey) {
            return call2(survey);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(SurveyUtils.Survey survey) {
            return Boolean.valueOf(!Intrinsics3.areEqual(survey, SurveyUtils.Survey.None.INSTANCE));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$7 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final /* synthetic */ class C89627 extends FunctionReferenceImpl implements Function1<SurveyUtils.Survey, Unit> {
        public C89627(WidgetHome widgetHome) {
            super(1, widgetHome, WidgetHome.class, "showSurvey", "showSurvey(Lcom/discord/utilities/surveys/SurveyUtils$Survey;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SurveyUtils.Survey survey) {
            invoke2(survey);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SurveyUtils.Survey survey) {
            Intrinsics3.checkNotNullParameter(survey, "p1");
            WidgetHome.access$showSurvey((WidgetHome) this.receiver, survey);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$8 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89638<T, R> implements Func1<StoreNux.NuxState, Boolean> {
        public static final C89638 INSTANCE = new C89638();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(StoreNux.NuxState nuxState) {
            return call2(nuxState);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(StoreNux.NuxState nuxState) {
            return Boolean.valueOf(nuxState.getFirstOpen());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$onViewBoundOrOnResume$9 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89649 extends Lambda implements Function1<StoreNux.NuxState, Unit> {
        public C89649() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreNux.NuxState nuxState) {
            invoke2(nuxState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreNux.NuxState nuxState) {
            WidgetHome.access$configureFirstOpen(WidgetHome.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$setPanelWindowInsetsListeners$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89651 implements OnApplyWindowInsetsListener {
        public C89651() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            ViewGroup.LayoutParams layoutParams = WidgetHome.access$getBinding$p(WidgetHome.this).f17128e.f1037c.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$setPanelWindowInsetsListeners$2 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89662 implements OnApplyWindowInsetsListener {
        public C89662() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m82of(0, 0, 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
            ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(WidgetHome.this).f17127d.f962c.f985d, windowInsetsCompatBuild);
            ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(WidgetHome.this).f17127d.f962c.f986e, windowInsetsCompatBuild);
            ViewCompat.dispatchApplyWindowInsets(WidgetHome.access$getBinding$p(WidgetHome.this).f17127d.f961b, windowInsetsCompatBuild);
            WidgetHomePanelNsfw widgetHomePanelNsfwAccess$getPanelNsfw$p = WidgetHome.access$getPanelNsfw$p(WidgetHome.this);
            if (widgetHomePanelNsfwAccess$getPanelNsfw$p != null) {
                widgetHomePanelNsfwAccess$getPanelNsfw$p.dispatchApplyWindowInsets(windowInsetsCompat);
            }
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$setPanelWindowInsetsListeners$3 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89673 implements OnApplyWindowInsetsListener {
        public C89673() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            FragmentContainerView fragmentContainerView = WidgetHome.access$getBinding$p(WidgetHome.this).f17129f.f1091c;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.panelRight.widgetConnectedList");
            fragmentContainerView.setPadding(fragmentContainerView.getPaddingLeft(), fragmentContainerView.getPaddingTop(), fragmentContainerView.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showSurvey$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89681 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public final /* synthetic */ SurveyUtils.Survey $survey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89681(SurveyUtils.Survey survey) {
            super(1);
            this.$survey = survey;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetMainSurveyDialog.Companion companion = WidgetMainSurveyDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            companion.show(supportFragmentManager, this.$survey.getSurveyId(), this.$survey.getSurveyURL(), this.$survey.getSurveyBody(), this.$survey.getSurveyTitle());
            StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$survey.getNoticeKey(), 0L, 2, null);
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.home.WidgetHome$showUrgentMessageDialog$1 */
    /* JADX INFO: compiled from: WidgetHome.kt */
    public static final class C89691 extends Lambda implements Function1<FragmentActivity, Boolean> {
        public static final C89691 INSTANCE = new C89691();

        public C89691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
            return Boolean.valueOf(invoke2(fragmentActivity));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(FragmentActivity fragmentActivity) {
            Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            WidgetUrgentMessageDialog.Companion aVar = WidgetUrgentMessageDialog.INSTANCE;
            FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Objects.requireNonNull(aVar);
            Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
            new WidgetUrgentMessageDialog().show(supportFragmentManager, "WidgetUrgentMessageDialog");
            return true;
        }
    }

    public WidgetHome() {
        super(C5419R.layout.widget_home);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetHome2.INSTANCE, null, 2, null);
        WidgetHome4 widgetHome4 = WidgetHome4.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetHomeViewModel.class), new WidgetHome$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetHome4));
        this.fixedPositionViewIds = SetsJVM.setOf(Integer.valueOf(C5419R.id.unread));
        this.leftPanelManager = new LeftPanelManager(null, null, 3, null);
        this.localeManager = new LocaleManager();
        this.onGuildListAddHintCreate = WidgetHome3.INSTANCE;
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
    }

    public static final /* synthetic */ void access$configureFirstOpen(WidgetHome widgetHome) {
        widgetHome.configureFirstOpen();
    }

    public static final /* synthetic */ void access$configureUI(WidgetHome widgetHome, WidgetHomeModel widgetHomeModel) {
        widgetHome.configureUI(widgetHomeModel);
    }

    public static final /* synthetic */ WidgetHomeBinding access$getBinding$p(WidgetHome widgetHome) {
        return widgetHome.getBinding();
    }

    public static final /* synthetic */ LocaleManager access$getLocaleManager$p(WidgetHome widgetHome) {
        return widgetHome.localeManager;
    }

    public static final /* synthetic */ WidgetHomePanelNsfw access$getPanelNsfw$p(WidgetHome widgetHome) {
        return widgetHome.panelNsfw;
    }

    public static final /* synthetic */ WidgetHomeViewModel access$getViewModel$p(WidgetHome widgetHome) {
        return widgetHome.getViewModel();
    }

    public static final /* synthetic */ boolean access$handleBackPressed(WidgetHome widgetHome) {
        return widgetHome.handleBackPressed();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetHome widgetHome, WidgetHomeViewModel.Event event) {
        widgetHome.handleEvent(event);
    }

    public static final /* synthetic */ void access$handleGlobalStatusIndicatorState(WidgetHome widgetHome, WidgetGlobalStatusIndicatorState.State state) {
        widgetHome.handleGlobalStatusIndicatorState(state);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetHome widgetHome, WidgetHomeViewModel.ViewState viewState) {
        widgetHome.handleViewState(viewState);
    }

    public static final /* synthetic */ void access$maybeShowHubEmailUpsell(WidgetHome widgetHome) {
        widgetHome.maybeShowHubEmailUpsell();
    }

    public static final /* synthetic */ void access$maybeToggleChannel(WidgetHome widgetHome, WidgetHomeModel widgetHomeModel) {
        widgetHome.maybeToggleChannel(widgetHomeModel);
    }

    public static final /* synthetic */ void access$onNsfwToggle(WidgetHome widgetHome, boolean z2) {
        widgetHome.onNsfwToggle(z2);
    }

    public static final /* synthetic */ void access$setPanelNsfw$p(WidgetHome widgetHome, WidgetHomePanelNsfw widgetHomePanelNsfw) {
        widgetHome.panelNsfw = widgetHomePanelNsfw;
    }

    public static final /* synthetic */ void access$showInteractionModal(WidgetHome widgetHome, InteractionModalCreate interactionModalCreate) {
        widgetHome.showInteractionModal(interactionModalCreate);
    }

    public static final /* synthetic */ void access$showSurvey(WidgetHome widgetHome, SurveyUtils.Survey survey) {
        widgetHome.showSurvey(survey);
    }

    public static final /* synthetic */ void access$showUrgentMessageDialog(WidgetHome widgetHome) {
        widgetHome.showUrgentMessageDialog();
    }

    private final void animatePeek(WidgetHomeViewModel.Event event) {
        View view;
        View view2;
        long j;
        float right;
        float right2;
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            return;
        }
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.widget_chat_list);
        if (!(fragmentFindFragmentById instanceof WidgetChatList)) {
            fragmentFindFragmentById = null;
        }
        WidgetChatList widgetChatList = (WidgetChatList) fragmentFindFragmentById;
        if (widgetChatList != null) {
            WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().f17127d;
            Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
            RoundedRelativeLayout roundedRelativeLayout = widgetHomePanelCenterBinding.f960a;
            Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(roundedRelativeLayout.getMeasuredWidth(), roundedRelativeLayout.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            roundedRelativeLayout.draw(new Canvas(bitmapCreateBitmap));
            getBinding().f17130g.setImageBitmap(bitmapCreateBitmap);
            if (event instanceof WidgetHomeViewModel.Event.AnimatePeekIn) {
                ImageView imageView = getBinding().f17130g;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.peekTransitionBitmap");
                right2 = roundedRelativeLayout.getRight();
                view2 = imageView;
                view = roundedRelativeLayout;
                j = 250;
                right = 0.0f;
            } else {
                view = getBinding().f17130g;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.peekTransitionBitmap");
                view2 = roundedRelativeLayout;
                j = 200;
                right = roundedRelativeLayout.getRight();
                right2 = 0.0f;
            }
            view.setTranslationX(right2);
            view.animate().setDuration(j).translationX(right).withEndAction(new RunnableC89391(widgetChatList)).start();
            view2.setTranslationX(right2 - roundedRelativeLayout.getMeasuredWidth());
            view2.animate().setDuration(j).translationX(right - roundedRelativeLayout.getMeasuredWidth()).start();
            widgetChatList.disableItemAnimations();
            ImageView imageView2 = getBinding().f17130g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.peekTransitionBitmap");
            imageView2.setVisibility(0);
        }
    }

    private final void configureFirstOpen() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11119z = Observable.m11076j(StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), C89401.INSTANCE).m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z, "Observable\n        .comb…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(observableM11119z, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89412(), 62, (Object) null);
    }

    private final void configureLeftPanel() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(this.leftPanelManager.observeLockState()), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89421(), 62, (Object) null);
    }

    private final void configureNavigationDrawerAction(StoreNavigation storeNavigation) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(storeNavigation.getNavigationPanelAction(), this, null, 2, null), StoreNavigation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89431(storeNavigation), 62, (Object) null);
    }

    private final void configureOverlappingPanels() {
        getBinding().f17126c.registerStartPanelStateListeners(new C89441());
        getBinding().f17126c.registerEndPanelStateListeners(new C89452());
    }

    private final void configureUI(WidgetHomeModel widgetHomeModel) {
        getViewModel().setWidgetHomeModel$app_productionGoogleRelease(widgetHomeModel);
        if (isOnHomeTab()) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel, binding);
        }
    }

    private final void enqueueEventDetails(long guildScheduledEventId) {
        WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(guildScheduledEventId);
    }

    private final WidgetHomeBinding getBinding() {
        return (WidgetHomeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHomeViewModel getViewModel() {
        return (WidgetHomeViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed() {
        int iOrdinal = getBinding().f17126c.getSelectedPanel().ordinal();
        if (iOrdinal == 0) {
            requireActivity().moveTaskToBack(true);
        } else if (iOrdinal == 1) {
            handleCenterPanelBack$app_productionGoogleRelease();
        } else if (iOrdinal == 2) {
            getBinding().f17126c.closePanels();
        }
        return true;
    }

    private final void handleEvent(WidgetHomeViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.OpenLeftPanel.INSTANCE)) {
            getBinding().f17126c.openStartPanel();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.ClosePanels.INSTANCE)) {
            getBinding().f17126c.closePanels();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.UnlockLeftPanel.INSTANCE)) {
            getBinding().f17126c.setStartPanelLockState(OverlappingPanelsLayout.LockState.UNLOCKED);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.ShowChannelOnboardingSheet.INSTANCE)) {
            showChannelOnboardingSheet();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekIn.INSTANCE) || Intrinsics3.areEqual(event, WidgetHomeViewModel.Event.AnimatePeekOut.INSTANCE)) {
            animatePeek(event);
            return;
        }
        if (event instanceof WidgetHomeViewModel.Event.ShowGuildWelcomeSheet) {
            showWelcomeSheet$default(this, ((WidgetHomeViewModel.Event.ShowGuildWelcomeSheet) event).getGuildId(), null, 2, null);
            return;
        }
        if (event instanceof WidgetHomeViewModel.Event.ShowGuildEventUpsell) {
            showGuildEventUpsell(((WidgetHomeViewModel.Event.ShowGuildEventUpsell) event).getGuildId());
        } else if (event instanceof WidgetHomeViewModel.Event.ShowPlaystationUpsell) {
            showPlaystationUpsell();
        } else {
            if (!(event instanceof WidgetHomeViewModel.Event.ShowGuildRoleSubscriptionUpsell)) {
                throw new NoWhenBranchMatchedException();
            }
            showGuildRoleSubscriptionUpsell(((WidgetHomeViewModel.Event.ShowGuildRoleSubscriptionUpsell) event).getGuildId());
        }
    }

    private final void handleGlobalStatusIndicatorState(WidgetGlobalStatusIndicatorState.State state) {
        if (state.isCustomBackground()) {
            unroundPanelCorners();
        } else {
            roundPanelCorners();
        }
    }

    private final void handleHomeConfig(HomeConfig homeConfig) {
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null && homeConfig.getGuildScheduledEventId() != null) {
            showWelcomeSheet(homeConfig.getGuildWelcomeSheetId().longValue(), homeConfig.getGuildScheduledEventId());
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildWelcomeSheetId() : null) != null) {
            showWelcomeSheet$default(this, homeConfig.getGuildWelcomeSheetId().longValue(), null, 2, null);
            return;
        }
        if ((homeConfig != null ? homeConfig.getGuildScheduledEventId() : null) != null) {
            enqueueEventDetails(homeConfig.getGuildScheduledEventId().longValue());
        }
    }

    private final void handleViewState(WidgetHomeViewModel.ViewState viewState) {
        getBinding().f17126c.handleStartPanelState(viewState.getLeftPanelState());
        getBinding().f17126c.handleEndPanelState(viewState.getRightPanelState());
        WidgetHomePanelNsfw widgetHomePanelNsfw = this.panelNsfw;
        if (widgetHomePanelNsfw != null) {
            WidgetHomePanelNsfw.configureUI$default(widgetHomePanelNsfw, viewState.getGuildId(), viewState.isChannelNsfw(), viewState.isNsfwUnconsented(), viewState.getNsfwAllowed(), getBinding().f17127d.f962c.f983b, new C89461(this), null, 64, null);
        }
    }

    private final boolean isOnHomeTab() {
        return this.storeTabsNavigation.getSelectedTab() == NavigationTab.HOME;
    }

    private final void maybeShowHubEmailUpsell() {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String name = WidgetHubEmailFlow.INSTANCE.getNAME();
        Intrinsics3.checkNotNullExpressionValue(name, "WidgetHubEmailFlow.NAME");
        notices.requestToShow(new StoreNotices.Notice(name, null, 0L, 0, true, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, true, RecyclerView.FOREVER_NS, C89471.INSTANCE, 6, null));
    }

    private final void maybeToggleChannel(WidgetHomeModel widgetHomeModel) {
        Channel channel = widgetHomeModel.getChannel();
        boolean z2 = channel != null && ChannelUtils.m7691o(channel);
        Channel channel2 = widgetHomeModel.getChannel();
        Long lValueOf = channel2 != null ? Long.valueOf(channel2.getGuildId()) : null;
        boolean z3 = lValueOf != null && ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, lValueOf.longValue(), null, 2, null);
        Channel channel3 = widgetHomeModel.getChannel();
        boolean z4 = channel3 != null && ChannelUtils.m7693q(channel3) && z3;
        FragmentContainerView fragmentContainerView = getBinding().f17127d.f963d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.panelCenter.widgetHomePanelDirectory");
        fragmentContainerView.setVisibility(z2 ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().f17127d.f961b;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.panelCenter.widgetForumChannelList");
        fragmentContainerView2.setVisibility(z4 ? 0 : 8);
        Fragment fragmentFindFragmentById = getChildFragmentManager().findFragmentById(C5419R.id.widget_home_panel_directory);
        if (!(fragmentFindFragmentById instanceof WidgetDirectoryChannel)) {
            fragmentFindFragmentById = null;
        }
        WidgetDirectoryChannel widgetDirectoryChannel = (WidgetDirectoryChannel) fragmentFindFragmentById;
        if (widgetDirectoryChannel != null) {
            WidgetDirectoryChannel.bindGestureObservers$default(widgetDirectoryChannel, z2, null, 2, null);
        }
        WidgetHomePanelCenterChatBinding widgetHomePanelCenterChatBinding = getBinding().f17127d.f962c;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterChatBinding, "binding.panelCenter.widgetHomePanelCenterChat");
        ConstraintLayout constraintLayout = widgetHomePanelCenterChatBinding.f982a;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.panelCenter.widgetHomePanelCenterChat.root");
        constraintLayout.setVisibility((z2 || z4) ? false : true ? 0 : 8);
    }

    private final void onNsfwToggle(boolean isHidden) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        Fragment fragmentFindFragmentById = childFragmentManager.findFragmentById(C5419R.id.widget_chat_list);
        if (fragmentFindFragmentById != null) {
            Intrinsics3.checkNotNullExpressionValue(fragmentFindFragmentById, "fragmentManager.findFrag…dget_chat_list) ?: return");
            FragmentTransaction fragmentTransactionBeginTransaction = childFragmentManager.beginTransaction();
            Intrinsics3.checkNotNullExpressionValue(fragmentTransactionBeginTransaction, "fragmentManager.beginTransaction()");
            if (isHidden) {
                fragmentTransactionBeginTransaction.hide(fragmentFindFragmentById);
            } else {
                fragmentTransactionBeginTransaction.show(fragmentFindFragmentById);
            }
            fragmentTransactionBeginTransaction.commit();
        }
    }

    private final void roundPanelCorners() {
        setPanelCorners(DimenUtils.dpToPixels(8));
    }

    private final void setPanelCorners(float radius) {
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().f17127d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        widgetHomePanelCenterBinding.f960a.updateTopLeftRadius(radius);
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding2 = getBinding().f17127d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding2, "binding.panelCenter");
        widgetHomePanelCenterBinding2.f960a.updateTopRightRadius(radius);
        getBinding().f17129f.f1090b.updateTopLeftRadius(radius);
        getBinding().f17129f.f1090b.updateTopRightRadius(radius);
    }

    private final void setPanelWindowInsetsListeners() {
        FrameLayout frameLayout = getBinding().f17131h;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetHomeContainer");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        HomePanelsLayout homePanelsLayout = getBinding().f17126c;
        Intrinsics3.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        ViewExtensions.setForwardingWindowInsetsListener(homePanelsLayout);
        WidgetHomePanelLeftBinding widgetHomePanelLeftBinding = getBinding().f17128e;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLeftBinding, "binding.panelLeft");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelLeftBinding.f1035a, new C89651());
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().f17127d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelCenterBinding.f960a, new C89662());
        WidgetHomePanelRightBinding widgetHomePanelRightBinding = getBinding().f17129f;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelRightBinding, "binding.panelRight");
        ViewCompat.setOnApplyWindowInsetsListener(widgetHomePanelRightBinding.f1089a, new C89673());
    }

    private final void setupSmoothKeyboardReaction() {
        WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = getBinding().f17127d;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
        RoundedRelativeLayout roundedRelativeLayout = widgetHomePanelCenterBinding.f960a;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
        Iterator<View> it = androidx.core.view.ViewGroup.iterator(roundedRelativeLayout);
        while (it.hasNext()) {
            View next = it.next();
            if (!(next instanceof AppBarLayout) && !this.fixedPositionViewIds.contains(Integer.valueOf(next.getId()))) {
                SmoothKeyboardReactionHelper.INSTANCE.install(next);
            }
        }
    }

    private final void showChannelOnboardingSheet() {
        WidgetChannelOnboarding.Companion companion = WidgetChannelOnboarding.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showGuildEventUpsell(long guildId) {
        WidgetGuildScheduledEventUpsellBottomSheet.Companion companion = WidgetGuildScheduledEventUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.launch(parentFragmentManager, guildId);
    }

    private final void showGuildRoleSubscriptionUpsell(long guildId) {
        WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.Companion companion = WidgetGuildRoleSubscriptionOnboardingUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId);
    }

    private final void showInteractionModal(InteractionModalCreate modal) {
        Context context = getContext();
        if (context != null) {
            ModalComponent.Companion companion = ModalComponent.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            companion.show(context, new ModalComponent.Options(modal));
        }
    }

    private final void showPlaystationUpsell() {
        WidgetPlaystationIntegrationUpsellBottomSheet.Companion companion = WidgetPlaystationIntegrationUpsellBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showSurvey(SurveyUtils.Survey survey) {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(survey.getNoticeKey(), null, 0L, 5, true, null, 0L, false, 0L, new C89681(survey), 486, null));
    }

    private final void showUrgentMessageDialog() {
        StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("URGENT_MESSAGE_DIALOG", null, 0L, 0, false, null, 0L, false, 0L, C89691.INSTANCE, Opcodes.IF_ACMPNE, null));
    }

    private final void showWelcomeSheet(long guildId, Long guildScheduledEventId) {
        if (StoreStream.INSTANCE.getGuildWelcomeScreens().hasWelcomeScreenBeenSeen(guildId)) {
            return;
        }
        WidgetGuildWelcomeSheet.Companion companion = WidgetGuildWelcomeSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, guildId, guildScheduledEventId);
    }

    public static /* synthetic */ void showWelcomeSheet$default(WidgetHome widgetHome, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        widgetHome.showWelcomeSheet(j, l);
    }

    private final void unroundPanelCorners() {
        setPanelCorners(0.0f);
    }

    public final PanelLayout getPanelLayout() {
        HomePanelsLayout homePanelsLayout = getBinding().f17126c;
        Intrinsics3.checkNotNullExpressionValue(homePanelsLayout, "binding.overlappingPanels");
        return homePanelsLayout;
    }

    public final Toolbar getToolbar() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            return appActivity.toolbar;
        }
        return null;
    }

    public final TextView getUnreadCountView() {
        WidgetHomePanelCenterContentUnreadBinding widgetHomePanelCenterContentUnreadBinding = getBinding().f17127d.f962c.f984c;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterContentUnreadBinding, "binding.panelCenter.widg…omePanelCenterChat.unread");
        TextView textView = widgetHomePanelCenterContentUnreadBinding.f1007a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.panelCenter.widg…nelCenterChat.unread.root");
        return textView;
    }

    public final void handleCenterPanelBack$app_productionGoogleRelease() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        StoreChannelsSelected.ResolvedSelectedChannel selectedChannel = widgetHomeModel$app_productionGoogleRelease != null ? widgetHomeModel$app_productionGoogleRelease.getSelectedChannel() : null;
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease2 = getViewModel().getWidgetHomeModel();
        Channel selectedVoiceChannel = widgetHomeModel$app_productionGoogleRelease2 != null ? widgetHomeModel$app_productionGoogleRelease2.getSelectedVoiceChannel() : null;
        if (selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.ThreadDraft) {
            ChannelSelector.INSTANCE.getInstance().dismissCreateThread();
            return;
        }
        boolean z2 = selectedChannel instanceof StoreChannelsSelected.ResolvedSelectedChannel.Channel;
        if (z2) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel;
            if (channel.getPeekParent() != null) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel.getChannel().getGuildId(), channel.getPeekParent().longValue(), null, null, 12, null);
                return;
            }
        }
        if (z2) {
            StoreChannelsSelected.ResolvedSelectedChannel.Channel channel2 = (StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel;
            if (ChannelUtils.m7675J(channel2.getChannel())) {
                if (selectedVoiceChannel == null || ChannelUtils.m7667B(selectedVoiceChannel) || selectedVoiceChannel.getId() != selectedChannel.getId()) {
                    WidgetCallPreviewFullscreen.Companion.launch$default(WidgetCallPreviewFullscreen.INSTANCE, requireContext(), channel2.getChannel().getId(), null, 4, null);
                    requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out);
                    return;
                } else {
                    WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), ((StoreChannelsSelected.ResolvedSelectedChannel.Channel) selectedChannel).getChannel().getId(), false, null, null, 28, null);
                    requireAppActivity().overridePendingTransition(C5419R.anim.activity_slide_horizontal_close_in, C5419R.anim.activity_slide_horizontal_close_out);
                    return;
                }
            }
        }
        getBinding().f17126c.openStartPanel();
    }

    public final void lockCloseRightPanel(boolean lock) {
        getBinding().f17126c.setEndPanelLockState(lock ? OverlappingPanelsLayout.LockState.CLOSE : OverlappingPanelsLayout.LockState.UNLOCKED);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LocaleProvider localeProvider = LocaleProvider.f1571b;
        C89481 c89481 = new C89481();
        Intrinsics3.checkParameterIsNotNull(c89481, "provider");
        LocaleProvider.f1570a = c89481;
    }

    @Override // p007b.p008a.p039o.PanelsChildGestureRegionObserver.a
    public void onGestureRegionsUpdate(List<Rect> gestureRegions) {
        Intrinsics3.checkNotNullParameter(gestureRegions, "gestureRegions");
        getBinding().f17126c.setChildGestureRegions(gestureRegions);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a = PanelsChildGestureRegionObserver.b.m232a();
        Intrinsics3.checkParameterIsNotNull(this, "gestureRegionsListener");
        panelsChildGestureRegionObserverM232a.f1575l.remove(this);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverM232a = PanelsChildGestureRegionObserver.b.m232a();
        Intrinsics3.checkParameterIsNotNull(this, "gestureRegionsListener");
        onGestureRegionsUpdate(_Collections.toList(panelsChildGestureRegionObserverM232a.f1573j.values()));
        panelsChildGestureRegionObserverM232a.f1575l.add(this);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        WidgetHomeModel widgetHomeModel$app_productionGoogleRelease = getViewModel().getWidgetHomeModel();
        if (widgetHomeModel$app_productionGoogleRelease != null) {
            WidgetHomeHeaderManager widgetHomeHeaderManager = WidgetHomeHeaderManager.INSTANCE;
            WidgetHomeBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            widgetHomeHeaderManager.configure(this, widgetHomeModel$app_productionGoogleRelease, binding);
        }
        if (getBinding().f17126c.getSelectedPanel() == OverlappingPanelsLayout.Panel.CENTER) {
            setActionBarTitleAccessibilityViewFocused();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        boolean z2 = TextUtils.getLayoutDirectionFromLocale(new LocaleManager().getPrimaryLocale(requireContext())) == 0;
        RoundedRelativeLayout roundedRelativeLayout = getBinding().f17129f.f1090b;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelRight.mainPanelRightRoundedContainer");
        ViewGroup.LayoutParams layoutParams = roundedRelativeLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = z2 ? marginLayoutParams.leftMargin : iDpToPixels;
        if (!z2) {
            iDpToPixels = marginLayoutParams.rightMargin;
        }
        marginLayoutParams.setMargins(i, marginLayoutParams.topMargin, iDpToPixels, marginLayoutParams.bottomMargin);
        RoundedRelativeLayout roundedRelativeLayout2 = getBinding().f17129f.f1090b;
        Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelRight.mainPanelRightRoundedContainer");
        roundedRelativeLayout2.setLayoutParams(marginLayoutParams);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.HOME, this);
        }
        this.panelNsfw = new WidgetHomePanelNsfw(this);
        WidgetHomeBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        this.panelLoading = new WidgetHomePanelLoading(binding);
        Function1<? super View, Unit> function1 = this.onGuildListAddHintCreate;
        TextView textView = getBinding().f17128e.f1036b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.panelLeft.guildListAddHint");
        function1.invoke(textView);
        AppFragment.setOnBackPressed$default(this, new C89491(), 0, 2, null);
        WidgetNoticeNuxSamsungLink.INSTANCE.enqueue(requireContext(), ClockFactory.get());
        setPanelWindowInsetsListeners();
        setupSmoothKeyboardReaction();
        Observable<StoreNux.NuxState> observableM11119z = StoreStream.INSTANCE.getNux().getNuxState().m11118y(new C89502()).m11119z();
        Intrinsics3.checkNotNullExpressionValue(observableM11119z, "StoreStream\n        .get…       }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11119z, 0L, false, 1, null), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89513(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        handleHomeConfig((HomeConfig) serializableExtra);
        WidgetHomePanelLoading widgetHomePanelLoading = this.panelLoading;
        if (widgetHomePanelLoading != null) {
            widgetHomePanelLoading.configure(this);
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89521(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89572(), 62, (Object) null);
        WidgetHomeModel.Companion companion = WidgetHomeModel.INSTANCE;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89583(), 62, (Object) null);
        Observable observableM11113s = ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null).m11113s(C89594.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11113s, "WidgetHomeModel\n        …lId == model2.channelId }");
        ObservableExtensionsKt.appSubscribe$default(observableM11113s, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89605(), 62, (Object) null);
        AccessibilityDetectionNavigator.INSTANCE.enqueueNoticeWhenEnabled(this);
        StoreStream.Companion companion2 = StoreStream.INSTANCE;
        configureNavigationDrawerAction(companion2.getNavigation());
        configureOverlappingPanels();
        Observable observableM11083G = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(SurveyUtils.INSTANCE.getSurveyToShow(), 0L, false, 3, null), this, null, 2, null).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11118y = observableM11083G.m11118y(C89616.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "SurveyUtils\n        .get…SurveyUtils.Survey.None }");
        ObservableExtensionsKt.appSubscribe$default(observableM11118y, WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89627(this), 62, (Object) null);
        Observable<StoreNux.NuxState> observableM11118y2 = companion2.getNux().getNuxState().m11118y(C89638.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y2, "StoreStream\n        .get… .filter { it.firstOpen }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11118y2, 0L, false, 1, null), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C89649(), 62, (Object) null);
        Observable observableM11118y3 = StoreUser.observeMe$default(companion2.getUsers(), false, 1, null).m11118y(C895310.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11118y3, "StoreStream\n        .get…hasUnreadUrgentMessages }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11118y3, this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C895411(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion2.getInteractions().observeModalCreate(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C895512(), 62, (Object) null);
        configureLeftPanel();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetHome.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C895613(this), 62, (Object) null);
    }

    public final void setOnGuildListAddHintCreate(Function1<? super View, Unit> onGuildListAddHintCreate) {
        Intrinsics3.checkNotNullParameter(onGuildListAddHintCreate, "onGuildListAddHintCreate");
        this.onGuildListAddHintCreate = onGuildListAddHintCreate;
    }
}
