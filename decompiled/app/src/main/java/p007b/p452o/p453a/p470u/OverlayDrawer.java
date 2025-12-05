package p007b.p452o.p453a.p470u;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p467r.GlTextureDrawer;
import p007b.p452o.p453a.p467r.Issue514Workaround;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p475b.p481f.GlTexture2;

/* compiled from: OverlayDrawer.java */
/* renamed from: b.o.a.u.b, reason: use source file name */
/* loaded from: classes3.dex */
public class OverlayDrawer {

    /* renamed from: a */
    public static final CameraLogger f14147a = new CameraLogger(OverlayDrawer.class.getSimpleName());

    /* renamed from: b */
    public Overlay f14148b;

    /* renamed from: c */
    public SurfaceTexture f14149c;

    /* renamed from: d */
    public Surface f14150d;

    /* renamed from: f */
    public Issue514Workaround f14152f;

    /* renamed from: g */
    public final Object f14153g = new Object();

    /* renamed from: e */
    @VisibleForTesting
    public GlTextureDrawer f14151e = new GlTextureDrawer(new GlTexture2(33984, 36197, null, 4));

    public OverlayDrawer(@NonNull Overlay overlay, @NonNull Size3 size3) {
        this.f14148b = overlay;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f14151e.f14105a.f14337g);
        this.f14149c = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(size3.f14251j, size3.f14252k);
        this.f14150d = new Surface(this.f14149c);
        this.f14152f = new Issue514Workaround(this.f14151e.f14105a.f14337g);
    }
}
