package p007b.p225i.p361c.p368l;

/* compiled from: CycleDetector.java */
/* renamed from: b.i.c.l.n, reason: use source file name */
/* loaded from: classes3.dex */
public class CycleDetector3 {

    /* renamed from: a */
    public final Class<?> f12199a;

    /* renamed from: b */
    public final boolean f12200b;

    public CycleDetector3(Class cls, boolean z2, CycleDetector cycleDetector) {
        this.f12199a = cls;
        this.f12200b = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CycleDetector3)) {
            return false;
        }
        CycleDetector3 cycleDetector3 = (CycleDetector3) obj;
        return cycleDetector3.f12199a.equals(this.f12199a) && cycleDetector3.f12200b == this.f12200b;
    }

    public int hashCode() {
        return ((this.f12199a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f12200b).hashCode();
    }
}
