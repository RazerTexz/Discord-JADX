package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.media.WidgetMedia;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed9 implements View.OnClickListener {
    public final /* synthetic */ MessageEmbed $embed$inlined;
    public final /* synthetic */ InlineMediaView $this_apply;

    public WidgetChatListAdapterItemEmbed9(InlineMediaView inlineMediaView, MessageEmbed messageEmbed) {
        this.$this_apply = inlineMediaView;
        this.$embed$inlined = messageEmbed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetMedia.Companion companion = WidgetMedia.INSTANCE;
        InlineMediaView inlineMediaView = this.$this_apply;
        Intrinsics3.checkNotNullExpressionValue(inlineMediaView, "this");
        Context context = inlineMediaView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "this.context");
        companion.launch(context, this.$embed$inlined);
    }
}
