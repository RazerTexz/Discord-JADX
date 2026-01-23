package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsListAdapter;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter.ItemContactSyncUpsell this$0;

    public WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1(WidgetFriendsListAdapter.ItemContactSyncUpsell itemContactSyncUpsell) {
        this.this$0 = itemContactSyncUpsell;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter.ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsell().invoke();
    }
}
