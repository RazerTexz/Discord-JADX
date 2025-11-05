package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.e.a.e0;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: specialBuiltinMembers.kt */
/* loaded from: classes3.dex */
public final class h extends e0 {
    public static final h m = new h();

    /* compiled from: specialBuiltinMembers.kt */
    public static final class a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
            return Boolean.valueOf(invoke2(bVar));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "it");
            return h.access$getHasErasedValueParametersInJava(h.this, bVar);
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    public static final class b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
            return Boolean.valueOf(invoke2(bVar));
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "it");
            return (bVar instanceof d0.e0.p.d.m0.c.x) && h.access$getHasErasedValueParametersInJava(h.this, bVar);
        }
    }

    public static final boolean access$getHasErasedValueParametersInJava(h hVar, d0.e0.p.d.m0.c.b bVar) {
        Objects.requireNonNull(hVar);
        return d0.t.u.contains(e0.a.getERASED_VALUE_PARAMETERS_SIGNATURES(), d0.e0.p.d.m0.e.b.u.computeJvmSignature(bVar));
    }

    public static final d0.e0.p.d.m0.c.x getOverriddenBuiltinFunctionWithErasedValueParametersInJava(d0.e0.p.d.m0.c.x xVar) {
        d0.z.d.m.checkNotNullParameter(xVar, "functionDescriptor");
        h hVar = m;
        d0.e0.p.d.m0.g.e name = xVar.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (hVar.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return (d0.e0.p.d.m0.c.x) d0.e0.p.d.m0.k.x.a.firstOverridden$default(xVar, false, hVar.new a(), 1, null);
        }
        return null;
    }

    public static final e0.b getSpecialSignatureInfo(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "<this>");
        e0.a aVar = e0.a;
        if (!aVar.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(bVar.getName())) {
            return null;
        }
        d0.e0.p.d.m0.c.b bVarFirstOverridden$default = d0.e0.p.d.m0.k.x.a.firstOverridden$default(bVar, false, m.new b(), 1, null);
        String strComputeJvmSignature = bVarFirstOverridden$default == null ? null : d0.e0.p.d.m0.e.b.u.computeJvmSignature(bVarFirstOverridden$default);
        if (strComputeJvmSignature == null) {
            return null;
        }
        return aVar.getSpecialSignatureInfo(strComputeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "<this>");
        return e0.a.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(eVar);
    }
}
