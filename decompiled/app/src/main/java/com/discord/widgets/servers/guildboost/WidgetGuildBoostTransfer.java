package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p010a.GuildBoostActivatedDialog;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetGuildBoostTransfer.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildBoostTransfer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PREVIOUS_GUILD_ID = "PREVIOUS_GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";
    private static final String INTENT_EXTRA_SUBSCRIPTION_ID = "SUBSCRIPTION_ID";
    private static final String INTENT_EXTRA_TARGET_GUILD_ID = "TARGET_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildBoostTransfer.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot, int i, Object obj) {
            if ((i & 8) != 0) {
                modelGuildBoostSlot = null;
            }
            companion.create(context, j, j2, modelGuildBoostSlot);
        }

        public final void create(Context context, long previousGuildId, long targetGuildId, ModelGuildBoostSlot slot) {
            ModelAppliedGuildBoost premiumGuildSubscription;
            Intrinsics3.checkNotNullParameter(context, "context");
            Long lValueOf = null;
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_PREVIOUS_GUILD_ID, previousGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_TARGET_GUILD_ID, targetGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SLOT_ID, slot != null ? Long.valueOf(slot.getId()) : null);
            if (slot != null && (premiumGuildSubscription = slot.getPremiumGuildSubscription()) != null) {
                lValueOf = Long.valueOf(premiumGuildSubscription.getId());
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SUBSCRIPTION_ID, lValueOf);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…iumGuildSubscription?.id)");
            AppScreen2.m156d(context, WidgetGuildBoostTransfer.class, intentPutExtra2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$configureUI$1 */
    public static final class C95201 extends Lambda implements Function0<Unit> {
        public C95201() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity activity = WidgetGuildBoostTransfer.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBound$1 */
    public static final class ViewOnClickListenerC95211 implements View.OnClickListener {
        public ViewOnClickListenerC95211() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoostTransfer.access$getViewModel$p(WidgetGuildBoostTransfer.this).transferGuildBoost();
        }
    }

    /* compiled from: WidgetGuildBoostTransfer.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C95221 extends FunctionReferenceImpl implements Function1<GuildBoostTransferInProgressViewModel.ViewState, Unit> {
        public C95221(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
            super(1, widgetGuildBoostTransfer, WidgetGuildBoostTransfer.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoostTransfer.access$configureUI((WidgetGuildBoostTransfer) this.receiver, viewState);
        }
    }

    public WidgetGuildBoostTransfer() {
        super(C5419R.layout.widget_guild_boost_transfer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoostTransfer2.INSTANCE, null, 2, null);
        WidgetGuildBoostTransfer3 widgetGuildBoostTransfer3 = new WidgetGuildBoostTransfer3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostTransferInProgressViewModel.class), new WidgetGuildBoostTransfer$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoostTransfer3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostTransfer widgetGuildBoostTransfer, GuildBoostTransferInProgressViewModel.ViewState viewState) {
        widgetGuildBoostTransfer.configureUI(viewState);
    }

    public static final /* synthetic */ GuildBoostTransferInProgressViewModel access$getViewModel$p(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        return widgetGuildBoostTransfer.getViewModel();
    }

    private final void configureUI(GuildBoostTransferInProgressViewModel.ViewState state) {
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorLoading) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.Loading) {
            DimmerView.setDimmed$default(getBinding().f16741b, true, false, 2, null);
            TextView textView = getBinding().f16743d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferError");
            textView.setVisibility(4);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorTransfer) {
            DimmerView.setDimmed$default(getBinding().f16741b, false, false, 2, null);
            TextView textView2 = getBinding().f16743d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferError");
            textView2.setVisibility(0);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) {
            GuildBoostTransferInProgressViewModel.ViewState.PreTransfer preTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) state;
            DimmerView.setDimmed$default(getBinding().f16741b, preTransfer.isTransferInProgress(), false, 2, null);
            TextView textView3 = getBinding().f16743d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferError");
            textView3.setVisibility(4);
            getBinding().f16744e.m8592b(preTransfer.getPreviousGuild(), -1);
            getBinding().f16747h.m8592b(preTransfer.getTargetGuild(), 1);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) {
            GuildBoostActivatedDialog.Companion aVar = GuildBoostActivatedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            GuildBoostTransferInProgressViewModel.ViewState.PostTransfer postTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) state;
            aVar.m101a(parentFragmentManager, requireContext(), postTransfer.getTargetGuild().getName(), postTransfer.getTargetGuildSubscriptionCount() + 1, true, new C95201());
        }
    }

    public static final void create(Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot) {
        INSTANCE.create(context, j, j2, modelGuildBoostSlot);
    }

    private final WidgetGuildBoostTransferBinding getBinding() {
        return (WidgetGuildBoostTransferBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildBoostTransferInProgressViewModel getViewModel() {
        return (GuildBoostTransferInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f16742c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferConfirmationBlurb");
        textView.setText(FormatUtils.m219k(this, C5419R.string.premium_guild_subscribe_confirm_transfer_blurb, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_blurb_slotCount, 1, 1), StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_blurb_guildCount, 1, 1)}, null, 4));
        TextView textView2 = getBinding().f16745f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferPreviousGuildHeader");
        textView2.setText(FormatUtils.m219k(this, C5419R.string.premium_guild_subscribe_confirm_transfer_from_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_from_guild_guildCount, 1, 1)}, null, 4));
        TextView textView3 = getBinding().f16748i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferTargetGuildHeader");
        textView3.setText(FormatUtils.m219k(this, C5419R.string.premium_guild_subscribe_confirm_transfer_to_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_to_guild_slotCount, 1, 1)}, null, 4));
        getBinding().f16746g.setOnClickListener(new ViewOnClickListenerC95211());
        MaterialButton materialButton = getBinding().f16746g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostTransferSelect");
        materialButton.setText(FormatUtils.m219k(this, C5419R.string.premium_guild_subscribe_transfer_confirm_confirmation, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_transfer_confirm_confirmation_slotCount, 1, 1)}, null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableM11112r, WidgetGuildBoostTransfer.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C95221(this), 62, (Object) null);
    }
}
