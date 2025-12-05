package p007b.p085c.p086a.p091w.p093c;

import java.util.List;
import p007b.p085c.p086a.p089b0.MiscUtils;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p085c.p086a.p090c0.ScaleXY;

/* compiled from: ScaleKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.k, reason: use source file name */
/* loaded from: classes.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: i */
    public final ScaleXY f2621i;

    public ScaleKeyframeAnimation(List<Keyframe<ScaleXY>> list) {
        super(list);
        this.f2621i = new ScaleXY();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        T t;
        ScaleXY scaleXY;
        T t2 = keyframe.f2317b;
        if (t2 == 0 || (t = keyframe.f2318c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY2 = (ScaleXY) t2;
        ScaleXY scaleXY3 = (ScaleXY) t;
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        if (lottieValueCallback != 0 && (scaleXY = (ScaleXY) lottieValueCallback.m668a(keyframe.f2320e, keyframe.f2321f.floatValue(), scaleXY2, scaleXY3, f, m726d(), this.f2599d)) != null) {
            return scaleXY;
        }
        ScaleXY scaleXY4 = this.f2621i;
        float fM655e = MiscUtils.m655e(scaleXY2.f2334a, scaleXY3.f2334a, f);
        float fM655e2 = MiscUtils.m655e(scaleXY2.f2335b, scaleXY3.f2335b, f);
        scaleXY4.f2334a = fM655e;
        scaleXY4.f2335b = fM655e2;
        return this.f2621i;
    }
}
