package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.a1;
import d0.e0.p.d.m0.n.d0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.y0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IntegerLiteralTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class n implements u0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final long f3475b;
    public final c0 c;
    public final Set<d0.e0.p.d.m0.n.c0> d;
    public final j0 e;
    public final Lazy f;

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v14, types: [d0.e0.p.d.m0.n.j0] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6, types: [d0.e0.p.d.m0.n.c0, d0.e0.p.d.m0.n.j0, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        public final j0 findIntersectionType(Collection<? extends j0> collection) {
            d0.z.d.m.checkNotNullParameter(collection, "types");
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            j0 next = it.next();
            while (it.hasNext()) {
                j0 j0Var = (j0) it.next();
                next = next;
                if (next != 0 && j0Var != null) {
                    u0 constructor = next.getConstructor();
                    u0 constructor2 = j0Var.getConstructor();
                    boolean z2 = constructor instanceof n;
                    if (z2 && (constructor2 instanceof n)) {
                        n nVar = (n) constructor;
                        n nVar2 = new n(n.access$getValue$p(nVar), n.access$getModule$p(nVar), d0.t.u.union(nVar.getPossibleTypes(), ((n) constructor2).getPossibleTypes()), null);
                        d0 d0Var = d0.a;
                        next = d0.integerLiteralType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), nVar2, false);
                    } else if (z2) {
                        if (((n) constructor).getPossibleTypes().contains(j0Var)) {
                            next = j0Var;
                        }
                    } else if (!(constructor2 instanceof n) || !((n) constructor2).getPossibleTypes().contains(next)) {
                    }
                }
                next = 0;
            }
            return next;
        }
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class b extends d0.z.d.o implements Function0<List<j0>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<j0> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<j0> invoke2() {
            j0 defaultType = n.this.getBuiltIns().getComparable().getDefaultType();
            d0.z.d.m.checkNotNullExpressionValue(defaultType, "builtIns.comparable.defaultType");
            List<j0> listMutableListOf = d0.t.n.mutableListOf(a1.replace$default(defaultType, d0.t.m.listOf(new y0(j1.IN_VARIANCE, n.access$getType$p(n.this))), null, 2, null));
            if (!n.access$isContainsOnlyUnsignedTypes(n.this)) {
                listMutableListOf.add(n.this.getBuiltIns().getNumberType());
            }
            return listMutableListOf;
        }
    }

    public n(long j, c0 c0Var, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        d0 d0Var = d0.a;
        this.e = d0.integerLiteralType(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), this, false);
        this.f = d0.g.lazy(new b());
        this.f3475b = j;
        this.c = c0Var;
        this.d = set;
    }

    public static final /* synthetic */ c0 access$getModule$p(n nVar) {
        return nVar.c;
    }

    public static final /* synthetic */ j0 access$getType$p(n nVar) {
        return nVar.e;
    }

    public static final /* synthetic */ long access$getValue$p(n nVar) {
        return nVar.f3475b;
    }

    public static final boolean access$isContainsOnlyUnsignedTypes(n nVar) {
        Collection<d0.e0.p.d.m0.n.c0> allSignedLiteralTypes = u.getAllSignedLiteralTypes(nVar.c);
        if ((allSignedLiteralTypes instanceof Collection) && allSignedLiteralTypes.isEmpty()) {
            return true;
        }
        Iterator<T> it = allSignedLiteralTypes.iterator();
        while (it.hasNext()) {
            if (!(!nVar.getPossibleTypes().contains((d0.e0.p.d.m0.n.c0) it.next()))) {
                return false;
            }
        }
        return true;
    }

    public final boolean checkConstructor(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        Set<d0.e0.p.d.m0.n.c0> set = this.d;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (d0.z.d.m.areEqual(((d0.e0.p.d.m0.n.c0) it.next()).getConstructor(), u0Var)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.b.h getBuiltIns() {
        return this.c.getBuiltIns();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return d0.t.n.emptyList();
    }

    public final Set<d0.e0.p.d.m0.n.c0> getPossibleTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<d0.e0.p.d.m0.n.c0> getSupertypes() {
        return (List) this.f.getValue();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        StringBuilder sbQ = b.d.b.a.a.Q('[');
        sbQ.append(d0.t.u.joinToString$default(this.d, ",", null, null, 0, null, o.j, 30, null));
        sbQ.append(']');
        return d0.z.d.m.stringPlus("IntegerLiteralType", sbQ.toString());
    }
}
