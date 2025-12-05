package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* compiled from: SequenceAction.java */
@RequiresApi(21)
/* renamed from: b.o.a.n.o.h, reason: use source file name */
/* loaded from: classes3.dex */
public class SequenceAction extends BaseAction {

    /* renamed from: e */
    public final List<BaseAction> f13943e;

    /* renamed from: f */
    public int f13944f = -1;

    /* compiled from: SequenceAction.java */
    /* renamed from: b.o.a.n.o.h$a */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
        /* renamed from: a */
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
    /* renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7248b(actionHolder, captureRequest, totalCaptureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* renamed from: c */
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
    /* renamed from: d */
    public void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7332d(actionHolder, captureRequest, captureResult);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: h */
    public void mo7335h(@NonNull ActionHolder actionHolder) {
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7335h(actionHolder);
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        int i = this.f13944f;
        if (i >= 0) {
            this.f13943e.get(i).mo7249j(actionHolder);
        }
    }

    /* renamed from: m */
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
