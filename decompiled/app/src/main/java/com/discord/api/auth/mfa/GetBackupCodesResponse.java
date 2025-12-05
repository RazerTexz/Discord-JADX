package com.discord.api.auth.mfa;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GetBackupCodesResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class GetBackupCodesResponse {
    private final List<BackupCode> backupCodes;

    /* renamed from: a */
    public final List<BackupCode> m7590a() {
        return this.backupCodes;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GetBackupCodesResponse) && Intrinsics3.areEqual(this.backupCodes, ((GetBackupCodesResponse) other).backupCodes);
        }
        return true;
    }

    public int hashCode() {
        List<BackupCode> list = this.backupCodes;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m824L(outline.m833U("GetBackupCodesResponse(backupCodes="), this.backupCodes, ")");
    }
}
