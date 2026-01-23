package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.h, reason: use source file name */
/* JADX INFO: compiled from: SequenceAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class SequenceAction extends BaseAction {

    /* JADX INFO: renamed from: e */
    public final List<BaseAction> f13943e;

    /* JADX INFO: renamed from: f */
    public int f13944f = -1;

    /* JADX INFO: renamed from: b.o.a.n.o.h$a */
    /* JADX INFO: compiled from: SequenceAction.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull Action2 action2, int i) {
            if (i == Integer.MAX_VALUE) {
                ((BaseAction) action2).f13937a.remove(this);
                SequenceAction.this.m7342m();
            }
        }
    }

    public SequenceAction(@NonNull List<BaseAction> list) {
        this.f13943e = list;
        m7342m();
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7248b(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(actionHolder);
            this.f13940d = false;
        }
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7331c(actionHolder, captureRequest);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7332d(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull ActionHolder actionHolder) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7335h(actionHolder);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7249j(actionHolder);
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m7342m() {
        int i = this.f13944f;
        boolean z2 = i == -1;
        if (i == this.f13943e.size() - 1) {
            m7341l(Integer.MAX_VALUE);
            return;
        }
        int i2 = this.f13944f + 1;
        this.f13944f = i2;
        this.f13943e.get(i2).m7337f(new a());
        if (z2) {
            return;
        }
        this.f13943e.get(this.f13944f).mo7249j(this.f13939c);
    }
}
