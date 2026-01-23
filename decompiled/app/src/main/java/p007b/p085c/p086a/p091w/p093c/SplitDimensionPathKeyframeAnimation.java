package p007b.p085c.p086a.p091w.p093c;

import android.graphics.PointF;
import java.util.Collections;
import p007b.p085c.p086a.p090c0.Keyframe;

/* JADX INFO: renamed from: b.c.a.w.c.m, reason: use source file name */
/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* JADX INFO: renamed from: i */
    public final PointF f2624i;

    /* JADX INFO: renamed from: j */
    public final BaseKeyframeAnimation<Float, Float> f2625j;

    /* JADX INFO: renamed from: k */
    public final BaseKeyframeAnimation<Float, Float> f2626k;

    public SplitDimensionPathKeyframeAnimation(BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation, BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2) {
        super(Collections.emptyList());
        this.f2624i = new PointF();
        this.f2625j = baseKeyframeAnimation;
        this.f2626k = baseKeyframeAnimation2;
        mo730h(this.f2599d);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: e */
    public PointF mo727e() {
        return this.f2624i;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: f */
    public PointF mo728f(Keyframe<PointF> keyframe, float f) {
        return this.f2624i;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: h */
    public void mo730h(float f) {
        this.f2625j.mo730h(f);
        this.f2626k.mo730h(f);
        this.f2624i.set(this.f2625j.mo727e().floatValue(), this.f2626k.mo727e().floatValue());
        for (int i = 0; i < this.f2596a.size(); i++) {
            this.f2596a.get(i).mo709a();
        }
    }
}
