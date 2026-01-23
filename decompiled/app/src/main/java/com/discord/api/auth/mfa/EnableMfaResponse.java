package com.discord.api.auth.mfa;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: EnableMfaResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class EnableMfaResponse {
    private final List<BackupCode> backupCodes;
    private final String token;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EnableMfaResponse)) {
            return false;
        }
        EnableMfaResponse enableMfaResponse = (EnableMfaResponse) other;
        return Intrinsics3.areEqual(this.token, enableMfaResponse.token) && Intrinsics3.areEqual(this.backupCodes, enableMfaResponse.backupCodes);
    }

    public int hashCode() {
        String str = this.token;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<BackupCode> list = this.backupCodes;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EnableMfaResponse(token=");
        sbM833U.append(this.token);
        sbM833U.append(", backupCodes=");
        return outline.m824L(sbM833U, this.backupCodes, ")");
    }
}
