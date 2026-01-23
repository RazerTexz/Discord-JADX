package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: b.o.a.n.o.j, reason: use source file name */
/* JADX INFO: compiled from: TogetherAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class TogetherAction extends BaseAction {

    /* JADX INFO: renamed from: e */
    public final List<BaseAction> f13949e;

    /* JADX INFO: renamed from: f */
    public final List<BaseAction> f13950f;

    /* JADX INFO: renamed from: b.o.a.n.o.j$a */
    /* JADX INFO: compiled from: TogetherAction.java */
    public class a implements ActionCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.ActionCallback
        /* JADX INFO: renamed from: a */
        public void mo7334a(@NonNull Action2 action2, int i) {
            if (i == Integer.MAX_VALUE) {
                TogetherAction.this.f13950f.remove(action2);
            }
            if (TogetherAction.this.f13950f.isEmpty()) {
                TogetherAction.this.m7341l(Integer.MAX_VALUE);
            }
        }
    }

    public TogetherAction(@NonNull List<BaseAction> list) {
        this.f13949e = new ArrayList(list);
        this.f13950f = new ArrayList(list);
        Iterator<BaseAction> it = list.iterator();
        while (it.hasNext()) {
            it.next().m7337f(new a());
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
        for (BaseAction baseAction : this.f13949e) {
            if (!baseAction.m7338g()) {
                baseAction.mo7248b(actionHolder, captureRequest, totalCaptureResult);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(actionHolder);
            this.f13940d = false;
        }
        for (BaseAction baseAction : this.f13949e) {
            if (!baseAction.m7338g()) {
                baseAction.mo7331c(actionHolder, captureRequest);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
        for (BaseAction baseAction : this.f13949e) {
            if (!baseAction.m7338g()) {
                baseAction.mo7332d(actionHolder, captureRequest, captureResult);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull ActionHolder actionHolder) {
        for (BaseAction baseAction : this.f13949e) {
            if (!baseAction.m7338g()) {
                baseAction.mo7335h(actionHolder);
            }
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        for (BaseAction baseAction : this.f13949e) {
            if (!baseAction.m7338g()) {
                baseAction.mo7249j(actionHolder);
            }
        }
    }
}
