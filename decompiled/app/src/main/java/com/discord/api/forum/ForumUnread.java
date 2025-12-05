package com.discord.api.forum;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ForumUnread.kt */
/* loaded from: classes.dex */
public final /* data */ class ForumUnread {
    private final Integer count;
    private final boolean missing;
    private final long threadId;

    /* renamed from: a, reason: from getter */
    public final Integer getCount() {
        return this.count;
    }

    /* renamed from: b, reason: from getter */
    public final long getThreadId() {
        return this.threadId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumUnread)) {
            return false;
        }
        ForumUnread forumUnread = (ForumUnread) other;
        return this.threadId == forumUnread.threadId && this.missing == forumUnread.missing && Intrinsics3.areEqual(this.count, forumUnread.count);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.threadId;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        boolean z2 = this.missing;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        Integer num = this.count;
        return i3 + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ForumUnread(threadId=");
        sbM833U.append(this.threadId);
        sbM833U.append(", missing=");
        sbM833U.append(this.missing);
        sbM833U.append(", count=");
        return outline.m818F(sbM833U, this.count, ")");
    }
}
