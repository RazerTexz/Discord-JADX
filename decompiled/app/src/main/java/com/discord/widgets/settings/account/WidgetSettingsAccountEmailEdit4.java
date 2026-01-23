package com.discord.widgets.settings.account;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsAccountEmailEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccountEmailEdit4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetSettingsAccountEmailEdit this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAccountEmailEdit4(WidgetSettingsAccountEmailEdit widgetSettingsAccountEmailEdit) {
        super(0);
        this.this$0 = widgetSettingsAccountEmailEdit;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextInputLayout textInputLayout = WidgetSettingsAccountEmailEdit.access$getBinding$p(this.this$0).f17837d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.editAccountEmailWrap");
        return authUtils.createEmailValidationManager(textInputLayout);
    }
}
