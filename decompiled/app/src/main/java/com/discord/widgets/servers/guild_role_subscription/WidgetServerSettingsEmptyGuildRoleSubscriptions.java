package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup;
import com.discord.widgets.servers.guild_role_subscription.ServerSettingsEmptyGuildRoleSubscriptionsViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEmptyGuildRoleSubscriptions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEmptyGuildRoleSubscriptionBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADED_STATE = 1;
    private static final int SERVER_SETTINGS_EMPTY_GUILD_ROLE_SUBSCRIPTIONS_VIEW_FLIPPER_LOADING_STATE = 0;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetServerSettingsEmptyGuildRoleSubscriptions.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionPlanSetup.INSTANCE.launch(WidgetServerSettingsEmptyGuildRoleSubscriptions.this.requireContext(), WidgetServerSettingsEmptyGuildRoleSubscriptions.access$getGuildId$p(WidgetServerSettingsEmptyGuildRoleSubscriptions.this));
            WidgetServerSettingsEmptyGuildRoleSubscriptions.this.requireActivity().finish();
        }
    }

    /* compiled from: WidgetServerSettingsEmptyGuildRoleSubscriptions.kt */
    /* renamed from: com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
            WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions = WidgetServerSettingsEmptyGuildRoleSubscriptions.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            WidgetServerSettingsEmptyGuildRoleSubscriptions.access$configureUI(widgetServerSettingsEmptyGuildRoleSubscriptions, viewState);
        }
    }

    public WidgetServerSettingsEmptyGuildRoleSubscriptions() {
        super(R.layout.widget_server_settings_empty_guild_role_subscription);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEmptyGuildRoleSubscriptions2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsEmptyGuildRoleSubscriptions5(this));
        WidgetServerSettingsEmptyGuildRoleSubscriptions6 widgetServerSettingsEmptyGuildRoleSubscriptions6 = new WidgetServerSettingsEmptyGuildRoleSubscriptions6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.class), new WidgetServerSettingsEmptyGuildRoleSubscriptions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsEmptyGuildRoleSubscriptions6));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions, ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
        widgetServerSettingsEmptyGuildRoleSubscriptions.configureUI(viewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsEmptyGuildRoleSubscriptions widgetServerSettingsEmptyGuildRoleSubscriptions) {
        return widgetServerSettingsEmptyGuildRoleSubscriptions.getGuildId();
    }

    private final void configureUI(ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState viewState) {
        if (viewState.isLoading()) {
            AppViewFlipper appViewFlipper = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.serverSettingsEm…eSubscriptionsViewFlipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        Boolean boolIsMonetizationEnabled = viewState.isMonetizationEnabled();
        if (boolIsMonetizationEnabled != null) {
            if (boolIsMonetizationEnabled.booleanValue()) {
                getBinding().f2567b.setOnClickListener(new WidgetServerSettingsEmptyGuildRoleSubscriptions3(this));
            } else {
                getBinding().f2567b.setOnClickListener(new WidgetServerSettingsEmptyGuildRoleSubscriptions4(this));
            }
        }
    }

    private final WidgetServerSettingsEmptyGuildRoleSubscriptionBinding getBinding() {
        return (WidgetServerSettingsEmptyGuildRoleSubscriptionBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsEmptyGuildRoleSubscriptionsViewModel getViewModel() {
        return (ServerSettingsEmptyGuildRoleSubscriptionsViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.guild_settings_role_subscriptions_title);
        getBinding().f2567b.setOnClickListener(new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsEmptyGuildRoleSubscriptionsViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsEmptyGuildRoleSubscriptions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
