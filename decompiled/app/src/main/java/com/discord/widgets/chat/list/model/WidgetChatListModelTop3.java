package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelTop$Companion$getWelcomeEntry$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelTop3<T, R> implements Func1<Channel, Long> {
    public static final WidgetChatListModelTop3 INSTANCE = new WidgetChatListModelTop3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Long call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Channel channel) {
        return Long.valueOf(channel != null ? channel.getId() : 0L);
    }
}
