package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ColorKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p097l.ShapeStroke;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: StrokeContent.java */
/* renamed from: b.c.a.w.b.r, reason: use source file name */
/* loaded from: classes.dex */
public class StrokeContent extends BaseStrokeContent {

    /* renamed from: o */
    public final BaseLayer2 f2585o;

    /* renamed from: p */
    public final String f2586p;

    /* renamed from: q */
    public final boolean f2587q;

    /* renamed from: r */
    public final BaseKeyframeAnimation<Integer, Integer> f2588r;

    /* renamed from: s */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2589s;

    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeStroke shapeStroke) {
        super(lottieDrawable, baseLayer2, C1563b.m761k(shapeStroke.f2825g), C1563b.m762l(shapeStroke.f2826h), shapeStroke.f2827i, shapeStroke.f2823e, shapeStroke.f2824f, shapeStroke.f2821c, shapeStroke.f2820b);
        this.f2585o = baseLayer2;
        this.f2586p = shapeStroke.f2819a;
        this.f2587q = shapeStroke.f2828j;
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a = shapeStroke.f2822d.mo773a();
        this.f2588r = baseKeyframeAnimationMo773a;
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.BaseStrokeContent, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        if (this.f2587q) {
            return;
        }
        Paint paint = this.f2473i;
        ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.f2588r;
        paint.setColor(colorKeyframeAnimation.m738j(colorKeyframeAnimation.m723a(), colorKeyframeAnimation.m725c()));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f2589s;
        if (baseKeyframeAnimation != null) {
            this.f2473i.setColorFilter(baseKeyframeAnimation.mo727e());
        }
        super.mo713f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p092b.BaseStrokeContent, p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.mo714g(t, lottieValueCallback);
        if (t == LottieProperty.f2424b) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2588r;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2421C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.f2589s;
            if (baseKeyframeAnimation2 != null) {
                this.f2585o.f2856u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.f2589s = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2589s = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            this.f2585o.m777e(this.f2588r);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2586p;
    }
}
