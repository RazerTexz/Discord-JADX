package p007b.p452o.p453a.p471v;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p464o.Filter2;
import p007b.p452o.p453a.p467r.GlTextureDrawer;
import p007b.p452o.p453a.p467r.WorkerHandler;
import p007b.p452o.p453a.p470u.Overlay;
import p007b.p452o.p453a.p470u.OverlayDrawer;
import p007b.p452o.p453a.p470u.OverlayLayout;
import p007b.p452o.p453a.p471v.PictureRecorder;
import p007b.p452o.p453a.p472w.RendererCameraPreview;
import p007b.p452o.p453a.p472w.RendererFrameCallback;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p475b.p481f.GlTexture2;

/* JADX INFO: renamed from: b.o.a.v.g, reason: use source file name */
/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class SnapshotGlPictureRecorder extends SnapshotPictureRecorder {

    /* JADX INFO: renamed from: n */
    public RendererCameraPreview f14192n;

    /* JADX INFO: renamed from: o */
    public AspectRatio2 f14193o;

    /* JADX INFO: renamed from: p */
    public Overlay f14194p;

    /* JADX INFO: renamed from: q */
    public boolean f14195q;

    /* JADX INFO: renamed from: r */
    public OverlayDrawer f14196r;

    /* JADX INFO: renamed from: s */
    public GlTextureDrawer f14197s;

    /* JADX INFO: renamed from: b.o.a.v.g$a */
    /* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
    public class a implements RendererFrameCallback {
        public a() {
        }

        @Override // p007b.p452o.p453a.p472w.RendererFrameCallback
        /* JADX INFO: renamed from: a */
        public void mo7422a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
            SnapshotGlPictureRecorder.this.f14192n.mo7446d(this);
            SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
            Objects.requireNonNull(snapshotGlPictureRecorder);
            WorkerHandler.m7402a(new SnapshotGlPictureRecorder2(snapshotGlPictureRecorder, surfaceTexture, i, f, f2, EGL14.eglGetCurrentContext()));
        }

        @Override // p007b.p452o.p453a.p472w.RendererFrameCallback
        /* JADX INFO: renamed from: b */
        public void mo7423b(int i) {
            SnapshotGlPictureRecorder snapshotGlPictureRecorder = SnapshotGlPictureRecorder.this;
            Objects.requireNonNull(snapshotGlPictureRecorder);
            snapshotGlPictureRecorder.f14197s = new GlTextureDrawer(new GlTexture2(33984, 36197, Integer.valueOf(i)));
            Rect rectM4222L = C3404f.m4222L(snapshotGlPictureRecorder.f14172j.f13718d, snapshotGlPictureRecorder.f14193o);
            snapshotGlPictureRecorder.f14172j.f13718d = new Size3(rectM4222L.width(), rectM4222L.height());
            if (snapshotGlPictureRecorder.f14195q) {
                snapshotGlPictureRecorder.f14196r = new OverlayDrawer(snapshotGlPictureRecorder.f14194p, snapshotGlPictureRecorder.f14172j.f13718d);
            }
        }

        @Override // p007b.p452o.p453a.p472w.RendererFrameCallback
        /* JADX INFO: renamed from: c */
        public void mo7424c(@NonNull Filter2 filter2) {
            SnapshotGlPictureRecorder.this.f14197s.f14108d = filter2.mo7369a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotGlPictureRecorder(@NonNull PictureResult.a aVar, @Nullable PictureRecorder.a aVar2, @NonNull RendererCameraPreview rendererCameraPreview, @NonNull AspectRatio2 aspectRatio2, @Nullable Overlay overlay) {
        boolean z2;
        super(aVar, aVar2);
        this.f14192n = rendererCameraPreview;
        this.f14193o = aspectRatio2;
        this.f14194p = overlay;
        if (overlay != null) {
            z2 = ((OverlayLayout) overlay).m7413b(Overlay.a.PICTURE_SNAPSHOT);
        }
        this.f14195q = z2;
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    /* JADX INFO: renamed from: b */
    public void mo7416b() {
        this.f14193o = null;
        super.mo7416b();
    }

    @Override // p007b.p452o.p453a.p471v.PictureRecorder
    @TargetApi(19)
    /* JADX INFO: renamed from: c */
    public void mo7417c() {
        this.f14192n.mo7445b(new a());
    }
}
