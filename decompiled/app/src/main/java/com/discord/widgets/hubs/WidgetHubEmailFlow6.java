package com.discord.widgets.hubs;

import com.discord.utilities.auth.AuthUtils;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$validationManager$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow6 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow6(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(0);
        this.this$0 = widgetHubEmailFlow;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        AuthUtils authUtils = AuthUtils.INSTANCE;
        TextInputLayout textInputLayout = WidgetHubEmailFlow.access$getBinding$p(this.this$0).f17175c.f820d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.discordHubEmailI…scriptionEmailInputLayout");
        return authUtils.createEmailValidationManager(textInputLayout);
    }
}
