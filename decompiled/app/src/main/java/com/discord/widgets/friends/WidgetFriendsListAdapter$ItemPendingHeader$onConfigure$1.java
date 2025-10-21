package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsListAdapter;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter.ItemPendingHeader this$0;

    public WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1(WidgetFriendsListAdapter.ItemPendingHeader itemPendingHeader) {
        this.this$0 = itemPendingHeader;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemPendingHeader.access$getAdapter$p(this.this$0).getOnClickPendingHeaderExpand().invoke();
    }
}
