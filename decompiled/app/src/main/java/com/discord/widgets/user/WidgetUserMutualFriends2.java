package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelApplicationStream;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.user.WidgetUserMutualFriends;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Func6;

/* compiled from: WidgetUserMutualFriends.kt */
/* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetUserMutualFriends2<T, R> implements Func1<List<? extends ModelUserRelationship>, Observable<? extends WidgetUserMutualFriends.Model>> {
    public final /* synthetic */ long $userId;

    /* compiled from: WidgetUserMutualFriends.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$Model$Companion$get$1$1 */
    public static final class C102151<T1, T2, T3, T4, T5, T6, R> implements Func6<Map<Long, ? extends List<? extends Guild>>, Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, Map<Long, ? extends ModelApplicationStream>, User, WidgetUserMutualFriends.Model> {
        public static final C102151 INSTANCE = new C102151();

        @Override // p658rx.functions.Func6
        public /* bridge */ /* synthetic */ WidgetUserMutualFriends.Model call(Map<Long, ? extends List<? extends Guild>> map, Map<Long, ? extends User> map2, Map<Long, ? extends Presence> map3, Map<Long, ? extends Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            return call2((Map<Long, ? extends List<Guild>>) map, map2, (Map<Long, Presence>) map3, (Map<Long, Integer>) map4, map5, user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetUserMutualFriends.Model call2(Map<Long, ? extends List<Guild>> map, Map<Long, ? extends User> map2, Map<Long, Presence> map3, Map<Long, Integer> map4, Map<Long, ? extends ModelApplicationStream> map5, User user) {
            Intrinsics3.checkNotNullExpressionValue(map2, "users");
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
                    listEmptyList = Collections2.emptyList();
                }
                arrayList.add(new WidgetUserMutualFriends.Model.Item.MutualFriend(user2, presence, listEmptyList, Boolean.valueOf(map5.containsKey(Long.valueOf(jLongValue)))));
            }
            return new WidgetUserMutualFriends.Model(user, arrayList.isEmpty() ? _Collections.plus((Collection<? extends WidgetUserMutualFriends.Model.Item.Empty>) arrayList, WidgetUserMutualFriends.Model.Item.Empty.INSTANCE) : arrayList, arrayList.size());
        }
    }

    public WidgetUserMutualFriends2(long j) {
        this.$userId = j;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetUserMutualFriends.Model> call(List<? extends ModelUserRelationship> list) {
        return call2(list);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetUserMutualFriends.Model> call2(List<? extends ModelUserRelationship> list) {
        Intrinsics3.checkNotNullExpressionValue(list, "relationshipsApiResponse");
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((ModelUserRelationship) it.next()).getId()));
        }
        Observable<Map<Long, List<Guild>>> observableObserveMutualGuilds = new UserMutualGuildsManager(null, null, null, 7, null).observeMutualGuilds(arrayList);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMutualGuilds, companion.getUsers().observeUsers(arrayList), companion.getPresences().observePresencesForUsers(arrayList), companion.getUserRelationships().observe(), companion.getApplicationStreaming().observeStreamsByUser(), companion.getUsers().observeUser(this.$userId), C102151.INSTANCE, 1000L, TimeUnit.MILLISECONDS);
    }
}
