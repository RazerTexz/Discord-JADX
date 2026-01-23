package p007b.p085c.p086a.p095y.p096k;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.FloatKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.k.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatableFloatValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableFloatValue extends BaseAnimatableValue<Float, Float> {
    public AnimatableFloatValue() {
        super(Float.valueOf(0.0f));
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: a */
    public BaseKeyframeAnimation<Float, Float> mo773a() {
        return new FloatKeyframeAnimation(this.f2738a);
    }

    public AnimatableFloatValue(List<Keyframe<Float>> list) {
        super((List) list);
    }
}
