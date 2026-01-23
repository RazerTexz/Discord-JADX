package p007b.p452o.p453a.p471v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.p456o.Action2;
import p007b.p452o.p453a.p455n.p456o.ActionHolder;
import p007b.p452o.p453a.p455n.p456o.BaseAction;
import p007b.p452o.p453a.p455n.p456o.CompletionCallback;
import p007b.p452o.p453a.p455n.p456o.SequenceAction;
import p007b.p452o.p453a.p455n.p456o.TimeoutAction;
import p007b.p452o.p453a.p455n.p457p.LockAction;
import p007b.p452o.p453a.p472w.RendererCameraPreview;
import p007b.p452o.p453a.p473x.AspectRatio2;

/* JADX INFO: renamed from: b.o.a.v.f, reason: use source file name */
/* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class Snapshot2PictureRecorder extends SnapshotGlPictureRecorder {

    /* JADX INFO: renamed from: t */
    public final Action2 f14185t;

    /* JADX INFO: renamed from: u */
    public final ActionHolder f14186u;

    /* JADX INFO: renamed from: v */
    public final boolean f14187v;

    /* JADX INFO: renamed from: w */
    public Integer f14188w;

    /* JADX INFO: renamed from: x */
    public Integer f14189x;

    /* JADX INFO: renamed from: b.o.a.v.f$a */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class a extends CompletionCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.CompletionCallback
        /* JADX INFO: renamed from: b */
        public void mo7247b(@NonNull Action2 action2) {
            SnapshotPictureRecorder.f14205m.m7159a(1, "Taking picture with super.take().");
            Snapshot2PictureRecorder.m7421d(Snapshot2PictureRecorder.this);
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$b */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class b extends BaseAction {
        public b(Snapshot2PictureRecorder snapshot2PictureRecorder, a aVar) {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction, p007b.p452o.p453a.p455n.p456o.Action2
        /* JADX INFO: renamed from: b */
        public void mo7248b(@NonNull ActionHolder actionHolder, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                SnapshotPictureRecorder.f14205m.m7159a(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                m7341l(Integer.MAX_VALUE);
            } else if (num.intValue() != 3) {
                SnapshotPictureRecorder.f14205m.m7159a(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            } else {
                SnapshotPictureRecorder.f14205m.m7159a(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                m7341l(Integer.MAX_VALUE);
            }
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
        /* JADX INFO: renamed from: j */
        public void mo7249j(@NonNull ActionHolder actionHolder) {
            this.f13939c = actionHolder;
            SnapshotPictureRecorder.f14205m.m7159a(1, "FlashAction:", "Parameters locked, opening torch.");
            ((Camera2Engine) actionHolder).f13807i0.set(CaptureRequest.FLASH_MODE, 2);
            Camera2Engine camera2Engine = (Camera2Engine) actionHolder;
            camera2Engine.f13807i0.set(CaptureRequest.CONTROL_AE_MODE, 1);
            camera2Engine.m7236k1();
        }
    }

    /* JADX INFO: renamed from: b.o.a.v.f$c */
    /* JADX INFO: compiled from: Snapshot2PictureRecorder.java */
    public class c extends BaseAction {
        public c(a aVar) {
        }

        @Override // p007b.p452o.p453a.p455n.p456o.BaseAction
        /* JADX INFO: renamed from: j */
        public void mo7249j(@NonNull ActionHolder actionHolder) {
            this.f13939c = actionHolder;
            try {
                SnapshotPictureRecorder.f14205m.m7159a(1, "ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder builder = ((Camera2Engine) actionHolder).f13807i0;
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                ((Camera2Engine) actionHolder).m7230e1(this, builder);
                builder.set(CaptureRequest.CONTROL_AE_MODE, Snapshot2PictureRecorder.this.f14188w);
                builder.set(CaptureRequest.FLASH_MODE, Snapshot2PictureRecorder.this.f14189x);
                ((Camera2Engine) actionHolder).m7236k1();
            } catch (CameraAccessException unused) {
            }
        }
    }

    public Snapshot2PictureRecorder(@NonNull PictureResult.a aVar, @NonNull Camera2Engine camera2Engine, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio2 aspectRatio2) {
        super(aVar, camera2Engine, rendererCameraPreview, aspectRatio2, camera2Engine.f13894c0);
        this.f14186u = camera2Engine;
        boolean z2 = false;
        SequenceAction sequenceAction = new SequenceAction(Arrays.asList(new TimeoutAction(2500L, new LockAction()), new b(this, null)));
        this.f14185t = sequenceAction;
        sequenceAction.m7337f(new a());
        TotalCaptureResult totalCaptureResult = camera2Engine.f13808j0;
        if (totalCaptureResult == null) {
            SnapshotPictureRecorder.f14205m.m7159a(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (camera2Engine.f13873H && num != null && num.intValue() == 4) {
            z2 = true;
        }
        this.f14187v = z2;
        this.f14188w = (Integer) camera2Engine.f13807i0.get(CaptureRequest.CONTROL_AE_MODE);
        this.f14189x = (Integer) camera2Engine.f13807i0.get(CaptureRequest.FLASH_MODE);
    }

    /* JADX INFO: renamed from: d */
    public static /* synthetic */ void m7421d(Snapshot2PictureRecorder snapshot2PictureRecorder) {
        super.mo7417c();
    }

    @Override // p007b.p452o.p453a.p471v.SnapshotGlPictureRecorder, p007b.p452o.p453a.p471v.PictureRecorder
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        new c(null).mo7333e(this.f14186u);
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.SnapshotGlPictureRecorder, p007b.p452o.p453a.p471v.PictureRecorder
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        if (this.f14187v) {
            SnapshotPictureRecorder.f14205m.m7159a(1, "take:", "Engine needs flash. Starting action");
            this.f14185t.mo7333e(this.f14186u);
        } else {
            SnapshotPictureRecorder.f14205m.m7159a(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.mo7417c();
        }
    }
}
