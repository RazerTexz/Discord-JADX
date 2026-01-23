package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanFormatBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.RadioManager;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildRoleSubscriptionPlanFormat.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanFormatBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager radioManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionPlanFormat newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat = new WidgetGuildRoleSubscriptionPlanFormat();
            widgetGuildRoleSubscriptionPlanFormat.setArguments(Bundle2.bundleOf(Tuples.m10073to(WidgetGuildRoleSubscriptionPlanFormat.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionPlanFormat;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class ViewOnClickListenerC84591 implements View.OnClickListener {
        public ViewOnClickListenerC84591() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionPlanFormat.access$getViewModel$p(WidgetGuildRoleSubscriptionPlanFormat.this).updateFullServerGate(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class ViewOnClickListenerC84602 implements View.OnClickListener {
        public ViewOnClickListenerC84602() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionPlanFormat.access$getViewModel$p(WidgetGuildRoleSubscriptionPlanFormat.this).updateFullServerGate(false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class C84611 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public C84611() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionPlanFormat.access$configureUI(WidgetGuildRoleSubscriptionPlanFormat.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionPlanFormat() {
        super(C5419R.layout.widget_guild_role_subscription_plan_format);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanFormat2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new C8457x31680061(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanFormat3.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat, GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
        widgetGuildRoleSubscriptionPlanFormat.configureUI(viewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionPlanDetailsViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat) {
        return widgetGuildRoleSubscriptionPlanFormat.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
        if (viewState.isFullServerGate()) {
            RadioManager radioManager = this.radioManager;
            if (radioManager == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("radioManager");
            }
            GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton = getBinding().f16937e;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton, "binding.guildRoleSubscri…ionPlanEntireServerFormat");
            radioManager.m8550a(guildRoleSubscriptionPlanFormatRadioButton);
            return;
        }
        RadioManager radioManager2 = this.radioManager;
        if (radioManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("radioManager");
        }
        GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2 = getBinding().f16938f;
        Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton2, "binding.guildRoleSubscri…ionPlanSomeChannelsFormat");
        radioManager2.m8550a(guildRoleSubscriptionPlanFormatRadioButton2);
    }

    private final WidgetGuildRoleSubscriptionPlanFormatBinding getBinding() {
        return (WidgetGuildRoleSubscriptionPlanFormatBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean getHideHeader() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(INTENT_EXTRA_HIDE_HEADER, false);
        }
        return false;
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.radioManager = new RadioManager(Collections2.listOf((Object[]) new GuildRoleSubscriptionPlanFormatRadioButton[]{getBinding().f16937e, getBinding().f16938f}));
        getBinding().f16937e.setOnClickListener(new ViewOnClickListenerC84591());
        getBinding().f16938f.setOnClickListener(new ViewOnClickListenerC84602());
        TextView textView = getBinding().f16936d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFormatTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16935c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionFormatSubtitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().f16934b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionFormatDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanFormat.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C84611(), 62, (Object) null);
    }
}
