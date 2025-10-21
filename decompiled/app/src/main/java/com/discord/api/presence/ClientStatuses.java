package com.discord.api.presence;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: ClientStatuses.kt */
/* loaded from: classes.dex */
public final /* data */ class ClientStatuses {
    private final ClientStatus desktop;
    private final ClientStatus mobile;
    private final ClientStatus web;

    public ClientStatuses(ClientStatus clientStatus, ClientStatus clientStatus2, ClientStatus clientStatus3) {
        this.desktop = clientStatus;
        this.web = clientStatus2;
        this.mobile = clientStatus3;
    }

    public final ClientStatus a() {
        ClientStatus clientStatus = this.desktop;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public final ClientStatus b() {
        ClientStatus clientStatus = this.mobile;
        return clientStatus != null ? clientStatus : ClientStatus.OFFLINE;
    }

    public final ClientStatus c() {
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
        StringBuilder sbU = outline.U("ClientStatuses(desktop=");
        sbU.append(this.desktop);
        sbU.append(", web=");
        sbU.append(this.web);
        sbU.append(", mobile=");
        sbU.append(this.mobile);
        sbU.append(")");
        return sbU.toString();
    }
}
