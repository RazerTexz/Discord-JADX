package com.discord.stores;

import androidx.core.app.NotificationCompat;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;

/* compiled from: StoreGuilds.kt */
/* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreGuilds4<T, R> implements Func1<String, Observable<? extends Long>> {
    public static final StoreGuilds4 INSTANCE = new StoreGuilds4();

    /* compiled from: StoreGuilds.kt */
    /* renamed from: com.discord.stores.StoreGuilds$Actions$requestMembers$3$1 */
    public static final class C60941<T> implements Action1<Long> {
        public final /* synthetic */ String $query;

        public C60941(String str) {
            this.$query = str;
        }

        @Override // p658rx.functions.Action1
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

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Long> call(String str) {
        return call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Long> call2(String str) {
        return StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().m11115u(new C60941(str));
    }
}
