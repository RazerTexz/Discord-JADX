package p007b.p452o.p453a.p455n;

import com.otaliastudios.cameraview.CameraView;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4361e;
import p007b.p452o.p453a.CameraView3;

/* JADX INFO: renamed from: b.o.a.n.m, reason: use source file name */
/* JADX INFO: compiled from: CameraEngine.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraEngine5 implements InterfaceC4361e<Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CameraEngine f13934a;

    public CameraEngine5(CameraEngine cameraEngine) {
        this.f13934a = cameraEngine;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4361e
    public void onSuccess(Void r6) {
        CameraView.C11195b c11195b = (CameraView.C11195b) this.f13934a.f13921m;
        c11195b.f22141b.m7159a(1, "dispatchOnCameraClosed");
        CameraView.this.f22133u.post(new CameraView3(c11195b));
    }
}
