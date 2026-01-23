package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3<T, R> implements Func1<Map<Long, Integer>, Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3();

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFilteredFriends$3$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73791<T1, T2, T3, R> implements Func3<Map<Long, ? extends Presence>, Map<Long, ? extends User>, Map<Long, ? extends ModelApplicationStream>, WidgetGroupInviteFriends.Model.ModelAppUserRelationship> {
        public final /* synthetic */ Map $filteredFriends;

        public C73791(Map map) {
            this.$filteredFriends = map;
        }

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.ModelAppUserRelationship call(Map<Long, ? extends Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            return call2((Map<Long, Presence>) map, map2, map3);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetGroupInviteFriends.Model.ModelAppUserRelationship call2(Map<Long, Presence> map, Map<Long, ? extends User> map2, Map<Long, ? extends ModelApplicationStream> map3) {
            Map map4 = this.$filteredFriends;
            Intrinsics3.checkNotNullExpressionValue(map4, "filteredFriends");
            Intrinsics3.checkNotNullExpressionValue(map, "presences");
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
            Intrinsics3.checkNotNullExpressionValue(map3, "applicationStreams");
            return new WidgetGroupInviteFriends.Model.ModelAppUserRelationship(map4, map, map2, map3);
        }
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call(Map<Long, Integer> map) {
        return call2(map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model.ModelAppUserRelationship> call2(Map<Long, Integer> map) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11075i(companion.getPresences().observePresencesForUsers(map.keySet()), companion.getUsers().observeUsers(map.keySet()), companion.getApplicationStreaming().observeStreamsByUser(), new C73791(map));
    }
}
