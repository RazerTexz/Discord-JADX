package com.discord.widgets.chat.input;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createAndConfigureExpressionFragment$onBackspacePressedListener$1 */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7747xeb2e4292 implements OnBackspacePressedListener {
    public final /* synthetic */ TextView $chatInput;

    public C7747xeb2e4292(TextView textView) {
        this.$chatInput = textView;
    }

    @Override // com.discord.widgets.chat.input.OnBackspacePressedListener
    public void onBackspacePressed() {
        this.$chatInput.dispatchKeyEvent(new KeyEvent(0, 67));
    }
}
