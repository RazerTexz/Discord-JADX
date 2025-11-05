package com.discord.api.message.allowedmentions;

import com.discord.models.domain.ModelGuildMemberListUpdate;

/* compiled from: MessageAllowedMentions.kt */
/* loaded from: classes.dex */
public enum MessageAllowedMentionsTypes {
    USERS("users"),
    ROLES("roles"),
    EVERYONE(ModelGuildMemberListUpdate.EVERYONE_ID);

    private final String apiStringRepresentation;

    MessageAllowedMentionsTypes(String str) {
        this.apiStringRepresentation = str;
    }

    /* renamed from: serialize, reason: from getter */
    public final String getApiStringRepresentation() {
        return this.apiStringRepresentation;
    }
}
