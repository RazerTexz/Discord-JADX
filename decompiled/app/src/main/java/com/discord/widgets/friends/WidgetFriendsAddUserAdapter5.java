package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$4, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter5 implements View.OnClickListener {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter5(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, long j) {
        this.this$0 = userViewHolder;
        this.$userId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsAddUserAdapter.access$getOnItemClick$p(WidgetFriendsAddUserAdapter.UserViewHolder.access$getAdapter$p(this.this$0)).invoke(Long.valueOf(this.$userId));
    }
}
