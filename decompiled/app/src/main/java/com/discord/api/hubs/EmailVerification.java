package com.discord.api.hubs;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* compiled from: EmailVerification.kt */
/* loaded from: classes.dex */
public final /* data */ class EmailVerification {
    private final List<GuildInfo> guildsInfo;
    private final boolean hasMatchingGuild;

    public final List<GuildInfo> a() {
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
        return m.areEqual(this.guildsInfo, emailVerification.guildsInfo) && this.hasMatchingGuild == emailVerification.hasMatchingGuild;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<GuildInfo> list = this.guildsInfo;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMatchingGuild;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmailVerification(guildsInfo=");
        sbU.append(this.guildsInfo);
        sbU.append(", hasMatchingGuild=");
        return a.O(sbU, this.hasMatchingGuild, ")");
    }
}
