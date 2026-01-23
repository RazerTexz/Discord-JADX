package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: TrackSpotifyListenAlongEnded.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class TrackSpotifyListenAlongEnded implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence partyId = null;
    private final Long otherUserId = null;
    private final transient String analyticsSchemaTypeName = "spotify_listen_along_ended";

    @Override // com.discord.api.science.AnalyticsSchema
    /* JADX INFO: renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSpotifyListenAlongEnded)) {
            return false;
        }
        TrackSpotifyListenAlongEnded trackSpotifyListenAlongEnded = (TrackSpotifyListenAlongEnded) other;
        return Intrinsics3.areEqual(this.partyId, trackSpotifyListenAlongEnded.partyId) && Intrinsics3.areEqual(this.otherUserId, trackSpotifyListenAlongEnded.otherUserId);
    }

    public int hashCode() {
        CharSequence charSequence = this.partyId;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        Long l = this.otherUserId;
        return iHashCode + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSpotifyListenAlongEnded(partyId=");
        sbM833U.append(this.partyId);
        sbM833U.append(", otherUserId=");
        return outline.m819G(sbM833U, this.otherUserId, ")");
    }
}
