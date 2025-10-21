package com.discord.widgets.forums;

import a0.a.a.b;
import b.d.b.a.outline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ForumPostReadState.kt */
/* loaded from: classes2.dex */
public final /* data */ class ForumPostReadState {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final boolean hasSeenBefore;
    private final boolean hasUnread;

    /* compiled from: ForumPostReadState.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ForumPostReadState createDefault(long channelId) {
            return new ForumPostReadState(channelId, true, false);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ForumPostReadState(long j, boolean z2, boolean z3) {
        this.channelId = j;
        this.hasSeenBefore = z2;
        this.hasUnread = z3;
    }

    public static /* synthetic */ ForumPostReadState copy$default(ForumPostReadState forumPostReadState, long j, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = forumPostReadState.channelId;
        }
        if ((i & 2) != 0) {
            z2 = forumPostReadState.hasSeenBefore;
        }
        if ((i & 4) != 0) {
            z3 = forumPostReadState.hasUnread;
        }
        return forumPostReadState.copy(j, z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    public final ForumPostReadState copy(long channelId, boolean hasSeenBefore, boolean hasUnread) {
        return new ForumPostReadState(channelId, hasSeenBefore, hasUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForumPostReadState)) {
            return false;
        }
        ForumPostReadState forumPostReadState = (ForumPostReadState) other;
        return this.channelId == forumPostReadState.channelId && this.hasSeenBefore == forumPostReadState.hasSeenBefore && this.hasUnread == forumPostReadState.hasUnread;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final boolean getHasSeenBefore() {
        return this.hasSeenBefore;
    }

    public final boolean getHasUnread() {
        return this.hasUnread;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.channelId) * 31;
        boolean z2 = this.hasSeenBefore;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iA + i) * 31;
        boolean z3 = this.hasUnread;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ForumPostReadState(channelId=");
        sbU.append(this.channelId);
        sbU.append(", hasSeenBefore=");
        sbU.append(this.hasSeenBefore);
        sbU.append(", hasUnread=");
        return outline.O(sbU, this.hasUnread, ")");
    }
}
