package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackSmsMessageStatusChanged.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackSmsMessageStatusChanged implements AnalyticsSchema, TrackBase2 {
    private TrackBase trackBase;
    private final CharSequence messageStatus = null;
    private final CharSequence phoneNumber = null;
    private final CharSequence carrierName = null;
    private final CharSequence messageId = null;
    private final CharSequence accountId = null;
    private final Long errorCode = null;
    private final CharSequence phoneCountry = null;
    private final transient String analyticsSchemaTypeName = "sms_message_status_changed";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackSmsMessageStatusChanged)) {
            return false;
        }
        TrackSmsMessageStatusChanged trackSmsMessageStatusChanged = (TrackSmsMessageStatusChanged) other;
        return Intrinsics3.areEqual(this.messageStatus, trackSmsMessageStatusChanged.messageStatus) && Intrinsics3.areEqual(this.phoneNumber, trackSmsMessageStatusChanged.phoneNumber) && Intrinsics3.areEqual(this.carrierName, trackSmsMessageStatusChanged.carrierName) && Intrinsics3.areEqual(this.messageId, trackSmsMessageStatusChanged.messageId) && Intrinsics3.areEqual(this.accountId, trackSmsMessageStatusChanged.accountId) && Intrinsics3.areEqual(this.errorCode, trackSmsMessageStatusChanged.errorCode) && Intrinsics3.areEqual(this.phoneCountry, trackSmsMessageStatusChanged.phoneCountry);
    }

    public int hashCode() {
        CharSequence charSequence = this.messageStatus;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.phoneNumber;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.carrierName;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.messageId;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.accountId;
        int iHashCode5 = (iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0)) * 31;
        Long l = this.errorCode;
        int iHashCode6 = (iHashCode5 + (l != null ? l.hashCode() : 0)) * 31;
        CharSequence charSequence6 = this.phoneCountry;
        return iHashCode6 + (charSequence6 != null ? charSequence6.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackSmsMessageStatusChanged(messageStatus=");
        sbM833U.append(this.messageStatus);
        sbM833U.append(", phoneNumber=");
        sbM833U.append(this.phoneNumber);
        sbM833U.append(", carrierName=");
        sbM833U.append(this.carrierName);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", accountId=");
        sbM833U.append(this.accountId);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", phoneCountry=");
        return outline.m817E(sbM833U, this.phoneCountry, ")");
    }
}
