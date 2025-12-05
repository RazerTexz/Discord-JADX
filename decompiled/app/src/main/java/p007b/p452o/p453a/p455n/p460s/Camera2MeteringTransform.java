package p007b.p452o.p453a.p455n.p460s;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p469t.MeteringTransform;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;

/* compiled from: Camera2MeteringTransform.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.s.b, reason: use source file name */
/* loaded from: classes3.dex */
public class Camera2MeteringTransform implements MeteringTransform<MeteringRectangle> {

    /* renamed from: a */
    public static final CameraLogger f13988a = new CameraLogger(Camera2MeteringTransform.class.getSimpleName());

    /* renamed from: b */
    public final Angles f13989b;

    /* renamed from: c */
    public final Size3 f13990c;

    /* renamed from: d */
    public final Size3 f13991d;

    /* renamed from: e */
    public final boolean f13992e;

    /* renamed from: f */
    public final CameraCharacteristics f13993f;

    /* renamed from: g */
    public final CaptureRequest.Builder f13994g;

    public Camera2MeteringTransform(@NonNull Angles angles, @NonNull Size3 size3, @NonNull Size3 size32, boolean z2, @NonNull CameraCharacteristics cameraCharacteristics, @NonNull CaptureRequest.Builder builder) {
        this.f13989b = angles;
        this.f13990c = size3;
        this.f13991d = size32;
        this.f13992e = z2;
        this.f13993f = cameraCharacteristics;
        this.f13994g = builder;
    }

    @Override // p007b.p452o.p453a.p469t.MeteringTransform
    @NonNull
    /* renamed from: a */
    public MeteringRectangle mo7354a(@NonNull RectF rectF, int i) {
        Rect rect = new Rect();
        rectF.round(rect);
        return new MeteringRectangle(rect, i);
    }

    @Override // p007b.p452o.p453a.p469t.MeteringTransform
    @NonNull
    /* renamed from: b */
    public PointF mo7355b(@NonNull PointF pointF) {
        PointF pointF2 = new PointF(pointF.x, pointF.y);
        Size3 size3 = this.f13990c;
        Size3 size32 = this.f13991d;
        int iRound = size3.f14251j;
        int iRound2 = size3.f14252k;
        AspectRatio2 aspectRatio2M7448g = AspectRatio2.m7448g(size32);
        AspectRatio2 aspectRatio2M7447f = AspectRatio2.m7447f(size3.f14251j, size3.f14252k);
        if (this.f13992e) {
            if (aspectRatio2M7448g.m7450i() > aspectRatio2M7447f.m7450i()) {
                float fM7450i = aspectRatio2M7448g.m7450i() / aspectRatio2M7447f.m7450i();
                float f = pointF2.x;
                float f2 = size3.f14251j;
                pointF2.x = (((fM7450i - 1.0f) * f2) / 2.0f) + f;
                iRound = Math.round(f2 * fM7450i);
            } else {
                float fM7450i2 = aspectRatio2M7447f.m7450i() / aspectRatio2M7448g.m7450i();
                float f3 = pointF2.y;
                float f4 = size3.f14252k;
                pointF2.y = (((fM7450i2 - 1.0f) * f4) / 2.0f) + f3;
                iRound2 = Math.round(f4 * fM7450i2);
            }
        }
        Size3 size3M7451f = this.f13991d;
        pointF2.x = (size3M7451f.f14251j / iRound) * pointF2.x;
        pointF2.y = (size3M7451f.f14252k / iRound2) * pointF2.y;
        int iM7358c = this.f13989b.m7358c(Reference2.SENSOR, Reference2.VIEW, 1);
        boolean z2 = iM7358c % 180 != 0;
        float f5 = pointF2.x;
        float f6 = pointF2.y;
        if (iM7358c == 0) {
            pointF2.x = f5;
            pointF2.y = f6;
        } else if (iM7358c == 90) {
            pointF2.x = f6;
            pointF2.y = size3M7451f.f14251j - f5;
        } else if (iM7358c == 180) {
            pointF2.x = size3M7451f.f14251j - f5;
            pointF2.y = size3M7451f.f14252k - f6;
        } else {
            if (iM7358c != 270) {
                throw new IllegalStateException(outline.m871q("Unexpected angle ", iM7358c));
            }
            pointF2.x = size3M7451f.f14252k - f6;
            pointF2.y = f5;
        }
        if (z2) {
            size3M7451f = size3M7451f.m7451f();
        }
        Rect rect = (Rect) this.f13994g.get(CaptureRequest.SCALER_CROP_REGION);
        int iWidth = rect == null ? size3M7451f.f14251j : rect.width();
        int iHeight = rect == null ? size3M7451f.f14252k : rect.height();
        pointF2.x = ((iWidth - size3M7451f.f14251j) / 2.0f) + pointF2.x;
        pointF2.y = ((iHeight - size3M7451f.f14252k) / 2.0f) + pointF2.y;
        Rect rect2 = (Rect) this.f13994g.get(CaptureRequest.SCALER_CROP_REGION);
        pointF2.x += rect2 == null ? 0.0f : rect2.left;
        pointF2.y += rect2 == null ? 0.0f : rect2.top;
        Rect rect3 = (Rect) this.f13993f.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect3 == null) {
            rect3 = new Rect(0, 0, iWidth, iHeight);
        }
        int iWidth2 = rect3.width();
        int iHeight2 = rect3.height();
        CameraLogger cameraLogger = f13988a;
        cameraLogger.m7159a(1, "input:", pointF, "output (before clipping):", pointF2);
        if (pointF2.x < 0.0f) {
            pointF2.x = 0.0f;
        }
        if (pointF2.y < 0.0f) {
            pointF2.y = 0.0f;
        }
        float f7 = iWidth2;
        if (pointF2.x > f7) {
            pointF2.x = f7;
        }
        float f8 = iHeight2;
        if (pointF2.y > f8) {
            pointF2.y = f8;
        }
        cameraLogger.m7159a(1, "input:", pointF, "output (after clipping):", pointF2);
        return pointF2;
    }
}
