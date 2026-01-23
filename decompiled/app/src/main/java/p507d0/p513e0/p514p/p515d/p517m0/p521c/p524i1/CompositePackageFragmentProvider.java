package p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider2;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.j, reason: use source file name */
/* JADX INFO: compiled from: CompositePackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CompositePackageFragmentProvider implements PackageFragmentProvider3 {

    /* JADX INFO: renamed from: a */
    public final List<PackageFragmentProvider> f22886a;

    /* JADX WARN: Multi-variable type inference failed */
    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list) {
        Intrinsics3.checkNotNullParameter(list, "providers");
        this.f22886a = list;
        list.size();
        _Collections.toSet(list).size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider3
    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        Iterator<PackageFragmentProvider> it = this.f22886a.iterator();
        while (it.hasNext()) {
            PackageFragmentProvider2.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, collection);
        }
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        Iterator<PackageFragmentProvider> it = this.f22886a.iterator();
        while (it.hasNext()) {
            PackageFragmentProvider2.collectPackageFragmentsOptimizedIfPossible(it.next(), fqName, arrayList);
        }
        return _Collections.toList(arrayList);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider
    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        Iterator<PackageFragmentProvider> it = this.f22886a.iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }
}
