package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import com.discord.C5419R;
import com.google.android.material.textfield.TextInputLayout;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetDisableGuildCommunication.kt */
/* renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication3 implements View.OnFocusChangeListener {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication3(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (!z2) {
            WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).f16477d.setHint(C5419R.string.guild_communication_disabled_reason_hint_android);
            return;
        }
        TextInputLayout textInputLayout = WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).f16477d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
        textInputLayout.setHint("");
    }
}
