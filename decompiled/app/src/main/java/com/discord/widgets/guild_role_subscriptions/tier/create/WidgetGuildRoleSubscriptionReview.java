package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview extends AppFragment {
    public static final String ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE = "ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE";
    private GuildRoleSubscriptionTierAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: planSetupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planSetupViewModel;

    /* renamed from: reviewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy reviewViewModel;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionReview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0)};

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$1 */
    public static final class C84961 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$updateTier(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2 */
    public static final class C84972 extends Lambda implements Function1<GuildRoleSubscriptionReviewViewModel.ViewState, Unit> {
        public C84972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$configureUI(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionReview.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3 */
    public static final class C84983 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public C84983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.access$updatePlanDetails(WidgetGuildRoleSubscriptionReview.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionReview() {
        super(C5419R.layout.widget_guild_role_subscription_tier_review);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionReview2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionReview3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8491x34f01039(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionReview6.INSTANCE));
        WidgetGuildRoleSubscriptionReview5 widgetGuildRoleSubscriptionReview5 = new WidgetGuildRoleSubscriptionReview5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.reviewViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionReviewViewModel.class), new C8495x384a615b(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionReview5));
        this.planSetupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new C8493x34f0103b(this), new AppViewModelDelegates2(new WidgetGuildRoleSubscriptionReview4(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview) {
        return widgetGuildRoleSubscriptionReview.getGuildId();
    }

    public static final /* synthetic */ void access$updatePlanDetails(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.updatePlanDetails(viewState);
    }

    public static final /* synthetic */ void access$updateTier(WidgetGuildRoleSubscriptionReview widgetGuildRoleSubscriptionReview, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionReview.updateTier(viewState);
    }

    private final void configureUI(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildRoleSubscriptionTierAdapter.setItems(viewState.getItems());
    }

    private final WidgetGuildRoleSubscriptionTierReviewBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierReviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanSetupViewModel getPlanSetupViewModel() {
        return (GuildRoleSubscriptionPlanSetupViewModel) this.planSetupViewModel.getValue();
    }

    private final GuildRoleSubscriptionReviewViewModel getReviewViewModel() {
        return (GuildRoleSubscriptionReviewViewModel) this.reviewViewModel.getValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isPlanReviewMode() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, false);
        }
        return false;
    }

    private final void setupRecyclerView() throws Resources.NotFoundException {
        this.adapter = new GuildRoleSubscriptionTierAdapter(this, null, 2, null);
        GuildRoleSubscriptionTierItemDecoration guildRoleSubscriptionTierItemDecoration = new GuildRoleSubscriptionTierItemDecoration(DimenUtils.dpToPixels(8), getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_setup_default_padding));
        RecyclerView recyclerView = getBinding().f16973b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "this");
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView, guildRoleSubscriptionTierAdapter, 0, false, 12, null));
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter2 = this.adapter;
        if (guildRoleSubscriptionTierAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionTierAdapter2);
        recyclerView.addItemDecoration(guildRoleSubscriptionTierItemDecoration);
    }

    private final void updatePlanDetails(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        String planDescription = viewState.getPlanDescription();
        if (planDescription == null || StringsJVM.isBlank(planDescription)) {
            return;
        }
        String coverImage = viewState.getCoverImage();
        if (coverImage == null || StringsJVM.isBlank(coverImage)) {
            return;
        }
        getReviewViewModel().updatePlanDetails(viewState.getPlanDescription(), viewState.getCoverImage());
    }

    private final void updateTier(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String name = viewState.getGuildRoleSubscriptionTier().getName();
        if ((name == null || StringsJVM.isBlank(name)) || viewState.getGuildRoleSubscriptionTier().getMemberColor() == null || viewState.getGuildRoleSubscriptionTier().getPriceTier() == null) {
            return;
        }
        getReviewViewModel().updateTier(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84961(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getReviewViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84972(), 62, (Object) null);
        if (isPlanReviewMode()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getPlanSetupViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionReview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84983(), 62, (Object) null);
        }
    }
}
