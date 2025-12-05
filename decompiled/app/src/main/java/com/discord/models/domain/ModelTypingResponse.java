package com.discord.models.domain;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelTypingResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelTypingResponse {
    private final Long messageSendCooldownMs;
    private final Long threadCreateCooldownMs;

    public ModelTypingResponse(Long l, Long l2) {
        this.messageSendCooldownMs = l;
        this.threadCreateCooldownMs = l2;
    }

    public static /* synthetic */ ModelTypingResponse copy$default(ModelTypingResponse modelTypingResponse, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = modelTypingResponse.messageSendCooldownMs;
        }
        if ((i & 2) != 0) {
            l2 = modelTypingResponse.threadCreateCooldownMs;
        }
        return modelTypingResponse.copy(l, l2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public final ModelTypingResponse copy(Long messageSendCooldownMs, Long threadCreateCooldownMs) {
        return new ModelTypingResponse(messageSendCooldownMs, threadCreateCooldownMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelTypingResponse)) {
            return false;
        }
        ModelTypingResponse modelTypingResponse = (ModelTypingResponse) other;
        return Intrinsics3.areEqual(this.messageSendCooldownMs, modelTypingResponse.messageSendCooldownMs) && Intrinsics3.areEqual(this.threadCreateCooldownMs, modelTypingResponse.threadCreateCooldownMs);
    }

    public final Long getMessageSendCooldownMs() {
        return this.messageSendCooldownMs;
    }

    public final Long getThreadCreateCooldownMs() {
        return this.threadCreateCooldownMs;
    }

    public int hashCode() {
        Long l = this.messageSendCooldownMs;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        Long l2 = this.threadCreateCooldownMs;
        return iHashCode + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelTypingResponse(messageSendCooldownMs=");
        sbM833U.append(this.messageSendCooldownMs);
        sbM833U.append(", threadCreateCooldownMs=");
        return outline.m819G(sbM833U, this.threadCreateCooldownMs, ")");
    }
}
