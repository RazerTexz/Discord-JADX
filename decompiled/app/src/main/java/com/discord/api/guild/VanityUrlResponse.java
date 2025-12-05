package com.discord.api.guild;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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
        StringBuilder sbM833U = outline.m833U("VanityUrlResponse(code=");
        sbM833U.append(this.code);
        sbM833U.append(", uses=");
        return outline.m814B(sbM833U, this.uses, ")");
    }
}
