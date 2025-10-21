package com.discord.api.utcdatetime;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;

/* compiled from: UtcDateTime.kt */
/* loaded from: classes.dex */
public final /* data */ class UtcDateTime implements Comparable<UtcDateTime> {
    private final long dateTimeMillis;

    public UtcDateTime(long j) {
        this.dateTimeMillis = j;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UtcDateTime utcDateTime) {
        return f(utcDateTime);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UtcDateTime) && this.dateTimeMillis == ((UtcDateTime) other).dateTimeMillis;
        }
        return true;
    }

    public int f(UtcDateTime other) {
        Intrinsics3.checkNotNullParameter(other, "other");
        return (this.dateTimeMillis > other.dateTimeMillis ? 1 : (this.dateTimeMillis == other.dateTimeMillis ? 0 : -1));
    }

    /* renamed from: g, reason: from getter */
    public final long getDateTimeMillis() {
        return this.dateTimeMillis;
    }

    public int hashCode() {
        long j = this.dateTimeMillis;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return outline.C(outline.U("UtcDateTime(dateTimeMillis="), this.dateTimeMillis, ")");
    }
}
