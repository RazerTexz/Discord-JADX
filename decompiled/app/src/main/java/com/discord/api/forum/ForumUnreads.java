package com.discord.api.forum;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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

    /* renamed from: b */
    public final List<ForumUnread> m7825b() {
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
        return this.channelId == forumUnreads.channelId && this.permissionDenied == forumUnreads.permissionDenied && Intrinsics3.areEqual(this.threads, forumUnreads.threads);
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
        StringBuilder sbM833U = outline.m833U("ForumUnreads(channelId=");
        sbM833U.append(this.channelId);
        sbM833U.append(", permissionDenied=");
        sbM833U.append(this.permissionDenied);
        sbM833U.append(", threads=");
        return outline.m824L(sbM833U, this.threads, ")");
    }
}
