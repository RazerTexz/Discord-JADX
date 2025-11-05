package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.GuildBoostActivatedDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetGuildBoostConfirmation.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildBoostConfirmation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: slotId$delegate, reason: from kotlin metadata */
    private final Lazy slotId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, long slotId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_SLOT_ID, slotId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…NT_EXTRA_SLOT_ID, slotId)");
            AppScreen2.d(context, WidgetGuildBoostConfirmation.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildBoostInProgressViewModel.GuildBoostState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.NOT_IN_PROGRESS.ordinal()] = 1;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.CALL_IN_PROGRESS.ordinal()] = 2;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.ERROR.ordinal()] = 3;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.COMPLETED.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$configureUI$1, reason: invalid class name */
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
            FragmentActivity activity = WidgetGuildBoostConfirmation.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildBoostInProgressViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
            super(1, widgetGuildBoostConfirmation, WidgetGuildBoostConfirmation.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostInProgressViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildBoostConfirmation.access$configureUI((WidgetGuildBoostConfirmation) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildBoostConfirmation.kt */
    /* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildBoostConfirmation.access$getViewModel$p(WidgetGuildBoostConfirmation.this).subscribeToGuildBoost(WidgetGuildBoostConfirmation.access$getGuildId$p(WidgetGuildBoostConfirmation.this), WidgetGuildBoostConfirmation.access$getSlotId$p(WidgetGuildBoostConfirmation.this));
        }
    }

    public WidgetGuildBoostConfirmation() {
        super(R.layout.widget_server_boost_confirmation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoostConfirmation2.INSTANCE, null, 2, null);
        WidgetGuildBoostConfirmation5 widgetGuildBoostConfirmation5 = new WidgetGuildBoostConfirmation5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostInProgressViewModel.class), new WidgetGuildBoostConfirmation$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoostConfirmation5));
        this.guildId = LazyJVM.lazy(new WidgetGuildBoostConfirmation3(this));
        this.slotId = LazyJVM.lazy(new WidgetGuildBoostConfirmation4(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation, GuildBoostInProgressViewModel.ViewState viewState) {
        widgetGuildBoostConfirmation.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getGuildId();
    }

    public static final /* synthetic */ long access$getSlotId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getSlotId();
    }

    public static final /* synthetic */ GuildBoostInProgressViewModel access$getViewModel$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getViewModel();
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostInProgressViewModel.ViewState viewModelViewState) {
        if (viewModelViewState instanceof GuildBoostInProgressViewModel.ViewState.Uninitialized) {
            return;
        }
        Objects.requireNonNull(viewModelViewState, "null cannot be cast to non-null type com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState.Loaded");
        GuildBoostInProgressViewModel.ViewState.Loaded loaded = (GuildBoostInProgressViewModel.ViewState.Loaded) viewModelViewState;
        if (loaded.getGuild() == null) {
            requireActivity().finish();
            return;
        }
        configureToolbar(loaded.getGuild().getName());
        getBinding().f2534b.b(loaded.getGuild(), 1);
        int iOrdinal = loaded.getGuildBoostState().ordinal();
        if (iOrdinal == 0) {
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostConfirmationError");
            textView.setVisibility(4);
            return;
        }
        if (iOrdinal == 1) {
            DimmerView.setDimmed$default(getBinding().f, true, false, 2, null);
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.boostConfirmationError");
            textView2.setVisibility(4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.boostConfirmationError");
            textView3.setVisibility(0);
            return;
        }
        if (loaded.getCanShowConfirmationDialog()) {
            GuildBoostActivatedDialog.Companion aVar = GuildBoostActivatedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.a(parentFragmentManager, requireContext(), loaded.getGuild().getName(), loaded.getSubscriptionCount() + 1, false, new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, long j2) {
        INSTANCE.create(context, j, j2);
    }

    private final WidgetServerBoostConfirmationBinding getBinding() {
        return (WidgetServerBoostConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getSlotId() {
        return ((Number) this.slotId.getValue()).longValue();
    }

    private final GuildBoostInProgressViewModel getViewModel() {
        return (GuildBoostInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AppActivity appActivity;
        super.onResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildBoostConfirmation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().e.setOnClickListener(new AnonymousClass1());
        MaterialButton materialButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.boostConfirmationSelect");
        materialButton.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_confirmation, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_confirmation_slotCount, 1, 1)}, null, 4));
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_cooldown_warning_days, 7, 7);
        CharSequence i18nPluralString2 = StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_cooldown_warning_slotCount, 1, 1);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.boostConfirmationCooldownWarning");
        textView.setText(FormatUtils.k(this, R.string.premium_guild_subscribe_confirm_cooldown_warning, new Object[]{i18nPluralString2, i18nPluralString}, null, 4));
    }
}
