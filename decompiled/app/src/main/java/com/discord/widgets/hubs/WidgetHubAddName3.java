package com.discord.widgets.hubs;

import com.discord.C5419R;
import com.discord.utilities.view.validators.BasicTextInputValidator;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubAddName.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddName$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddName3 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubAddName this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddName3(WidgetHubAddName widgetHubAddName) {
        super(0);
        this.this$0 = widgetHubAddName;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = this.this$0.getBinding().f17141d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.discordHubAddNameInputLayout");
        return new ValidationManager(new Input.TextInputLayoutInput("binding.discordHubAddNameInputLayout", textInputLayout, BasicTextInputValidator.INSTANCE.createRequiredInputValidator(C5419R.string.member_verification_form_required_item)));
    }
}
