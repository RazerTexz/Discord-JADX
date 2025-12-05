package com.discord.widgets.guilds.leave;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.LeaveGuildDialogBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.leave.LeaveGuildDialogViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetLeaveGuildDialog.kt */
/* loaded from: classes2.dex */
public final class WidgetLeaveGuildDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetLeaveGuildDialog.class, "binding", "getBinding()Lcom/discord/databinding/LeaveGuildDialogBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
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
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$1 */
    public static final class ViewOnClickListenerC87301 implements View.OnClickListener {
        public ViewOnClickListenerC87301() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.access$getViewModel$p(WidgetLeaveGuildDialog.this).leaveGuild();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$2 */
    public static final class ViewOnClickListenerC87312 implements View.OnClickListener {
        public ViewOnClickListenerC87312() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetLeaveGuildDialog.this.dismiss();
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$3 */
    public static final class C87323 extends Lambda implements Function1<LeaveGuildDialogViewModel.ViewState, Unit> {
        public C87323() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetLeaveGuildDialog.access$configureUI(WidgetLeaveGuildDialog.this, viewState);
        }
    }

    /* compiled from: WidgetLeaveGuildDialog.kt */
    /* renamed from: com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$onResume$4 */
    public static final class C87334 extends Lambda implements Function1<LeaveGuildDialogViewModel.Event, Unit> {
        public C87334() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(LeaveGuildDialogViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(LeaveGuildDialogViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetLeaveGuildDialog.access$handleEvent(WidgetLeaveGuildDialog.this, event);
        }
    }

    public WidgetLeaveGuildDialog() {
        super(C5419R.layout.leave_guild_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetLeaveGuildDialog2.INSTANCE, null, 2, null);
        WidgetLeaveGuildDialog3 widgetLeaveGuildDialog3 = new WidgetLeaveGuildDialog3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(LeaveGuildDialogViewModel.class), new WidgetLeaveGuildDialog$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetLeaveGuildDialog3));
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
            if (Intrinsics3.areEqual(viewState, LeaveGuildDialogViewModel.ViewState.Invalid.INSTANCE)) {
                dismiss();
                return;
            }
            return;
        }
        TextView textView = getBinding().f15181e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.leaveGuildDialogHeader");
        LeaveGuildDialogViewModel.ViewState.Valid valid = (LeaveGuildDialogViewModel.ViewState.Valid) viewState;
        FormatUtils.m222n(textView, C5419R.string.leave_server_title, new Object[]{valid.getGuild().getName()}, null, 4);
        TextView textView2 = getBinding().f15180d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.leaveGuildDialogBody");
        FormatUtils.m222n(textView2, valid.getGuild().isHub() ? C5419R.string.leave_hub_body : C5419R.string.leave_server_body_mobile, new Object[]{valid.getGuild().getName()}, null, 4);
        getBinding().f15179c.setText(getString(valid.getGuild().isHub() ? C5419R.string.leave_hub : C5419R.string.leave_server));
        getBinding().f15179c.setIsLoading(valid.isLoading());
    }

    private final LeaveGuildDialogBinding getBinding() {
        return (LeaveGuildDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final LeaveGuildDialogViewModel getViewModel() {
        return (LeaveGuildDialogViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(LeaveGuildDialogViewModel.Event event) {
        if (Intrinsics3.areEqual(event, LeaveGuildDialogViewModel.Event.Dismiss.INSTANCE)) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        requireDialog().setCanceledOnTouchOutside(true);
        getBinding().f15179c.setOnClickListener(new ViewOnClickListenerC87301());
        getBinding().f15178b.setOnClickListener(new ViewOnClickListenerC87312());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87323(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetLeaveGuildDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C87334(), 62, (Object) null);
    }
}
