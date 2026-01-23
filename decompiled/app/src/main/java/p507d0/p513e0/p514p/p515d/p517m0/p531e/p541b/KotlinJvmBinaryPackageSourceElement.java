package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaPackageFragment;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.q, reason: use source file name */
/* JADX INFO: compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinJvmBinaryPackageSourceElement implements SourceElement {

    /* JADX INFO: renamed from: b */
    public final LazyJavaPackageFragment f23631b;

    public KotlinJvmBinaryPackageSourceElement(LazyJavaPackageFragment lazyJavaPackageFragment) {
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragment, "packageFragment");
        this.f23631b = lazyJavaPackageFragment;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        Intrinsics3.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    public String toString() {
        return this.f23631b + ": " + this.f23631b.getBinaryClasses$descriptors_jvm().keySet();
    }
}
