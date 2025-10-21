package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackUpdateNote.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackUpdateNote implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long otherUser = null;
    private final CharSequence type = null;
    private final transient String analyticsSchemaTypeName = "update_note";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackUpdateNote)) {
            return false;
        }
        TrackUpdateNote trackUpdateNote = (TrackUpdateNote) other;
        return Intrinsics3.areEqual(this.otherUser, trackUpdateNote.otherUser) && Intrinsics3.areEqual(this.type, trackUpdateNote.type);
    }

    public int hashCode() {
        Long l = this.otherUser;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.type;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackUpdateNote(otherUser=");
        sbU.append(this.otherUser);
        sbU.append(", type=");
        return outline.E(sbU, this.type, ")");
    }
}
