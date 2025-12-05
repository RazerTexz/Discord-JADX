package com.discord.api.connectedaccounts;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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
        StringBuilder sbM833U = outline.m833U("ConnectedIntegrationAccount(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        return outline.m822J(sbM833U, this.name, ")");
    }
}
