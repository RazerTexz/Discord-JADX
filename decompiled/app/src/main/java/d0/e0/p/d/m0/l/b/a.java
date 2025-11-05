package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.i0;
import d0.t.n0;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* loaded from: classes3.dex */
public abstract class a implements i0 {
    public final d0.e0.p.d.m0.m.o a;

    /* renamed from: b, reason: collision with root package name */
    public final s f3481b;
    public final d0.e0.p.d.m0.c.c0 c;
    public j d;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.g.b, e0> e;

    /* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    /* renamed from: d0.e0.p.d.m0.l.b.a$a, reason: collision with other inner class name */
    public static final class C0569a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, e0> {
        public C0569a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ e0 invoke(d0.e0.p.d.m0.g.b bVar) {
            return invoke2(bVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final e0 invoke2(d0.e0.p.d.m0.g.b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            d0.e0.p.d.m0.b.q.o oVar = (d0.e0.p.d.m0.b.q.o) a.this;
            Objects.requireNonNull(oVar);
            d0.z.d.m.checkNotNullParameter(bVar, "fqName");
            InputStream inputStreamFindBuiltInsData = oVar.f3481b.findBuiltInsData(bVar);
            d0.e0.p.d.m0.l.b.d0.c cVarCreate = inputStreamFindBuiltInsData == null ? null : d0.e0.p.d.m0.l.b.d0.c.v.create(bVar, oVar.a, oVar.c, inputStreamFindBuiltInsData, false);
            if (cVarCreate == null) {
                return null;
            }
            j jVar = a.this.d;
            if (jVar != null) {
                cVarCreate.initialize(jVar);
                return cVarCreate;
            }
            d0.z.d.m.throwUninitializedPropertyAccessException("components");
            throw null;
        }
    }

    public a(d0.e0.p.d.m0.m.o oVar, s sVar, d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(sVar, "finder");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        this.a = oVar;
        this.f3481b = sVar;
        this.c = c0Var;
        this.e = oVar.createMemoizedFunctionWithNullableValues(new C0569a());
    }

    @Override // d0.e0.p.d.m0.c.i0
    public void collectPackageFragments(d0.e0.p.d.m0.g.b bVar, Collection<e0> collection) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(collection, "packageFragments");
        d0.e0.p.d.m0.p.a.addIfNotNull(collection, this.e.invoke(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public List<e0> getPackageFragments(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return d0.t.n.listOfNotNull(this.e.invoke(bVar));
    }

    @Override // d0.e0.p.d.m0.c.f0
    public Collection<d0.e0.p.d.m0.g.b> getSubPackagesOf(d0.e0.p.d.m0.g.b bVar, Function1<? super d0.e0.p.d.m0.g.e, Boolean> function1) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(function1, "nameFilter");
        return n0.emptySet();
    }
}
