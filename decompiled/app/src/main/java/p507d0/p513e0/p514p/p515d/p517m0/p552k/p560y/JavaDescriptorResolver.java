package p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.ClassifierDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.JavaResolverCache;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.LazyJavaPackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaPackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.EnumC11569c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11574g;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.y.b, reason: use source file name */
/* JADX INFO: compiled from: JavaDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaDescriptorResolver {

    /* JADX INFO: renamed from: a */
    public final LazyJavaPackageFragmentProvider f24461a;

    /* JADX INFO: renamed from: b */
    public final JavaResolverCache f24462b;

    public JavaDescriptorResolver(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider, JavaResolverCache javaResolverCache) {
        Intrinsics3.checkNotNullParameter(lazyJavaPackageFragmentProvider, "packageFragmentProvider");
        Intrinsics3.checkNotNullParameter(javaResolverCache, "javaResolverCache");
        this.f24461a = lazyJavaPackageFragmentProvider;
        this.f24462b = javaResolverCache;
    }

    public final LazyJavaPackageFragmentProvider getPackageFragmentProvider() {
        return this.f24461a;
    }

    public final ClassDescriptor resolveClass(InterfaceC11574g interfaceC11574g) {
        Intrinsics3.checkNotNullParameter(interfaceC11574g, "javaClass");
        FqName fqName = interfaceC11574g.getFqName();
        if (fqName != null && interfaceC11574g.getLightClassOriginKind() == EnumC11569c0.SOURCE) {
            return ((JavaResolverCache.a) this.f24462b).getClassResolvedFromSource(fqName);
        }
        InterfaceC11574g outerClass = interfaceC11574g.getOuterClass();
        if (outerClass != null) {
            ClassDescriptor classDescriptorResolveClass = resolveClass(outerClass);
            MemberScope3 unsubstitutedInnerClassesScope = classDescriptorResolveClass == null ? null : classDescriptorResolveClass.getUnsubstitutedInnerClassesScope();
            ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope == null ? null : unsubstitutedInnerClassesScope.getContributedClassifier(interfaceC11574g.getName(), LookupLocation3.FROM_JAVA_LOADER);
            if (contributedClassifier instanceof ClassDescriptor) {
                return (ClassDescriptor) contributedClassifier;
            }
            return null;
        }
        if (fqName == null) {
            return null;
        }
        LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider = this.f24461a;
        FqName fqNameParent = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "fqName.parent()");
        LazyJavaPackageFragment lazyJavaPackageFragment = (LazyJavaPackageFragment) _Collections.firstOrNull((List) lazyJavaPackageFragmentProvider.getPackageFragments(fqNameParent));
        if (lazyJavaPackageFragment == null) {
            return null;
        }
        return lazyJavaPackageFragment.findClassifierByJavaClass$descriptors_jvm(interfaceC11574g);
    }
}
