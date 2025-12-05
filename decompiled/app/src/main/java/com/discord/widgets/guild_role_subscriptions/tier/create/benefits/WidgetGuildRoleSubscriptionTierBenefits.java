package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitsBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.StickyHeaderItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitsViewModel;
import com.google.android.material.radiobutton.MaterialRadioButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefits extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionTierBenefits.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_BENEFITS_HIDE_HEADER = "INTENT_EXTRA_BENEFITS_HIDE_HEADER";
    public static final String INTENT_EXTRA_BENEFIT_LIST_TYPE = "INTENT_EXTRA_BENEFIT_LIST_TYPE";
    private final ActivityResultLauncher<Intent> benefitLauncher;

    /* renamed from: benefitListType$delegate, reason: from kotlin metadata */
    private final Lazy benefitListType;
    private GuildRoleSubscriptionBenefitAdapter benefitsAdapter;

    /* renamed from: benefitsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy benefitsViewModel;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final RadioGroup.OnCheckedChangeListener channelBenefitSettingsCheckedChangeListener;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1 itemClickListener;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierBenefits newInstance$default(Companion companion, long j, GuildRoleSubscriptionTierBenefitListType guildRoleSubscriptionTierBenefitListType, boolean z2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            return companion.newInstance(j, guildRoleSubscriptionTierBenefitListType, z2);
        }

        public final WidgetGuildRoleSubscriptionTierBenefits newInstance(long guildId, GuildRoleSubscriptionTierBenefitListType benefitListType, boolean hideHeader) {
            Intrinsics3.checkNotNullParameter(benefitListType, "benefitListType");
            WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits = new WidgetGuildRoleSubscriptionTierBenefits();
            widgetGuildRoleSubscriptionTierBenefits.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.m10073to("INTENT_EXTRA_BENEFITS_HIDE_HEADER", Boolean.valueOf(hideHeader)), Tuples.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, benefitListType)));
            return widgetGuildRoleSubscriptionTierBenefits;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionTierBenefitListType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionTierBenefitListType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionTierBenefitListType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionTierBenefitListType.ALL.ordinal()] = 3;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$1 */
    public static final class C85501 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C85501() {
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
            WidgetGuildRoleSubscriptionTierBenefits.access$getBenefitsViewModel$p(WidgetGuildRoleSubscriptionTierBenefits.this).updateBenefits(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionTierBenefits.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits$onViewBoundOrOnResume$2 */
    public static final class C85512 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitsViewModel.ViewState, Unit> {
        public C85512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefits.access$configureUI(WidgetGuildRoleSubscriptionTierBenefits.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefits() {
        super(C5419R.layout.widget_guild_role_subscription_tier_benefits);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefits$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8539x18a0931f(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierBenefits$viewModel$2.INSTANCE));
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$guildId$2(this));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$hideHeader$2(this));
        WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2 = new WidgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.benefitsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitsViewModel.class), new C8541x17397041(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefits$benefitsViewModel$2));
        this.benefitListType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefits$benefitListType$2(this));
        this.benefitLauncher = WidgetGuildRoleSubscriptionTierBenefit.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefits$benefitLauncher$1(this));
        this.itemClickListener = new WidgetGuildRoleSubscriptionTierBenefits$itemClickListener$1(this);
        this.channelBenefitSettingsCheckedChangeListener = new C8542xe408467d(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits, GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionTierBenefits.configureUI(viewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getBenefitLauncher$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.benefitLauncher;
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitListType access$getBenefitListType$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitListType();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitsViewModel access$getBenefitsViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBenefitsViewModel();
    }

    public static final /* synthetic */ WidgetGuildRoleSubscriptionTierBenefitsBinding access$getBinding$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getGuildId();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefits widgetGuildRoleSubscriptionTierBenefits) {
        return widgetGuildRoleSubscriptionTierBenefits.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitsViewModel.ViewState viewState) {
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        guildRoleSubscriptionBenefitAdapter.setItems(viewState.getItems());
        RadioGroup radioGroup = getBinding().f16960f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(viewState.getCanChangeChannelSettings() ? 0 : 8);
        if (viewState.getCanAccessAllChannels() == null) {
            return;
        }
        getBinding().f16960f.setOnCheckedChangeListener(null);
        if (viewState.getCanAccessAllChannels().booleanValue()) {
            MaterialRadioButton materialRadioButton = getBinding().f16956b;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton, "binding.guildRoleSubscriptionTierAllChannels");
            materialRadioButton.setChecked(true);
        } else {
            MaterialRadioButton materialRadioButton2 = getBinding().f16961g;
            Intrinsics3.checkNotNullExpressionValue(materialRadioButton2, "binding.guildRoleSubscriptionTierManualChannels");
            materialRadioButton2.setChecked(true);
        }
        getBinding().f16960f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final GuildRoleSubscriptionTierBenefitListType getBenefitListType() {
        return (GuildRoleSubscriptionTierBenefitListType) this.benefitListType.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitsViewModel getBenefitsViewModel() {
        return (GuildRoleSubscriptionTierBenefitsViewModel) this.benefitsViewModel.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void setUpBenefitsRecycler() {
        this.benefitsAdapter = new GuildRoleSubscriptionBenefitAdapter(this.itemClickListener, this, null, 4, null);
        PaddedItemDecorator paddedItemDecorator = new PaddedItemDecorator(1, 0, DimenUtils.dpToPixels(8), true);
        RecyclerView recyclerView = getBinding().f16962h;
        RecyclerView recyclerView2 = getBinding().f16962h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.subscriptionTierBenefitsRecycler");
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView2, guildRoleSubscriptionBenefitAdapter, 0, false, 12, null));
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter2 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionBenefitAdapter2);
        GuildRoleSubscriptionBenefitAdapter guildRoleSubscriptionBenefitAdapter3 = this.benefitsAdapter;
        if (guildRoleSubscriptionBenefitAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("benefitsAdapter");
        }
        StickyHeaderItemDecoration stickyHeaderItemDecoration = new StickyHeaderItemDecoration(guildRoleSubscriptionBenefitAdapter3);
        recyclerView.addItemDecoration(paddedItemDecorator);
        recyclerView.addItemDecoration(stickyHeaderItemDecoration);
    }

    private final void setupUIForChannelBenefits() {
        TextView textView = getBinding().f16959e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(C5419R.string.guild_role_subscription_create_tier_channel_benefits_title));
        TextView textView2 = getBinding().f16958d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(C5419R.string.guild_role_subscription_create_tier_channel_benefits_description));
        RadioGroup radioGroup = getBinding().f16960f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(0);
        getBinding().f16960f.setOnCheckedChangeListener(this.channelBenefitSettingsCheckedChangeListener);
    }

    private final void setupUIForIntangibleBenefits() {
        TextView textView = getBinding().f16959e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setText(getString(C5419R.string.guild_role_subscription_create_tier_intangible_benefits_title));
        TextView textView2 = getBinding().f16958d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setText(getString(C5419R.string.f14671x2e4f7edc));
        RadioGroup radioGroup = getBinding().f16960f;
        Intrinsics3.checkNotNullExpressionValue(radioGroup, "binding.guildRoleSubscri…TierChannelBenefitSetting");
        radioGroup.setVisibility(8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpBenefitsRecycler();
        TextView textView = getBinding().f16959e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitsTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16958d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitsSubTitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().f16957c;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierBenefitsDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        int iOrdinal = getBenefitListType().ordinal();
        if (iOrdinal == 0) {
            setupUIForChannelBenefits();
            return;
        }
        if (iOrdinal == 1) {
            setupUIForIntangibleBenefits();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            setupUIForChannelBenefits();
            setupUIForIntangibleBenefits();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85501(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getBenefitsViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefits.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C85512(), 62, (Object) null);
    }
}
