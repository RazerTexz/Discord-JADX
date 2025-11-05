package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionEntryPoint.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_TRACKING_SOURCE_LOCATION = "INTENT_EXTRA_TRACKING_SOURCE_LOCATION";

    /* renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, String trackingSourceLocation) {
            m.checkNotNullParameter(context, "context");
            m.checkNotNullParameter(trackingSourceLocation, "trackingSourceLocation");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionEntryPoint.INTENT_EXTRA_TRACKING_SOURCE_LOCATION, trackingSourceLocation);
            j.d(context, WidgetGuildRoleSubscriptionEntryPoint.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("serverName", ((WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) this.$viewState).getGuild().getName());
            renderContext.a("serverNameHook", new C04101());
        }

        /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
        /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04101 extends o implements Function1<Hook, Unit> {
            public C04101() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetGuildRoleSubscriptionEntryPoint.this.getContext(), R.attr.primary_000)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint) {
            super(1, widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPoint.class, "configureUI", "configureUI(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetGuildRoleSubscriptionEntryPoint.access$configureUI((WidgetGuildRoleSubscriptionEntryPoint) this.receiver, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPoint() {
        super(R.layout.widget_guild_role_subscription_entry_point);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2.INSTANCE, null, 2, null);
        WidgetGuildRoleSubscriptionEntryPoint$viewModel$2 widgetGuildRoleSubscriptionEntryPoint$viewModel$2 = WidgetGuildRoleSubscriptionEntryPoint$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildRoleSubscriptionEntryPointViewModel.class), new WidgetGuildRoleSubscriptionEntryPoint$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildRoleSubscriptionEntryPoint$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionEntryPoint.configureUI(viewState);
    }

    private final void configureUI(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Uninitialized) {
            TextView textView = getViewBinding().f2434b;
            m.checkNotNullExpressionValue(textView, "viewBinding.description");
            textView.setVisibility(8);
        } else {
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Invalid) {
                requireActivity().onBackPressed();
                return;
            }
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) {
                TextView textView2 = getViewBinding().c;
                m.checkNotNullExpressionValue(textView2, "viewBinding.title");
                b.m(textView2, R.string.guild_role_subscription_purchase_page_unavailable_cta_hook, new Object[0], new AnonymousClass1(viewState));
                TextView textView3 = getViewBinding().f2434b;
                m.checkNotNullExpressionValue(textView3, "viewBinding.description");
                textView3.setVisibility(0);
            }
        }
    }

    private final long getGuildId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
    }

    private final String getTrackingSourceLocation() {
        return getMostRecentIntent().getStringExtra(INTENT_EXTRA_TRACKING_SOURCE_LOCATION);
    }

    private final WidgetGuildRoleSubscriptionEntryPointBinding getViewBinding() {
        return (WidgetGuildRoleSubscriptionEntryPointBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildRoleSubscriptionEntryPointViewModel getViewModel() {
        return (WidgetGuildRoleSubscriptionEntryPointViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j, String str) {
        INSTANCE.launch(context, j, str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        getViewModel().setGuildId(getGuildId());
        getViewModel().setTrackingSourceLocation(getTrackingSourceLocation());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionEntryPoint.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
