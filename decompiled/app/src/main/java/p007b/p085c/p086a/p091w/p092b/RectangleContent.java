package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.LottieProperty;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.FloatKeyframeAnimation;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p097l.RectangleShape;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.o, reason: use source file name */
/* JADX INFO: compiled from: RectangleContent.java */
/* JADX INFO: loaded from: classes.dex */
public class RectangleContent implements BaseKeyframeAnimation.b, KeyPathElementContent, PathContent {

    /* JADX INFO: renamed from: c */
    public final String f2561c;

    /* JADX INFO: renamed from: d */
    public final boolean f2562d;

    /* JADX INFO: renamed from: e */
    public final LottieDrawable f2563e;

    /* JADX INFO: renamed from: f */
    public final BaseKeyframeAnimation<?, PointF> f2564f;

    /* JADX INFO: renamed from: g */
    public final BaseKeyframeAnimation<?, PointF> f2565g;

    /* JADX INFO: renamed from: h */
    public final BaseKeyframeAnimation<?, Float> f2566h;

    /* JADX INFO: renamed from: j */
    public boolean f2568j;

    /* JADX INFO: renamed from: a */
    public final Path f2559a = new Path();

    /* JADX INFO: renamed from: b */
    public final RectF f2560b = new RectF();

    /* JADX INFO: renamed from: i */
    public CompoundTrimPathContent f2567i = new CompoundTrimPathContent();

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, RectangleShape rectangleShape) {
        this.f2561c = rectangleShape.f2793a;
        this.f2562d = rectangleShape.f2797e;
        this.f2563e = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a = rectangleShape.f2794b.mo773a();
        this.f2564f = baseKeyframeAnimationMo773a;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a2 = rectangleShape.f2795c.mo773a();
        this.f2565g = baseKeyframeAnimationMo773a2;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationMo773a3 = rectangleShape.f2796d.mo773a();
        this.f2566h = baseKeyframeAnimationMo773a3;
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        baseLayer2.m777e(baseKeyframeAnimationMo773a3);
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseKeyframeAnimationMo773a2.f2596a.add(this);
        baseKeyframeAnimationMo773a3.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2568j = false;
        this.f2563e.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.f2592c == 1) {
                    this.f2567i.f2481a.add(trimPathContent);
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
        if (t == LottieProperty.f2430h) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f2565g;
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2432j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.f2564f;
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2431i) {
            BaseKeyframeAnimation<?, Float> baseKeyframeAnimation3 = this.f2566h;
            LottieValueCallback<Float> lottieValueCallback4 = baseKeyframeAnimation3.f2600e;
            baseKeyframeAnimation3.f2600e = lottieValueCallback;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2561c;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        if (this.f2568j) {
            return this.f2559a;
        }
        this.f2559a.reset();
        if (this.f2562d) {
            this.f2568j = true;
            return this.f2559a;
        }
        PointF pointFMo727e = this.f2565g.mo727e();
        float f = pointFMo727e.x / 2.0f;
        float f2 = pointFMo727e.y / 2.0f;
        BaseKeyframeAnimation<?, Float> baseKeyframeAnimation = this.f2566h;
        float fM739j = baseKeyframeAnimation == null ? 0.0f : ((FloatKeyframeAnimation) baseKeyframeAnimation).m739j();
        float fMin = Math.min(f, f2);
        if (fM739j > fMin) {
            fM739j = fMin;
        }
        PointF pointFMo727e2 = this.f2564f.mo727e();
        this.f2559a.moveTo(pointFMo727e2.x + f, (pointFMo727e2.y - f2) + fM739j);
        this.f2559a.lineTo(pointFMo727e2.x + f, (pointFMo727e2.y + f2) - fM739j);
        if (fM739j > 0.0f) {
            RectF rectF = this.f2560b;
            float f3 = pointFMo727e2.x;
            float f4 = fM739j * 2.0f;
            float f5 = pointFMo727e2.y;
            rectF.set((f3 + f) - f4, (f5 + f2) - f4, f3 + f, f5 + f2);
            this.f2559a.arcTo(this.f2560b, 0.0f, 90.0f, false);
        }
        this.f2559a.lineTo((pointFMo727e2.x - f) + fM739j, pointFMo727e2.y + f2);
        if (fM739j > 0.0f) {
            RectF rectF2 = this.f2560b;
            float f6 = pointFMo727e2.x;
            float f7 = pointFMo727e2.y;
            float f8 = fM739j * 2.0f;
            rectF2.set(f6 - f, (f7 + f2) - f8, (f6 - f) + f8, f7 + f2);
            this.f2559a.arcTo(this.f2560b, 90.0f, 90.0f, false);
        }
        this.f2559a.lineTo(pointFMo727e2.x - f, (pointFMo727e2.y - f2) + fM739j);
        if (fM739j > 0.0f) {
            RectF rectF3 = this.f2560b;
            float f9 = pointFMo727e2.x;
            float f10 = pointFMo727e2.y;
            float f11 = fM739j * 2.0f;
            rectF3.set(f9 - f, f10 - f2, (f9 - f) + f11, (f10 - f2) + f11);
            this.f2559a.arcTo(this.f2560b, 180.0f, 90.0f, false);
        }
        this.f2559a.lineTo((pointFMo727e2.x + f) - fM739j, pointFMo727e2.y - f2);
        if (fM739j > 0.0f) {
            RectF rectF4 = this.f2560b;
            float f12 = pointFMo727e2.x;
            float f13 = fM739j * 2.0f;
            float f14 = pointFMo727e2.y;
            rectF4.set((f12 + f) - f13, f14 - f2, f12 + f, (f14 - f2) + f13);
            this.f2559a.arcTo(this.f2560b, 270.0f, 90.0f, false);
        }
        this.f2559a.close();
        this.f2567i.m715a(this.f2559a);
        this.f2568j = true;
        return this.f2559a;
    }
}
