package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;

/* compiled from: ExposureReset.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.d, reason: use source file name */
/* loaded from: classes3.dex */
public class ExposureReset extends BaseReset {

    /* renamed from: f */
    public static final CameraLogger f13973f = new CameraLogger(ExposureReset.class.getSimpleName());

    public ExposureReset() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        if (this.f13938b == 0) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.FALSE);
            ((Camera2Engine) actionHolder).m7236k1();
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseReset
    /* renamed from: m */
    public void mo7352m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{meteringRectangle});
        }
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        CameraLogger cameraLogger = f13973f;
        cameraLogger.m7159a(1, "onStarted:", "last precapture trigger is", num);
        if (num != null && num.intValue() == 1) {
            cameraLogger.m7159a(1, "onStarted:", "canceling precapture.");
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(Build.VERSION.SDK_INT < 23 ? 0 : 2));
        }
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        camera2Engine.f13807i0.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.TRUE);
        camera2Engine.m7236k1();
        m7341l(0);
    }
}
