package com.discord.api.interaction;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* compiled from: InteractionStateUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class InteractionStateUpdate {
    private final Long id;
    private final String nonce;

    public InteractionStateUpdate(Long l, String str) {
        m.checkNotNullParameter(str, "nonce");
        this.id = l;
        this.nonce = str;
    }

    /* renamed from: a, reason: from getter */
    public final Long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionStateUpdate)) {
            return false;
        }
        InteractionStateUpdate interactionStateUpdate = (InteractionStateUpdate) other;
        return m.areEqual(this.id, interactionStateUpdate.id) && m.areEqual(this.nonce, interactionStateUpdate.nonce);
    }

    public int hashCode() {
        Long l = this.id;
        int iHashCode = (l != null ? l.hashCode() : 0) * 31;
        String str = this.nonce;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("InteractionStateUpdate(id=");
        sbU.append(this.id);
        sbU.append(", nonce=");
        return a.J(sbU, this.nonce, ")");
    }
}
