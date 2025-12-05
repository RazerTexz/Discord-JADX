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

/* compiled from: FocusMeter.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.r.e, reason: use source file name */
/* loaded from: classes3.dex */
public class FocusMeter extends BaseMeter {

    /* renamed from: i */
    public static final CameraLogger f13974i = new CameraLogger(FocusMeter.class.getSimpleName());

    public FocusMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        f13974i.m7159a(1, "onCaptureCompleted:", "afState:", num);
        if (num == null) {
            return;
        }
        int iIntValue = num.intValue();
        if (iIntValue == 4) {
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        } else {
            if (iIntValue != 5) {
                return;
            }
            this.f13967g = false;
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: i */
    public void mo7339i(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, null);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* renamed from: m */
    public boolean mo7349m(@NonNull ActionHolder actionHolder) {
        Integer num = (Integer) ((Camera2Engine) actionHolder).f13807i0.get(CaptureRequest.CONTROL_AF_MODE);
        boolean z2 = num != null && (num.intValue() == 1 || num.intValue() == 4 || num.intValue() == 3 || num.intValue() == 2);
        f13974i.m7159a(1, "checkIsSupported:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* renamed from: n */
    public boolean mo7350n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        if (totalCaptureResult == null) {
            f13974i.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
        boolean z2 = num != null && (num.intValue() == 4 || num.intValue() == 2);
        f13974i.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* renamed from: o */
    public void mo7351o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f13974i.m7159a(1, "onStarted:", "with areas:", list);
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AF, 0)).intValue();
        if (!list.isEmpty() && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AF_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(iIntValue, list.size())).toArray(new MeteringRectangle[0]));
        }
        ((Camera2Engine) actionHolder).m7236k1();
    }
}
