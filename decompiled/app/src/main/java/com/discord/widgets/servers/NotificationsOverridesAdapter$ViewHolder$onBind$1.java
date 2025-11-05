package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.NotificationsOverridesAdapter;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: NotificationsOverridesAdapter.kt */
/* loaded from: classes2.dex */
public final class NotificationsOverridesAdapter$ViewHolder$onBind$1 implements View.OnClickListener {
    public final /* synthetic */ NotificationsOverridesAdapter.Item $data;
    public final /* synthetic */ NotificationsOverridesAdapter.ViewHolder this$0;

    public NotificationsOverridesAdapter$ViewHolder$onBind$1(NotificationsOverridesAdapter.ViewHolder viewHolder, NotificationsOverridesAdapter.Item item) {
        this.this$0 = viewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, NotificationsOverridesAdapter.Item, Unit> onClick = this.this$0.getOnClick();
        m.checkNotNullExpressionValue(view, "it");
        onClick.invoke(view, this.$data);
    }
}
