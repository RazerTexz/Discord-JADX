package p007b.p452o.p453a.p455n.p459r;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.r.b, reason: use source file name */
/* JADX INFO: compiled from: BaseReset.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseReset extends BaseAction {

    /* JADX INFO: renamed from: e */
    public boolean f13969e;

    public BaseReset(boolean z2) {
        this.f13969e = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public final void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        mo7352m(actionHolder, this.f13969e ? new MeteringRectangle((Rect) m7340k(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect()), 0) : null);
    }

    /* JADX INFO: renamed from: m */
    public abstract void mo7352m(@NonNull ActionHolder actionHolder, @Nullable MeteringRectangle meteringRectangle);
}
