package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OperatorTakeWhile;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2, reason: use source file name */
/* JADX INFO: compiled from: StoreSlowMode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSlowMode3<T, R> implements Func1<Boolean, Observable<? extends Long>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    /* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$1 */
    /* JADX INFO: compiled from: StoreSlowMode.kt */
    public static final class C64001<T, R> implements Func1<HashMap<Long, Long>, Long> {
        public C64001() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Long call(HashMap<Long, Long> map) {
            return call2(map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(HashMap<Long, Long> map) {
            return map.get(Long.valueOf(StoreSlowMode3.this.$channelId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2 */
    /* JADX INFO: compiled from: StoreSlowMode.kt */
    public static final class C64012<T, R> implements Func1<Long, Observable<? extends Long>> {

        /* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSlowMode.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Long, Long> {
            public final /* synthetic */ Long $nextSendTimeForChannel;
            public final /* synthetic */ long $now;

            public AnonymousClass1(Long l, long j) {
                this.$nextSendTimeForChannel = l;
                this.$now = j;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Long call(Long l) {
                return call2(l);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Long l) {
                return Long.valueOf(this.$nextSendTimeForChannel.longValue() - (this.$now + (l.longValue() * 1000)));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreSlowMode.kt */
        public static final class AnonymousClass2<T, R> implements Func1<Long, Boolean> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(Long l) {
                return call2(l);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Long l) {
                return Boolean.valueOf(l.longValue() >= 0);
            }
        }

        public C64012() {
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
            return call2(l);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Long l) {
            long jCurrentTimeMillis = StoreSlowMode.access$getClock$p(StoreSlowMode3.this.this$0).currentTimeMillis();
            if (l == null || l.longValue() <= jCurrentTimeMillis) {
                return new ScalarSynchronousObservable(0L);
            }
            Observable<R> observableM11083G = Observable.m11061E(0L, 1L, TimeUnit.SECONDS).m11083G(new AnonymousClass1(l, jCurrentTimeMillis));
            return Observable.m11074h0(new OnSubscribeLift(observableM11083G.f27640j, new OperatorTakeWhile(AnonymousClass2.INSTANCE)));
        }
    }

    public StoreSlowMode3(StoreSlowMode storeSlowMode, StoreSlowMode.Type type, long j) {
        this.this$0 = storeSlowMode;
        this.$type = type;
        this.$channelId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
        if (bool.booleanValue()) {
            return new ScalarSynchronousObservable(0L);
        }
        return (Intrinsics3.areEqual(this.$type, StoreSlowMode.Type.MessageSend.INSTANCE) ? StoreSlowMode.access$getMessageSendNextSendTimesSubject$p(this.this$0) : StoreSlowMode.access$getThreadCreateNextSendTimesSubject$p(this.this$0)).m11083G(new C64001()).m11099Y(new C64012());
    }
}
