package b.o.a.w;

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
import b.o.a.w.a;
import com.otaliastudios.cameraview.R;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: GlCameraPreview.java */
/* loaded from: classes3.dex */
public class d extends b.o.a.w.a<GLSurfaceView, SurfaceTexture> implements b.o.a.w.b, e {
    public boolean j;
    public SurfaceTexture k;
    public b.o.a.r.c l;
    public final Set<f> m;

    @VisibleForTesting
    public float n;

    @VisibleForTesting
    public float o;
    public View p;
    public b.o.a.o.b q;

    /* compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public final /* synthetic */ f j;

        public a(f fVar) {
            this.j = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m.add(this.j);
            b.o.a.r.c cVar = d.this.l;
            if (cVar != null) {
                this.j.b(cVar.a.g);
            }
            this.j.c(d.this.q);
        }
    }

    /* compiled from: GlCameraPreview.java */
    public class b implements Runnable {
        public final /* synthetic */ b.o.a.o.b j;

        public b(b.o.a.o.b bVar) {
            this.j = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            b.o.a.r.c cVar = dVar.l;
            if (cVar != null) {
                cVar.d = this.j;
            }
            Iterator<f> it = dVar.m.iterator();
            while (it.hasNext()) {
                it.next().c(this.j);
            }
        }
    }

    /* compiled from: GlCameraPreview.java */
    public class c implements GLSurfaceView.Renderer {

        /* compiled from: GlCameraPreview.java */
        public class a implements Runnable {
            public final /* synthetic */ int j;

            public a(int i) {
                this.j = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<f> it = d.this.m.iterator();
                while (it.hasNext()) {
                    it.next().b(this.j);
                }
            }
        }

        /* compiled from: GlCameraPreview.java */
        public class b implements SurfaceTexture.OnFrameAvailableListener {
            public b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                ((GLSurfaceView) d.this.c).requestRender();
            }
        }

        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            d dVar = d.this;
            SurfaceTexture surfaceTexture = dVar.k;
            if (surfaceTexture != null && dVar.g > 0 && dVar.h > 0) {
                float[] fArr = dVar.l.f1950b;
                surfaceTexture.updateTexImage();
                d.this.k.getTransformMatrix(fArr);
                if (d.this.i != 0) {
                    Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(fArr, 0, d.this.i, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
                }
                d dVar2 = d.this;
                if (dVar2.d) {
                    Matrix.translateM(fArr, 0, (1.0f - dVar2.n) / 2.0f, (1.0f - dVar2.o) / 2.0f, 0.0f);
                    d dVar3 = d.this;
                    Matrix.scaleM(fArr, 0, dVar3.n, dVar3.o, 1.0f);
                }
                d dVar4 = d.this;
                dVar4.l.a(dVar4.k.getTimestamp() / 1000);
                for (f fVar : d.this.m) {
                    d dVar5 = d.this;
                    fVar.a(dVar5.k, dVar5.i, dVar5.n, dVar5.o);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            d.this.q.k(i, i2);
            d dVar = d.this;
            if (!dVar.j) {
                dVar.f(i, i2);
                d.this.j = true;
            } else {
                if (i == dVar.e && i2 == dVar.f) {
                    return;
                }
                dVar.h(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            d dVar = d.this;
            if (dVar.q == null) {
                dVar.q = new b.o.a.o.c();
            }
            d.this.l = new b.o.a.r.c(new b.o.b.f.b(33984, 36197, null, 4));
            d dVar2 = d.this;
            b.o.a.r.c cVar = dVar2.l;
            cVar.d = dVar2.q;
            int i = cVar.a.g;
            dVar2.k = new SurfaceTexture(i);
            ((GLSurfaceView) d.this.c).queueEvent(new a(i));
            d.this.k.setOnFrameAvailableListener(new b());
        }
    }

    public d(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
        this.m = new CopyOnWriteArraySet();
        this.n = 1.0f;
        this.o = 1.0f;
    }

    @Override // b.o.a.w.b
    public void a(@NonNull b.o.a.o.b bVar) {
        this.q = bVar;
        if (m()) {
            bVar.k(this.e, this.f);
        }
        ((GLSurfaceView) this.c).queueEvent(new b(bVar));
    }

    @Override // b.o.a.w.e
    public void b(@NonNull f fVar) {
        ((GLSurfaceView) this.c).queueEvent(new a(fVar));
    }

    @Override // b.o.a.w.b
    @NonNull
    public b.o.a.o.b c() {
        return this.q;
    }

    @Override // b.o.a.w.e
    public void d(@NonNull f fVar) {
        this.m.remove(fVar);
    }

    @Override // b.o.a.w.a
    public void e(@Nullable a.b bVar) {
        int i;
        int i2;
        float fI;
        float fI2;
        if (this.g <= 0 || this.h <= 0 || (i = this.e) <= 0 || (i2 = this.f) <= 0) {
            return;
        }
        b.o.a.x.a aVarF = b.o.a.x.a.f(i, i2);
        b.o.a.x.a aVarF2 = b.o.a.x.a.f(this.g, this.h);
        if (aVarF.i() >= aVarF2.i()) {
            fI2 = aVarF.i() / aVarF2.i();
            fI = 1.0f;
        } else {
            fI = aVarF2.i() / aVarF.i();
            fI2 = 1.0f;
        }
        this.d = fI > 1.02f || fI2 > 1.02f;
        this.n = 1.0f / fI;
        this.o = 1.0f / fI2;
        ((GLSurfaceView) this.c).requestRender();
    }

    @Override // b.o.a.w.a
    @NonNull
    public SurfaceTexture i() {
        return this.k;
    }

    @Override // b.o.a.w.a
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View k() {
        return this.p;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.b.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R.a.gl_surface_view);
        c cVar = new c();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(cVar);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new b.o.a.w.c(this, gLSurfaceView, cVar));
        viewGroup.addView(viewGroup2, 0);
        this.p = viewGroup2;
        return gLSurfaceView;
    }

    @Override // b.o.a.w.a
    public void o() {
        super.o();
        this.m.clear();
    }

    @Override // b.o.a.w.a
    public void p() {
        ((GLSurfaceView) this.c).onPause();
    }

    @Override // b.o.a.w.a
    public void q() {
        ((GLSurfaceView) this.c).onResume();
    }
}
