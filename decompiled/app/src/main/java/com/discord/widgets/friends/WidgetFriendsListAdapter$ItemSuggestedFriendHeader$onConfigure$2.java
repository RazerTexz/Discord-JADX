package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsListAdapter;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter.ItemSuggestedFriendHeader this$0;

    public WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2(WidgetFriendsListAdapter.ItemSuggestedFriendHeader itemSuggestedFriendHeader) {
        this.this$0 = itemSuggestedFriendHeader;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemSuggestedFriendHeader.access$getAdapter$p(this.this$0).getOnClickSuggestedHeaderExpandCollapse().invoke();
    }
}
