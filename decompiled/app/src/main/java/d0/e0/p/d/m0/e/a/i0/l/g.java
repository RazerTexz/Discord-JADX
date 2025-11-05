package d0.e0.p.d.m0.e.a.i0.l;

import kotlin.jvm.functions.Function1;

/* compiled from: LazyJavaClassMemberScope.kt */
/* loaded from: classes3.dex */
public final class g extends d0.z.d.o implements Function1<d0.e0.p.d.m0.e.a.k0.q, Boolean> {
    public static final g j = new g();

    public g() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.e.a.k0.q qVar) {
        return Boolean.valueOf(invoke2(qVar));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.e.a.k0.q qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "it");
        return !qVar.isStatic();
    }
}
