package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ThreadMemberUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class ThreadMemberUpdate {
    private final int flags;
    private final long guildId;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    /* renamed from: a, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: b, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: c, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: d, reason: from getter */
    public final UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* renamed from: e, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadMemberUpdate)) {
            return false;
        }
        ThreadMemberUpdate threadMemberUpdate = (ThreadMemberUpdate) other;
        return this.id == threadMemberUpdate.id && this.guildId == threadMemberUpdate.guildId && this.userId == threadMemberUpdate.userId && this.flags == threadMemberUpdate.flags && Intrinsics3.areEqual(this.joinTimestamp, threadMemberUpdate.joinTimestamp) && this.muted == threadMemberUpdate.muted && Intrinsics3.areEqual(this.muteConfig, threadMemberUpdate.muteConfig);
    }

    /* renamed from: f, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* renamed from: g, reason: from getter */
    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        long j2 = this.guildId;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.userId;
        int i2 = (((i + ((int) (j3 ^ (j3 >>> 32)))) * 31) + this.flags) * 31;
        UtcDateTime utcDateTime = this.joinTimestamp;
        int iHashCode = (i2 + (utcDateTime != null ? utcDateTime.hashCode() : 0)) * 31;
        boolean z2 = this.muted;
        int i3 = z2;
        if (z2 != 0) {
            i3 = 1;
        }
        int i4 = (iHashCode + i3) * 31;
        MuteConfig muteConfig = this.muteConfig;
        return i4 + (muteConfig != null ? muteConfig.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadMemberUpdate(id=");
        sbU.append(this.id);
        sbU.append(", guildId=");
        sbU.append(this.guildId);
        sbU.append(", userId=");
        sbU.append(this.userId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", joinTimestamp=");
        sbU.append(this.joinTimestamp);
        sbU.append(", muted=");
        sbU.append(this.muted);
        sbU.append(", muteConfig=");
        sbU.append(this.muteConfig);
        sbU.append(")");
        return sbU.toString();
    }
}
