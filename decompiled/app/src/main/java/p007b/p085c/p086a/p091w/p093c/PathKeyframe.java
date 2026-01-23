package p007b.p085c.p086a.p091w.p093c;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieComposition;
import p007b.p085c.p086a.p089b0.Utils;
import p007b.p085c.p086a.p090c0.Keyframe;

/* JADX INFO: renamed from: b.c.a.w.c.h, reason: use source file name */
/* JADX INFO: compiled from: PathKeyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class PathKeyframe extends Keyframe<PointF> {

    /* JADX INFO: renamed from: o */
    @Nullable
    public Path f2614o;

    /* JADX INFO: renamed from: p */
    public final Keyframe<PointF> f2615p;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe<PointF> keyframe) {
        super(lottieComposition, keyframe.f2317b, keyframe.f2318c, keyframe.f2319d, keyframe.f2320e, keyframe.f2321f);
        this.f2615p = keyframe;
        m742e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: e */
    public void m742e() {
        T t;
        T t2 = this.f2318c;
        boolean z2 = (t2 == 0 || (t = this.f2317b) == 0 || !((PointF) t).equals(((PointF) t2).x, ((PointF) t2).y)) ? false : true;
        T t3 = this.f2318c;
        if (t3 == 0 || z2) {
            return;
        }
        PointF pointF = (PointF) this.f2317b;
        PointF pointF2 = (PointF) t3;
        Keyframe<PointF> keyframe = this.f2615p;
        PointF pointF3 = keyframe.f2328m;
        PointF pointF4 = keyframe.f2329n;
        PathMeasure pathMeasure = Utils.f2309a;
        Path path = new Path();
        path.moveTo(pointF.x, pointF.y);
        if (pointF3 == null || pointF4 == null || (pointF3.length() == 0.0f && pointF4.length() == 0.0f)) {
            path.lineTo(pointF2.x, pointF2.y);
        } else {
            float f = pointF3.x + pointF.x;
            float f2 = pointF.y + pointF3.y;
            float f3 = pointF2.x;
            float f4 = f3 + pointF4.x;
            float f5 = pointF2.y;
            path.cubicTo(f, f2, f4, f5 + pointF4.y, f3, f5);
        }
        this.f2614o = path;
    }
}
