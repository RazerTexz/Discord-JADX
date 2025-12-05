package com.discord.widgets.chat.list.entries;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildWelcomeEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class GuildWelcomeEntry extends ChatListEntry {
    private final boolean canInvite;
    private final boolean guildHasIcon;
    private final long guildId;
    private final String guildName;
    private final boolean isOwner;
    private final String key;
    private final int type;

    public GuildWelcomeEntry(boolean z2, boolean z3, boolean z4, long j, String str) {
        Intrinsics3.checkNotNullParameter(str, "guildName");
        this.isOwner = z2;
        this.guildHasIcon = z3;
        this.canInvite = z4;
        this.guildId = j;
        this.guildName = str;
        this.type = 25;
        StringBuilder sb = new StringBuilder();
        sb.append(getType());
        sb.append(j);
        this.key = sb.toString();
    }

    public static /* synthetic */ GuildWelcomeEntry copy$default(GuildWelcomeEntry guildWelcomeEntry, boolean z2, boolean z3, boolean z4, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = guildWelcomeEntry.isOwner;
        }
        if ((i & 2) != 0) {
            z3 = guildWelcomeEntry.guildHasIcon;
        }
        boolean z5 = z3;
        if ((i & 4) != 0) {
            z4 = guildWelcomeEntry.canInvite;
        }
        boolean z6 = z4;
        if ((i & 8) != 0) {
            j = guildWelcomeEntry.guildId;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str = guildWelcomeEntry.guildName;
        }
        return guildWelcomeEntry.copy(z2, z5, z6, j2, str);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsOwner() {
        return this.isOwner;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanInvite() {
        return this.canInvite;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGuildName() {
        return this.guildName;
    }

    public final GuildWelcomeEntry copy(boolean isOwner, boolean guildHasIcon, boolean canInvite, long guildId, String guildName) {
        Intrinsics3.checkNotNullParameter(guildName, "guildName");
        return new GuildWelcomeEntry(isOwner, guildHasIcon, canInvite, guildId, guildName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildWelcomeEntry)) {
            return false;
        }
        GuildWelcomeEntry guildWelcomeEntry = (GuildWelcomeEntry) other;
        return this.isOwner == guildWelcomeEntry.isOwner && this.guildHasIcon == guildWelcomeEntry.guildHasIcon && this.canInvite == guildWelcomeEntry.canInvite && this.guildId == guildWelcomeEntry.guildId && Intrinsics3.areEqual(this.guildName, guildWelcomeEntry.guildName);
    }

    public final boolean getCanInvite() {
        return this.canInvite;
    }

    public final boolean getGuildHasIcon() {
        return this.guildHasIcon;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getGuildName() {
        return this.guildName;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.isOwner;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.guildHasIcon;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        boolean z3 = this.canInvite;
        int iM3a = (C0002b.m3a(this.guildId) + ((i3 + (z3 ? 1 : z3 ? 1 : 0)) * 31)) * 31;
        String str = this.guildName;
        return iM3a + (str != null ? str.hashCode() : 0);
    }

    public final boolean isOwner() {
        return this.isOwner;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildWelcomeEntry(isOwner=");
        sbM833U.append(this.isOwner);
        sbM833U.append(", guildHasIcon=");
        sbM833U.append(this.guildHasIcon);
        sbM833U.append(", canInvite=");
        sbM833U.append(this.canInvite);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", guildName=");
        return outline.m822J(sbM833U, this.guildName, ")");
    }
}
