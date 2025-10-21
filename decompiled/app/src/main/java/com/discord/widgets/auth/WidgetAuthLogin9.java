package com.discord.widgets.auth;

import com.discord.R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAuthLogin.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthLogin$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthLogin9 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin9(WidgetAuthLogin widgetAuthLogin) {
        super(0);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout mainTextInputLayout = WidgetAuthLogin.access$getBinding$p(this.this$0).e.getMainTextInputLayout();
        BasicTextInputValidator.Companion companion = BasicTextInputValidator.INSTANCE;
        InputValidator[] inputValidatorArr = {companion.createRequiredInputValidator(R.string.login_required)};
        TextInputLayout textInputLayout = WidgetAuthLogin.access$getBinding$p(this.this$0).g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.authLoginPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput("binding.authLogin", mainTextInputLayout, inputValidatorArr), new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, companion.createRequiredInputValidator(R.string.password_required)));
    }
}
