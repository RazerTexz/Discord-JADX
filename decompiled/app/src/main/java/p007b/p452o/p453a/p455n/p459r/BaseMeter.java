package p007b.p452o.p453a.p455n.p459r;

import android.hardware.camera2.params.MeteringRectangle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.r.a, reason: use source file name */
/* JADX INFO: compiled from: BaseMeter.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseMeter extends BaseAction {

    /* JADX INFO: renamed from: e */
    public static final CameraLogger f13965e = new CameraLogger(BaseMeter.class.getSimpleName());

    /* JADX INFO: renamed from: f */
    public final List<MeteringRectangle> f13966f;

    /* JADX INFO: renamed from: g */
    public boolean f13967g;

    /* JADX INFO: renamed from: h */
    public boolean f13968h;

    public BaseMeter(@NonNull List<MeteringRectangle> list, boolean z2) {
        this.f13966f = list;
        this.f13968h = z2;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public final void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        boolean z2 = this.f13968h && mo7350n(actionHolder);
        if (mo7349m(actionHolder) && !z2) {
            f13965e.m7159a(1, "onStart:", "supported and not skipped. Dispatching onStarted.");
            mo7351o(actionHolder, this.f13966f);
        } else {
            f13965e.m7159a(1, "onStart:", "not supported or skipped. Dispatching COMPLETED state.");
            this.f13967g = true;
            m7341l(Integer.MAX_VALUE);
        }
    }

    /* JADX INFO: renamed from: m */
    public abstract boolean mo7349m(@NonNull ActionHolder actionHolder);

    /* JADX INFO: renamed from: n */
    public abstract boolean mo7350n(@NonNull ActionHolder actionHolder);

    /* JADX INFO: renamed from: o */
    public abstract void mo7351o(@NonNull ActionHolder actionHolder, @NonNull List<MeteringRectangle> list);
}
