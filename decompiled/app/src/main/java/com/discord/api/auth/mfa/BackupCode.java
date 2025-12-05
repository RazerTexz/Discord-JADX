package com.discord.api.auth.mfa;

import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: BackupCode.kt */
/* loaded from: classes.dex */
public final /* data */ class BackupCode {
    private final String code;
    private final boolean consumed;

    /* renamed from: a, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getConsumed() {
        return this.consumed;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BackupCode)) {
            return false;
        }
        BackupCode backupCode = (BackupCode) other;
        return Intrinsics3.areEqual(this.code, backupCode.code) && this.consumed == backupCode.consumed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.code;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.consumed;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("BackupCode(code=");
        sbM833U.append(this.code);
        sbM833U.append(", consumed=");
        return outline.m827O(sbM833U, this.consumed, ")");
    }
}
