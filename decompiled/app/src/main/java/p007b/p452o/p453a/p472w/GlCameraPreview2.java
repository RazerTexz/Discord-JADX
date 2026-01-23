package p007b.p452o.p453a.p472w;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.C11196R;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p007b.p452o.p453a.p464o.Filter2;
import p007b.p452o.p453a.p464o.NoFilter;
import p007b.p452o.p453a.p467r.GlTextureDrawer;
import p007b.p452o.p453a.p472w.CameraPreview;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p475b.p481f.GlTexture2;

/* JADX INFO: renamed from: b.o.a.w.d, reason: use source file name */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlCameraPreview2 extends CameraPreview<GLSurfaceView, SurfaceTexture> implements FilterCameraPreview, RendererCameraPreview {

    /* JADX INFO: renamed from: j */
    public boolean f14221j;

    /* JADX INFO: renamed from: k */
    public SurfaceTexture f14222k;

    /* JADX INFO: renamed from: l */
    public GlTextureDrawer f14223l;

    /* JADX INFO: renamed from: m */
    public final Set<RendererFrameCallback> f14224m;

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public float f14225n;

    /* JADX INFO: renamed from: o */
    @VisibleForTesting
    public float f14226o;

    /* JADX INFO: renamed from: p */
    public View f14227p;

    /* JADX INFO: renamed from: q */
    public Filter2 f14228q;

    /* JADX INFO: renamed from: b.o.a.w.d$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ RendererFrameCallback f14229j;

        public a(RendererFrameCallback rendererFrameCallback) {
            this.f14229j = rendererFrameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2.this.f14224m.add(this.f14229j);
            GlTextureDrawer glTextureDrawer = GlCameraPreview2.this.f14223l;
            if (glTextureDrawer != null) {
                this.f14229j.mo7423b(glTextureDrawer.f14105a.f14337g);
            }
            this.f14229j.mo7424c(GlCameraPreview2.this.f14228q);
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$b */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Filter2 f14231j;

        public b(Filter2 filter2) {
            this.f14231j = filter2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            GlTextureDrawer glTextureDrawer = glCameraPreview2.f14223l;
            if (glTextureDrawer != null) {
                glTextureDrawer.f14108d = this.f14231j;
            }
            Iterator<RendererFrameCallback> it = glCameraPreview2.f14224m.iterator();
            while (it.hasNext()) {
                it.next().mo7424c(this.f14231j);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$c */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class c implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: b.o.a.w.d$c$a */
        /* JADX INFO: compiled from: GlCameraPreview.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ int f14234j;

            public a(int i) {
                this.f14234j = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<RendererFrameCallback> it = GlCameraPreview2.this.f14224m.iterator();
                while (it.hasNext()) {
                    it.next().mo7423b(this.f14234j);
                }
            }
        }

        /* JADX INFO: renamed from: b.o.a.w.d$c$b */
        /* JADX INFO: compiled from: GlCameraPreview.java */
        public class b implements SurfaceTexture.OnFrameAvailableListener {
            public b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                ((GLSurfaceView) GlCameraPreview2.this.f14208c).requestRender();
            }
        }

        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            SurfaceTexture surfaceTexture = glCameraPreview2.f14222k;
            if (surfaceTexture != null && glCameraPreview2.f14212g > 0 && glCameraPreview2.f14213h > 0) {
                float[] fArr = glCameraPreview2.f14223l.f14106b;
                surfaceTexture.updateTexImage();
                GlCameraPreview2.this.f14222k.getTransformMatrix(fArr);
                if (GlCameraPreview2.this.f14214i != 0) {
                    Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(fArr, 0, GlCameraPreview2.this.f14214i, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
                }
                GlCameraPreview2 glCameraPreview22 = GlCameraPreview2.this;
                if (glCameraPreview22.f14209d) {
                    Matrix.translateM(fArr, 0, (1.0f - glCameraPreview22.f14225n) / 2.0f, (1.0f - glCameraPreview22.f14226o) / 2.0f, 0.0f);
                    GlCameraPreview2 glCameraPreview23 = GlCameraPreview2.this;
                    Matrix.scaleM(fArr, 0, glCameraPreview23.f14225n, glCameraPreview23.f14226o, 1.0f);
                }
                GlCameraPreview2 glCameraPreview24 = GlCameraPreview2.this;
                glCameraPreview24.f14223l.m7399a(glCameraPreview24.f14222k.getTimestamp() / 1000);
                for (RendererFrameCallback rendererFrameCallback : GlCameraPreview2.this.f14224m) {
                    GlCameraPreview2 glCameraPreview25 = GlCameraPreview2.this;
                    rendererFrameCallback.mo7422a(glCameraPreview25.f14222k, glCameraPreview25.f14214i, glCameraPreview25.f14225n, glCameraPreview25.f14226o);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            GlCameraPreview2.this.f14228q.mo7374k(i, i2);
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            if (!glCameraPreview2.f14221j) {
                glCameraPreview2.m7426f(i, i2);
                GlCameraPreview2.this.f14221j = true;
            } else {
                if (i == glCameraPreview2.f14210e && i2 == glCameraPreview2.f14211f) {
                    return;
                }
                glCameraPreview2.m7428h(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            if (glCameraPreview2.f14228q == null) {
                glCameraPreview2.f14228q = new NoFilter();
            }
            GlCameraPreview2.this.f14223l = new GlTextureDrawer(new GlTexture2(33984, 36197, null, 4));
            GlCameraPreview2 glCameraPreview22 = GlCameraPreview2.this;
            GlTextureDrawer glTextureDrawer = glCameraPreview22.f14223l;
            glTextureDrawer.f14108d = glCameraPreview22.f14228q;
            int i = glTextureDrawer.f14105a.f14337g;
            glCameraPreview22.f14222k = new SurfaceTexture(i);
            ((GLSurfaceView) GlCameraPreview2.this.f14208c).queueEvent(new a(i));
            GlCameraPreview2.this.f14222k.setOnFrameAvailableListener(new b());
        }
    }

    public GlCameraPreview2(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
        this.f14224m = new CopyOnWriteArraySet();
        this.f14225n = 1.0f;
        this.f14226o = 1.0f;
    }

    @Override // p007b.p452o.p453a.p472w.FilterCameraPreview
    /* JADX INFO: renamed from: a */
    public void mo7443a(@NonNull Filter2 filter2) {
        this.f14228q = filter2;
        if (m7433m()) {
            filter2.mo7374k(this.f14210e, this.f14211f);
        }
        ((GLSurfaceView) this.f14208c).queueEvent(new b(filter2));
    }

    @Override // p007b.p452o.p453a.p472w.RendererCameraPreview
    /* JADX INFO: renamed from: b */
    public void mo7445b(@NonNull RendererFrameCallback rendererFrameCallback) {
        ((GLSurfaceView) this.f14208c).queueEvent(new a(rendererFrameCallback));
    }

    @Override // p007b.p452o.p453a.p472w.FilterCameraPreview
    @NonNull
    /* JADX INFO: renamed from: c */
    public Filter2 mo7444c() {
        return this.f14228q;
    }

    @Override // p007b.p452o.p453a.p472w.RendererCameraPreview
    /* JADX INFO: renamed from: d */
    public void mo7446d(@NonNull RendererFrameCallback rendererFrameCallback) {
        this.f14224m.remove(rendererFrameCallback);
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    /* JADX INFO: renamed from: e */
    public void mo7425e(@Nullable CameraPreview.b bVar) {
        int i;
        int i2;
        float fM7450i;
        float fM7450i2;
        if (this.f14212g <= 0 || this.f14213h <= 0 || (i = this.f14210e) <= 0 || (i2 = this.f14211f) <= 0) {
            return;
        }
        AspectRatio2 aspectRatio2M7447f = AspectRatio2.m7447f(i, i2);
        AspectRatio2 aspectRatio2M7447f2 = AspectRatio2.m7447f(this.f14212g, this.f14213h);
        if (aspectRatio2M7447f.m7450i() >= aspectRatio2M7447f2.m7450i()) {
            fM7450i2 = aspectRatio2M7447f.m7450i() / aspectRatio2M7447f2.m7450i();
            fM7450i = 1.0f;
        } else {
            fM7450i = aspectRatio2M7447f2.m7450i() / aspectRatio2M7447f.m7450i();
            fM7450i2 = 1.0f;
        }
        this.f14209d = fM7450i > 1.02f || fM7450i2 > 1.02f;
        this.f14225n = 1.0f / fM7450i;
        this.f14226o = 1.0f / fM7450i2;
        ((GLSurfaceView) this.f14208c).requestRender();
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* JADX INFO: renamed from: i */
    public SurfaceTexture mo7429i() {
        return this.f14222k;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* JADX INFO: renamed from: j */
    public Class<SurfaceTexture> mo7430j() {
        return SurfaceTexture.class;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* JADX INFO: renamed from: k */
    public View mo7431k() {
        return this.f14227p;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    @NonNull
    /* JADX INFO: renamed from: n */
    public View mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(C11196R.b.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(C11196R.a.gl_surface_view);
        c cVar = new c();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(cVar);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new GlCameraPreview(this, gLSurfaceView, cVar));
        viewGroup.addView(viewGroup2, 0);
        this.f14227p = viewGroup2;
        return gLSurfaceView;
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    /* JADX INFO: renamed from: o */
    public void mo7435o() {
        super.mo7435o();
        this.f14224m.clear();
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    /* JADX INFO: renamed from: p */
    public void mo7436p() {
        ((GLSurfaceView) this.f14208c).onPause();
    }

    @Override // p007b.p452o.p453a.p472w.CameraPreview
    /* JADX INFO: renamed from: q */
    public void mo7437q() {
        ((GLSurfaceView) this.f14208c).onResume();
    }
}
