package p007b.p452o.p453a.p455n;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;

/* JADX INFO: renamed from: b.o.a.n.f, reason: use source file name */
/* JADX INFO: compiled from: Camera2Engine.java */
/* JADX INFO: loaded from: classes3.dex */
public class Camera2Engine3 extends BaseAction {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Camera2Engine f13865e;

    public Camera2Engine3(Camera2Engine camera2Engine) {
        this.f13865e = camera2Engine;
    }

    @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
    /* JADX INFO: renamed from: j */
    public void mo7249j(@NonNull ActionHolder actionHolder) {
        this.f13939c = actionHolder;
        this.f13865e.m7231f1(((Camera2Engine) actionHolder).f13807i0);
        Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
        CaptureRequest.Builder builder = camera2Engine.f13807i0;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.FALSE;
        builder.set(key, bool);
        camera2Engine.f13807i0.set(CaptureRequest.CONTROL_AWB_LOCK, bool);
        camera2Engine.m7236k1();
        m7341l(Integer.MAX_VALUE);
    }
}
