package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.utilities.uri.UriHandler;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Companion$bindUrlOnClick$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed2 implements View.OnClickListener {
    public final /* synthetic */ String $mask;
    public final /* synthetic */ String $url;

    public WidgetChatListAdapterItemEmbed2(String str, String str2) {
        this.$url = str;
        this.$mask = str2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        UriHandler.handleOrUntrusted(outline.m885x(view, "view", "view.context"), this.$url, this.$mask);
    }
}
