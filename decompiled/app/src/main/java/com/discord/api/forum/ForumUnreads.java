package com.discord.api.forum;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* compiled from: ForumUnreads.kt */
/* loaded from: classes.dex */
public final /* data */ class ForumUnreads {
    private final long channelId;
    private final boolean permissionDenied;
    private final List<ForumUnread> threads;

    /* renamed from: a, reason: from getter */
    public final boolean getPermissionDenied() {
        return this.permissionDenied;
    }

    public final List<ForumUnread> b() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnreads)) {
            return false;
        }
        ForumUnreads forumUnreads = (ForumUnreads) other;
        return this.channelId == forumUnreads.channelId && this.permissionDenied == forumUnreads.permissionDenied && m.areEqual(this.threads, forumUnreads.threads);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.channelId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.permissionDenied;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        List<ForumUnread> list = this.threads;
        return i3 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ForumUnreads(channelId=");
        sbU.append(this.channelId);
        sbU.append(", permissionDenied=");
        sbU.append(this.permissionDenied);
        sbU.append(", threads=");
        return a.L(sbU, this.threads, ")");
    }
}
