package com.discord.widgets.channels.list.items;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.user.UserUtils;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: CollapsedUser.kt */
/* loaded from: classes2.dex */
public final /* data */ class CollapsedUser implements MGRecyclerDataPayload {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean emptySlot;
    private final long extraCount;
    private final String key;
    private final int type;
    private final User user;

    /* compiled from: CollapsedUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ CollapsedUser createEmptyUser$default(Companion companion, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = 0;
            }
            return companion.createEmptyUser(j);
        }

        public final CollapsedUser createEmptyUser(long extraCount) {
            return new CollapsedUser(UserUtils.INSTANCE.getEMPTY_USER(), true, Math.min(99L, extraCount));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CollapsedUser(User user, boolean z2, long j) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.emptySlot = z2;
        this.extraCount = j;
        this.key = String.valueOf(user.getId());
    }

    public static /* synthetic */ CollapsedUser copy$default(CollapsedUser collapsedUser, User user, boolean z2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            user = collapsedUser.user;
        }
        if ((i & 2) != 0) {
            z2 = collapsedUser.emptySlot;
        }
        if ((i & 4) != 0) {
            j = collapsedUser.extraCount;
        }
        return collapsedUser.copy(user, z2, j);
    }

    /* renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getEmptySlot() {
        return this.emptySlot;
    }

    /* renamed from: component3, reason: from getter */
    public final long getExtraCount() {
        return this.extraCount;
    }

    public final CollapsedUser copy(User user, boolean emptySlot, long extraCount) {
        Intrinsics3.checkNotNullParameter(user, "user");
        return new CollapsedUser(user, emptySlot, extraCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollapsedUser)) {
            return false;
        }
        CollapsedUser collapsedUser = (CollapsedUser) other;
        return Intrinsics3.areEqual(this.user, collapsedUser.user) && this.emptySlot == collapsedUser.emptySlot && this.extraCount == collapsedUser.extraCount;
    }

    public final boolean getEmptySlot() {
        return this.emptySlot;
    }

    public final long getExtraCount() {
        return this.extraCount;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        boolean z2 = this.emptySlot;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return b.a(this.extraCount) + ((iHashCode + i) * 31);
    }

    public String toString() {
        StringBuilder sbU = outline.U("CollapsedUser(user=");
        sbU.append(this.user);
        sbU.append(", emptySlot=");
        sbU.append(this.emptySlot);
        sbU.append(", extraCount=");
        return outline.C(sbU, this.extraCount, ")");
    }

    public /* synthetic */ CollapsedUser(User user, boolean z2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 0L : j);
    }
}
