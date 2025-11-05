package com.discord.api.auth.mfa;

import d0.z.d.m;

/* compiled from: GetBackupCodesVerificationRequestBody.kt */
/* loaded from: classes.dex */
public final class GetBackupCodesVerificationRequestBody {
    private final String key;
    private final String nonce;
    private final boolean regenerate;

    public GetBackupCodesVerificationRequestBody(String str, String str2, boolean z2) {
        m.checkNotNullParameter(str, "key");
        m.checkNotNullParameter(str2, "nonce");
        this.key = str;
        this.nonce = str2;
        this.regenerate = z2;
    }
}
