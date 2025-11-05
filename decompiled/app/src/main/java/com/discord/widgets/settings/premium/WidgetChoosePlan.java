package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.c;
import b.a.a.b.a;
import b.a.a.b.b;
import b.a.a.b.f;
import b.a.a.b.g;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChoosePlanBinding;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.premium.ChoosePlanViewModel;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetChoosePlan.kt */
/* loaded from: classes2.dex */
public final class WidgetChoosePlan extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChoosePlan.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChoosePlanBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String RESULT_EXTRA_LOCATION_TRAIT = "result_extra_location_trait";
    public static final String RESULT_EXTRA_OLD_SKU_NAME = "result_extra_current_sku_name";
    public static final String RESULT_VIEW_TYPE = "result_view_type";
    private WidgetChoosePlanAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private LinearLayoutManager planLayoutManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChoosePlan.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ActivityResultLauncher activityResultLauncher, ViewType viewType, String str, Traits.Location location, Traits.Subscription subscription, int i, Object obj) {
            companion.launch(context, (i & 2) != 0 ? null : activityResultLauncher, viewType, (i & 8) != 0 ? null : str, location, (i & 32) != 0 ? null : subscription);
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, ViewType viewType, String oldSkuName, Traits.Location locationTrait, Traits.Subscription subscriptionTrait) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(viewType, "viewType");
            m.checkNotNullParameter(locationTrait, "locationTrait");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME, oldSkuName);
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_LOCATION_TRAIT, locationTrait);
            intent.putExtra(WidgetChoosePlan.RESULT_VIEW_TYPE, viewType);
            AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionTrait, null, null, 12, null);
            if (launcher != null) {
                j.g.f(context, launcher, WidgetChoosePlan.class, intent);
            } else {
                j.d(context, WidgetChoosePlan.class, intent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, Function0<Unit> callback) {
            m.checkNotNullParameter(fragment, "fragment");
            m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new WidgetChoosePlan$Companion$registerForResult$1(callback));
            m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChoosePlan.kt */
    public enum ViewType {
        BUY_PREMIUM_TIER_2,
        BUY_PREMIUM_TIER_1,
        BUY_PREMIUM_GUILD,
        SWITCH_PLANS
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GooglePlaySku.Type.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1.ordinal()] = 1;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2.ordinal()] = 2;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 3;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 4;
            iArr[GooglePlaySku.Type.PREMIUM_GUILD.ordinal()] = 5;
        }
    }

    /* compiled from: WidgetChoosePlan.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<ChoosePlanViewModel.Event, Unit> {
        public AnonymousClass1(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.Event event) {
            m.checkNotNullParameter(event, "p1");
            WidgetChoosePlan.access$handleEvent((WidgetChoosePlan) this.receiver, event);
        }
    }

    /* compiled from: WidgetChoosePlan.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends d0.z.d.a implements Function1<ChoosePlanViewModel.ViewState, Unit> {
        public AnonymousClass2(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$ViewState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetChoosePlan.access$configureUI((WidgetChoosePlan) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetChoosePlan.kt */
    /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
        public final /* synthetic */ Traits.Location $locationTrait;

        /* compiled from: WidgetChoosePlan.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.access$getViewModel$p(WidgetChoosePlan.this).buy(this.$sku, this.$oldSkuName, AnonymousClass2.this.$locationTrait, "premium_upsell");
            }
        }

        /* compiled from: WidgetChoosePlan.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C04582 extends o implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04582(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Traits.Location location = new Traits.Location("Premium Upsell Modal", "Premium Upsell Modal", null, null, null, 28, null);
                AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, location, Traits.Subscription.INSTANCE.withGatewayPlanId(this.$sku.getUpgrade().getSkuName()), null, null, 12, null);
                WidgetChoosePlan.access$getViewModel$p(WidgetChoosePlan.this).buy(this.$sku.getUpgrade(), this.$oldSkuName, location, "premium_upsell");
            }
        }

        /* compiled from: WidgetChoosePlan.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.access$getViewModel$p(WidgetChoosePlan.this).buy(this.$sku, this.$oldSkuName, AnonymousClass2.this.$locationTrait, "yearly_upsell");
            }
        }

        /* compiled from: WidgetChoosePlan.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$4, reason: invalid class name */
        public static final class AnonymousClass4 extends o implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Traits.Location location = new Traits.Location("Yearly Upsell Modal", "Yearly Upsell Modal", null, null, null, 28, null);
                AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, location, Traits.Subscription.INSTANCE.withGatewayPlanId(this.$sku.getUpgrade().getSkuName()), null, null, 12, null);
                WidgetChoosePlan.access$getViewModel$p(WidgetChoosePlan.this).buy(this.$sku.getUpgrade(), this.$oldSkuName, location, "yearly_upsell");
            }
        }

        /* compiled from: WidgetChoosePlan.kt */
        /* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$5, reason: invalid class name */
        public static final class AnonymousClass5 extends o implements Function0<Unit> {
            public AnonymousClass5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.upgradePremiumYearlyClosed(AnonymousClass2.this.$locationTrait);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Traits.Location location) {
            super(3);
            this.$locationTrait = location;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            invoke2(googlePlaySku, str, skuDetails);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            m.checkNotNullParameter(googlePlaySku, "sku");
            if (googlePlaySku.getUpgrade() != null && skuDetails != null && googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_GUILD) {
                AnalyticsTracker.paymentFlowStep$default(AnalyticsTracker.INSTANCE, this.$locationTrait, Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "premium_upsell", "plan_select", null, null, 48, null);
                a.Companion bVar = b.a.a.b.a.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChoosePlan.this.getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(googlePlaySku, str);
                C04582 c04582 = new C04582(googlePlaySku, str);
                String strB = skuDetails.b();
                m.checkNotNullExpressionValue(strB, "upgradeSkuDetails.price");
                boolean zAreEqual = m.areEqual(googlePlaySku.getSkuName(), str);
                Objects.requireNonNull(bVar);
                m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                m.checkNotNullParameter(anonymousClass1, "onContinueClickListener");
                m.checkNotNullParameter(c04582, "onUpgradeClickListener");
                m.checkNotNullParameter(strB, "upgradePrice");
                b.a.a.b.a aVar = new b.a.a.b.a();
                aVar.onContinueClickListener = anonymousClass1;
                aVar.onUpgradeClickListener = c04582;
                aVar.upgradePrice = strB;
                aVar.hasBoostPlan = zAreEqual;
                aVar.show(parentFragmentManager, b.a.a.b.a.class.getSimpleName());
                return;
            }
            if (googlePlaySku.getUpgrade() == null || skuDetails == null) {
                WidgetChoosePlan.access$getViewModel$p(WidgetChoosePlan.this).buy(googlePlaySku, str, this.$locationTrait, "plan_select");
                return;
            }
            AnalyticsTracker.paymentFlowStep$default(AnalyticsTracker.INSTANCE, this.$locationTrait, Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "yearly_upsell", "plan_select", null, null, 48, null);
            b.Companion c0018b = b.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetChoosePlan.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(googlePlaySku, str);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(googlePlaySku, str);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            String strB2 = skuDetails.b();
            m.checkNotNullExpressionValue(strB2, "upgradeSkuDetails.price");
            boolean zAreEqual2 = m.areEqual(googlePlaySku.getSkuName(), str);
            boolean z2 = googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
            Objects.requireNonNull(c0018b);
            m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            m.checkNotNullParameter(anonymousClass3, "onMonthlyClickListener");
            m.checkNotNullParameter(anonymousClass4, "onYearlyClickListener");
            m.checkNotNullParameter(anonymousClass5, "onDismissCallback");
            m.checkNotNullParameter(strB2, "upgradePrice");
            b bVar2 = new b();
            bVar2.onMonthlyClickListener = anonymousClass3;
            bVar2.onYearlyClickListener = anonymousClass4;
            bVar2.onDismissCallback = anonymousClass5;
            bVar2.upgradePrice = strB2;
            bVar2.hasMonthlyPlan = zAreEqual2;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_TIER_1", z2);
            bVar2.setArguments(bundle);
            bVar2.show(parentFragmentManager2, b.class.getSimpleName());
        }
    }

    public WidgetChoosePlan() {
        super(R.layout.widget_choose_plan);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChoosePlan$binding$2.INSTANCE, null, 2, null);
        WidgetChoosePlan$viewModel$2 widgetChoosePlan$viewModel$2 = new WidgetChoosePlan$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ChoosePlanViewModel.class), new WidgetChoosePlan$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChoosePlan$viewModel$2));
    }

    public static final /* synthetic */ Unit access$configureUI(WidgetChoosePlan widgetChoosePlan, ChoosePlanViewModel.ViewState viewState) {
        return widgetChoosePlan.configureUI(viewState);
    }

    public static final /* synthetic */ ChoosePlanViewModel access$getViewModel$p(WidgetChoosePlan widgetChoosePlan) {
        return widgetChoosePlan.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetChoosePlan widgetChoosePlan, ChoosePlanViewModel.Event event) {
        widgetChoosePlan.handleEvent(event);
    }

    private final Unit configureUI(ChoosePlanViewModel.ViewState viewState) {
        if (viewState instanceof ChoosePlanViewModel.ViewState.Loading) {
            return null;
        }
        if (!(viewState instanceof ChoosePlanViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ChoosePlanViewModel.ViewState.Loaded loaded = (ChoosePlanViewModel.ViewState.Loaded) viewState;
        widgetChoosePlanAdapter.setData(loaded.getItems());
        LinearLayout linearLayout = getBinding().f2349b;
        m.checkNotNullExpressionValue(linearLayout, "binding.choosePlanEmptyContainer");
        linearLayout.setVisibility(loaded.isEmpty() ? 0 : 8);
        if (m.areEqual(loaded.getPurchasesQueryState(), StoreGooglePlayPurchases.QueryState.InProgress.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().e, true, false, 2, null);
            return Unit.a;
        }
        DimmerView.setDimmed$default(getBinding().e, false, false, 2, null);
        return Unit.a;
    }

    private final WidgetChoosePlanBinding getBinding() {
        return (WidgetChoosePlanBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChoosePlanViewModel getViewModel() {
        return (ChoosePlanViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ChoosePlanViewModel.Event event) {
        if (event instanceof ChoosePlanViewModel.Event.ErrorSkuPurchase) {
            b.a.d.m.i(this, ((ChoosePlanViewModel.Event.ErrorSkuPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof ChoosePlanViewModel.Event.StartSkuPurchase) {
            GooglePlayBillingManager.INSTANCE.launchBillingFlow(requireAppActivity(), ((ChoosePlanViewModel.Event.StartSkuPurchase) event).getBillingParams());
            return;
        }
        if (event instanceof ChoosePlanViewModel.Event.CompleteSkuPurchase) {
            ChoosePlanViewModel.Event.CompleteSkuPurchase completeSkuPurchase = (ChoosePlanViewModel.Event.CompleteSkuPurchase) event;
            GooglePlaySku googlePlaySkuFromSkuName = GooglePlaySku.INSTANCE.fromSkuName(completeSkuPurchase.getSkuName());
            if (googlePlaySkuFromSkuName != null) {
                WidgetChoosePlan$handleEvent$onDismiss$1 widgetChoosePlan$handleEvent$onDismiss$1 = new WidgetChoosePlan$handleEvent$onDismiss$1(this);
                int iOrdinal = googlePlaySkuFromSkuName.getType().ordinal();
                if (iOrdinal == 0) {
                    f.Companion aVar = f.INSTANCE;
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    aVar.a(parentFragmentManager, widgetChoosePlan$handleEvent$onDismiss$1, false);
                    return;
                }
                if (iOrdinal == 1) {
                    f.Companion aVar2 = f.INSTANCE;
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    aVar2.a(parentFragmentManager2, widgetChoosePlan$handleEvent$onDismiss$1, true);
                    return;
                }
                if (iOrdinal != 2 && iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return;
                    }
                    c.Companion aVar3 = c.INSTANCE;
                    FragmentManager parentFragmentManager3 = getParentFragmentManager();
                    m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                    aVar3.a(parentFragmentManager3, requireContext(), null, googlePlaySkuFromSkuName.getPremiumSubscriptionCount(), false, widgetChoosePlan$handleEvent$onDismiss$1);
                    return;
                }
                g.Companion aVar4 = g.INSTANCE;
                FragmentManager parentFragmentManager4 = getParentFragmentManager();
                m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
                String planName = completeSkuPurchase.getPlanName();
                Objects.requireNonNull(aVar4);
                m.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
                m.checkNotNullParameter(widgetChoosePlan$handleEvent$onDismiss$1, "onDismiss");
                m.checkNotNullParameter(planName, "planName");
                g gVar = new g();
                gVar.onDismiss = widgetChoosePlan$handleEvent$onDismiss$1;
                Bundle bundle = new Bundle();
                bundle.putString("extra_plan_text", planName);
                gVar.setArguments(bundle);
                gVar.show(parentFragmentManager4, g.class.getSimpleName());
            }
        }
    }

    private final void setUpRecycler() {
        RecyclerView recyclerView = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView, "binding.choosePlanRecycler");
        this.planLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        RecyclerView recyclerView2 = getBinding().d;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        m.checkNotNullExpressionValue(recyclerView2, "it");
        this.adapter = (WidgetChoosePlanAdapter) companion.configure(new WidgetChoosePlanAdapter(recyclerView2));
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(RESULT_EXTRA_LOCATION_TRAIT);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.utilities.analytics.Traits.Location");
        Traits.Location location = (Traits.Location) serializableExtra;
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChoosePlanAdapter.setOnClickPlan(new AnonymousClass2(location));
        RecyclerView recyclerView3 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView3, "binding.choosePlanRecycler");
        LinearLayoutManager linearLayoutManager = this.planLayoutManager;
        if (linearLayoutManager == null) {
            m.throwUninitializedPropertyAccessException("planLayoutManager");
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().d;
        m.checkNotNullExpressionValue(recyclerView4, "binding.choosePlanRecycler");
        WidgetChoosePlanAdapter widgetChoosePlanAdapter2 = this.adapter;
        if (widgetChoosePlanAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetChoosePlanAdapter2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpRecycler();
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.choosePlanEmptyDescription");
        b.a.k.b.n(linkifiedTextView, R.string.premium_no_plans_body, new Object[]{b.a.d.f.a.a(360055386693L, null)}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), WidgetChoosePlan.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChoosePlan.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(this), 62, (Object) null);
    }
}
