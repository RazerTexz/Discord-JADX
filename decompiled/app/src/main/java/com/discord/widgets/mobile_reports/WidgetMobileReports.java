package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.ReportNodeChild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMobileReportsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import com.discord.widgets.mobile_reports.WidgetMobileReports2;
import d0.LazyJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetMobileReports.kt */
/* loaded from: classes2.dex */
public final class WidgetMobileReports extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMobileReports.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMobileReportsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetMobileReports.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launchDirectoryServerReport(Context context, long guildId, long hubId, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.DirectoryServer(guildId, hubId, channelId));
        }

        public final void launchGuildScheduledEventReport(Context context, long guildId, long eventId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.GuildScheduledEvent(guildId, eventId));
        }

        public final void launchMessageReport(Context context, long messageId, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.Message(messageId, channelId));
        }

        public final void launchStageChannelReport(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.d(context, WidgetMobileReports.class, new WidgetMobileReports2.StageChannel(channelId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!this.$viewState.shouldHideBackArrow());
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ReportsMenuNode $nextNodeView;
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* compiled from: WidgetMobileReports.kt */
        /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!r0.$viewState.shouldHideBackArrow());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ReportsMenuNode reportsMenuNode, MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$nextNodeView = reportsMenuNode;
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getBinding$p(WidgetMobileReports.this).f2496b.removeAllViewsInLayout();
            WidgetMobileReports.access$getBinding$p(WidgetMobileReports.this).f2496b.addView(this.$nextNodeView);
            ViewExtensions.fadeIn$default(this.$nextNodeView, 0L, null, null, new AnonymousClass1(), 7, null);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            invoke2(reportNodeChild, nodeState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            Intrinsics3.checkNotNullParameter(reportNodeChild, "destination");
            Intrinsics3.checkNotNullParameter(nodeState, "nodeState");
            MobileReportsViewModel mobileReportsViewModelAccess$getViewModel$p = WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this);
            MobileReportsViewModel.CheckboxElement checkboxElement = nodeState.getCheckboxElement();
            mobileReportsViewModelAccess$getViewModel$p.handleNext(reportNodeChild, checkboxElement != null ? new NodeElementResult(checkboxElement.getName(), _Collections.toList(checkboxElement.getSelections())) : null);
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this).handleBlockUser();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetMobileReports.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.access$getViewModel$p(WidgetMobileReports.this).handleSubmit();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<Boolean> {
        public AnonymousClass1(MobileReportsViewModel mobileReportsViewModel) {
            super(0, mobileReportsViewModel, MobileReportsViewModel.class, "handleBack", "handleBack()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ((MobileReportsViewModel) this.receiver).handleBack();
        }
    }

    /* compiled from: WidgetMobileReports.kt */
    /* renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<MobileReportsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MobileReportsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MobileReportsViewModel.ViewState viewState) {
            AppActivity appActivity;
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            if (viewState instanceof MobileReportsViewModel.ViewState.Menu) {
                WidgetMobileReports.access$configureUI(WidgetMobileReports.this, (MobileReportsViewModel.ViewState.Menu) viewState);
            } else {
                if (!(viewState instanceof MobileReportsViewModel.ViewState.Invalid) || (appActivity = WidgetMobileReports.this.getAppActivity()) == null) {
                    return;
                }
                appActivity.finish();
            }
        }
    }

    public WidgetMobileReports() {
        super(R.layout.widget_mobile_reports);
        this.args = LazyJVM.lazy(new WidgetMobileReports$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetMobileReports5 widgetMobileReports5 = new WidgetMobileReports5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MobileReportsViewModel.class), new WidgetMobileReports$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMobileReports5));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMobileReports3.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetMobileReports widgetMobileReports, MobileReportsViewModel.ViewState.Menu menu) {
        widgetMobileReports.configureUI(menu);
    }

    public static final /* synthetic */ WidgetMobileReports2 access$getArgs$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getArgs();
    }

    public static final /* synthetic */ WidgetMobileReportsBinding access$getBinding$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getBinding();
    }

    public static final /* synthetic */ MobileReportsViewModel access$getViewModel$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getViewModel();
    }

    private final void configureUI(MobileReportsViewModel.ViewState.Menu viewState) {
        setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        ProgressBar progressBar = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.mobileReportsProgressBar");
        progressBar.setVisibility(8);
        ReportsMenuNode reportsMenuNode = (ReportsMenuNode) getBinding().f2496b.getChildAt(0);
        MobileReportsViewModel.NodeState nodeStateGenNodeState = viewState.genNodeState();
        if (reportsMenuNode == null) {
            ReportsMenuNode reportsMenuNodeCreateNodeView = createNodeView(viewState);
            reportsMenuNodeCreateNodeView.setVisibility(8);
            getBinding().f2496b.addView(reportsMenuNodeCreateNodeView);
            ViewExtensions.fadeIn$default(reportsMenuNodeCreateNodeView, 0L, null, null, new AnonymousClass1(viewState), 7, null);
            return;
        }
        if (!(!Intrinsics3.areEqual(reportsMenuNode.getPrevViewState() != null ? r3.getNode() : null, nodeStateGenNodeState.getNode()))) {
            reportsMenuNode.setup(nodeStateGenNodeState);
            setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        } else {
            ReportsMenuNode reportsMenuNodeCreateNodeView2 = createNodeView(viewState);
            reportsMenuNodeCreateNodeView2.setVisibility(8);
            ViewExtensions.fadeOut$default(reportsMenuNode, 0L, null, new AnonymousClass2(reportsMenuNodeCreateNodeView2, viewState), 3, null);
        }
    }

    private final ReportsMenuNode createNodeView(MobileReportsViewModel.ViewState.Menu viewState) {
        ReportsMenuNode reportsMenuNode = new ReportsMenuNode(requireContext());
        reportsMenuNode.setHandleSelectChild(new AnonymousClass1());
        reportsMenuNode.setHandleBlock(new AnonymousClass2());
        reportsMenuNode.setHandleCancel(new AnonymousClass3());
        reportsMenuNode.setHandleSubmit(new AnonymousClass4());
        reportsMenuNode.setup(viewState.genNodeState());
        return reportsMenuNode;
    }

    private final WidgetMobileReports2 getArgs() {
        return (WidgetMobileReports2) this.args.getValue();
    }

    private final WidgetMobileReportsBinding getBinding() {
        return (WidgetMobileReportsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MobileReportsViewModel getViewModel() {
        return (MobileReportsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AppFragment.setOnBackPressed$default(this, new WidgetMobileReports4(new AnonymousClass1(getViewModel())), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMobileReports.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
