package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackApplicationUpdated.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackApplicationUpdated implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence name = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final CharSequence description = null;
    private final CharSequence iconHash = null;
    private final CharSequence coverImageHash = null;
    private final Long linkedGuildId = null;
    private final CharSequence previousStoreState = null;
    private final CharSequence currentStoreState = null;
    private final transient String analyticsSchemaTypeName = "application_updated";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackApplicationUpdated)) {
            return false;
        }
        TrackApplicationUpdated trackApplicationUpdated = (TrackApplicationUpdated) other;
        return Intrinsics3.areEqual(this.applicationId, trackApplicationUpdated.applicationId) && Intrinsics3.areEqual(this.botId, trackApplicationUpdated.botId) && Intrinsics3.areEqual(this.name, trackApplicationUpdated.name) && Intrinsics3.areEqual(this.hasBot, trackApplicationUpdated.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackApplicationUpdated.hasRedirectUri) && Intrinsics3.areEqual(this.description, trackApplicationUpdated.description) && Intrinsics3.areEqual(this.iconHash, trackApplicationUpdated.iconHash) && Intrinsics3.areEqual(this.coverImageHash, trackApplicationUpdated.coverImageHash) && Intrinsics3.areEqual(this.linkedGuildId, trackApplicationUpdated.linkedGuildId) && Intrinsics3.areEqual(this.previousStoreState, trackApplicationUpdated.previousStoreState) && Intrinsics3.areEqual(this.currentStoreState, trackApplicationUpdated.currentStoreState);
    }

    public int hashCode() {
        Long l = this.applicationId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.botId;
        int iHashCode2 = (iHashCode + (l2 != null ? l2.hashCode() : 0)) * 31;
        CharSequence charSequence = this.name;
        int iHashCode3 = (iHashCode2 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        Boolean bool = this.hasBot;
        int iHashCode4 = (iHashCode3 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.hasRedirectUri;
        int iHashCode5 = (iHashCode4 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.description;
        int iHashCode6 = (iHashCode5 + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.iconHash;
        int iHashCode7 = (iHashCode6 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.coverImageHash;
        int iHashCode8 = (iHashCode7 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        Long l3 = this.linkedGuildId;
        int iHashCode9 = (iHashCode8 + (l3 != null ? l3.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.previousStoreState;
        int iHashCode10 = (iHashCode9 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.currentStoreState;
        return iHashCode10 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackApplicationUpdated(applicationId=");
        sbM833U.append(this.applicationId);
        sbM833U.append(", botId=");
        sbM833U.append(this.botId);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", hasBot=");
        sbM833U.append(this.hasBot);
        sbM833U.append(", hasRedirectUri=");
        sbM833U.append(this.hasRedirectUri);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", iconHash=");
        sbM833U.append(this.iconHash);
        sbM833U.append(", coverImageHash=");
        sbM833U.append(this.coverImageHash);
        sbM833U.append(", linkedGuildId=");
        sbM833U.append(this.linkedGuildId);
        sbM833U.append(", previousStoreState=");
        sbM833U.append(this.previousStoreState);
        sbM833U.append(", currentStoreState=");
        return outline.m817E(sbM833U, this.currentStoreState, ")");
    }
}
