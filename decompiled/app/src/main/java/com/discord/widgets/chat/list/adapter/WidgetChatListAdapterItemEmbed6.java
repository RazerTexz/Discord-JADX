package com.discord.widgets.chat.list.adapter;

import com.discord.simpleast.core.node.Node;
import com.discord.utilities.textprocessing.node.UrlNode;
import p007b.p008a.p050t.p052b.p055c.NodeProcessor;
import p507d0.p579g0.StringsJVM;

/* compiled from: WidgetChatListAdapterItemEmbed.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemEmbed$Model$isEmbedUrlFoundInVisibleSpoilerNode$1$2$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemEmbed6 implements NodeProcessor {
    public final /* synthetic */ String $targetUrl;

    public WidgetChatListAdapterItemEmbed6(String str) {
        this.$targetUrl = str;
    }

    @Override // p007b.p008a.p050t.p052b.p055c.NodeProcessor
    public final void processNode(Node<Object> node) {
        if ((node instanceof UrlNode) && StringsJVM.equals(((UrlNode) node).getUrl(), this.$targetUrl, true)) {
            throw new WidgetChatListAdapterItemEmbed7();
        }
    }
}
