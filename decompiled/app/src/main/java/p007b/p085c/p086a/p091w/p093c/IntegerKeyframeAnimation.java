package p007b.p085c.p086a.p091w.p093c;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* compiled from: IntegerKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.e, reason: use source file name */
/* loaded from: classes.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    public IntegerKeyframeAnimation(List<Keyframe<Integer>> list) {
        super(list);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        return Integer.valueOf(m741j(keyframe, f));
    }

    /* renamed from: j */
    public int m741j(Keyframe<Integer> keyframe, float f) {
        Integer num;
        if (keyframe.f2317b == null || keyframe.f2318c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        if (lottieValueCallback != 0 && (num = (Integer) lottieValueCallback.m668a(keyframe.f2320e, keyframe.f2321f.floatValue(), keyframe.f2317b, keyframe.f2318c, f, m726d(), this.f2599d)) != null) {
            return num.intValue();
        }
        if (keyframe.f2324i == 784923401) {
            keyframe.f2324i = keyframe.f2317b.intValue();
        }
        int i = keyframe.f2324i;
        if (keyframe.f2325j == 784923401) {
            keyframe.f2325j = keyframe.f2318c.intValue();
        }
        int i2 = keyframe.f2325j;
        PointF pointF = MiscUtils.f2308a;
        return (int) ((f * (i2 - i)) + i);
    }
}
