package com.discord.widgets.guildscheduledevent.buttonconfiguration;

import android.content.Context;
import android.view.View;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities2;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import d0.z.d.Intrinsics3;

/* compiled from: DirectoryButtonConfiguration.kt */
/* loaded from: classes2.dex */
public final /* data */ class DirectoryButtonConfiguration implements ButtonConfiguration {
    private final View.OnClickListener extrasButtonOnClickListener;
    private final GuildScheduledEvent guildScheduledEvent;
    private final boolean isAnyButtonVisible;
    private final boolean isDetailView;
    private final boolean isEventActive;
    private final boolean isEventComplete;
    private final boolean isExtrasVisible;
    private final boolean isInGuild;
    private final boolean isRsvped;
    private final boolean isShareVisible;
    private final View.OnClickListener primaryButtonOnClickListener;
    private final boolean primaryButtonVisible;
    private final int secondaryButtonBackground;
    private final boolean secondaryButtonEnabled;
    private final View.OnClickListener secondaryButtonOnClickListener;
    private final int secondaryButtonTextDrawableRes;
    private final boolean secondaryButtonVisible;
    private final View.OnClickListener shareButtonOnClickListener;

    public DirectoryButtonConfiguration(GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEvent = guildScheduledEvent;
        this.isInGuild = z2;
        this.isRsvped = z3;
        this.isDetailView = z4;
        this.primaryButtonOnClickListener = onClickListener;
        this.secondaryButtonOnClickListener = onClickListener2;
        this.shareButtonOnClickListener = onClickListener3;
        this.extrasButtonOnClickListener = onClickListener4;
        boolean z5 = false;
        boolean z6 = guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED;
        this.isEventComplete = z6;
        boolean z7 = GuildScheduledEventUtilities5.getEventTiming(guildScheduledEvent) == GuildScheduledEventUtilities2.LIVE;
        this.isEventActive = z7;
        this.primaryButtonVisible = (z4 && !z7 && z2) ? false : true;
        this.secondaryButtonBackground = z3 ? R.drawable.bg_guild_scheduled_event_list_item_interested_button_interested : R.drawable.bg_guild_scheduled_event_list_item_interested_button_default;
        this.secondaryButtonTextDrawableRes = z3 ? R.drawable.ic_check_active_16dp : R.drawable.ic_bell_16dp;
        this.secondaryButtonEnabled = true;
        if (z2 && !z7 && !z6) {
            z5 = true;
        }
        this.secondaryButtonVisible = z5;
        this.isShareVisible = z2;
        this.isExtrasVisible = true;
        this.isAnyButtonVisible = true;
    }

    public static /* synthetic */ DirectoryButtonConfiguration copy$default(DirectoryButtonConfiguration directoryButtonConfiguration, GuildScheduledEvent guildScheduledEvent, boolean z2, boolean z3, boolean z4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, int i, Object obj) {
        return directoryButtonConfiguration.copy((i & 1) != 0 ? directoryButtonConfiguration.guildScheduledEvent : guildScheduledEvent, (i & 2) != 0 ? directoryButtonConfiguration.isInGuild : z2, (i & 4) != 0 ? directoryButtonConfiguration.isRsvped : z3, (i & 8) != 0 ? directoryButtonConfiguration.isDetailView : z4, (i & 16) != 0 ? directoryButtonConfiguration.getPrimaryButtonOnClickListener() : onClickListener, (i & 32) != 0 ? directoryButtonConfiguration.getSecondaryButtonOnClickListener() : onClickListener2, (i & 64) != 0 ? directoryButtonConfiguration.getShareButtonOnClickListener() : onClickListener3, (i & 128) != 0 ? directoryButtonConfiguration.getExtrasButtonOnClickListener() : onClickListener4);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsInGuild() {
        return this.isInGuild;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsRsvped() {
        return this.isRsvped;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsDetailView() {
        return this.isDetailView;
    }

    public final View.OnClickListener component5() {
        return getPrimaryButtonOnClickListener();
    }

    public final View.OnClickListener component6() {
        return getSecondaryButtonOnClickListener();
    }

    public final View.OnClickListener component7() {
        return getShareButtonOnClickListener();
    }

    public final View.OnClickListener component8() {
        return getExtrasButtonOnClickListener();
    }

    public final DirectoryButtonConfiguration copy(GuildScheduledEvent guildScheduledEvent, boolean isInGuild, boolean isRsvped, boolean isDetailView, View.OnClickListener primaryButtonOnClickListener, View.OnClickListener secondaryButtonOnClickListener, View.OnClickListener shareButtonOnClickListener, View.OnClickListener extrasButtonOnClickListener) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new DirectoryButtonConfiguration(guildScheduledEvent, isInGuild, isRsvped, isDetailView, primaryButtonOnClickListener, secondaryButtonOnClickListener, shareButtonOnClickListener, extrasButtonOnClickListener);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DirectoryButtonConfiguration)) {
            return false;
        }
        DirectoryButtonConfiguration directoryButtonConfiguration = (DirectoryButtonConfiguration) other;
        return Intrinsics3.areEqual(this.guildScheduledEvent, directoryButtonConfiguration.guildScheduledEvent) && this.isInGuild == directoryButtonConfiguration.isInGuild && this.isRsvped == directoryButtonConfiguration.isRsvped && this.isDetailView == directoryButtonConfiguration.isDetailView && Intrinsics3.areEqual(getPrimaryButtonOnClickListener(), directoryButtonConfiguration.getPrimaryButtonOnClickListener()) && Intrinsics3.areEqual(getSecondaryButtonOnClickListener(), directoryButtonConfiguration.getSecondaryButtonOnClickListener()) && Intrinsics3.areEqual(getShareButtonOnClickListener(), directoryButtonConfiguration.getShareButtonOnClickListener()) && Intrinsics3.areEqual(getExtrasButtonOnClickListener(), directoryButtonConfiguration.getExtrasButtonOnClickListener());
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public View.OnClickListener getExtrasButtonOnClickListener() {
        return this.extrasButtonOnClickListener;
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
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
        boolean z2 = this.isInGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        boolean z3 = this.isRsvped;
        int i3 = z3;
        if (z3 != 0) {
            i3 = 1;
        }
        int i4 = (i2 + i3) * 31;
        boolean z4 = this.isDetailView;
        int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        View.OnClickListener primaryButtonOnClickListener = getPrimaryButtonOnClickListener();
        int iHashCode2 = (i5 + (primaryButtonOnClickListener != null ? primaryButtonOnClickListener.hashCode() : 0)) * 31;
        View.OnClickListener secondaryButtonOnClickListener = getSecondaryButtonOnClickListener();
        int iHashCode3 = (iHashCode2 + (secondaryButtonOnClickListener != null ? secondaryButtonOnClickListener.hashCode() : 0)) * 31;
        View.OnClickListener shareButtonOnClickListener = getShareButtonOnClickListener();
        int iHashCode4 = (iHashCode3 + (shareButtonOnClickListener != null ? shareButtonOnClickListener.hashCode() : 0)) * 31;
        View.OnClickListener extrasButtonOnClickListener = getExtrasButtonOnClickListener();
        return iHashCode4 + (extrasButtonOnClickListener != null ? extrasButtonOnClickListener.hashCode() : 0);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    /* renamed from: isAnyButtonVisible, reason: from getter */
    public boolean getIsAnyButtonVisible() {
        return this.isAnyButtonVisible;
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
        if (this.isInGuild) {
            return FormatUtils.h(context, R.string.hub_directory_card_joined_guild_button, new Object[0], null, 4);
        }
        Object[] objArr = new Object[1];
        Guild guild = this.guildScheduledEvent.getGuild();
        objArr[0] = guild != null ? guild.getName() : null;
        return FormatUtils.h(context, R.string.lurker_mode_nag_bar_button, objArr, null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public CharSequence secondaryButtonText(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return FormatUtils.h(context, R.string.indicate_rsvp, new Object[0], null, 4);
    }

    @Override // com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration
    public int secondaryButtonTextColor(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return !getSecondaryButtonEnabled() ? ColorCompat.getColor(context, R.color.white_alpha_40) : (!this.isRsvped || this.isEventActive || this.isEventComplete) ? ColorCompat.getColor(context, R.color.white) : ColorCompat.getThemedColor(context, R.attr.colorBackgroundAccent);
    }

    public String toString() {
        StringBuilder sbU = outline.U("DirectoryButtonConfiguration(guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(", isInGuild=");
        sbU.append(this.isInGuild);
        sbU.append(", isRsvped=");
        sbU.append(this.isRsvped);
        sbU.append(", isDetailView=");
        sbU.append(this.isDetailView);
        sbU.append(", primaryButtonOnClickListener=");
        sbU.append(getPrimaryButtonOnClickListener());
        sbU.append(", secondaryButtonOnClickListener=");
        sbU.append(getSecondaryButtonOnClickListener());
        sbU.append(", shareButtonOnClickListener=");
        sbU.append(getShareButtonOnClickListener());
        sbU.append(", extrasButtonOnClickListener=");
        sbU.append(getExtrasButtonOnClickListener());
        sbU.append(")");
        return sbU.toString();
    }
}
