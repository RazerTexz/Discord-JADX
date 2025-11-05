package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import b.i.a.c.g3.z.k;
import java.util.Iterator;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ k j;

    public /* synthetic */ c(k kVar) {
        this.j = kVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar = this.j;
        Surface surface = kVar.r;
        if (surface != null) {
            Iterator<k.b> it = kVar.j.iterator();
            while (it.hasNext()) {
                it.next().q(surface);
            }
        }
        SurfaceTexture surfaceTexture = kVar.q;
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
        kVar.q = null;
        kVar.r = null;
    }
}
