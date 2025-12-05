package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.GuildTemplateEntry;
import p658rx.functions.Action0;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate2 implements Action0 {
    public final /* synthetic */ GuildTemplateEntry $item;

    public WidgetChatListAdapterItemGuildTemplate2(GuildTemplateEntry guildTemplateEntry) {
        this.$item = guildTemplateEntry;
    }

    @Override // p658rx.functions.Action0
    public final void call() {
        StoreStream.INSTANCE.getGuildTemplates().maybeInitTemplateState(this.$item.getGuildTemplateCode());
    }
}
