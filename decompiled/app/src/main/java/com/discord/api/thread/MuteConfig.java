package com.discord.api.thread;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: MuteConfig.kt */
/* loaded from: classes.dex */
public final /* data */ class MuteConfig {
    private final String endTime;

    /* renamed from: a, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof MuteConfig) && Intrinsics3.areEqual(this.endTime, ((MuteConfig) other).endTime);
        }
        return true;
    }

    public int hashCode() {
        String str = this.endTime;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("MuteConfig(endTime="), this.endTime, ")");
    }
}
