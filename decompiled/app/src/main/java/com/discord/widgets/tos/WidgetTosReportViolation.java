package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.report.ReportReason;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolationViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetTosReportViolation.kt */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetTosReportViolation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHANNEL_ID = "EXTRA_CHANNEL_ID";
    private static final String EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID";
    private static final String EXTRA_TARGET = "EXTRA_TARGET";

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetTosReportViolation.kt */
    public static final class Companion {

        /* compiled from: WidgetTosReportViolation.kt */
        public static final /* data */ class Arguments {
            private final long channelId;
            private final long messageId;
            private final String target;

            public Arguments(String str, long j, long j2) {
                Intrinsics3.checkNotNullParameter(str, "target");
                this.target = str;
                this.channelId = j;
                this.messageId = j2;
            }

            public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = arguments.target;
                }
                if ((i & 2) != 0) {
                    j = arguments.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = arguments.messageId;
                }
                return arguments.copy(str, j3, j2);
            }

            /* renamed from: component1, reason: from getter */
            public final String getTarget() {
                return this.target;
            }

            /* renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            public final Arguments copy(String target, long channelId, long messageId) {
                Intrinsics3.checkNotNullParameter(target, "target");
                return new Arguments(target, channelId, messageId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Arguments)) {
                    return false;
                }
                Arguments arguments = (Arguments) other;
                return Intrinsics3.areEqual(this.target, arguments.target) && this.channelId == arguments.channelId && this.messageId == arguments.messageId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final String getTarget() {
                return this.target;
            }

            public int hashCode() {
                String str = this.target;
                return C0002b.m3a(this.messageId) + ((C0002b.m3a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("Arguments(target=");
                sbM833U.append(this.target);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", messageId=");
                return outline.m815C(sbM833U, this.messageId, ")");
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, Long l, Long l2, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            if ((i & 8) != 0) {
                l2 = null;
            }
            companion.show(context, str, l, l2);
        }

        public final void show(Context context, String target, Long channelId, Long messageId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(target, "target");
            Intent intent = new Intent();
            intent.putExtra(WidgetTosReportViolation.EXTRA_CHANNEL_ID, channelId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_TARGET, target);
            AppScreen2.m156d(context, WidgetTosReportViolation.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$1 */
    public static final class ViewOnClickListenerC101741 implements View.OnClickListener {
        public ViewOnClickListenerC101741() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation.this).sendReport();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleReportSubmissionError$1 */
    public static final class C101751 extends Lambda implements Function0<Unit> {
        public C101751() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation.this).handleDismissError();
        }
    }

    /* compiled from: WidgetTosReportViolation.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C101761 extends FunctionReferenceImpl implements Function1<WidgetTosReportViolationViewModel.ViewState, Unit> {
        public C101761(WidgetTosReportViolation widgetTosReportViolation) {
            super(1, widgetTosReportViolation, WidgetTosReportViolation.class, "configureUI", "configureUI(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetTosReportViolationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetTosReportViolation.access$configureUI((WidgetTosReportViolation) this.receiver, viewState);
        }
    }

    public WidgetTosReportViolation() {
        super(C5419R.layout.widget_tos_report_violation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTosReportViolation3.INSTANCE, null, 2, null);
        WidgetTosReportViolation5 widgetTosReportViolation5 = new WidgetTosReportViolation5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetTosReportViolationViewModel.class), new WidgetTosReportViolation$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTosReportViolation5));
        this.args = LazyJVM.lazy(new WidgetTosReportViolation2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetTosReportViolation widgetTosReportViolation, WidgetTosReportViolationViewModel.ViewState viewState) {
        widgetTosReportViolation.configureUI(viewState);
    }

    public static final /* synthetic */ Companion.Arguments access$getArgs$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getArgs();
    }

    public static final /* synthetic */ WidgetTosReportViolationBinding access$getBinding$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getBinding();
    }

    public static final /* synthetic */ WidgetTosReportViolationViewModel access$getViewModel$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getViewModel();
    }

    private final void configureUI(WidgetTosReportViolationViewModel.ViewState viewState) {
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loading) {
            handleLoading();
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loaded) {
            handleLoaded(((WidgetTosReportViolationViewModel.ViewState.Loaded) viewState).getReasons());
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitting) {
            handleReportSubmitting(((WidgetTosReportViolationViewModel.ViewState.Submitting) viewState).getReason());
        } else if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitted) {
            handleReportSubmitted();
        } else {
            if (!(viewState instanceof WidgetTosReportViolationViewModel.ViewState.SubmissionError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleReportSubmissionError();
        }
    }

    private final Companion.Arguments getArgs() {
        return (Companion.Arguments) this.args.getValue();
    }

    private final WidgetTosReportViolationBinding getBinding() {
        return (WidgetTosReportViolationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetTosReportViolationViewModel getViewModel() {
        return (WidgetTosReportViolationViewModel) this.viewModel.getValue();
    }

    private final void handleLoaded(List<ReportReason> reasons) {
        ProgressBar progressBar = getBinding().f18306f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(8);
        LoadingButton loadingButton = getBinding().f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(getViewModel().getReasonSelected() != null);
        getBinding().f18302b.setIsLoading(false);
        getBinding().f18302b.setOnClickListener(new ViewOnClickListenerC101741());
        TextView textView = getBinding().f18305e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportReasonsHeader");
        textView.setVisibility(0);
        getBinding().f18304d.removeAllViews();
        for (ReportReason reportReason : reasons) {
            WidgetTosReportViolationReasonView widgetTosReportViolationReasonView = new WidgetTosReportViolationReasonView(requireContext(), null, 0, 6, null);
            if (!ViewCompat.isLaidOut(widgetTosReportViolationReasonView) || widgetTosReportViolationReasonView.isLayoutRequested()) {
                widgetTosReportViolationReasonView.addOnLayoutChangeListener(new WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(widgetTosReportViolationReasonView, reportReason, this));
            } else {
                widgetTosReportViolationReasonView.setReason(reportReason);
                widgetTosReportViolationReasonView.setChecked(Intrinsics3.areEqual(reportReason, access$getViewModel$p(this).getReasonSelected()));
                widgetTosReportViolationReasonView.setOnClickListener(new WidgetTosReportViolation4(widgetTosReportViolationReasonView, reportReason, this));
            }
            getBinding().f18304d.addView(widgetTosReportViolationReasonView);
        }
    }

    private final void handleLoading() {
        ProgressBar progressBar = getBinding().f18306f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(0);
        LoadingButton loadingButton = getBinding().f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18304d.removeAllViews();
    }

    private final void handleReportSubmissionError() {
        LoadingButton loadingButton = getBinding().f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18302b.setIsLoading(false);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.m219k(this, C5419R.string.notice_dispatch_error, new Object[0], null, 4), FormatUtils.m219k(this, C5419R.string.report_modal_error, new Object[]{"https://dis.gd/request"}, null, 4), FormatUtils.m219k(this, C5419R.string.okay, new Object[0], null, 4), null, null, null, null, null, null, null, null, 0, new C101751(), 8176, null);
    }

    private final void handleReportSubmitted() {
        AppToast.m171i(this, C5419R.string.report_modal_submitted, 0, 4);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final void handleReportSubmitting(int reason) {
        LinearLayout linearLayout = getBinding().f18304d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
        Iterator<View> it = ViewGroup.getChildren(linearLayout).iterator();
        while (it.hasNext()) {
            it.next().setEnabled(false);
        }
        LoadingButton loadingButton = getBinding().f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18302b.setIsLoading(true);
        getViewModel().sendReportAPICall(reason, getArgs().getChannelId(), getArgs().getMessageId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.report);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f18303c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportHeader");
        FormatUtils.m222n(textView, C5419R.string.report_message, new Object[]{getArgs().getTarget()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().f18307g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportTooltip");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.form_report_help_text, new Object[]{"https://discord.com/guidelines"}, null, 4);
        getBinding().f18302b.setIsLoading(false);
        LoadingButton loadingButton = getBinding().f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetTosReportViolation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101761(this), 62, (Object) null);
    }
}
