package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.analytics.generated.traits.TrackChannel;
import com.discord.analytics.generated.traits.TrackChannel2;
import com.discord.analytics.generated.traits.TrackGuild;
import com.discord.analytics.generated.traits.TrackGuild2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackFeedUserPreferenceChanged.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackFeedUserPreferenceChanged implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence loadId = null;
    private final CharSequence operation = null;
    private final Long preference = null;
    private final CharSequence entityType = null;
    private final Long messageId = null;
    private final Long targetUserId = null;
    private final transient String analyticsSchemaTypeName = "feed_user_preference_changed";

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: a, reason: from getter */
    public TrackGuild getTrackGuild() {
        return this.trackGuild;
    }

    @Override // com.discord.analytics.generated.traits.TrackGuild2
    /* renamed from: c */
    public void mo7508c(TrackGuild trackGuild) {
        this.trackGuild = trackGuild;
    }

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackFeedUserPreferenceChanged)) {
            return false;
        }
        TrackFeedUserPreferenceChanged trackFeedUserPreferenceChanged = (TrackFeedUserPreferenceChanged) other;
        return Intrinsics3.areEqual(this.loadId, trackFeedUserPreferenceChanged.loadId) && Intrinsics3.areEqual(this.operation, trackFeedUserPreferenceChanged.operation) && Intrinsics3.areEqual(this.preference, trackFeedUserPreferenceChanged.preference) && Intrinsics3.areEqual(this.entityType, trackFeedUserPreferenceChanged.entityType) && Intrinsics3.areEqual(this.messageId, trackFeedUserPreferenceChanged.messageId) && Intrinsics3.areEqual(this.targetUserId, trackFeedUserPreferenceChanged.targetUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.loadId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.operation;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        Long l = this.preference;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.entityType;
        int iHashCode4 = (iHashCode3 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        Long l2 = this.messageId;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Long l3 = this.targetUserId;
        return iHashCode5 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackFeedUserPreferenceChanged(loadId=");
        sbM833U.append(this.loadId);
        sbM833U.append(", operation=");
        sbM833U.append(this.operation);
        sbM833U.append(", preference=");
        sbM833U.append(this.preference);
        sbM833U.append(", entityType=");
        sbM833U.append(this.entityType);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", targetUserId=");
        return outline.m819G(sbM833U, this.targetUserId, ")");
    }
}
