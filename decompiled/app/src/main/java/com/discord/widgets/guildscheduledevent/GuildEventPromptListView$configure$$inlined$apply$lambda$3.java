package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildEventPromptListView;

/* compiled from: GuildEventPromptListView.kt */
/* loaded from: classes2.dex */
public final class GuildEventPromptListView$configure$$inlined$apply$lambda$3 implements View.OnClickListener {
    public final /* synthetic */ GuildEventPromptListView.ScheduledEventData $scheduledEventData$inlined;

    public GuildEventPromptListView$configure$$inlined$apply$lambda$3(GuildEventPromptListView.ScheduledEventData scheduledEventData) {
        this.$scheduledEventData$inlined = scheduledEventData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$scheduledEventData$inlined.getOnScheduledEventClick().invoke();
    }
}
