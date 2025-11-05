package d0.e0.p.d.m0.c;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: findClassInModule.kt */
/* loaded from: classes3.dex */
public final class w {

    /* compiled from: findClassInModule.kt */
    public /* synthetic */ class a extends d0.z.d.j implements Function1<d0.e0.p.d.m0.g.a, d0.e0.p.d.m0.g.a> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // d0.z.d.d, kotlin.reflect.KCallable
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // d0.z.d.d
        public final KDeclarationContainer getOwner() {
            return d0.z.d.a0.getOrCreateKotlinClass(d0.e0.p.d.m0.g.a.class);
        }

        @Override // d0.z.d.d
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.a invoke(d0.e0.p.d.m0.g.a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.g.a invoke2(d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "p0");
            return aVar.getOuterClassId();
        }
    }

    /* compiled from: findClassInModule.kt */
    public static final class b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.a, Integer> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "it");
            return 0;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(d0.e0.p.d.m0.g.a aVar) {
            return Integer.valueOf(invoke2(aVar));
        }
    }

    public static final e findClassAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        h hVarFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(c0Var, aVar);
        if (hVarFindClassifierAcrossModuleDependencies instanceof e) {
            return (e) hVarFindClassifierAcrossModuleDependencies;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h findClassifierAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        h contributedClassifier;
        d0.e0.p.d.m0.d.b.d dVar = d0.e0.p.d.m0.d.b.d.FROM_DESERIALIZATION;
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        c0 resolutionAnchorIfAny = d0.e0.p.d.m0.k.r.getResolutionAnchorIfAny(c0Var);
        if (resolutionAnchorIfAny == null) {
            d0.e0.p.d.m0.g.b packageFqName = aVar.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            j0 j0Var = c0Var.getPackage(packageFqName);
            List<d0.e0.p.d.m0.g.e> listPathSegments = aVar.getRelativeClassName().pathSegments();
            d0.z.d.m.checkNotNullExpressionValue(listPathSegments, "classId.relativeClassName.pathSegments()");
            d0.e0.p.d.m0.k.a0.i memberScope = j0Var.getMemberScope();
            Object objFirst = d0.t.u.first((List<? extends Object>) listPathSegments);
            d0.z.d.m.checkNotNullExpressionValue(objFirst, "segments.first()");
            contributedClassifier = memberScope.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst, dVar);
            if (contributedClassifier == null) {
                return null;
            }
            for (d0.e0.p.d.m0.g.e eVar : listPathSegments.subList(1, listPathSegments.size())) {
                if (!(contributedClassifier instanceof e)) {
                    return null;
                }
                d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope = ((e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                d0.z.d.m.checkNotNullExpressionValue(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
                h contributedClassifier2 = unsubstitutedInnerClassesScope.getContributedClassifier(eVar, dVar);
                contributedClassifier = contributedClassifier2 instanceof e ? (e) contributedClassifier2 : null;
                if (contributedClassifier == null) {
                    return null;
                }
            }
        } else {
            d0.e0.p.d.m0.g.b packageFqName2 = aVar.getPackageFqName();
            d0.z.d.m.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            j0 j0Var2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<d0.e0.p.d.m0.g.e> listPathSegments2 = aVar.getRelativeClassName().pathSegments();
            d0.z.d.m.checkNotNullExpressionValue(listPathSegments2, "classId.relativeClassName.pathSegments()");
            d0.e0.p.d.m0.k.a0.i memberScope2 = j0Var2.getMemberScope();
            Object objFirst2 = d0.t.u.first((List<? extends Object>) listPathSegments2);
            d0.z.d.m.checkNotNullExpressionValue(objFirst2, "segments.first()");
            h contributedClassifier3 = memberScope2.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst2, dVar);
            if (contributedClassifier3 == null) {
                contributedClassifier3 = null;
                if (contributedClassifier3 == null) {
                    return contributedClassifier3;
                }
                d0.e0.p.d.m0.g.b packageFqName3 = aVar.getPackageFqName();
                d0.z.d.m.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
                j0 j0Var3 = c0Var.getPackage(packageFqName3);
                List<d0.e0.p.d.m0.g.e> listPathSegments3 = aVar.getRelativeClassName().pathSegments();
                d0.z.d.m.checkNotNullExpressionValue(listPathSegments3, "classId.relativeClassName.pathSegments()");
                d0.e0.p.d.m0.k.a0.i memberScope3 = j0Var3.getMemberScope();
                Object objFirst3 = d0.t.u.first((List<? extends Object>) listPathSegments3);
                d0.z.d.m.checkNotNullExpressionValue(objFirst3, "segments.first()");
                contributedClassifier = memberScope3.getContributedClassifier((d0.e0.p.d.m0.g.e) objFirst3, dVar);
                if (contributedClassifier == null) {
                    return null;
                }
                for (d0.e0.p.d.m0.g.e eVar2 : listPathSegments3.subList(1, listPathSegments3.size())) {
                    if (!(contributedClassifier instanceof e)) {
                        return null;
                    }
                    d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope2 = ((e) contributedClassifier).getUnsubstitutedInnerClassesScope();
                    d0.z.d.m.checkNotNullExpressionValue(eVar2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    h contributedClassifier4 = unsubstitutedInnerClassesScope2.getContributedClassifier(eVar2, dVar);
                    contributedClassifier = contributedClassifier4 instanceof e ? (e) contributedClassifier4 : null;
                    if (contributedClassifier == null) {
                        return null;
                    }
                }
            } else {
                for (d0.e0.p.d.m0.g.e eVar3 : listPathSegments2.subList(1, listPathSegments2.size())) {
                    if (contributedClassifier3 instanceof e) {
                        d0.e0.p.d.m0.k.a0.i unsubstitutedInnerClassesScope3 = ((e) contributedClassifier3).getUnsubstitutedInnerClassesScope();
                        d0.z.d.m.checkNotNullExpressionValue(eVar3, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        h contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(eVar3, dVar);
                        contributedClassifier3 = contributedClassifier5 instanceof e ? (e) contributedClassifier5 : null;
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

    public static final e findNonGenericClassAcrossDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar, d0 d0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        e eVarFindClassAcrossModuleDependencies = findClassAcrossModuleDependencies(c0Var, aVar);
        return eVarFindClassAcrossModuleDependencies != null ? eVarFindClassAcrossModuleDependencies : d0Var.getClass(aVar, d0.f0.q.toList(d0.f0.q.map(d0.f0.n.generateSequence(aVar, a.j), b.j)));
    }

    public static final y0 findTypeAliasAcrossModuleDependencies(c0 c0Var, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        h hVarFindClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(c0Var, aVar);
        if (hVarFindClassifierAcrossModuleDependencies instanceof y0) {
            return (y0) hVarFindClassifierAcrossModuleDependencies;
        }
        return null;
    }
}
