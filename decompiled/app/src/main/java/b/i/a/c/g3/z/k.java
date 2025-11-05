package b.i.a.c.g3.z;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.WindowManager;
import androidx.annotation.AnyThread;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.i.a.c.f3.c0;
import b.i.a.c.f3.e0;
import b.i.a.c.g3.u;
import b.i.a.c.g3.z.g;
import b.i.a.c.g3.z.i;
import b.i.a.c.g3.z.l;
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: SphericalGLSurfaceView.java */
/* loaded from: classes3.dex */
public final class k extends GLSurfaceView {
    public final CopyOnWriteArrayList<b> j;
    public final SensorManager k;

    @Nullable
    public final Sensor l;
    public final g m;
    public final Handler n;
    public final l o;
    public final j p;

    @Nullable
    public SurfaceTexture q;

    @Nullable
    public Surface r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1005s;
    public boolean t;
    public boolean u;

    /* compiled from: SphericalGLSurfaceView.java */
    @VisibleForTesting
    public final class a implements GLSurfaceView.Renderer, l.a, g.a {
        public final j j;
        public final float[] m;
        public final float[] n;
        public final float[] o;
        public float p;
        public float q;
        public final float[] k = new float[16];
        public final float[] l = new float[16];
        public final float[] r = new float[16];

        /* renamed from: s, reason: collision with root package name */
        public final float[] f1006s = new float[16];

        public a(j jVar) {
            float[] fArr = new float[16];
            this.m = fArr;
            float[] fArr2 = new float[16];
            this.n = fArr2;
            float[] fArr3 = new float[16];
            this.o = fArr3;
            this.j = jVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.q = 3.1415927f;
        }

        @Override // b.i.a.c.g3.z.g.a
        @BinderThread
        public synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.m;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.q = -f;
            b();
        }

        @AnyThread
        public final void b() {
            Matrix.setRotateM(this.n, 0, -this.p, (float) Math.cos(this.q), (float) Math.sin(this.q), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Long lD;
            float[] fArr;
            synchronized (this) {
                Matrix.multiplyMM(this.f1006s, 0, this.m, 0, this.o, 0);
                Matrix.multiplyMM(this.r, 0, this.n, 0, this.f1006s, 0);
            }
            Matrix.multiplyMM(this.l, 0, this.k, 0, this.r, 0);
            j jVar = this.j;
            float[] fArr2 = this.l;
            Objects.requireNonNull(jVar);
            GLES20.glClear(16384);
            GlUtil.a();
            if (jVar.j.compareAndSet(true, false)) {
                SurfaceTexture surfaceTexture = jVar.f1004s;
                Objects.requireNonNull(surfaceTexture);
                surfaceTexture.updateTexImage();
                GlUtil.a();
                if (jVar.k.compareAndSet(true, false)) {
                    Matrix.setIdentityM(jVar.p, 0);
                }
                long timestamp = jVar.f1004s.getTimestamp();
                c0<Long> c0Var = jVar.n;
                synchronized (c0Var) {
                    lD = c0Var.d(timestamp, false);
                }
                Long l = lD;
                if (l != null) {
                    f fVar = jVar.m;
                    float[] fArr3 = jVar.p;
                    float[] fArrE = fVar.c.e(l.longValue());
                    if (fArrE != null) {
                        float[] fArr4 = fVar.f998b;
                        float f = fArrE[0];
                        float f2 = -fArrE[1];
                        float f3 = -fArrE[2];
                        float length = Matrix.length(f, f2, f3);
                        if (length != 0.0f) {
                            fArr = fArr3;
                            Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                        } else {
                            fArr = fArr3;
                            Matrix.setIdentityM(fArr4, 0);
                        }
                        if (!fVar.d) {
                            f.a(fVar.a, fVar.f998b);
                            fVar.d = true;
                        }
                        Matrix.multiplyMM(fArr, 0, fVar.a, 0, fVar.f998b, 0);
                    }
                }
                h hVarE = jVar.o.e(timestamp);
                if (hVarE != null) {
                    i iVar = jVar.l;
                    Objects.requireNonNull(iVar);
                    if (i.a(hVarE)) {
                        iVar.h = hVarE.c;
                        i.a aVar = new i.a(hVarE.a.a[0]);
                        iVar.i = aVar;
                        if (!hVarE.d) {
                            aVar = new i.a(hVarE.f1000b.a[0]);
                        }
                        iVar.j = aVar;
                    }
                }
            }
            Matrix.multiplyMM(jVar.q, 0, fArr2, 0, jVar.p, 0);
            i iVar2 = jVar.l;
            int i = jVar.r;
            float[] fArr5 = jVar.q;
            i.a aVar2 = iVar2.i;
            if (aVar2 == null) {
                return;
            }
            GlUtil.a aVar3 = iVar2.k;
            Objects.requireNonNull(aVar3);
            aVar3.c();
            GlUtil.a();
            GLES20.glEnableVertexAttribArray(iVar2.n);
            GLES20.glEnableVertexAttribArray(iVar2.o);
            GlUtil.a();
            int i2 = iVar2.h;
            GLES20.glUniformMatrix3fv(iVar2.m, 1, false, i2 == 1 ? i.d : i2 == 2 ? i.f : i.c, 0);
            GLES20.glUniformMatrix4fv(iVar2.l, 1, false, fArr5, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(iVar2.p, 0);
            GlUtil.a();
            GLES20.glVertexAttribPointer(iVar2.n, 3, 5126, false, 12, (Buffer) aVar2.f1003b);
            GlUtil.a();
            GLES20.glVertexAttribPointer(iVar2.o, 2, 5126, false, 8, (Buffer) aVar2.c);
            GlUtil.a();
            GLES20.glDrawArrays(aVar2.d, 0, aVar2.a);
            GlUtil.a();
            GLES20.glDisableVertexAttribArray(iVar2.n);
            GLES20.glDisableVertexAttribArray(iVar2.o);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.k, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f)) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            k kVar = k.this;
            kVar.n.post(new b.i.a.c.g3.z.b(kVar, this.j.b()));
        }
    }

    /* compiled from: SphericalGLSurfaceView.java */
    public interface b {
        void q(Surface surface);

        void u(Surface surface);
    }

    public k(Context context) {
        super(context, null);
        this.j = new CopyOnWriteArrayList<>();
        this.n = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        this.k = sensorManager;
        Sensor defaultSensor = e0.a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.l = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        j jVar = new j();
        this.p = jVar;
        a aVar = new a(jVar);
        l lVar = new l(context, aVar, 25.0f);
        this.o = lVar;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Objects.requireNonNull(windowManager);
        this.m = new g(windowManager.getDefaultDisplay(), lVar, aVar);
        this.f1005s = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(lVar);
    }

    public final void a() {
        boolean z2 = this.f1005s && this.t;
        Sensor sensor = this.l;
        if (sensor == null || z2 == this.u) {
            return;
        }
        if (z2) {
            this.k.registerListener(this.m, sensor, 0);
        } else {
            this.k.unregisterListener(this.m);
        }
        this.u = z2;
    }

    public d getCameraMotionListener() {
        return this.p;
    }

    public u getVideoFrameMetadataListener() {
        return this.p;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.r;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.post(new c(this));
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.t = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.t = true;
        a();
    }

    public void setDefaultStereoMode(int i) {
        this.p.t = i;
    }

    public void setUseSensorRotation(boolean z2) {
        this.f1005s = z2;
        a();
    }
}
