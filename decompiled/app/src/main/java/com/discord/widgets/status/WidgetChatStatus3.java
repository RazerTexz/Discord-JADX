package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreMessageAck;
import com.discord.stores.StoreStream;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* compiled from: WidgetChatStatus.kt */
/* renamed from: com.discord.widgets.status.WidgetChatStatus$Model$Companion$get$isUnreadValidObs$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatStatus3<T, R> implements Func1<Long, Observable<? extends Boolean>> {
    public static final WidgetChatStatus3 INSTANCE = new WidgetChatStatus3();

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Boolean> call(Long l) {
        return call2(l);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Boolean> call2(Long l) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreMessageAck messageAck = companion.getMessageAck();
        Intrinsics3.checkNotNullExpressionValue(l, "selectedChannelId");
        Observable<StoreMessageAck.Ack> observableObserveForChannel = messageAck.observeForChannel(l.longValue());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return Observable.m(new ScalarSynchronousObservable(Boolean.FALSE), Observable.j(observableObserveForChannel.p(200L, timeUnit), companion.getMessagesMostRecent().observeRecentMessageIds(l.longValue()).p(200L, timeUnit).Z(1), WidgetChatStatus4.INSTANCE).b0(WidgetChatStatus5.INSTANCE));
    }
}
