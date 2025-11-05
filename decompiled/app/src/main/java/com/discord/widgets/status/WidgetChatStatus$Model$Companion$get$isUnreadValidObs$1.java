package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* compiled from: WidgetChatStatus.kt */
/* loaded from: classes2.dex */
public final class WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1<T, R> implements b<Long, Observable<? extends Boolean>> {
    public static final WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1 INSTANCE = new WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Long l) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreMessageAck messageAck = companion.getMessageAck();
        m.checkNotNullExpressionValue(l, "selectedChannelId");
        Observable<StoreMessageAck.Ack> observableObserveForChannel = messageAck.observeForChannel(l.longValue());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.m(new k(Boolean.FALSE), Observable.j(observableObserveForChannel.p(200L, timeUnit), companion.getMessagesMostRecent().observeRecentMessageIds(l.longValue()).p(200L, timeUnit).Z(1), WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$1.INSTANCE).b0(WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1$isLastAckOlderThanMostRecent$2.INSTANCE));
    }
}
