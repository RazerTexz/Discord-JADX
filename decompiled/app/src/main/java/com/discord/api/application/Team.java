package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Team.kt */
/* loaded from: classes.dex */
public final /* data */ class Team {
    private final String icon;
    private final long id;
    private final String name;
    private final long ownerUserId;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Team)) {
            return false;
        }
        Team team = (Team) other;
        return this.id == team.id && Intrinsics3.areEqual(this.icon, team.icon) && Intrinsics3.areEqual(this.name, team.name) && this.ownerUserId == team.ownerUserId;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.icon;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j2 = this.ownerUserId;
        return iHashCode2 + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Team(id=");
        sbM833U.append(this.id);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", ownerUserId=");
        return outline.m815C(sbM833U, this.ownerUserId, ")");
    }
}
