package com.discord.api.presence;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ClientStatuses.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ClientStatuses {
    private final ClientStatus desktop;
    private final ClientStatus mobile;
    private final ClientStatus web;

    public ClientStatuses(ClientStatus clientStatus, ClientStatus clientStatus2, ClientStatus clientStatus3) {
        this.desktop = clientStatus;
        this.web = clientStatus2;
        this.mobile = clientStatus3;
    }

    /* JADX INFO: renamed from: a */
    public final ClientStatus m8149a() {
        ClientStatus clientStatus = this.desktop;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    /* JADX INFO: renamed from: b */
    public final ClientStatus m8150b() {
        ClientStatus clientStatus = this.mobile;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    /* JADX INFO: renamed from: c */
    public final ClientStatus m8151c() {
        ClientStatus clientStatus = this.web;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ClientStatuses)) {
            return false;
        }
        ClientStatuses clientStatuses = (ClientStatuses) other;
        return Intrinsics3.areEqual(this.desktop, clientStatuses.desktop) && Intrinsics3.areEqual(this.web, clientStatuses.web) && Intrinsics3.areEqual(this.mobile, clientStatuses.mobile);
    }

    public int hashCode() {
        ClientStatus clientStatus = this.desktop;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        ClientStatus clientStatus2 = this.web;
        int iHashCode2 = (iHashCode + (clientStatus2 != null ? clientStatus2.hashCode() : 0)) * 31;
        ClientStatus clientStatus3 = this.mobile;
        return iHashCode2 + (clientStatus3 != null ? clientStatus3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ClientStatuses(desktop=");
        sbM833U.append(this.desktop);
        sbM833U.append(", web=");
        sbM833U.append(this.web);
        sbM833U.append(", mobile=");
        sbM833U.append(this.mobile);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
