package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.n.a0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.m0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: IntersectionType.kt */
/* loaded from: classes3.dex */
public final class v {
    public static final v a = new v();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    public static final class a {
        public static final a j;
        public static final a k;
        public static final a l;
        public static final a m;
        public static final /* synthetic */ a[] n;

        /* compiled from: IntersectionType.kt */
        /* renamed from: d0.e0.p.d.m0.n.l1.v$a$a, reason: collision with other inner class name */
        public static final class C0583a extends a {
            public C0583a(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.v.a
            public a combine(i1 i1Var) {
                d0.z.d.m.checkNotNullParameter(i1Var, "nextType");
                return f(i1Var);
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class b extends a {
            public b(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.v.a
            public b combine(i1 i1Var) {
                d0.z.d.m.checkNotNullParameter(i1Var, "nextType");
                return this;
            }

            @Override // d0.e0.p.d.m0.n.l1.v.a
            public /* bridge */ /* synthetic */ a combine(i1 i1Var) {
                return combine(i1Var);
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class c extends a {
            public c(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.v.a
            public a combine(i1 i1Var) {
                d0.z.d.m.checkNotNullParameter(i1Var, "nextType");
                return f(i1Var);
            }
        }

        /* compiled from: IntersectionType.kt */
        public static final class d extends a {
            public d(String str, int i) {
                super(str, i, null);
            }

            @Override // d0.e0.p.d.m0.n.l1.v.a
            public a combine(i1 i1Var) {
                d0.z.d.m.checkNotNullParameter(i1Var, "nextType");
                a aVarF = f(i1Var);
                return aVarF == a.k ? this : aVarF;
            }
        }

        static {
            c cVar = new c("START", 0);
            j = cVar;
            C0583a c0583a = new C0583a("ACCEPT_NULL", 1);
            k = c0583a;
            d dVar = new d("UNKNOWN", 2);
            l = dVar;
            b bVar = new b("NOT_NULL", 3);
            m = bVar;
            n = new a[]{cVar, c0583a, dVar, bVar};
        }

        public a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static a valueOf(String str) {
            d0.z.d.m.checkNotNullParameter(str, "value");
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            a[] aVarArr = n;
            a[] aVarArr2 = new a[aVarArr.length];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            return aVarArr2;
        }

        public abstract a combine(i1 i1Var);

        public final a f(i1 i1Var) {
            d0.z.d.m.checkNotNullParameter(i1Var, "<this>");
            return i1Var.isMarkedNullable() ? k : n.a.isSubtypeOfAny(i1Var) ? m : l;
        }
    }

    public static final boolean access$isStrictSupertype(v vVar, c0 c0Var, c0 c0Var2) {
        Objects.requireNonNull(vVar);
        m mVar = l.f3529b.getDefault();
        return mVar.isSubtypeOf(c0Var, c0Var2) && !mVar.isSubtypeOf(c0Var2, c0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Collection<j0> a(Collection<? extends j0> collection, Function2<? super j0, ? super j0, Boolean> function2) {
        ArrayList arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        d0.z.d.m.checkNotNullExpressionValue(it, "filteredTypes.iterator()");
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            boolean z2 = false;
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    j0 j0Var2 = (j0) it2.next();
                    if (j0Var2 != j0Var) {
                        d0.z.d.m.checkNotNullExpressionValue(j0Var2, "lower");
                        d0.z.d.m.checkNotNullExpressionValue(j0Var, "upper");
                        boolean z3 = function2.invoke(j0Var2, j0Var).booleanValue();
                        if (z3) {
                            z2 = true;
                            break;
                        }
                    }
                }
            }
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    public final j0 intersectTypes$descriptors(List<? extends j0> list) {
        d0.z.d.m.checkNotNullParameter(list, "types");
        list.size();
        ArrayList<j0> arrayList = new ArrayList();
        for (j0 j0Var : list) {
            if (j0Var.getConstructor() instanceof a0) {
                Collection<c0> supertypes = j0Var.getConstructor().getSupertypes();
                d0.z.d.m.checkNotNullExpressionValue(supertypes, "type.constructor.supertypes");
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(supertypes, 10));
                for (c0 c0Var : supertypes) {
                    d0.z.d.m.checkNotNullExpressionValue(c0Var, "it");
                    j0 j0VarUpperIfFlexible = d0.e0.p.d.m0.n.y.upperIfFlexible(c0Var);
                    if (j0Var.isMarkedNullable()) {
                        j0VarUpperIfFlexible = j0VarUpperIfFlexible.makeNullableAsSpecified(true);
                    }
                    arrayList2.add(j0VarUpperIfFlexible);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(j0Var);
            }
        }
        a aVarCombine = a.j;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            aVarCombine = aVarCombine.combine((i1) it.next());
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (j0 j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default : arrayList) {
            if (aVarCombine == a.m) {
                if (j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default instanceof i) {
                    j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default = m0.withNotNullProjection((i) j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
                }
                j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default = m0.makeSimpleTypeDefinitelyNotNullOrNotNull$default(j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default, false, 1, null);
            }
            linkedHashSet.add(j0VarMakeSimpleTypeDefinitelyNotNullOrNotNull$default);
        }
        if (linkedHashSet.size() == 1) {
            return (j0) d0.t.u.single(linkedHashSet);
        }
        new w(linkedHashSet);
        Collection<j0> collectionA = a(linkedHashSet, new x(this));
        ((ArrayList) collectionA).isEmpty();
        j0 j0VarFindIntersectionType = d0.e0.p.d.m0.k.v.n.a.findIntersectionType(collectionA);
        if (j0VarFindIntersectionType != null) {
            return j0VarFindIntersectionType;
        }
        Collection<j0> collectionA2 = a(collectionA, new y(l.f3529b.getDefault()));
        ArrayList arrayList3 = (ArrayList) collectionA2;
        arrayList3.isEmpty();
        return arrayList3.size() < 2 ? (j0) d0.t.u.single(collectionA2) : new a0(linkedHashSet).createType();
    }
}
