package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p025i.ViewUserStatusPresenceBinding;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final /* synthetic */ class C102391 extends FunctionReferenceImpl implements Function1<WidgetUserStatusSheetViewModel.ViewState, Unit> {
        public C102391(WidgetUserStatusSheet widgetUserStatusSheet) {
            super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserStatusSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetUserStatusSheet.access$updateView((WidgetUserStatusSheet) this.receiver, viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class ViewOnClickListenerC102401 implements View.OnClickListener {
        public ViewOnClickListenerC102401() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.ONLINE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class ViewOnClickListenerC102412 implements View.OnClickListener {
        public ViewOnClickListenerC102412() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.IDLE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class ViewOnClickListenerC102423 implements View.OnClickListener {
        public ViewOnClickListenerC102423() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.DND);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$4 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class ViewOnClickListenerC102434 implements View.OnClickListener {
        public ViewOnClickListenerC102434() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.INVISIBLE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$5 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class ViewOnClickListenerC102445 implements View.OnClickListener {
        public ViewOnClickListenerC102445() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet widgetUserStatusSheet = WidgetUserStatusSheet.this;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetUserStatusSheet.access$openCustomStatusAndDismiss(widgetUserStatusSheet, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$6 */
    /* JADX INFO: compiled from: WidgetUserStatusSheet.kt */
    public static final class C102456 extends Lambda implements Function0<Unit> {
        public C102456() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserStatusSheet.access$clearCustomStatus(WidgetUserStatusSheet.this);
        }
    }

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserStatusSheet2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet3 widgetUserStatusSheet3 = WidgetUserStatusSheet3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetUserStatusSheet3));
    }

    public static final /* synthetic */ void access$clearCustomStatus(WidgetUserStatusSheet widgetUserStatusSheet) {
        widgetUserStatusSheet.clearCustomStatus();
    }

    public static final /* synthetic */ void access$openCustomStatusAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, Context context) {
        widgetUserStatusSheet.openCustomStatusAndDismiss(context);
    }

    public static final /* synthetic */ void access$updateStateAndDismiss(WidgetUserStatusSheet widgetUserStatusSheet, ClientStatus clientStatus) {
        widgetUserStatusSheet.updateStateAndDismiss(clientStatus);
    }

    public static final /* synthetic */ void access$updateView(WidgetUserStatusSheet widgetUserStatusSheet, WidgetUserStatusSheetViewModel.ViewState viewState) {
        widgetUserStatusSheet.updateView(viewState);
    }

    @MainThread
    private final void clearCustomStatus() {
        getViewModel().clearCustomStatus();
    }

    private final WidgetUserStatusUpdateBinding getBinding() {
        return (WidgetUserStatusUpdateBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetUserStatusSheetViewModel getViewModel() {
        return (WidgetUserStatusSheetViewModel) this.viewModel.getValue();
    }

    @MainThread
    private final void openCustomStatusAndDismiss(Context context) {
        AnalyticsTracker.INSTANCE.openModal("Custom Status Modal", new Traits.Source(null, "Account Panel", "Avatar", null, null, 25, null));
        WidgetUserSetCustomStatus.INSTANCE.launch(context);
        dismiss();
    }

    @MainThread
    private final void updateStateAndDismiss(ClientStatus status) {
        getViewModel().setStatus(status);
        dismiss();
    }

    private final void updateView(WidgetUserStatusSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetUserStatusSheetViewModel.ViewState.Loaded) {
            getBinding().f18432b.updateViewState(((WidgetUserStatusSheetViewModel.ViewState.Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserStatusSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C102391(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f18436f.f814b.setImageResource(C5419R.drawable.ic_status_online_16dp);
        getBinding().f18436f.f816d.setText(C5419R.string.status_online);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding = getBinding().f18436f;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding, "binding.userStatusUpdateOnline");
        viewUserStatusPresenceBinding.f813a.setOnClickListener(new ViewOnClickListenerC102401());
        getBinding().f18434d.f814b.setImageResource(C5419R.drawable.ic_status_idle_16dp);
        getBinding().f18434d.f816d.setText(C5419R.string.status_idle);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding2 = getBinding().f18434d;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding2, "binding.userStatusUpdateIdle");
        viewUserStatusPresenceBinding2.f813a.setOnClickListener(new ViewOnClickListenerC102412());
        getBinding().f18433c.f814b.setImageResource(C5419R.drawable.ic_status_dnd_16dp);
        getBinding().f18433c.f816d.setText(C5419R.string.status_dnd);
        getBinding().f18433c.f815c.setText(C5419R.string.status_dnd_help);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding3 = getBinding().f18433c;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding3, "binding.userStatusUpdateDnd");
        viewUserStatusPresenceBinding3.f813a.setOnClickListener(new ViewOnClickListenerC102423());
        getBinding().f18435e.f814b.setImageResource(C5419R.drawable.ic_status_invisible_16dp);
        getBinding().f18435e.f816d.setText(C5419R.string.status_invisible);
        getBinding().f18435e.f815c.setText(C5419R.string.status_invisible_helper);
        ViewUserStatusPresenceBinding viewUserStatusPresenceBinding4 = getBinding().f18435e;
        Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceBinding4, "binding.userStatusUpdateInvisible");
        viewUserStatusPresenceBinding4.f813a.setOnClickListener(new ViewOnClickListenerC102434());
        getBinding().f18432b.setOnClickListener(new ViewOnClickListenerC102445());
        getBinding().f18432b.setOnClear(new C102456());
    }
}
