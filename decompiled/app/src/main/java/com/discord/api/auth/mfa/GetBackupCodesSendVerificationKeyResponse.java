package com.discord.api.auth.mfa;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: GetBackupCodesSendVerificationKeyResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class GetBackupCodesSendVerificationKeyResponse {
    private final String nonce;
    private final String regenerateNonce;

    /* renamed from: a, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: b, reason: from getter */
    public final String getRegenerateNonce() {
        return this.regenerateNonce;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetBackupCodesSendVerificationKeyResponse)) {
            return false;
        }
        GetBackupCodesSendVerificationKeyResponse getBackupCodesSendVerificationKeyResponse = (GetBackupCodesSendVerificationKeyResponse) other;
        return Intrinsics3.areEqual(this.nonce, getBackupCodesSendVerificationKeyResponse.nonce) && Intrinsics3.areEqual(this.regenerateNonce, getBackupCodesSendVerificationKeyResponse.regenerateNonce);
    }

    public int hashCode() {
        String str = this.nonce;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.regenerateNonce;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("GetBackupCodesSendVerificationKeyResponse(nonce=");
        sbU.append(this.nonce);
        sbU.append(", regenerateNonce=");
        return outline.J(sbU, this.regenerateNonce, ")");
    }
}
