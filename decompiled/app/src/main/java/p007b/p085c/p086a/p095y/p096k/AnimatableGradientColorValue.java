package p007b.p085c.p086a.p095y.p096k;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.GradientColorKeyframeAnimation;
import p007b.p085c.p086a.p095y.p097l.GradientColor;

/* compiled from: AnimatableGradientColorValue.java */
/* renamed from: b.c.a.y.k.c, reason: use source file name */
/* loaded from: classes.dex */
public class AnimatableGradientColorValue extends BaseAnimatableValue<GradientColor, GradientColor> {
    public AnimatableGradientColorValue(List<Keyframe<GradientColor>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* renamed from: a */
    public BaseKeyframeAnimation<GradientColor, GradientColor> mo773a() {
        return new GradientColorKeyframeAnimation(this.f2738a);
    }
}
