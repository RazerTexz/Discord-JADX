package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.o.a.h, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CameraView.C11195b f13709j;

    public CameraView4(CameraView.C11195b c11195b) {
        this.f13709j = c11195b;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
