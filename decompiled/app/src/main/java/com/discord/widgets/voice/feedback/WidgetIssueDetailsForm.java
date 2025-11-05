package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.voice.feedback.IssueDetailsFormViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetIssueDetailsForm.kt */
/* loaded from: classes.dex */
public final class WidgetIssueDetailsForm extends AppFragment {
    public static final String ARG_PENDING_VOICE_FEEDBACK = "ARG_PENDING_VOICE_FEEDBACK";
    public static final String ARG_SHOW_CX_PROMPT = "ARG_SHOW_CX_PROMPT";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetIssueDetailsForm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0)};

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
            AppScreen2.d(context, WidgetIssueDetailsForm.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            TextInputLayout textInputLayout = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
            WidgetIssueDetailsForm.access$getViewModel$p(WidgetIssueDetailsForm.this).submitForm(ViewExtensions.getTextOrEmpty(textInputLayout));
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            MaterialButton materialButton = WidgetIssueDetailsForm.access$getBinding$p(WidgetIssueDetailsForm.this).d;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
            materialButton.setEnabled(editable.length() > 0);
        }
    }

    /* compiled from: WidgetIssueDetailsForm.kt */
    /* renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<IssueDetailsFormViewModel.Event, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IssueDetailsFormViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IssueDetailsFormViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetIssueDetailsForm.access$handleEvent(WidgetIssueDetailsForm.this, event);
        }
    }

    public WidgetIssueDetailsForm() {
        super(R.layout.widget_issue_details_form);
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
            AppToast.i(this, R.string.call_feedback_confirmation, 0, 4);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.hideKeyboard(getBinding().c);
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
        setActionBarTitle(R.string.feedback_modal_title);
        MaterialButton materialButton = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(false);
        getBinding().d.setOnClickListener(new AnonymousClass1());
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.issueDetailsInput");
        showKeyboard(textInputLayout2);
        LinkifiedTextView linkifiedTextView = getBinding().f2480b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.issueDetailsCxPrompt");
        linkifiedTextView.setVisibility(shouldShowCxPrompt() ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2480b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.issueDetailsCxPrompt");
        FormatUtils.n(linkifiedTextView2, R.string.feedback_need_more_help, new Object[]{AppHelpDesk.c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetIssueDetailsForm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
