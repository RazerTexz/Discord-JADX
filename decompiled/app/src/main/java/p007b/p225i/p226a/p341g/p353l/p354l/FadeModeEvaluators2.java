package p007b.p225i.p226a.p341g.p353l.p354l;

import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: FadeModeEvaluators.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.l.l.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FadeModeEvaluators2 {

    /* renamed from: a */
    public static final FadeModeEvaluator2 f11916a = new a();

    /* renamed from: b */
    public static final FadeModeEvaluator2 f11917b = new b();

    /* renamed from: c */
    public static final FadeModeEvaluator2 f11918c = new c();

    /* renamed from: d */
    public static final FadeModeEvaluator2 f11919d = new d();

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$a */
    public static class a implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return new FadeModeResult2(255, TransitionUtils5.m6206g(0, 255, f2, f3, f), true);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$b */
    public static class b implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, f3, f), 255);
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$c */
    public static class c implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, f3, f), TransitionUtils5.m6206g(0, 255, f2, f3, f));
        }
    }

    /* compiled from: FadeModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.b$d */
    public static class d implements FadeModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FadeModeEvaluator2
        /* renamed from: a */
        public FadeModeResult2 mo6195a(float f, float f2, float f3) {
            float fM839a = outline.m839a(f3, f2, 0.35f, f2);
            return FadeModeResult2.m6196a(TransitionUtils5.m6206g(255, 0, f2, fM839a, f), TransitionUtils5.m6206g(0, 255, fM839a, f3, f));
        }
    }
}
