package com.discord.widgets.friends;

import com.discord.utilities.user.UserUtils;
import com.discord.widgets.friends.FriendsListViewModel;
import java.util.Comparator;

/* JADX INFO: renamed from: com.discord.widgets.friends.FriendsListViewModel$getItems$sortedPendingItems$1, reason: use source file name */
/* JADX INFO: compiled from: FriendsListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FriendsListViewModel5<T> implements Comparator<FriendsListViewModel.Item.PendingFriendRequest> {
    public static final FriendsListViewModel5 INSTANCE = new FriendsListViewModel5();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest2) {
        return compare2(pendingFriendRequest, pendingFriendRequest2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest2) {
        if (pendingFriendRequest.getRelationshipType() == 3 && pendingFriendRequest2.getRelationshipType() == 4) {
            return -1;
        }
        if (pendingFriendRequest.getRelationshipType() == 4 && pendingFriendRequest2.getRelationshipType() == 3) {
            return 1;
        }
        return UserUtils.INSTANCE.compareUserNames(pendingFriendRequest.getUser(), pendingFriendRequest2.getUser());
    }
}
