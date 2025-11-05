package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: DeserializedPackageFragmentImpl.kt */
/* loaded from: classes3.dex */
public abstract class o extends n {
    public final d0.e0.p.d.m0.f.z.a p;
    public final d0.e0.p.d.m0.l.b.e0.f q;
    public final d0.e0.p.d.m0.f.z.d r;

    /* renamed from: s, reason: collision with root package name */
    public final x f3506s;
    public d0.e0.p.d.m0.f.m t;
    public d0.e0.p.d.m0.k.a0.i u;

    /* compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.a, u0> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u0 invoke(d0.e0.p.d.m0.g.a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final u0 invoke2(d0.e0.p.d.m0.g.a aVar) {
            d0.z.d.m.checkNotNullParameter(aVar, "it");
            d0.e0.p.d.m0.l.b.e0.f fVarAccess$getContainerSource$p = o.access$getContainerSource$p(o.this);
            if (fVarAccess$getContainerSource$p != null) {
                return fVarAccess$getContainerSource$p;
            }
            u0 u0Var = u0.a;
            d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
            return u0Var;
        }
    }

    /* compiled from: DeserializedPackageFragmentImpl.kt */
    public static final class b extends d0.z.d.o implements Function0<Collection<? extends d0.e0.p.d.m0.g.e>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Collection<? extends d0.e0.p.d.m0.g.e> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Collection<? extends d0.e0.p.d.m0.g.e> invoke2() {
            Collection<d0.e0.p.d.m0.g.a> allClassIds = o.this.getClassDataFinder().getAllClassIds();
            ArrayList arrayList = new ArrayList();
            for (Object obj : allClassIds) {
                d0.e0.p.d.m0.g.a aVar = (d0.e0.p.d.m0.g.a) obj;
                if ((aVar.isNestedClass() || h.a.getBLACK_LIST().contains(aVar)) ? false : true) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((d0.e0.p.d.m0.g.a) it.next()).getShortClassName());
            }
            return arrayList2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.c0 c0Var, d0.e0.p.d.m0.f.m mVar, d0.e0.p.d.m0.f.z.a aVar, d0.e0.p.d.m0.l.b.e0.f fVar) {
        super(bVar, oVar, c0Var);
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.z.d.m.checkNotNullParameter(mVar, "proto");
        d0.z.d.m.checkNotNullParameter(aVar, "metadataVersion");
        this.p = aVar;
        this.q = fVar;
        d0.e0.p.d.m0.f.p strings = mVar.getStrings();
        d0.z.d.m.checkNotNullExpressionValue(strings, "proto.strings");
        d0.e0.p.d.m0.f.o qualifiedNames = mVar.getQualifiedNames();
        d0.z.d.m.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        d0.e0.p.d.m0.f.z.d dVar = new d0.e0.p.d.m0.f.z.d(strings, qualifiedNames);
        this.r = dVar;
        this.f3506s = new x(mVar, dVar, aVar, new a());
        this.t = mVar;
    }

    public static final /* synthetic */ d0.e0.p.d.m0.l.b.e0.f access$getContainerSource$p(o oVar) {
        return oVar.q;
    }

    @Override // d0.e0.p.d.m0.l.b.n
    public /* bridge */ /* synthetic */ g getClassDataFinder() {
        return getClassDataFinder();
    }

    @Override // d0.e0.p.d.m0.c.e0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        d0.e0.p.d.m0.k.a0.i iVar = this.u;
        if (iVar != null) {
            return iVar;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("_memberScope");
        throw null;
    }

    public void initialize(j jVar) {
        d0.z.d.m.checkNotNullParameter(jVar, "components");
        d0.e0.p.d.m0.f.m mVar = this.t;
        if (mVar == null) {
            throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
        }
        this.t = null;
        d0.e0.p.d.m0.f.l lVar = mVar.getPackage();
        d0.z.d.m.checkNotNullExpressionValue(lVar, "proto.`package`");
        this.u = new d0.e0.p.d.m0.l.b.e0.i(this, lVar, this.r, this.p, this.q, jVar, new b());
    }

    @Override // d0.e0.p.d.m0.l.b.n
    public x getClassDataFinder() {
        return this.f3506s;
    }
}
