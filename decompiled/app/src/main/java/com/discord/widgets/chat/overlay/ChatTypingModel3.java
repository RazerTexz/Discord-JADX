package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import j0.k.Func1;

/* compiled from: ChatTypingModel.kt */
/* renamed from: com.discord.widgets.chat.overlay.ChatTypingModel$Companion$getTypingObservableForChannel$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ChatTypingModel3<T, R> implements Func1<Channel, Object[]> {
    public static final ChatTypingModel3 INSTANCE = new ChatTypingModel3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Object[] call(Channel channel) {
        return call2(channel);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Object[] call2(Channel channel) {
        return channel != null ? new Object[]{Long.valueOf(channel.getId()), Long.valueOf(channel.getGuildId()), Integer.valueOf(channel.getRateLimitPerUser())} : new Object[0];
    }
}
