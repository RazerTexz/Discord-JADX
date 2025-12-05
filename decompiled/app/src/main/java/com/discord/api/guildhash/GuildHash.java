package com.discord.api.guildhash;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildHash.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildHash {
    private final String hash;
    private final boolean omitted;

    /* renamed from: a, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getOmitted() {
        return this.omitted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHash)) {
            return false;
        }
        GuildHash guildHash = (GuildHash) other;
        return Intrinsics3.areEqual(this.hash, guildHash.hash) && this.omitted == guildHash.omitted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.hash;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.omitted;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildHash(hash=");
        sbM833U.append(this.hash);
        sbM833U.append(", omitted=");
        return outline.m827O(sbM833U, this.omitted, ")");
    }
}
