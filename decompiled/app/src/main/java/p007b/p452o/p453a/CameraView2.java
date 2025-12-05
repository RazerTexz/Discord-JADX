package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;

/* compiled from: CameraView.java */
/* renamed from: b.o.a.f, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraView2 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ CameraOptions f13706j;

    /* renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13707k;

    public CameraView2(CameraView.C11195b c11195b, CameraOptions cameraOptions) {
        this.f13707k = c11195b;
        this.f13706j = cameraOptions;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            it.next().mo7157c(this.f13706j);
        }
    }
}
