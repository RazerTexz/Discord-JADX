package com.discord.api.role;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;

/* compiled from: GuildRole.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildRole implements Serializable {
    private final int color;
    private final boolean hoist;
    private final String icon;
    private final long id;
    private final boolean managed;
    private final boolean mentionable;
    private final String name;
    private final long permissions;
    private final int position;
    private final GuildRoleTags tags;
    private final String unicodeEmoji;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final int getColor() {
        return this.color;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHoist() {
        return this.hoist;
    }

    /* renamed from: d, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRole)) {
            return false;
        }
        GuildRole guildRole = (GuildRole) other;
        return this.position == guildRole.position && Intrinsics3.areEqual(this.name, guildRole.name) && this.id == guildRole.id && this.color == guildRole.color && this.hoist == guildRole.hoist && this.permissions == guildRole.permissions && this.mentionable == guildRole.mentionable && this.managed == guildRole.managed && Intrinsics3.areEqual(this.icon, guildRole.icon) && Intrinsics3.areEqual(this.tags, guildRole.tags) && Intrinsics3.areEqual(this.unicodeEmoji, guildRole.unicodeEmoji);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMentionable() {
        return this.mentionable;
    }

    /* renamed from: g, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final long getPermissions() {
        return this.permissions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.position * 31;
        String str = this.name;
        int iHashCode = str != null ? str.hashCode() : 0;
        long j = this.id;
        int i2 = (((((i + iHashCode) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.color) * 31;
        boolean z2 = this.hoist;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        long j2 = this.permissions;
        int i4 = (((i2 + i3) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        boolean z3 = this.mentionable;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (i4 + i5) * 31;
        boolean z4 = this.managed;
        int i7 = (i6 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (i7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        GuildRoleTags guildRoleTags = this.tags;
        int iHashCode3 = (iHashCode2 + (guildRoleTags != null ? guildRoleTags.hashCode() : 0)) * 31;
        String str3 = this.unicodeEmoji;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final int getPosition() {
        return this.position;
    }

    /* renamed from: j, reason: from getter */
    public final GuildRoleTags getTags() {
        return this.tags;
    }

    /* renamed from: k, reason: from getter */
    public final String getUnicodeEmoji() {
        return this.unicodeEmoji;
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildRole(position=");
        sbU.append(this.position);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", id=");
        sbU.append(this.id);
        sbU.append(", color=");
        sbU.append(this.color);
        sbU.append(", hoist=");
        sbU.append(this.hoist);
        sbU.append(", permissions=");
        sbU.append(this.permissions);
        sbU.append(", mentionable=");
        sbU.append(this.mentionable);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", tags=");
        sbU.append(this.tags);
        sbU.append(", unicodeEmoji=");
        return outline.J(sbU, this.unicodeEmoji, ")");
    }
}
