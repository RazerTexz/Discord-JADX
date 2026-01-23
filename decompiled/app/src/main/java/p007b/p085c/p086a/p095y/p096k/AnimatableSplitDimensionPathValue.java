package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.SplitDimensionPathKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.k.i, reason: use source file name */
/* JADX INFO: compiled from: AnimatableSplitDimensionPathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {

    /* JADX INFO: renamed from: a */
    public final AnimatableFloatValue f2723a;

    /* JADX INFO: renamed from: b */
    public final AnimatableFloatValue f2724b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.f2723a = animatableFloatValue;
        this.f2724b = animatableFloatValue2;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo773a() {
        return new SplitDimensionPathKeyframeAnimation(this.f2723a.mo773a(), this.f2724b.mo773a());
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: b */
    public List<Keyframe<PointF>> mo774b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    public boolean isStatic() {
        return this.f2723a.isStatic() && this.f2724b.isStatic();
    }
}
