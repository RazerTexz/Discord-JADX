package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.feedback.IssueDetailsFormViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetIssueDetailsForm.kt */
/* loaded from: classes.dex */
public final class WidgetIssueDetailsForm extends AppFragment {
    public static final String ARG_PENDING_VOICE_FEEDBACK = "ARG_PENDING_VOICE_FEEDBACK";
    public static final String ARG_SHOW_CX_PROMPT = "ARG_SHOW_CX_PROMPT";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetIssueDetailsForm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetIssueDetailsForm.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, PendingFeedback pendingFeedback, boolean showCxPrompt) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(pendingFeedback, "pendingFeedback");
            Intent intent = new Intent();
            intent.putExtra(WidgetIssueDetailsForm.ARG_PENDING_VOICE_FEEDBACK, pendingFeedback);
            intent.putExtra(WidgetIssueDetailsForm.ARG_SHOW_CX_PROMPT, showCxPrompt);
            AppScreen2.m156d(context, WidgetIssueDetailsForm.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$1 */
    public static final class ViewOnClickListenerC104501 implements View.OnClickListener {
        public ViewOnClickListenerC104501() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).f17207c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
            WidgetIssueDetailsForm.access$getViewModel$p(WidgetIssueDetailsForm.this).submitForm(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$2 */
    public static final class C104512 extends Lambda implements Function1<Editable, Unit> {
        public C104512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            MaterialButton materialButton = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).f17208d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
            materialButton.setEnabled(editable.length() > 0);
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBoundOrOnResume$1 */
    public static final class C104521 extends Lambda implements Function1<IssueDetailsFormViewModel.Event, Unit> {
        public C104521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IssueDetailsFormViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IssueDetailsFormViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetIssueDetailsForm.access$handleEvent(WidgetIssueDetailsForm.this, event);
        }
    }

    public WidgetIssueDetailsForm() {
        super(C5419R.layout.widget_issue_details_form);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetIssueDetailsForm2.INSTANCE, null, 2, null);
        WidgetIssueDetailsForm3 widgetIssueDetailsForm3 = new WidgetIssueDetailsForm3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(IssueDetailsFormViewModel.class), new WidgetIssueDetailsForm$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetIssueDetailsForm3));
    }

    public static final /* synthetic */ WidgetIssueDetailsFormBinding access$getBinding$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getBinding();
    }

    public static final /* synthetic */ PendingFeedback access$getPendingFeedback(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getPendingFeedback();
    }

    public static final /* synthetic */ IssueDetailsFormViewModel access$getViewModel$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetIssueDetailsForm widgetIssueDetailsForm, IssueDetailsFormViewModel.Event event) {
        widgetIssueDetailsForm.handleEvent(event);
    }

    private final WidgetIssueDetailsFormBinding getBinding() {
        return (WidgetIssueDetailsFormBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PendingFeedback getPendingFeedback() {
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(ARG_PENDING_VOICE_FEEDBACK);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.voice.feedback.PendingFeedback");
        return (PendingFeedback) serializableExtra;
    }

    private final IssueDetailsFormViewModel getViewModel() {
        return (IssueDetailsFormViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(IssueDetailsFormViewModel.Event event) {
        if (Intrinsics3.areEqual(event, IssueDetailsFormViewModel.Event.Close.INSTANCE)) {
            AppToast.m171i(this, C5419R.string.call_feedback_confirmation, 0, 4);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.hideKeyboard(getBinding().f17207c);
            }
            requireActivity().onBackPressed();
        }
    }

    private final boolean shouldShowCxPrompt() {
        return getMostRecentIntent().getBooleanExtra(ARG_SHOW_CX_PROMPT, false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.feedback_modal_title);
        MaterialButton materialButton = getBinding().f17208d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(false);
        getBinding().f17208d.setOnClickListener(new ViewOnClickListenerC104501());
        TextInputLayout textInputLayout = getBinding().f17207c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C104512());
        TextInputLayout textInputLayout2 = getBinding().f17207c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.issueDetailsInput");
        showKeyboard(textInputLayout2);
        LinkifiedTextView linkifiedTextView = getBinding().f17206b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.issueDetailsCxPrompt");
        linkifiedTextView.setVisibility(shouldShowCxPrompt() ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17206b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.issueDetailsCxPrompt");
        FormatUtils.m222n(linkifiedTextView2, C5419R.string.feedback_need_more_help, new Object[]{AppHelpDesk.m148c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetIssueDetailsForm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C104521(), 62, (Object) null);
    }
}
