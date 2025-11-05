package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import com.discord.widgets.friends.FriendsListViewModel;
import java.util.Comparator;

/* compiled from: FriendsListViewModel.kt */
/* loaded from: classes2.dex */
public final class FriendsListViewModel$getItems$onlineFriendItems$2<T> implements Comparator<FriendsListViewModel.Item.Friend> {
    public static final FriendsListViewModel$getItems$onlineFriendItems$2 INSTANCE = new FriendsListViewModel$getItems$onlineFriendItems$2();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return compare2(friend, friend2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return UserUtils.INSTANCE.compareUserNames(friend.getUser(), friend2.getUser());
    }
}
