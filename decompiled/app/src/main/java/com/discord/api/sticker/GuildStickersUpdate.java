package com.discord.api.sticker;

import com.discord.api.guildhash.GuildHashes;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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

    /* renamed from: c */
    public final List<Sticker> m8233c() {
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
        StringBuilder sbM833U = outline.m833U("GuildStickersUpdate(guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", stickers=");
        sbM833U.append(this.stickers);
        sbM833U.append(", guildHashes=");
        sbM833U.append(this.guildHashes);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
