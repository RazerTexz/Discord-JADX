package b.o.a;

import b.o.a.l;
import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* compiled from: CameraView.java */
/* loaded from: classes3.dex */
public class i implements Runnable {
    public final /* synthetic */ l.a j;
    public final /* synthetic */ CameraView.b k;

    public i(CameraView.b bVar, l.a aVar) {
        this.k = bVar;
        this.j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        l lVar = new l(this.j);
        Iterator<a> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            it.next().d(lVar);
        }
    }
}
