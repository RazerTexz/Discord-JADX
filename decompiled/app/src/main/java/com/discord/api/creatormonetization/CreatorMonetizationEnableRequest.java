package com.discord.api.creatormonetization;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CreatorMonetizationEnableRequest.kt */
/* loaded from: classes.dex */
public final /* data */ class CreatorMonetizationEnableRequest {
    private final long id;
    private final State state;

    /* compiled from: CreatorMonetizationEnableRequest.kt */
    public enum State {
        OPEN,
        REJECTED,
        APPROVED
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final State getState() {
        return this.state;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatorMonetizationEnableRequest)) {
            return false;
        }
        CreatorMonetizationEnableRequest creatorMonetizationEnableRequest = (CreatorMonetizationEnableRequest) other;
        return this.id == creatorMonetizationEnableRequest.id && Intrinsics3.areEqual(this.state, creatorMonetizationEnableRequest.state);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        State state = this.state;
        return i + (state != null ? state.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CreatorMonetizationEnableRequest(id=");
        sbM833U.append(this.id);
        sbM833U.append(", state=");
        sbM833U.append(this.state);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
