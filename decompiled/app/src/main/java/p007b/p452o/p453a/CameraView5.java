package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import p007b.p452o.p453a.PictureResult;

/* JADX INFO: renamed from: b.o.a.i, reason: use source file name */
/* JADX INFO: compiled from: CameraView.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraView5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ PictureResult.a f13710j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13711k;

    public CameraView5(CameraView.C11195b c11195b, PictureResult.a aVar) {
        this.f13711k = c11195b;
        this.f13710j = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PictureResult pictureResult = new PictureResult(this.f13710j);
        Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            it.next().mo7158d(pictureResult);
        }
    }
}
