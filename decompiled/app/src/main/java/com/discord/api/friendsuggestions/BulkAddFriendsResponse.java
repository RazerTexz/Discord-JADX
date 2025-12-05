package com.discord.api.friendsuggestions;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BulkAddFriendsResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class BulkAddFriendsResponse {
    private final List<String> failedRequests;
    private final List<String> successfulRequests;

    /* renamed from: a */
    public final List<String> m7826a() {
        return this.failedRequests;
    }

    /* renamed from: b */
    public final List<String> m7827b() {
        return this.successfulRequests;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulkAddFriendsResponse)) {
            return false;
        }
        BulkAddFriendsResponse bulkAddFriendsResponse = (BulkAddFriendsResponse) other;
        return Intrinsics3.areEqual(this.successfulRequests, bulkAddFriendsResponse.successfulRequests) && Intrinsics3.areEqual(this.failedRequests, bulkAddFriendsResponse.failedRequests);
    }

    public int hashCode() {
        List<String> list = this.successfulRequests;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.failedRequests;
        return iHashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BulkAddFriendsResponse(successfulRequests=");
        sbM833U.append(this.successfulRequests);
        sbM833U.append(", failedRequests=");
        return outline.m824L(sbM833U, this.failedRequests, ")");
    }
}
