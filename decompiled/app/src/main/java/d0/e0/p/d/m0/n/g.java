package d0.e0.p.d.m0.n;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: AbstractTypeConstructor.kt */
/* loaded from: classes3.dex */
public abstract class g implements u0 {
    public final d0.e0.p.d.m0.m.j<b> a;

    /* compiled from: AbstractTypeConstructor.kt */
    public final class a implements u0 {
        public final d0.e0.p.d.m0.n.l1.g a;

        /* renamed from: b, reason: collision with root package name */
        public final Lazy f3524b;
        public final /* synthetic */ g c;

        /* compiled from: AbstractTypeConstructor.kt */
        /* renamed from: d0.e0.p.d.m0.n.g$a$a, reason: collision with other inner class name */
        public static final class C0580a extends d0.z.d.o implements Function0<List<? extends c0>> {
            public final /* synthetic */ g this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0580a(g gVar) {
                super(0);
                this.this$1 = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ List<? extends c0> invoke() {
                return invoke2();
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<? extends c0> invoke2() {
                return d0.e0.p.d.m0.n.l1.h.refineTypes(a.access$getKotlinTypeRefiner$p(a.this), this.this$1.getSupertypes());
            }
        }

        public a(g gVar, d0.e0.p.d.m0.n.l1.g gVar2) {
            d0.z.d.m.checkNotNullParameter(gVar, "this$0");
            d0.z.d.m.checkNotNullParameter(gVar2, "kotlinTypeRefiner");
            this.c = gVar;
            this.a = gVar2;
            this.f3524b = d0.g.lazy(d0.i.PUBLICATION, new C0580a(gVar));
        }

        public static final /* synthetic */ d0.e0.p.d.m0.n.l1.g access$getKotlinTypeRefiner$p(a aVar) {
            return aVar.a;
        }

        public boolean equals(Object obj) {
            return this.c.equals(obj);
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.b.h getBuiltIns() {
            d0.e0.p.d.m0.b.h builtIns = this.c.getBuiltIns();
            d0.z.d.m.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
            return this.c.getDeclarationDescriptor();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<d0.e0.p.d.m0.c.z0> getParameters() {
            List<d0.e0.p.d.m0.c.z0> parameters = this.c.getParameters();
            d0.z.d.m.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        @Override // d0.e0.p.d.m0.n.u0
        public /* bridge */ /* synthetic */ Collection getSupertypes() {
            return getSupertypes();
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public boolean isDenotable() {
            return this.c.isDenotable();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
            return this.c.refine(gVar);
        }

        public String toString() {
            return this.c.toString();
        }

        @Override // d0.e0.p.d.m0.n.u0
        public List<c0> getSupertypes() {
            return (List) this.f3524b.getValue();
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    public static final class b {
        public final Collection<c0> a;

        /* renamed from: b, reason: collision with root package name */
        public List<? extends c0> f3525b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Collection<? extends c0> collection) {
            d0.z.d.m.checkNotNullParameter(collection, "allSupertypes");
            this.a = collection;
            this.f3525b = d0.t.m.listOf(t.c);
        }

        public final Collection<c0> getAllSupertypes() {
            return this.a;
        }

        public final List<c0> getSupertypesWithoutCycles() {
            return this.f3525b;
        }

        public final void setSupertypesWithoutCycles(List<? extends c0> list) {
            d0.z.d.m.checkNotNullParameter(list, "<set-?>");
            this.f3525b = list;
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    public static final class c extends d0.z.d.o implements Function0<b> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ b invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final b invoke() {
            return new b(g.this.a());
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    public static final class d extends d0.z.d.o implements Function1<Boolean, b> {
        public static final d j = new d();

        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        public final b invoke(boolean z2) {
            return new b(d0.t.m.listOf(t.c));
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    public static final class e extends d0.z.d.o implements Function1<b, Unit> {

        /* compiled from: AbstractTypeConstructor.kt */
        public static final class a extends d0.z.d.o implements Function1<u0, Iterable<? extends c0>> {
            public final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Iterable<c0> invoke2(u0 u0Var) {
                d0.z.d.m.checkNotNullParameter(u0Var, "it");
                return g.access$computeNeighbours(this.this$0, u0Var, false);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Iterable<? extends c0> invoke(u0 u0Var) {
                return invoke2(u0Var);
            }
        }

        /* compiled from: AbstractTypeConstructor.kt */
        public static final class b extends d0.z.d.o implements Function1<c0, Unit> {
            public final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(g gVar) {
                super(1);
                this.this$0 = gVar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c0 c0Var) {
                invoke2(c0Var);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c0 c0Var) {
                d0.z.d.m.checkNotNullParameter(c0Var, "it");
                this.this$0.f(c0Var);
            }
        }

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
            invoke2(bVar);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "supertypes");
            Collection<c0> collectionFindLoopsInSupertypesAndDisconnect = g.this.d().findLoopsInSupertypesAndDisconnect(g.this, bVar.getAllSupertypes(), new a(g.this), new b(g.this));
            if (collectionFindLoopsInSupertypesAndDisconnect.isEmpty()) {
                c0 c0VarB = g.this.b();
                collectionFindLoopsInSupertypesAndDisconnect = c0VarB == null ? null : d0.t.m.listOf(c0VarB);
                if (collectionFindLoopsInSupertypesAndDisconnect == null) {
                    collectionFindLoopsInSupertypesAndDisconnect = d0.t.n.emptyList();
                }
            }
            Objects.requireNonNull(g.this);
            g gVar = g.this;
            List<c0> list = collectionFindLoopsInSupertypesAndDisconnect instanceof List ? (List) collectionFindLoopsInSupertypesAndDisconnect : null;
            if (list == null) {
                list = d0.t.u.toList(collectionFindLoopsInSupertypesAndDisconnect);
            }
            bVar.setSupertypesWithoutCycles(gVar.e(list));
        }
    }

    public g(d0.e0.p.d.m0.m.o oVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        this.a = oVar.createLazyValueWithPostCompute(new c(), d.j, new e());
    }

    public static final Collection access$computeNeighbours(g gVar, u0 u0Var, boolean z2) {
        Objects.requireNonNull(gVar);
        g gVar2 = u0Var instanceof g ? (g) u0Var : null;
        List listPlus = gVar2 != null ? d0.t.u.plus((Collection) gVar2.a.invoke().getAllSupertypes(), (Iterable) gVar2.c(z2)) : null;
        if (listPlus != null) {
            return listPlus;
        }
        Collection<c0> supertypes = u0Var.getSupertypes();
        d0.z.d.m.checkNotNullExpressionValue(supertypes, "supertypes");
        return supertypes;
    }

    public abstract Collection<c0> a();

    public c0 b() {
        return null;
    }

    public Collection<c0> c(boolean z2) {
        return d0.t.n.emptyList();
    }

    public abstract d0.e0.p.d.m0.c.x0 d();

    public List<c0> e(List<c0> list) {
        d0.z.d.m.checkNotNullParameter(list, "supertypes");
        return list;
    }

    public void f(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
    }

    @Override // d0.e0.p.d.m0.n.u0
    public abstract d0.e0.p.d.m0.c.h getDeclarationDescriptor();

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ Collection getSupertypes() {
        return getSupertypes();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public u0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return new a(this, gVar);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<c0> getSupertypes() {
        return this.a.invoke().getSupertypesWithoutCycles();
    }
}
