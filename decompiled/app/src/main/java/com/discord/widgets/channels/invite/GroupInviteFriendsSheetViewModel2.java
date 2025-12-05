package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import java.util.Map;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeFriends$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel2<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends Map<Long, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;

    public GroupInviteFriendsSheetViewModel2(StoreUser storeUser) {
        this.$storeUser = storeUser;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Map<Long, ? extends User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Map<Long, User>> call2(Map<Long, Integer> map) {
        return this.$storeUser.observeUsers(map.keySet());
    }
}
