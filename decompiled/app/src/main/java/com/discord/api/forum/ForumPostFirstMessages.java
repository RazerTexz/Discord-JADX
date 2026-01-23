package com.discord.api.forum;

import java.util.Map;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ForumPostFirstMessages.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ForumPostFirstMessages {
    private final Map<Long, ForumPostFirstMessages2> threads;

    /* JADX INFO: renamed from: a */
    public final Map<Long, ForumPostFirstMessages2> m7821a() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumPostFirstMessages) && Intrinsics3.areEqual(this.threads, ((ForumPostFirstMessages) other).threads);
        }
        return true;
    }

    public int hashCode() {
        Map<Long, ForumPostFirstMessages2> map = this.threads;
        if (map != null) {
            return map.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m825M(outline.m833U("ForumPostFirstMessages(threads="), this.threads, ")");
    }
}
