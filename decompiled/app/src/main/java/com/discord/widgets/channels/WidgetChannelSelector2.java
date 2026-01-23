package com.discord.widgets.channels;

import android.view.View;
import com.discord.widgets.channels.WidgetChannelSelector;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector2 implements View.OnClickListener {
    public final /* synthetic */ WidgetChannelSelector.Model.Item $data;
    public final /* synthetic */ WidgetChannelSelector.Adapter.ItemChannel this$0;

    public WidgetChannelSelector2(WidgetChannelSelector.Adapter.ItemChannel itemChannel, WidgetChannelSelector.Model.Item item) {
        this.this$0 = itemChannel;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetChannelSelector.access$onChannelSelected(WidgetChannelSelector.Adapter.access$getDialog$p(WidgetChannelSelector.Adapter.ItemChannel.access$getAdapter$p(this.this$0)), this.$data.getChannel());
    }
}
