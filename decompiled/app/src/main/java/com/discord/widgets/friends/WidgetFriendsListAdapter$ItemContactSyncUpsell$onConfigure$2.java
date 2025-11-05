package com.discord.widgets.friends;

import android.view.View;
import com.discord.widgets.friends.WidgetFriendsListAdapter;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetFriendsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2 implements View.OnLongClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter.ItemContactSyncUpsell this$0;

    public WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2(WidgetFriendsListAdapter.ItemContactSyncUpsell itemContactSyncUpsell) {
        this.this$0 = itemContactSyncUpsell;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Function1<View, Unit> onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter.ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsellLongClick();
        m.checkNotNullExpressionValue(view, "it");
        onClickContactSyncUpsellLongClick.invoke(view);
        return true;
    }
}
