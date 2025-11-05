package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2<T, R> implements b<StoreGuildTemplates.GuildTemplateState, Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model>> {
    public static final WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2 INSTANCE = new WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return call2(guildTemplateState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call2(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return ((guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Loading) || (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.LoadFailed)) ? new k(WidgetChatListAdapterItemGuildTemplate.Model.Loading.INSTANCE) : guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? new k(new WidgetChatListAdapterItemGuildTemplate.Model.Resolved(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate())) : new k(WidgetChatListAdapterItemGuildTemplate.Model.Invalid.INSTANCE);
    }
}
