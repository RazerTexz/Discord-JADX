package com.discord.widgets.user;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e4;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.presence.ClientStatus;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetUserStatusUpdateBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.WidgetUserStatusSheetViewModel;
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

/* compiled from: WidgetUserStatusSheet.kt */
/* loaded from: classes.dex */
public final class WidgetUserStatusSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetUserStatusSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserStatusUpdateBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetUserStatusSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Fragment fragment) {
            m.checkNotNullParameter(fragment, "fragment");
            WidgetUserStatusSheet widgetUserStatusSheet = new WidgetUserStatusSheet();
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetUserStatusSheet.show(parentFragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetUserStatusSheetViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetUserStatusSheet widgetUserStatusSheet) {
            super(1, widgetUserStatusSheet, WidgetUserStatusSheet.class, "updateView", "updateView(Lcom/discord/widgets/user/WidgetUserStatusSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetUserStatusSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetUserStatusSheetViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetUserStatusSheet.access$updateView((WidgetUserStatusSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.ONLINE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.IDLE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.DND);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet.access$updateStateAndDismiss(WidgetUserStatusSheet.this, ClientStatus.INVISIBLE);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetUserStatusSheet widgetUserStatusSheet = WidgetUserStatusSheet.this;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            WidgetUserStatusSheet.access$openCustomStatusAndDismiss(widgetUserStatusSheet, context);
        }
    }

    /* compiled from: WidgetUserStatusSheet.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserStatusSheet$onViewCreated$6, reason: invalid class name */
    public static final class AnonymousClass6 extends o implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetUserStatusSheet.access$clearCustomStatus(WidgetUserStatusSheet.this);
        }
    }

    public WidgetUserStatusSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetUserStatusSheet$binding$2.INSTANCE, null, 2, null);
        WidgetUserStatusSheet$viewModel$2 widgetUserStatusSheet$viewModel$2 = WidgetUserStatusSheet$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetUserStatusSheetViewModel.class), new WidgetUserStatusSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetUserStatusSheet$viewModel$2));
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
            getBinding().f2698b.updateViewState(((WidgetUserStatusSheetViewModel.ViewState.Loaded) viewState).getCustomStatusViewState());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_user_status_update;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        dismiss();
        super.onPause();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetUserStatusSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f.f106b.setImageResource(R.drawable.ic_status_online_16dp);
        getBinding().f.d.setText(R.string.status_online);
        e4 e4Var = getBinding().f;
        m.checkNotNullExpressionValue(e4Var, "binding.userStatusUpdateOnline");
        e4Var.a.setOnClickListener(new AnonymousClass1());
        getBinding().d.f106b.setImageResource(R.drawable.ic_status_idle_16dp);
        getBinding().d.d.setText(R.string.status_idle);
        e4 e4Var2 = getBinding().d;
        m.checkNotNullExpressionValue(e4Var2, "binding.userStatusUpdateIdle");
        e4Var2.a.setOnClickListener(new AnonymousClass2());
        getBinding().c.f106b.setImageResource(R.drawable.ic_status_dnd_16dp);
        getBinding().c.d.setText(R.string.status_dnd);
        getBinding().c.c.setText(R.string.status_dnd_help);
        e4 e4Var3 = getBinding().c;
        m.checkNotNullExpressionValue(e4Var3, "binding.userStatusUpdateDnd");
        e4Var3.a.setOnClickListener(new AnonymousClass3());
        getBinding().e.f106b.setImageResource(R.drawable.ic_status_invisible_16dp);
        getBinding().e.d.setText(R.string.status_invisible);
        getBinding().e.c.setText(R.string.status_invisible_helper);
        e4 e4Var4 = getBinding().e;
        m.checkNotNullExpressionValue(e4Var4, "binding.userStatusUpdateInvisible");
        e4Var4.a.setOnClickListener(new AnonymousClass4());
        getBinding().f2698b.setOnClickListener(new AnonymousClass5());
        getBinding().f2698b.setOnClear(new AnonymousClass6());
    }
}
