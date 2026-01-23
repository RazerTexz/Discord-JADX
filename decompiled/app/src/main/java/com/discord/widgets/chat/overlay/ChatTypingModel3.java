package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import p637j0.p641k.Func1;

/* JADX INFO: renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$1, reason: use source file name */
/* JADX INFO: compiled from: ChatTypingModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatTypingModel3<T, R> implements Func1<Channel, Object[]> {
    public static final ChatTypingModel3 INSTANCE = new ChatTypingModel3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Object[] call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Object[] call2(Channel channel) {
        return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
    }
}
