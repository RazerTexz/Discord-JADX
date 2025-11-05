package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.m.f;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.f0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.l;
import d0.e0.p.d.m0.n.w0;
import d0.e0.p.d.m0.n.y0;
import d0.e0.p.d.m0.n.z;
import d0.e0.p.d.m0.n.z0;
import d0.t.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class d {

    /* compiled from: CapturedTypeConstructor.kt */
    public static final class a extends o implements Function0<c0> {
        public final /* synthetic */ w0 $this_createCapturedIfNeeded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w0 w0Var) {
            super(0);
            this.$this_createCapturedIfNeeded = w0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ c0 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final c0 invoke() {
            c0 type = this.$this_createCapturedIfNeeded.getType();
            m.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* compiled from: CapturedTypeConstructor.kt */
    public static final class b extends l {
        public final /* synthetic */ boolean c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(boolean z2, z0 z0Var) {
            super(z0Var);
            this.c = z2;
        }

        @Override // d0.e0.p.d.m0.n.z0
        public boolean approximateContravariantCapturedTypes() {
            return this.c;
        }

        @Override // d0.e0.p.d.m0.n.l, d0.e0.p.d.m0.n.z0
        public w0 get(c0 c0Var) {
            m.checkNotNullParameter(c0Var, "key");
            w0 w0Var = super.get(c0Var);
            if (w0Var == null) {
                return null;
            }
            h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
            return d.access$createCapturedIfNeeded(w0Var, declarationDescriptor instanceof d0.e0.p.d.m0.c.z0 ? (d0.e0.p.d.m0.c.z0) declarationDescriptor : null);
        }
    }

    public static final w0 a(w0 w0Var, d0.e0.p.d.m0.c.z0 z0Var) {
        if (z0Var == null || w0Var.getProjectionKind() == j1.INVARIANT) {
            return w0Var;
        }
        if (z0Var.getVariance() != w0Var.getProjectionKind()) {
            return new y0(createCapturedType(w0Var));
        }
        if (!w0Var.isStarProjection()) {
            return new y0(w0Var.getType());
        }
        d0.e0.p.d.m0.m.o oVar = f.f3514b;
        m.checkNotNullExpressionValue(oVar, "NO_LOCKS");
        return new y0(new f0(oVar, new a(w0Var)));
    }

    public static final /* synthetic */ w0 access$createCapturedIfNeeded(w0 w0Var, d0.e0.p.d.m0.c.z0 z0Var) {
        return a(w0Var, z0Var);
    }

    public static final c0 createCapturedType(w0 w0Var) {
        m.checkNotNullParameter(w0Var, "typeProjection");
        return new d0.e0.p.d.m0.k.u.a.a(w0Var, null, false, null, 14, null);
    }

    public static final boolean isCaptured(c0 c0Var) {
        m.checkNotNullParameter(c0Var, "<this>");
        return c0Var.getConstructor() instanceof d0.e0.p.d.m0.k.u.a.b;
    }

    public static final z0 wrapWithCapturingSubstitution(z0 z0Var, boolean z2) {
        m.checkNotNullParameter(z0Var, "<this>");
        if (!(z0Var instanceof z)) {
            return new b(z2, z0Var);
        }
        z zVar = (z) z0Var;
        d0.e0.p.d.m0.c.z0[] parameters = zVar.getParameters();
        List<Pair> listZip = k.zip(zVar.getArguments(), zVar.getParameters());
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(listZip, 10));
        for (Pair pair : listZip) {
            arrayList.add(a((w0) pair.getFirst(), (d0.e0.p.d.m0.c.z0) pair.getSecond()));
        }
        Object[] array = arrayList.toArray(new w0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return new z(parameters, (w0[]) array, z2);
    }

    public static /* synthetic */ z0 wrapWithCapturingSubstitution$default(z0 z0Var, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return wrapWithCapturingSubstitution(z0Var, z2);
    }
}
