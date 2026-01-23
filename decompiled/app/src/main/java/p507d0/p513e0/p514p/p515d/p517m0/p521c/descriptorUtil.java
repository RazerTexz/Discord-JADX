package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation2;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.s, reason: use source file name */
/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class descriptorUtil {
    public static final ClassDescriptor resolveClassByFqName(ModuleDescriptor2 moduleDescriptor2, FqName fqName, LookupLocation2 lookupLocation2) {
        MemberScope3 unsubstitutedInnerClassesScope;
        ClassifierDescriptor contributedClassifier;
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(lookupLocation2, "lookupLocation");
        if (fqName.isRoot()) {
            return null;
        }
        FqName fqNameParent = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent, "fqName.parent()");
        MemberScope3 memberScope = moduleDescriptor2.getPackage(fqNameParent).getMemberScope();
        Name nameShortName = fqName.shortName();
        Intrinsics3.checkNotNullExpressionValue(nameShortName, "fqName.shortName()");
        ClassifierDescriptor contributedClassifier2 = memberScope.getContributedClassifier(nameShortName, lookupLocation2);
        ClassDescriptor classDescriptor = contributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier2 : null;
        if (classDescriptor != null) {
            return classDescriptor;
        }
        FqName fqNameParent2 = fqName.parent();
        Intrinsics3.checkNotNullExpressionValue(fqNameParent2, "fqName.parent()");
        ClassDescriptor classDescriptorResolveClassByFqName = resolveClassByFqName(moduleDescriptor2, fqNameParent2, lookupLocation2);
        if (classDescriptorResolveClassByFqName == null || (unsubstitutedInnerClassesScope = classDescriptorResolveClassByFqName.getUnsubstitutedInnerClassesScope()) == null) {
            contributedClassifier = null;
        } else {
            Name nameShortName2 = fqName.shortName();
            Intrinsics3.checkNotNullExpressionValue(nameShortName2, "fqName.shortName()");
            contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(nameShortName2, lookupLocation2);
        }
        if (contributedClassifier instanceof ClassDescriptor) {
            return (ClassDescriptor) contributedClassifier;
        }
        return null;
    }
}
