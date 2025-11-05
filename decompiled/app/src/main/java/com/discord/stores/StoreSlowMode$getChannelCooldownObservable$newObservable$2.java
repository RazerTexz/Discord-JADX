package com.discord.stores;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreSlowMode;
import d0.z.d.m;
import j0.k.b;
import j0.l.a.i2;
import j0.l.a.r;
import j0.l.e.k;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* compiled from: StoreSlowMode.kt */
/* loaded from: classes2.dex */
public final class StoreSlowMode$getChannelCooldownObservable$newObservable$2<T, R> implements b<Boolean, Observable<? extends Long>> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ StoreSlowMode.Type $type;
    public final /* synthetic */ StoreSlowMode this$0;

    /* compiled from: StoreSlowMode.kt */
    /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<HashMap<Long, Long>, Long> {
        public AnonymousClass1() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Long call(HashMap<Long, Long> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Long call2(HashMap<Long, Long> map) {
            return map.get(Long.valueOf(StoreSlowMode$getChannelCooldownObservable$newObservable$2.this.$channelId));
        }
    }

    /* compiled from: StoreSlowMode.kt */
    /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Long, Observable<? extends Long>> {

        /* compiled from: StoreSlowMode.kt */
        /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements b<Long, Long> {
            public final /* synthetic */ Long $nextSendTimeForChannel;
            public final /* synthetic */ long $now;

            public AnonymousClass1(Long l, long j) {
                this.$nextSendTimeForChannel = l;
                this.$now = j;
            }

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Long call(Long l) {
                return call2(l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Long l) {
                return Long.valueOf(this.$nextSendTimeForChannel.longValue() - (this.$now + (l.longValue() * 1000)));
            }
        }

        /* compiled from: StoreSlowMode.kt */
        /* renamed from: com.discord.stores.StoreSlowMode$getChannelCooldownObservable$newObservable$2$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02912<T, R> implements b<Long, Boolean> {
            public static final C02912 INSTANCE = new C02912();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ Boolean call(Long l) {
                return call2(l);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(Long l) {
                return Boolean.valueOf(l.longValue() >= 0);
            }
        }

        public AnonymousClass2() {
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends Long> call(Long l) {
            return call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends Long> call2(Long l) {
            long jCurrentTimeMillis = StoreSlowMode.access$getClock$p(StoreSlowMode$getChannelCooldownObservable$newObservable$2.this.this$0).currentTimeMillis();
            if (l == null || l.longValue() <= jCurrentTimeMillis) {
                return new k(0L);
            }
            Observable<R> observableG = Observable.E(0L, 1L, TimeUnit.SECONDS).G(new AnonymousClass1(l, jCurrentTimeMillis));
            return Observable.h0(new r(observableG.j, new i2(C02912.INSTANCE)));
        }
    }

    public StoreSlowMode$getChannelCooldownObservable$newObservable$2(StoreSlowMode storeSlowMode, StoreSlowMode.Type type, long j) {
        this.this$0 = storeSlowMode;
        this.$type = type;
        this.$channelId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(Boolean bool) {
        return call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(Boolean bool) {
        m.checkNotNullExpressionValue(bool, "shouldOverrideCooldown");
        if (bool.booleanValue()) {
            return new k(0L);
        }
        return (m.areEqual(this.$type, StoreSlowMode.Type.MessageSend.INSTANCE) ? StoreSlowMode.access$getMessageSendNextSendTimesSubject$p(this.this$0) : StoreSlowMode.access$getThreadCreateNextSendTimesSubject$p(this.this$0)).G(new AnonymousClass1()).Y(new AnonymousClass2());
    }
}
