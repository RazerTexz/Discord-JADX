package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanFormatBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.RadioManager;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import d0.Tuples;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionPlanFormat.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanFormatBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager radioManager;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
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
            widgetGuildRoleSubscriptionPlanFormat.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGuildRoleSubscriptionPlanFormat.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionPlanFormat;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionPlanFormat.access$getViewModel$p(WidgetGuildRoleSubscriptionPlanFormat.this).updateFullServerGate(true);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildRoleSubscriptionPlanFormat.access$getViewModel$p(WidgetGuildRoleSubscriptionPlanFormat.this).updateFullServerGate(false);
        }
    }

    /* compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionPlanFormat.access$configureUI(WidgetGuildRoleSubscriptionPlanFormat.this, viewState);
        }
    }

    public WidgetGuildRoleSubscriptionPlanFormat() {
        super(R.layout.widget_guild_role_subscription_plan_format);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanFormat2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetGuildRoleSubscriptionPlanFormat$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanFormat3.INSTANCE));
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
            GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton, "binding.guildRoleSubscri…ionPlanEntireServerFormat");
            radioManager.a(guildRoleSubscriptionPlanFormatRadioButton);
            return;
        }
        RadioManager radioManager2 = this.radioManager;
        if (radioManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("radioManager");
        }
        GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton2, "binding.guildRoleSubscri…ionPlanSomeChannelsFormat");
        radioManager2.a(guildRoleSubscriptionPlanFormatRadioButton2);
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
        this.radioManager = new RadioManager(Collections2.listOf((Object[]) new GuildRoleSubscriptionPlanFormatRadioButton[]{getBinding().e, getBinding().f}));
        getBinding().e.setOnClickListener(new AnonymousClass1());
        getBinding().f.setOnClickListener(new AnonymousClass2());
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFormatTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionFormatSubtitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().f2437b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionFormatDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanFormat.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
