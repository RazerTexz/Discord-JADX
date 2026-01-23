package com.discord.widgets.bugreports;

import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetBugReport$validationManager$2 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetBugReport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetBugReport$validationManager$2(WidgetBugReport widgetBugReport) {
        super(0);
        this.this$0 = widgetBugReport;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetBugReport.access$getBinding$p(this.this$0).f15739h;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bugReportName");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(C5419R.string.bug_report_error_name_required)};
        TextInputLayout textInputLayout2 = WidgetBugReport.access$getBinding$p(this.this$0).f15741j;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bugReportPriority");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, inputValidatorArr), new Input.TextInputLayoutInput("priority", textInputLayout2, companion.createRequiredInputValidator(C5419R.string.bug_report_error_priority_required)));
    }
}
