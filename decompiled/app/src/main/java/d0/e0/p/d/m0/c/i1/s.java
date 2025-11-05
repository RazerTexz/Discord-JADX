package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.j0;
import d0.e0.p.d.m0.k.a0.b;
import d0.e0.p.d.m0.k.a0.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
/* loaded from: classes3.dex */
public final class s extends k implements d0.e0.p.d.m0.c.j0 {
    public static final /* synthetic */ KProperty<Object>[] l = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s.class), "fragments", "getFragments()Ljava/util/List;"))};
    public final y m;
    public final d0.e0.p.d.m0.g.b n;
    public final d0.e0.p.d.m0.m.j o;
    public final d0.e0.p.d.m0.k.a0.i p;

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class a extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.e0>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.e0> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends d0.e0.p.d.m0.c.e0> invoke2() {
            return d0.e0.p.d.m0.c.h0.packageFragments(s.this.getModule().getPackageFragmentProvider(), s.this.getFqName());
        }
    }

    /* compiled from: LazyPackageViewDescriptorImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final d0.e0.p.d.m0.k.a0.i invoke() {
            if (s.this.getFragments().isEmpty()) {
                return i.b.f3461b;
            }
            List<d0.e0.p.d.m0.c.e0> fragments = s.this.getFragments();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(fragments, 10));
            Iterator<T> it = fragments.iterator();
            while (it.hasNext()) {
                arrayList.add(((d0.e0.p.d.m0.c.e0) it.next()).getMemberScope());
            }
            List listPlus = d0.t.u.plus((Collection<? extends h0>) arrayList, new h0(s.this.getModule(), s.this.getFqName()));
            b.a aVar = d0.e0.p.d.m0.k.a0.b.f3451b;
            StringBuilder sbU = b.d.b.a.a.U("package view scope for ");
            sbU.append(s.this.getFqName());
            sbU.append(" in ");
            sbU.append(s.this.getModule().getName());
            return aVar.create(sbU.toString(), listPlus);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(y yVar, d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar) {
        super(d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), bVar.shortNameOrSpecial());
        d0.z.d.m.checkNotNullParameter(yVar, "module");
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        this.m = yVar;
        this.n = bVar;
        this.o = oVar.createLazyValue(new a());
        this.p = new d0.e0.p.d.m0.k.a0.h(oVar, new b());
    }

    @Override // d0.e0.p.d.m0.c.m
    public <R, D> R accept(d0.e0.p.d.m0.c.o<R, D> oVar, D d) {
        d0.z.d.m.checkNotNullParameter(oVar, "visitor");
        return oVar.visitPackageViewDescriptor(this, d);
    }

    public boolean equals(Object obj) {
        d0.e0.p.d.m0.c.j0 j0Var = obj instanceof d0.e0.p.d.m0.c.j0 ? (d0.e0.p.d.m0.c.j0) obj : null;
        return j0Var != null && d0.z.d.m.areEqual(getFqName(), j0Var.getFqName()) && d0.z.d.m.areEqual(getModule(), j0Var.getModule());
    }

    @Override // d0.e0.p.d.m0.c.m
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.m getContainingDeclaration() {
        return getContainingDeclaration();
    }

    @Override // d0.e0.p.d.m0.c.j0
    public d0.e0.p.d.m0.g.b getFqName() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.c.j0
    public List<d0.e0.p.d.m0.c.e0> getFragments() {
        return (List) d0.e0.p.d.m0.m.n.getValue(this.o, this, (KProperty<?>) l[0]);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.c.j0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.c0 getModule() {
        return getModule();
    }

    public int hashCode() {
        return getFqName().hashCode() + (getModule().hashCode() * 31);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public boolean isEmpty() {
        return j0.a.isEmpty(this);
    }

    @Override // d0.e0.p.d.m0.c.m
    public d0.e0.p.d.m0.c.j0 getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        y module = getModule();
        d0.e0.p.d.m0.g.b bVarParent = getFqName().parent();
        d0.z.d.m.checkNotNullExpressionValue(bVarParent, "fqName.parent()");
        return module.getPackage(bVarParent);
    }

    @Override // d0.e0.p.d.m0.c.j0
    public y getModule() {
        return this.m;
    }
}
