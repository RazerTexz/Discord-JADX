package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.o.f;
import d0.e0.p.d.m0.o.k;
import d0.e0.p.d.m0.o.l;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public final class i extends d0.e0.p.d.m0.o.a {
    public static final i a = new i();

    /* renamed from: b, reason: collision with root package name */
    public static final List<d> f3550b;

    /* compiled from: modifierChecks.kt */
    public static final class a extends o implements Function1<x, String> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(x xVar) {
            return invoke2(xVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(x xVar) {
            Boolean boolValueOf;
            m.checkNotNullParameter(xVar, "<this>");
            List<c1> valueParameters = xVar.getValueParameters();
            m.checkNotNullExpressionValue(valueParameters, "valueParameters");
            c1 c1Var = (c1) u.lastOrNull((List) valueParameters);
            if (c1Var == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf(!d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var) && c1Var.getVarargElementType() == null);
            }
            boolean zAreEqual = m.areEqual(boolValueOf, Boolean.TRUE);
            i iVar = i.a;
            if (zAreEqual) {
                return null;
            }
            return "last parameter should not have a default value or be a vararg";
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class b extends o implements Function1<x, String> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(x xVar) {
            return invoke2(xVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0062  */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final String invoke2(x xVar) {
            boolean z2;
            boolean z3;
            m.checkNotNullParameter(xVar, "<this>");
            i iVar = i.a;
            d0.e0.p.d.m0.c.m containingDeclaration = xVar.getContainingDeclaration();
            m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
            if (!((containingDeclaration instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.b.h.isAny((d0.e0.p.d.m0.c.e) containingDeclaration))) {
                Collection<? extends x> overriddenDescriptors = xVar.getOverriddenDescriptors();
                m.checkNotNullExpressionValue(overriddenDescriptors, "overriddenDescriptors");
                if (overriddenDescriptors.isEmpty()) {
                    z3 = false;
                    z2 = z3;
                } else {
                    Iterator<T> it = overriddenDescriptors.iterator();
                    while (it.hasNext()) {
                        d0.e0.p.d.m0.c.m containingDeclaration2 = ((x) it.next()).getContainingDeclaration();
                        m.checkNotNullExpressionValue(containingDeclaration2, "it.containingDeclaration");
                        if ((containingDeclaration2 instanceof d0.e0.p.d.m0.c.e) && d0.e0.p.d.m0.b.h.isAny((d0.e0.p.d.m0.c.e) containingDeclaration2)) {
                            z3 = true;
                            break;
                        }
                    }
                    z3 = false;
                    if (z3) {
                    }
                }
            }
            if (z2) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* compiled from: modifierChecks.kt */
    public static final class c extends o implements Function1<x, String> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(x xVar) {
            return invoke2(xVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(x xVar) {
            boolean zIsSubtypeOf;
            m.checkNotNullParameter(xVar, "<this>");
            q0 dispatchReceiverParameter = xVar.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = xVar.getExtensionReceiverParameter();
            }
            i iVar = i.a;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                c0 returnType = xVar.getReturnType();
                if (returnType == null) {
                    zIsSubtypeOf = false;
                } else {
                    c0 type = dispatchReceiverParameter.getType();
                    m.checkNotNullExpressionValue(type, "receiver.type");
                    zIsSubtypeOf = d0.e0.p.d.m0.n.o1.a.isSubtypeOf(returnType, type);
                }
                if (zIsSubtypeOf) {
                    z2 = true;
                }
            }
            if (z2) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        d0.e0.p.d.m0.g.e eVar = j.i;
        f.b bVar = f.b.f3549b;
        d0.e0.p.d.m0.o.b[] bVarArr = {bVar, new l.a(1)};
        d0.e0.p.d.m0.g.e eVar2 = j.j;
        d0.e0.p.d.m0.o.b[] bVarArr2 = {bVar, new l.a(2)};
        d0.e0.p.d.m0.g.e eVar3 = j.a;
        h hVar = h.a;
        e eVar4 = e.a;
        d0.e0.p.d.m0.g.e eVar5 = j.f;
        l.d dVar = l.d.f3560b;
        k.a aVar = k.a.d;
        d0.e0.p.d.m0.g.e eVar6 = j.h;
        l.c cVar = l.c.f3559b;
        f3550b = n.listOf((Object[]) new d[]{new d(eVar, bVarArr, (Function1) null, 4, (DefaultConstructorMarker) null), new d(eVar2, bVarArr2, a.j), new d(eVar3, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.a(2), eVar4}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.f3551b, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.a(3), eVar4}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.c, new d0.e0.p.d.m0.o.b[]{bVar, hVar, new l.b(2), eVar4}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.g, new d0.e0.p.d.m0.o.b[]{bVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(eVar5, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(eVar6, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.k, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.l, new d0.e0.p.d.m0.o.b[]{bVar, cVar, aVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.f3554y, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.d, new d0.e0.p.d.m0.o.b[]{f.a.f3548b}, b.j), new d(j.e, new d0.e0.p.d.m0.o.b[]{bVar, k.b.d, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.G, new d0.e0.p.d.m0.o.b[]{bVar, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.F, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(n.listOf((Object[]) new d0.e0.p.d.m0.g.e[]{j.n, j.o}), new d0.e0.p.d.m0.o.b[]{bVar}, c.j), new d(j.H, new d0.e0.p.d.m0.o.b[]{bVar, k.c.d, dVar, hVar}, (Function1) null, 4, (DefaultConstructorMarker) null), new d(j.m, new d0.e0.p.d.m0.o.b[]{bVar, cVar}, (Function1) null, 4, (DefaultConstructorMarker) null)});
    }

    @Override // d0.e0.p.d.m0.o.a
    public List<d> getChecks$descriptors() {
        return f3550b;
    }
}
