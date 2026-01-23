package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p452o.p453a.p455n.Camera2Engine;

/* JADX INFO: renamed from: b.o.a.n.o.e, reason: use source file name */
/* JADX INFO: compiled from: BaseAction.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public abstract class BaseAction implements Action2 {

    /* JADX INFO: renamed from: a */
    public final List<ActionCallback> f13937a = new ArrayList();

    /* JADX INFO: renamed from: b */
    public int f13938b;

    /* JADX INFO: renamed from: c */
    public ActionHolder f13939c;

    /* JADX INFO: renamed from: d */
    public boolean f13940d;

    @Override // p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: a */
    public final void mo7330a(@NonNull ActionHolder actionHolder) {
        ((Camera2Engine) actionHolder).f13814p0.remove(this);
        if (!m7338g()) {
            mo7335h(actionHolder);
            m7341l(Integer.MAX_VALUE);
        }
        this.f13940d = false;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: b */
    public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
    }

    @Override // p007b.p452o.p453a.p455n.p456o.Action2
    @CallSuper
    /* JADX INFO: renamed from: c */
    public void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest) {
        if (this.f13940d) {
            mo7249j(actionHolder);
            this.f13940d = false;
        }
    }

    @Override // p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: d */
    public void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult) {
    }

    @Override // p007b.p452o.p453a.p455n.p456o.Action2
    /* JADX INFO: renamed from: e */
    public final void mo7333e(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        if (!camera2Engine.f13814p0.contains(this)) {
            camera2Engine.f13814p0.add(this);
        }
        if (((Camera2Engine) actionHolder).f13808j0 != null) {
            mo7249j(actionHolder);
        } else {
            this.f13940d = true;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m7337f(@NonNull ActionCallback actionCallback) {
        if (this.f13937a.contains(actionCallback)) {
            return;
        }
        this.f13937a.add(actionCallback);
        actionCallback.mo7334a(this, this.f13938b);
    }

    /* JADX INFO: renamed from: g */
    public boolean m7338g() {
        return this.f13938b == Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: h */
    public void mo7335h(@NonNull ActionHolder actionHolder) {
    }

    /* JADX INFO: renamed from: i */
    public void mo7339i(@NonNull ActionHolder actionHolder) {
    }

    @CallSuper
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
    }

    @NonNull
    /* JADX INFO: renamed from: k */
    public <T> T m7340k(@NonNull CameraCharacteristics.Key<T> key, @NonNull T t) {
        T t2 = (T) ((Camera2Engine) this.f13939c).f13805g0.get(key);
        return t2 == null ? t : t2;
    }

    /* JADX INFO: renamed from: l */
    public final void m7341l(int i) {
        if (i != this.f13938b) {
            this.f13938b = i;
            Iterator<ActionCallback> it = this.f13937a.iterator();
            while (it.hasNext()) {
                it.next().mo7334a(this, this.f13938b);
            }
            if (this.f13938b == Integer.MAX_VALUE) {
                ((Camera2Engine) this.f13939c).f13814p0.remove(this);
                mo7339i(this.f13939c);
            }
        }
    }
}
