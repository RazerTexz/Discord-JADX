package com.discord.api.emoji;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: GuildEmoji.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildEmoji {
    private final boolean animated;
    private final Boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requireColons;
    private final List<Long> roles;

    public GuildEmoji(long j, String str, List<Long> list, boolean z2, boolean z3, boolean z4, Boolean bool) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.name = str;
        this.roles = list;
        this.requireColons = z2;
        this.managed = z3;
        this.animated = z4;
        this.available = bool;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getAvailable() {
        return this.available;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    /* renamed from: e, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildEmoji)) {
            return false;
        }
        GuildEmoji guildEmoji = (GuildEmoji) other;
        return this.id == guildEmoji.id && Intrinsics3.areEqual(this.name, guildEmoji.name) && Intrinsics3.areEqual(this.roles, guildEmoji.roles) && this.requireColons == guildEmoji.requireColons && this.managed == guildEmoji.managed && this.animated == guildEmoji.animated && Intrinsics3.areEqual(this.available, guildEmoji.available);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getRequireColons() {
        return this.requireColons;
    }

    public final List<Long> g() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.requireColons;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode2 + i2) * 31;
        boolean z3 = this.managed;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z4 = this.animated;
        int i6 = (i5 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
        Boolean bool = this.available;
        return i6 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildEmoji(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requireColons=");
        sbU.append(this.requireColons);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return outline.D(sbU, this.available, ")");
    }
}
