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
import p007b.p085c.p086a.p095y.p097l.CircleShape;
import p007b.p085c.p086a.p095y.p098m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.f, reason: use source file name */
/* JADX INFO: compiled from: EllipseContent.java */
/* JADX INFO: loaded from: classes.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    /* JADX INFO: renamed from: b */
    public final String f2494b;

    /* JADX INFO: renamed from: c */
    public final LottieDrawable f2495c;

    /* JADX INFO: renamed from: d */
    public final BaseKeyframeAnimation<?, PointF> f2496d;

    /* JADX INFO: renamed from: e */
    public final BaseKeyframeAnimation<?, PointF> f2497e;

    /* JADX INFO: renamed from: f */
    public final CircleShape f2498f;

    /* JADX INFO: renamed from: h */
    public boolean f2500h;

    /* JADX INFO: renamed from: a */
    public final Path f2493a = new Path();

    /* JADX INFO: renamed from: g */
    public CompoundTrimPathContent f2499g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, CircleShape circleShape) {
        this.f2494b = circleShape.f2739a;
        this.f2495c = lottieDrawable;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a = circleShape.f2741c.mo773a();
        this.f2496d = baseKeyframeAnimationMo773a;
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationMo773a2 = circleShape.f2740b.mo773a();
        this.f2497e = baseKeyframeAnimationMo773a2;
        this.f2498f = circleShape;
        baseLayer2.m777e(baseKeyframeAnimationMo773a);
        baseLayer2.m777e(baseKeyframeAnimationMo773a2);
        baseKeyframeAnimationMo773a.f2596a.add(this);
        baseKeyframeAnimationMo773a2.f2596a.add(this);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2500h = false;
        this.f2495c.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    /* JADX INFO: renamed from: b */
    public void mo710b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list.size(); i++) {
            Content2 content2 = list.get(i);
            if (content2 instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content2;
                if (trimPathContent.f2592c == 1) {
                    this.f2499g.f2481a.add(trimPathContent);
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
        if (t == LottieProperty.f2429g) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation = this.f2496d;
            LottieValueCallback<PointF> lottieValueCallback2 = baseKeyframeAnimation.f2600e;
            baseKeyframeAnimation.f2600e = lottieValueCallback;
        } else if (t == LottieProperty.f2432j) {
            BaseKeyframeAnimation<?, PointF> baseKeyframeAnimation2 = this.f2497e;
            LottieValueCallback<PointF> lottieValueCallback3 = baseKeyframeAnimation2.f2600e;
            baseKeyframeAnimation2.f2600e = lottieValueCallback;
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.Content2
    public String getName() {
        return this.f2494b;
    }

    @Override // p007b.p085c.p086a.p091w.p092b.PathContent
    public Path getPath() {
        if (this.f2500h) {
            return this.f2493a;
        }
        this.f2493a.reset();
        if (this.f2498f.f2743e) {
            this.f2500h = true;
            return this.f2493a;
        }
        PointF pointFMo727e = this.f2496d.mo727e();
        float f = pointFMo727e.x / 2.0f;
        float f2 = pointFMo727e.y / 2.0f;
        float f3 = f * 0.55228f;
        float f4 = 0.55228f * f2;
        this.f2493a.reset();
        if (this.f2498f.f2742d) {
            float f5 = -f2;
            this.f2493a.moveTo(0.0f, f5);
            float f6 = 0.0f - f3;
            float f7 = -f;
            float f8 = 0.0f - f4;
            this.f2493a.cubicTo(f6, f5, f7, f8, f7, 0.0f);
            float f9 = f4 + 0.0f;
            this.f2493a.cubicTo(f7, f9, f6, f2, 0.0f, f2);
            float f10 = f3 + 0.0f;
            this.f2493a.cubicTo(f10, f2, f, f9, f, 0.0f);
            this.f2493a.cubicTo(f, f8, f10, f5, 0.0f, f5);
        } else {
            float f11 = -f2;
            this.f2493a.moveTo(0.0f, f11);
            float f12 = f3 + 0.0f;
            float f13 = 0.0f - f4;
            this.f2493a.cubicTo(f12, f11, f, f13, f, 0.0f);
            float f14 = f4 + 0.0f;
            this.f2493a.cubicTo(f, f14, f12, f2, 0.0f, f2);
            float f15 = 0.0f - f3;
            float f16 = -f;
            this.f2493a.cubicTo(f15, f2, f16, f14, f16, 0.0f);
            this.f2493a.cubicTo(f16, f13, f15, f11, 0.0f, f11);
        }
        PointF pointFMo727e2 = this.f2497e.mo727e();
        this.f2493a.offset(pointFMo727e2.x, pointFMo727e2.y);
        this.f2493a.close();
        this.f2499g.m715a(this.f2493a);
        this.f2500h = true;
        return this.f2493a;
    }
}
