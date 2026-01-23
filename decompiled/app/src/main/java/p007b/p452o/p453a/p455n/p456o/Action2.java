package p007b.p452o.p453a.p455n.p456o;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.n.o.a, reason: use source file name */
/* JADX INFO: compiled from: Action.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public interface Action2 {
    /* JADX INFO: renamed from: a */
    void mo7330a(@NonNull ActionHolder actionHolder);

    /* JADX INFO: renamed from: b */
    void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult);

    /* JADX INFO: renamed from: c */
    void mo7331c(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest);

    /* JADX INFO: renamed from: d */
    void mo7332d(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull CaptureResult captureResult);

    /* JADX INFO: renamed from: e */
    void mo7333e(@NonNull ActionHolder actionHolder);
}
