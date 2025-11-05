package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ boolean $incomingFriendRequest;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, long j, boolean z2) {
        this.this$0 = userViewHolder;
        this.$userId = j;
        this.$incomingFriendRequest = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getDeclineHandler$p = WidgetFriendsAddUserAdapter.access$getDeclineHandler$p(WidgetFriendsAddUserAdapter.UserViewHolder.access$getAdapter$p(this.this$0));
        if (function2Access$getDeclineHandler$p != null) {
        }
    }
}
