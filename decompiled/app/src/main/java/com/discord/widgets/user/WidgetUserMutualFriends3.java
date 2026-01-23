package com.discord.widgets.user;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.WidgetUserMutualFriends;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMutualFriends$MutualFriendsAdapter$ViewHolder$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetUserMutualFriends.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMutualFriends3 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserMutualFriends.Model.Item.MutualFriend $data;
    public final /* synthetic */ WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder this$0;

    public WidgetUserMutualFriends3(WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder viewHolder, WidgetUserMutualFriends.Model.Item.MutualFriend mutualFriend) {
        this.this$0 = viewHolder;
        this.$data = mutualFriend;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
        long id2 = this.$data.getUser().getId();
        FragmentManager parentFragmentManager = WidgetUserMutualFriends.MutualFriendsAdapter.access$getFragment$p(WidgetUserMutualFriends.MutualFriendsAdapter.ViewHolder.access$getAdapter$p(this.this$0)).getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "adapter.fragment.parentFragmentManager");
        WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
    }
}
