package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: CameraView.java */
/* loaded from: classes3.dex */
public class j implements Runnable {
    public final /* synthetic */ int j;
    public final /* synthetic */ CameraView.b k;

    public j(CameraView.b bVar, int i) {
        this.k = bVar;
        this.j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
