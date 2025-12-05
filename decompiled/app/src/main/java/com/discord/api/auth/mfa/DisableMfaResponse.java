package com.discord.api.auth.mfa;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DisableMfaResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class DisableMfaResponse {
    private final String token;

    /* renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof DisableMfaResponse) && Intrinsics3.areEqual(this.token, ((DisableMfaResponse) other).token);
        }
        return true;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("DisableMfaResponse(token="), this.token, ")");
    }
}
