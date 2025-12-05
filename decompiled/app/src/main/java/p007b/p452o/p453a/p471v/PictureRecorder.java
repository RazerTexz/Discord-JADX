package p007b.p452o.p453a.p471v;

import android.media.MediaActionSound;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.CameraView4;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p455n.CameraBaseEngine;

/* compiled from: PictureRecorder.java */
/* renamed from: b.o.a.v.d, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class PictureRecorder {

    /* renamed from: j */
    @VisibleForTesting(otherwise = 4)
    public PictureResult.a f14172j;

    /* renamed from: k */
    @VisibleForTesting
    public a f14173k;

    /* renamed from: l */
    public Exception f14174l;

    /* compiled from: PictureRecorder.java */
    /* renamed from: b.o.a.v.d$a */
    public interface a {
        /* renamed from: a */
        void mo7227a(@Nullable PictureResult.a aVar, @Nullable Exception exc);
    }

    public PictureRecorder(@NonNull PictureResult.a aVar, @Nullable a aVar2) {
        this.f14172j = aVar;
        this.f14173k = aVar2;
    }

    /* renamed from: a */
    public void m7420a(boolean z2) {
        CameraView cameraView;
        boolean z3;
        a aVar = this.f14173k;
        if (aVar != null) {
            boolean z4 = !z2;
            CameraView.C11195b c11195b = (CameraView.C11195b) ((CameraBaseEngine) aVar).f13921m;
            if (z4 && (z3 = (cameraView = CameraView.this).f22124l) && z3) {
                if (cameraView.f22111B == null) {
                    cameraView.f22111B = new MediaActionSound();
                }
                cameraView.f22111B.play(0);
            }
            CameraView.this.f22133u.post(new CameraView4(c11195b));
        }
    }

    /* renamed from: b */
    public void mo7416b() {
        a aVar = this.f14173k;
        if (aVar != null) {
            aVar.mo7227a(this.f14172j, this.f14174l);
            this.f14173k = null;
            this.f14172j = null;
        }
    }

    /* renamed from: c */
    public abstract void mo7417c();
}
