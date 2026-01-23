package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* JADX INFO: renamed from: b.o.a.g, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView3 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ CameraView.C11195b f13708j;

    public CameraView3(CameraView.C11195b c11195b) {
        this.f13708j = c11195b;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            it.next().mo7155a();
        }
    }
}
