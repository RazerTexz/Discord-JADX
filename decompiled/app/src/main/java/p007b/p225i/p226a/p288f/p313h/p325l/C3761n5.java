package p007b.p225i.p226a.p288f.p313h.p325l;

/* JADX INFO: renamed from: b.i.a.f.h.l.n5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3761n5 extends AbstractC3748m5 {
    public C3761n5(C3735l5 c3735l5) {
        super(null);
    }

    /* JADX INFO: renamed from: c */
    public static <E> InterfaceC3597b5<E> m5137c(Object obj, long j) {
        return (InterfaceC3597b5) C3711j7.m4993r(obj, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [b.i.a.f.h.l.b5, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: a */
    public final <E> void mo5070a(Object obj, Object obj2, long j) {
        InterfaceC3597b5 interfaceC3597b5M5137c = m5137c(obj, j);
        ?? M5137c = m5137c(obj2, j);
        int size = interfaceC3597b5M5137c.size();
        int size2 = M5137c.size();
        ?? r0 = interfaceC3597b5M5137c;
        r0 = interfaceC3597b5M5137c;
        if (size > 0 && size2 > 0) {
            boolean zMo4568a = interfaceC3597b5M5137c.mo4568a();
            ?? Mo4569f = interfaceC3597b5M5137c;
            if (!zMo4568a) {
                Mo4569f = interfaceC3597b5M5137c.mo4569f(size2 + size);
            }
            Mo4569f.addAll(M5137c);
            r0 = Mo4569f;
        }
        if (size > 0) {
            M5137c = r0;
        }
        C3711j7.m4981f(obj, j, M5137c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3748m5
    /* JADX INFO: renamed from: b */
    public final void mo5071b(Object obj, long j) {
        m5137c(obj, j).mo4570g0();
    }
}
