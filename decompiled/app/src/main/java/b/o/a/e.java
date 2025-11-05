package b.o.a;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import java.util.Objects;

/* compiled from: CameraUtils.java */
/* loaded from: classes3.dex */
public class e {
    public static final b a = new b(e.class.getSimpleName());

    public static boolean a(@NonNull b.o.a.m.e eVar) {
        Objects.requireNonNull(b.o.a.n.q.a.a());
        int iIntValue = b.o.a.n.q.a.d.get(eVar).intValue();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == iIntValue) {
                return true;
            }
        }
        return false;
    }
}
