package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p097l.GradientColor;
import p007b.p085c.p086a.p095y.p097l.GradientFill;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.h, reason: use source file name */
/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final String f2511a;

    /* JADX INFO: renamed from: b */
    public final boolean f2512b;

    /* JADX INFO: renamed from: c */
    public final BaseLayer2 f2513c;

    /* JADX INFO: renamed from: d */
    public final LongSparseArray<LinearGradient> f2514d = new LongSparseArray<>();

    /* JADX INFO: renamed from: e */
    public final LongSparseArray<RadialGradient> f2515e = new LongSparseArray<>();

    /* JADX INFO: renamed from: f */
    public final Path f2516f;

    /* JADX INFO: renamed from: g */
    public final Paint f2517g;

    /* JADX INFO: renamed from: h */
    public final RectF f2518h;

    /* JADX INFO: renamed from: i */
    public final List<PathContent> f2519i;

    /* JADX INFO: renamed from: j */
    public final int f2520j;

    /* JADX INFO: renamed from: k */
    public final BaseKeyframeAnimation<GradientColor, GradientColor> f2521k;

    /* JADX INFO: renamed from: l */
    public final BaseKeyframeAnimation<Integer, Integer> f2522l;

    /* JADX INFO: renamed from: m */
    public final BaseKeyframeAnimation<PointF, PointF> f2523m;

    /* JADX INFO: renamed from: n */
    public final BaseKeyframeAnimation<PointF, PointF> f2524n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2525o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public ValueCallbackKeyframeAnimation f2526p;

    /* JADX INFO: renamed from: q */
    public final LottieDrawable f2527q;

    /* JADX INFO: renamed from: r */
    public final int f2528r;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, GradientFill gradientFill) {
        Path path = new Path();
        this.f2516f = path;
        this.f2517g = new LPaint(1);
        this.f2518h = new RectF();
        this.f2519i = new ArrayList();
        this.f2513c = baseLayer2;
        this.f2511a = gradientFill.f2752g;
        this.f2512b = gradientFill.f2753h;
        this.f2527q = lottieDrawable;
        this.f2520j = gradientFill.f2746a;
        path.setFillType(gradientFill.f2747b);
        this.f2528r = (int) (lottieDrawable.f2370k.m670b() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimationMo773a = gradientFill.f2748c.mo773a();
        this.f2521k = baseKeyframeAnimationMo773a;
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a2 = gradientFill.f2749d.mo773a();
        this.f2522l = baseKeyframeAnimationMo773a2;
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a3 = gradientFill.f2750e.mo773a();
        this.f2523m = baseKeyframeAnimationMo773a3;
        baseKeyframeAnimationMo773a3.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a3);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a4 = gradientFill.f2751f.mo773a();
        this.f2524n = baseKeyframeAnimationMo773a4;
        baseKeyframeAnimationMo773a4.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a4);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2527q.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content2 content2 = list2.get(i);
            if (content2 instanceof PathContent) {
                this.f2519i.add((PathContent) content2);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.m656f(keyPath, i, list, keyPath2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2516f.reset();
        for (int i = 0; i < this.f2519i.size(); i++) {
            this.f2516f.addPath(this.f2519i.get(i).getPath(), matrix);
        }
        this.f2516f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* JADX INFO: renamed from: e */
    public final int[] m717e(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f2526p;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.mo727e();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.f2512b) {
            return;
        }
        this.f2516f.reset();
        for (int i2 = 0; i2 < this.f2519i.size(); i2++) {
            this.f2516f.addPath(this.f2519i.get(i2).getPath(), matrix);
        }
        this.f2516f.computeBounds(this.f2518h, false);
        if (this.f2520j == 1) {
            long jM718h = m718h();
            radialGradient = this.f2514d.get(jM718h);
            if (radialGradient == null) {
                PointF pointFMo727e = this.f2523m.mo727e();
                PointF pointFMo727e2 = this.f2524n.mo727e();
                GradientColor gradientColorMo727e = this.f2521k.mo727e();
                LinearGradient linearGradient = new LinearGradient(pointFMo727e.x, pointFMo727e.y, pointFMo727e2.x, pointFMo727e2.y, m717e(gradientColorMo727e.f2745b), gradientColorMo727e.f2744a, Shader.TileMode.CLAMP);
                this.f2514d.put(jM718h, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jM718h2 = m718h();
            radialGradient = this.f2515e.get(jM718h2);
            if (radialGradient == null) {
                PointF pointFMo727e3 = this.f2523m.mo727e();
                PointF pointFMo727e4 = this.f2524n.mo727e();
                GradientColor gradientColorMo727e2 = this.f2521k.mo727e();
                int[] iArrM717e = m717e(gradientColorMo727e2.f2745b);
                float[] fArr = gradientColorMo727e2.f2744a;
                float f = pointFMo727e3.x;
                float f2 = pointFMo727e3.y;
                float fHypot = (float) Math.hypot(pointFMo727e4.x - f, pointFMo727e4.y - f2);
                radialGradient = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrM717e, fArr, Shader.TileMode.CLAMP);
                this.f2515e.put(jM718h2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.f2517g.setShader(radialGradient);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f2525o;
        if (baseKeyframeAnimation != null) {
            this.f2517g.setColorFilter(baseKeyframeAnimation.mo727e());
        }
        this.f2517g.setAlpha(MiscUtils.m653c((int) ((((i / 255.0f) * this.f2522l.mo727e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f2516f, this.f2517g);
        L.m663a("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.f2426d) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2522l;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2421C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f2525o;
            if (baseKeyframeAnimation2 != null) {
                this.f2513c.f2856u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.f2525o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2525o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            this.f2513c.m777e(this.f2525o);
            return;
        }
        if (t == LottieProperty.f2422D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.f2526p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.f2513c.f2856u.remove(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.f2526p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2526p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.f2596a.add(this);
            this.f2513c.m777e(this.f2526p);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2511a;
    }

    /* JADX INFO: renamed from: h */
    public final int m718h() {
        int iRound = Math.round(this.f2523m.f2599d * this.f2528r);
        int iRound2 = Math.round(this.f2524n.f2599d * this.f2528r);
        int iRound3 = Math.round(this.f2521k.f2599d * this.f2528r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
