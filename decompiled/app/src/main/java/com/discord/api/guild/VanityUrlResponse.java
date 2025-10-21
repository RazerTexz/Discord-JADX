package com.discord.api.guild;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;

/* compiled from: VanityUrlResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class VanityUrlResponse {
    private final String code;
    private final int uses;

    /* renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final int getUses() {
        return this.uses;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VanityUrlResponse)) {
            return false;
        }
        VanityUrlResponse vanityUrlResponse = (VanityUrlResponse) other;
        return Intrinsics3.areEqual(this.code, vanityUrlResponse.code) && this.uses == vanityUrlResponse.uses;
    }

    public int hashCode() {
        String str = this.code;
        return ((str != null ? str.hashCode() : 0) * 31) + this.uses;
    }

    public String toString() {
        StringBuilder sbU = outline.U("VanityUrlResponse(code=");
        sbU.append(this.code);
        sbU.append(", uses=");
        return outline.B(sbU, this.uses, ")");
    }
}
