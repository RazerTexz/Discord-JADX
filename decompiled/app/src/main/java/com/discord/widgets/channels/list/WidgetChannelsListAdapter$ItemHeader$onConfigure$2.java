package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.widgets.channels.WidgetCreateChannel;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemHeader$onConfigure$2 implements View.OnClickListener {
    public final /* synthetic */ long $selectedGuildId;

    public WidgetChannelsListAdapter$ItemHeader$onConfigure$2(long j) {
        this.$selectedGuildId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.Companion.show$default(WidgetCreateChannel.INSTANCE, outline.m885x(view, "v", "v.context"), this.$selectedGuildId, 2, null, 8, null);
    }
}
