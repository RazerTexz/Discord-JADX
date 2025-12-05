package com.discord.widgets.chat.input;

import android.view.View;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import p007b.p076b.p077a.p081f.KeyboardManager;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatInputAttachments.kt */
/* renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1 */
/* loaded from: classes2.dex */
public final class C7742xe5e506b2 implements KeyboardManager {
    public final /* synthetic */ WidgetChatInputAttachments.C77411 this$0;

    public C7742xe5e506b2(WidgetChatInputAttachments.C77411 c77411) {
        this.this$0 = c77411;
    }

    @Override // p007b.p076b.p077a.p081f.KeyboardManager
    public void requestDisplay(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        this.this$0.$fragment.showKeyboard(view);
    }

    @Override // p007b.p076b.p077a.p081f.KeyboardManager
    public void requestHide() {
        WidgetChatInputAttachments.C77411 c77411 = this.this$0;
        c77411.$fragment.hideKeyboard(WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).m9293l());
    }
}
