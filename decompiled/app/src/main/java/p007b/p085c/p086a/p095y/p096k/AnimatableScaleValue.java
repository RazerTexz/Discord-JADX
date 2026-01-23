package p007b.p085c.p086a.p095y.p096k;

import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.ScaleXY;
import p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation;
import p007b.p085c.p086a.p091w.p093c.ScaleKeyframeAnimation;

/* JADX INFO: renamed from: b.c.a.y.k.g, reason: use source file name */
/* JADX INFO: compiled from: AnimatableScaleValue.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatableScaleValue extends BaseAnimatableValue<ScaleXY, ScaleXY> {
    public AnimatableScaleValue(List<Keyframe<ScaleXY>> list) {
        super((List) list);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.AnimatableValue
    /* JADX INFO: renamed from: a */
    public BaseKeyframeAnimation<ScaleXY, ScaleXY> mo773a() {
        return new ScaleKeyframeAnimation(this.f2738a);
    }
}
