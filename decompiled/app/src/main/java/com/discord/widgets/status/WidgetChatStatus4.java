package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: WidgetChatStatus.kt */
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus4<T1, T2, R> implements Func2<StoreMessageAck.Ack, Long, Boolean> {
    public static final WidgetChatStatus4 INSTANCE = new WidgetChatStatus4();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(StoreMessageAck.Ack ack, Long l) {
        return call2(ack, l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(StoreMessageAck.Ack ack, Long l) {
        long messageId = ack != null ? ack.getMessageId() : 0L;
        Intrinsics3.checkNotNullExpressionValue(l, "mostRecentIdSnapshot");
        return Boolean.valueOf(messageId < l.longValue());
    }
}
