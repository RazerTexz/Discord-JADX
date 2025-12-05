package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift;
import p007b.p008a.p009a.p011a0.WidgetGiftAcceptDialog;

/* compiled from: WidgetChatListAdapterItemGift.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGift$configureResolvedUI$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGift5 implements View.OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGift.Model.Resolved $model$inlined;
    public final /* synthetic */ WidgetChatListAdapterItemGift this$0;

    public WidgetChatListAdapterItemGift5(WidgetChatListAdapterItemGift widgetChatListAdapterItemGift, WidgetChatListAdapterItemGift.Model.Resolved resolved) {
        this.this$0 = widgetChatListAdapterItemGift;
        this.$model$inlined = resolved;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGiftAcceptDialog.INSTANCE.m107a(this.$model$inlined.getGift().getCode(), "Embed", WidgetChatListAdapterItemGift.access$getItem$p(this.this$0).getChannelId());
    }
}
