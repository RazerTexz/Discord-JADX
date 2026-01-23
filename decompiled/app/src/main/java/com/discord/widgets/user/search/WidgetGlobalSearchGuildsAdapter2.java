package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel.Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter.Item this$0;

    public WidgetGlobalSearchGuildsAdapter2(WidgetGlobalSearchGuildsAdapter.Item item, int i, WidgetGlobalSearchGuildsModel.Item item2) {
        this.this$0 = item;
        this.$position = i;
        this.$data = item2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
