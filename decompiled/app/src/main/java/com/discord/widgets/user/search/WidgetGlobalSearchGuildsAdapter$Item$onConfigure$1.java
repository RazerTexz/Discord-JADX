package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;

/* compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel.Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter.Item this$0;

    public WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1(WidgetGlobalSearchGuildsAdapter.Item item, int i, WidgetGlobalSearchGuildsModel.Item item2) {
        this.this$0 = item;
        this.$position = i;
        this.$data = item2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
