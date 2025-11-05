package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.g1;
import d0.e0.p.d.m0.n.i0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.m0;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;

/* compiled from: typeEnhancement.kt */
/* loaded from: classes3.dex */
public final class d {
    public final d0.e0.p.d.m0.e.a.i0.c a;

    /* compiled from: typeEnhancement.kt */
    public static class a {
        public final c0 a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3343b;
        public final boolean c;

        public a(c0 c0Var, int i, boolean z2) {
            d0.z.d.m.checkNotNullParameter(c0Var, "type");
            this.a = c0Var;
            this.f3343b = i;
            this.c = z2;
        }

        public final int getSubtreeSize() {
            return this.f3343b;
        }

        public c0 getType() {
            return this.a;
        }

        public final c0 getTypeIfChanged() {
            c0 type = getType();
            if (getWereChanges()) {
                return type;
            }
            return null;
        }

        public final boolean getWereChanges() {
            return this.c;
        }
    }

    /* compiled from: typeEnhancement.kt */
    public static final class b extends a {
        public final j0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j0 j0Var, int i, boolean z2) {
            super(j0Var, i, z2);
            d0.z.d.m.checkNotNullParameter(j0Var, "type");
            this.d = j0Var;
        }

        @Override // d0.e0.p.d.m0.e.a.l0.d.a
        public /* bridge */ /* synthetic */ c0 getType() {
            return getType();
        }

        @Override // d0.e0.p.d.m0.e.a.l0.d.a
        public j0 getType() {
            return this.d;
        }
    }

    public d(d0.e0.p.d.m0.e.a.i0.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "javaResolverSettings");
        this.a = cVar;
    }

    public final b a(j0 j0Var, Function1<? super Integer, e> function1, int i, t tVar, boolean z2) {
        int subtreeSize;
        w0 w0VarCreateProjection;
        if (!u.shouldEnhance(tVar) && j0Var.getArguments().isEmpty()) {
            return new b(j0Var, 1, false);
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = j0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new b(j0Var, 1, false);
        }
        e eVarInvoke = function1.invoke(Integer.valueOf(i));
        c cVarAccess$enhanceMutability = x.access$enhanceMutability(declarationDescriptor, eVarInvoke, tVar);
        d0.e0.p.d.m0.c.h hVar = (d0.e0.p.d.m0.c.h) cVarAccess$enhanceMutability.component1();
        d0.e0.p.d.m0.c.g1.g gVarComponent2 = cVarAccess$enhanceMutability.component2();
        u0 typeConstructor = hVar.getTypeConstructor();
        d0.z.d.m.checkNotNullExpressionValue(typeConstructor, "enhancedClassifier.typeConstructor");
        int i2 = i + 1;
        boolean z3 = gVarComponent2 != null;
        List<w0> arguments = j0Var.getArguments();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(arguments, 10));
        int i3 = 0;
        for (Object obj : arguments) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                d0.t.n.throwIndexOverflow();
            }
            w0 w0Var = (w0) obj;
            if (w0Var.isStarProjection()) {
                subtreeSize = i2 + 1;
                if (function1.invoke(Integer.valueOf(i2)).getNullability() != h.NOT_NULL || z2) {
                    w0VarCreateProjection = e1.makeStarProjection(hVar.getTypeConstructor().getParameters().get(i3));
                    d0.z.d.m.checkNotNullExpressionValue(w0VarCreateProjection, "{\n                    TypeUtils.makeStarProjection(enhancedClassifier.typeConstructor.parameters[localArgIndex])\n                }");
                } else {
                    c0 c0VarMakeNotNullable = d0.e0.p.d.m0.n.o1.a.makeNotNullable(w0Var.getType().unwrap());
                    j1 projectionKind = w0Var.getProjectionKind();
                    d0.z.d.m.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                    w0VarCreateProjection = d0.e0.p.d.m0.n.o1.a.createProjection(c0VarMakeNotNullable, projectionKind, typeConstructor.getParameters().get(i3));
                }
            } else {
                a aVarB = b(w0Var.getType().unwrap(), function1, i2);
                z3 = z3 || aVarB.getWereChanges();
                subtreeSize = aVarB.getSubtreeSize() + i2;
                c0 type = aVarB.getType();
                j1 projectionKind2 = w0Var.getProjectionKind();
                d0.z.d.m.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                w0VarCreateProjection = d0.e0.p.d.m0.n.o1.a.createProjection(type, projectionKind2, typeConstructor.getParameters().get(i3));
            }
            i2 = subtreeSize;
            arrayList.add(w0VarCreateProjection);
            i3 = i4;
        }
        c cVarAccess$getEnhancedNullability = x.access$getEnhancedNullability(j0Var, eVarInvoke, tVar);
        boolean zBooleanValue = ((Boolean) cVarAccess$getEnhancedNullability.component1()).booleanValue();
        d0.e0.p.d.m0.c.g1.g gVarComponent22 = cVarAccess$getEnhancedNullability.component2();
        int i5 = i2 - i;
        if (!(z3 || gVarComponent22 != null)) {
            return new b(j0Var, i5, false);
        }
        boolean z4 = false;
        d0.e0.p.d.m0.c.g1.g gVarAccess$compositeAnnotationsOrSingle = x.access$compositeAnnotationsOrSingle(d0.t.n.listOfNotNull((Object[]) new d0.e0.p.d.m0.c.g1.g[]{j0Var.getAnnotations(), gVarComponent2, gVarComponent22}));
        d0 d0Var = d0.a;
        j0 j0VarSimpleType$default = d0.simpleType$default(gVarAccess$compositeAnnotationsOrSingle, typeConstructor, arrayList, zBooleanValue, null, 16, null);
        i1 i1VarWrapEnhancement = j0VarSimpleType$default;
        if (eVarInvoke.isNotNullTypeParameter()) {
            i1VarWrapEnhancement = this.a.getCorrectNullabilityForNotNullTypeParameter() ? m0.makeSimpleTypeDefinitelyNotNullOrNotNull(j0VarSimpleType$default, true) : new g(j0VarSimpleType$default);
        }
        if (gVarComponent22 != null && eVarInvoke.isNullabilityQualifierForWarning()) {
            z4 = true;
        }
        if (z4) {
            i1VarWrapEnhancement = g1.wrapEnhancement(j0Var, i1VarWrapEnhancement);
        }
        return new b((j0) i1VarWrapEnhancement, i5, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a b(i1 i1Var, Function1<? super Integer, e> function1, int i) {
        i1 i1VarFlexibleType;
        if (e0.isError(i1Var)) {
            return new a(i1Var, 1, false);
        }
        if (!(i1Var instanceof d0.e0.p.d.m0.n.v)) {
            if (i1Var instanceof j0) {
                return a((j0) i1Var, function1, i, t.INFLEXIBLE, false);
            }
            throw new NoWhenBranchMatchedException();
        }
        boolean z2 = i1Var instanceof i0;
        d0.e0.p.d.m0.n.v vVar = (d0.e0.p.d.m0.n.v) i1Var;
        b bVarA = a(vVar.getLowerBound(), function1, i, t.FLEXIBLE_LOWER, z2);
        b bVarA2 = a(vVar.getUpperBound(), function1, i, t.FLEXIBLE_UPPER, z2);
        bVarA.getSubtreeSize();
        bVarA2.getSubtreeSize();
        boolean z3 = bVarA.getWereChanges() || bVarA2.getWereChanges();
        j0 type = bVarA.getType();
        c0 enhancement = g1.getEnhancement(bVarA2.getType());
        c0 enhancement2 = g1.getEnhancement(type);
        if (enhancement2 != null) {
            if (enhancement != null) {
                d0 d0Var = d0.a;
                enhancement2 = d0.flexibleType(y.lowerIfFlexible(enhancement2), y.upperIfFlexible(enhancement));
            }
        } else if (enhancement == null) {
            enhancement2 = null;
        } else {
            enhancement2 = enhancement;
            if (enhancement != null) {
            }
        }
        if (z3) {
            if (i1Var instanceof d0.e0.p.d.m0.e.a.i0.m.g) {
                i1VarFlexibleType = new d0.e0.p.d.m0.e.a.i0.m.g(bVarA.getType(), bVarA2.getType());
            } else {
                d0 d0Var2 = d0.a;
                i1VarFlexibleType = d0.flexibleType(bVarA.getType(), bVarA2.getType());
            }
            i1Var = g1.wrapEnhancement(i1VarFlexibleType, enhancement2);
        }
        return new a(i1Var, bVarA.getSubtreeSize(), z3);
    }

    public final c0 enhance(c0 c0Var, Function1<? super Integer, e> function1) {
        d0.z.d.m.checkNotNullParameter(c0Var, "<this>");
        d0.z.d.m.checkNotNullParameter(function1, "qualifiers");
        return b(c0Var.unwrap(), function1, 0).getTypeIfChanged();
    }
}
