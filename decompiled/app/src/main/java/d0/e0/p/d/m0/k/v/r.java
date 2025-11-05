package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class r extends g<b> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3476b = new a(null);

    /* compiled from: constantValues.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final g<?> create(c0 c0Var) {
            d0.z.d.m.checkNotNullParameter(c0Var, "argumentType");
            if (e0.isError(c0Var)) {
                return null;
            }
            c0 type = c0Var;
            int i = 0;
            while (d0.e0.p.d.m0.b.h.isArray(type)) {
                type = ((w0) d0.t.u.single((List) type.getArguments())).getType();
                d0.z.d.m.checkNotNullExpressionValue(type, "type.arguments.single().type");
                i++;
            }
            d0.e0.p.d.m0.c.h declarationDescriptor = type.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
                d0.e0.p.d.m0.g.a classId = d0.e0.p.d.m0.k.x.a.getClassId(declarationDescriptor);
                return classId == null ? new r(new b.a(c0Var)) : new r(classId, i);
            }
            if (!(declarationDescriptor instanceof z0)) {
                return null;
            }
            d0.e0.p.d.m0.g.a aVar = d0.e0.p.d.m0.g.a.topLevel(k.a.f3217b.toSafe());
            d0.z.d.m.checkNotNullExpressionValue(aVar, "topLevel(StandardNames.FqNames.any.toSafe())");
            return new r(aVar, 0);
        }
    }

    /* compiled from: constantValues.kt */
    public static abstract class b {

        /* compiled from: constantValues.kt */
        public static final class a extends b {
            public final c0 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(c0 c0Var) {
                super(null);
                d0.z.d.m.checkNotNullParameter(c0Var, "type");
                this.a = c0Var;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && d0.z.d.m.areEqual(this.a, ((a) obj).a);
            }

            public final c0 getType() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("LocalClass(type=");
                sbU.append(this.a);
                sbU.append(')');
                return sbU.toString();
            }
        }

        /* compiled from: constantValues.kt */
        /* renamed from: d0.e0.p.d.m0.k.v.r$b$b, reason: collision with other inner class name */
        public static final class C0566b extends b {
            public final f a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0566b(f fVar) {
                super(null);
                d0.z.d.m.checkNotNullParameter(fVar, "value");
                this.a = fVar;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0566b) && d0.z.d.m.areEqual(this.a, ((C0566b) obj).a);
            }

            public final int getArrayDimensions() {
                return this.a.getArrayNestedness();
            }

            public final d0.e0.p.d.m0.g.a getClassId() {
                return this.a.getClassId();
            }

            public final f getValue() {
                return this.a;
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("NormalClass(value=");
                sbU.append(this.a);
                sbU.append(')');
                return sbU.toString();
            }
        }

        public b() {
        }

        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(b bVar) {
        super(bVar);
        d0.z.d.m.checkNotNullParameter(bVar, "value");
    }

    public final c0 getArgumentType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        b value = getValue();
        if (value instanceof b.a) {
            return ((b.a) getValue()).getType();
        }
        if (!(value instanceof b.C0566b)) {
            throw new NoWhenBranchMatchedException();
        }
        f value2 = ((b.C0566b) getValue()).getValue();
        d0.e0.p.d.m0.g.a aVarComponent1 = value2.component1();
        int iComponent2 = value2.component2();
        d0.e0.p.d.m0.c.e eVarFindClassAcrossModuleDependencies = d0.e0.p.d.m0.c.w.findClassAcrossModuleDependencies(c0Var, aVarComponent1);
        if (eVarFindClassAcrossModuleDependencies == null) {
            j0 j0VarCreateErrorType = d0.e0.p.d.m0.n.t.createErrorType("Unresolved type: " + aVarComponent1 + " (arrayDimensions=" + iComponent2 + ')');
            d0.z.d.m.checkNotNullExpressionValue(j0VarCreateErrorType, "createErrorType(\"Unresolved type: $classId (arrayDimensions=$arrayDimensions)\")");
            return j0VarCreateErrorType;
        }
        j0 defaultType = eVarFindClassAcrossModuleDependencies.getDefaultType();
        d0.z.d.m.checkNotNullExpressionValue(defaultType, "descriptor.defaultType");
        c0 c0VarReplaceArgumentsWithStarProjections = d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(defaultType);
        for (int i = 0; i < iComponent2; i++) {
            c0VarReplaceArgumentsWithStarProjections = c0Var.getBuiltIns().getArrayType(j1.INVARIANT, c0VarReplaceArgumentsWithStarProjections);
            d0.z.d.m.checkNotNullExpressionValue(c0VarReplaceArgumentsWithStarProjections, "module.builtIns.getArrayType(Variance.INVARIANT, type)");
        }
        return c0VarReplaceArgumentsWithStarProjections;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0 d0Var = d0.a;
        d0.e0.p.d.m0.c.g1.g empty = d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
        d0.e0.p.d.m0.c.e kClass = c0Var.getBuiltIns().getKClass();
        d0.z.d.m.checkNotNullExpressionValue(kClass, "module.builtIns.kClass");
        return d0.simpleNotNullType(empty, kClass, d0.t.m.listOf(new y0(getArgumentType(c0Var))));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(f fVar) {
        this(new b.C0566b(fVar));
        d0.z.d.m.checkNotNullParameter(fVar, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(d0.e0.p.d.m0.g.a aVar, int i) {
        this(new f(aVar, i));
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
    }
}
