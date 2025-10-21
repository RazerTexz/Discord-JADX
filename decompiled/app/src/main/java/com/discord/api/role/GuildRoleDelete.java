package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;

/* compiled from: GuildRoleDelete.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildRoleDelete {
    private final GuildHashes guildHashes;
    private final long guildId;
    private final long roleId;

    /* renamed from: a, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getRoleId() {
        return this.roleId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRoleDelete)) {
            return false;
        }
        GuildRoleDelete guildRoleDelete = (GuildRoleDelete) other;
        return this.guildId == guildRoleDelete.guildId && this.roleId == guildRoleDelete.roleId && Intrinsics3.areEqual(this.guildHashes, guildRoleDelete.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        long j2 = this.roleId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return i + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRoleDelete(guildId=");
        sbU.append(this.guildId);
        sbU.append(", roleId=");
        sbU.append(this.roleId);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
