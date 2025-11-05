package com.discord.widgets.user;

import android.view.View;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreStream;
import com.discord.widgets.user.WidgetUserMutualGuilds;

/* compiled from: WidgetUserMutualGuilds.kt */
/* loaded from: classes.dex */
public final class WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetUserMutualGuilds.Model.Item $data;
    public final /* synthetic */ WidgetUserMutualGuilds.Adapter.ViewHolder this$0;

    public WidgetUserMutualGuilds$Adapter$ViewHolder$onConfigure$1(WidgetUserMutualGuilds.Adapter.ViewHolder viewHolder, WidgetUserMutualGuilds.Model.Item item) {
        this.this$0 = viewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StoreGuildSelected guildSelected = StoreStream.INSTANCE.getGuildSelected();
        Guild guild = this.$data.getGuild();
        guildSelected.set(guild != null ? guild.getId() : 0L);
        WidgetUserMutualGuilds.Adapter.access$getGuildSelectedCallback$p(WidgetUserMutualGuilds.Adapter.ViewHolder.access$getAdapter$p(this.this$0)).call();
    }
}
