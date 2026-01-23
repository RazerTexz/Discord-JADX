package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.message.Message;
import kotlin.Tuples2;
import p507d0.Tuples;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions2<T1, T2, R> implements Func2<Message, Channel, Tuples2<? extends Message, ? extends Channel>> {
    public static final WidgetChatListActions2 INSTANCE = new WidgetChatListActions2();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Tuples2<? extends Message, ? extends Channel> call(Message message, Channel channel) {
        return call2(message, channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Tuples2<Message, Channel> call2(Message message, Channel channel) {
        return Tuples.m10073to(message, channel);
    }
}
