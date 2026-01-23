package com.discord.api.handoff;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: HandoffToken.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class HandoffToken {
    private final String handoffToken;

    /* JADX INFO: renamed from: a, reason: from getter */
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
        return outline.m822J(outline.m833U("HandoffToken(handoffToken="), this.handoffToken, ")");
    }
}
