package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: TimeoutAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.i, reason: use source file name */
/* loaded from: classes3.dex */
public class TimeoutAction extends ActionWrapper {

    /* renamed from: e */
    public long f13946e;

    /* renamed from: f */
    public long f13947f;

    /* renamed from: g */
    public BaseAction f13948g;

    public TimeoutAction(long j, @NonNull BaseAction baseAction) {
        this.f13947f = j;
        this.f13948g = baseAction;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper, p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        super.mo7248b(actionHolder, captureRequest, totalCaptureResult);
        if (m7338g() || System.currentTimeMillis() <= this.f13946e + this.f13947f) {
            return;
        }
        this.f13948g.mo7330a(actionHolder);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper, p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13946e = System.currentTimeMillis();
        super.mo7249j(actionHolder);
    }

    @Override // p007b.p452o.p453a.p455n.p456o.ActionWrapper
    @NonNull
    /* renamed from: m */
    public BaseAction mo7336m() {
        return this.f13948g;
    }
}
