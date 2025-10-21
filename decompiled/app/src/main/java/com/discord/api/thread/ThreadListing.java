package com.discord.api.thread;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: ThreadListing.kt */
/* loaded from: classes.dex */
public final /* data */ class ThreadListing {
    private final List<Message> firstMessages;
    private final boolean hasMore;
    private final List<ThreadMember> members;
    private final List<Channel> threads;

    public final List<Message> a() {
        return this.firstMessages;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<Channel> c() {
        return this.threads;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThreadListing)) {
            return false;
        }
        ThreadListing threadListing = (ThreadListing) other;
        return Intrinsics3.areEqual(this.threads, threadListing.threads) && this.hasMore == threadListing.hasMore && Intrinsics3.areEqual(this.members, threadListing.members) && Intrinsics3.areEqual(this.firstMessages, threadListing.firstMessages);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Channel> list = this.threads;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        boolean z2 = this.hasMore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode + i) * 31;
        List<ThreadMember> list2 = this.members;
        int iHashCode2 = (i2 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Message> list3 = this.firstMessages;
        return iHashCode2 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ThreadListing(threads=");
        sbU.append(this.threads);
        sbU.append(", hasMore=");
        sbU.append(this.hasMore);
        sbU.append(", members=");
        sbU.append(this.members);
        sbU.append(", firstMessages=");
        return outline.L(sbU, this.firstMessages, ")");
    }
}
