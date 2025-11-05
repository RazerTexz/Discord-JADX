package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.k.f;
import d0.e0.p.d.m0.k.k;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* compiled from: ErasedOverridabilityCondition.kt */
/* loaded from: classes3.dex */
public final class p implements d0.e0.p.d.m0.k.f {

    /* compiled from: ErasedOverridabilityCondition.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            k.d.a.values();
            a = new int[]{1, 0, 0};
        }
    }

    /* compiled from: ErasedOverridabilityCondition.kt */
    public static final class b extends d0.z.d.o implements Function1<c1, d0.e0.p.d.m0.n.c0> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c1 c1Var) {
            return invoke2(c1Var);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final d0.e0.p.d.m0.n.c0 invoke2(c1 c1Var) {
            return c1Var.getType();
        }
    }

    @Override // d0.e0.p.d.m0.k.f
    public f.a getContract() {
        return f.a.SUCCESS_ONLY;
    }

    @Override // d0.e0.p.d.m0.k.f
    public f.b isOverridable(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2, d0.e0.p.d.m0.c.e eVar) {
        boolean z2;
        d0.e0.p.d.m0.c.a aVarSubstitute;
        f.b bVar = f.b.UNKNOWN;
        d0.z.d.m.checkNotNullParameter(aVar, "superDescriptor");
        d0.z.d.m.checkNotNullParameter(aVar2, "subDescriptor");
        if (!(aVar2 instanceof d0.e0.p.d.m0.e.a.h0.f)) {
            return bVar;
        }
        d0.e0.p.d.m0.e.a.h0.f fVar = (d0.e0.p.d.m0.e.a.h0.f) aVar2;
        d0.z.d.m.checkNotNullExpressionValue(fVar.getTypeParameters(), "subDescriptor.typeParameters");
        if (!r1.isEmpty()) {
            return bVar;
        }
        k.d basicOverridabilityProblem = d0.e0.p.d.m0.k.k.getBasicOverridabilityProblem(aVar, aVar2);
        if ((basicOverridabilityProblem == null ? null : basicOverridabilityProblem.getResult()) != null) {
            return bVar;
        }
        List<c1> valueParameters = fVar.getValueParameters();
        d0.z.d.m.checkNotNullExpressionValue(valueParameters, "subDescriptor.valueParameters");
        Sequence map = d0.f0.q.map(d0.t.u.asSequence(valueParameters), b.j);
        d0.e0.p.d.m0.n.c0 returnType = fVar.getReturnType();
        d0.z.d.m.checkNotNull(returnType);
        Sequence sequencePlus = d0.f0.q.plus((Sequence<? extends d0.e0.p.d.m0.n.c0>) map, returnType);
        q0 extensionReceiverParameter = fVar.getExtensionReceiverParameter();
        Iterator it = d0.f0.q.plus(sequencePlus, (Iterable) d0.t.n.listOfNotNull(extensionReceiverParameter != null ? extensionReceiverParameter.getType() : null)).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            d0.e0.p.d.m0.n.c0 c0Var = (d0.e0.p.d.m0.n.c0) it.next();
            if ((c0Var.getArguments().isEmpty() ^ true) && !(c0Var.unwrap() instanceof d0.e0.p.d.m0.e.a.i0.m.g)) {
                z2 = true;
                break;
            }
        }
        if (z2 || (aVarSubstitute = aVar.substitute(d0.e0.p.d.m0.e.a.i0.m.f.f3341b.buildSubstitutor())) == null) {
            return bVar;
        }
        if (aVarSubstitute instanceof t0) {
            t0 t0Var = (t0) aVarSubstitute;
            d0.z.d.m.checkNotNullExpressionValue(t0Var.getTypeParameters(), "erasedSuper.typeParameters");
            if (!r1.isEmpty()) {
                aVarSubstitute = (t0) t0Var.newCopyBuilder().setTypeParameters(d0.t.n.emptyList()).build();
                d0.z.d.m.checkNotNull(aVarSubstitute);
            }
        }
        k.d.a result = d0.e0.p.d.m0.k.k.f3468b.isOverridableByWithoutExternalConditions(aVarSubstitute, aVar2, false).getResult();
        d0.z.d.m.checkNotNullExpressionValue(result, "DEFAULT.isOverridableByWithoutExternalConditions(erasedSuper, subDescriptor, false).result");
        return a.a[result.ordinal()] == 1 ? f.b.OVERRIDABLE : bVar;
    }
}
