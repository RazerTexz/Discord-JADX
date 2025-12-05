package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsGuildRoleSubscriptionTierListBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel;
import com.discord.widgets.servers.guild_role_subscription.edit_tier.WidgetServerSettingsGuildRoleSubscriptionEditTier;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionTierList extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsGuildRoleSubscriptionTierList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsGuildRoleSubscriptionTierListBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_TIERS_VIEW_FLIPPER_LOADED_STATE */
    private static final int f19393x64833d6d = 1;

    /* renamed from: SERVER_SETTINGS_GUILD_ROLE_SUBSCRIPTION_TIERS_VIEW_FLIPPER_LOADING_STATE */
    private static final int f19394xaaa0cc98 = 0;
    private ServerSettingsGuildRoleSubscriptionTierAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.m156d(context, WidgetServerSettingsGuildRoleSubscriptionTierList.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$configureUI$1 */
    public static final class C94551 implements ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener {
        public final /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded $loadedViewState;

        public C94551(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded loaded) {
            this.$loadedViewState = loaded;
        }

        @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener
        public void onAddTierItemClick() {
            WidgetCreateGuildRoleSubscriptionTier.INSTANCE.launch(WidgetServerSettingsGuildRoleSubscriptionTierList.this.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptionTierList.this), this.$loadedViewState.getGroupListingId());
        }

        @Override // com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierAdapter.ItemClickListener
        public void onTierItemClick(long tierListingId) {
            WidgetServerSettingsGuildRoleSubscriptionEditTier.INSTANCE.launch(WidgetServerSettingsGuildRoleSubscriptionTierList.this.requireContext(), WidgetServerSettingsGuildRoleSubscriptionTierList.access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptionTierList.this), this.$loadedViewState.getGroupListingId(), tierListingId);
        }
    }

    /* compiled from: WidgetServerSettingsGuildRoleSubscriptionTierList.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList$onViewBoundOrOnResume$1 */
    public static final class C94561 extends Lambda implements Function1<ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState, Unit> {
        public C94561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
            WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList = WidgetServerSettingsGuildRoleSubscriptionTierList.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsGuildRoleSubscriptionTierList.access$configureUI(widgetServerSettingsGuildRoleSubscriptionTierList, viewState);
        }
    }

    public WidgetServerSettingsGuildRoleSubscriptionTierList() {
        super(C5419R.layout.widget_server_settings_guild_role_subscription_tier_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsGuildRoleSubscriptionTierList2.INSTANCE, null, 2, null);
        WidgetServerSettingsGuildRoleSubscriptionTierList4 widgetServerSettingsGuildRoleSubscriptionTierList4 = new WidgetServerSettingsGuildRoleSubscriptionTierList4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsGuildRoleSubscriptionTierListViewModel.class), new C9454x6bb8463d(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsGuildRoleSubscriptionTierList4));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsGuildRoleSubscriptionTierList3(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList, ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
        widgetServerSettingsGuildRoleSubscriptionTierList.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsGuildRoleSubscriptionTierList widgetServerSettingsGuildRoleSubscriptionTierList) {
        return widgetServerSettingsGuildRoleSubscriptionTierList.getGuildId();
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState viewState) {
        if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17670c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionTierListViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded) {
            configureUI((ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Failed) {
            AppToast.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
            requireActivity().finish();
        }
    }

    private final WidgetServerSettingsGuildRoleSubscriptionTierListBinding getBinding() {
        return (WidgetServerSettingsGuildRoleSubscriptionTierListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsGuildRoleSubscriptionTierListViewModel getViewModel() {
        return (ServerSettingsGuildRoleSubscriptionTierListViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.adapter = new ServerSettingsGuildRoleSubscriptionTierAdapter(this, null, 2, null);
        RecyclerView recyclerView = getBinding().f17669b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsGu…dRoleSubscriptionTierList");
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(serverSettingsGuildRoleSubscriptionTierAdapter);
        RecyclerView recyclerView2 = getBinding().f17669b;
        Context contextRequireContext = requireContext();
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(contextRequireContext, 1, serverSettingsGuildRoleSubscriptionTierAdapter2, DimenUtils.dpToPixels(8), 0, 16, null));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.guild_role_subscription_settings_section_tiers);
        setActionBarSubtitle(C5419R.string.guild_settings_role_subscriptions_title);
        Observable<ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetServerSettingsGuildRoleSubscriptionTierList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C94561(), 62, (Object) null);
    }

    private final void configureUI(ServerSettingsGuildRoleSubscriptionTierListViewModel.ViewState.Loaded loadedViewState) {
        AppViewFlipper appViewFlipper = getBinding().f17670c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsGu…iptionTierListViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionTierAdapter.setItemClickListener(new C94551(loadedViewState));
        ServerSettingsGuildRoleSubscriptionTierAdapter serverSettingsGuildRoleSubscriptionTierAdapter2 = this.adapter;
        if (serverSettingsGuildRoleSubscriptionTierAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        serverSettingsGuildRoleSubscriptionTierAdapter2.setItems(loadedViewState.getAdapterItems());
    }
}
