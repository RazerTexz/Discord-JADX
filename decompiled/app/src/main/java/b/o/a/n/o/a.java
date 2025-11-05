package b.o.a.n.o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* compiled from: Action.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public interface a {
    void a(@NonNull c cVar);

    void b(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    void c(@NonNull c cVar, @NonNull CaptureRequest captureRequest);

    void d(@NonNull c cVar, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    void e(@NonNull c cVar);
}
