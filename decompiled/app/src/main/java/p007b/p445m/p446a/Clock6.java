package p007b.p445m.p446a;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Clock.kt */
/* renamed from: b.m.a.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class Clock6 {

    /* renamed from: a */
    public final long f13644a;

    /* renamed from: b */
    public final Long f13645b;

    public Clock6(long j, Long l) {
        this.f13644a = j;
        this.f13645b = l;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Clock6) {
                Clock6 clock6 = (Clock6) obj;
                if (!(this.f13644a == clock6.f13644a) || !Intrinsics3.areEqual(this.f13645b, clock6.f13645b)) {
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j = this.f13644a;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        Long l = this.f13645b;
        return i + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("KronosTime(posixTimeMs=");
        sbM833U.append(this.f13644a);
        sbM833U.append(", timeSinceLastNtpSyncMs=");
        return outline.m819G(sbM833U, this.f13645b, ")");
    }
}
