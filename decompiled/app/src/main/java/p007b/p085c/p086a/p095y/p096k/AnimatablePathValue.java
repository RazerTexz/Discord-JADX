package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.PathKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.PointKeyframeAnimation;

/* compiled from: AnimatablePathValue.java */
/* renamed from: b.c.a.y.k.e, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatablePathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a */
    public final List<Keyframe<PointF>> f2722a;

    public AnimatablePathValue(List<Keyframe<PointF>> list) {
        this.f2722a = list;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* renamed from: a */
    public BaseKeyframeAnimation<PointF, PointF> mo773a() {
        return this.f2722a.get(0).m667d() ? new PointKeyframeAnimation(this.f2722a) : new PathKeyframeAnimation(this.f2722a);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* renamed from: b */
    public List<Keyframe<PointF>> mo774b() {
        return this.f2722a;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    public boolean isStatic() {
        return this.f2722a.size() == 1 && this.f2722a.get(0).m667d();
    }
}
