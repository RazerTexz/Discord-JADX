package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GuildButtonConfiguration.kt */
/* loaded from: classes2.dex */
public final /* data */ class GuildButtonConfiguration implements ButtonConfiguration {
    private final boolean canConnect;
    private final boolean canConnectToChannel;
    private final boolean canRsvp;
    private final boolean canStartEvent;
    private final View.OnClickListener extrasButtonOnClickListener;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyButtonVisible;
    private final boolean isConnected;
    private final boolean isDetailView;
    private final boolean isEndEventVisible;
    private final boolean isEventActive;
    private final boolean isEventComplete;
    private final boolean isExtrasVisible;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final boolean isShareVisible;
    private final View.OnClickListener onEndEventButtonClicked;
    private final View.OnClickListener onExtraButtonClicked;
    private final View.OnClickListener onJoinButtonClicked;
    private final View.OnClickListener onRsvpButtonClicked;
    private final View.OnClickListener onShareButtonClicked;
    private final View.OnClickListener onStartEventButtonClicked;
    private final View.OnClickListener primaryButtonOnClickListener;
    private final boolean primaryButtonVisible;
    private final int secondaryButtonBackground;
    private final boolean secondaryButtonEnabled;
    private final View.OnClickListener secondaryButtonOnClickListener;
    private final int secondaryButtonTextDrawableRes;
    private final boolean secondaryButtonVisible;
    private final View.OnClickListener shareButtonOnClickListener;
    private final GuildScheduledEventUtilities2 timing;

    public GuildButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5, View.OnClickListener onClickListener6) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEvent = guildScheduledEvent;
        this.canRsvp = z2;
        this.canStartEvent = z3;
        this.isConnected = z4;
        this.canConnect = z5;
        this.isInGuild = z6;
        this.isRsvped = z7;
        this.isDetailView = z8;
        this.onRsvpButtonClicked = onClickListener;
        View.OnClickListener onClickListener7 = onClickListener2;
        this.onJoinButtonClicked = onClickListener7;
        this.onEndEventButtonClicked = onClickListener3;
        this.onStartEventButtonClicked = onClickListener4;
        this.onShareButtonClicked = onClickListener5;
        this.onExtraButtonClicked = onClickListener6;
        GuildScheduledEventUtilities2 eventTiming = GuildScheduledEventUtilities5.getEventTiming(guildScheduledEvent);
        this.timing = eventTiming;
        boolean z9 = true;
        boolean z10 = guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED;
        this.isEventComplete = z10;
        boolean z11 = eventTiming == GuildScheduledEventUtilities2.LIVE;
        this.isEventActive = z11;
        this.canConnectToChannel = z5;
        boolean z12 = z8 && z11 && z4 && z3;
        this.isEndEventVisible = z12;
        this.primaryButtonVisible = (!z3 || z10) ? false : eventTiming.isStartable();
        this.primaryButtonOnClickListener = onClickListener4;
        this.secondaryButtonVisible = z2;
        if (z12) {
            onClickListener7 = onClickListener3;
        } else if (!z11) {
            onClickListener7 = onClickListener;
        }
        this.secondaryButtonOnClickListener = onClickListener7;
        this.secondaryButtonEnabled = !z10 && (!z11 || (guildScheduledEvent.getEntityType() != GuildScheduledEventEntityType.EXTERNAL && z5));
        this.secondaryButtonTextDrawableRes = (z11 || !getSecondaryButtonEnabled()) ? 0 : z7 ? R.drawable.ic_check_active_16dp : R.drawable.ic_bell_16dp;
        boolean secondaryButtonEnabled = getSecondaryButtonEnabled();
        int i = R.drawable.bg_guild_scheduled_event_list_item_interested_button_default;
        if (!secondaryButtonEnabled) {
            i = R.drawable.bg_guild_scheduled_event_list_item_interested_button_disabled;
        } else if (!z12) {
            if (z11) {
                i = R.drawable.bg_guild_scheduled_event_list_item_interested_button_active;
            } else if (z7) {
                i = R.drawable.bg_guild_scheduled_event_list_item_interested_button_interested;
            }
        }
        this.secondaryButtonBackground = i;
        this.isShareVisible = !z10;
        this.shareButtonOnClickListener = onClickListener5;
        this.isExtrasVisible = true;
        this.extrasButtonOnClickListener = onClickListener6;
        if (!getSecondaryButtonVisible() && !getPrimaryButtonVisible() && !z12 && !getIsShareVisible()) {
            z9 = false;
        }
        this.isAnyButtonVisible = z9;
    }

    public static /* synthetic */ GuildButtonConfiguration copy$default(GuildButtonConfiguration guildButtonConfiguration, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5, View.OnClickListener onClickListener6, int i, Object obj) {
        return guildButtonConfiguration.copy((i & 1) != 0 ? guildButtonConfiguration.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? guildButtonConfiguration.canRsvp : z2, (i & 4) != 0 ? guildButtonConfiguration.canStartEvent : z3, (i & 8) != 0 ? guildButtonConfiguration.isConnected : z4, (i & 16) != 0 ? guildButtonConfiguration.canConnect : z5, (i & 32) != 0 ? guildButtonConfiguration.isInGuild : z6, (i & 64) != 0 ? guildButtonConfiguration.isRsvped : z7, (i & 128) != 0 ? guildButtonConfiguration.isDetailView : z8, (i & 256) != 0 ? guildButtonConfiguration.onRsvpButtonClicked : onClickListener, (i & 512) != 0 ? guildButtonConfiguration.onJoinButtonClicked : onClickListener2, (i & 1024) != 0 ? guildButtonConfiguration.onEndEventButtonClicked : onClickListener3, (i & 2048) != 0 ? guildButtonConfiguration.onStartEventButtonClicked : onClickListener4, (i & 4096) != 0 ? guildButtonConfiguration.onShareButtonClicked : onClickListener5, (i & 8192) != 0 ? guildButtonConfiguration.onExtraButtonClicked : onClickListener6);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* renamed from: component10, reason: from getter */
    public final View.OnClickListener getOnJoinButtonClicked() {
        return this.onJoinButtonClicked;
    }

    /* renamed from: component11, reason: from getter */
    public final View.OnClickListener getOnEndEventButtonClicked() {
        return this.onEndEventButtonClicked;
    }

    /* renamed from: component12, reason: from getter */
    public final View.OnClickListener getOnStartEventButtonClicked() {
        return this.onStartEventButtonClicked;
    }

    /* renamed from: component13, reason: from getter */
    public final View.OnClickListener getOnShareButtonClicked() {
        return this.onShareButtonClicked;
    }

    /* renamed from: component14, reason: from getter */
    public final View.OnClickListener getOnExtraButtonClicked() {
        return this.onExtraButtonClicked;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanRsvp() {
        return this.canRsvp;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsConnected() {
        return this.isConnected;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanConnect() {
        return this.canConnect;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsDetailView() {
        return this.isDetailView;
    }

    /* renamed from: component9, reason: from getter */
    public final View.OnClickListener getOnRsvpButtonClicked() {
        return this.onRsvpButtonClicked;
    }

    public final GuildButtonConfiguration copy(GuildScheduledEvent guildScheduledEvent, boolean canRsvp, boolean canStartEvent, boolean isConnected, boolean canConnect, boolean isInGuild, boolean isRsvped, boolean isDetailView, View.OnClickListener onRsvpButtonClicked, View.OnClickListener onJoinButtonClicked, View.OnClickListener onEndEventButtonClicked, View.OnClickListener onStartEventButtonClicked, View.OnClickListener onShareButtonClicked, View.OnClickListener onExtraButtonClicked) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new GuildButtonConfiguration(guildScheduledEvent, canRsvp, canStartEvent, isConnected, canConnect, isInGuild, isRsvped, isDetailView, onRsvpButtonClicked, onJoinButtonClicked, onEndEventButtonClicked, onStartEventButtonClicked, onShareButtonClicked, onExtraButtonClicked);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildButtonConfiguration)) {
            return false;
        }
        GuildButtonConfiguration guildButtonConfiguration = (GuildButtonConfiguration) other;
        return Intrinsics3.areEqual(this.guildScheduledEvent, guildButtonConfiguration.guildScheduledEvent) && this.canRsvp == guildButtonConfiguration.canRsvp && this.canStartEvent == guildButtonConfiguration.canStartEvent && this.isConnected == guildButtonConfiguration.isConnected && this.canConnect == guildButtonConfiguration.canConnect && this.isInGuild == guildButtonConfiguration.isInGuild && this.isRsvped == guildButtonConfiguration.isRsvped && this.isDetailView == guildButtonConfiguration.isDetailView && Intrinsics3.areEqual(this.onRsvpButtonClicked, guildButtonConfiguration.onRsvpButtonClicked) && Intrinsics3.areEqual(this.onJoinButtonClicked, guildButtonConfiguration.onJoinButtonClicked) && Intrinsics3.areEqual(this.onEndEventButtonClicked, guildButtonConfiguration.onEndEventButtonClicked) && Intrinsics3.areEqual(this.onStartEventButtonClicked, guildButtonConfiguration.onStartEventButtonClicked) && Intrinsics3.areEqual(this.onShareButtonClicked, guildButtonConfiguration.onShareButtonClicked) && Intrinsics3.areEqual(this.onExtraButtonClicked, guildButtonConfiguration.onExtraButtonClicked);
    }

    public final boolean getCanConnect() {
        return this.canConnect;
    }

    public final boolean getCanRsvp() {
        return this.canRsvp;
    }

    public final boolean getCanStartEvent() {
        return this.canStartEvent;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View.OnClickListener getExtrasButtonOnClickListener() {
        return this.extrasButtonOnClickListener;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final View.OnClickListener getOnEndEventButtonClicked() {
        return this.onEndEventButtonClicked;
    }

    public final View.OnClickListener getOnExtraButtonClicked() {
        return this.onExtraButtonClicked;
    }

    public final View.OnClickListener getOnJoinButtonClicked() {
        return this.onJoinButtonClicked;
    }

    public final View.OnClickListener getOnRsvpButtonClicked() {
        return this.onRsvpButtonClicked;
    }

    public final View.OnClickListener getOnShareButtonClicked() {
        return this.onShareButtonClicked;
    }

    public final View.OnClickListener getOnStartEventButtonClicked() {
        return this.onStartEventButtonClicked;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View.OnClickListener getPrimaryButtonOnClickListener() {
        return this.primaryButtonOnClickListener;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getPrimaryButtonVisible() {
        return this.primaryButtonVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int getSecondaryButtonBackground() {
        return this.secondaryButtonBackground;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getSecondaryButtonEnabled() {
        return this.secondaryButtonEnabled;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View.OnClickListener getSecondaryButtonOnClickListener() {
        return this.secondaryButtonOnClickListener;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int getSecondaryButtonTextDrawableRes() {
        return this.secondaryButtonTextDrawableRes;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public boolean getSecondaryButtonVisible() {
        return this.secondaryButtonVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View.OnClickListener getShareButtonOnClickListener() {
        return this.shareButtonOnClickListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
        boolean z2 = this.canRsvp;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.canStartEvent;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.isConnected;
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
        boolean z6 = this.isInGuild;
        int i9 = z6;
        if (z6 != 0) {
            i9 = 1;
        }
        int i10 = (i8 + i9) * 31;
        boolean z7 = this.isRsvped;
        int i11 = z7;
        if (z7 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        boolean z8 = this.isDetailView;
        int i13 = (i12 + (z8 ? 1 : z8 ? 1 : 0)) * 31;
        View.OnClickListener onClickListener = this.onRsvpButtonClicked;
        int iHashCode2 = (i13 + (onClickListener != null ? onClickListener.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener2 = this.onJoinButtonClicked;
        int iHashCode3 = (iHashCode2 + (onClickListener2 != null ? onClickListener2.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener3 = this.onEndEventButtonClicked;
        int iHashCode4 = (iHashCode3 + (onClickListener3 != null ? onClickListener3.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener4 = this.onStartEventButtonClicked;
        int iHashCode5 = (iHashCode4 + (onClickListener4 != null ? onClickListener4.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener5 = this.onShareButtonClicked;
        int iHashCode6 = (iHashCode5 + (onClickListener5 != null ? onClickListener5.hashCode() : 0)) * 31;
        View.OnClickListener onClickListener6 = this.onExtraButtonClicked;
        return iHashCode6 + (onClickListener6 != null ? onClickListener6.hashCode() : 0);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* renamed from: isAnyButtonVisible, reason: from getter */
    public boolean getIsAnyButtonVisible() {
        return this.isAnyButtonVisible;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isDetailView() {
        return this.isDetailView;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* renamed from: isExtrasVisible, reason: from getter */
    public boolean getIsExtrasVisible() {
        return this.isExtrasVisible;
    }

    public final boolean isInGuild() {
        return this.isInGuild;
    }

    public final boolean isRsvped() {
        return this.isRsvped;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* renamed from: isShareVisible, reason: from getter */
    public boolean getIsShareVisible() {
        return this.isShareVisible;
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence primaryButtonText(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return FormatUtils.h(context, R.string.start_event, new Object[0], null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence secondaryButtonText(Context context) {
        int i;
        Intrinsics3.checkNotNullParameter(context, "context");
        if (this.isEventActive && this.guildScheduledEvent.getEntityType() == GuildScheduledEventEntityType.EXTERNAL) {
            i = R.string.guild_event_started;
        } else {
            boolean z2 = this.isEventActive;
            i = (!z2 || this.canConnectToChannel) ? this.isEndEventVisible ? R.string.end_event : (z2 && this.isConnected) ? R.string.go_to_channel : (z2 && this.guildScheduledEvent.getEntityType() == GuildScheduledEventEntityType.VOICE) ? R.string.guild_event_join : this.isEventActive ? R.string.stage_channel_join_button : this.isEventComplete ? R.string.guild_event_invite_completed : R.string.indicate_rsvp : R.string.channel_locked_short;
        }
        return FormatUtils.h(context, i, new Object[0], null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int secondaryButtonTextColor(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return !getSecondaryButtonEnabled() ? ColorCompat.getColor(context, R.color.white_alpha_40) : (!this.isRsvped || this.isEventActive || this.isEventComplete) ? ColorCompat.getColor(context, R.color.white) : ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildButtonConfiguration(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", canRsvp=");
        sbU.append(this.canRsvp);
        sbU.append(", canStartEvent=");
        sbU.append(this.canStartEvent);
        sbU.append(", isConnected=");
        sbU.append(this.isConnected);
        sbU.append(", canConnect=");
        sbU.append(this.canConnect);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", isDetailView=");
        sbU.append(this.isDetailView);
        sbU.append(", onRsvpButtonClicked=");
        sbU.append(this.onRsvpButtonClicked);
        sbU.append(", onJoinButtonClicked=");
        sbU.append(this.onJoinButtonClicked);
        sbU.append(", onEndEventButtonClicked=");
        sbU.append(this.onEndEventButtonClicked);
        sbU.append(", onStartEventButtonClicked=");
        sbU.append(this.onStartEventButtonClicked);
        sbU.append(", onShareButtonClicked=");
        sbU.append(this.onShareButtonClicked);
        sbU.append(", onExtraButtonClicked=");
        sbU.append(this.onExtraButtonClicked);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ GuildButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5, View.OnClickListener onClickListener6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(guildScheduledEvent, z2, z3, z4, z5, z6, z7, (i & 128) != 0 ? false : z8, (i & 256) != 0 ? null : onClickListener, (i & 512) != 0 ? null : onClickListener2, (i & 1024) != 0 ? null : onClickListener3, (i & 2048) != 0 ? null : onClickListener4, (i & 4096) != 0 ? null : onClickListener5, (i & 8192) != 0 ? null : onClickListener6);
    }
}
