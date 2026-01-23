package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.c.x2.u, reason: use source file name */
/* JADX INFO: compiled from: SeekPoint.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SeekPoint {

    /* JADX INFO: renamed from: a */
    public static final SeekPoint f8997a = new SeekPoint(0, 0);

    /* JADX INFO: renamed from: b */
    public final long f8998b;

    /* JADX INFO: renamed from: c */
    public final long f8999c;

    public SeekPoint(long j, long j2) {
        this.f8998b = j;
        this.f8999c = j2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekPoint.class != obj.getClass()) {
            return false;
        }
        SeekPoint seekPoint = (SeekPoint) obj;
        return this.f8998b == seekPoint.f8998b && this.f8999c == seekPoint.f8999c;
    }

    public int hashCode() {
        return (((int) this.f8998b) * 31) + ((int) this.f8999c);
    }

    public String toString() {
        long j = this.f8998b;
        return outline.m815C(outline.m830R(60, "[timeUs=", j, ", position="), this.f8999c, "]");
    }
}
