package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;

/* compiled from: FocusReset.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.f, reason: use source file name */
/* loaded from: classes3.dex */
public class FocusReset extends BaseReset {

    /* renamed from: f */
    public static final CameraLogger f13975f = new CameraLogger(FocusReset.class.getSimpleName());

    public FocusReset() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseReset
    /* renamed from: m */
    public void mo7352m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        boolean z2;
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        boolean z3 = true;
        if (meteringRectangle == null || iIntValue <= 0) {
            z2 = false;
        } else {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{meteringRectangle});
            z2 = true;
        }
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        Integer num = totalCaptureResult == null ? null : (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER);
        f13975f.m7159a(2, "onStarted:", "last focus trigger is", num);
        if (num == null || num.intValue() != 1) {
            z3 = z2;
        } else {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        }
        if (z3) {
            ((Camera2Engine) actionHolder).m7236k1();
        }
        m7341l(Integer.MAX_VALUE);
    }
}
