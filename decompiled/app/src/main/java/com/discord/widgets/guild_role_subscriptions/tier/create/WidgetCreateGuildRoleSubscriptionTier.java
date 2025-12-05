package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p062y.p069p0.StepsView2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.functions.Func0;

/* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCreateGuildRoleSubscriptionTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GROUP_LISTING_ID = "INTENT_EXTRA_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: createTierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy createTierViewModel;

    /* renamed from: groupListingId$delegate, reason: from kotlin metadata */
    private final Lazy groupListingId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, long groupListingId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetCreateGuildRoleSubscriptionTier.INTENT_EXTRA_GROUP_LISTING_ID, groupListingId);
            AppScreen2.m156d(context, WidgetCreateGuildRoleSubscriptionTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBound$2 */
    public static final class C84872<R> implements Func0<Boolean> {
        public C84872() {
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }

        @Override // p658rx.functions.Func0, java.util.concurrent.Callable
        public final Boolean call() {
            WidgetCreateGuildRoleSubscriptionTier.access$getCreateTierViewModel$p(WidgetCreateGuildRoleSubscriptionTier.this).goToPreviousStep();
            return Boolean.TRUE;
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$1 */
    public static final class C84881 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84881() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            WidgetCreateGuildRoleSubscriptionTier.access$updateCreateTierViewModel(widgetCreateGuildRoleSubscriptionTier, viewState);
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$2 */
    public static final class C84892 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetCreateGuildRoleSubscriptionTier.access$configureUI(widgetCreateGuildRoleSubscriptionTier, viewState);
        }
    }

    /* compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3 */
    public static final class C84903 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.Event, Unit> {
        public C84903() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(event, "it");
            WidgetCreateGuildRoleSubscriptionTier.access$handleEvent(widgetCreateGuildRoleSubscriptionTier, event);
        }
    }

    public WidgetCreateGuildRoleSubscriptionTier() {
        super(C5419R.layout.widget_create_guild_role_subscription_tier);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateGuildRoleSubscriptionTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$guildId$2(this));
        this.groupListingId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$groupListingId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8482x761ac5a7(this), new AppViewModelDelegates2(WidgetCreateGuildRoleSubscriptionTier$viewModel$2.INSTANCE));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(CreateGuildRoleSubscriptionTierViewModel.class), new C8484x761ac5a9(this), new AppViewModelDelegates2(new WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetCreateGuildRoleSubscriptionTier.configureUI(viewState);
    }

    public static final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel access$getCreateTierViewModel$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getCreateTierViewModel();
    }

    public static final /* synthetic */ long access$getGroupListingId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGroupListingId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGuildId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel.Event event) {
        widgetCreateGuildRoleSubscriptionTier.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateCreateTierViewModel(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        widgetCreateGuildRoleSubscriptionTier.updateCreateTierViewModel(viewState);
    }

    private final void configureUI(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
        int currentStep = viewState.getCurrentStep();
        if (currentStep < 0) {
            requireActivity().finish();
            return;
        }
        getBinding().f16440b.m8610b(currentStep);
        getBinding().f16440b.setIsNextButtonEnabled(viewState.getCanProceed());
        getBinding().f16440b.setIsDoneButtonEnabled(!viewState.isSubmitting());
        getBinding().f16440b.setIsLoading(viewState.isSubmitting());
    }

    private final WidgetCreateGuildRoleSubscriptionTierBinding getBinding() {
        return (WidgetCreateGuildRoleSubscriptionTierBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CreateGuildRoleSubscriptionTierViewModel getCreateTierViewModel() {
        return (CreateGuildRoleSubscriptionTierViewModel) this.createTierViewModel.getValue();
    }

    private final long getGroupListingId() {
        return ((Number) this.groupListingId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(CreateGuildRoleSubscriptionTierViewModel.Event event) {
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitSuccess) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) {
            ((CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) event).getError().showToasts(requireContext());
        } else if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) {
            getViewModel().setFullServerGating(((CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) event).isFullServerGating());
        }
    }

    public static final void launch(Context context, long j, long j2) {
        INSTANCE.launch(context, j, j2);
    }

    private final void updateCreateTierViewModel(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        getCreateTierViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = Collections2.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDetails.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$2(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$3(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDesign.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$4(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, C5419R.string.guild_role_subscription_plan_finish, Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId()))), null, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$5(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f16440b;
        StepsView.C7125d c7125d = new StepsView.C7125d(this, listListOf);
        C8486x4ace8fa1 c8486x4ace8fa1 = new C8486x4ace8fa1(this, listListOf);
        int i = StepsView.f19295j;
        stepsView.m8609a(c7125d, c8486x4ace8fa1, StepsView2.f2064j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new C84872(), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84881(), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel.ViewState> observableM11112r2 = getCreateTierViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r2, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r2, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84892(), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel.Event> observableM11112r3 = getCreateTierViewModel().observeEvents().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r3, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r3, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84903(), 62, (Object) null);
    }
}
