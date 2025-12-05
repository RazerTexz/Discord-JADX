package p007b.p085c.p086a.p095y.p096k;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ColorKeyframeAnimation;

/* compiled from: AnimatableColorValue.java */
/* renamed from: b.c.a.y.k.a, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableColorValue extends BaseAnimatableValue<Integer, Integer> {
    public AnimatableColorValue(List<Keyframe<Integer>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* renamed from: a */
    public BaseKeyframeAnimation<Integer, Integer> mo773a() {
        return new ColorKeyframeAnimation(this.f2738a);
    }
}
