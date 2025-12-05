package com.discord.api.friendsuggestions;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BulkFriendSuggestions.kt */
/* loaded from: classes.dex */
public final /* data */ class BulkFriendSuggestions {
    private final String bulkAddToken;
    private final List<FriendSuggestion> friendSuggestions;

    /* renamed from: a, reason: from getter */
    public final String getBulkAddToken() {
        return this.bulkAddToken;
    }

    /* renamed from: b */
    public final List<FriendSuggestion> m7829b() {
        return this.friendSuggestions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BulkFriendSuggestions)) {
            return false;
        }
        BulkFriendSuggestions bulkFriendSuggestions = (BulkFriendSuggestions) other;
        return Intrinsics3.areEqual(this.bulkAddToken, bulkFriendSuggestions.bulkAddToken) && Intrinsics3.areEqual(this.friendSuggestions, bulkFriendSuggestions.friendSuggestions);
    }

    public int hashCode() {
        String str = this.bulkAddToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FriendSuggestion> list = this.friendSuggestions;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BulkFriendSuggestions(bulkAddToken=");
        sbM833U.append(this.bulkAddToken);
        sbM833U.append(", friendSuggestions=");
        return outline.m824L(sbM833U, this.friendSuggestions, ")");
    }
}
