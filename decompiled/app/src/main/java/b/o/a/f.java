package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* compiled from: CameraView.java */
/* loaded from: classes3.dex */
public class f implements Runnable {
    public final /* synthetic */ c j;
    public final /* synthetic */ CameraView.b k;

    public f(CameraView.b bVar, c cVar) {
        this.k = bVar;
        this.j = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().c(this.j);
        }
    }
}
