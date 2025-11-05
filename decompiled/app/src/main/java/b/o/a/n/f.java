package b.o.a.n;

import android.hardware.camera2.CaptureRequest;
import androidx.annotation.NonNull;

/* compiled from: Camera2Engine.java */
/* loaded from: classes3.dex */
public class f extends b.o.a.n.o.e {
    public final /* synthetic */ d e;

    public f(d dVar) {
        this.e = dVar;
    }

    @Override // b.o.a.n.o.e
    public void j(@NonNull b.o.a.n.o.c cVar) {
        this.c = cVar;
        this.e.f1(((d) cVar).f1921i0);
        d dVar = (d) cVar;
        CaptureRequest.Builder builder = dVar.f1921i0;
        CaptureRequest.Key key = CaptureRequest.CONTROL_AE_LOCK;
        Boolean bool = Boolean.FALSE;
        builder.set(key, bool);
        dVar.f1921i0.set(CaptureRequest.CONTROL_AWB_LOCK, bool);
        dVar.k1();
        l(Integer.MAX_VALUE);
    }
}
