package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ApplicationCommandPermission.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationCommandPermission {
    private final long id;
    private final boolean permission;
    private final ApplicationCommandPermission2 type;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getPermission() {
        return this.permission;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandPermission)) {
            return false;
        }
        ApplicationCommandPermission applicationCommandPermission = (ApplicationCommandPermission) other;
        return this.id == applicationCommandPermission.id && Intrinsics3.areEqual(this.type, applicationCommandPermission.type) && this.permission == applicationCommandPermission.permission;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        ApplicationCommandPermission2 applicationCommandPermission2 = this.type;
        int iHashCode = (i + (applicationCommandPermission2 != null ? applicationCommandPermission2.hashCode() : 0)) * 31;
        boolean z2 = this.permission;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandPermission(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", permission=");
        return outline.O(sbU, this.permission, ")");
    }
}
