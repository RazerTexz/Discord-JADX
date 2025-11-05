package com.discord.api.friendsuggestions;


/* compiled from: FriendSuggestionReasonType.kt */
/* loaded from: classes.dex */
public enum FriendSuggestionReasonType {
    NONE(0),
    EXTERNAL_FRIEND(1);

    private final int apiValue;

    FriendSuggestionReasonType(int i) {
        this.apiValue = i;
    }

    public final int getApiValue() {
        return this.apiValue;
    }
}
