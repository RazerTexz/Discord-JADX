package p007b.p225i.p226a.p341g.p353l;

import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.g.l.b, reason: use source file name */
/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
public class FadeModeEvaluators {

    /* JADX INFO: renamed from: a */
    public static final FadeModeEvaluator f11894a = new a();

    /* JADX INFO: renamed from: b */
    public static final FadeModeEvaluator f11895b = new b();

    /* JADX INFO: renamed from: c */
    public static final FadeModeEvaluator f11896c = new c();

    /* JADX INFO: renamed from: d */
    public static final FadeModeEvaluator f11897d = new d();

    /* JADX INFO: renamed from: b.i.a.g.l.b$a */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class a implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* JADX INFO: renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return new FadeModeResult(255, TransitionUtils3.m6192g(0, 255, f2, f3, f), true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$b */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class b implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* JADX INFO: renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, f3, f), 255);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$c */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class c implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* JADX INFO: renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, f3, f), TransitionUtils3.m6192g(0, 255, f2, f3, f));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.b$d */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class d implements FadeModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FadeModeEvaluator
        /* JADX INFO: renamed from: a */
        public FadeModeResult mo6181a(float f, float f2, float f3) {
            float fM839a = outline.m839a(f3, f2, 0.35f, f2);
            return FadeModeResult.m6182a(TransitionUtils3.m6192g(255, 0, f2, fM839a, f), TransitionUtils3.m6192g(0, 255, fM839a, f3, f));
        }
    }
}
