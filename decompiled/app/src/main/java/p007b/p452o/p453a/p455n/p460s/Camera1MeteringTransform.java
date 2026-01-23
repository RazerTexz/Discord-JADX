package p007b.p452o.p453a.p455n.p460s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p469t.MeteringTransform;
import p007b.p452o.p453a.p473x.Size3;

/* JADX INFO: renamed from: b.o.a.n.s.a, reason: use source file name */
/* JADX INFO: compiled from: Camera1MeteringTransform.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera1MeteringTransform implements MeteringTransform<Camera.Area> {

    /* JADX INFO: renamed from: a */
    public static final CameraLogger f13985a = new CameraLogger(Camera1MeteringTransform.class.getSimpleName());

    /* JADX INFO: renamed from: b */
    public final int f13986b;

    /* JADX INFO: renamed from: c */
    public final Size3 f13987c;

    public Camera1MeteringTransform(@NonNull Angles angles, @NonNull Size3 size3) {
        this.f13986b = -angles.m7358c(Reference2.SENSOR, Reference2.VIEW, 1);
        this.f13987c = size3;
    }

    @Override // p007b.p452o.p453a.p469t.MeteringTransform
    @NonNull
    /* JADX INFO: renamed from: a */
    public Camera.Area mo7354a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new Camera.Area(rect, i);
    }

    @Override // p007b.p452o.p453a.p469t.MeteringTransform
    @NonNull
    /* JADX INFO: renamed from: b */
    public PointF mo7355b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF();
        float f = pointF.x;
        Size3 size3 = this.f13987c;
        pointF2.x = ((f / size3.f14251j) * 2000.0f) - 1000.0f;
        pointF2.y = ((pointF.y / size3.f14252k) * 2000.0f) - 1000.0f;
        PointF pointF3 = new PointF();
        double d = (((double) this.f13986b) * 3.141592653589793d) / 180.0d;
        pointF3.x = (float) ((Math.cos(d) * ((double) pointF2.x)) - (Math.sin(d) * ((double) pointF2.y)));
        pointF3.y = (float) ((Math.cos(d) * ((double) pointF2.y)) + (Math.sin(d) * ((double) pointF2.x)));
        f13985a.m7159a(1, "scaled:", pointF2, "rotated:", pointF3);
        return pointF3;
    }
}
