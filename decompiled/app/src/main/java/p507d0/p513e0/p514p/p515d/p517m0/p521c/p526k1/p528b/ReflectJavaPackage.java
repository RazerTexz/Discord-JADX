package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.u, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaPackage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaPackage extends ReflectJavaElement implements InterfaceC11588u {

    /* JADX INFO: renamed from: a */
    public final FqName f23062a;

    public ReflectJavaPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        this.f23062a = fqName;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaPackage) && Intrinsics3.areEqual(getFqName(), ((ReflectJavaPackage) obj).getFqName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public Collection<InterfaceC11574g> getClasses(Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        return Collections2.emptyList();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public FqName getFqName() {
        return this.f23062a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u
    public Collection<InterfaceC11588u> getSubPackages() {
        return Collections2.emptyList();
    }

    public int hashCode() {
        return getFqName().hashCode();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public String toString() {
        return ReflectJavaPackage.class.getName() + ": " + getFqName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public List<InterfaceC11564a> getAnnotations() {
        return Collections2.emptyList();
    }
}
