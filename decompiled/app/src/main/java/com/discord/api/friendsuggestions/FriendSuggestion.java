package com.discord.api.friendsuggestions;

import com.discord.api.user.User;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: FriendSuggestion.kt */
/* loaded from: classes.dex */
public final /* data */ class FriendSuggestion {
    private final List<FriendSuggestionReason> reasons;
    private final User suggestedUser;

    /* renamed from: a */
    public final List<FriendSuggestionReason> m7830a() {
        return this.reasons;
    }

    /* renamed from: b, reason: from getter */
    public final User getSuggestedUser() {
        return this.suggestedUser;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FriendSuggestion)) {
            return false;
        }
        FriendSuggestion friendSuggestion = (FriendSuggestion) other;
        return Intrinsics3.areEqual(this.suggestedUser, friendSuggestion.suggestedUser) && Intrinsics3.areEqual(this.reasons, friendSuggestion.reasons);
    }

    public int hashCode() {
        User user = this.suggestedUser;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        List<FriendSuggestionReason> list = this.reasons;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("FriendSuggestion(suggestedUser=");
        sbM833U.append(this.suggestedUser);
        sbM833U.append(", reasons=");
        return outline.m824L(sbM833U, this.reasons, ")");
    }
}
