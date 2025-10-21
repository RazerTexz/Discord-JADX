package com.discord.api.friendsuggestions;

import b.d.b.a.outline;

/* compiled from: FriendSuggestionDelete.kt */
/* loaded from: classes.dex */
public final /* data */ class FriendSuggestionDelete {
    private final long suggestedUserId;

    /* renamed from: a, reason: from getter */
    public final long getSuggestedUserId() {
        return this.suggestedUserId;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FriendSuggestionDelete) && this.suggestedUserId == ((FriendSuggestionDelete) other).suggestedUserId;
        }
        return true;
    }

    public int hashCode() {
        long j = this.suggestedUserId;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return outline.C(outline.U("FriendSuggestionDelete(suggestedUserId="), this.suggestedUserId, ")");
    }
}
