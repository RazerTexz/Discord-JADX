package b.o.a.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: CameraEngine.java */
/* loaded from: classes3.dex */
public class k implements b.i.a.f.n.f<b.o.a.c, Void> {
    public final /* synthetic */ i a;

    public k(i iVar) {
        this.a = iVar;
    }

    @Override // b.i.a.f.n.f
    @NonNull
    public Task<Void> a(@Nullable b.o.a.c cVar) throws Exception {
        b.o.a.c cVar2 = cVar;
        if (cVar2 == null) {
            throw new RuntimeException("Null options!");
        }
        CameraView.b bVar = (CameraView.b) this.a.m;
        bVar.f3177b.a(1, "dispatchOnCameraOpened", cVar2);
        CameraView.this.u.post(new b.o.a.f(bVar, cVar2));
        return b.i.a.f.e.o.f.Z(null);
    }
}
