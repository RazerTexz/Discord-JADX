package com.discord.widgets.hubs.events;

import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubEventsViewModel.kt */
/* renamed from: com.discord.widgets.hubs.events.HubGuildScheduledEventData, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubEventsViewModel2 {
    private final boolean canConnect;
    private final boolean canShare;
    private final boolean canStartEvent;
    private final Channel channel;
    private final long directoryChannelId;
    private final GuildScheduledEvent event;
    private final boolean isConnected;
    private final boolean isInGuild;
    private final boolean isRsvped;

    public WidgetHubEventsViewModel2(long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "event");
        this.directoryChannelId = j;
        this.event = guildScheduledEvent;
        this.channel = channel;
        this.isRsvped = z2;
        this.canShare = z3;
        this.canStartEvent = z4;
        this.canConnect = z5;
        this.isConnected = z6;
        this.isInGuild = z7;
    }

    public static /* synthetic */ WidgetHubEventsViewModel2 copy$default(WidgetHubEventsViewModel2 widgetHubEventsViewModel2, long j, GuildScheduledEvent guildScheduledEvent, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        return widgetHubEventsViewModel2.copy((i & 1) != 0 ? widgetHubEventsViewModel2.directoryChannelId : j, (i & 2) != 0 ? widgetHubEventsViewModel2.event : guildScheduledEvent, (i & 4) != 0 ? widgetHubEventsViewModel2.channel : channel, (i & 8) != 0 ? widgetHubEventsViewModel2.isRsvped : z2, (i & 16) != 0 ? widgetHubEventsViewModel2.canShare : z3, (i & 32) != 0 ? widgetHubEventsViewModel2.canStartEvent : z4, (i & 64) != 0 ? widgetHubEventsViewModel2.canConnect : z5, (i & 128) != 0 ? widgetHubEventsViewModel2.isConnected : z6, (i & 256) != 0 ? widgetHubEventsViewModel2.isInGuild : z7);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    /* renamed from: component2, reason: from getter */
    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* renamed from: component3, reason: from getter */
    public final Channel getChannel() {
        return this.channel;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanShare() {
        return this.canShare;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    public final WidgetHubEventsViewModel2 copy(long directoryChannelId, GuildScheduledEvent event, Channel channel, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean canConnect, boolean isConnected, boolean isInGuild) {
        Intrinsics3.checkNotNullParameter(event, "event");
        return new WidgetHubEventsViewModel2(directoryChannelId, event, channel, isRsvped, canShare, canStartEvent, canConnect, isConnected, isInGuild);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEventsViewModel2)) {
            return false;
        }
        WidgetHubEventsViewModel2 widgetHubEventsViewModel2 = (WidgetHubEventsViewModel2) other;
        return this.directoryChannelId == widgetHubEventsViewModel2.directoryChannelId && Intrinsics3.areEqual(this.event, widgetHubEventsViewModel2.event) && Intrinsics3.areEqual(this.channel, widgetHubEventsViewModel2.channel) && this.isRsvped == widgetHubEventsViewModel2.isRsvped && this.canShare == widgetHubEventsViewModel2.canShare && this.canStartEvent == widgetHubEventsViewModel2.canStartEvent && this.canConnect == widgetHubEventsViewModel2.canConnect && this.isConnected == widgetHubEventsViewModel2.isConnected && this.isInGuild == widgetHubEventsViewModel2.isInGuild;
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanShare() {
        return this.canShare;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getDirectoryChannelId() {
        return this.directoryChannelId;
    }

    public final GuildScheduledEvent getEvent() {
        return this.event;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iM3a = C0002b.m3a(this.directoryChannelId) * 31;
        GuildScheduledEvent guildScheduledEvent = this.event;
        int iHashCode = (iM3a + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0)) * 31;
        Channel channel = this.channel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z2 = this.isRsvped;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.canShare;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.canStartEvent;
        int i5 = z4;
        if (z4 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z5 = this.canConnect;
        int i7 = z5;
        if (z5 != 0) {
            i7 = 1;
        }
        int i8 = (i6 + i7) * 31;
        boolean z6 = this.isConnected;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.isInGuild;
        return i10 + (z7 ? 1 : z7 ? 1 : 0);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("HubGuildScheduledEventData(directoryChannelId=");
        sbM833U.append(this.directoryChannelId);
        sbM833U.append(", event=");
        sbM833U.append(this.event);
        sbM833U.append(", channel=");
        sbM833U.append(this.channel);
        sbM833U.append(", isRsvped=");
        sbM833U.append(this.isRsvped);
        sbM833U.append(", canShare=");
        sbM833U.append(this.canShare);
        sbM833U.append(", canStartEvent=");
        sbM833U.append(this.canStartEvent);
        sbM833U.append(", canConnect=");
        sbM833U.append(this.canConnect);
        sbM833U.append(", isConnected=");
        sbM833U.append(this.isConnected);
        sbM833U.append(", isInGuild=");
        return outline.m827O(sbM833U, this.isInGuild, ")");
    }
}
