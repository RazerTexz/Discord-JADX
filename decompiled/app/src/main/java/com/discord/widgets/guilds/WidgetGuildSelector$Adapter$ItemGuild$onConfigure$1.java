package com.discord.widgets.guilds;

import android.view.View;
import com.discord.widgets.guilds.WidgetGuildSelector;

/* compiled from: WidgetGuildSelector.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetGuildSelector.Item $data;
    public final /* synthetic */ WidgetGuildSelector.Adapter.ItemGuild this$0;

    public WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1(WidgetGuildSelector.Adapter.ItemGuild itemGuild, WidgetGuildSelector.Item item) {
        this.this$0 = itemGuild;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetGuildSelector.access$onGuildSelected(WidgetGuildSelector.Adapter.access$getDialog$p(WidgetGuildSelector.Adapter.ItemGuild.access$getAdapter$p(this.this$0)), this.$data.getGuild());
    }
}
