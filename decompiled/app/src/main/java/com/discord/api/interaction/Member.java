package com.discord.api.interaction;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* compiled from: Interaction.kt */
/* loaded from: classes.dex */
public final /* data */ class Member {
    private final boolean deaf;
    private final String joinedAt;
    private final boolean mute;
    private final List<Long> roles;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Member)) {
            return false;
        }
        Member member = (Member) other;
        return m.areEqual(this.roles, member.roles) && m.areEqual(this.joinedAt, member.joinedAt) && this.mute == member.mute && this.deaf == member.deaf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<Long> list = this.roles;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.joinedAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.mute;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        boolean z3 = this.deaf;
        return i2 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Member(roles=");
        sbU.append(this.roles);
        sbU.append(", joinedAt=");
        sbU.append(this.joinedAt);
        sbU.append(", mute=");
        sbU.append(this.mute);
        sbU.append(", deaf=");
        return a.O(sbU, this.deaf, ")");
    }
}
