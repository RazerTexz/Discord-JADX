package p007b.p225i.p226a.p341g.p353l;

import android.graphics.RectF;

/* compiled from: FitModeEvaluators.java */
/* renamed from: b.i.a.g.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public class FitModeEvaluators {

    /* renamed from: a */
    public static final FitModeEvaluator f11901a = new a();

    /* renamed from: b */
    public static final FitModeEvaluator f11902b = new b();

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.e$a */
    public static class a implements FitModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: a */
        public FitModeResult mo6183a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6191f = TransitionUtils3.m6191f(f4, f6, f2, f3, f, true);
            float f8 = fM6191f / f4;
            float f9 = fM6191f / f6;
            return new FitModeResult(f8, f9, fM6191f, f5 * f8, fM6191f, f7 * f9);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: b */
        public boolean mo6184b(FitModeResult fitModeResult) {
            return fitModeResult.f11906d > fitModeResult.f11908f;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: c */
        public void mo6185c(RectF rectF, float f, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f11908f - fitModeResult.f11906d) * f;
        }
    }

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.e$b */
    public static class b implements FitModeEvaluator {
        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: a */
        public FitModeResult mo6183a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6191f = TransitionUtils3.m6191f(f5, f7, f2, f3, f, true);
            float f8 = fM6191f / f5;
            float f9 = fM6191f / f7;
            return new FitModeResult(f8, f9, f4 * f8, fM6191f, f6 * f9, fM6191f);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: b */
        public boolean mo6184b(FitModeResult fitModeResult) {
            return fitModeResult.f11905c > fitModeResult.f11907e;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.FitModeEvaluator
        /* renamed from: c */
        public void mo6185c(RectF rectF, float f, FitModeResult fitModeResult) {
            float fAbs = (Math.abs(fitModeResult.f11907e - fitModeResult.f11905c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}
