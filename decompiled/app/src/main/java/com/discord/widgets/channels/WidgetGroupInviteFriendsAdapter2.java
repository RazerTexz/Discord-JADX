package com.discord.widgets.channels;

import android.view.View;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.WidgetGroupInviteFriendsAdapter;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetGroupInviteFriendsAdapter.kt */
/* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriendsAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGroupInviteFriends.Model.FriendItem $data;
    public final /* synthetic */ WidgetGroupInviteFriendsAdapter.WidgetGroupInviteFriendsListItem this$0;

    public WidgetGroupInviteFriendsAdapter2(WidgetGroupInviteFriendsAdapter.WidgetGroupInviteFriendsListItem widgetGroupInviteFriendsListItem, WidgetGroupInviteFriends.Model.FriendItem friendItem) {
        this.this$0 = widgetGroupInviteFriendsListItem;
        this.$data = friendItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2 function2Access$getListener$p;
        if (this.$data.getUser() == null || (function2Access$getListener$p = WidgetGroupInviteFriendsAdapter.access$getListener$p(WidgetGroupInviteFriendsAdapter.WidgetGroupInviteFriendsListItem.access$getAdapter$p(this.this$0))) == null) {
            return;
        }
    }
}
