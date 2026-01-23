package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.d, reason: use source file name */
/* JADX INFO: compiled from: ActionWrapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class ActionWrapper extends BaseAction {

    /* JADX INFO: renamed from: b.o.a.n.o.d$a */
    /* JADX INFO: compiled from: ActionWrapper.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull Action2 action2, int i) {
            ActionWrapper.this.m7341l(i);
            if (i == Integer.MAX_VALUE) {
                ((BaseAction) action2).f13937a.remove(this);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        mo7336m().mo7248b(actionHolder, captureRequest, totalCaptureResult);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(actionHolder);
            this.f13940d = false;
        }
        mo7336m().mo7331c(actionHolder, captureRequest);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        mo7336m().mo7332d(actionHolder, captureRequest, captureResult);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull ActionHolder actionHolder) {
        mo7336m().mo7335h(actionHolder);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        mo7336m().m7337f(new a());
        mo7336m().mo7249j(actionHolder);
    }

    @NonNull
    /* JADX INFO: renamed from: m */
    public abstract BaseAction mo7336m();
}
