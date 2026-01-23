package p007b.p225i.p226a.p242c.p260g3.p261z;

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
import com.google.android.exoplayer2.util.GlUtil;
import java.nio.Buffer;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p007b.p225i.p226a.p242c.p259f3.TimedValueQueue;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoFrameMetadataListener;
import p007b.p225i.p226a.p242c.p260g3.p261z.OrientationListener;
import p007b.p225i.p226a.p242c.p260g3.p261z.ProjectionRenderer;
import p007b.p225i.p226a.p242c.p260g3.p261z.TouchTracker;

/* JADX INFO: renamed from: b.i.a.c.g3.z.k, reason: use source file name */
/* JADX INFO: compiled from: SphericalGLSurfaceView.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* JADX INFO: renamed from: j */
    public final CopyOnWriteArrayList<b> f7021j;

    /* JADX INFO: renamed from: k */
    public final SensorManager f7022k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final Sensor f7023l;

    /* JADX INFO: renamed from: m */
    public final OrientationListener f7024m;

    /* JADX INFO: renamed from: n */
    public final Handler f7025n;

    /* JADX INFO: renamed from: o */
    public final TouchTracker f7026o;

    /* JADX INFO: renamed from: p */
    public final SceneRenderer f7027p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public SurfaceTexture f7028q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public Surface f7029r;

    /* JADX INFO: renamed from: s */
    public boolean f7030s;

    /* JADX INFO: renamed from: t */
    public boolean f7031t;

    /* JADX INFO: renamed from: u */
    public boolean f7032u;

    /* JADX INFO: renamed from: b.i.a.c.g3.z.k$a */
    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    @VisibleForTesting
    public final class a implements GLSurfaceView.Renderer, TouchTracker.a, OrientationListener.a {

        /* JADX INFO: renamed from: j */
        public final SceneRenderer f7033j;

        /* JADX INFO: renamed from: m */
        public final float[] f7036m;

        /* JADX INFO: renamed from: n */
        public final float[] f7037n;

        /* JADX INFO: renamed from: o */
        public final float[] f7038o;

        /* JADX INFO: renamed from: p */
        public float f7039p;

        /* JADX INFO: renamed from: q */
        public float f7040q;

        /* JADX INFO: renamed from: k */
        public final float[] f7034k = new float[16];

        /* JADX INFO: renamed from: l */
        public final float[] f7035l = new float[16];

        /* JADX INFO: renamed from: r */
        public final float[] f7041r = new float[16];

        /* JADX INFO: renamed from: s */
        public final float[] f7042s = new float[16];

        public a(SceneRenderer sceneRenderer) {
            float[] fArr = new float[16];
            this.f7036m = fArr;
            float[] fArr2 = new float[16];
            this.f7037n = fArr2;
            float[] fArr3 = new float[16];
            this.f7038o = fArr3;
            this.f7033j = sceneRenderer;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f7040q = 3.1415927f;
        }

        @Override // p007b.p225i.p226a.p242c.p260g3.p261z.OrientationListener.a
        @BinderThread
        /* JADX INFO: renamed from: a */
        public synchronized void mo3199a(float[] fArr, float f) {
            float[] fArr2 = this.f7036m;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f7040q = -f;
            m3203b();
        }

        @AnyThread
        /* JADX INFO: renamed from: b */
        public final void m3203b() {
            Matrix.setRotateM(this.f7037n, 0, -this.f7039p, (float) Math.cos(this.f7040q), (float) Math.sin(this.f7040q), 0.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            Long lM2969d;
            float[] fArr;
            synchronized (this) {
                Matrix.multiplyMM(this.f7042s, 0, this.f7036m, 0, this.f7038o, 0);
                Matrix.multiplyMM(this.f7041r, 0, this.f7037n, 0, this.f7042s, 0);
            }
            Matrix.multiplyMM(this.f7035l, 0, this.f7034k, 0, this.f7041r, 0);
            SceneRenderer sceneRenderer = this.f7033j;
            float[] fArr2 = this.f7035l;
            Objects.requireNonNull(sceneRenderer);
            GLES20.glClear(16384);
            GlUtil.m8945a();
            if (sceneRenderer.f7008j.compareAndSet(true, false)) {
                SurfaceTexture surfaceTexture = sceneRenderer.f7017s;
                Objects.requireNonNull(surfaceTexture);
                surfaceTexture.updateTexImage();
                GlUtil.m8945a();
                if (sceneRenderer.f7009k.compareAndSet(true, false)) {
                    Matrix.setIdentityM(sceneRenderer.f7014p, 0);
                }
                long timestamp = sceneRenderer.f7017s.getTimestamp();
                TimedValueQueue<Long> timedValueQueue = sceneRenderer.f7012n;
                synchronized (timedValueQueue) {
                    lM2969d = timedValueQueue.m2969d(timestamp, false);
                }
                Long l = lM2969d;
                if (l != null) {
                    FrameRotationQueue frameRotationQueue = sceneRenderer.f7011m;
                    float[] fArr3 = sceneRenderer.f7014p;
                    float[] fArrM2970e = frameRotationQueue.f6970c.m2970e(l.longValue());
                    if (fArrM2970e != null) {
                        float[] fArr4 = frameRotationQueue.f6969b;
                        float f = fArrM2970e[0];
                        float f2 = -fArrM2970e[1];
                        float f3 = -fArrM2970e[2];
                        float length = Matrix.length(f, f2, f3);
                        if (length != 0.0f) {
                            fArr = fArr3;
                            Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
                        } else {
                            fArr = fArr3;
                            Matrix.setIdentityM(fArr4, 0);
                        }
                        if (!frameRotationQueue.f6971d) {
                            FrameRotationQueue.m3198a(frameRotationQueue.f6968a, frameRotationQueue.f6969b);
                            frameRotationQueue.f6971d = true;
                        }
                        Matrix.multiplyMM(fArr, 0, frameRotationQueue.f6968a, 0, frameRotationQueue.f6969b, 0);
                    }
                }
                Projection projectionM2970e = sceneRenderer.f7013o.m2970e(timestamp);
                if (projectionM2970e != null) {
                    ProjectionRenderer projectionRenderer = sceneRenderer.f7010l;
                    Objects.requireNonNull(projectionRenderer);
                    if (ProjectionRenderer.m3200a(projectionM2970e)) {
                        projectionRenderer.f6995h = projectionM2970e.f6981c;
                        ProjectionRenderer.a aVar = new ProjectionRenderer.a(projectionM2970e.f6979a.f6983a[0]);
                        projectionRenderer.f6996i = aVar;
                        if (!projectionM2970e.f6982d) {
                            aVar = new ProjectionRenderer.a(projectionM2970e.f6980b.f6983a[0]);
                        }
                        projectionRenderer.f6997j = aVar;
                    }
                }
            }
            Matrix.multiplyMM(sceneRenderer.f7015q, 0, fArr2, 0, sceneRenderer.f7014p, 0);
            ProjectionRenderer projectionRenderer2 = sceneRenderer.f7010l;
            int i = sceneRenderer.f7016r;
            float[] fArr5 = sceneRenderer.f7015q;
            ProjectionRenderer.a aVar2 = projectionRenderer2.f6996i;
            if (aVar2 == null) {
                return;
            }
            GlUtil.C10776a c10776a = projectionRenderer2.f6998k;
            Objects.requireNonNull(c10776a);
            c10776a.m8949c();
            GlUtil.m8945a();
            GLES20.glEnableVertexAttribArray(projectionRenderer2.f7001n);
            GLES20.glEnableVertexAttribArray(projectionRenderer2.f7002o);
            GlUtil.m8945a();
            int i2 = projectionRenderer2.f6995h;
            GLES20.glUniformMatrix3fv(projectionRenderer2.f7000m, 1, false, i2 == 1 ? ProjectionRenderer.f6991d : i2 == 2 ? ProjectionRenderer.f6993f : ProjectionRenderer.f6990c, 0);
            GLES20.glUniformMatrix4fv(projectionRenderer2.f6999l, 1, false, fArr5, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, i);
            GLES20.glUniform1i(projectionRenderer2.f7003p, 0);
            GlUtil.m8945a();
            GLES20.glVertexAttribPointer(projectionRenderer2.f7001n, 3, 5126, false, 12, (Buffer) aVar2.f7005b);
            GlUtil.m8945a();
            GLES20.glVertexAttribPointer(projectionRenderer2.f7002o, 2, 5126, false, 8, (Buffer) aVar2.f7006c);
            GlUtil.m8945a();
            GLES20.glDrawArrays(aVar2.f7007d, 0, aVar2.f7004a);
            GlUtil.m8945a();
            GLES20.glDisableVertexAttribArray(projectionRenderer2.f7001n);
            GLES20.glDisableVertexAttribArray(projectionRenderer2.f7002o);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.f7034k, 0, f > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d) : 90.0f, f, 0.1f, 100.0f);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView sphericalGLSurfaceView = SphericalGLSurfaceView.this;
            sphericalGLSurfaceView.f7025n.post(new RunnableC2790b(sphericalGLSurfaceView, this.f7033j.m3201b()));
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.g3.z.k$b */
    /* JADX INFO: compiled from: SphericalGLSurfaceView.java */
    public interface b {
        /* JADX INFO: renamed from: q */
        void mo3204q(Surface surface);

        /* JADX INFO: renamed from: u */
        void mo3205u(Surface surface);
    }

    public SphericalGLSurfaceView(Context context) {
        super(context, null);
        this.f7021j = new CopyOnWriteArrayList<>();
        this.f7025n = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        Objects.requireNonNull(systemService);
        SensorManager sensorManager = (SensorManager) systemService;
        this.f7022k = sensorManager;
        Sensor defaultSensor = Util2.f6708a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f7023l = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        SceneRenderer sceneRenderer = new SceneRenderer();
        this.f7027p = sceneRenderer;
        a aVar = new a(sceneRenderer);
        TouchTracker touchTracker = new TouchTracker(context, aVar, 25.0f);
        this.f7026o = touchTracker;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Objects.requireNonNull(windowManager);
        this.f7024m = new OrientationListener(windowManager.getDefaultDisplay(), touchTracker, aVar);
        this.f7030s = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(touchTracker);
    }

    /* JADX INFO: renamed from: a */
    public final void m3202a() {
        boolean z2 = this.f7030s && this.f7031t;
        Sensor sensor = this.f7023l;
        if (sensor == null || z2 == this.f7032u) {
            return;
        }
        if (z2) {
            this.f7022k.registerListener(this.f7024m, sensor, 0);
        } else {
            this.f7022k.unregisterListener(this.f7024m);
        }
        this.f7032u = z2;
    }

    public CameraMotionListener getCameraMotionListener() {
        return this.f7027p;
    }

    public VideoFrameMetadataListener getVideoFrameMetadataListener() {
        return this.f7027p;
    }

    @Nullable
    public Surface getVideoSurface() {
        return this.f7029r;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7025n.post(new RunnableC2791c(this));
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.f7031t = false;
        m3202a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.f7031t = true;
        m3202a();
    }

    public void setDefaultStereoMode(int i) {
        this.f7027p.f7018t = i;
    }

    public void setUseSensorRotation(boolean z2) {
        this.f7030s = z2;
        m3202a();
    }
}
