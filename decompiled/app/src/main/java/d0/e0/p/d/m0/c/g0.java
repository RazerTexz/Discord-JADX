package d0.e0.p.d.m0.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: PackageFragmentProviderImpl.kt */
/* loaded from: classes3.dex */
public final class g0 implements i0 {
    public final Collection<e0> a;

    /* compiled from: PackageFragmentProviderImpl.kt */
    public static final class a extends d0.z.d.o implements Function1<e0, d0.e0.p.d.m0.g.b> {
        public static final a j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.b invoke(e0 e0Var) {
            return invoke2(e0Var);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.g.b invoke2(e0 e0Var) {
            d0.z.d.m.checkNotNullParameter(e0Var, "it");
            return e0Var.getFqName();
        }
    }

    /* compiled from: PackageFragmentProviderImpl.kt */
    public static final class b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, Boolean> {
        public final /* synthetic */ d0.e0.p.d.m0.g.b $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d0.e0.p.d.m0.g.b bVar) {
            super(1);
            this.$fqName = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.g.b bVar) {
            return Boolean.valueOf(invoke2(bVar));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.g.b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "it");
            return !bVar.isRoot() && d0.z.d.m.areEqual(bVar.parent(), this.$fqName);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g0(Collection<? extends e0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        this.a = collection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        for (Object obj : this.a) {
            if (d0.z.d.m.areEqual(((e0) obj).getFqName(), bVar)) {
                collection.add(obj);
            }
        }
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<e0> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Collection<e0> collection = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (d0.z.d.m.areEqual(((e0) obj).getFqName(), bVar)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // d0.e0.p.d.m0.c.f0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return d0.f0.q.toList(d0.f0.q.filter(d0.f0.q.map(d0.t.u.asSequence(this.a), a.j), new b(bVar)));
    }
}
