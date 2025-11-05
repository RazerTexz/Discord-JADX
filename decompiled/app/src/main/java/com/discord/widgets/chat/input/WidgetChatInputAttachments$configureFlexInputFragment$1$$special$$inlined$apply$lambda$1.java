package com.discord.widgets.chat.input;

import android.view.View;
import b.b.a.f.a;
import com.discord.widgets.chat.input.WidgetChatInputAttachments;
import d0.z.d.m;

/* compiled from: WidgetChatInputAttachments.kt */
/* loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1 implements a {
    public final /* synthetic */ WidgetChatInputAttachments.AnonymousClass1 this$0;

    public WidgetChatInputAttachments$configureFlexInputFragment$1$$special$$inlined$apply$lambda$1(WidgetChatInputAttachments.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // b.b.a.f.a
    public void requestDisplay(View view) {
        m.checkNotNullParameter(view, "view");
        this.this$0.$fragment.showKeyboard(view);
    }

    @Override // b.b.a.f.a
    public void requestHide() {
        WidgetChatInputAttachments.AnonymousClass1 anonymousClass1 = this.this$0;
        anonymousClass1.$fragment.hideKeyboard(WidgetChatInputAttachments.access$getFlexInputFragment$p(WidgetChatInputAttachments.this).l());
    }
}
