package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingUser$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item.PendingFriendRequest $item;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemPendingUser this$0;

    public WidgetFriendsListAdapter$ItemPendingUser$onConfigure$2(WidgetFriendsListAdapter.ItemPendingUser itemPendingUser, FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest) {
        this.this$0 = itemPendingUser;
        this.$item = pendingFriendRequest;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickAcceptFriend().invoke(this.$item.getUser());
    }
}
