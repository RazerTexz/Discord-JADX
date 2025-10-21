package com.discord.analytics.generated.events;

import b.d.b.a.outline;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: TrackDevPortalRpApprovalFormStateChange.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackDevPortalRpApprovalFormStateChange implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final Long applicationId = null;
    private final Long botId = null;
    private final CharSequence name = null;
    private final Boolean hasBot = null;
    private final Boolean hasRedirectUri = null;
    private final Long state = null;
    private final Boolean joinRequest = null;
    private final Boolean spectate = null;
    private final transient String analyticsSchemaTypeName = "dev_portal_rp_approval_form_state_change";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackDevPortalRpApprovalFormStateChange)) {
            return false;
        }
        TrackDevPortalRpApprovalFormStateChange trackDevPortalRpApprovalFormStateChange = (TrackDevPortalRpApprovalFormStateChange) other;
        return Intrinsics3.areEqual(this.applicationId, trackDevPortalRpApprovalFormStateChange.applicationId) && Intrinsics3.areEqual(this.botId, trackDevPortalRpApprovalFormStateChange.botId) && Intrinsics3.areEqual(this.name, trackDevPortalRpApprovalFormStateChange.name) && Intrinsics3.areEqual(this.hasBot, trackDevPortalRpApprovalFormStateChange.hasBot) && Intrinsics3.areEqual(this.hasRedirectUri, trackDevPortalRpApprovalFormStateChange.hasRedirectUri) && Intrinsics3.areEqual(this.state, trackDevPortalRpApprovalFormStateChange.state) && Intrinsics3.areEqual(this.joinRequest, trackDevPortalRpApprovalFormStateChange.joinRequest) && Intrinsics3.areEqual(this.spectate, trackDevPortalRpApprovalFormStateChange.spectate);
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
        Long l3 = this.state;
        int iHashCode6 = (iHashCode5 + (l3 != null ? l3.hashCode() : 0)) * 31;
        Boolean bool3 = this.joinRequest;
        int iHashCode7 = (iHashCode6 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.spectate;
        return iHashCode7 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("TrackDevPortalRpApprovalFormStateChange(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", botId=");
        sbU.append(this.botId);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", hasBot=");
        sbU.append(this.hasBot);
        sbU.append(", hasRedirectUri=");
        sbU.append(this.hasRedirectUri);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(", joinRequest=");
        sbU.append(this.joinRequest);
        sbU.append(", spectate=");
        return outline.D(sbU, this.spectate, ")");
    }
}
