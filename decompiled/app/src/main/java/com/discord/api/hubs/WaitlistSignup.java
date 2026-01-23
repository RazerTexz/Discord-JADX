package com.discord.api.hubs;

import androidx.core.app.NotificationCompat;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WaitlistSignup.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WaitlistSignup {
    private final String email;
    private final String emailDomain;
    private final String school;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getSchool() {
        return this.school;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WaitlistSignup)) {
            return false;
        }
        WaitlistSignup waitlistSignup = (WaitlistSignup) other;
        return Intrinsics3.areEqual(this.email, waitlistSignup.email) && Intrinsics3.areEqual(this.emailDomain, waitlistSignup.emailDomain) && Intrinsics3.areEqual(this.school, waitlistSignup.school);
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.emailDomain;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.school;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WaitlistSignup(email=");
        sbM833U.append(this.email);
        sbM833U.append(", emailDomain=");
        sbM833U.append(this.emailDomain);
        sbM833U.append(", school=");
        return outline.m822J(sbM833U, this.school, ")");
    }
}
