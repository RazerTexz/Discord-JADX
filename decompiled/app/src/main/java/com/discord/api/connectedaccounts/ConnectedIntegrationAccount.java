package com.discord.api.connectedaccounts;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ConnectedIntegrationAccount.kt */
/* loaded from: classes.dex */
public final /* data */ class ConnectedIntegrationAccount {
    private final String id;
    private final String name;

    /* renamed from: a, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectedIntegrationAccount)) {
            return false;
        }
        ConnectedIntegrationAccount connectedIntegrationAccount = (ConnectedIntegrationAccount) other;
        return Intrinsics3.areEqual(this.id, connectedIntegrationAccount.id) && Intrinsics3.areEqual(this.name, connectedIntegrationAccount.name);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ConnectedIntegrationAccount(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
