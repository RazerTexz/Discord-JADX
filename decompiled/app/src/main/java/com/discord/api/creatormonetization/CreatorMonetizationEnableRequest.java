package com.discord.api.creatormonetization;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

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
        StringBuilder sbU = outline.U("CreatorMonetizationEnableRequest(id=");
        sbU.append(this.id);
        sbU.append(", state=");
        sbU.append(this.state);
        sbU.append(")");
        return sbU.toString();
    }
}
