package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackBotTokenCompromised.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackBotTokenCompromised implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long botId = null;
    private final CharSequence tokenUrl = null;
    private final transient String analyticsSchemaTypeName = "bot_token_compromised";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackBotTokenCompromised)) {
            return false;
        }
        TrackBotTokenCompromised trackBotTokenCompromised = (TrackBotTokenCompromised) other;
        return Intrinsics3.areEqual(this.botId, trackBotTokenCompromised.botId) && Intrinsics3.areEqual(this.tokenUrl, trackBotTokenCompromised.tokenUrl);
    }

    public int hashCode() {
        Long l = this.botId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        CharSequence charSequence = this.tokenUrl;
        return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackBotTokenCompromised(botId=");
        sbU.append(this.botId);
        sbU.append(", tokenUrl=");
        return outline.E(sbU, this.tokenUrl, ")");
    }
}
