package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.Lazy4;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaPackageFragment;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.resolvers2;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11588u;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.LockBasedStorageManager;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.storage;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.collections;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaPackageFragmentProvider implements PackageFragmentProvider3 {

    /* JADX INFO: renamed from: a */
    public final context4 f23308a;

    /* JADX INFO: renamed from: b */
    public final storage<FqName, LazyJavaPackageFragment> f23309b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.f$a */
    /* JADX INFO: compiled from: LazyJavaPackageFragmentProvider.kt */
    public static final class a extends Lambda implements Function0<LazyJavaPackageFragment> {
        public final /* synthetic */ InterfaceC11588u $jPackage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InterfaceC11588u interfaceC11588u) {
            super(0);
            this.$jPackage = interfaceC11588u;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ LazyJavaPackageFragment invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LazyJavaPackageFragment invoke() {
            return new LazyJavaPackageFragment(LazyJavaPackageFragmentProvider.access$getC$p(LazyJavaPackageFragmentProvider.this), this.$jPackage);
        }
    }

    public LazyJavaPackageFragmentProvider(context2 context2Var) {
        Intrinsics3.checkNotNullParameter(context2Var, "components");
        context4 context4Var = new context4(context2Var, resolvers2.a.f23321a, Lazy4.lazyOf(null));
        this.f23308a = context4Var;
        this.f23309b = context4Var.getStorageManager().createCacheWithNotNullValues();
    }

    public static final /* synthetic */ context4 access$getC$p(LazyJavaPackageFragmentProvider lazyJavaPackageFragmentProvider) {
        return lazyJavaPackageFragmentProvider.f23308a;
    }

    /* JADX INFO: renamed from: a */
    public final LazyJavaPackageFragment m9461a(FqName fqName) {
        InterfaceC11588u interfaceC11588uFindPackage = this.f23308a.getComponents().getFinder().findPackage(fqName);
        if (interfaceC11588uFindPackage == null) {
            return null;
        }
        return (LazyJavaPackageFragment) ((LockBasedStorageManager.d) this.f23309b).computeIfAbsent(fqName, new a(interfaceC11588uFindPackage));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        collections.addIfNotNull(collection, m9461a(fqName));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public List<LazyJavaPackageFragment> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        return Collections2.listOfNotNull(m9461a(fqName));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public /* bridge */ /* synthetic */ Collection getSubPackagesOf(FqName fqName, Function1 function1) {
        return getSubPackagesOf(fqName, (Function1<? super Name, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public List<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        LazyJavaPackageFragment lazyJavaPackageFragmentM9461a = m9461a(fqName);
        List<FqName> subPackageFqNames$descriptors_jvm = lazyJavaPackageFragmentM9461a == null ? null : lazyJavaPackageFragmentM9461a.getSubPackageFqNames$descriptors_jvm();
        return subPackageFqNames$descriptors_jvm != null ? subPackageFqNames$descriptors_jvm : Collections2.emptyList();
    }
}
