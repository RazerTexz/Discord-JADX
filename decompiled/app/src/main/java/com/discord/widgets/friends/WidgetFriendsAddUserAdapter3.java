package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
/* renamed from: com.discord.widgets.friends.WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter3 implements View.OnClickListener {
    public final /* synthetic */ boolean $incomingFriendRequest;
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter3(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, long j, boolean z2) {
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
