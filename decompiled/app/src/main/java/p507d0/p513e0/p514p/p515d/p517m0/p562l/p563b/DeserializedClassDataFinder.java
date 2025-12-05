package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.PackageFragmentProvider2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: DeserializedClassDataFinder.kt */
/* renamed from: d0.e0.p.d.m0.l.b.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class DeserializedClassDataFinder implements ClassDataFinder {

    /* renamed from: a */
    public final PackageFragmentProvider f24668a;

    public DeserializedClassDataFinder(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics3.checkNotNullParameter(packageFragmentProvider, "packageFragmentProvider");
        this.f24668a = packageFragmentProvider;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        ClassData classDataFindClassData;
        Intrinsics3.checkNotNullParameter(classId, "classId");
        PackageFragmentProvider packageFragmentProvider = this.f24668a;
        FqName packageFqName = classId.getPackageFqName();
        Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        for (PackageFragmentDescriptor packageFragmentDescriptor : PackageFragmentProvider2.packageFragments(packageFragmentProvider, packageFqName)) {
            if ((packageFragmentDescriptor instanceof DeserializedPackageFragment) && (classDataFindClassData = ((DeserializedPackageFragment) packageFragmentDescriptor).getClassDataFinder().findClassData(classId)) != null) {
                return classDataFindClassData;
            }
        }
        return null;
    }
}
