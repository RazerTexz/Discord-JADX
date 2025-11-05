package b.i.a.g.l;

/* compiled from: FadeModeEvaluators.java */
/* loaded from: classes3.dex */
public class b {
    public static final b.i.a.g.l.a a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final b.i.a.g.l.a f1631b = new C0128b();
    public static final b.i.a.g.l.a c = new c();
    public static final b.i.a.g.l.a d = new d();

    /* compiled from: FadeModeEvaluators.java */
    public static class a implements b.i.a.g.l.a {
        @Override // b.i.a.g.l.a
        public b.i.a.g.l.c a(float f, float f2, float f3) {
            return new b.i.a.g.l.c(255, k.g(0, 255, f2, f3, f), true);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$b, reason: collision with other inner class name */
    public static class C0128b implements b.i.a.g.l.a {
        @Override // b.i.a.g.l.a
        public b.i.a.g.l.c a(float f, float f2, float f3) {
            return b.i.a.g.l.c.a(k.g(255, 0, f2, f3, f), 255);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    public static class c implements b.i.a.g.l.a {
        @Override // b.i.a.g.l.a
        public b.i.a.g.l.c a(float f, float f2, float f3) {
            return b.i.a.g.l.c.a(k.g(255, 0, f2, f3, f), k.g(0, 255, f2, f3, f));
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    public static class d implements b.i.a.g.l.a {
        @Override // b.i.a.g.l.a
        public b.i.a.g.l.c a(float f, float f2, float f3) {
            float fA = b.d.b.a.a.a(f3, f2, 0.35f, f2);
            return b.i.a.g.l.c.a(k.g(255, 0, f2, fA, f), k.g(0, 255, fA, f3, f));
        }
    }
}
