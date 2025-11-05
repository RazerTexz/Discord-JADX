package d0.e0.p.d.m0.c.g1;

import d0.f0.q;
import d0.t.u;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public final class k implements g {
    public final List<g> j;

    /* compiled from: Annotations.kt */
    public static final class a extends o implements Function1<g, c> {
        public final /* synthetic */ d0.e0.p.d.m0.g.b $fqName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d0.e0.p.d.m0.g.b bVar) {
            super(1);
            this.$fqName = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ c invoke(g gVar) {
            return invoke2(gVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final c invoke2(g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "it");
            return gVar.findAnnotation(this.$fqName);
        }
    }

    /* compiled from: Annotations.kt */
    public static final class b extends o implements Function1<g, Sequence<? extends c>> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Sequence<? extends c> invoke(g gVar) {
            return invoke2(gVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Sequence<c> invoke2(g gVar) {
            d0.z.d.m.checkNotNullParameter(gVar, "it");
            return u.asSequence(gVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(List<? extends g> list) {
        d0.z.d.m.checkNotNullParameter(list, "delegates");
        this.j = list;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public c findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        return (c) q.firstOrNull(q.mapNotNull(u.asSequence(this.j), new a(bVar)));
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean hasAnnotation(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        Iterator it = u.asSequence(this.j).iterator();
        while (it.hasNext()) {
            if (((g) it.next()).hasAnnotation(bVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        List<g> list = this.j;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (!((g) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator<c> iterator() {
        return q.flatMap(u.asSequence(this.j), b.j).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(g... gVarArr) {
        this((List<? extends g>) d0.t.k.toList(gVarArr));
        d0.z.d.m.checkNotNullParameter(gVarArr, "delegates");
    }
}
