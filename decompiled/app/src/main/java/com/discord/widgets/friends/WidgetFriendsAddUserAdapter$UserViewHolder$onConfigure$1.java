package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsAddUserAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsAddUserAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ long $userId;
    public final /* synthetic */ WidgetFriendsAddUserAdapter.UserViewHolder this$0;

    public WidgetFriendsAddUserAdapter$UserViewHolder$onConfigure$1(WidgetFriendsAddUserAdapter.UserViewHolder userViewHolder, long j) {
        this.this$0 = userViewHolder;
        this.$userId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getAcceptHandler$p = WidgetFriendsAddUserAdapter.access$getAcceptHandler$p(WidgetFriendsAddUserAdapter.UserViewHolder.access$getAdapter$p(this.this$0));
        if (function1Access$getAcceptHandler$p != null) {
        }
    }
}
