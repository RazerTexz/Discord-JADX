package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Map;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3<T, R> implements Func1<Map<Long, Integer>, Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3();

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, R> implements Func3<Map<Long, ? extends Presence>, Map<Long, ? extends User>, Map<Long, ? extends ModelApplicationStream>, WidgetGroupInviteFriends.Model.ModelAppUserRelationship> {
        public final /* synthetic */ Map $filteredFriends;

        public AnonymousClass1(Map map) {
            this.$filteredFriends = map;
        }

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.ModelAppUserRelationship call(Map<Long, ? extends Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            return call2((Map<Long, Presence>) map, map2, map3);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetGroupInviteFriends.Model.ModelAppUserRelationship call2(Map<Long, Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Map map4 = this.$filteredFriends;
            Intrinsics3.checkNotNullExpressionValue(map4, "filteredFriends");
            Intrinsics3.checkNotNullExpressionValue(map, "presences");
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
            return new WidgetGroupInviteFriends.Model.ModelAppUserRelationship(map4, map, map2, map3);
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call(Map<Long, Integer> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call2(Map<Long, Integer> map) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(companion.getPresences().observePresencesForUsers(map.keySet()), companion.getUsers().observeUsers(map.keySet()), companion.getApplicationStreaming().observeStreamsByUser(), new AnonymousClass1(map));
    }
}
