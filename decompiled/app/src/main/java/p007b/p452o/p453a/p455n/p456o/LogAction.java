package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.CameraEngine;

/* JADX INFO: renamed from: b.o.a.n.o.g, reason: use source file name */
/* JADX INFO: compiled from: LogAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class LogAction extends BaseAction {

    /* JADX INFO: renamed from: e */
    public static final CameraLogger f13941e = new CameraLogger(CameraEngine.class.getSimpleName());

    /* JADX INFO: renamed from: f */
    public String f13942f;

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num3 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        String str = "aeMode: " + num + " aeLock: " + ((Boolean) totalCaptureResult.get(CaptureResult.CONTROL_AE_LOCK)) + " aeState: " + num2 + " aeTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER)) + " afState: " + num3 + " afTriggerState: " + ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_TRIGGER));
        if (str.equals(this.f13942f)) {
            return;
        }
        this.f13942f = str;
        f13941e.m7159a(1, str);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull ActionHolder actionHolder) {
        m7341l(0);
        mo7333e(actionHolder);
    }
}
