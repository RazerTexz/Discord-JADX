package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.c.g1.g;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;

/* compiled from: LazyJavaAnnotations.kt */
/* loaded from: classes3.dex */
public final class d implements d0.e0.p.d.m0.c.g1.g {
    public final g j;
    public final d0.e0.p.d.m0.e.a.k0.d k;
    public final boolean l;
    public final d0.e0.p.d.m0.m.i<d0.e0.p.d.m0.e.a.k0.a, d0.e0.p.d.m0.c.g1.c> m;

    /* compiled from: LazyJavaAnnotations.kt */
    public static final class a extends o implements Function1<d0.e0.p.d.m0.e.a.k0.a, d0.e0.p.d.m0.c.g1.c> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.g1.c invoke(d0.e0.p.d.m0.e.a.k0.a aVar) {
            return invoke2(aVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.c.g1.c invoke2(d0.e0.p.d.m0.e.a.k0.a aVar) {
            m.checkNotNullParameter(aVar, "annotation");
            return d0.e0.p.d.m0.e.a.g0.c.a.mapOrResolveJavaAnnotation(aVar, d.access$getC$p(d.this), d.access$getAreAnnotationsFreshlySupported$p(d.this));
        }
    }

    public d(g gVar, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2) {
        m.checkNotNullParameter(gVar, "c");
        m.checkNotNullParameter(dVar, "annotationOwner");
        this.j = gVar;
        this.k = dVar;
        this.l = z2;
        this.m = gVar.getComponents().getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    public static final /* synthetic */ boolean access$getAreAnnotationsFreshlySupported$p(d dVar) {
        return dVar.l;
    }

    public static final /* synthetic */ g access$getC$p(d dVar) {
        return dVar.j;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public d0.e0.p.d.m0.c.g1.c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        m.checkNotNullParameter(bVar, "fqName");
        d0.e0.p.d.m0.e.a.k0.a aVarFindAnnotation = this.k.findAnnotation(bVar);
        d0.e0.p.d.m0.c.g1.c cVarInvoke = aVarFindAnnotation == null ? null : this.m.invoke(aVarFindAnnotation);
        return cVarInvoke == null ? d0.e0.p.d.m0.e.a.g0.c.a.findMappedJavaAnnotation(bVar, this.k, this.j) : cVarInvoke;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return g.b.hasAnnotation(this, bVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return this.k.getAnnotations().isEmpty() && !this.k.isDeprecatedInJavaDoc();
    }

    @Override // java.lang.Iterable
    public Iterator<d0.e0.p.d.m0.c.g1.c> iterator() {
        return q.filterNotNull(q.plus((Sequence<? extends d0.e0.p.d.m0.c.g1.c>) q.map(u.asSequence(this.k.getAnnotations()), this.m), d0.e0.p.d.m0.e.a.g0.c.a.findMappedJavaAnnotation(k.a.u, this.k, this.j))).iterator();
    }

    public /* synthetic */ d(g gVar, d0.e0.p.d.m0.e.a.k0.d dVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVar, dVar, (i & 4) != 0 ? false : z2);
    }
}
