package com.discord.api.application;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: ApplicationAsset.kt */
/* loaded from: classes.dex */
public final /* data */ class ApplicationAsset {
    private final long id;
    private final String name;
    private final int type;

    /* renamed from: a, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationAsset)) {
            return false;
        }
        ApplicationAsset applicationAsset = (ApplicationAsset) other;
        return this.id == applicationAsset.id && this.type == applicationAsset.type && Intrinsics3.areEqual(this.name, applicationAsset.name);
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.type) * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationAsset(id=");
        sbU.append(this.id);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", name=");
        return outline.J(sbU, this.name, ")");
    }
}
