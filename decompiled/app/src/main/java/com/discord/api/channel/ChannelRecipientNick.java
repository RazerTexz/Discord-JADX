package com.discord.api.channel;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChannelRecipientNick.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ChannelRecipientNick {
    private final long id;
    private final String nick;

    public ChannelRecipientNick(long j, String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NICK);
        this.id = j;
        this.nick = str;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: b */
    public final long m7664b() {
        return this.id;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getNick() {
        return this.nick;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelRecipientNick)) {
            return false;
        }
        ChannelRecipientNick channelRecipientNick = (ChannelRecipientNick) other;
        return this.id == channelRecipientNick.id && Intrinsics3.areEqual(this.nick, channelRecipientNick.nick);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.nick;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ChannelRecipientNick(id=");
        sbM833U.append(this.id);
        sbM833U.append(", nick=");
        return outline.m822J(sbM833U, this.nick, ")");
    }
}
