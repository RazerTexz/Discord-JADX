package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.PointKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.k.f, reason: use source file name */
/* JADX INFO: compiled from: AnimatablePointValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatablePointValue extends BaseAnimatableValue<PointF, PointF> {
    public AnimatablePointValue(List<Keyframe<PointF>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo773a() {
        return new PointKeyframeAnimation(this.f2738a);
    }
}
