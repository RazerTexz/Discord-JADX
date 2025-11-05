package com.discord.api.guildhash;

import b.d.b.a.a;
import d0.z.d.m;

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
        return m.areEqual(this.hash, guildHash.hash) && this.omitted == guildHash.omitted;
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
        StringBuilder sbU = a.U("GuildHash(hash=");
        sbU.append(this.hash);
        sbU.append(", omitted=");
        return a.O(sbU, this.omitted, ")");
    }
}
