package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.r.i, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalanceMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class WhiteBalanceMeter extends BaseMeter {

    /* JADX INFO: renamed from: i */
    public static final CameraLogger f13983i = new CameraLogger(WhiteBalanceMeter.class.getSimpleName());

    public WhiteBalanceMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        f13983i.m7159a(1, "onCaptureCompleted:", "awbState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 2) {
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 3) {
                return;
            }
            this.f13967g = false;
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: m */
    public boolean mo7349m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() != 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f13807i0.get(CaptureRequest.CONTROL_AWB_MODE);
        boolean z3 = z2 && num != null && num.intValue() == 1;
        f13983i.m7159a(1, "checkIsSupported:", Boolean.valueOf(z3));
        return z3;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: n */
    public boolean mo7350n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        if (totalCaptureResult == null) {
            f13983i.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        f13983i.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: o */
    public void mo7351o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f13983i.m7159a(1, "onStarted:", "with areas:", list);
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (list.isEmpty() || iIntValue <= 0) {
            return;
        }
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AWB_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        ((Camera2Engine) actionHolder).m7236k1();
    }
}
