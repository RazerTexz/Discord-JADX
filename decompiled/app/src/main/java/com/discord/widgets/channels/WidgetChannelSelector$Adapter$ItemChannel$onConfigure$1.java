package com.discord.widgets.channels;

import android.view.View;
import com.discord.widgets.channels.WidgetChannelSelector;

/* compiled from: WidgetChannelSelector.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelSelector.Model.Item $data;
    public final /* synthetic */ WidgetChannelSelector.Adapter.ItemChannel this$0;

    public WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1(WidgetChannelSelector.Adapter.ItemChannel itemChannel, WidgetChannelSelector.Model.Item item) {
        this.this$0 = itemChannel;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector.access$onChannelSelected(WidgetChannelSelector.Adapter.access$getDialog$p(WidgetChannelSelector.Adapter.ItemChannel.access$getAdapter$p(this.this$0)), this.$data.getChannel());
    }
}
