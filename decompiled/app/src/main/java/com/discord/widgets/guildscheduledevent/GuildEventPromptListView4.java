package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.widgets.guildscheduledevent.GuildEventPromptListView;

/* compiled from: GuildEventPromptListView.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.GuildEventPromptListView$configure$$inlined$apply$lambda$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildEventPromptListView4 implements View.OnClickListener {
    public final /* synthetic */ GuildEventPromptListView.ScheduledEventData $scheduledEventData$inlined;

    public GuildEventPromptListView4(GuildEventPromptListView.ScheduledEventData scheduledEventData) {
        this.$scheduledEventData$inlined = scheduledEventData;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$scheduledEventData$inlined.getOnScheduledEventClick().invoke();
    }
}
