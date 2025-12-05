package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;

/* compiled from: MediaPeriodId.java */
/* renamed from: b.i.a.c.a3.y, reason: use source file name */
/* loaded from: classes3.dex */
public class MediaPeriodId {

    /* renamed from: a */
    public final Object f5732a;

    /* renamed from: b */
    public final int f5733b;

    /* renamed from: c */
    public final int f5734c;

    /* renamed from: d */
    public final long f5735d;

    /* renamed from: e */
    public final int f5736e;

    public MediaPeriodId(MediaPeriodId mediaPeriodId) {
        this.f5732a = mediaPeriodId.f5732a;
        this.f5733b = mediaPeriodId.f5733b;
        this.f5734c = mediaPeriodId.f5734c;
        this.f5735d = mediaPeriodId.f5735d;
        this.f5736e = mediaPeriodId.f5736e;
    }

    /* renamed from: a */
    public boolean m2593a() {
        return this.f5733b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaPeriodId)) {
            return false;
        }
        MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
        return this.f5732a.equals(mediaPeriodId.f5732a) && this.f5733b == mediaPeriodId.f5733b && this.f5734c == mediaPeriodId.f5734c && this.f5735d == mediaPeriodId.f5735d && this.f5736e == mediaPeriodId.f5736e;
    }

    public int hashCode() {
        return ((((((((this.f5732a.hashCode() + 527) * 31) + this.f5733b) * 31) + this.f5734c) * 31) + ((int) this.f5735d)) * 31) + this.f5736e;
    }

    public MediaPeriodId(Object obj) {
        this.f5732a = obj;
        this.f5733b = -1;
        this.f5734c = -1;
        this.f5735d = -1L;
        this.f5736e = -1;
    }

    public MediaPeriodId(Object obj, int i, int i2, long j) {
        this.f5732a = obj;
        this.f5733b = i;
        this.f5734c = i2;
        this.f5735d = j;
        this.f5736e = -1;
    }

    public MediaPeriodId(Object obj, int i, int i2, long j, int i3) {
        this.f5732a = obj;
        this.f5733b = i;
        this.f5734c = i2;
        this.f5735d = j;
        this.f5736e = i3;
    }

    public MediaPeriodId(Object obj, long j, int i) {
        this.f5732a = obj;
        this.f5733b = -1;
        this.f5734c = -1;
        this.f5735d = j;
        this.f5736e = i;
    }
}
