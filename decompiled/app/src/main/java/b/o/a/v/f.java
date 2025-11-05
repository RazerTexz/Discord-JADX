package b.o.a.v;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import b.o.a.l;
import java.util.Arrays;

/* compiled from: Snapshot2PictureRecorder.java */
@RequiresApi(21)
/* loaded from: classes3.dex */
public class f extends g {
    public final b.o.a.n.o.a t;
    public final b.o.a.n.o.c u;
    public final boolean v;
    public Integer w;

    /* renamed from: x, reason: collision with root package name */
    public Integer f1955x;

    /* compiled from: Snapshot2PictureRecorder.java */
    public class a extends b.o.a.n.o.f {
        public a() {
        }

        @Override // b.o.a.n.o.f
        public void b(@NonNull b.o.a.n.o.a aVar) {
            i.m.a(1, "Taking picture with super.take().");
            f.d(f.this);
        }
    }

    /* compiled from: Snapshot2PictureRecorder.java */
    public class b extends b.o.a.n.o.e {
        public b(f fVar, a aVar) {
        }

        @Override // b.o.a.n.o.e, b.o.a.n.o.a
        public void b(@NonNull b.o.a.n.o.c cVar, @NonNull CaptureRequest captureRequest, @NonNull TotalCaptureResult totalCaptureResult) {
            Integer num = (Integer) totalCaptureResult.get(CaptureResult.FLASH_STATE);
            if (num == null) {
                i.m.a(2, "FlashAction:", "Waiting flash, but flashState is null!", "Taking snapshot.");
                l(Integer.MAX_VALUE);
            } else if (num.intValue() != 3) {
                i.m.a(1, "FlashAction:", "Waiting flash but flashState is", num, ". Waiting...");
            } else {
                i.m.a(1, "FlashAction:", "Waiting flash and we have FIRED state!", "Taking snapshot.");
                l(Integer.MAX_VALUE);
            }
        }

        @Override // b.o.a.n.o.e
        public void j(@NonNull b.o.a.n.o.c cVar) {
            this.c = cVar;
            i.m.a(1, "FlashAction:", "Parameters locked, opening torch.");
            ((b.o.a.n.d) cVar).f1921i0.set(CaptureRequest.FLASH_MODE, 2);
            b.o.a.n.d dVar = (b.o.a.n.d) cVar;
            dVar.f1921i0.set(CaptureRequest.CONTROL_AE_MODE, 1);
            dVar.k1();
        }
    }

    /* compiled from: Snapshot2PictureRecorder.java */
    public class c extends b.o.a.n.o.e {
        public c(a aVar) {
        }

        @Override // b.o.a.n.o.e
        public void j(@NonNull b.o.a.n.o.c cVar) {
            this.c = cVar;
            try {
                i.m.a(1, "ResetFlashAction:", "Reverting the flash changes.");
                CaptureRequest.Builder builder = ((b.o.a.n.d) cVar).f1921i0;
                builder.set(CaptureRequest.CONTROL_AE_MODE, 1);
                builder.set(CaptureRequest.FLASH_MODE, 0);
                ((b.o.a.n.d) cVar).e1(this, builder);
                builder.set(CaptureRequest.CONTROL_AE_MODE, f.this.w);
                builder.set(CaptureRequest.FLASH_MODE, f.this.f1955x);
                ((b.o.a.n.d) cVar).k1();
            } catch (CameraAccessException unused) {
            }
        }
    }

    public f(@NonNull l.a aVar, @NonNull b.o.a.n.d dVar, @NonNull b.o.a.w.e eVar, @NonNull b.o.a.x.a aVar2) {
        super(aVar, dVar, eVar, aVar2, dVar.f1930c0);
        this.u = dVar;
        boolean z2 = false;
        b.o.a.n.o.h hVar = new b.o.a.n.o.h(Arrays.asList(new b.o.a.n.o.i(2500L, new b.o.a.n.p.d()), new b(this, null)));
        this.t = hVar;
        hVar.f(new a());
        TotalCaptureResult totalCaptureResult = dVar.f1922j0;
        if (totalCaptureResult == null) {
            i.m.a(2, "Picture snapshot requested very early, before the first preview frame.", "Metering might not work as intended.");
        }
        Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
        if (dVar.H && num != null && num.intValue() == 4) {
            z2 = true;
        }
        this.v = z2;
        this.w = (Integer) dVar.f1921i0.get(CaptureRequest.CONTROL_AE_MODE);
        this.f1955x = (Integer) dVar.f1921i0.get(CaptureRequest.FLASH_MODE);
    }

    public static /* synthetic */ void d(f fVar) {
        super.c();
    }

    @Override // b.o.a.v.g, b.o.a.v.d
    public void b() {
        new c(null).e(this.u);
        super.b();
    }

    @Override // b.o.a.v.g, b.o.a.v.d
    public void c() {
        if (this.v) {
            i.m.a(1, "take:", "Engine needs flash. Starting action");
            this.t.e(this.u);
        } else {
            i.m.a(1, "take:", "Engine does no metering or needs no flash.", "Taking fast snapshot.");
            super.c();
        }
    }
}
