package com.discord.widgets.settings.account;

import com.discord.C5419R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountChangePassword.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountChangePassword3 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountChangePassword this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountChangePassword3(WidgetSettingsAccountChangePassword widgetSettingsAccountChangePassword) {
        super(0);
        this.this$0 = widgetSettingsAccountChangePassword;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17820c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.changePasswordCurrentPasswordInput");
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        BasicTextInputValidator[] basicTextInputValidatorArr = {companion.createRequiredInputValidator(C5419R.string.password_required)};
        TextInputLayout textInputLayout2 = this.this$0.getBinding().f17821d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.changePasswordNewPasswordInput");
        return new ValidationManager(new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, basicTextInputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.NEW_PASSWORD_FIELD, textInputLayout2, companion.createRequiredInputValidator(C5419R.string.password_requirements_empty)));
    }
}
