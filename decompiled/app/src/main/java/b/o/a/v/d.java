package b.o.a.v;

import android.media.MediaActionSound;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.l;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: PictureRecorder.java */
/* loaded from: classes3.dex */
public abstract class d {

    @VisibleForTesting(otherwise = 4)
    public l.a j;

    @VisibleForTesting
    public a k;
    public Exception l;

    /* compiled from: PictureRecorder.java */
    public interface a {
        void a(@Nullable l.a aVar, @Nullable Exception exc);
    }

    public d(@NonNull l.a aVar, @Nullable a aVar2) {
        this.j = aVar;
        this.k = aVar2;
    }

    public void a(boolean z2) {
        CameraView cameraView;
        boolean z3;
        a aVar = this.k;
        if (aVar != null) {
            boolean z4 = !z2;
            CameraView.b bVar = (CameraView.b) ((b.o.a.n.g) aVar).m;
            if (z4 && (z3 = (cameraView = CameraView.this).l) && z3) {
                if (cameraView.B == null) {
                    cameraView.B = new MediaActionSound();
                }
                cameraView.B.play(0);
            }
            CameraView.this.u.post(new b.o.a.h(bVar));
        }
    }

    public void b() {
        a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.j, this.l);
            this.k = null;
            this.j = null;
        }
    }

    public abstract void c();
}
