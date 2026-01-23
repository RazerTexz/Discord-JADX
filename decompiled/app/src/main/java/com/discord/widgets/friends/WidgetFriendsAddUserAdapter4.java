package com.discord.widgets.friends;

import android.view.View;
import com.discord.models.user.User;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.friends.WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter4 implements View.OnClickListener {
    public final /* synthetic */ User $user;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter4(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, User user) {
        this.this$0 = userViewHolder;
        this.$user = user;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getSendHandler$p = WidgetFriendsAddUserAdapter.access$getSendHandler$p(WidgetFriendsAddUserAdapter.UserViewHolder.access$getAdapter$p(this.this$0));
        if (function2Access$getSendHandler$p != null) {
        }
    }
}
