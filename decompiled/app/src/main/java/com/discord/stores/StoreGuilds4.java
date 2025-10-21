package com.discord.stores;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreGuilds.kt */
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds4<T, R> implements Func1<String, Observable<? extends Long>> {
    public static final StoreGuilds4 INSTANCE = new StoreGuilds4();

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Long> {
        public final /* synthetic */ String $query;

        public AnonymousClass1(String str) {
            this.$query = str;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Long l) {
            call2(l);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Long l) {
            StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
            Intrinsics3.checkNotNullExpressionValue(l, "selectedGuildId");
            StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, l.longValue(), this.$query, null, null, 12, null);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(String str) {
        return StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().u(new AnonymousClass1(str));
    }
}
