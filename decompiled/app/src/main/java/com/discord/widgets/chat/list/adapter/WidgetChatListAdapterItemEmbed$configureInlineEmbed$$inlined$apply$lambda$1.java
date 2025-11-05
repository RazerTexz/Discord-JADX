package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.widgets.chat.list.InlineMediaView;
import com.discord.widgets.media.WidgetMedia;
import d0.z.d.m;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ MessageEmbed $embed$inlined;
    public final /* synthetic */ InlineMediaView $this_apply;

    public WidgetChatListAdapterItemEmbed$configureInlineEmbed$$inlined$apply$lambda$1(InlineMediaView inlineMediaView, MessageEmbed messageEmbed) {
        this.$this_apply = inlineMediaView;
        this.$embed$inlined = messageEmbed;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetMedia.Companion companion = WidgetMedia.INSTANCE;
        InlineMediaView inlineMediaView = this.$this_apply;
        m.checkNotNullExpressionValue(inlineMediaView, "this");
        Context context = inlineMediaView.getContext();
        m.checkNotNullExpressionValue(context, "this.context");
        companion.launch(context, this.$embed$inlined);
    }
}
