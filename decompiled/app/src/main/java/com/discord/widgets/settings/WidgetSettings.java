package com.discord.widgets.settings;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.debugging.WidgetDebugging;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.SettingsViewModel;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.tabs.OnTabSelectedListener;
import com.discord.widgets.tabs.WidgetTabsHost;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.functions.Action2;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings extends AppFragment implements OnTabSelectedListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: viewModelUserProfileHeader$delegate, reason: from kotlin metadata */
    private final Lazy viewModelUserProfileHeader;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$configureToolbar$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final class C96101<T1, T2> implements Action2<MenuItem, Context> {
        public C96101() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_settings_debugging /* 2131364408 */:
                    WidgetDebugging.Companion companion = WidgetDebugging.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    companion.launch(context);
                    break;
                case C5419R.id.menu_settings_log_out /* 2131364409 */:
                    WidgetSettings widgetSettings = WidgetSettings.this;
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    WidgetSettings.access$showLogoutDialog(widgetSettings, context);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final /* synthetic */ class C96161 extends FunctionReferenceImpl implements Function1<SettingsViewModel.ViewState, Unit> {
        public C96161(WidgetSettings widgetSettings) {
            super(1, widgetSettings, WidgetSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/SettingsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetSettings.access$configureUI((WidgetSettings) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$showLogoutDialog$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final class C96171 extends Lambda implements Function1<View, Unit> {
        public static final C96171 INSTANCE = new C96171();

        public C96171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            StoreStream.INSTANCE.getAuthentication().logout();
        }
    }

    public WidgetSettings() {
        super(C5419R.layout.widget_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettings$binding$2.INSTANCE, null, 2, null);
        WidgetSettings$viewModel$2 widgetSettings$viewModel$2 = WidgetSettings$viewModel$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettings$viewModel$2));
        WidgetSettings$viewModelUserProfileHeader$2 widgetSettings$viewModelUserProfileHeader$2 = WidgetSettings$viewModelUserProfileHeader$2.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates32 = new AppViewModelDelegates3(this);
        this.viewModelUserProfileHeader = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(UserProfileHeaderViewModel.class), new WidgetSettings$appViewModels$$inlined$viewModels$2(appViewModelDelegates32), new AppViewModelDelegates5(widgetSettings$viewModelUserProfileHeader$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettings widgetSettings, SettingsViewModel.ViewState viewState) {
        widgetSettings.configureUI(viewState);
    }

    public static final /* synthetic */ SettingsViewModel access$getViewModel$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModel();
    }

    public static final /* synthetic */ UserProfileHeaderViewModel access$getViewModelUserProfileHeader$p(WidgetSettings widgetSettings) {
        return widgetSettings.getViewModelUserProfileHeader();
    }

    public static final /* synthetic */ void access$showLogoutDialog(WidgetSettings widgetSettings, Context context) {
        widgetSettings.showLogoutDialog(context);
    }

    private final void configureLoaded(SettingsViewModel.ViewState.Loaded model) {
        MeUser meUser = model.getMeUser();
        UserUtils userUtils = UserUtils.INSTANCE;
        boolean z2 = userUtils.isStaff(meUser);
        boolean zIsVerified = meUser.isVerified();
        boolean hasSubscription = userUtils.getHasSubscription(meUser);
        WidgetSettingsBinding binding = getBinding();
        View view = binding.f17904n;
        Intrinsics3.checkNotNullExpressionValue(view, "developerOptionsDivider");
        view.setVisibility(z2 ? 0 : 8);
        TextView textView = binding.f17905o;
        Intrinsics3.checkNotNullExpressionValue(textView, "developerOptionsHeader");
        textView.setVisibility(z2 ? 0 : 8);
        TextView textView2 = binding.f17903m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "developerOptions");
        textView2.setVisibility(z2 ? 0 : 8);
        binding.f17903m.setOnClickListener(WidgetSettings$configureLoaded$1$1.INSTANCE);
        LinearLayout linearLayout = binding.f17911u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "nitroSettingsContainer");
        linearLayout.setVisibility(zIsVerified ? 0 : 8);
        TextView textView3 = binding.f17882E;
        Intrinsics3.checkNotNullExpressionValue(textView3, "settingsNitro");
        textView3.setText(getString(hasSubscription ? C5419R.string.billing_manage_subscription : C5419R.string.premium_settings_subscribe_today));
        TextView textView4 = binding.f17907q;
        Intrinsics3.checkNotNullExpressionValue(textView4, "nitroBoosting");
        textView4.setText(getString(hasSubscription ? C5419R.string.premium_guild_perks_modal_manage_your_subscriptions : C5419R.string.premium_settings_premium_guild_subscriptions));
        Presence presence = model.getPresence();
        binding.f17884G.setPresence(presence);
        TextView textView5 = binding.f17883F;
        Intrinsics3.checkNotNullExpressionValue(textView5, "settingsPresenceText");
        textView5.setText(getString(PresenceUtils.INSTANCE.getStatusStringResForPresence(presence)));
        TextView textView6 = binding.f17880C;
        Intrinsics3.checkNotNullExpressionValue(textView6, "roleSubscriptions");
        textView6.setVisibility(model.getShowRoleSubscriptionsButton() ? 0 : 8);
        if (model.getPromoCount() > 0) {
            TextView textView7 = binding.f17908r;
            Intrinsics3.checkNotNullExpressionValue(textView7, "nitroGiftingBadge");
            textView7.setText(String.valueOf(model.getPromoCount()));
            TextView textView8 = binding.f17908r;
            Intrinsics3.checkNotNullExpressionValue(textView8, "nitroGiftingBadge");
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(new ShapeAppearanceModel.Builder().setAllCornerSizes(ShapeAppearanceModel.PILL).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(ContextCompat.getColor(requireContext(), C5419R.color.status_red_500)));
            textView8.setBackground(materialShapeDrawable);
            TextView textView9 = binding.f17908r;
            Intrinsics3.checkNotNullExpressionValue(textView9, "nitroGiftingBadge");
            textView9.setVisibility(0);
        } else {
            TextView textView10 = binding.f17908r;
            Intrinsics3.checkNotNullExpressionValue(textView10, "nitroGiftingBadge");
            textView10.setVisibility(8);
        }
        LinearLayout linearLayout2 = binding.f17912v;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "notificationUpsell");
        linearLayout2.setVisibility((NotificationManagerCompat.from(requireContext()).areNotificationsEnabled() || model.getPushNotificationUpsellDismissed()) ? false : true ? 0 : 8);
    }

    private final void configureToolbar() {
        AppFragment.bindToolbar$default(this, null, 1, null);
        setActionBarTitle(C5419R.string.user_settings);
        setActionBarTitleLayoutMinimumTappableArea();
        AppFragment.setActionBarOptionsMenu$default(this, C5419R.menu.menu_settings, new C96101(), null, 4, null);
    }

    private final void configureUI(SettingsViewModel.ViewState model) {
        Unit unit;
        if (model instanceof SettingsViewModel.ViewState.Uninitialized) {
            unit = Unit.f27425a;
        } else {
            if (!(model instanceof SettingsViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            configureLoaded((SettingsViewModel.ViewState.Loaded) model);
            unit = Unit.f27425a;
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final WidgetSettingsBinding getBinding() {
        return (WidgetSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsViewModel getViewModel() {
        return (SettingsViewModel) this.viewModel.getValue();
    }

    private final UserProfileHeaderViewModel getViewModelUserProfileHeader() {
        return (UserProfileHeaderViewModel) this.viewModelUserProfileHeader.getValue();
    }

    private final void showLogoutDialog(Context context) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(context).setTitle(C5419R.string.logout).setMessage(C5419R.string.user_settings_confirm_logout).setDialogAttrTheme(C5419R.attr.notice_theme_positive_red).setPositiveButton(C5419R.string.logout, C96171.INSTANCE), C5419R.string.cancel, (Function1) null, 2, (Object) null).show(parentFragmentManager);
    }

    @Override // com.discord.widgets.tabs.OnTabSelectedListener
    public void onTabSelected() {
        configureToolbar();
        setActionBarTitleAccessibilityViewFocused();
        getViewModel().refreshSubscriptions();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetTabsHost)) {
            parentFragment = null;
        }
        WidgetTabsHost widgetTabsHost = (WidgetTabsHost) parentFragment;
        if (widgetTabsHost != null) {
            widgetTabsHost.registerTabSelectionListener(NavigationTab.SETTINGS, this);
        }
        WidgetSettingsBinding binding = getBinding();
        binding.f17881D.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$1(this));
        UserProfileHeaderView userProfileHeaderView = binding.f17889L;
        Badge.Companion companion = Badge.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        userProfileHeaderView.setOnBadgeClick(companion.onBadgeClick(parentFragmentManager, requireContext()));
        binding.f17889L.setOnBannerPress(new WidgetSettings$onViewBound$$inlined$with$lambda$2(this));
        TextView textView = binding.f17896f;
        Intrinsics3.checkNotNullExpressionValue(textView, "appInfoHeader");
        textView.setText(getString(C5419R.string.app_information) + " - 126.21 - Stable (126021)");
        binding.f17879B.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$3(this));
        binding.f17911u.setOnClickListener(WidgetSettings$onViewBound$1$5.INSTANCE);
        binding.f17907q.setOnClickListener(WidgetSettings$onViewBound$1$6.INSTANCE);
        binding.f17880C.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$4(this));
        binding.f17909s.setOnClickListener(WidgetSettings$onViewBound$1$8.INSTANCE);
        binding.f17893c.setOnClickListener(WidgetSettings$onViewBound$1$9.INSTANCE);
        binding.f17878A.setOnClickListener(WidgetSettings$onViewBound$1$10.INSTANCE);
        binding.f17899i.setOnClickListener(WidgetSettings$onViewBound$1$11.INSTANCE);
        binding.f17916z.setOnClickListener(WidgetSettings$onViewBound$1$12.INSTANCE);
        binding.f17902l.setOnClickListener(WidgetSettings$onViewBound$1$13.INSTANCE);
        binding.f17898h.setOnClickListener(WidgetSettings$onViewBound$1$14.INSTANCE);
        binding.f17892b.setOnClickListener(WidgetSettings$onViewBound$1$15.INSTANCE);
        binding.f17900j.setOnClickListener(WidgetSettings$onViewBound$1$16.INSTANCE);
        binding.f17906p.setOnClickListener(WidgetSettings$onViewBound$1$17.INSTANCE);
        binding.f17895e.setOnClickListener(WidgetSettings$onViewBound$1$18.INSTANCE);
        binding.f17915y.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$5(this));
        binding.f17886I.setOnClickListener(WidgetSettings$onViewBound$1$20.INSTANCE);
        binding.f17890M.setOnClickListener(WidgetSettings$onViewBound$1$21.INSTANCE);
        binding.f17885H.setOnClickListener(WidgetSettings$onViewBound$1$22.INSTANCE);
        binding.f17887J.setOnClickListener(new WidgetSettings$onViewBound$$inlined$with$lambda$6(binding, this));
        binding.f17894d.setOnClickListener(WidgetSettings$onViewBound$1$24.INSTANCE);
        binding.f17901k.setOnClickListener(WidgetSettings$onViewBound$1$25.INSTANCE);
        binding.f17914x.setOnClickListener(WidgetSettings$onViewBound$1$26.INSTANCE);
        binding.f17913w.setOnClickListener(WidgetSettings$onViewBound$1$27.INSTANCE);
        for (TextView textView2 : Collections2.listOf((Object[]) new TextView[]{binding.f17888K, binding.f17910t, binding.f17897g, binding.f17905o, binding.f17896f})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f17889L;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModelUserProfileHeader().observeViewState());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96161(this), 62, (Object) null);
    }
}
