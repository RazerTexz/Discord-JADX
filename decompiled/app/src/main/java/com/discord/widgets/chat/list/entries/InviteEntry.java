package com.discord.widgets.chat.list.entries;

import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: InviteEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class InviteEntry extends ChatListEntry {
    private final String eventId;
    private final long guildId;
    private final String inviteCode;
    private final String key;
    private final long messageId;
    private final int type;
    private final long userId;

    public InviteEntry(long j, long j2, String str, long j3, String str2) {
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        this.userId = j;
        this.messageId = j2;
        this.inviteCode = str;
        this.guildId = j3;
        this.eventId = str2;
        this.type = 24;
        this.key = "24 -- " + j2 + " -- " + str;
    }

    public static /* synthetic */ InviteEntry copy$default(InviteEntry inviteEntry, long j, long j2, String str, long j3, String str2, int i, Object obj) {
        return inviteEntry.copy((i & 1) != 0 ? inviteEntry.userId : j, (i & 2) != 0 ? inviteEntry.messageId : j2, (i & 4) != 0 ? inviteEntry.inviteCode : str, (i & 8) != 0 ? inviteEntry.guildId : j3, (i & 16) != 0 ? inviteEntry.eventId : str2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* renamed from: component2, reason: from getter */
    public final long getMessageId() {
        return this.messageId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component4, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    public final InviteEntry copy(long userId, long messageId, String inviteCode, long guildId, String eventId) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        return new InviteEntry(userId, messageId, inviteCode, guildId, eventId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InviteEntry)) {
            return false;
        }
        InviteEntry inviteEntry = (InviteEntry) other;
        return this.userId == inviteEntry.userId && this.messageId == inviteEntry.messageId && Intrinsics3.areEqual(this.inviteCode, inviteEntry.inviteCode) && this.guildId == inviteEntry.guildId && Intrinsics3.areEqual(this.eventId, inviteEntry.eventId);
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        int iM3a = (C0002b.m3a(this.messageId) + (C0002b.m3a(this.userId) * 31)) * 31;
        String str = this.inviteCode;
        int iM3a2 = (C0002b.m3a(this.guildId) + ((iM3a + (str != null ? str.hashCode() : 0)) * 31)) * 31;
        String str2 = this.eventId;
        return iM3a2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("InviteEntry(userId=");
        sbM833U.append(this.userId);
        sbM833U.append(", messageId=");
        sbM833U.append(this.messageId);
        sbM833U.append(", inviteCode=");
        sbM833U.append(this.inviteCode);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", eventId=");
        return outline.m822J(sbM833U, this.eventId, ")");
    }
}
