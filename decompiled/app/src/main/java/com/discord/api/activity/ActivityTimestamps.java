package com.discord.api.activity;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ActivityTimestamps.kt */
/* loaded from: classes.dex */
public final /* data */ class ActivityTimestamps {
    private final String end;
    private final String start;

    public ActivityTimestamps(String str, String str2) {
        this.start = str;
        this.end = str2;
    }

    /* renamed from: a */
    public final long m7560a(String number) {
        if (number == null || number.length() == 0) {
            return 0L;
        }
        try {
            long j = Long.parseLong(number);
            if (number.length() < 13) {
                j *= 1000;
            }
            return j;
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: b */
    public final long m7561b() {
        return m7560a(this.end);
    }

    /* renamed from: c */
    public final long m7562c() {
        return m7560a(this.start);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActivityTimestamps)) {
            return false;
        }
        ActivityTimestamps activityTimestamps = (ActivityTimestamps) other;
        return Intrinsics3.areEqual(this.start, activityTimestamps.start) && Intrinsics3.areEqual(this.end, activityTimestamps.end);
    }

    public int hashCode() {
        String str = this.start;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.end;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ActivityTimestamps(start=");
        sbM833U.append(this.start);
        sbM833U.append(", end=");
        return outline.m822J(sbM833U, this.end, ")");
    }
}
