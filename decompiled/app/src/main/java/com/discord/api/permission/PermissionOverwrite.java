package com.discord.api.permission;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PermissionOverwrite.kt */
/* loaded from: classes.dex */
public final /* data */ class PermissionOverwrite {
    private final long allow;
    private final long deny;
    private final long id;
    private final Type type;

    /* compiled from: PermissionOverwrite.kt */
    public enum Type {
        ROLE,
        MEMBER
    }

    public PermissionOverwrite(long j, Type type, long j2, long j3) {
        Intrinsics3.checkNotNullParameter(type, "type");
        this.id = j;
        this.type = type;
        this.allow = j2;
        this.deny = j3;
    }

    /* renamed from: b */
    public static PermissionOverwrite m8127b(PermissionOverwrite permissionOverwrite, long j, Type type, long j2, long j3, int i) {
        long j4 = (i & 1) != 0 ? permissionOverwrite.id : j;
        Type type2 = (i & 2) != 0 ? permissionOverwrite.type : null;
        long j5 = (i & 4) != 0 ? permissionOverwrite.allow : j2;
        long j6 = (i & 8) != 0 ? permissionOverwrite.deny : j3;
        Intrinsics3.checkNotNullParameter(type2, "type");
        return new PermissionOverwrite(j4, type2, j5, j6);
    }

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final long getAllow() {
        return this.allow;
    }

    /* renamed from: d, reason: from getter */
    public final long getDeny() {
        return this.deny;
    }

    /* renamed from: e */
    public final long m8131e() {
        return this.id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionOverwrite)) {
            return false;
        }
        PermissionOverwrite permissionOverwrite = (PermissionOverwrite) other;
        return this.id == permissionOverwrite.id && Intrinsics3.areEqual(this.type, permissionOverwrite.type) && this.allow == permissionOverwrite.allow && this.deny == permissionOverwrite.deny;
    }

    /* renamed from: f, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Type type = this.type;
        int iHashCode = type != null ? type.hashCode() : 0;
        long j2 = this.allow;
        int i2 = (((i + iHashCode) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.deny;
        return i2 + ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("PermissionOverwrite(id=");
        sbM833U.append(this.id);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", allow=");
        sbM833U.append(this.allow);
        sbM833U.append(", deny=");
        return outline.m815C(sbM833U, this.deny, ")");
    }
}
