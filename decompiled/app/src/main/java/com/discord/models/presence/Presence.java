package com.discord.models.presence;

import b.d.b.a.outline;
import com.discord.api.activity.Activity;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: Presence.kt */
/* loaded from: classes.dex */
public final /* data */ class Presence {
    private final List<Activity> activities;
    private final ClientStatuses clientStatuses;
    private final ClientStatus status;

    public Presence(ClientStatus clientStatus, ClientStatuses clientStatuses, List<Activity> list) {
        Intrinsics3.checkNotNullParameter(clientStatus, "status");
        this.status = clientStatus;
        this.clientStatuses = clientStatuses;
        this.activities = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Presence copy$default(Presence presence, ClientStatus clientStatus, ClientStatuses clientStatuses, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            clientStatus = presence.status;
        }
        if ((i & 2) != 0) {
            clientStatuses = presence.clientStatuses;
        }
        if ((i & 4) != 0) {
            list = presence.activities;
        }
        return presence.copy(clientStatus, clientStatuses, list);
    }

    /* renamed from: component1, reason: from getter */
    public final ClientStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final ClientStatuses getClientStatuses() {
        return this.clientStatuses;
    }

    public final List<Activity> component3() {
        return this.activities;
    }

    public final Presence copy(ClientStatus status, ClientStatuses clientStatuses, List<Activity> activities) {
        Intrinsics3.checkNotNullParameter(status, "status");
        return new Presence(status, clientStatuses, activities);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Presence)) {
            return false;
        }
        Presence presence = (Presence) other;
        return Intrinsics3.areEqual(this.status, presence.status) && Intrinsics3.areEqual(this.clientStatuses, presence.clientStatuses) && Intrinsics3.areEqual(this.activities, presence.activities);
    }

    public final List<Activity> getActivities() {
        return this.activities;
    }

    public final ClientStatuses getClientStatuses() {
        return this.clientStatuses;
    }

    public final ClientStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        ClientStatus clientStatus = this.status;
        int iHashCode = (clientStatus != null ? clientStatus.hashCode() : 0) * 31;
        ClientStatuses clientStatuses = this.clientStatuses;
        int iHashCode2 = (iHashCode + (clientStatuses != null ? clientStatuses.hashCode() : 0)) * 31;
        List<Activity> list = this.activities;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Presence(status=");
        sbU.append(this.status);
        sbU.append(", clientStatuses=");
        sbU.append(this.clientStatuses);
        sbU.append(", activities=");
        return outline.L(sbU, this.activities, ")");
    }
}
