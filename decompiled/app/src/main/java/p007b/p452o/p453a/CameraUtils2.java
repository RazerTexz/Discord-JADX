package p007b.p452o.p453a;

import android.hardware.Camera;
import androidx.annotation.NonNull;
import java.util.Objects;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p455n.p458q.Camera1Mapper;

/* JADX INFO: renamed from: b.o.a.e, reason: use source file name */
/* JADX INFO: compiled from: CameraUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class CameraUtils2 {

    /* JADX INFO: renamed from: a */
    public static final CameraLogger f13705a = new CameraLogger(CameraUtils2.class.getSimpleName());

    /* JADX INFO: renamed from: a */
    public static boolean m7164a(@NonNull Facing facing) {
        Objects.requireNonNull(Camera1Mapper.m7346a());
        int iIntValue = Camera1Mapper.f13959d.get(facing).intValue();
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
