package com.discord.api.hubs;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EmailVerification.kt */
/* loaded from: classes.dex */
public final /* data */ class EmailVerification {
    private final List<EmailVerification3> guildsInfo;
    private final boolean hasMatchingGuild;

    /* renamed from: a */
    public final List<EmailVerification3> m7998a() {
        return this.guildsInfo;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMatchingGuild() {
        return this.hasMatchingGuild;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerification)) {
            return false;
        }
        EmailVerification emailVerification = (EmailVerification) other;
        return Intrinsics3.areEqual(this.guildsInfo, emailVerification.guildsInfo) && this.hasMatchingGuild == emailVerification.hasMatchingGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<EmailVerification3> list = this.guildsInfo;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMatchingGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EmailVerification(guildsInfo=");
        sbM833U.append(this.guildsInfo);
        sbM833U.append(", hasMatchingGuild=");
        return outline.m827O(sbM833U, this.hasMatchingGuild, ")");
    }
}
