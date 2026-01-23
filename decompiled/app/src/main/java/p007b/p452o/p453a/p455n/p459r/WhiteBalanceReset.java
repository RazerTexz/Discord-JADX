package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;

/* JADX INFO: renamed from: b.o.a.n.r.j, reason: use source file name */
/* JADX INFO: compiled from: WhiteBalanceReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class WhiteBalanceReset extends BaseReset {

    /* JADX INFO: renamed from: f */
    public static final CameraLogger f13984f = new CameraLogger(WhiteBalanceReset.class.getSimpleName());

    public WhiteBalanceReset() {
        super(true);
    }

    @Override // p007b.p452o.p453a.p455n.p459r.BaseReset
    /* JADX INFO: renamed from: m */
    public void mo7352m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle) {
        f13984f.m7159a(2, "onStarted:", "with area:", meteringRectangle);
        int iIntValue = ((Integer) m7340k(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB, 0)).intValue();
        if (meteringRectangle != null && iIntValue > 0) {
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{meteringRectangle});
            ((Camera2Engine) actionHolder).m7236k1();
        }
        m7341l(Integer.MAX_VALUE);
    }
}
