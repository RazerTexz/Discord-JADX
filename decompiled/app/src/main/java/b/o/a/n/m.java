package b.o.a.n;

import com.otaliastudios.cameraview.CameraView;

/* compiled from: CameraEngine.java */
/* loaded from: classes3.dex */
public class m implements b.i.a.f.n.e<Void> {
    public final /* synthetic */ i a;

    public m(i iVar) {
        this.a = iVar;
    }

    @Override // b.i.a.f.n.e
    public void onSuccess(Void r6) {
        CameraView.b bVar = (CameraView.b) this.a.m;
        bVar.f3177b.a(1, "dispatchOnCameraClosed");
        CameraView.this.u.post(new b.o.a.g(bVar));
    }
}
