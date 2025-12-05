package p007b.p452o.p453a;

import com.otaliastudios.cameraview.CameraView;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: CameraView.java */
/* renamed from: b.o.a.j, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraView6 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ int f13712j;

    /* renamed from: k */
    public final /* synthetic */ CameraView.C11195b f13713k;

    public CameraView6(CameraView.C11195b c11195b, int i) {
        this.f13713k = c11195b;
        this.f13712j = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull(it.next());
        }
    }
}
