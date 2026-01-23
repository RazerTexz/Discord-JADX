package p007b.p225i.p226a.p341g.p353l.p354l;

import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.g.l.l.b, reason: use source file name */
/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class FadeModeEvaluators2 {

    /* JADX INFO: renamed from: a */
    public static final FadeModeEvaluator2 f11916a = new a();

    /* JADX INFO: renamed from: b */
    public static final FadeModeEvaluator2 f11917b = new b();

    /* JADX INFO: renamed from: c */
    public static final FadeModeEvaluator2 f11918c = new c();

    /* JADX INFO: renamed from: d */
    public static final FadeModeEvaluator2 f11919d = new d();

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$a */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class a implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* JADX INFO: renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return new FadeModeResult2(255, TransitionUtils5.m6206g(0, 255, f2, f3, f), true);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$b */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class b implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* JADX INFO: renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, f3, f), 255);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$c */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class c implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* JADX INFO: renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, f3, f), TransitionUtils5.m6206g(0, 255, f2, f3, f));
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.l.l.b$d */
    /* JADX INFO: compiled from: FadeModeEvaluators.java */
    public static class d implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* JADX INFO: renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            float fM839a = outline.m839a(f3, f2, 0.35f, f2);
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, fM839a, f), TransitionUtils5.m6206g(0, 255, fM839a, f3, f));
        }
    }
}
