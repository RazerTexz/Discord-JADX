package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p097l.GradientColor;
import p007b.p085c.p086a.p095y.p097l.GradientStroke;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: GradientStrokeContent.java */
/* renamed from: b.c.a.w.b.i, reason: use source file name */
/* loaded from: classes.dex */
public class GradientStrokeContent extends BaseStrokeContent {

    /* renamed from: o */
    public final String f2529o;

    /* renamed from: p */
    public final boolean f2530p;

    /* renamed from: q */
    public final LongSparseArray<LinearGradient> f2531q;

    /* renamed from: r */
    public final LongSparseArray<RadialGradient> f2532r;

    /* renamed from: s */
    public final RectF f2533s;

    /* renamed from: t */
    public final int f2534t;

    /* renamed from: u */
    public final int f2535u;

    /* renamed from: v */
    public final BaseKeyframeAnimation<GradientColor, GradientColor> f2536v;

    /* renamed from: w */
    public final BaseKeyframeAnimation<PointF, PointF> f2537w;

    /* renamed from: x */
    public final BaseKeyframeAnimation<PointF, PointF> f2538x;

    /* renamed from: y */
    @Nullable
    public ValueCallbackKeyframeAnimation f2539y;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer2, C1563b.m761k(gradientStroke.f2761h), C1563b.m762l(gradientStroke.f2762i), gradientStroke.f2763j, gradientStroke.f2757d, gradientStroke.f2760g, gradientStroke.f2764k, gradientStroke.f2765l);
        this.f2531q = new LongSparseArray<>();
        this.f2532r = new LongSparseArray<>();
        this.f2533s = new RectF();
        this.f2529o = gradientStroke.f2754a;
        this.f2534t = gradientStroke.f2755b;
        this.f2530p = gradientStroke.f2766m;
        this.f2535u = (int) (lottieDrawable.f2370k.m670b() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimationMo773a = gradientStroke.f2756c.mo773a();
        this.f2536v = baseKeyframeAnimationMo773a;
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a2 = gradientStroke.f2758e.mo773a();
        this.f2537w = baseKeyframeAnimationMo773a2;
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a3 = gradientStroke.f2759f.mo773a();
        this.f2538x = baseKeyframeAnimationMo773a3;
        baseKeyframeAnimationMo773a3.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a3);
    }

    /* renamed from: e */
    public final int[] m719e(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f2539y;
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
    @Override // p007b.p085c.p086a.p091w.p092b.BaseStrokeContent, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.f2530p) {
            return;
        }
        mo712d(this.f2533s, matrix, false);
        if (this.f2534t == 1) {
            long jM720h = m720h();
            radialGradient = this.f2531q.get(jM720h);
            if (radialGradient == null) {
                PointF pointFMo727e = this.f2537w.mo727e();
                PointF pointFMo727e2 = this.f2538x.mo727e();
                GradientColor gradientColorMo727e = this.f2536v.mo727e();
                radialGradient = new LinearGradient(pointFMo727e.x, pointFMo727e.y, pointFMo727e2.x, pointFMo727e2.y, m719e(gradientColorMo727e.f2745b), gradientColorMo727e.f2744a, Shader.TileMode.CLAMP);
                this.f2531q.put(jM720h, radialGradient);
            }
        } else {
            long jM720h2 = m720h();
            radialGradient = this.f2532r.get(jM720h2);
            if (radialGradient == null) {
                PointF pointFMo727e3 = this.f2537w.mo727e();
                PointF pointFMo727e4 = this.f2538x.mo727e();
                GradientColor gradientColorMo727e2 = this.f2536v.mo727e();
                int[] iArrM719e = m719e(gradientColorMo727e2.f2745b);
                float[] fArr = gradientColorMo727e2.f2744a;
                radialGradient = new RadialGradient(pointFMo727e3.x, pointFMo727e3.y, (float) Math.hypot(pointFMo727e4.x - r9, pointFMo727e4.y - r10), iArrM719e, fArr, Shader.TileMode.CLAMP);
                this.f2532r.put(jM720h2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.f2473i.setShader(radialGradient);
        super.mo713f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p092b.BaseStrokeContent, p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.mo714g(t, lottieValueCallback);
        if (t == LottieProperty.f2422D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f2539y;
            if (valueCallbackKeyframeAnimation != null) {
                this.f2470f.f2856u.remove(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f2539y = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2539y = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.f2596a.add(this);
            this.f2470f.m777e(this.f2539y);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2529o;
    }

    /* renamed from: h */
    public final int m720h() {
        int iRound = Math.round(this.f2537w.f2599d * this.f2535u);
        int iRound2 = Math.round(this.f2538x.f2599d * this.f2535u);
        int iRound3 = Math.round(this.f2536v.f2599d * this.f2535u);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
