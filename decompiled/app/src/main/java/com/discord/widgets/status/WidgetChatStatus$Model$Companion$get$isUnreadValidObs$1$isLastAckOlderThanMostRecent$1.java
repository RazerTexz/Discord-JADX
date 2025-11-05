package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import d0.z.d.m;
import rx.functions.Func2;

/* compiled from: WidgetChatStatus.kt */
/* loaded from: classes2.dex */
public final class WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1<T1, T2, R> implements Func2<StoreMessageAck.Ack, Long, Boolean> {
    public static final WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1 INSTANCE = new WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(StoreMessageAck.Ack ack, Long l) {
        return call2(ack, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessageAck.Ack ack, Long l) {
        long messageId = ack != null ? ack.getMessageId() : 0L;
        m.checkNotNullExpressionValue(l, "mostRecentIdSnapshot");
        return Boolean.valueOf(messageId < l.longValue());
    }
}
