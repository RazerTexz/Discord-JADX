package com.discord.widgets.auth;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.ValidationManager;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetAuthRegisterIdentity.kt */
/* renamed from: com.discord.widgets.auth.WidgetAuthRegisterIdentity$emailValidationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetAuthRegisterIdentity4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetAuthRegisterIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthRegisterIdentity4(WidgetAuthRegisterIdentity widgetAuthRegisterIdentity) {
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
        return AuthUtils.INSTANCE.createEmailValidationManager(WidgetAuthRegisterIdentity.access$getBinding$p(this.this$0).d.getMainTextInputLayout());
    }
}
