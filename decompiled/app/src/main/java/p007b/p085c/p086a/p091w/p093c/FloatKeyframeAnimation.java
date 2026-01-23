package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* JADX INFO: renamed from: b.c.a.w.c.c, reason: use source file name */
/* JADX INFO: compiled from: FloatKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    public FloatKeyframeAnimation(List<Keyframe<Float>> list) {
        super(list);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        return Float.valueOf(m740k(keyframe, f));
    }

    /* JADX INFO: renamed from: j */
    public float m739j() {
        return m740k(m723a(), m725c());
    }

    /* JADX INFO: renamed from: k */
    public float m740k(Keyframe<Float> keyframe, float f) {
        Float f2;
        if (keyframe.f2317b == null || keyframe.f2318c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        if (lottieValueCallback != 0 && (f2 = (Float) lottieValueCallback.m668a(keyframe.f2320e, keyframe.f2321f.floatValue(), keyframe.f2317b, keyframe.f2318c, f, m726d(), this.f2599d)) != null) {
            return f2.floatValue();
        }
        if (keyframe.f2322g == -3987645.8f) {
            keyframe.f2322g = keyframe.f2317b.floatValue();
        }
        float f3 = keyframe.f2322g;
        if (keyframe.f2323h == -3987645.8f) {
            keyframe.f2323h = keyframe.f2318c.floatValue();
        }
        return MiscUtils.m655e(f3, keyframe.f2323h, f);
    }
}
