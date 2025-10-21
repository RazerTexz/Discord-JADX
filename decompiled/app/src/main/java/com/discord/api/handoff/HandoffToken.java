package com.discord.api.handoff;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: HandoffToken.kt */
/* loaded from: classes.dex */
public final /* data */ class HandoffToken {
    private final String handoffToken;

    /* renamed from: a, reason: from getter */
    public final String getHandoffToken() {
        return this.handoffToken;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof HandoffToken) && Intrinsics3.areEqual(this.handoffToken, ((HandoffToken) other).handoffToken);
        }
        return true;
    }

    public int hashCode() {
        String str = this.handoffToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.J(outline.U("HandoffToken(handoffToken="), this.handoffToken, ")");
    }
}
