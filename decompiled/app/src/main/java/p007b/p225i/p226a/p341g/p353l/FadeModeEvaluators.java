package p007b.p225i.p226a.p341g.p353l;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: FadeModeEvaluators.java */
/* renamed from: b.i.a.g.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FadeModeEvaluators {

    /* renamed from: a */
    public static final FadeModeEvaluator f11894a = new a();

    /* renamed from: b */
    public static final FadeModeEvaluator f11895b = new b();

    /* renamed from: c */
    public static final FadeModeEvaluator f11896c = new c();

    /* renamed from: d */
    public static final FadeModeEvaluator f11897d = new d();

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$a */
    public static class a implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return new FadeModeResult(255, TransitionUtils3.m6192g(0, 255, f2, f3, f), true);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$b */
    public static class b implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, f3, f), 255);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$c */
    public static class c implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, f3, f), TransitionUtils3.m6192g(0, 255, f2, f3, f));
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.b$d */
    public static class d implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            float fM839a = outline.m839a(f3, f2, 0.35f, f2);
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, fM839a, f), TransitionUtils3.m6192g(0, 255, fM839a, f3, f));
        }
    }
}
