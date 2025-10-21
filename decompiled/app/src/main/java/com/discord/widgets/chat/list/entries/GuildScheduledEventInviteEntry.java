package com.discord.widgets.chat.list.entries;

import b.d.b.a.outline;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.models.domain.ModelInvite;
import d0.z.d.Intrinsics3;

/* compiled from: GuildScheduledEventInviteEntry.kt */
/* loaded from: classes2.dex */
public final /* data */ class GuildScheduledEventInviteEntry extends ChatListEntry {
    private final GuildScheduledEvent guildScheduledEvent;
    private final ModelInvite invite;
    private final String inviteCode;
    private final String key;
    private final int type;

    public GuildScheduledEventInviteEntry(ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(modelInvite, "invite");
        Intrinsics3.checkNotNullParameter(str, "inviteCode");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.invite = modelInvite;
        this.inviteCode = str;
        this.guildScheduledEvent = guildScheduledEvent;
        this.type = 43;
        StringBuilder sbU = outline.U("43 -- ");
        sbU.append(guildScheduledEvent.getId());
        sbU.append(" -- ");
        sbU.append(str);
        this.key = sbU.toString();
    }

    public static /* synthetic */ GuildScheduledEventInviteEntry copy$default(GuildScheduledEventInviteEntry guildScheduledEventInviteEntry, ModelInvite modelInvite, String str, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite = guildScheduledEventInviteEntry.invite;
        }
        if ((i & 2) != 0) {
            str = guildScheduledEventInviteEntry.inviteCode;
        }
        if ((i & 4) != 0) {
            guildScheduledEvent = guildScheduledEventInviteEntry.guildScheduledEvent;
        }
        return guildScheduledEventInviteEntry.copy(modelInvite, str, guildScheduledEvent);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelInvite getInvite() {
        return this.invite;
    }

    /* renamed from: component2, reason: from getter */
    public final String getInviteCode() {
        return this.inviteCode;
    }

    /* renamed from: component3, reason: from getter */
    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final GuildScheduledEventInviteEntry copy(ModelInvite invite, String inviteCode, GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        return new GuildScheduledEventInviteEntry(invite, inviteCode, guildScheduledEvent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildScheduledEventInviteEntry)) {
            return false;
        }
        GuildScheduledEventInviteEntry guildScheduledEventInviteEntry = (GuildScheduledEventInviteEntry) other;
        return Intrinsics3.areEqual(this.invite, guildScheduledEventInviteEntry.invite) && Intrinsics3.areEqual(this.inviteCode, guildScheduledEventInviteEntry.inviteCode) && Intrinsics3.areEqual(this.guildScheduledEvent, guildScheduledEventInviteEntry.guildScheduledEvent);
    }

    public final GuildScheduledEvent getGuildScheduledEvent() {
        return this.guildScheduledEvent;
    }

    public final ModelInvite getInvite() {
        return this.invite;
    }

    public final String getInviteCode() {
        return this.inviteCode;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ModelInvite modelInvite = this.invite;
        int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
        String str = this.inviteCode;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
        return iHashCode2 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GuildScheduledEventInviteEntry(invite=");
        sbU.append(this.invite);
        sbU.append(", inviteCode=");
        sbU.append(this.inviteCode);
        sbU.append(", guildScheduledEvent=");
        sbU.append(this.guildScheduledEvent);
        sbU.append(")");
        return sbU.toString();
    }
}
