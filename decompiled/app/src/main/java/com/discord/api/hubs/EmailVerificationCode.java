package com.discord.api.hubs;

import b.d.b.a.a;
import com.discord.api.guild.Guild;
import d0.z.d.m;

/* compiled from: EmailVerification.kt */
/* loaded from: classes.dex */
public final /* data */ class EmailVerificationCode {
    private final Guild guild;
    private final boolean joined;

    /* renamed from: a, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getJoined() {
        return this.joined;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmailVerificationCode)) {
            return false;
        }
        EmailVerificationCode emailVerificationCode = (EmailVerificationCode) other;
        return m.areEqual(this.guild, emailVerificationCode.guild) && this.joined == emailVerificationCode.joined;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        boolean z2 = this.joined;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmailVerificationCode(guild=");
        sbU.append(this.guild);
        sbU.append(", joined=");
        return a.O(sbU, this.joined, ")");
    }
}
