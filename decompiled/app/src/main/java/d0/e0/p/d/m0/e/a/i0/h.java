package d0.e0.p.d.m0.e.a.i0;

import d0.e0.p.d.m0.c.m;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.e.a.i0.l.s;
import d0.e0.p.d.m0.e.a.k0.y;
import d0.e0.p.d.m0.e.a.k0.z;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: resolvers.kt */
/* loaded from: classes3.dex */
public final class h implements k {
    public final g a;

    /* renamed from: b, reason: collision with root package name */
    public final m f3324b;
    public final int c;
    public final Map<y, Integer> d;
    public final d0.e0.p.d.m0.m.i<y, s> e;

    /* compiled from: resolvers.kt */
    public static final class a extends o implements Function1<y, s> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ s invoke(y yVar) {
            return invoke2(yVar);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final s invoke2(y yVar) {
            d0.z.d.m.checkNotNullParameter(yVar, "typeParameter");
            Integer num = (Integer) h.access$getTypeParameters$p(h.this).get(yVar);
            if (num == null) {
                return null;
            }
            h hVar = h.this;
            return new s(d0.e0.p.d.m0.e.a.i0.a.copyWithNewDefaultTypeQualifiers(d0.e0.p.d.m0.e.a.i0.a.child(h.access$getC$p(hVar), hVar), h.access$getContainingDeclaration$p(hVar).getAnnotations()), yVar, h.access$getTypeParametersIndexOffset$p(hVar) + num.intValue(), h.access$getContainingDeclaration$p(hVar));
        }
    }

    public h(g gVar, m mVar, z zVar, int i) {
        d0.z.d.m.checkNotNullParameter(gVar, "c");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(zVar, "typeParameterOwner");
        this.a = gVar;
        this.f3324b = mVar;
        this.c = i;
        this.d = d0.e0.p.d.m0.p.a.mapToIndex(zVar.getTypeParameters());
        this.e = gVar.getStorageManager().createMemoizedFunctionWithNullableValues(new a());
    }

    public static final /* synthetic */ g access$getC$p(h hVar) {
        return hVar.a;
    }

    public static final /* synthetic */ m access$getContainingDeclaration$p(h hVar) {
        return hVar.f3324b;
    }

    public static final /* synthetic */ Map access$getTypeParameters$p(h hVar) {
        return hVar.d;
    }

    public static final /* synthetic */ int access$getTypeParametersIndexOffset$p(h hVar) {
        return hVar.c;
    }

    @Override // d0.e0.p.d.m0.e.a.i0.k
    public z0 resolveTypeParameter(y yVar) {
        d0.z.d.m.checkNotNullParameter(yVar, "javaTypeParameter");
        s sVarInvoke = this.e.invoke(yVar);
        return sVarInvoke == null ? this.a.getTypeParameterResolver().resolveTypeParameter(yVar) : sVarInvoke;
    }
}
