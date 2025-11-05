package b.o.a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: CameraView.java */
/* loaded from: classes3.dex */
public class h implements Runnable {
    public final /* synthetic */ CameraView.b j;

    public h(CameraView.b bVar) {
        this.j = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<a> it = CameraView.this.D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
