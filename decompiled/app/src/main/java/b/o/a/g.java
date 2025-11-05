package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* compiled from: CameraView.java */
/* loaded from: classes3.dex */
public class g implements Runnable {
    public final /* synthetic */ CameraView.b j;

    public g(CameraView.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
