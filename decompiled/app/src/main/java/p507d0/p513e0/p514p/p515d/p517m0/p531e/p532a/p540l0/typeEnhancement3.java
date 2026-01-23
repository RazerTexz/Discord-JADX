package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.Annotations4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.c, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement3<T> {

    /* JADX INFO: renamed from: a */
    public final T f23443a;

    /* JADX INFO: renamed from: b */
    public final Annotations4 f23444b;

    public typeEnhancement3(T t, Annotations4 annotations4) {
        this.f23443a = t;
        this.f23444b = annotations4;
    }

    public final T component1() {
        return this.f23443a;
    }

    public final Annotations4 component2() {
        return this.f23444b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof typeEnhancement3)) {
            return false;
        }
        typeEnhancement3 typeenhancement3 = (typeEnhancement3) obj;
        return Intrinsics3.areEqual(this.f23443a, typeenhancement3.f23443a) && Intrinsics3.areEqual(this.f23444b, typeenhancement3.f23444b);
    }

    public int hashCode() {
        T t = this.f23443a;
        int iHashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations4 annotations4 = this.f23444b;
        return iHashCode + (annotations4 != null ? annotations4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("EnhancementResult(result=");
        sbM833U.append(this.f23443a);
        sbM833U.append(", enhancementAnnotations=");
        sbM833U.append(this.f23444b);
        sbM833U.append(')');
        return sbM833U.toString();
    }
}
