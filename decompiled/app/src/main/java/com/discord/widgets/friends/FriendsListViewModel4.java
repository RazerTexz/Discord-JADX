package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import com.discord.widgets.friends.FriendsListViewModel;
import java.util.Comparator;

/* compiled from: FriendsListViewModel.kt */
/* renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$onlineFriendItems$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class FriendsListViewModel4<T> implements Comparator<FriendsListViewModel.Item.Friend> {
    public static final FriendsListViewModel4 INSTANCE = new FriendsListViewModel4();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return compare2(friend, friend2);
    }

    /* renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel.Item.Friend friend, FriendsListViewModel.Item.Friend friend2) {
        return UserUtils.INSTANCE.compareUserNames(friend.getUser(), friend2.getUser());
    }
}
