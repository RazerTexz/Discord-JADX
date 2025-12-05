package com.discord.api.requiredaction;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UserRequiredActionUpdate.kt */
/* loaded from: classes.dex */
public final /* data */ class UserRequiredActionUpdate {
    private final String requiredAction;

    /* renamed from: a, reason: from getter */
    public final String getRequiredAction() {
        return this.requiredAction;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserRequiredActionUpdate) && Intrinsics3.areEqual(this.requiredAction, ((UserRequiredActionUpdate) other).requiredAction);
        }
        return true;
    }

    public int hashCode() {
        String str = this.requiredAction;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("UserRequiredActionUpdate(requiredAction="), this.requiredAction, ")");
    }
}
