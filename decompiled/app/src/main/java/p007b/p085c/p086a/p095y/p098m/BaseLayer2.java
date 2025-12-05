package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.PerformanceTracker;
import p007b.p085c.p086a.p089b0.MeanCalculator;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p090c0.ScaleXY;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p092b.Content2;
import p007b.p085c.p086a.p091w.p092b.DrawingContent;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.FloatKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.MaskKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.TransformKeyframeAnimation;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.KeyPathElement;
import p007b.p085c.p086a.p095y.p096k.AnimatableTransform;
import p007b.p085c.p086a.p095y.p097l.Mask;
import p007b.p085c.p086a.p095y.p097l.ShapeData;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: BaseLayer.java */
/* renamed from: b.c.a.y.m.b, reason: use source file name */
/* loaded from: classes.dex */
public abstract class BaseLayer2 implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElement {

    /* renamed from: a */
    public final Path f2836a = new Path();

    /* renamed from: b */
    public final Matrix f2837b = new Matrix();

    /* renamed from: c */
    public final Paint f2838c = new LPaint(1);

    /* renamed from: d */
    public final Paint f2839d = new LPaint(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e */
    public final Paint f2840e = new LPaint(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: f */
    public final Paint f2841f;

    /* renamed from: g */
    public final Paint f2842g;

    /* renamed from: h */
    public final RectF f2843h;

    /* renamed from: i */
    public final RectF f2844i;

    /* renamed from: j */
    public final RectF f2845j;

    /* renamed from: k */
    public final RectF f2846k;

    /* renamed from: l */
    public final String f2847l;

    /* renamed from: m */
    public final Matrix f2848m;

    /* renamed from: n */
    public final LottieDrawable f2849n;

    /* renamed from: o */
    public final Layer2 f2850o;

    /* renamed from: p */
    @Nullable
    public MaskKeyframeAnimation f2851p;

    /* renamed from: q */
    @Nullable
    public FloatKeyframeAnimation f2852q;

    /* renamed from: r */
    @Nullable
    public BaseLayer2 f2853r;

    /* renamed from: s */
    @Nullable
    public BaseLayer2 f2854s;

    /* renamed from: t */
    public List<BaseLayer2> f2855t;

    /* renamed from: u */
    public final List<BaseKeyframeAnimation<?, ?>> f2856u;

    /* renamed from: v */
    public final TransformKeyframeAnimation f2857v;

    /* renamed from: w */
    public boolean f2858w;

    public BaseLayer2(LottieDrawable lottieDrawable, Layer2 layer2) {
        LPaint lPaint = new LPaint(1);
        this.f2841f = lPaint;
        this.f2842g = new LPaint(PorterDuff.Mode.CLEAR);
        this.f2843h = new RectF();
        this.f2844i = new RectF();
        this.f2845j = new RectF();
        this.f2846k = new RectF();
        this.f2848m = new Matrix();
        this.f2856u = new ArrayList();
        this.f2858w = true;
        this.f2849n = lottieDrawable;
        this.f2850o = layer2;
        this.f2847l = outline.m822J(new StringBuilder(), layer2.f2870c, "#draw");
        if (layer2.f2888u == 3) {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            lPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        AnimatableTransform animatableTransform = layer2.f2876i;
        Objects.requireNonNull(animatableTransform);
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.f2857v = transformKeyframeAnimation;
        transformKeyframeAnimation.m744b(this);
        List<Mask> list = layer2.f2875h;
        if (list != null && !list.isEmpty()) {
            MaskKeyframeAnimation maskKeyframeAnimation = new MaskKeyframeAnimation(layer2.f2875h);
            this.f2851p = maskKeyframeAnimation;
            Iterator<BaseKeyframeAnimation<ShapeData, Path>> it = maskKeyframeAnimation.f2611a.iterator();
            while (it.hasNext()) {
                it.next().f2596a.add(this);
            }
            for (BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation : this.f2851p.f2612b) {
                m777e(baseKeyframeAnimation);
                baseKeyframeAnimation.f2596a.add(this);
            }
        }
        if (this.f2850o.f2887t.isEmpty()) {
            m786p(true);
            return;
        }
        FloatKeyframeAnimation floatKeyframeAnimation = new FloatKeyframeAnimation(this.f2850o.f2887t);
        this.f2852q = floatKeyframeAnimation;
        floatKeyframeAnimation.f2597b = true;
        floatKeyframeAnimation.f2596a.add(new BaseLayer(this));
        m786p(this.f2852q.mo727e().floatValue() == 1.0f);
        m777e(this.f2852q);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        this.f2849n.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        if (keyPath.m770e(this.f2850o.f2870c, i)) {
            if (!"__container".equals(this.f2850o.f2870c)) {
                keyPath2 = keyPath2.m766a(this.f2850o.f2870c);
                if (keyPath.m768c(this.f2850o.f2870c, i)) {
                    list.add(keyPath2.m772g(this));
                }
            }
            if (keyPath.m771f(this.f2850o.f2870c, i)) {
                mo784n(keyPath, keyPath.m769d(this.f2850o.f2870c, i) + i, list, keyPath2);
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    @CallSuper
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2843h.set(0.0f, 0.0f, 0.0f, 0.0f);
        m778h();
        this.f2848m.set(matrix);
        if (z2) {
            List<BaseLayer2> list = this.f2855t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2848m.preConcat(this.f2855t.get(size).f2857v.m747e());
                }
            } else {
                BaseLayer2 baseLayer2 = this.f2854s;
                if (baseLayer2 != null) {
                    this.f2848m.preConcat(baseLayer2.f2857v.m747e());
                }
            }
        }
        this.f2848m.preConcat(this.f2857v.m747e());
    }

    /* renamed from: e */
    public void m777e(@Nullable BaseKeyframeAnimation<?, ?> baseKeyframeAnimation) {
        if (baseKeyframeAnimation == null) {
            return;
        }
        this.f2856u.add(baseKeyframeAnimation);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x03aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024b  */
    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        String str = this.f2847l;
        if (!this.f2858w || this.f2850o.f2889v) {
            L.m663a(str);
            return;
        }
        m778h();
        this.f2837b.reset();
        this.f2837b.set(matrix);
        int i2 = 1;
        for (int size = this.f2855t.size() - 1; size >= 0; size--) {
            this.f2837b.preConcat(this.f2855t.get(size).f2857v.m747e());
        }
        L.m663a("Layer#parentMatrix");
        int iIntValue = (int) ((((i / 255.0f) * (this.f2857v.f2636j == null ? 100 : r3.mo727e().intValue())) / 100.0f) * 255.0f);
        float f = 0.0f;
        if (!m782l() && !m781k()) {
            this.f2837b.preConcat(this.f2857v.m747e());
            mo780j(canvas, this.f2837b, iIntValue);
            L.m663a("Layer#drawLayer");
            L.m663a(this.f2847l);
            m783m(0.0f);
            return;
        }
        boolean z3 = false;
        mo712d(this.f2843h, this.f2837b, false);
        RectF rectF = this.f2843h;
        int i3 = 3;
        if (m782l() && this.f2850o.f2888u != 3) {
            this.f2845j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f2853r.mo712d(this.f2845j, matrix, true);
            if (!rectF.intersect(this.f2845j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.f2837b.preConcat(this.f2857v.m747e());
        RectF rectF2 = this.f2843h;
        Matrix matrix2 = this.f2837b;
        this.f2844i.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (m781k()) {
            int size2 = this.f2851p.f2613c.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    Mask mask = this.f2851p.f2613c.get(i5);
                    this.f2836a.set(this.f2851p.f2611a.get(i5).mo727e());
                    this.f2836a.transform(matrix2);
                    int iM758h = C1563b.m758h(mask.f2767a);
                    if (iM758h == 0) {
                        if (mask.f2770d) {
                            break;
                        }
                        this.f2836a.computeBounds(this.f2846k, z3);
                        if (i5 != 0) {
                            this.f2844i.set(this.f2846k);
                        } else {
                            RectF rectF3 = this.f2844i;
                            rectF3.set(Math.min(rectF3.left, this.f2846k.left), Math.min(this.f2844i.top, this.f2846k.top), Math.max(this.f2844i.right, this.f2846k.right), Math.max(this.f2844i.bottom, this.f2846k.bottom));
                        }
                        i5++;
                        z3 = false;
                        i3 = 3;
                        i4 = 2;
                    } else {
                        if (iM758h == 1) {
                            break;
                        }
                        if (iM758h != i4) {
                            if (iM758h == i3) {
                                break;
                            }
                            this.f2836a.computeBounds(this.f2846k, z3);
                            if (i5 != 0) {
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        }
                    }
                } else if (!rectF2.intersect(this.f2844i)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                }
            }
            f = 0.0f;
        }
        if (!this.f2843h.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.f2843h.set(f, f, f, f);
        }
        L.m663a("Layer#computeBounds");
        if (!this.f2843h.isEmpty()) {
            this.f2838c.setAlpha(255);
            Utils.m662f(canvas, this.f2843h, this.f2838c, 31);
            L.m663a("Layer#saveLayer");
            m779i(canvas);
            mo780j(canvas, this.f2837b, iIntValue);
            L.m663a("Layer#drawLayer");
            if (m781k()) {
                Matrix matrix3 = this.f2837b;
                Utils.m662f(canvas, this.f2843h, this.f2839d, 19);
                if (Build.VERSION.SDK_INT < 28) {
                    m779i(canvas);
                }
                L.m663a("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.f2851p.f2613c.size()) {
                    Mask mask2 = this.f2851p.f2613c.get(i6);
                    BaseKeyframeAnimation<ShapeData, Path> baseKeyframeAnimation = this.f2851p.f2611a.get(i6);
                    BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f2851p.f2612b.get(i6);
                    int iM758h2 = C1563b.m758h(mask2.f2767a);
                    if (iM758h2 != 0) {
                        if (iM758h2 == i2) {
                            if (i6 == 0) {
                                this.f2838c.setColor(ViewCompat.MEASURED_STATE_MASK);
                                this.f2838c.setAlpha(255);
                                canvas.drawRect(this.f2843h, this.f2838c);
                            }
                            if (mask2.f2770d) {
                                Utils.m662f(canvas, this.f2843h, this.f2840e, 31);
                                canvas.drawRect(this.f2843h, this.f2838c);
                                this.f2840e.setAlpha((int) (baseKeyframeAnimation2.mo727e().intValue() * 2.55f));
                                this.f2836a.set(baseKeyframeAnimation.mo727e());
                                this.f2836a.transform(matrix3);
                                canvas.drawPath(this.f2836a, this.f2840e);
                                canvas.restore();
                            } else {
                                this.f2836a.set(baseKeyframeAnimation.mo727e());
                                this.f2836a.transform(matrix3);
                                canvas.drawPath(this.f2836a, this.f2840e);
                            }
                        } else if (iM758h2 != 2) {
                            if (iM758h2 == 3) {
                                if (this.f2851p.f2611a.isEmpty()) {
                                    z2 = false;
                                    if (!z2) {
                                        this.f2838c.setAlpha(255);
                                        canvas.drawRect(this.f2843h, this.f2838c);
                                    }
                                } else {
                                    for (int i7 = 0; i7 < this.f2851p.f2613c.size(); i7++) {
                                        if (this.f2851p.f2613c.get(i7).f2767a != 4) {
                                            z2 = false;
                                            break;
                                        }
                                    }
                                    z2 = true;
                                    if (!z2) {
                                    }
                                }
                            }
                        } else if (mask2.f2770d) {
                            Utils.m662f(canvas, this.f2843h, this.f2839d, 31);
                            canvas.drawRect(this.f2843h, this.f2838c);
                            this.f2840e.setAlpha((int) (baseKeyframeAnimation2.mo727e().intValue() * 2.55f));
                            this.f2836a.set(baseKeyframeAnimation.mo727e());
                            this.f2836a.transform(matrix3);
                            canvas.drawPath(this.f2836a, this.f2840e);
                            canvas.restore();
                        } else {
                            Utils.m662f(canvas, this.f2843h, this.f2839d, 31);
                            this.f2836a.set(baseKeyframeAnimation.mo727e());
                            this.f2836a.transform(matrix3);
                            this.f2838c.setAlpha((int) (baseKeyframeAnimation2.mo727e().intValue() * 2.55f));
                            canvas.drawPath(this.f2836a, this.f2838c);
                            canvas.restore();
                        }
                    } else if (mask2.f2770d) {
                        Utils.m662f(canvas, this.f2843h, this.f2838c, 31);
                        canvas.drawRect(this.f2843h, this.f2838c);
                        this.f2836a.set(baseKeyframeAnimation.mo727e());
                        this.f2836a.transform(matrix3);
                        this.f2838c.setAlpha((int) (baseKeyframeAnimation2.mo727e().intValue() * 2.55f));
                        canvas.drawPath(this.f2836a, this.f2840e);
                        canvas.restore();
                    } else {
                        this.f2836a.set(baseKeyframeAnimation.mo727e());
                        this.f2836a.transform(matrix3);
                        this.f2838c.setAlpha((int) (baseKeyframeAnimation2.mo727e().intValue() * 2.55f));
                        canvas.drawPath(this.f2836a, this.f2838c);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                L.m663a("Layer#restoreLayer");
            }
            if (m782l()) {
                Utils.m662f(canvas, this.f2843h, this.f2841f, 19);
                L.m663a("Layer#saveLayer");
                m779i(canvas);
                this.f2853r.mo713f(canvas, matrix, iIntValue);
                canvas.restore();
                L.m663a("Layer#restoreLayer");
                L.m663a("Layer#drawMatte");
            }
            canvas.restore();
            L.m663a("Layer#restoreLayer");
        }
        L.m663a(this.f2847l);
        m783m(0.0f);
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    @CallSuper
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        this.f2857v.m745c(t, lottieValueCallback);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2850o.f2870c;
    }

    /* renamed from: h */
    public final void m778h() {
        if (this.f2855t != null) {
            return;
        }
        if (this.f2854s == null) {
            this.f2855t = Collections.emptyList();
            return;
        }
        this.f2855t = new ArrayList();
        for (BaseLayer2 baseLayer2 = this.f2854s; baseLayer2 != null; baseLayer2 = baseLayer2.f2854s) {
            this.f2855t.add(baseLayer2);
        }
    }

    /* renamed from: i */
    public final void m779i(Canvas canvas) {
        RectF rectF = this.f2843h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f2842g);
        L.m663a("Layer#clearLayer");
    }

    /* renamed from: j */
    public abstract void mo780j(Canvas canvas, Matrix matrix, int i);

    /* renamed from: k */
    public boolean m781k() {
        MaskKeyframeAnimation maskKeyframeAnimation = this.f2851p;
        return (maskKeyframeAnimation == null || maskKeyframeAnimation.f2611a.isEmpty()) ? false : true;
    }

    /* renamed from: l */
    public boolean m782l() {
        return this.f2853r != null;
    }

    /* renamed from: m */
    public final void m783m(float f) {
        PerformanceTracker performanceTracker = this.f2849n.f2370k.f2336a;
        String str = this.f2850o.f2870c;
        if (performanceTracker.f2458a) {
            MeanCalculator meanCalculator = performanceTracker.f2460c.get(str);
            if (meanCalculator == null) {
                meanCalculator = new MeanCalculator();
                performanceTracker.f2460c.put(str, meanCalculator);
            }
            float f2 = meanCalculator.f2306a + f;
            meanCalculator.f2306a = f2;
            int i = meanCalculator.f2307b + 1;
            meanCalculator.f2307b = i;
            if (i == Integer.MAX_VALUE) {
                meanCalculator.f2306a = f2 / 2.0f;
                meanCalculator.f2307b = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<PerformanceTracker.a> it = performanceTracker.f2459b.iterator();
                while (it.hasNext()) {
                    it.next().m708a(f);
                }
            }
        }
    }

    /* renamed from: n */
    public void mo784n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
    }

    /* renamed from: o */
    public void mo785o(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        TransformKeyframeAnimation transformKeyframeAnimation = this.f2857v;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = transformKeyframeAnimation.f2636j;
        if (baseKeyframeAnimation != null) {
            baseKeyframeAnimation.mo730h(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation2 = transformKeyframeAnimation.f2639m;
        if (baseKeyframeAnimation2 != null) {
            baseKeyframeAnimation2.mo730h(f);
        }
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = transformKeyframeAnimation.f2640n;
        if (baseKeyframeAnimation3 != null) {
            baseKeyframeAnimation3.mo730h(f);
        }
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimation4 = transformKeyframeAnimation.f2632f;
        if (baseKeyframeAnimation4 != null) {
            baseKeyframeAnimation4.mo730h(f);
        }
        BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation5 = transformKeyframeAnimation.f2633g;
        if (baseKeyframeAnimation5 != null) {
            baseKeyframeAnimation5.mo730h(f);
        }
        BaseKeyframeAnimation<ScaleXY, ScaleXY> baseKeyframeAnimation6 = transformKeyframeAnimation.f2634h;
        if (baseKeyframeAnimation6 != null) {
            baseKeyframeAnimation6.mo730h(f);
        }
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation7 = transformKeyframeAnimation.f2635i;
        if (baseKeyframeAnimation7 != null) {
            baseKeyframeAnimation7.mo730h(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation = transformKeyframeAnimation.f2637k;
        if (floatKeyframeAnimation != null) {
            floatKeyframeAnimation.mo730h(f);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = transformKeyframeAnimation.f2638l;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.mo730h(f);
        }
        if (this.f2851p != null) {
            for (int i = 0; i < this.f2851p.f2611a.size(); i++) {
                this.f2851p.f2611a.get(i).mo730h(f);
            }
        }
        float f2 = this.f2850o.f2880m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        FloatKeyframeAnimation floatKeyframeAnimation3 = this.f2852q;
        if (floatKeyframeAnimation3 != null) {
            floatKeyframeAnimation3.mo730h(f / f2);
        }
        BaseLayer2 baseLayer2 = this.f2853r;
        if (baseLayer2 != null) {
            baseLayer2.mo785o(baseLayer2.f2850o.f2880m * f);
        }
        for (int i2 = 0; i2 < this.f2856u.size(); i2++) {
            this.f2856u.get(i2).mo730h(f);
        }
    }

    /* renamed from: p */
    public final void m786p(boolean z2) {
        if (z2 != this.f2858w) {
            this.f2858w = z2;
            this.f2849n.invalidateSelf();
        }
    }
}
