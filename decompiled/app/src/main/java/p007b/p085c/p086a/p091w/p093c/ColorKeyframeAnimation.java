package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* JADX INFO: renamed from: b.c.a.w.c.b, reason: use source file name */
/* JADX INFO: compiled from: ColorKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    public ColorKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        return Integer.valueOf(m738j(keyframe, f));
    }

    /* JADX INFO: renamed from: j */
    public int m738j(Keyframe<Integer> keyframe, float f) {
        Integer num;
        Integer num2 = keyframe.f2317b;
        if (num2 == null || keyframe.f2318c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int iIntValue = num2.intValue();
        int iIntValue2 = keyframe.f2318c.intValue();
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        return (lottieValueCallback == 0 || (num = (Integer) lottieValueCallback.m668a(keyframe.f2320e, keyframe.f2321f.floatValue(), Integer.valueOf(iIntValue), Integer.valueOf(iIntValue2), f, m726d(), this.f2599d)) == null) ? AnimatableValueParser.m528i0(MiscUtils.m652b(f, 0.0f, 1.0f), iIntValue, iIntValue2) : num.intValue();
    }
}
