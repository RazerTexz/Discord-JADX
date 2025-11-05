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
public final class WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ FriendsListViewModel.Item $data;
    public final /* synthetic */ WidgetFriendsListAdapter.ItemSuggestedFriend this$0;

    public WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1(WidgetFriendsListAdapter.ItemSuggestedFriend itemSuggestedFriend, FriendsListViewModel.Item item) {
        this.this$0 = itemSuggestedFriend;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemSuggestedFriend.access$getAdapter$p(this.this$0).getOnClickUserProfile();
        m.checkNotNullExpressionValue(view, "view");
        onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.SuggestedFriend) this.$data).getSuggestion().getUser());
    }
}
