package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.friends.FriendsListViewModel;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemPendingUser this$0;

    public WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1(WidgetFriendsListAdapter.ItemPendingUser itemPendingUser, FriendsListViewModel.Item item) {
        this.this$0 = itemPendingUser;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickUserProfile();
        m.checkNotNullExpressionValue(view, "view");
        onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.PendingFriendRequest) this.$data).getUser());
    }
}
