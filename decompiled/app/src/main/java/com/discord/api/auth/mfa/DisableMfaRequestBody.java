package com.discord.api.auth.mfa;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DisableMfaRequestBody.kt */
/* loaded from: classes.dex */
public final /* data */ class DisableMfaRequestBody {
    private final String code;

    public DisableMfaRequestBody(String str) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
        this.code = str;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaRequestBody) && Intrinsics3.areEqual(this.code, ((DisableMfaRequestBody) other).code);
        }
        return true;
    }

    public int hashCode() {
        String str = this.code;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("DisableMfaRequestBody(code="), this.code, ")");
    }
}
