package com.discord.analytics.generated.traits;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: TrackEmail.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackEmail {
    private final CharSequence emailType = null;
    private final CharSequence subjectType = null;
    private final CharSequence emailId = null;
    private final CharSequence category = null;
    private final CharSequence version = null;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrackEmail)) {
            return false;
        }
        TrackEmail trackEmail = (TrackEmail) other;
        return Intrinsics3.areEqual(this.emailType, trackEmail.emailType) && Intrinsics3.areEqual(this.subjectType, trackEmail.subjectType) && Intrinsics3.areEqual(this.emailId, trackEmail.emailId) && Intrinsics3.areEqual(this.category, trackEmail.category) && Intrinsics3.areEqual(this.version, trackEmail.version);
    }

    public int hashCode() {
        CharSequence charSequence = this.emailType;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        CharSequence charSequence2 = this.subjectType;
        int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
        CharSequence charSequence3 = this.emailId;
        int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
        CharSequence charSequence4 = this.category;
        int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
        CharSequence charSequence5 = this.version;
        return iHashCode4 + (charSequence5 != null ? charSequence5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("TrackEmail(emailType=");
        sbM833U.append(this.emailType);
        sbM833U.append(", subjectType=");
        sbM833U.append(this.subjectType);
        sbM833U.append(", emailId=");
        sbM833U.append(this.emailId);
        sbM833U.append(", category=");
        sbM833U.append(this.category);
        sbM833U.append(", version=");
        return outline.m817E(sbM833U, this.version, ")");
    }
}
