package com.discord.api.fingerprint;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: FingerprintResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class FingerprintResponse {
    private final String fingerprint;

    /* renamed from: a, reason: from getter */
    public final String getFingerprint() {
        return this.fingerprint;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof FingerprintResponse) && Intrinsics3.areEqual(this.fingerprint, ((FingerprintResponse) other).fingerprint);
        }
        return true;
    }

    public int hashCode() {
        String str = this.fingerprint;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("FingerprintResponse(fingerprint="), this.fingerprint, ")");
    }
}
