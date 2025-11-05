package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.b;

/* compiled from: WidgetChatListModelTop.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion$getWelcomeEntry$1<T, R> implements b<Channel, Long> {
    public static final WidgetChatListModelTop$Companion$getWelcomeEntry$1 INSTANCE = new WidgetChatListModelTop$Companion$getWelcomeEntry$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Long call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Channel channel) {
        return Long.valueOf(channel != null ? channel.getId() : 0L);
    }
}
