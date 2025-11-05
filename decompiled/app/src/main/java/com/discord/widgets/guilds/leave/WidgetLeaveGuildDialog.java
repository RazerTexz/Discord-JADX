package com.discord.widgets.guilds.leave;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetLeaveGuildDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetLeaveGuildDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            WidgetLeaveGuildDialog widgetLeaveGuildDialog = new WidgetLeaveGuildDialog();
            widgetLeaveGuildDialog.setArguments(bundle);
            widgetLeaveGuildDialog.show(fragmentManager, WidgetLeaveGuildDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.access$getViewModel$p(WidgetLeaveGuildDialog.this).leaveGuild();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<LeaveGuildDialogViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetLeaveGuildDialog.access$configureUI(WidgetLeaveGuildDialog.this, viewState);
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<LeaveGuildDialogViewModel.Event, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            WidgetLeaveGuildDialog.access$handleEvent(WidgetLeaveGuildDialog.this, event);
        }
    }

    public WidgetLeaveGuildDialog() {
        super(R.layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetLeaveGuildDialog$binding$2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog$viewModel$2 widgetLeaveGuildDialog$viewModel$2 = new WidgetLeaveGuildDialog$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetLeaveGuildDialog$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel.ViewState viewState) {
        widgetLeaveGuildDialog.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getArgumentsOrDefault();
    }

    public static final /* synthetic */ LeaveGuildDialogViewModel access$getViewModel$p(WidgetLeaveGuildDialog widgetLeaveGuildDialog) {
        return widgetLeaveGuildDialog.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetLeaveGuildDialog widgetLeaveGuildDialog, LeaveGuildDialogViewModel.Event event) {
        widgetLeaveGuildDialog.handleEvent(event);
    }

    private final void configureUI(LeaveGuildDialogViewModel.ViewState viewState) {
        if (!(viewState instanceof LeaveGuildDialogViewModel.ViewState.Valid)) {
            if (m.areEqual(viewState, LeaveGuildDialogViewModel.ViewState.Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel.ViewState.Valid valid = (LeaveGuildDialogViewModel.ViewState.Valid) viewState;
        b.n(textView, R.string.leave_server_title, new Object[]{valid.getGuild().getName()}, null, 4);
        TextView textView2 = getBinding().d;
        m.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        b.n(textView2, valid.getGuild().isHub() ? R.string.leave_hub_body : R.string.leave_server_body_mobile, new Object[]{valid.getGuild().getName()}, null, 4);
        getBinding().c.setText(getString(valid.getGuild().isHub() ? R.string.leave_hub : R.string.leave_server));
        getBinding().c.setIsLoading(valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel.Event event) {
        if (m.areEqual(event, LeaveGuildDialogViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2128b.setOnClickListener(new AnonymousClass2());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
