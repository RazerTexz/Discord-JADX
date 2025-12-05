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

/* compiled from: FocusLock.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.p.c, reason: use source file name */
/* loaded from: classes3.dex */
public class FocusLock extends BaseLock {

    /* renamed from: e */
    public static final CameraLogger f13953e = new CameraLogger(FocusLock.class.getSimpleName());

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        f13953e.m7159a(1, "onCapture:", "afState:", num, "afMode:", num2);
        if (num == null || num2 == null || num2.intValue() != 1) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0 || iIntValue == 2 || iIntValue == 4 || iIntValue == 5 || iIntValue == 6) {
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: m */
    public boolean mo7343m(@NonNull ActionHolder actionHolder) {
        for (int i : (int[]) m7340k(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0])) {
            if (i == 1) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: n */
    public boolean mo7344n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        if (totalCaptureResult == null) {
            f13953e.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 5 || num.intValue() == 0 || num.intValue() == 2 || num.intValue() == 6);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE);
        boolean z3 = z2 && (num2 != null && num2.intValue() == 1);
        f13953e.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p457p.BaseLock
    /* renamed from: o */
    public void mo7345o(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_MODE, 1);
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        camera2Engine.f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        camera2Engine.m7236k1();
    }
}
