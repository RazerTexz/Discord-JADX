package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.LookupLocation3;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.ResolutionAnchorProvider2;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.MemberScope3;
import p507d0.p578f0.C12075n;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.w, reason: use source file name */
/* JADX INFO: compiled from: findClassInModule.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class findClassInModule {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.w$a */
    /* JADX INFO: compiled from: findClassInModule.kt */
    public /* synthetic */ class a extends FunctionReference implements Function1<ClassId, ClassId> {

        /* JADX INFO: renamed from: j */
        public static final a f23101j = new a();

        public a() {
            super(1);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(ClassId.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ ClassId invoke(ClassId classId) {
            return invoke2(classId);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ClassId invoke2(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "p0");
            return classId.getOuterClassId();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.w$b */
    /* JADX INFO: compiled from: findClassInModule.kt */
    public static final class b extends Lambda implements Function1<ClassId, Integer> {

        /* JADX INFO: renamed from: j */
        public static final b f23102j = new b();

        public b() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(ClassId classId) {
            Intrinsics3.checkNotNullParameter(classId, "it");
            return 0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(ClassId classId) {
            return Integer.valueOf(invoke2(classId));
        }
    }

    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor2 moduleDescriptor2, ClassId classId) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor2, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor2 moduleDescriptor2, ClassId classId) {
        ClassifierDescriptor contributedClassifier;
        LookupLocation3 lookupLocation3 = LookupLocation3.FROM_DESERIALIZATION;
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        ModuleDescriptor2 resolutionAnchorIfAny = ResolutionAnchorProvider2.getResolutionAnchorIfAny(moduleDescriptor2);
        if (resolutionAnchorIfAny == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor2.getPackage(packageFqName);
            List<Name> listPathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics3.checkNotNullExpressionValue(listPathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope3 memberScope = packageViewDescriptor.getMemberScope();
            Object objFirst = _Collections.first((List<? extends Object>) listPathSegments);
            Intrinsics3.checkNotNullExpressionValue(objFirst, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((Name) objFirst, lookupLocation3);
            if (contributedClassifier == null) {
                return null;
            }
            for (Name name : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(contributedClassifier instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope3 unsubstitutedInnerClassesScope = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                ClassifierDescriptor contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(name, lookupLocation3);
                contributedClassifier = contributedClassifier2 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier2 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics3.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<Name> listPathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics3.checkNotNullExpressionValue(listPathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope3 memberScope2 = packageViewDescriptor2.getMemberScope();
            Object objFirst2 = _Collections.first((List<? extends Object>) listPathSegments2);
            Intrinsics3.checkNotNullExpressionValue(objFirst2, "segments.first()");
            ClassifierDescriptor contributedClassifier3 = memberScope2.getContributedClassifier((Name) objFirst2, lookupLocation3);
            if (contributedClassifier3 == null) {
                contributedClassifier3 = null;
                if (contributedClassifier3 == null) {
                    return contributedClassifier3;
                }
                FqName packageFqName3 = classId.getPackageFqName();
                Intrinsics3.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
                PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor2.getPackage(packageFqName3);
                List<Name> listPathSegments3 = classId.getRelativeClassName().pathSegments();
                Intrinsics3.checkNotNullExpressionValue(listPathSegments3, "classId.relativeClassName.pathSegments()");
                MemberScope3 memberScope3 = packageViewDescriptor3.getMemberScope();
                Object objFirst3 = _Collections.first((List<? extends Object>) listPathSegments3);
                Intrinsics3.checkNotNullExpressionValue(objFirst3, "segments.first()");
                contributedClassifier = memberScope3.getContributedClassifier((Name) objFirst3, lookupLocation3);
                if (contributedClassifier == null) {
                    return null;
                }
                for (Name name2 : listPathSegments3.subList(1, listPathSegments3.size())) {
                    if (!(contributedClassifier instanceof ClassDescriptor)) {
                        return null;
                    }
                    MemberScope3 unsubstitutedInnerClassesScope2 = ((ClassDescriptor) contributedClassifier).getUnsubstitutedInnerClassesScope();
                    Intrinsics3.checkNotNullExpressionValue(name2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    ClassifierDescriptor contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(name2, lookupLocation3);
                    contributedClassifier = contributedClassifier4 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier4 : null;
                    if (contributedClassifier == null) {
                        return null;
                    }
                }
            } else {
                for (Name name3 : listPathSegments2.subList(1, listPathSegments2.size())) {
                    if (contributedClassifier3 instanceof ClassDescriptor) {
                        MemberScope3 unsubstitutedInnerClassesScope3 = ((ClassDescriptor) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                        Intrinsics3.checkNotNullExpressionValue(name3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        ClassifierDescriptor contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(name3, lookupLocation3);
                        contributedClassifier3 = contributedClassifier5 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier5 : null;
                        if (contributedClassifier3 == null) {
                        }
                    }
                    contributedClassifier3 = null;
                }
                if (contributedClassifier3 == null) {
                }
            }
        }
        return contributedClassifier;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor2 moduleDescriptor2, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        Intrinsics3.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor2, classId);
        return classDescriptorFindClassAcrossModuleDependencies != null ? classDescriptorFindClassAcrossModuleDependencies : notFoundClasses.getClass(classId, _Sequences2.toList(_Sequences2.map(C12075n.generateSequence(classId, a.f23101j), b.f23102j)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor2 moduleDescriptor2, ClassId classId) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "<this>");
        Intrinsics3.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor classifierDescriptorFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor2, classId);
        if (classifierDescriptorFindClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) classifierDescriptorFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
