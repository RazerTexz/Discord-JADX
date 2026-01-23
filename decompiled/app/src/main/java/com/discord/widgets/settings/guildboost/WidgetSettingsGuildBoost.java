package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p010a.GuildBoostCancelDialog;
import p007b.p008a.p009a.p010a.GuildBoostUncancelDialog;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetSettingsGuildBoostSubscriptionAdapter guildBoostSubscriptionsAdapter;
    private SettingsGuildBoostSampleGuildAdapter sampleGuildsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsGuildBoost.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class ViewOnClickListenerC98561 implements View.OnClickListener {
        public final /* synthetic */ String $helpdeskArticleUrl;

        public ViewOnClickListenerC98561(String str) {
            this.$helpdeskArticleUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "it", "it.context"), this.$helpdeskArticleUrl, false, false, null, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class ViewOnClickListenerC98572 implements View.OnClickListener {
        public ViewOnClickListenerC98572() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).retryClicked();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98583 extends Lambda implements Function2<Long, String, Unit> {
        public C98583() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).handleGuildSearchCallback(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98591 extends Lambda implements Function1<SettingsGuildBoostViewModel.ViewState, Unit> {
        public C98591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGuildBoostViewModel.ViewState viewState) {
            if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loaded) {
                WidgetSettingsGuildBoost.access$showContent(WidgetSettingsGuildBoost.this, (SettingsGuildBoostViewModel.ViewState.Loaded) viewState);
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loading) {
                WidgetSettingsGuildBoost.access$showLoadingUI(WidgetSettingsGuildBoost.this);
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Failure) {
                WidgetSettingsGuildBoost.access$showFailureUI(WidgetSettingsGuildBoost.this);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$1 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98601 extends Lambda implements Function2<ModelGuildBoostSlot, Long, Unit> {
        public C98601() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
            invoke(modelGuildBoostSlot, l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
            Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "slot");
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).transferClicked(modelGuildBoostSlot, j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(_Sets.minus(StoreStream.INSTANCE.getGuilds().getGuilds().keySet(), Long.valueOf(j))), 14, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$2 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98612 extends Lambda implements Function2<Long, Boolean, Unit> {
        public C98612() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).cancelClicked(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$3 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98623 extends Lambda implements Function1<Long, Unit> {
        public C98623() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.access$getViewModel$p(WidgetSettingsGuildBoost.this).subscribeClicked(j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, null, 30, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$4 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final /* synthetic */ class C98634 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public C98634(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
            super(1, widgetSettingsGuildBoost, WidgetSettingsGuildBoost.class, "handleSampleGuildSelected", "handleSampleGuildSelected(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.access$handleSampleGuildSelected((WidgetSettingsGuildBoost) this.receiver, j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$7 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98647 extends Lambda implements Function0<Unit> {
        public C98647() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetSettingsGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    public WidgetSettingsGuildBoost() {
        super(C5419R.layout.widget_settings_boost);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsGuildBoost2.INSTANCE, null, 2, null);
        WidgetSettingsGuildBoost3 widgetSettingsGuildBoost3 = WidgetSettingsGuildBoost3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsGuildBoostViewModel.class), new WidgetSettingsGuildBoost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsGuildBoost3));
    }

    public static final /* synthetic */ SettingsGuildBoostViewModel access$getViewModel$p(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        return widgetSettingsGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleSampleGuildSelected(WidgetSettingsGuildBoost widgetSettingsGuildBoost, long j) {
        widgetSettingsGuildBoost.handleSampleGuildSelected(j);
    }

    public static final /* synthetic */ void access$showContent(WidgetSettingsGuildBoost widgetSettingsGuildBoost, SettingsGuildBoostViewModel.ViewState.Loaded loaded) {
        widgetSettingsGuildBoost.showContent(loaded);
    }

    public static final /* synthetic */ void access$showFailureUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showFailureUI();
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showLoadingUI();
    }

    private final void configureNoGuildsViews(boolean hasNoGuilds) {
        ImageView imageView = getBinding().f17921b.f1251b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.noGuilds.settingsBoostNoGuildsImage");
        imageView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView = getBinding().f17921b.f1253d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noGuilds.settingsBoostNoGuildsTitle");
        textView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView2 = getBinding().f17921b.f1252c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noGuilds.settingsBoostNoGuildsSubtitle");
        textView2.setVisibility(hasNoGuilds ? 0 : 8);
    }

    private final WidgetSettingsBoostBinding getBinding() {
        return (WidgetSettingsBoostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGuildBoostViewModel getViewModel() {
        return (SettingsGuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleSampleGuildSelected(long selectedGuildId) {
        StoreStream.INSTANCE.getGuildSelected().dispatchSampleGuildIdSelected(selectedGuildId);
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", true);
        intent.addFlags(268468224);
        AppScreen2.m155c(requireContext(), false, intent, 2);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showContent(SettingsGuildBoostViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(2);
        boolean z2 = !viewState.getGuildBoostItems().isEmpty();
        LinearLayout linearLayout = getBinding().f17928i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsBoostSubtextContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter = this.guildBoostSubscriptionsAdapter;
            if (widgetSettingsGuildBoostSubscriptionAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildBoostSubscriptionsAdapter");
            }
            widgetSettingsGuildBoostSubscriptionAdapter.configure(viewState.getGuildBoostItems(), new C98623(), new C98601(), new C98612(), viewState.getCanCancelBoosts(), viewState.getCanUncancelBoosts());
        }
        SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter = this.sampleGuildsAdapter;
        if (settingsGuildBoostSampleGuildAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("sampleGuildsAdapter");
        }
        settingsGuildBoostSampleGuildAdapter.configure(viewState.getSampleGuildItems(), new C98634(this));
        SettingsGuildBoostViewModel.PendingAction pendingAction = viewState.getPendingAction();
        if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Subscribe) {
            SettingsGuildBoostViewModel.PendingAction.Subscribe subscribe = (SettingsGuildBoostViewModel.PendingAction.Subscribe) pendingAction;
            Long targetGuildId = subscribe.getTargetGuildId();
            if (targetGuildId != null) {
                targetGuildId.longValue();
                WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), subscribe.getTargetGuildId().longValue(), subscribe.getSlotId());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Transfer) {
            SettingsGuildBoostViewModel.PendingAction.Transfer transfer = (SettingsGuildBoostViewModel.PendingAction.Transfer) pendingAction;
            Long targetGuildId2 = transfer.getTargetGuildId();
            if (targetGuildId2 != null) {
                targetGuildId2.longValue();
                WidgetGuildBoostTransfer.INSTANCE.create(requireContext(), transfer.getPreviousGuildId(), transfer.getTargetGuildId().longValue(), transfer.getSlot());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Cancel) {
            GuildBoostCancelDialog.Companion companion = GuildBoostCancelDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long slotId = ((SettingsGuildBoostViewModel.PendingAction.Cancel) pendingAction).getSlotId();
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            GuildBoostCancelDialog guildBoostCancelDialog = new GuildBoostCancelDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_slot_id", slotId);
            guildBoostCancelDialog.setArguments(bundle);
            guildBoostCancelDialog.show(parentFragmentManager, GuildBoostCancelDialog.class.getName());
            getViewModel().consumePendingAction();
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Uncancel) {
            GuildBoostUncancelDialog.Companion companion2 = GuildBoostUncancelDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            long slotId2 = ((SettingsGuildBoostViewModel.PendingAction.Uncancel) pendingAction).getSlotId();
            Objects.requireNonNull(companion2);
            Intrinsics3.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            GuildBoostUncancelDialog guildBoostUncancelDialog = new GuildBoostUncancelDialog();
            Bundle bundle2 = new Bundle();
            bundle2.putLong("extra_slot_id", slotId2);
            guildBoostUncancelDialog.setArguments(bundle2);
            guildBoostUncancelDialog.show(parentFragmentManager2, GuildBoostUncancelDialog.class.getName());
            getViewModel().consumePendingAction();
        }
        getBinding().f17923d.m8595a(viewState.getUserPremiumTier(), new C98647());
        getBinding().f17929j.m8597a(viewState.getUserPremiumTier(), !viewState.getSampleGuildItems().isEmpty());
        configureNoGuildsViews(viewState.getSampleGuildItems().isEmpty());
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.premium_guild_subscription_title);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17924e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBoostRecycler");
        this.guildBoostSubscriptionsAdapter = (WidgetSettingsGuildBoostSubscriptionAdapter) companion.configure(new WidgetSettingsGuildBoostSubscriptionAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f17926g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBoostSampleGuilds");
        this.sampleGuildsAdapter = (SettingsGuildBoostSampleGuildAdapter) companion.configure(new SettingsGuildBoostSampleGuildAdapter(recyclerView2));
        String strM149a = AppHelpDesk.f507a.m149a(360028038352L, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17927h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsBoostSubtext");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.premium_guild_subscription_subtitle_mobile_2, new Object[]{strM149a}, null, 4);
        getBinding().f17927h.setOnClickListener(new ViewOnClickListenerC98561(strM149a));
        getBinding().f17925f.setOnClickListener(new ViewOnClickListenerC98572());
        getBinding().f17924e.setHasFixedSize(false);
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, false, new C98583(), 6, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGuildBoostViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C98591(), 62, (Object) null);
    }
}
