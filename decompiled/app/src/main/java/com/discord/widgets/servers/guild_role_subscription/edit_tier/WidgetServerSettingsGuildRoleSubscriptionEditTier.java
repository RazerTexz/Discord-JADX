package com.discord.widgets.servers.guild_role_subscription.edit_tier;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.GuildRoleSubscriptionConfirmationDialog;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.ServerSettingsGuildRoleSubscriptionEditTierViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionEditTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsGuildRoleSubscriptionEditTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionEditTierBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID = "INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID";
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTIONS_EDIT_TIER_VIEW_FLIPPER_LOADED_STATE = 1;
    private static final int SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_EDIT_TIER_VIEW_FLIPPER_LOADING_STATE = 0;
    private static final int TIER_PAGE_SIZE = 3;
    private WidgetServerSettingsGuildRoleSubscriptionEditTier2 adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: guildRoleSubscriptionGroupListingId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleSubscriptionGroupListingId;

    /* renamed from: guildRoleSubscriptionTierListingId$delegate, reason: from kotlin metadata */
    private final Lazy guildRoleSubscriptionTierListingId;

    /* renamed from: tierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy tierViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptionEditTier.INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_GROUP_LISTING_ID, guildRoleSubscriptionGroupListingId);
            intent.putExtra(WidgetServerSettingsGuildRoleSubscriptionEditTier.INTENT_EXTRA_GUILD_ROLE_SUBSCRIPTION_TIER_LISTING_ID, guildRoleSubscriptionTierListingId);
            AppScreen2.d(context, WidgetServerSettingsGuildRoleSubscriptionEditTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).submitChanges();
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {

        /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
        /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).publishTier();
            }
        }

        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildRoleSubscriptionConfirmationDialog.Companion companion = GuildRoleSubscriptionConfirmationDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String string = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_publish_tier_dialog_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.guild…ublish_tier_dialog_title)");
            String string2 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_publish_tier_dialog_description);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.guild…_tier_dialog_description)");
            String string3 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_publish_tier_cta);
            Intrinsics3.checkNotNullExpressionValue(string3, "getString(R.string.guild…ription_publish_tier_cta)");
            companion.show(parentFragmentManager, string, string2, string3, false, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {

        /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
        /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBound$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).deleteTier();
            }
        }

        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildRoleSubscriptionConfirmationDialog.Companion companion = GuildRoleSubscriptionConfirmationDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            String string = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_tier_delete_confirmation_title);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.guild…elete_confirmation_title)");
            String string2 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_tier_delete_confirmation_title);
            Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.guild…elete_confirmation_title)");
            String string3 = WidgetServerSettingsGuildRoleSubscriptionEditTier.this.getString(R.string.guild_role_subscription_tier_delete_cta);
            Intrinsics3.checkNotNullExpressionValue(string3, "getString(R.string.guild…cription_tier_delete_cta)");
            companion.show(parentFragmentManager, string, string2, string3, true, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier = WidgetServerSettingsGuildRoleSubscriptionEditTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsGuildRoleSubscriptionEditTier.access$configureUI(widgetServerSettingsGuildRoleSubscriptionEditTier, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).onTierUpdated(viewState.getGuildRoleSubscriptionTier());
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsGuildRoleSubscriptionEditTier.access$handleEvents(WidgetServerSettingsGuildRoleSubscriptionEditTier.this, event);
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "tab");
            tab.setText(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).getTabStringResId(i));
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionEditTier.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier$setupAdapter$2, reason: invalid class name */
    public static final class AnonymousClass2 implements TabLayout.OnTabSelectedListener {
        public AnonymousClass2() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab != null) {
                int position = tab.getPosition();
                MaterialButton materialButton = WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getBinding$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).f;
                Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.serverSettingsGu…ubscriptionEditTierDelete");
                materialButton.setVisibility(WidgetServerSettingsGuildRoleSubscriptionEditTier.access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier.this).isDetailsTab(position) ? 0 : 8);
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptionEditTier() {
        super(R.layout.widget_server_settings_guild_role_subscription_edit_tier);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionEditTier3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier4(this));
        this.guildRoleSubscriptionGroupListingId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier5(this));
        this.guildRoleSubscriptionTierListingId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptionEditTier6(this));
        WidgetServerSettingsGuildRoleSubscriptionEditTier8 widgetServerSettingsGuildRoleSubscriptionEditTier8 = new WidgetServerSettingsGuildRoleSubscriptionEditTier8(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionEditTierViewModel.class), new WidgetServerSettingsGuildRoleSubscriptionEditTier$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsGuildRoleSubscriptionEditTier8));
        this.tierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetServerSettingsGuildRoleSubscriptionEditTier$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsGuildRoleSubscriptionEditTier7.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTier2 access$getAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        WidgetServerSettingsGuildRoleSubscriptionEditTier2 widgetServerSettingsGuildRoleSubscriptionEditTier2 = widgetServerSettingsGuildRoleSubscriptionEditTier.adapter;
        if (widgetServerSettingsGuildRoleSubscriptionEditTier2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetServerSettingsGuildRoleSubscriptionEditTier2;
    }

    public static final /* synthetic */ WidgetServerSettingsGuildRoleSubscriptionEditTierBinding access$getBinding$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildId();
    }

    public static final /* synthetic */ long access$getGuildRoleSubscriptionGroupListingId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildRoleSubscriptionGroupListingId();
    }

    public static final /* synthetic */ long access$getGuildRoleSubscriptionTierListingId$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getGuildRoleSubscriptionTierListingId();
    }

    public static final /* synthetic */ ServerSettingsGuildRoleSubscriptionEditTierViewModel access$getViewModel$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier) {
        return widgetServerSettingsGuildRoleSubscriptionEditTier.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.handleEvents(event);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetServerSettingsGuildRoleSubscriptionEditTier widgetServerSettingsGuildRoleSubscriptionEditTier, WidgetServerSettingsGuildRoleSubscriptionEditTier2 widgetServerSettingsGuildRoleSubscriptionEditTier2) {
        widgetServerSettingsGuildRoleSubscriptionEditTier.adapter = widgetServerSettingsGuildRoleSubscriptionEditTier2;
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loading.INSTANCE)) {
            AppViewFlipper appViewFlipper = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionEditTierViewFlipper");
            appViewFlipper.setDisplayedChild(0);
            return;
        }
        if (!(viewState instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded)) {
            if (Intrinsics3.areEqual(viewState, ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Failed.INSTANCE)) {
                AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
                requireActivity().finish();
                return;
            }
            return;
        }
        FloatingActionButton floatingActionButton = getBinding().g;
        ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded loaded = (ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState.Loaded) viewState;
        floatingActionButton.setVisibility(loaded.getHasChanges() ? 0 : 8);
        floatingActionButton.setEnabled(!loaded.isSubmitting());
        AppViewFlipper appViewFlipper2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsGu…iptionEditTierViewFlipper");
        appViewFlipper2.setDisplayedChild(1);
        Group group = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(group, "binding.guildRoleSubscriptionEditTierPublishGroup");
        group.setVisibility(loaded.isPublished() ^ true ? 0 : 8);
        setActionBarTitle(loaded.getTierName());
    }

    private final WidgetServerSettingsGuildRoleSubscriptionEditTierBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionEditTierBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildRoleSubscriptionGroupListingId() {
        return ((Number) this.guildRoleSubscriptionGroupListingId.getValue()).longValue();
    }

    private final long getGuildRoleSubscriptionTierListingId() {
        return ((Number) this.guildRoleSubscriptionTierListingId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionTierViewModel getTierViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.tierViewModel.getValue();
    }

    private final ServerSettingsGuildRoleSubscriptionEditTierViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionEditTierViewModel) this.viewModel.getValue();
    }

    private final void handleError(Error error) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        error.showToasts(requireContext());
    }

    private final void handleEvents(ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event event) {
        if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate) {
            ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate storedStateUpdate = (ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.StoredStateUpdate) event;
            getTierViewModel().setTier(storedStateUpdate.getGuildRoleSubscriptionTier());
            getTierViewModel().setFullServerGating(storedStateUpdate.isFullServerGating());
        } else {
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitSuccess) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.SubmitFailure) event).getError());
                return;
            }
            if (event instanceof ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteFailure) {
                handleError(((ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteFailure) event).getError());
            } else if (Intrinsics3.areEqual(event, ServerSettingsGuildRoleSubscriptionEditTierViewModel.Event.DeleteSuccess.INSTANCE)) {
                AppFragment.hideKeyboard$default(this, null, 1, null);
                requireActivity().finish();
            }
        }
    }

    private final void setupAdapter() {
        WidgetServerSettingsGuildRoleSubscriptionEditTier2 widgetServerSettingsGuildRoleSubscriptionEditTier2 = new WidgetServerSettingsGuildRoleSubscriptionEditTier2(this, getGuildId());
        this.adapter = widgetServerSettingsGuildRoleSubscriptionEditTier2;
        if (widgetServerSettingsGuildRoleSubscriptionEditTier2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetServerSettingsGuildRoleSubscriptionEditTier2.setPageSize(3);
        ViewPager2 viewPager2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.guildRoleSubscriptionEditTierViewPager");
        WidgetServerSettingsGuildRoleSubscriptionEditTier2 widgetServerSettingsGuildRoleSubscriptionEditTier22 = this.adapter;
        if (widgetServerSettingsGuildRoleSubscriptionEditTier22 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager2.setAdapter(widgetServerSettingsGuildRoleSubscriptionEditTier22);
        TabLayout tabLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.guildRoleSubscriptionEditTierTabs");
        ViewPager2 viewPager22 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager22, "binding.guildRoleSubscriptionEditTierViewPager");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager22, new AnonymousClass1());
        getBinding().d.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarSubtitle(R.string.guild_settings_role_subscription_tier_edit_subtitle);
        getBinding().g.setOnClickListener(new AnonymousClass1());
        getBinding().f2569b.setOnClickListener(new AnonymousClass2());
        getBinding().f.setOnClickListener(new AnonymousClass3());
        setupAdapter();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsGuildRoleSubscriptionEditTierViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR2 = getTierViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "tierViewModel\n        .o…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionEditTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
