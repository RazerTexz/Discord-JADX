package p007b.p452o.p453a.p455n.p457p;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;

/* compiled from: WhiteBalanceLock.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.p.e, reason: use source file name */
/* loaded from: classes3.dex */
public class WhiteBalanceLock extends BaseLock {

    /* renamed from: e */
    public static final CameraLogger f13955e = new CameraLogger(WhiteBalanceLock.class.getSimpleName());

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        f13955e.m7159a(1, "processCapture:", "awbState:", num);
        if (num != null && num.intValue() == 3) {
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: m */
    public boolean mo7343m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f13807i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        f13955e.m7159a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: n */
    public boolean mo7344n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        if (totalCaptureResult == null) {
            f13955e.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 3;
        f13955e.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: o */
    public void mo7345o(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.TRUE);
        ((Camera2Engine) actionHolder).m7236k1();
    }
}
