package p007b.p225i.p226a.p341g.p353l.p354l;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

/* compiled from: FitModeEvaluators.java */
@RequiresApi(21)
/* renamed from: b.i.a.g.l.l.e, reason: use source file name */
/* loaded from: classes3.dex */
public class FitModeEvaluators2 {

    /* renamed from: a */
    public static final FitModeEvaluator2 f11923a = new a();

    /* renamed from: b */
    public static final FitModeEvaluator2 f11924b = new b();

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.e$a */
    public static class a implements FitModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: a */
        public FitModeResult2 mo6197a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6205f = TransitionUtils5.m6205f(f4, f6, f2, f3, f, true);
            float f8 = fM6205f / f4;
            float f9 = fM6205f / f6;
            return new FitModeResult2(f8, f9, fM6205f, f5 * f8, fM6205f, f7 * f9);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: b */
        public boolean mo6198b(FitModeResult2 fitModeResult2) {
            return fitModeResult2.f11928d > fitModeResult2.f11930f;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: c */
        public void mo6199c(RectF rectF, float f, FitModeResult2 fitModeResult2) {
            rectF.bottom -= Math.abs(fitModeResult2.f11930f - fitModeResult2.f11928d) * f;
        }
    }

    /* compiled from: FitModeEvaluators.java */
    /* renamed from: b.i.a.g.l.l.e$b */
    public static class b implements FitModeEvaluator2 {
        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: a */
        public FitModeResult2 mo6197a(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
            float fM6205f = TransitionUtils5.m6205f(f5, f7, f2, f3, f, true);
            float f8 = fM6205f / f5;
            float f9 = fM6205f / f7;
            return new FitModeResult2(f8, f9, f4 * f8, fM6205f, f6 * f9, fM6205f);
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: b */
        public boolean mo6198b(FitModeResult2 fitModeResult2) {
            return fitModeResult2.f11927c > fitModeResult2.f11929e;
        }

        @Override // p007b.p225i.p226a.p341g.p353l.p354l.FitModeEvaluator2
        /* renamed from: c */
        public void mo6199c(RectF rectF, float f, FitModeResult2 fitModeResult2) {
            float fAbs = (Math.abs(fitModeResult2.f11929e - fitModeResult2.f11927c) / 2.0f) * f;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }
    }
}
