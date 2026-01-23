package com.discord.widgets.guilds;

import android.view.View;
import com.discord.widgets.guilds.WidgetGuildSelector;

/* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector2 implements View.OnClickListener {
    public final /* synthetic */ WidgetGuildSelector.Item $data;
    public final /* synthetic */ WidgetGuildSelector.Adapter.ItemGuild this$0;

    public WidgetGuildSelector2(WidgetGuildSelector.Adapter.ItemGuild itemGuild, WidgetGuildSelector.Item item) {
        this.this$0 = itemGuild;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildSelector.access$onGuildSelected(WidgetGuildSelector.Adapter.access$getDialog$p(WidgetGuildSelector.Adapter.ItemGuild.access$getAdapter$p(this.this$0)), this.$data.getGuild());
    }
}
