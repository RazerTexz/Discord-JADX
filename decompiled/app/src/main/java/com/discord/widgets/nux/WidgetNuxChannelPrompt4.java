package com.discord.widgets.nux;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.validators.Input;
import com.discord.utilities.view.validators.InputValidator;
import com.discord.utilities.view.validators.ValidationManager;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetNuxChannelPrompt.kt */
/* renamed from: com.discord.widgets.nux.WidgetNuxChannelPrompt$validationManager$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetNuxChannelPrompt4 extends Lambda implements Function0<ValidationManager> {
    public final /* synthetic */ WidgetNuxChannelPrompt this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetNuxChannelPrompt4(WidgetNuxChannelPrompt widgetNuxChannelPrompt) {
        super(0);
        this.this$0 = widgetNuxChannelPrompt;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ValidationManager invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ValidationManager invoke() {
        TextInputLayout textInputLayout = WidgetNuxChannelPrompt.access$getBinding$p(this.this$0).g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.nufChannelPromptTopicWrap");
        return new ValidationManager(new Input.TextInputLayoutInput(ModelAuditLogEntry.CHANGE_KEY_NAME, textInputLayout, new InputValidator[0]));
    }
}
