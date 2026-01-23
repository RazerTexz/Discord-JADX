package com.discord.api.utcdatetime;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: UtcDateTime.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UtcDateTime implements Comparable<UtcDateTime> {
    private final long dateTimeMillis;

    public UtcDateTime(long j) {
        this.dateTimeMillis = j;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UtcDateTime utcDateTime) {
        return m8322f(utcDateTime);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UtcDateTime) && this.dateTimeMillis == ((UtcDateTime) other).dateTimeMillis;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public int m8322f(UtcDateTime other) {
        Intrinsics3.checkNotNullParameter(other, "other");
        return (this.dateTimeMillis > other.dateTimeMillis ? 1 : (this.dateTimeMillis == other.dateTimeMillis ? 0 : -1));
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final long getDateTimeMillis() {
        return this.dateTimeMillis;
    }

    public int hashCode() {
        long j = this.dateTimeMillis;
        return (int) (j ^ (j >>> 32));
    }

    public String toString() {
        return outline.m815C(outline.m833U("UtcDateTime(dateTimeMillis="), this.dateTimeMillis, ")");
    }
}
