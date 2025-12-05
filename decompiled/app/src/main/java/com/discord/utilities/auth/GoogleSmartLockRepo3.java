package com.discord.utilities.auth;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: GoogleSmartLockRepo.kt */
/* renamed from: com.discord.utilities.auth.SmartLockSignInAttempt, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class GoogleSmartLockRepo3 {
    private final boolean signedInWithoutError;
    private final boolean usedAutomaticCredentials;

    public GoogleSmartLockRepo3() {
        this(false, false, 3, null);
    }

    public GoogleSmartLockRepo3(boolean z2, boolean z3) {
        this.usedAutomaticCredentials = z2;
        this.signedInWithoutError = z3;
    }

    public static /* synthetic */ GoogleSmartLockRepo3 copy$default(GoogleSmartLockRepo3 googleSmartLockRepo3, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = googleSmartLockRepo3.usedAutomaticCredentials;
        }
        if ((i & 2) != 0) {
            z3 = googleSmartLockRepo3.signedInWithoutError;
        }
        return googleSmartLockRepo3.copy(z2, z3);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final GoogleSmartLockRepo3 copy(boolean usedAutomaticCredentials, boolean signedInWithoutError) {
        return new GoogleSmartLockRepo3(usedAutomaticCredentials, signedInWithoutError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GoogleSmartLockRepo3)) {
            return false;
        }
        GoogleSmartLockRepo3 googleSmartLockRepo3 = (GoogleSmartLockRepo3) other;
        return this.usedAutomaticCredentials == googleSmartLockRepo3.usedAutomaticCredentials && this.signedInWithoutError == googleSmartLockRepo3.signedInWithoutError;
    }

    public final boolean getSignedInWithoutError() {
        return this.signedInWithoutError;
    }

    public final boolean getUsedAutomaticCredentials() {
        return this.usedAutomaticCredentials;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z2 = this.usedAutomaticCredentials;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.signedInWithoutError;
        return i + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("SmartLockSignInAttempt(usedAutomaticCredentials=");
        sbM833U.append(this.usedAutomaticCredentials);
        sbM833U.append(", signedInWithoutError=");
        return outline.m827O(sbM833U, this.signedInWithoutError, ")");
    }

    public /* synthetic */ GoogleSmartLockRepo3(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? true : z3);
    }
}
