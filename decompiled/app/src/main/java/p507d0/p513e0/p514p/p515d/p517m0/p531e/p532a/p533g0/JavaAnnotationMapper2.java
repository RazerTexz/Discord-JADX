package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0;

import java.util.Map;
import p507d0.Tuples;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.StandardNames;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.context4;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l.LazyJavaAnnotationDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JavaAnnotationMapper.kt */
/* renamed from: d0.e0.p.d.m0.e.a.g0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class JavaAnnotationMapper2 {

    /* renamed from: a */
    public static final JavaAnnotationMapper2 f23230a = new JavaAnnotationMapper2();

    /* renamed from: b */
    public static final Name f23231b;

    /* renamed from: c */
    public static final Name f23232c;

    /* renamed from: d */
    public static final Name f23233d;

    /* renamed from: e */
    public static final Map<FqName, FqName> f23234e;

    /* renamed from: f */
    public static final Map<FqName, FqName> f23235f;

    static {
        Name nameIdentifier = Name.identifier("message");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(\"message\")");
        f23231b = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("allowedTargets");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"allowedTargets\")");
        f23232c = nameIdentifier2;
        Name nameIdentifier3 = Name.identifier("value");
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier3, "identifier(\"value\")");
        f23233d = nameIdentifier3;
        FqName fqName = StandardNames.a.f22504A;
        FqName fqName2 = JvmAnnotationNames.f23149c;
        FqName fqName3 = StandardNames.a.f22507D;
        FqName fqName4 = JvmAnnotationNames.f23150d;
        FqName fqName5 = StandardNames.a.f22508E;
        FqName fqName6 = JvmAnnotationNames.f23153g;
        FqName fqName7 = StandardNames.a.f22509F;
        FqName fqName8 = JvmAnnotationNames.f23152f;
        f23234e = Maps6.mapOf(Tuples.m10073to(fqName, fqName2), Tuples.m10073to(fqName3, fqName4), Tuples.m10073to(fqName5, fqName6), Tuples.m10073to(fqName7, fqName8));
        f23235f = Maps6.mapOf(Tuples.m10073to(fqName2, fqName), Tuples.m10073to(fqName4, fqName3), Tuples.m10073to(JvmAnnotationNames.f23151e, StandardNames.a.f22566u), Tuples.m10073to(fqName6, fqName5), Tuples.m10073to(fqName8, fqName7));
    }

    public static /* synthetic */ AnnotationDescriptor mapOrResolveJavaAnnotation$default(JavaAnnotationMapper2 javaAnnotationMapper2, InterfaceC11564a interfaceC11564a, context4 context4Var, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        return javaAnnotationMapper2.mapOrResolveJavaAnnotation(interfaceC11564a, context4Var, z2);
    }

    public final AnnotationDescriptor findMappedJavaAnnotation(FqName fqName, InterfaceC11570d interfaceC11570d, context4 context4Var) {
        InterfaceC11564a interfaceC11564aFindAnnotation;
        Intrinsics3.checkNotNullParameter(fqName, "kotlinName");
        Intrinsics3.checkNotNullParameter(interfaceC11570d, "annotationOwner");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        if (Intrinsics3.areEqual(fqName, StandardNames.a.f22566u)) {
            FqName fqName2 = JvmAnnotationNames.f23151e;
            Intrinsics3.checkNotNullExpressionValue(fqName2, "DEPRECATED_ANNOTATION");
            InterfaceC11564a interfaceC11564aFindAnnotation2 = interfaceC11570d.findAnnotation(fqName2);
            if (interfaceC11564aFindAnnotation2 != null || interfaceC11570d.isDeprecatedInJavaDoc()) {
                return new JavaAnnotationMapper4(interfaceC11564aFindAnnotation2, context4Var);
            }
        }
        FqName fqName3 = f23234e.get(fqName);
        if (fqName3 == null || (interfaceC11564aFindAnnotation = interfaceC11570d.findAnnotation(fqName3)) == null) {
            return null;
        }
        return mapOrResolveJavaAnnotation$default(this, interfaceC11564aFindAnnotation, context4Var, false, 4, null);
    }

    public final Name getDEPRECATED_ANNOTATION_MESSAGE$descriptors_jvm() {
        return f23231b;
    }

    public final Name getRETENTION_ANNOTATION_VALUE$descriptors_jvm() {
        return f23233d;
    }

    public final Name getTARGET_ANNOTATION_ALLOWED_TARGETS$descriptors_jvm() {
        return f23232c;
    }

    public final AnnotationDescriptor mapOrResolveJavaAnnotation(InterfaceC11564a interfaceC11564a, context4 context4Var, boolean z2) {
        Intrinsics3.checkNotNullParameter(interfaceC11564a, "annotation");
        Intrinsics3.checkNotNullParameter(context4Var, "c");
        ClassId classId = interfaceC11564a.getClassId();
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f23149c))) {
            return new JavaAnnotationMapper6(interfaceC11564a, context4Var);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f23150d))) {
            return new JavaAnnotationMapper5(interfaceC11564a, context4Var);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f23153g))) {
            return new JavaAnnotationMapper(context4Var, interfaceC11564a, StandardNames.a.f22508E);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f23152f))) {
            return new JavaAnnotationMapper(context4Var, interfaceC11564a, StandardNames.a.f22509F);
        }
        if (Intrinsics3.areEqual(classId, ClassId.topLevel(JvmAnnotationNames.f23151e))) {
            return null;
        }
        return new LazyJavaAnnotationDescriptor(context4Var, interfaceC11564a, z2);
    }
}
