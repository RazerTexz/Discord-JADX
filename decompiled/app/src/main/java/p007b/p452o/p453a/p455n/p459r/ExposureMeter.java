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

/* JADX INFO: renamed from: b.o.a.n.r.c, reason: use source file name */
/* JADX INFO: compiled from: ExposureMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class ExposureMeter extends BaseMeter {

    /* JADX INFO: renamed from: i */
    public static final CameraLogger f13970i = new CameraLogger(ExposureMeter.class.getSimpleName());

    /* JADX INFO: renamed from: j */
    public boolean f13971j;

    /* JADX INFO: renamed from: k */
    public boolean f13972k;

    public ExposureMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        super(list, z2);
        this.f13971j = false;
        this.f13972k = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_PRECAPTURE_TRIGGER);
        f13970i.m7159a(1, "onCaptureCompleted:", "aeState:", num, "aeTriggerState:", num2);
        if (num == null) {
            return;
        }
        if (this.f13938b == 0) {
            int iIntValue = num.intValue();
            if (iIntValue == 2) {
                if (num2 != null && num2.intValue() == 1) {
                    this.f13967g = true;
                    m7341l(Integer.MAX_VALUE);
                }
            } else if (iIntValue == 3) {
                this.f13967g = false;
                m7341l(Integer.MAX_VALUE);
            } else if (iIntValue != 4) {
                if (iIntValue == 5) {
                    m7341l(1);
                }
            }
        }
        if (this.f13938b == 1) {
            int iIntValue2 = num.intValue();
            if (iIntValue2 != 2) {
                if (iIntValue2 == 3) {
                    this.f13967g = false;
                    m7341l(Integer.MAX_VALUE);
                    return;
                } else if (iIntValue2 != 4) {
                    return;
                }
            }
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, null);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: m */
    public boolean mo7349m(@NonNull ActionHolder actionHolder) {
        boolean z2 = ((Integer) m7340k(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL, -1)).intValue() == 2;
        Integer num = (Integer) ((Camera2Engine) actionHolder).f13807i0.get(CaptureRequest.CONTROL_AE_MODE);
        boolean z3 = num != null && (num.intValue() == 1 || num.intValue() == 3 || num.intValue() == 2 || num.intValue() == 4 || num.intValue() == 5);
        this.f13972k = !z2;
        boolean z4 = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue() > 0;
        this.f13971j = z4;
        boolean z5 = z3 && (this.f13972k || z4);
        f13970i.m7159a(1, "checkIsSupported:", Boolean.valueOf(z5), "trigger:", Boolean.valueOf(this.f13972k), "areas:", Boolean.valueOf(this.f13971j));
        return z5;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: n */
    public boolean mo7350n(@NonNull ActionHolder actionHolder) {
        TotalCaptureResult totalCaptureResult = ((Camera2Engine) actionHolder).f13808j0;
        if (totalCaptureResult == null) {
            f13970i.m7159a(1, "checkShouldSkip: false - lastResult is null.");
            return false;
        }
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        boolean z2 = num != null && num.intValue() == 2;
        f13970i.m7159a(1, "checkShouldSkip:", Boolean.valueOf(z2));
        return z2;
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseMeter
    /* JADX INFO: renamed from: o */
    public void mo7351o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list) {
        f13970i.m7159a(1, "onStarted:", "with areas:", list);
        if (this.f13971j && !list.isEmpty()) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_REGIONS, (MeteringRectangle[]) list.subList(0, Math.min(((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AE, 0)).intValue(), list.size())).toArray(new MeteringRectangle[0]));
        }
        if (this.f13972k) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
        }
        ((Camera2Engine) actionHolder).m7236k1();
        if (this.f13972k) {
            m7341l(0);
        } else {
            m7341l(1);
        }
    }
}
