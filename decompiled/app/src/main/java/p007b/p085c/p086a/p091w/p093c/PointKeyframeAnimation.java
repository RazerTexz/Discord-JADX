package p007b.p085c.p086a.p091w.p093c;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: PointKeyframeAnimation.java */
/* renamed from: b.c.a.w.c.j, reason: use source file name */
/* loaded from: classes.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i */
    public final PointF f2620i;

    public PointKeyframeAnimation(List<Keyframe<PointF>> list) {
        super(list);
        this.f2620i = new PointF();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        T t;
        PointF pointF;
        T t2 = keyframe.f2317b;
        if (t2 == 0 || (t = keyframe.f2318c) == 0) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF2 = (PointF) t2;
        PointF pointF3 = (PointF) t;
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.m668a(keyframe.f2320e, keyframe.f2321f.floatValue(), pointF2, pointF3, f, m726d(), this.f2599d)) != null) {
            return pointF;
        }
        PointF pointF4 = this.f2620i;
        float f2 = pointF2.x;
        float fM839a = outline.m839a(pointF3.x, f2, f, f2);
        float f3 = pointF2.y;
        pointF4.set(fM839a, ((pointF3.y - f3) * f) + f3);
        return this.f2620i;
    }
}
