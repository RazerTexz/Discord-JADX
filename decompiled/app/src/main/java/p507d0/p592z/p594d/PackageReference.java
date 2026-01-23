package p507d0.p592z.p594d;

/* JADX INFO: renamed from: d0.z.d.u, reason: use source file name */
/* JADX INFO: compiled from: PackageReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackageReference implements ClassBasedDeclarationContainer {

    /* JADX INFO: renamed from: j */
    public final Class<?> f25292j;

    public PackageReference(Class<?> cls, String str) {
        Intrinsics3.checkNotNullParameter(cls, "jClass");
        Intrinsics3.checkNotNullParameter(str, "moduleName");
        this.f25292j = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackageReference) && Intrinsics3.areEqual(getJClass(), ((PackageReference) obj).getJClass());
    }

    @Override // p507d0.p592z.p594d.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.f25292j;
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
