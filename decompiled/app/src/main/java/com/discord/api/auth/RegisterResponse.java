package com.discord.api.auth;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: RegisterResponse.kt */
/* loaded from: classes.dex */
public final /* data */ class RegisterResponse {
    private final String token;

    /* renamed from: a, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RegisterResponse) && Intrinsics3.areEqual(this.token, ((RegisterResponse) other).token);
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
        return outline.J(outline.U("RegisterResponse(token="), this.token, ")");
    }
}
