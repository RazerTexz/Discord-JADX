package com.discord.widgets.user;

import com.discord.C5419R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetUserPasswordVerify.kt */
/* renamed from: com.discord.widgets.user.WidgetUserPasswordVerify$validationManager$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserPasswordVerify4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetUserPasswordVerify this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserPasswordVerify4(WidgetUserPasswordVerify widgetUserPasswordVerify) {
        super(0);
        this.this$0 = widgetUserPasswordVerify;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetUserPasswordVerify.access$getBinding$p(this.this$0).f18346c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountPasswordWrap");
        return new ValidationManager(new Input.TextInputLayoutInput(WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD, textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.password_required), AuthUtils.INSTANCE.createPasswordInputValidator(C5419R.string.password_length_error)));
    }
}
