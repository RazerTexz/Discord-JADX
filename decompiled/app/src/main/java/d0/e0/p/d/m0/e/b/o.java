package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.e.b.n;

/* compiled from: KotlinClassFinder.kt */
/* loaded from: classes3.dex */
public final class o {
    public static final p findKotlinClass(n nVar, d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<this>");
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        n.a aVarFindKotlinClassOrContent = nVar.findKotlinClassOrContent(aVar);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }

    public static final p findKotlinClass(n nVar, d0.e0.p.d.m0.e.a.k0.g gVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "<this>");
        d0.z.d.m.checkNotNullParameter(gVar, "javaClass");
        n.a aVarFindKotlinClassOrContent = nVar.findKotlinClassOrContent(gVar);
        if (aVarFindKotlinClassOrContent == null) {
            return null;
        }
        return aVarFindKotlinClassOrContent.toKotlinJvmBinaryClass();
    }
}
