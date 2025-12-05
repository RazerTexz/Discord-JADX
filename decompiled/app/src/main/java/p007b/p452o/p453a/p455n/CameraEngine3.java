package p007b.p452o.p453a.p455n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.otaliastudios.cameraview.CameraView;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.CameraView2;

/* compiled from: CameraEngine.java */
/* renamed from: b.o.a.n.k, reason: use source file name */
/* loaded from: classes3.dex */
public class CameraEngine3 implements InterfaceC4362f<CameraOptions, Void> {

    /* renamed from: a */
    public final /* synthetic */ CameraEngine f13932a;

    public CameraEngine3(CameraEngine cameraEngine) {
        this.f13932a = cameraEngine;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* renamed from: a */
    public Task<Void> mo4013a(@Nullable CameraOptions cameraOptions) throws Exception {
        CameraOptions cameraOptions2 = cameraOptions;
        if (cameraOptions2 == null) {
            throw new RuntimeException("Null options!");
        }
        CameraView.C11195b c11195b = (CameraView.C11195b) this.f13932a.f13921m;
        c11195b.f22141b.m7159a(1, "dispatchOnCameraOpened", cameraOptions2);
        CameraView.this.f22133u.post(new CameraView2(c11195b, cameraOptions2));
        return C3404f.m4264Z(null);
    }
}
