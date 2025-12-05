package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.models.application.Unread;
import p637j0.p641k.Func1;

/* compiled from: WidgetChatListModelMessages.kt */
/* renamed from: com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion$observeUnreadMarkerMessageId$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListModelMessages4<T, R> implements Func1<Unread, Long> {
    public static final WidgetChatListModelMessages4 INSTANCE = new WidgetChatListModelMessages4();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Long call(Unread unread) {
        return call2(unread);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Long call2(Unread unread) {
        Long messageId = unread.getMarker().getMessageId();
        return Long.valueOf(messageId != null ? messageId.longValue() : 0L);
    }
}
