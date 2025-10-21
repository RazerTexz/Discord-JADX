package com.discord.api.message.allowedmentions;

import com.discord.models.domain.ModelGuildMemberListUpdate;

/* compiled from: MessageAllowedMentions.kt */
/* renamed from: com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes, reason: use source file name */
/* loaded from: classes.dex */
public enum MessageAllowedMentions2 {
    USERS("users"),
    ROLES("roles"),
    EVERYONE(ModelGuildMemberListUpdate.EVERYONE_ID);

    private final String apiStringRepresentation;

    MessageAllowedMentions2(String str) {
        this.apiStringRepresentation = str;
    }

    /* renamed from: serialize, reason: from getter */
    public final String getApiStringRepresentation() {
        return this.apiStringRepresentation;
    }
}
