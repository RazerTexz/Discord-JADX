package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p097l.PolystarShape;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.w.b.n, reason: use source file name */
/* JADX INFO: compiled from: PolystarContent.java */
/* JADX INFO: loaded from: classes.dex */
public class PolystarContent implements PathContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* JADX INFO: renamed from: b */
    public final String f2546b;

    /* JADX INFO: renamed from: c */
    public final LottieDrawable f2547c;

    /* JADX INFO: renamed from: d */
    public final PolystarShape.a f2548d;

    /* JADX INFO: renamed from: e */
    public final boolean f2549e;

    /* JADX INFO: renamed from: f */
    public final BaseKeyframeAnimation<?, Float> f2550f;

    /* JADX INFO: renamed from: g */
    public final BaseKeyframeAnimation<?, PointF> f2551g;

    /* JADX INFO: renamed from: h */
    public final BaseKeyframeAnimation<?, Float> f2552h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final BaseKeyframeAnimation<?, Float> f2553i;

    /* JADX INFO: renamed from: j */
    public final BaseKeyframeAnimation<?, Float> f2554j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final BaseKeyframeAnimation<?, Float> f2555k;

    /* JADX INFO: renamed from: l */
    public final BaseKeyframeAnimation<?, Float> f2556l;

    /* JADX INFO: renamed from: n */
    public boolean f2558n;

    /* JADX INFO: renamed from: a */
    public final Path f2545a = new Path();

    /* JADX INFO: renamed from: m */
    public CompoundTrimPathContent f2557m = new CompoundTrimPathContent();

    public PolystarContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, PolystarShape polystarShape) {
        this.f2547c = lottieDrawable;
        this.f2546b = polystarShape.f2780a;
        PolystarShape.a aVar = polystarShape.f2781b;
        this.f2548d = aVar;
        this.f2549e = polystarShape.f2789j;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a = polystarShape.f2782c.mo773a();
        this.f2550f = baseKeyframeAnimationMo773a;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a2 = polystarShape.f2783d.mo773a();
        this.f2551g = baseKeyframeAnimationMo773a2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a3 = polystarShape.f2784e.mo773a();
        this.f2552h = baseKeyframeAnimationMo773a3;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a4 = polystarShape.f2786g.mo773a();
        this.f2554j = baseKeyframeAnimationMo773a4;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a5 = polystarShape.f2788i.mo773a();
        this.f2556l = baseKeyframeAnimationMo773a5;
        PolystarShape.a aVar2 = PolystarShape.a.STAR;
        if (aVar == aVar2) {
            this.f2553i = polystarShape.f2785f.mo773a();
            this.f2555k = polystarShape.f2787h.mo773a();
        } else {
            this.f2553i = null;
            this.f2555k = null;
        }
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        baseLayer2.m777e(baseKeyframeAnimationMo773a3);
        baseLayer2.m777e(baseKeyframeAnimationMo773a4);
        baseLayer2.m777e(baseKeyframeAnimationMo773a5);
        if (aVar == aVar2) {
            baseLayer2.m777e(this.f2553i);
            baseLayer2.m777e(this.f2555k);
        }
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseKeyframeAnimationMo773a3.f2596a.add(this);
        baseKeyframeAnimationMo773a4.f2596a.add(this);
        baseKeyframeAnimationMo773a5.f2596a.add(this);
        if (aVar == aVar2) {
            this.f2553i.f2596a.add(this);
            this.f2555k.f2596a.add(this);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2558n = false;
        this.f2547c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.f2592c == 1) {
                    this.f2557m.f2481a.add(trimPathContent);
                    trimPathContent.f2591b.add(this);
                }
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.m656f(keyPath, i, list, keyPath2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2;
        if (t == LottieProperty.f2441s) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f2550f;
            LottieValueCallback<Float> lottieValueCallback2 = baseKeyframeAnimation3.f2600e;
            baseKeyframeAnimation3.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2442t) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation4 = this.f2552h;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation4.f2600e;
            baseKeyframeAnimation4.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2432j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = this.f2551g;
            LottieValueCallback<PointF> lottieValueCallback4 = baseKeyframeAnimation5.f2600e;
            baseKeyframeAnimation5.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2443u && (baseKeyframeAnimation2 = this.f2553i) != null) {
            LottieValueCallback<Float> lottieValueCallback5 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2444v) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation6 = this.f2554j;
            LottieValueCallback<Float> lottieValueCallback6 = baseKeyframeAnimation6.f2600e;
            baseKeyframeAnimation6.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2445w && (baseKeyframeAnimation = this.f2555k) != null) {
            LottieValueCallback<Float> lottieValueCallback7 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2446x) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation7 = this.f2556l;
            LottieValueCallback<Float> lottieValueCallback8 = baseKeyframeAnimation7.f2600e;
            baseKeyframeAnimation7.f2600e = lottieValueCallback;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2546b;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        float f;
        float f2;
        float fSin;
        double d;
        float fCos;
        float fM839a;
        float f3;
        float f4;
        float f5;
        float f6;
        double d2;
        float f7;
        float f8;
        double d3;
        double d4;
        double d5;
        if (this.f2558n) {
            return this.f2545a;
        }
        this.f2545a.reset();
        if (this.f2549e) {
            this.f2558n = true;
            return this.f2545a;
        }
        int iOrdinal = this.f2548d.ordinal();
        if (iOrdinal == 0) {
            float fFloatValue = this.f2550f.mo727e().floatValue();
            double radians = Math.toRadians((this.f2552h != null ? r2.mo727e().floatValue() : 0.0d) - 90.0d);
            double d6 = fFloatValue;
            float f9 = (float) (6.283185307179586d / d6);
            float f10 = f9 / 2.0f;
            float f11 = fFloatValue - ((int) fFloatValue);
            if (f11 != 0.0f) {
                radians += (double) ((1.0f - f11) * f10);
            }
            float fFloatValue2 = this.f2554j.mo727e().floatValue();
            float fFloatValue3 = this.f2553i.mo727e().floatValue();
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f2555k;
            float fFloatValue4 = baseKeyframeAnimation != null ? baseKeyframeAnimation.mo727e().floatValue() / 100.0f : 0.0f;
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = this.f2556l;
            float fFloatValue5 = baseKeyframeAnimation2 != null ? baseKeyframeAnimation2.mo727e().floatValue() / 100.0f : 0.0f;
            if (f11 != 0.0f) {
                fM839a = outline.m839a(fFloatValue2, fFloatValue3, f11, fFloatValue3);
                double d7 = fM839a;
                f = fFloatValue3;
                f2 = fFloatValue4;
                fCos = (float) (Math.cos(radians) * d7);
                fSin = (float) (d7 * Math.sin(radians));
                this.f2545a.moveTo(fCos, fSin);
                d = radians + ((double) ((f9 * f11) / 2.0f));
            } else {
                f = fFloatValue3;
                f2 = fFloatValue4;
                double d8 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d8);
                fSin = (float) (Math.sin(radians) * d8);
                this.f2545a.moveTo(fCos2, fSin);
                d = radians + ((double) f10);
                fCos = fCos2;
                fM839a = 0.0f;
            }
            double dCeil = Math.ceil(d6) * 2.0d;
            int i = 0;
            boolean z2 = false;
            while (true) {
                double d9 = i;
                if (d9 >= dCeil) {
                    break;
                }
                float f12 = z2 ? fFloatValue2 : f;
                if (fM839a == 0.0f || d9 != dCeil - 2.0d) {
                    f3 = f9;
                    f4 = f10;
                } else {
                    f3 = f9;
                    f4 = (f9 * f11) / 2.0f;
                }
                if (fM839a == 0.0f || d9 != dCeil - 1.0d) {
                    f5 = fM839a;
                    fM839a = f12;
                    f6 = f4;
                } else {
                    f6 = f4;
                    f5 = fM839a;
                }
                double d10 = fM839a;
                float fCos3 = (float) (Math.cos(d) * d10);
                float fSin2 = (float) (d10 * Math.sin(d));
                if (f2 == 0.0f && fFloatValue5 == 0.0f) {
                    this.f2545a.lineTo(fCos3, fSin2);
                    f7 = fSin2;
                    d2 = d;
                    f8 = fFloatValue5;
                } else {
                    d2 = d;
                    float f13 = fSin;
                    double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin3 = (float) Math.sin(dAtan2);
                    f7 = fSin2;
                    f8 = fFloatValue5;
                    double dAtan22 = (float) (Math.atan2(fSin2, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin4 = (float) Math.sin(dAtan22);
                    float f14 = z2 ? f2 : f8;
                    float f15 = z2 ? f8 : f2;
                    float f16 = (z2 ? f : fFloatValue2) * f14 * 0.47829f;
                    float f17 = fCos4 * f16;
                    float f18 = f16 * fSin3;
                    float f19 = (z2 ? fFloatValue2 : f) * f15 * 0.47829f;
                    float f20 = fCos5 * f19;
                    float f21 = f19 * fSin4;
                    if (f11 != 0.0f) {
                        if (i == 0) {
                            f17 *= f11;
                            f18 *= f11;
                        } else if (d9 == dCeil - 1.0d) {
                            f20 *= f11;
                            f21 *= f11;
                        }
                    }
                    this.f2545a.cubicTo(fCos - f17, f13 - f18, fCos3 + f20, f7 + f21, fCos3, f7);
                }
                d = d2 + ((double) f6);
                z2 = !z2;
                i++;
                fCos = fCos3;
                fM839a = f5;
                f9 = f3;
                fSin = f7;
                fFloatValue5 = f8;
            }
            PointF pointFMo727e = this.f2551g.mo727e();
            this.f2545a.offset(pointFMo727e.x, pointFMo727e.y);
            this.f2545a.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(this.f2550f.mo727e().floatValue());
            double radians2 = Math.toRadians((this.f2552h != null ? r2.mo727e().floatValue() : 0.0d) - 90.0d);
            double d11 = iFloor;
            float fFloatValue6 = this.f2556l.mo727e().floatValue() / 100.0f;
            float fFloatValue7 = this.f2554j.mo727e().floatValue();
            double d12 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d12);
            float fSin5 = (float) (Math.sin(radians2) * d12);
            this.f2545a.moveTo(fCos6, fSin5);
            double d13 = (float) (6.283185307179586d / d11);
            double d14 = radians2 + d13;
            double dCeil2 = Math.ceil(d11);
            int i2 = 0;
            while (i2 < dCeil2) {
                float fCos7 = (float) (Math.cos(d14) * d12);
                double d15 = dCeil2;
                float fSin6 = (float) (Math.sin(d14) * d12);
                if (fFloatValue6 != 0.0f) {
                    d4 = d12;
                    d3 = d14;
                    double dAtan23 = (float) (Math.atan2(fSin5, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan23);
                    float fSin7 = (float) Math.sin(dAtan23);
                    d5 = d13;
                    double dAtan24 = (float) (Math.atan2(fSin6, fCos7) - 1.5707963267948966d);
                    float f22 = fFloatValue7 * fFloatValue6 * 0.25f;
                    this.f2545a.cubicTo(fCos6 - (fCos8 * f22), fSin5 - (fSin7 * f22), fCos7 + (((float) Math.cos(dAtan24)) * f22), fSin6 + (f22 * ((float) Math.sin(dAtan24))), fCos7, fSin6);
                } else {
                    d3 = d14;
                    d4 = d12;
                    d5 = d13;
                    this.f2545a.lineTo(fCos7, fSin6);
                }
                d14 = d3 + d5;
                i2++;
                fSin5 = fSin6;
                fCos6 = fCos7;
                dCeil2 = d15;
                d12 = d4;
                d13 = d5;
            }
            PointF pointFMo727e2 = this.f2551g.mo727e();
            this.f2545a.offset(pointFMo727e2.x, pointFMo727e2.y);
            this.f2545a.close();
        }
        this.f2545a.close();
        this.f2557m.m715a(this.f2545a);
        this.f2558n = true;
        return this.f2545a;
    }
}
