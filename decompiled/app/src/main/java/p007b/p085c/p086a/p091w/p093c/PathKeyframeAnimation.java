package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.Keyframe;
import p007b.p085c.p086a.p090c0.LottieValueCallback;

/* JADX INFO: renamed from: b.c.a.w.c.i, reason: use source file name */
/* JADX INFO: compiled from: PathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class PathKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* JADX INFO: renamed from: i */
    public final PointF f2616i;

    /* JADX INFO: renamed from: j */
    public final float[] f2617j;

    /* JADX INFO: renamed from: k */
    public PathKeyframe f2618k;

    /* JADX INFO: renamed from: l */
    public PathMeasure f2619l;

    public PathKeyframeAnimation(List<? extends Keyframe<PointF>> list) {
        super(list);
        this.f2616i = new PointF();
        this.f2617j = new float[2];
        this.f2619l = new PathMeasure();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p093c.BaseKeyframeAnimation
    /* JADX INFO: renamed from: f */
    public Object mo728f(Keyframe keyframe, float f) {
        PointF pointF;
        PathKeyframe pathKeyframe = (PathKeyframe) keyframe;
        Path path = pathKeyframe.f2614o;
        if (path == null) {
            return (PointF) keyframe.f2317b;
        }
        LottieValueCallback<A> lottieValueCallback = this.f2600e;
        if (lottieValueCallback != 0 && (pointF = (PointF) lottieValueCallback.m668a(pathKeyframe.f2320e, pathKeyframe.f2321f.floatValue(), pathKeyframe.f2317b, pathKeyframe.f2318c, m726d(), f, this.f2599d)) != null) {
            return pointF;
        }
        if (this.f2618k != pathKeyframe) {
            this.f2619l.setPath(path, false);
            this.f2618k = pathKeyframe;
        }
        PathMeasure pathMeasure = this.f2619l;
        pathMeasure.getPosTan(pathMeasure.getLength() * f, this.f2617j, null);
        PointF pointF2 = this.f2616i;
        float[] fArr = this.f2617j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f2616i;
    }
}
