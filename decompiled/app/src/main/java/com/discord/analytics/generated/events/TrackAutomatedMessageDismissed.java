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

/* compiled from: TrackAutomatedMessageDismissed.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAutomatedMessageDismissed implements AnalyticsSchema, TrackBase2, TrackGuild2, TrackChannel2 {
    private TrackBase trackBase;
    private TrackChannel trackChannel;
    private TrackGuild trackGuild;
    private final CharSequence messageAuthor = null;
    private final CharSequence messageName = null;
    private final transient String analyticsSchemaTypeName = "automated_message_dismissed";

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
        if (!(other instanceof TrackAutomatedMessageDismissed)) {
            return false;
        }
        TrackAutomatedMessageDismissed trackAutomatedMessageDismissed = (TrackAutomatedMessageDismissed) other;
        return Intrinsics3.areEqual(this.messageAuthor, trackAutomatedMessageDismissed.messageAuthor) && Intrinsics3.areEqual(this.messageName, trackAutomatedMessageDismissed.messageName);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageAuthor;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.messageName;
        return iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackAutomatedMessageDismissed(messageAuthor=");
        sbM833U.append(this.messageAuthor);
        sbM833U.append(", messageName=");
        return outline.m817E(sbM833U, this.messageName, ")");
    }
}
