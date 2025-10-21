package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemUser$onConfigure$3 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item.Friend $item;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemUser this$0;

    public WidgetFriendsListAdapter$ItemUser$onConfigure$3(WidgetFriendsListAdapter.ItemUser itemUser, FriendsListViewModel.Item.Friend friend) {
        this.this$0 = itemUser;
        this.$item = friend;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemUser.access$getAdapter$p(this.this$0).getOnClickChat().invoke(this.$item.getUser());
    }
}
