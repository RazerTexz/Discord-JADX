package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h0, reason: use source file name */
/* JADX INFO: compiled from: PackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PackageFragmentProvider2 {
    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider packageFragmentProvider, FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(collection, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProvider3) {
            ((PackageFragmentProvider3) packageFragmentProvider).collectPackageFragments(fqName, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }

    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }
}
