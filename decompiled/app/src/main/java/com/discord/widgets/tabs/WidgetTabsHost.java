package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTabsHostBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState;
import com.discord.widgets.tabs.TabsHostViewModel;
import com.discord.widgets.user.WidgetUserStatusSheet;
import com.discord.widgets.user.search.WidgetGlobalSearchDialog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func0;

/* compiled from: WidgetTabsHost.kt */
/* loaded from: classes.dex */
public final class WidgetTabsHost extends AppFragment {
    private static final long BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS = 200;
    private static final long BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS = 250;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private ValueAnimator bottomNavAnimator;
    private final WidgetGlobalStatusIndicatorState globalStatusIndicatorStateObserver;
    private int previousBottomNavHeight;
    private Boolean previousShowBottomNav;
    private final Map<NavigationTab, OnTabSelectedListener> tabToTabSelectionListenerMap;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private TabsHostViewModel.ViewState viewState;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetTabsHost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTabsHostBinding;", 0)};

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$configureSystemStatusBar$1 */
    public static final class C101571 extends Lambda implements Function1<WidgetGlobalStatusIndicatorState.State, Unit> {
        public final /* synthetic */ int $defaultStatusBarColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C101571(int i) {
            super(1);
            this.$defaultStatusBarColor = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState.State state) {
            invoke2(state);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalStatusIndicatorState.State state) {
            Intrinsics3.checkNotNullParameter(state, "state");
            WidgetTabsHost.access$setPanelWindowInsetsListeners(WidgetTabsHost.this, state.isVisible());
            int color = ColorCompat.getColor(WidgetTabsHost.this, C5419R.color.transparent);
            if (!state.isVisible()) {
                color = this.$defaultStatusBarColor;
            }
            ColorCompat.setStatusBarColor$default((Fragment) WidgetTabsHost.this, color, false, 4, (Object) null);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBound$1 */
    public static final class C101581<R> implements Func0<Boolean> {
        public C101581() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            return Boolean.valueOf(WidgetTabsHost.access$getViewModel$p(WidgetTabsHost.this).handleBackPress());
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$1 */
    public static final class C101591 extends Lambda implements Function1<TabsHostViewModel.ViewState, Unit> {
        public C101591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.ViewState viewState) {
            WidgetTabsHost widgetTabsHost = WidgetTabsHost.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetTabsHost.access$updateViews(widgetTabsHost, viewState);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$onViewBoundOrOnResume$2 */
    public static final /* synthetic */ class C101602 extends FunctionReferenceImpl implements Function1<TabsHostViewModel.Event, Unit> {
        public C101602(WidgetTabsHost widgetTabsHost) {
            super(1, widgetTabsHost, WidgetTabsHost.class, "handleEvent", "handleEvent(Lcom/discord/widgets/tabs/TabsHostViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TabsHostViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TabsHostViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetTabsHost.access$handleEvent((WidgetTabsHost) this.receiver, event);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$1 */
    public static final class C101611 implements OnApplyWindowInsetsListener {
        public static final C101611 INSTANCE = new C101611();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Sequence<View> children;
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), view.getPaddingTop(), windowInsetsCompat.getSystemWindowInsetRight(), view.getPaddingBottom());
            WindowInsetsCompat windowInsetsCompatBuild = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m82of(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, windowInsetsCompat.getSystemWindowInsetBottom())).build();
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatBuild, "WindowInsetsCompat.Build…        )\n      ).build()");
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                Iterator<View> it = children.iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompatBuild);
                }
            }
            return windowInsetsCompatBuild;
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$2 */
    public static final class C101622 implements OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean $isCallStatusVisible;

        public C101622(boolean z2) {
            this.$isCallStatusVisible = z2;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Sequence<View> children;
            Intrinsics3.checkNotNullParameter(view, "view");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.$isCallStatusVisible) {
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            } else {
                view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
                windowInsetsCompat = new WindowInsetsCompat.Builder().setSystemWindowInsets(Insets.m82of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "WindowInsetsCompat.Build…      )\n        ).build()");
            }
            if (!(view instanceof ViewGroup)) {
                view = null;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup != null && (children = androidx.core.view.ViewGroup.getChildren(viewGroup)) != null) {
                Iterator<View> it = children.iterator();
                while (it.hasNext()) {
                    ViewCompat.dispatchApplyWindowInsets(it.next(), windowInsetsCompat);
                }
            }
            return windowInsetsCompat;
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$3 */
    public static final class C101633 implements OnApplyWindowInsetsListener {
        public final /* synthetic */ boolean $isCallStatusVisible;

        public C101633(boolean z2) {
            this.$isCallStatusVisible = z2;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            int systemWindowInsetTop;
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            if (this.$isCallStatusVisible) {
                systemWindowInsetTop = 0;
            } else {
                Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
                systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
            }
            view.setPadding(view.getPaddingLeft(), systemWindowInsetTop, view.getPaddingRight(), view.getPaddingBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$setPanelWindowInsetsListeners$4 */
    public static final class C101644 implements OnApplyWindowInsetsListener {
        public static final C101644 INSTANCE = new C101644();

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Intrinsics3.checkNotNullExpressionValue(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
            return windowInsetsCompat.consumeSystemWindowInsets();
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$1 */
    public static final /* synthetic */ class C101651 extends FunctionReferenceImpl implements Function1<NavigationTab, Unit> {
        public C101651(TabsHostViewModel tabsHostViewModel) {
            super(1, tabsHostViewModel, TabsHostViewModel.class, "selectTab", "selectTab(Lcom/discord/widgets/tabs/NavigationTab;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NavigationTab navigationTab) {
            invoke2(navigationTab);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NavigationTab navigationTab) {
            Intrinsics3.checkNotNullParameter(navigationTab, "p1");
            ((TabsHostViewModel) this.receiver).selectTab(navigationTab);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$2 */
    public static final /* synthetic */ class C101662 extends FunctionReferenceImpl implements Function0<Unit> {
        public C101662(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSearchClick((WidgetTabsHost) this.receiver);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$3 */
    public static final /* synthetic */ class C101673 extends FunctionReferenceImpl implements Function0<Unit> {
        public C101673(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSettingsLongPress", "onSettingsLongPress()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSettingsLongPress((WidgetTabsHost) this.receiver);
        }
    }

    /* compiled from: WidgetTabsHost.kt */
    /* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$4 */
    public static final /* synthetic */ class C101684 extends FunctionReferenceImpl implements Function0<Unit> {
        public C101684(WidgetTabsHost widgetTabsHost) {
            super(0, widgetTabsHost, WidgetTabsHost.class, "onSearchClick", "onSearchClick()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTabsHost.access$onSearchClick((WidgetTabsHost) this.receiver);
        }
    }

    public WidgetTabsHost() {
        super(C5419R.layout.widget_tabs_host);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTabsHost2.INSTANCE, null, 2, null);
        this.tabToTabSelectionListenerMap = new LinkedHashMap();
        this.globalStatusIndicatorStateObserver = WidgetGlobalStatusIndicatorState.INSTANCE.get();
        WidgetTabsHost5 widgetTabsHost5 = WidgetTabsHost5.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(TabsHostViewModel.class), new WidgetTabsHost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTabsHost5));
    }

    public static final /* synthetic */ WidgetTabsHostBinding access$getBinding$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getBinding();
    }

    public static final /* synthetic */ TabsHostViewModel access$getViewModel$p(WidgetTabsHost widgetTabsHost) {
        return widgetTabsHost.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetTabsHost widgetTabsHost, TabsHostViewModel.Event event) {
        widgetTabsHost.handleEvent(event);
    }

    public static final /* synthetic */ void access$onSearchClick(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSearchClick();
    }

    public static final /* synthetic */ void access$onSettingsLongPress(WidgetTabsHost widgetTabsHost) {
        widgetTabsHost.onSettingsLongPress();
    }

    public static final /* synthetic */ void access$setPanelWindowInsetsListeners(WidgetTabsHost widgetTabsHost, boolean z2) {
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    public static final /* synthetic */ void access$updateViews(WidgetTabsHost widgetTabsHost, TabsHostViewModel.ViewState viewState) {
        widgetTabsHost.updateViews(viewState);
    }

    private final void configureSystemStatusBar() {
        int themedColor = ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundTertiary);
        ColorCompat.setStatusBarColor$default((Fragment) this, themedColor, false, 4, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(this.globalStatusIndicatorStateObserver.observeState(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101571(themedColor), 62, (Object) null);
    }

    private final WidgetTabsHostBinding getBinding() {
        return (WidgetTabsHostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final TabsHostViewModel getViewModel() {
        return (TabsHostViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(TabsHostViewModel.Event event) {
        if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.TrackFriendsListShown.INSTANCE)) {
            handleFriendsListShown();
        } else if (Intrinsics3.areEqual(event, TabsHostViewModel.Event.DismissSearchDialog.INSTANCE)) {
            WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.dismiss(parentFragmentManager);
        }
    }

    private final void handleFriendsListShown() {
        AnalyticsTracker.INSTANCE.friendsListViewed();
    }

    private final void navigateToTab(NavigationTab navigationTab) {
        FragmentContainerView fragmentContainerView = getBinding().f18222e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetTabsHostHome");
        fragmentContainerView.setVisibility(navigationTab == NavigationTab.HOME ? 0 : 8);
        FragmentContainerView fragmentContainerView2 = getBinding().f18221d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetTabsHostFriends");
        fragmentContainerView2.setVisibility(navigationTab == NavigationTab.FRIENDS ? 0 : 8);
        FragmentContainerView fragmentContainerView3 = getBinding().f18223f;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetTabsHostMentions");
        fragmentContainerView3.setVisibility(navigationTab == NavigationTab.MENTIONS ? 0 : 8);
        FragmentContainerView fragmentContainerView4 = getBinding().f18226i;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetTabsHostUserSettings");
        fragmentContainerView4.setVisibility(navigationTab == NavigationTab.SETTINGS ? 0 : 8);
        OnTabSelectedListener onTabSelectedListener = this.tabToTabSelectionListenerMap.get(navigationTab);
        if (onTabSelectedListener != null) {
            onTabSelectedListener.onTabSelected();
        }
    }

    private final void onSearchClick() {
        WidgetGlobalSearchDialog.Companion companion = WidgetGlobalSearchDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetGlobalSearchDialog.Companion.show$default(companion, parentFragmentManager, null, 2, null);
    }

    private final void onSettingsLongPress() {
        WidgetUserStatusSheet.INSTANCE.show(this);
    }

    private final void setPanelWindowInsetsListeners(boolean isCallStatusVisible) {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18220c, C101611.INSTANCE);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18222e, new C101622(isCallStatusVisible));
        FrameLayout frameLayout = getBinding().f18224g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewExtensions.setForwardingWindowInsetsListener(frameLayout);
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18225h, new C101633(isCallStatusVisible));
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18219b, C101644.INSTANCE);
        getBinding().f18220c.requestApplyInsets();
    }

    public static /* synthetic */ void setPanelWindowInsetsListeners$default(WidgetTabsHost widgetTabsHost, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetTabsHost.setPanelWindowInsetsListeners(z2);
    }

    private final void updateNavHostMargins(TabsHostViewModel.ViewState viewState) {
        NavigationTab selectedTab = viewState.getSelectedTab();
        FrameLayout frameLayout = getBinding().f18224g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.widgetTabsHostNavHost");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, selectedTab == NavigationTab.HOME ? 0 : viewState.getBottomNavHeight());
        FrameLayout frameLayout2 = getBinding().f18224g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.widgetTabsHostNavHost");
        frameLayout2.setLayoutParams(marginLayoutParams);
    }

    private final void updateViews(TabsHostViewModel.ViewState viewState) {
        this.viewState = viewState;
        NavigationTab selectedTab = viewState.getSelectedTab();
        boolean showBottomNav = viewState.getShowBottomNav();
        int bottomNavHeight = viewState.getBottomNavHeight();
        navigateToTab(selectedTab);
        getBinding().f18219b.updateView(selectedTab, new C101651(getViewModel()), showBottomNav, viewState.getMyUserId(), viewState.getVisibleTabs(), viewState.getNumHomeNotifications(), viewState.getNumFriendsNotifications(), new C101662(this), new C101673(this), new C101684(this));
        updateNavHostMargins(viewState);
        boolean z2 = !Intrinsics3.areEqual(Boolean.valueOf(showBottomNav), this.previousShowBottomNav);
        boolean z3 = bottomNavHeight != this.previousBottomNavHeight;
        if (z2 || z3) {
            ValueAnimator valueAnimator = this.bottomNavAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            TabsHostBottomNavigationView tabsHostBottomNavigationView = getBinding().f18219b;
            Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
            float translationY = tabsHostBottomNavigationView.getTranslationY();
            if (showBottomNav) {
                TabsHostBottomNavigationView tabsHostBottomNavigationView2 = getBinding().f18219b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView2, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView2.setVisibility(0);
                ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(translationY, 0.0f);
                valueAnimatorOfFloat.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat.setDuration(BOTTOM_TABS_UPWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat.addUpdateListener(new WidgetTabsHost3(this));
                valueAnimatorOfFloat.start();
                this.bottomNavAnimator = valueAnimatorOfFloat;
            } else if (bottomNavHeight > 0) {
                ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(translationY, bottomNavHeight);
                valueAnimatorOfFloat2.setInterpolator(new FastOutSlowInInterpolator());
                valueAnimatorOfFloat2.setDuration(BOTTOM_TABS_DOWNWARD_ANIMATION_DURATION_MS);
                valueAnimatorOfFloat2.addUpdateListener(new WidgetTabsHost4(this));
                valueAnimatorOfFloat2.start();
                this.bottomNavAnimator = valueAnimatorOfFloat2;
            } else {
                TabsHostBottomNavigationView tabsHostBottomNavigationView3 = getBinding().f18219b;
                Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView3, "binding.widgetTabsHostBottomNavigationView");
                tabsHostBottomNavigationView3.setVisibility(4);
            }
        }
        this.previousBottomNavHeight = bottomNavHeight;
        this.previousShowBottomNav = Boolean.valueOf(showBottomNav);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        ValueAnimator valueAnimator = this.bottomNavAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        super.onDestroyView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f18219b.addHeightChangedListener(BottomNavViewObserver.INSTANCE.getINSTANCE());
        setPanelWindowInsetsListeners$default(this, false, 1, null);
        AppFragment.setOnBackPressed$default(this, new C101581(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<TabsHostViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101591(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetTabsHost.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101602(this), 62, (Object) null);
        configureSystemStatusBar();
    }

    public final void registerTabSelectionListener(NavigationTab navigationTab, OnTabSelectedListener onTabSelectedListener) {
        Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
        Intrinsics3.checkNotNullParameter(onTabSelectedListener, "onTabSelectedListener");
        this.tabToTabSelectionListenerMap.put(navigationTab, onTabSelectedListener);
        TabsHostViewModel.ViewState viewState = this.viewState;
        NavigationTab selectedTab = viewState != null ? viewState.getSelectedTab() : null;
        if (selectedTab != null) {
            navigateToTab(selectedTab);
        }
    }
}
