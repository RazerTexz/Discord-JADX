package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackAfCard;
import com.discord.analytics.generated.traits.TrackAfCard2;
import com.discord.analytics.generated.traits.TrackAfGame;
import com.discord.analytics.generated.traits.TrackAfGame2;
import com.discord.analytics.generated.traits.TrackAfParty;
import com.discord.analytics.generated.traits.TrackAfParty2;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Intrinsics3;

/* compiled from: TrackAfUserPopoutOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackAfUserPopoutOpened implements AnalyticsSchema, TrackBase2, TrackAfCard2, TrackAfGame2, TrackAfParty2 {
    private TrackAfCard trackAfCard;
    private TrackAfGame trackAfGame;
    private TrackAfParty trackAfParty;
    private TrackBase trackBase;
    private final Long popoutUserId = null;
    private final Long avatarPosition = null;
    private final transient String analyticsSchemaTypeName = "af_user_popout_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackAfUserPopoutOpened)) {
            return false;
        }
        TrackAfUserPopoutOpened trackAfUserPopoutOpened = (TrackAfUserPopoutOpened) other;
        return Intrinsics3.areEqual(this.popoutUserId, trackAfUserPopoutOpened.popoutUserId) && Intrinsics3.areEqual(this.avatarPosition, trackAfUserPopoutOpened.avatarPosition);
    }

    public int hashCode() {
        Long l = this.popoutUserId;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.avatarPosition;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackAfUserPopoutOpened(popoutUserId=");
        sbU.append(this.popoutUserId);
        sbU.append(", avatarPosition=");
        return outline.G(sbU, this.avatarPosition, ")");
    }
}
