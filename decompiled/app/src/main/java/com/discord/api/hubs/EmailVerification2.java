package com.discord.api.hubs;

import com.discord.api.guild.Guild;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EmailVerification.kt */
/* renamed from: com.discord.api.hubs.EmailVerificationCode, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class EmailVerification2 {
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
        if (!(other instanceof EmailVerification2)) {
            return false;
        }
        EmailVerification2 emailVerification2 = (EmailVerification2) other;
        return Intrinsics3.areEqual(this.guild, emailVerification2.guild) && this.joined == emailVerification2.joined;
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
        StringBuilder sbM833U = outline.m833U("EmailVerificationCode(guild=");
        sbM833U.append(this.guild);
        sbM833U.append(", joined=");
        return outline.m827O(sbM833U, this.joined, ")");
    }
}
