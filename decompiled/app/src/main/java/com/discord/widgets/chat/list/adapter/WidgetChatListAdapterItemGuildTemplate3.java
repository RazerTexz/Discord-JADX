package com.discord.widgets.chat.list.adapter;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreGuildTemplates;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetChatListAdapterItemGuildTemplate.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildTemplate$ModelProvider$get$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildTemplate3<T, R> implements Func1<StoreGuildTemplates.GuildTemplateState, Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model>> {
    public static final WidgetChatListAdapterItemGuildTemplate3 INSTANCE = new WidgetChatListAdapterItemGuildTemplate3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return call2(guildTemplateState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChatListAdapterItemGuildTemplate.Model> call2(StoreGuildTemplates.GuildTemplateState guildTemplateState) {
        return ((guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Loading) || (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.LoadFailed)) ? new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Loading.INSTANCE) : guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved ? new ScalarSynchronousObservable(new WidgetChatListAdapterItemGuildTemplate.Model.Resolved(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate())) : new ScalarSynchronousObservable(WidgetChatListAdapterItemGuildTemplate.Model.Invalid.INSTANCE);
    }
}
