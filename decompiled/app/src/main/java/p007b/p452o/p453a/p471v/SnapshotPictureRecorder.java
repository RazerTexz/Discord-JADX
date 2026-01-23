package p007b.p452o.p453a.p471v;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p471v.PictureRecorder;

/* JADX INFO: renamed from: b.o.a.v.i, reason: use source file name */
/* JADX INFO: compiled from: SnapshotPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SnapshotPictureRecorder extends PictureRecorder {

    /* JADX INFO: renamed from: m */
    public static final CameraLogger f14205m = new CameraLogger(SnapshotPictureRecorder.class.getSimpleName());

    public SnapshotPictureRecorder(@NonNull PictureResult.a aVar, @Nullable PictureRecorder.a aVar2) {
        super(aVar, aVar2);
    }
}
