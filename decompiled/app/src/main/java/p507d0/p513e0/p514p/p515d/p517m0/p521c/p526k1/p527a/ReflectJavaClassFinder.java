package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p527a;

import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaClass;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b.ReflectJavaPackage;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.d, reason: use source file name */
/* JADX INFO: compiled from: ReflectJavaClassFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ReflectJavaClassFinder implements JavaClassFinder {

    /* JADX INFO: renamed from: a */
    public final ClassLoader f23014a;

    public ReflectJavaClassFinder(ClassLoader classLoader) {
        Intrinsics3.checkNotNullParameter(classLoader, "classLoader");
        this.f23014a = classLoader;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder
    public InterfaceC11574g findClass(JavaClassFinder.a aVar) {
        Intrinsics3.checkNotNullParameter(aVar, "request");
        ClassId classId = aVar.getClassId();
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "classId.relativeClassName.asString()");
        String strReplace$default = StringsJVM.replace$default(strAsString, '.', '$', false, 4, (Object) null);
        if (!packageFqName.isRoot()) {
            strReplace$default = packageFqName.asString() + '.' + strReplace$default;
        }
        Class<?> clsTryLoadClass = ReflectJavaClassFinder2.tryLoadClass(this.f23014a, strReplace$default);
        if (clsTryLoadClass != null) {
            return new ReflectJavaClass(clsTryLoadClass);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder
    public InterfaceC11588u findPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return new ReflectJavaPackage(fqName);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JavaClassFinder
    public Set<String> knownClassNamesInPackage(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "packageFqName");
        return null;
    }
}
