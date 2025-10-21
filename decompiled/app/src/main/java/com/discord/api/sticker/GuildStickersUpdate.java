package com.discord.api.sticker;

import b.d.b.a.outline;
import com.discord.api.guildhash.GuildHashes;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: GuildStickersUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildStickersUpdate {
    private final GuildHashes guildHashes;
    private final long guildId;
    private final List<Sticker> stickers;

    /* renamed from: a, reason: from getter */
    public final GuildHashes getGuildHashes() {
        return this.guildHashes;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final List<Sticker> c() {
        return this.stickers;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildStickersUpdate)) {
            return false;
        }
        GuildStickersUpdate guildStickersUpdate = (GuildStickersUpdate) other;
        return this.guildId == guildStickersUpdate.guildId && Intrinsics3.areEqual(this.stickers, guildStickersUpdate.stickers) && Intrinsics3.areEqual(this.guildHashes, guildStickersUpdate.guildHashes);
    }

    public int hashCode() {
        long j = this.guildId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        List<Sticker> list = this.stickers;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        GuildHashes guildHashes = this.guildHashes;
        return iHashCode + (guildHashes != null ? guildHashes.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildStickersUpdate(guildId=");
        sbU.append(this.guildId);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", guildHashes=");
        sbU.append(this.guildHashes);
        sbU.append(")");
        return sbU.toString();
    }
}
