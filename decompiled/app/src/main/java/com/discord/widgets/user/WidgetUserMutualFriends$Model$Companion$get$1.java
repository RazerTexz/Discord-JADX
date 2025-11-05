package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.user.WidgetUserMutualFriends;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func6;

/* compiled from: WidgetUserMutualFriends.kt */
/* loaded from: classes.dex */
public final class WidgetUserMutualFriends$Model$Companion$get$1<T, R> implements b<List<? extends ModelUserRelationship>, Observable<? extends WidgetUserMutualFriends.Model>> {
    public final /* synthetic */ long $userId;

    /* compiled from: WidgetUserMutualFriends.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends List<? extends Guild>>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends ModelApplicationStream>, User, WidgetUserMutualFriends.Model> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetUserMutualFriends.Model call(Map<Long, ? extends List<? extends Guild>> map, Map<Long, ? extends User> map2, Map<Long, ? extends Presence> map3, Map<Long, ? extends Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            return call2((Map<Long, ? extends List<Guild>>) map, map2, (Map<Long, Presence>) map3, (Map<Long, Integer>) map4, map5, user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetUserMutualFriends.Model call2(Map<Long, ? extends List<Guild>> map, Map<Long, ? extends User> map2, Map<Long, Presence> map3, Map<Long, Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            m.checkNotNullExpressionValue(map2, "users");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, ? extends User> entry : map2.entrySet()) {
                if (map4.containsKey(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            ArrayList arrayList = new ArrayList(linkedHashMap.size());
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                long jLongValue = ((Number) entry2.getKey()).longValue();
                User user2 = (User) entry2.getValue();
                Presence presence = map3.get(Long.valueOf(jLongValue));
                List<Guild> listEmptyList = map.get(Long.valueOf(jLongValue));
                if (listEmptyList == null) {
                    listEmptyList = n.emptyList();
                }
                arrayList.add(new WidgetUserMutualFriends.Model.Item.MutualFriend(user2, presence, listEmptyList, Boolean.valueOf(map5.containsKey(Long.valueOf(jLongValue)))));
            }
            return new WidgetUserMutualFriends.Model(user, arrayList.isEmpty() ? u.plus((Collection<? extends WidgetUserMutualFriends.Model.Item.Empty>) arrayList, WidgetUserMutualFriends.Model.Item.Empty.INSTANCE) : arrayList, arrayList.size());
        }
    }

    public WidgetUserMutualFriends$Model$Companion$get$1(long j) {
        this.$userId = j;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMutualFriends.Model> call(List<? extends ModelUserRelationship> list) {
        return call2(list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMutualFriends.Model> call2(List<? extends ModelUserRelationship> list) {
        m.checkNotNullExpressionValue(list, "relationshipsApiResponse");
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelUserRelationship) it.next()).getId()));
        }
        Observable<Map<Long, List<Guild>>> observableObserveMutualGuilds = new UserMutualGuildsManager(null, null, null, 7, null).observeMutualGuilds(arrayList);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMutualGuilds, companion.getUsers().observeUsers(arrayList), companion.getPresences().observePresencesForUsers(arrayList), companion.getUserRelationships().observe(), companion.getApplicationStreaming().observeStreamsByUser(), companion.getUsers().observeUser(this.$userId), AnonymousClass1.INSTANCE, 1000L, TimeUnit.MILLISECONDS);
    }
}
