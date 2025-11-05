package d0.e0.p.d.m0.c.g1;

/* compiled from: Annotations.kt */
/* loaded from: classes3.dex */
public final class i {
    public static final g composeAnnotations(g gVar, g gVar2) {
        d0.z.d.m.checkNotNullParameter(gVar, "first");
        d0.z.d.m.checkNotNullParameter(gVar2, "second");
        return gVar.isEmpty() ? gVar2 : gVar2.isEmpty() ? gVar : new k(gVar, gVar2);
    }
}
