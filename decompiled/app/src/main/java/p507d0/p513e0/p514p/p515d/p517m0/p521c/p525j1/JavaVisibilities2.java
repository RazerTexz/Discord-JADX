package p507d0.p513e0.p514p.p515d.p517m0.p521c.p525j1;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibilities;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.j1.b, reason: use source file name */
/* JADX INFO: compiled from: JavaVisibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaVisibilities2 extends Visibility2 {

    /* JADX INFO: renamed from: c */
    public static final JavaVisibilities2 f23007c = new JavaVisibilities2();

    public JavaVisibilities2() {
        super("protected_and_package", true);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2
    public Integer compareTo(Visibility2 visibility2) {
        Intrinsics3.checkNotNullParameter(visibility2, "visibility");
        if (Intrinsics3.areEqual(this, visibility2)) {
            return 0;
        }
        if (visibility2 == Visibilities.b.f22697c) {
            return null;
        }
        return Integer.valueOf(Visibilities.f22694a.isPrivate(visibility2) ? 1 : -1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2
    public String getInternalDisplayName() {
        return "protected/*protected and package*/";
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.Visibility2
    public Visibility2 normalize() {
        return Visibilities.g.f22702c;
    }
}
