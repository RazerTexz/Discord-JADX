package com.discord.widgets.auth;

import com.discord.C5419R;
import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetAuthRegisterIdentity.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$phoneValidationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity6 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity6(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
        super(0);
        this.this$0 = widgetAuthRegisterIdentity;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        return new ValidationManager(new Input.TextInputLayoutInput("phone", WidgetAuthRegisterIdentity.access$getBinding$p(this.this$0).f15711d.getMainTextInputLayout(), BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.phone_required), AuthUtils.INSTANCE.createPhoneInputValidator(C5419R.string.phone_invalid)));
    }
}
