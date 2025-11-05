package com.discord.api.thread;

import b.d.b.a.a;
import d0.z.d.m;

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
            return (other instanceof MuteConfig) && m.areEqual(this.endTime, ((MuteConfig) other).endTime);
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
        return a.J(a.U("MuteConfig(endTime="), this.endTime, ")");
    }
}
