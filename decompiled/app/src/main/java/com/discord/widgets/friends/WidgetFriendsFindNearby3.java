package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func3;

/* compiled from: WidgetFriendsFindNearby.kt */
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$getUserModels$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby3<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Presence>, Map<Long, ? extends Integer>, WidgetFriendsFindNearby.Model.NearbyUsers> {
    public static final WidgetFriendsFindNearby3 INSTANCE = new WidgetFriendsFindNearby3();

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetFriendsFindNearby.Model.NearbyUsers call(Map<Long, ? extends User> map, Map<Long, ? extends Presence> map2, Map<Long, ? extends Integer> map3) {
        return call2(map, (Map<Long, Presence>) map2, (Map<Long, Integer>) map3);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetFriendsFindNearby.Model.NearbyUsers call2(Map<Long, ? extends User> map, Map<Long, Presence> map2, Map<Long, Integer> map3) {
        Intrinsics3.checkNotNullExpressionValue(map, "users");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<Long, ? extends User> entry : map.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            User value = entry.getValue();
            List listEmptyList = Collections2.emptyList();
            Presence presence = map2.get(Long.valueOf(jLongValue));
            Integer num = map3.get(Long.valueOf(jLongValue));
            boolean z2 = true;
            if (num == null || num.intValue() != 1) {
                z2 = false;
            }
            arrayList.add(new WidgetFriendsAddUserAdapter.ItemUser(value, listEmptyList, presence, z2));
        }
        return new WidgetFriendsFindNearby.Model.NearbyUsers(arrayList);
    }
}
