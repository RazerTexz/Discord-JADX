package d0.e0.p.d.m0.k.a0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.k.p;
import d0.e0.p.d.m0.n.c0;
import d0.t.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeIntersectionScope.kt */
/* loaded from: classes3.dex */
public final class o extends d0.e0.p.d.m0.k.a0.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f3464b = new a(null);
    public final i c;

    /* compiled from: TypeIntersectionScope.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final i create(String str, Collection<? extends c0> collection) {
            d0.z.d.m.checkNotNullParameter(str, "message");
            d0.z.d.m.checkNotNullParameter(collection, "types");
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((c0) it.next()).getMemberScope());
            }
            d0.e0.p.d.m0.p.i<i> iVarListOfNonEmptyScopes = d0.e0.p.d.m0.o.n.a.listOfNonEmptyScopes(arrayList);
            i iVarCreateOrSingle$descriptors = d0.e0.p.d.m0.k.a0.b.f3451b.createOrSingle$descriptors(str, iVarListOfNonEmptyScopes);
            return iVarListOfNonEmptyScopes.size() <= 1 ? iVarCreateOrSingle$descriptors : new o(str, iVarCreateOrSingle$descriptors, null);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    public static final class b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.a, d0.e0.p.d.m0.c.a> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.a invoke2(d0.e0.p.d.m0.c.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "<this>");
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a invoke(d0.e0.p.d.m0.c.a aVar) {
            return invoke2(aVar);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    public static final class c extends d0.z.d.o implements Function1<t0, d0.e0.p.d.m0.c.a> {
        public static final c j = new c();

        public c() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.a invoke2(t0 t0Var) {
            d0.z.d.m.checkNotNullParameter(t0Var, "<this>");
            return t0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a invoke(t0 t0Var) {
            return invoke2(t0Var);
        }
    }

    /* compiled from: TypeIntersectionScope.kt */
    public static final class d extends d0.z.d.o implements Function1<n0, d0.e0.p.d.m0.c.a> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.a invoke2(n0 n0Var) {
            d0.z.d.m.checkNotNullParameter(n0Var, "<this>");
            return n0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.a invoke(n0 n0Var) {
            return invoke2(n0Var);
        }
    }

    public o(String str, i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this.c = iVar;
    }

    public static final i create(String str, Collection<? extends c0> collection) {
        return f3464b.create(str, collection);
    }

    @Override // d0.e0.p.d.m0.k.a0.a
    public i a() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.l
    public Collection<d0.e0.p.d.m0.c.m> getContributedDescriptors(d0.e0.p.d.m0.k.a0.d dVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(dVar, "kindFilter");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        Collection<d0.e0.p.d.m0.c.m> contributedDescriptors = super.getContributedDescriptors(dVar, function1);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : contributedDescriptors) {
            if (((d0.e0.p.d.m0.c.m) obj) instanceof d0.e0.p.d.m0.c.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        List list = (List) pair.component1();
        return u.plus(p.selectMostSpecificInEachOverridableGroup(list, b.j), (Iterable) pair.component2());
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.i
    public Collection<t0> getContributedFunctions(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return p.selectMostSpecificInEachOverridableGroup(super.getContributedFunctions(eVar, bVar), c.j);
    }

    @Override // d0.e0.p.d.m0.k.a0.a, d0.e0.p.d.m0.k.a0.i
    public Collection<n0> getContributedVariables(d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.d.b.b bVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(bVar, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return p.selectMostSpecificInEachOverridableGroup(super.getContributedVariables(eVar, bVar), d.j);
    }
}
