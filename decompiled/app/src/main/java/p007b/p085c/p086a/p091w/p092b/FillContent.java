package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.L;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.LPaint;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ColorKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ValueCallbackKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p097l.ShapeFill;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* compiled from: FillContent.java */
/* renamed from: b.c.a.w.b.g, reason: use source file name */
/* loaded from: classes.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* renamed from: a */
    public final Path f2501a;

    /* renamed from: b */
    public final Paint f2502b;

    /* renamed from: c */
    public final BaseLayer2 f2503c;

    /* renamed from: d */
    public final String f2504d;

    /* renamed from: e */
    public final boolean f2505e;

    /* renamed from: f */
    public final List<PathContent> f2506f;

    /* renamed from: g */
    public final BaseKeyframeAnimation<Integer, Integer> f2507g;

    /* renamed from: h */
    public final BaseKeyframeAnimation<Integer, Integer> f2508h;

    /* renamed from: i */
    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> f2509i;

    /* renamed from: j */
    public final LottieDrawable f2510j;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, ShapeFill shapeFill) {
        Path path = new Path();
        this.f2501a = path;
        this.f2502b = new LPaint(1);
        this.f2506f = new ArrayList();
        this.f2503c = baseLayer2;
        this.f2504d = shapeFill.f2808c;
        this.f2505e = shapeFill.f2811f;
        this.f2510j = lottieDrawable;
        if (shapeFill.f2809d == null || shapeFill.f2810e == null) {
            this.f2507g = null;
            this.f2508h = null;
            return;
        }
        path.setFillType(shapeFill.f2807b);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a = shapeFill.f2809d.mo773a();
        this.f2507g = baseKeyframeAnimationMo773a;
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationMo773a2 = shapeFill.f2810e.mo773a();
        this.f2508h = baseKeyframeAnimationMo773a2;
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* renamed from: a */
    public void mo709a() {
        this.f2510j.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content2 content2 = list2.get(i);
            if (content2 instanceof PathContent) {
                this.f2506f.add((PathContent) content2);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: c */
    public void mo711c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.m656f(keyPath, i, list, keyPath2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2501a.reset();
        for (int i = 0; i < this.f2506f.size(); i++) {
            this.f2501a.addPath(this.f2506f.get(i).getPath(), matrix);
        }
        this.f2501a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        if (this.f2505e) {
            return;
        }
        Paint paint = this.f2502b;
        ColorKeyframeAnimation colorKeyframeAnimation = (ColorKeyframeAnimation) this.f2507g;
        paint.setColor(colorKeyframeAnimation.m738j(colorKeyframeAnimation.m723a(), colorKeyframeAnimation.m725c()));
        this.f2502b.setAlpha(MiscUtils.m653c((int) ((((i / 255.0f) * this.f2508h.mo727e().intValue()) / 100.0f) * 255.0f), 0, 255));
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.f2509i;
        if (baseKeyframeAnimation != null) {
            this.f2502b.setColorFilter(baseKeyframeAnimation.mo727e());
        }
        this.f2501a.reset();
        for (int i2 = 0; i2 < this.f2506f.size(); i2++) {
            this.f2501a.addPath(this.f2506f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f2501a, this.f2502b);
        L.m663a("FillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.KeyPathElement
    /* renamed from: g */
    public <T> void mo714g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.f2423a) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.f2507g;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.f2426d) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation2 = this.f2508h;
            LottieValueCallback<Integer> lottieValueCallback3 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2421C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation3 = this.f2509i;
            if (baseKeyframeAnimation3 != null) {
                this.f2503c.f2856u.remove(baseKeyframeAnimation3);
            }
            if (lottieValueCallback == 0) {
                this.f2509i = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f2509i = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.f2596a.add(this);
            this.f2503c.m777e(this.f2509i);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2504d;
    }
}
