package com.discord.api.thread;

import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ThreadMember.kt */
/* loaded from: classes.dex */
public class ThreadMember {
    private final int flags;
    private final long id;
    private final UtcDateTime joinTimestamp;
    private final MuteConfig muteConfig;
    private final boolean muted;
    private final long userId;

    public ThreadMember(long j, long j2, int i, UtcDateTime utcDateTime, boolean z2, MuteConfig muteConfig) {
        Intrinsics3.checkNotNullParameter(utcDateTime, "joinTimestamp");
        this.id = j;
        this.userId = j2;
        this.flags = i;
        this.joinTimestamp = utcDateTime;
        this.muted = z2;
        this.muteConfig = muteConfig;
    }

    /* renamed from: a, reason: from getter */
    public int getFlags() {
        return this.flags;
    }

    /* renamed from: b, reason: from getter */
    public long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public UtcDateTime getJoinTimestamp() {
        return this.joinTimestamp;
    }

    /* renamed from: d, reason: from getter */
    public final MuteConfig getMuteConfig() {
        return this.muteConfig;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getMuted() {
        return this.muted;
    }

    /* renamed from: f, reason: from getter */
    public long getUserId() {
        return this.userId;
    }
}
