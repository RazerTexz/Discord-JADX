package d0.e0.p.d.m0.e.a.g0;

import d0.e0.p.d.m0.b.k;
import d0.e0.p.d.m0.m.n;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import d0.z.d.y;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes3.dex */
public final class h extends b {
    public static final /* synthetic */ KProperty<Object>[] g = {a0.property1(new y(a0.getOrCreateKotlinClass(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    public final d0.e0.p.d.m0.m.j h;

    /* compiled from: JavaAnnotationMapper.kt */
    public static final class a extends o implements Function0<Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> invoke2() {
            d0.e0.p.d.m0.k.v.g<?> gVarMapJavaRetentionArgument$descriptors_jvm = d.a.mapJavaRetentionArgument$descriptors_jvm(h.this.e);
            Map<d0.e0.p.d.m0.g.e, ? extends d0.e0.p.d.m0.k.v.g<?>> mapMapOf = gVarMapJavaRetentionArgument$descriptors_jvm == null ? null : g0.mapOf(d0.o.to(c.a.getRETENTION_ANNOTATION_VALUE$descriptors_jvm(), gVarMapJavaRetentionArgument$descriptors_jvm));
            return mapMapOf != null ? mapMapOf : h0.emptyMap();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d0.e0.p.d.m0.e.a.k0.a aVar, d0.e0.p.d.m0.e.a.i0.g gVar) {
        super(gVar, aVar, k.a.D);
        m.checkNotNullParameter(aVar, "annotation");
        m.checkNotNullParameter(gVar, "c");
        this.h = gVar.getStorageManager().createLazyValue(new a());
    }

    @Override // d0.e0.p.d.m0.e.a.g0.b, d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        return (Map) n.getValue(this.h, this, (KProperty<?>) g[0]);
    }
}
