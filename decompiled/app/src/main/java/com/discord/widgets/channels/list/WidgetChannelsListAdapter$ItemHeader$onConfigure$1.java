package com.discord.widgets.channels.list;

import android.view.View;
import b.d.b.a.outline;
import com.discord.widgets.channels.WidgetCreateChannel;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemHeader$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ long $selectedGuildId;

    public WidgetChannelsListAdapter$ItemHeader$onConfigure$1(long j) {
        this.$selectedGuildId = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel.Companion.show$default(WidgetCreateChannel.INSTANCE, outline.x(view, "v", "v.context"), this.$selectedGuildId, 0, null, 8, null);
    }
}
