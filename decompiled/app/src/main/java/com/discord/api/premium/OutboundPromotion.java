package com.discord.api.premium;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: OutboundPromotion.kt */
/* loaded from: classes.dex */
public final /* data */ class OutboundPromotion {
    private final UtcDateTime endDate;
    private final long id;
    private final String outboundRedemptionModalBody;
    private final String outboundRedemptionPageLink;
    private final String outboundRedemptionUrlFormat;
    private final String outboundTermsAndConditions;
    private final String outboundTitle;
    private final UtcDateTime startDate;

    /* renamed from: a, reason: from getter */
    public final UtcDateTime getEndDate() {
        return this.endDate;
    }

    /* renamed from: b, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final String getOutboundRedemptionModalBody() {
        return this.outboundRedemptionModalBody;
    }

    /* renamed from: d, reason: from getter */
    public final String getOutboundRedemptionPageLink() {
        return this.outboundRedemptionPageLink;
    }

    /* renamed from: e, reason: from getter */
    public final String getOutboundRedemptionUrlFormat() {
        return this.outboundRedemptionUrlFormat;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OutboundPromotion)) {
            return false;
        }
        OutboundPromotion outboundPromotion = (OutboundPromotion) other;
        return this.id == outboundPromotion.id && Intrinsics3.areEqual(this.startDate, outboundPromotion.startDate) && Intrinsics3.areEqual(this.endDate, outboundPromotion.endDate) && Intrinsics3.areEqual(this.outboundTitle, outboundPromotion.outboundTitle) && Intrinsics3.areEqual(this.outboundRedemptionModalBody, outboundPromotion.outboundRedemptionModalBody) && Intrinsics3.areEqual(this.outboundRedemptionPageLink, outboundPromotion.outboundRedemptionPageLink) && Intrinsics3.areEqual(this.outboundRedemptionUrlFormat, outboundPromotion.outboundRedemptionUrlFormat) && Intrinsics3.areEqual(this.outboundTermsAndConditions, outboundPromotion.outboundTermsAndConditions);
    }

    /* renamed from: f, reason: from getter */
    public final String getOutboundTermsAndConditions() {
        return this.outboundTermsAndConditions;
    }

    /* renamed from: g, reason: from getter */
    public final String getOutboundTitle() {
        return this.outboundTitle;
    }

    /* renamed from: h, reason: from getter */
    public final UtcDateTime getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        UtcDateTime utcDateTime = this.startDate;
        int iHashCode = (i + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        UtcDateTime utcDateTime2 = this.endDate;
        int iHashCode2 = (iHashCode + (utcDateTime2 != null ? utcDateTime2.hashCode() : 0)) * 31;
        String str = this.outboundTitle;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.outboundRedemptionModalBody;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.outboundRedemptionPageLink;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.outboundRedemptionUrlFormat;
        int iHashCode6 = (iHashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.outboundTermsAndConditions;
        return iHashCode6 + (str5 != null ? str5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("OutboundPromotion(id=");
        sbU.append(this.id);
        sbU.append(", startDate=");
        sbU.append(this.startDate);
        sbU.append(", endDate=");
        sbU.append(this.endDate);
        sbU.append(", outboundTitle=");
        sbU.append(this.outboundTitle);
        sbU.append(", outboundRedemptionModalBody=");
        sbU.append(this.outboundRedemptionModalBody);
        sbU.append(", outboundRedemptionPageLink=");
        sbU.append(this.outboundRedemptionPageLink);
        sbU.append(", outboundRedemptionUrlFormat=");
        sbU.append(this.outboundRedemptionUrlFormat);
        sbU.append(", outboundTermsAndConditions=");
        return outline.J(sbU, this.outboundTermsAndConditions, ")");
    }
}
