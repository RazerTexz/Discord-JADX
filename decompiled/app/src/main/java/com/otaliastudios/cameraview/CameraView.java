package com.otaliastudios.cameraview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import androidx.view.Lifecycle;
import androidx.view.LifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.OnLifecycleEvent;
import b.o.a.l;
import b.o.a.m.h;
import b.o.a.m.j;
import b.o.a.m.k;
import b.o.a.m.l;
import b.o.a.m.m;
import b.o.a.n.i;
import b.o.a.p.d;
import b.o.a.q.c;
import b.o.a.q.e;
import b.o.a.q.f;
import b.o.a.q.g;
import b.o.a.r.f;
import b.o.a.s.c;
import b.o.a.u.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class CameraView extends FrameLayout implements LifecycleObserver {
    public static final String j;
    public static final b.o.a.b k;
    public b.o.a.x.b A;
    public MediaActionSound B;
    public b.o.a.s.a C;

    @VisibleForTesting
    public List<b.o.a.a> D;

    @VisibleForTesting
    public List<d> E;
    public Lifecycle F;

    @VisibleForTesting
    public e G;

    @VisibleForTesting
    public g H;

    @VisibleForTesting
    public f I;

    @VisibleForTesting
    public b.o.a.r.d J;

    @VisibleForTesting
    public c K;
    public boolean L;
    public boolean M;

    @VisibleForTesting
    public b.o.a.u.c N;
    public boolean l;
    public boolean m;
    public boolean n;
    public HashMap<b.o.a.q.a, b.o.a.q.b> o;
    public k p;
    public b.o.a.m.d q;
    public b.o.a.o.b r;

    /* renamed from: s, reason: collision with root package name */
    public int f3173s;
    public int t;
    public Handler u;
    public Executor v;

    @VisibleForTesting
    public b w;

    /* renamed from: x, reason: collision with root package name */
    public b.o.a.w.a f3174x;

    /* renamed from: y, reason: collision with root package name */
    public b.o.a.r.f f3175y;

    /* renamed from: z, reason: collision with root package name */
    public i f3176z;

    public class a implements ThreadFactory {
        public final AtomicInteger j = new AtomicInteger(1);

        public a(CameraView cameraView) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder sbU = b.d.b.a.a.U("FrameExecutor #");
            sbU.append(this.j.getAndIncrement());
            return new Thread(runnable, sbU.toString());
        }
    }

    @VisibleForTesting
    public class b implements i.g, f.c, c.a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final b.o.a.b f3177b;

        public class a implements Runnable {
            public final /* synthetic */ float j;
            public final /* synthetic */ PointF[] k;

            public a(float f, PointF[] pointFArr) {
                this.j = f;
                this.k = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<b.o.a.a> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$b, reason: collision with other inner class name */
        public class RunnableC0491b implements Runnable {
            public final /* synthetic */ float j;
            public final /* synthetic */ float[] k;
            public final /* synthetic */ PointF[] l;

            public RunnableC0491b(float f, float[] fArr, PointF[] pointFArr) {
                this.j = f;
                this.k = fArr;
                this.l = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<b.o.a.a> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public class c implements Runnable {
            public final /* synthetic */ b.o.a.p.b j;

            public c(b.o.a.p.b bVar) {
                this.j = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f3177b.a(0, "dispatchFrame: executing. Passing", Long.valueOf(this.j.a()), "to processors.");
                Iterator<b.o.a.p.d> it = CameraView.this.E.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().a(this.j);
                    } catch (Exception e) {
                        b.this.f3177b.a(2, "Frame processor crashed:", e);
                    }
                }
                this.j.b();
            }
        }

        public class d implements Runnable {
            public final /* synthetic */ CameraException j;

            public d(CameraException cameraException) {
                this.j = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<b.o.a.a> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    it.next().b(this.j);
                }
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.requestLayout();
            }
        }

        public class f implements Runnable {
            public final /* synthetic */ PointF j;
            public final /* synthetic */ b.o.a.q.a k;

            public f(PointF pointF, b.o.a.q.a aVar) {
                this.j = pointF;
                this.k = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.o.a.s.c cVar = CameraView.this.K;
                PointF[] pointFArr = {this.j};
                View view = cVar.j.get(1);
                if (view != null) {
                    view.clearAnimation();
                    PointF pointF = pointFArr[0];
                    float width = (int) (pointF.x - (view.getWidth() / 2));
                    float height = (int) (pointF.y - (view.getHeight() / 2));
                    view.setTranslationX(width);
                    view.setTranslationY(height);
                }
                b.o.a.s.a aVar = CameraView.this.C;
                if (aVar != null) {
                    aVar.a(this.k != null ? b.o.a.s.b.GESTURE : b.o.a.s.b.METHOD, this.j);
                }
                Iterator<b.o.a.a> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public class g implements Runnable {
            public final /* synthetic */ boolean j;
            public final /* synthetic */ b.o.a.q.a k;
            public final /* synthetic */ PointF l;

            public g(boolean z2, b.o.a.q.a aVar, PointF pointF) {
                this.j = z2;
                this.k = aVar;
                this.l = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView;
                boolean z2;
                if (this.j && (z2 = (cameraView = CameraView.this).l) && z2) {
                    if (cameraView.B == null) {
                        cameraView.B = new MediaActionSound();
                    }
                    cameraView.B.play(1);
                }
                b.o.a.s.a aVar = CameraView.this.C;
                if (aVar != null) {
                    aVar.c(this.k != null ? b.o.a.s.b.GESTURE : b.o.a.s.b.METHOD, this.j, this.l);
                }
                Iterator<b.o.a.a> it = CameraView.this.D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public b() {
            String simpleName = b.class.getSimpleName();
            this.a = simpleName;
            this.f3177b = new b.o.a.b(simpleName);
        }

        public void a(CameraException cameraException) {
            this.f3177b.a(1, "dispatchError", cameraException);
            CameraView.this.u.post(new d(cameraException));
        }

        public void b(@NonNull b.o.a.p.b bVar) {
            this.f3177b.a(0, "dispatchFrame:", Long.valueOf(bVar.a()), "processors:", Integer.valueOf(CameraView.this.E.size()));
            if (CameraView.this.E.isEmpty()) {
                bVar.b();
            } else {
                CameraView.this.v.execute(new c(bVar));
            }
        }

        public void c(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.f3177b.a(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f2));
            CameraView.this.u.post(new RunnableC0491b(f2, fArr, pointFArr));
        }

        public void d(@Nullable b.o.a.q.a aVar, boolean z2, @NonNull PointF pointF) {
            this.f3177b.a(1, "dispatchOnFocusEnd", aVar, Boolean.valueOf(z2), pointF);
            CameraView.this.u.post(new g(z2, aVar, pointF));
        }

        public void e(@Nullable b.o.a.q.a aVar, @NonNull PointF pointF) {
            this.f3177b.a(1, "dispatchOnFocusStart", aVar, pointF);
            CameraView.this.u.post(new f(pointF, aVar));
        }

        public void f(float f2, @Nullable PointF[] pointFArr) {
            this.f3177b.a(1, "dispatchOnZoomChanged", Float.valueOf(f2));
            CameraView.this.u.post(new a(f2, pointFArr));
        }

        @NonNull
        public Context g() {
            return CameraView.this.getContext();
        }

        public void h() {
            b.o.a.x.b bVarC = CameraView.this.f3176z.C(b.o.a.n.t.b.VIEW);
            if (bVarC == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            }
            if (bVarC.equals(CameraView.this.A)) {
                this.f3177b.a(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", bVarC);
            } else {
                this.f3177b.a(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", bVarC);
                CameraView.this.u.post(new e());
            }
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        j = simpleName;
        k = new b.o.a.b(simpleName);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        int i3;
        int i4;
        b.o.a.x.c cVar;
        b.o.a.o.b cVar2;
        super(context, attributeSet);
        this.o = new HashMap<>(4);
        this.D = new CopyOnWriteArrayList();
        this.E = new CopyOnWriteArrayList();
        boolean zIsInEditMode = isInEditMode();
        this.M = zIsInEditMode;
        if (zIsInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.c.CameraView, 0, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraPreview, k.GL_SURFACE.g());
        int i5 = R.c.CameraView_cameraFacing;
        b.o.a.m.e eVar = b.o.a.m.e.BACK;
        if (!b.o.a.e.a(eVar)) {
            b.o.a.m.e eVar2 = b.o.a.m.e.FRONT;
            if (b.o.a.e.a(eVar2)) {
                eVar = eVar2;
            }
        }
        int integer2 = typedArrayObtainStyledAttributes.getInteger(i5, eVar.g());
        int integer3 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFlash, b.o.a.m.f.OFF.g());
        int integer4 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGrid, b.o.a.m.g.OFF.g());
        int integer5 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraWhiteBalance, m.AUTO.g());
        int integer6 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraMode, b.o.a.m.i.PICTURE.g());
        int integer7 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraHdr, h.OFF.g());
        int integer8 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudio, b.o.a.m.a.ON.g());
        int integer9 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoCodec, l.DEVICE_DEFAULT.g());
        int integer10 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudioCodec, b.o.a.m.b.DEVICE_DEFAULT.g());
        int integer11 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraEngine, b.o.a.m.d.CAMERA1.g());
        int integer12 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraPictureFormat, j.JPEG.g());
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPlaySounds, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraUseDeviceOrientation, true);
        this.L = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraExperimental, false);
        this.n = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraRequestPermissions, true);
        this.p = k.f(integer);
        this.q = b.o.a.m.d.f(integer11);
        int color = typedArrayObtainStyledAttributes.getColor(R.c.CameraView_cameraGridColor, b.o.a.r.d.j);
        long j2 = (long) typedArrayObtainStyledAttributes.getFloat(R.c.CameraView_cameraVideoMaxSize, 0.0f);
        int integer13 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoMaxDuration, 0);
        int integer14 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraVideoBitRate, 0);
        int integer15 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAudioBitRate, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(R.c.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPreviewFrameRateExact, false);
        long integer16 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraAutoFocusResetDelay, PathInterpolatorCompat.MAX_NUM_POINTS);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureMetering, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSnapshotMetering, false);
        int integer17 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraSnapshotMaxWidth, 0);
        int integer18 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraSnapshotMaxHeight, 0);
        int integer19 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer20 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer21 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingFormat, 0);
        int integer22 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer23 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraFrameProcessingExecutors, 1);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraDrawHardwareOverlays, false);
        ArrayList arrayList = new ArrayList(3);
        int i6 = R.c.CameraView_cameraPictureSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            i = integer8;
            i2 = 0;
            arrayList.add(b.i.a.f.e.o.f.N0(typedArrayObtainStyledAttributes.getInteger(i6, 0)));
        } else {
            i = integer8;
            i2 = 0;
        }
        int i7 = R.c.CameraView_cameraPictureSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            arrayList.add(b.i.a.f.e.o.f.L0(typedArrayObtainStyledAttributes.getInteger(i7, i2)));
        }
        int i8 = R.c.CameraView_cameraPictureSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            arrayList.add(b.i.a.f.e.o.f.M0(typedArrayObtainStyledAttributes.getInteger(i8, i2)));
        }
        int i9 = R.c.CameraView_cameraPictureSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            arrayList.add(b.i.a.f.e.o.f.K0(typedArrayObtainStyledAttributes.getInteger(i9, i2)));
        }
        int i10 = R.c.CameraView_cameraPictureSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            arrayList.add(b.i.a.f.e.o.f.D1(new b.o.a.x.h(typedArrayObtainStyledAttributes.getInteger(i10, i2))));
        }
        int i11 = R.c.CameraView_cameraPictureSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            arrayList.add(b.i.a.f.e.o.f.D1(new b.o.a.x.g(typedArrayObtainStyledAttributes.getInteger(i11, 0))));
        }
        int i12 = R.c.CameraView_cameraPictureSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            i3 = integer7;
            arrayList.add(b.i.a.f.e.o.f.D1(new b.o.a.x.d(b.o.a.x.a.h(typedArrayObtainStyledAttributes.getString(i12)).i(), 0.0f)));
        } else {
            i3 = integer7;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(new b.o.a.x.f());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(new b.o.a.x.e());
        }
        b.o.a.x.c cVarG = !arrayList.isEmpty() ? b.i.a.f.e.o.f.g((b.o.a.x.c[]) arrayList.toArray(new b.o.a.x.c[0])) : new b.o.a.x.e();
        ArrayList arrayList2 = new ArrayList(3);
        int i13 = R.c.CameraView_cameraVideoSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            i4 = 0;
            arrayList2.add(b.i.a.f.e.o.f.N0(typedArrayObtainStyledAttributes.getInteger(i13, 0)));
        } else {
            i4 = 0;
        }
        int i14 = R.c.CameraView_cameraVideoSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            arrayList2.add(b.i.a.f.e.o.f.L0(typedArrayObtainStyledAttributes.getInteger(i14, i4)));
        }
        int i15 = R.c.CameraView_cameraVideoSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            arrayList2.add(b.i.a.f.e.o.f.M0(typedArrayObtainStyledAttributes.getInteger(i15, i4)));
        }
        int i16 = R.c.CameraView_cameraVideoSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            arrayList2.add(b.i.a.f.e.o.f.K0(typedArrayObtainStyledAttributes.getInteger(i16, i4)));
        }
        int i17 = R.c.CameraView_cameraVideoSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            arrayList2.add(b.i.a.f.e.o.f.D1(new b.o.a.x.h(typedArrayObtainStyledAttributes.getInteger(i17, i4))));
        }
        int i18 = R.c.CameraView_cameraVideoSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            arrayList2.add(b.i.a.f.e.o.f.D1(new b.o.a.x.g(typedArrayObtainStyledAttributes.getInteger(i18, 0))));
        }
        int i19 = R.c.CameraView_cameraVideoSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            cVar = cVarG;
            arrayList2.add(b.i.a.f.e.o.f.D1(new b.o.a.x.d(b.o.a.x.a.h(typedArrayObtainStyledAttributes.getString(i19)).i(), 0.0f)));
        } else {
            cVar = cVarG;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(new b.o.a.x.f());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.c.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(new b.o.a.x.e());
        }
        b.o.a.x.c cVarG2 = !arrayList2.isEmpty() ? b.i.a.f.e.o.f.g((b.o.a.x.c[]) arrayList2.toArray(new b.o.a.x.c[0])) : new b.o.a.x.e();
        int i20 = R.c.CameraView_cameraGestureTap;
        b.o.a.q.b bVar = b.o.a.q.b.j;
        int integer24 = typedArrayObtainStyledAttributes.getInteger(i20, bVar.h());
        int integer25 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureLongTap, bVar.h());
        int integer26 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGesturePinch, bVar.h());
        int integer27 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureScrollHorizontal, bVar.h());
        int integer28 = typedArrayObtainStyledAttributes.getInteger(R.c.CameraView_cameraGestureScrollVertical, bVar.h());
        String string = typedArrayObtainStyledAttributes.getString(R.c.CameraView_cameraAutoFocusMarker);
        b.o.a.s.a aVar = null;
        if (string != null) {
            try {
                aVar = (b.o.a.s.a) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
        try {
            cVar2 = (b.o.a.o.b) Class.forName(typedArrayObtainStyledAttributes.getString(R.c.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused2) {
            cVar2 = new b.o.a.o.c();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.w = new b();
        this.u = new Handler(Looper.getMainLooper());
        this.G = new e(this.w);
        this.H = new g(this.w);
        this.I = new b.o.a.q.f(this.w);
        this.J = new b.o.a.r.d(context);
        this.N = new b.o.a.u.c(context);
        this.K = new b.o.a.s.c(context);
        addView(this.J);
        addView(this.K);
        addView(this.N);
        b();
        setPlaySounds(z2);
        setUseDeviceOrientation(z3);
        setGrid(b.o.a.m.g.f(integer4));
        setGridColor(color);
        setDrawHardwareOverlays(z7);
        setFacing(b.o.a.m.e.f(integer2));
        setFlash(b.o.a.m.f.f(integer3));
        setMode(b.o.a.m.i.f(integer6));
        setWhiteBalance(m.f(integer5));
        setHdr(h.f(i3));
        setAudio(b.o.a.m.a.f(i));
        setAudioBitRate(integer15);
        setAudioCodec(b.o.a.m.b.f(integer10));
        setPictureSize(cVar);
        setPictureMetering(z5);
        setPictureSnapshotMetering(z6);
        setPictureFormat(j.f(integer12));
        setVideoSize(cVarG2);
        setVideoCodec(l.f(integer9));
        setVideoMaxSize(j2);
        setVideoMaxDuration(integer13);
        setVideoBitRate(integer14);
        setAutoFocusResetDelay(integer16);
        setPreviewFrameRateExact(z4);
        setPreviewFrameRate(f);
        setSnapshotMaxWidth(integer17);
        setSnapshotMaxHeight(integer18);
        setFrameProcessingMaxWidth(integer19);
        setFrameProcessingMaxHeight(integer20);
        setFrameProcessingFormat(integer21);
        setFrameProcessingPoolSize(integer22);
        setFrameProcessingExecutors(integer23);
        e(b.o.a.q.a.k, b.o.a.q.b.f(integer24));
        e(b.o.a.q.a.l, b.o.a.q.b.f(integer25));
        e(b.o.a.q.a.j, b.o.a.q.b.f(integer26));
        e(b.o.a.q.a.m, b.o.a.q.b.f(integer27));
        e(b.o.a.q.a.n, b.o.a.q.b.f(integer28));
        setAutoFocusMarker(aVar);
        setFilter(cVar2);
        this.f3175y = new b.o.a.r.f(context, this.w);
    }

    @SuppressLint({"NewApi"})
    public boolean a(@NonNull b.o.a.m.a aVar) {
        b.o.a.m.a aVar2 = b.o.a.m.a.STEREO;
        b.o.a.m.a aVar3 = b.o.a.m.a.MONO;
        b.o.a.m.a aVar4 = b.o.a.m.a.ON;
        if (aVar == aVar4 || aVar == aVar3 || aVar == aVar2) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (!str.equals("android.permission.RECORD_AUDIO")) {
                    }
                }
                throw new IllegalStateException(k.a(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z2 = aVar == aVar4 || aVar == aVar3 || aVar == aVar2;
        boolean z3 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z4 = z2 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z3 && !z4) {
            return true;
        }
        if (this.n) {
            Activity activity = null;
            for (Context context2 = getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (z3) {
                arrayList.add("android.permission.CAMERA");
            }
            if (z4) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (activity != null) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!this.M) {
            Objects.requireNonNull(this.N);
            if (layoutParams instanceof c.a) {
                this.N.addView(view, layoutParams);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b() {
        i bVar;
        b.o.a.b bVar2 = k;
        bVar2.a(2, "doInstantiateEngine:", "instantiating. engine:", this.q);
        b.o.a.m.d dVar = this.q;
        b bVar3 = this.w;
        if (this.L && dVar == b.o.a.m.d.CAMERA2) {
            bVar = new b.o.a.n.d(bVar3);
        } else {
            this.q = b.o.a.m.d.CAMERA1;
            bVar = new b.o.a.n.b(bVar3);
        }
        this.f3176z = bVar;
        bVar2.a(2, "doInstantiateEngine:", "instantiated. engine:", bVar.getClass().getSimpleName());
        this.f3176z.o0(this.N);
    }

    public final boolean c() {
        i iVar = this.f3176z;
        return iVar.n.f == b.o.a.n.v.e.OFF && !iVar.O();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.M) {
            return;
        }
        b.o.a.r.f fVar = this.f3175y;
        if (fVar.h) {
            fVar.h = false;
            fVar.d.disable();
            ((DisplayManager) fVar.f1951b.getSystemService("display")).unregisterDisplayListener(fVar.f);
            fVar.g = -1;
            fVar.e = -1;
        }
        this.f3176z.L0(false);
        b.o.a.w.a aVar = this.f3174x;
        if (aVar != null) {
            aVar.p();
        }
    }

    public boolean d() {
        b.o.a.n.v.e eVar = this.f3176z.n.f;
        b.o.a.n.v.e eVar2 = b.o.a.n.v.e.ENGINE;
        return eVar.f(eVar2) && this.f3176z.n.g.f(eVar2);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.M) {
            return;
        }
        this.D.clear();
        boolean z2 = this.E.size() > 0;
        this.E.clear();
        if (z2) {
            this.f3176z.k0(false);
        }
        this.f3176z.d(true, 0);
        b.o.a.w.a aVar = this.f3174x;
        if (aVar != null) {
            aVar.o();
        }
    }

    public boolean e(@NonNull b.o.a.q.a aVar, @NonNull b.o.a.q.b bVar) {
        b.o.a.q.b bVar2 = b.o.a.q.b.j;
        if (!aVar.f(bVar)) {
            e(aVar, bVar2);
            return false;
        }
        this.o.put(aVar, bVar);
        int iOrdinal = aVar.ordinal();
        if (iOrdinal == 0) {
            this.G.a = this.o.get(b.o.a.q.a.j) != bVar2;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            this.H.a = (this.o.get(b.o.a.q.a.k) == bVar2 && this.o.get(b.o.a.q.a.l) == bVar2) ? false : true;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            this.I.a = (this.o.get(b.o.a.q.a.m) == bVar2 && this.o.get(b.o.a.q.a.n) == bVar2) ? false : true;
        }
        this.t = 0;
        Iterator<b.o.a.q.b> it = this.o.values().iterator();
        while (it.hasNext()) {
            this.t += it.next() == bVar2 ? 0 : 1;
        }
        return true;
    }

    public final String f(int i) {
        if (i == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i == 0) {
            return "UNSPECIFIED";
        }
        if (i != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    public final void g(@NonNull b.o.a.q.c cVar, @NonNull b.o.a.c cVar2) {
        b.o.a.q.a aVar = cVar.f1947b;
        b.o.a.q.b bVar = this.o.get(aVar);
        PointF[] pointFArr = cVar.c;
        switch (bVar.ordinal()) {
            case 1:
                float width = getWidth();
                float height = getHeight();
                RectF rectFA = b.o.a.t.b.a(pointFArr[0], width * 0.05f, 0.05f * height);
                ArrayList arrayList = new ArrayList();
                PointF pointF = new PointF(rectFA.centerX(), rectFA.centerY());
                float fWidth = rectFA.width();
                float fHeight = rectFA.height();
                arrayList.add(new b.o.a.t.a(rectFA, 1000));
                arrayList.add(new b.o.a.t.a(b.o.a.t.b.a(pointF, fWidth * 1.5f, fHeight * 1.5f), Math.round(1000 * 0.1f)));
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b.o.a.t.a aVar2 = (b.o.a.t.a) it.next();
                    Objects.requireNonNull(aVar2);
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    RectF rectF2 = new RectF();
                    rectF2.set(Math.max(rectF.left, aVar2.j.left), Math.max(rectF.top, aVar2.j.top), Math.min(rectF.right, aVar2.j.right), Math.min(rectF.bottom, aVar2.j.bottom));
                    arrayList2.add(new b.o.a.t.a(rectF2, aVar2.k));
                }
                this.f3176z.I0(aVar, new b.o.a.t.b(arrayList2), pointFArr[0]);
                break;
            case 2:
                this.f3176z.O0(new l.a());
                break;
            case 3:
                this.f3176z.P0(new l.a());
                break;
            case 4:
                float fN = this.f3176z.N();
                float fA = cVar.a(fN, 0.0f, 1.0f);
                if (fA != fN) {
                    this.f3176z.G0(fA, pointFArr, true);
                    break;
                }
                break;
            case 5:
                float fK = this.f3176z.k();
                float f = cVar2.m;
                float f2 = cVar2.n;
                float fA2 = cVar.a(fK, f, f2);
                if (fA2 != fK) {
                    this.f3176z.d0(fA2, new float[]{f, f2}, pointFArr, true);
                    break;
                }
                break;
            case 6:
                if (getFilter() instanceof b.o.a.o.d) {
                    b.o.a.o.d dVar = (b.o.a.o.d) getFilter();
                    float fI = dVar.i();
                    float fA3 = cVar.a(fI, 0.0f, 1.0f);
                    if (fA3 != fI) {
                        dVar.d(fA3);
                        break;
                    }
                }
                break;
            case 7:
                if (getFilter() instanceof b.o.a.o.e) {
                    b.o.a.o.e eVar = (b.o.a.o.e) getFilter();
                    float fG = eVar.g();
                    float fA4 = cVar.a(fG, 0.0f, 1.0f);
                    if (fA4 != fG) {
                        eVar.b(fA4);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @NonNull
    public b.o.a.m.a getAudio() {
        return this.f3176z.f();
    }

    public int getAudioBitRate() {
        return this.f3176z.g();
    }

    @NonNull
    public b.o.a.m.b getAudioCodec() {
        return this.f3176z.h();
    }

    public long getAutoFocusResetDelay() {
        return this.f3176z.i();
    }

    @Nullable
    public b.o.a.c getCameraOptions() {
        return this.f3176z.j();
    }

    public boolean getDrawHardwareOverlays() {
        return this.N.getHardwareCanvasEnabled();
    }

    @NonNull
    public b.o.a.m.d getEngine() {
        return this.q;
    }

    public float getExposureCorrection() {
        return this.f3176z.k();
    }

    @NonNull
    public b.o.a.m.e getFacing() {
        return this.f3176z.l();
    }

    @NonNull
    public b.o.a.o.b getFilter() {
        Object obj = this.f3174x;
        if (obj == null) {
            return this.r;
        }
        if (obj instanceof b.o.a.w.b) {
            return ((b.o.a.w.b) obj).c();
        }
        StringBuilder sbU = b.d.b.a.a.U("Filters are only supported by the GL_SURFACE preview. Current:");
        sbU.append(this.p);
        throw new RuntimeException(sbU.toString());
    }

    @NonNull
    public b.o.a.m.f getFlash() {
        return this.f3176z.m();
    }

    public int getFrameProcessingExecutors() {
        return this.f3173s;
    }

    public int getFrameProcessingFormat() {
        return this.f3176z.n();
    }

    public int getFrameProcessingMaxHeight() {
        return this.f3176z.o();
    }

    public int getFrameProcessingMaxWidth() {
        return this.f3176z.p();
    }

    public int getFrameProcessingPoolSize() {
        return this.f3176z.q();
    }

    @NonNull
    public b.o.a.m.g getGrid() {
        return this.J.getGridMode();
    }

    public int getGridColor() {
        return this.J.getGridColor();
    }

    @NonNull
    public h getHdr() {
        return this.f3176z.r();
    }

    @Nullable
    public Location getLocation() {
        return this.f3176z.s();
    }

    @NonNull
    public b.o.a.m.i getMode() {
        return this.f3176z.t();
    }

    @NonNull
    public j getPictureFormat() {
        return this.f3176z.u();
    }

    public boolean getPictureMetering() {
        return this.f3176z.v();
    }

    @Nullable
    public b.o.a.x.b getPictureSize() {
        return this.f3176z.w(b.o.a.n.t.b.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.f3176z.y();
    }

    public boolean getPlaySounds() {
        return this.l;
    }

    @NonNull
    public k getPreview() {
        return this.p;
    }

    public float getPreviewFrameRate() {
        return this.f3176z.A();
    }

    public boolean getPreviewFrameRateExact() {
        return this.f3176z.B();
    }

    public int getSnapshotMaxHeight() {
        return this.f3176z.D();
    }

    public int getSnapshotMaxWidth() {
        return this.f3176z.E();
    }

    @Nullable
    public b.o.a.x.b getSnapshotSize() {
        b.o.a.x.b bVar = null;
        if (getWidth() != 0 && getHeight() != 0) {
            i iVar = this.f3176z;
            b.o.a.n.t.b bVar2 = b.o.a.n.t.b.VIEW;
            b.o.a.x.b bVarF = iVar.F(bVar2);
            if (bVarF == null) {
                return null;
            }
            Rect rectL = b.i.a.f.e.o.f.L(bVarF, b.o.a.x.a.f(getWidth(), getHeight()));
            bVar = new b.o.a.x.b(rectL.width(), rectL.height());
            if (this.f3176z.e().b(bVar2, b.o.a.n.t.b.OUTPUT)) {
                return bVar.f();
            }
        }
        return bVar;
    }

    public boolean getUseDeviceOrientation() {
        return this.m;
    }

    public int getVideoBitRate() {
        return this.f3176z.G();
    }

    @NonNull
    public b.o.a.m.l getVideoCodec() {
        return this.f3176z.H();
    }

    public int getVideoMaxDuration() {
        return this.f3176z.I();
    }

    public long getVideoMaxSize() {
        return this.f3176z.J();
    }

    @Nullable
    public b.o.a.x.b getVideoSize() {
        return this.f3176z.K(b.o.a.n.t.b.OUTPUT);
    }

    @NonNull
    public m getWhiteBalance() {
        return this.f3176z.M();
    }

    public float getZoom() {
        return this.f3176z.N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        b.o.a.w.a hVar;
        super.onAttachedToWindow();
        if (!this.M && this.f3174x == null) {
            b.o.a.b bVar = k;
            bVar.a(2, "doInstantiateEngine:", "instantiating. preview:", this.p);
            k kVar = this.p;
            Context context = getContext();
            int iOrdinal = kVar.ordinal();
            if (iOrdinal == 0) {
                hVar = new b.o.a.w.h(context, this);
            } else if (iOrdinal == 1 && isHardwareAccelerated()) {
                hVar = new b.o.a.w.j(context, this);
            } else {
                this.p = k.GL_SURFACE;
                hVar = new b.o.a.w.d(context, this);
            }
            this.f3174x = hVar;
            bVar.a(2, "doInstantiateEngine:", "instantiated. preview:", hVar.getClass().getSimpleName());
            this.f3176z.u0(this.f3174x);
            b.o.a.o.b bVar2 = this.r;
            if (bVar2 != null) {
                setFilter(bVar2);
                this.r = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.A = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.t > 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.M) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), BasicMeasure.EXACTLY));
            return;
        }
        b.o.a.x.b bVarC = this.f3176z.C(b.o.a.n.t.b.VIEW);
        this.A = bVarC;
        if (bVarC == null) {
            k.a(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        b.o.a.x.b bVar = this.A;
        float f = bVar.j;
        float f2 = bVar.k;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f3174x.u()) {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = BasicMeasure.EXACTLY;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = BasicMeasure.EXACTLY;
            }
        } else {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        }
        b.o.a.b bVar2 = k;
        StringBuilder sbV = b.d.b.a.a.V("requested dimensions are (", size, "[");
        sbV.append(f(mode));
        sbV.append("]x");
        sbV.append(size2);
        sbV.append("[");
        sbV.append(f(mode2));
        sbV.append("])");
        bVar2.a(1, "onMeasure:", sbV.toString());
        bVar2.a(1, "onMeasure:", "previewSize is", "(" + f + "x" + f2 + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            bVar2.a(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            bVar2.a(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f + "x" + f2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) f2, BasicMeasure.EXACTLY));
            return;
        }
        float f3 = f2 / f;
        if (mode == 0 || mode2 == 0) {
            if (mode == 0) {
                size = Math.round(size2 / f3);
            } else {
                size2 = Math.round(size * f3);
            }
            bVar2.a(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(Math.round(size2 / f3), size);
            } else {
                size2 = Math.min(Math.round(size * f3), size2);
            }
            bVar2.a(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        float f4 = size2;
        float f5 = size;
        if (f4 / f5 >= f3) {
            size2 = Math.round(f5 * f3);
        } else {
            size = Math.round(f4 / f3);
        }
        bVar2.a(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!d()) {
            return true;
        }
        b.o.a.c cVarJ = this.f3176z.j();
        if (cVarJ == null) {
            throw new IllegalStateException("Options should not be null here.");
        }
        e eVar = this.G;
        if (!eVar.a ? false : eVar.c(motionEvent)) {
            k.a(1, "onTouchEvent", "pinch!");
            g(this.G, cVarJ);
        } else {
            b.o.a.q.f fVar = this.I;
            if (!fVar.a ? false : fVar.c(motionEvent)) {
                k.a(1, "onTouchEvent", "scroll!");
                g(this.I, cVarJ);
            } else {
                g gVar = this.H;
                if (!gVar.a ? false : gVar.c(motionEvent)) {
                    k.a(1, "onTouchEvent", "tap!");
                    g(this.H, cVarJ);
                }
            }
        }
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.M) {
            return;
        }
        b.o.a.w.a aVar = this.f3174x;
        if (aVar != null) {
            aVar.q();
        }
        if (a(getAudio())) {
            b.o.a.r.f fVar = this.f3175y;
            if (!fVar.h) {
                fVar.h = true;
                fVar.g = fVar.a();
                ((DisplayManager) fVar.f1951b.getSystemService("display")).registerDisplayListener(fVar.f, fVar.a);
                fVar.d.enable();
            }
            b.o.a.n.t.a aVarE = this.f3176z.e();
            int i = this.f3175y.g;
            aVarE.e(i);
            aVarE.d = i;
            aVarE.d();
            this.f3176z.H0();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.M && layoutParams != null) {
            Objects.requireNonNull(this.N);
            if (layoutParams instanceof c.a) {
                this.N.removeView(view);
                return;
            }
        }
        super.removeView(view);
    }

    public void set(@NonNull b.o.a.m.c cVar) {
        if (cVar instanceof b.o.a.m.a) {
            setAudio((b.o.a.m.a) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.e) {
            setFacing((b.o.a.m.e) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.f) {
            setFlash((b.o.a.m.f) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.g) {
            setGrid((b.o.a.m.g) cVar);
            return;
        }
        if (cVar instanceof h) {
            setHdr((h) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.i) {
            setMode((b.o.a.m.i) cVar);
            return;
        }
        if (cVar instanceof m) {
            setWhiteBalance((m) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.l) {
            setVideoCodec((b.o.a.m.l) cVar);
            return;
        }
        if (cVar instanceof b.o.a.m.b) {
            setAudioCodec((b.o.a.m.b) cVar);
            return;
        }
        if (cVar instanceof k) {
            setPreview((k) cVar);
        } else if (cVar instanceof b.o.a.m.d) {
            setEngine((b.o.a.m.d) cVar);
        } else if (cVar instanceof j) {
            setPictureFormat((j) cVar);
        }
    }

    public void setAudio(@NonNull b.o.a.m.a aVar) {
        if (aVar == getAudio() || c()) {
            this.f3176z.Z(aVar);
        } else if (a(aVar)) {
            this.f3176z.Z(aVar);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i) {
        this.f3176z.a0(i);
    }

    public void setAudioCodec(@NonNull b.o.a.m.b bVar) {
        this.f3176z.b0(bVar);
    }

    public void setAutoFocusMarker(@Nullable b.o.a.s.a aVar) {
        View viewB;
        this.C = aVar;
        b.o.a.s.c cVar = this.K;
        View view = cVar.j.get(1);
        if (view != null) {
            cVar.removeView(view);
        }
        if (aVar == null || (viewB = aVar.b(cVar.getContext(), cVar)) == null) {
            return;
        }
        cVar.j.put(1, viewB);
        cVar.addView(viewB);
    }

    public void setAutoFocusResetDelay(long j2) {
        this.f3176z.c0(j2);
    }

    public void setDrawHardwareOverlays(boolean z2) {
        this.N.setHardwareCanvasEnabled(z2);
    }

    public void setEngine(@NonNull b.o.a.m.d dVar) {
        if (c()) {
            this.q = dVar;
            i iVar = this.f3176z;
            b();
            b.o.a.w.a aVar = this.f3174x;
            if (aVar != null) {
                this.f3176z.u0(aVar);
            }
            setFacing(iVar.l());
            setFlash(iVar.m());
            setMode(iVar.t());
            setWhiteBalance(iVar.M());
            setHdr(iVar.r());
            setAudio(iVar.f());
            setAudioBitRate(iVar.g());
            setAudioCodec(iVar.h());
            setPictureSize(iVar.x());
            setPictureFormat(iVar.u());
            setVideoSize(iVar.L());
            setVideoCodec(iVar.H());
            setVideoMaxSize(iVar.J());
            setVideoMaxDuration(iVar.I());
            setVideoBitRate(iVar.G());
            setAutoFocusResetDelay(iVar.i());
            setPreviewFrameRate(iVar.A());
            setPreviewFrameRateExact(iVar.B());
            setSnapshotMaxWidth(iVar.E());
            setSnapshotMaxHeight(iVar.D());
            setFrameProcessingMaxWidth(iVar.p());
            setFrameProcessingMaxHeight(iVar.o());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(iVar.q());
            this.f3176z.k0(!this.E.isEmpty());
        }
    }

    public void setExperimental(boolean z2) {
        this.L = z2;
    }

    public void setExposureCorrection(float f) {
        b.o.a.c cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f2 = cameraOptions.m;
            float f3 = cameraOptions.n;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                f = f3;
            }
            this.f3176z.d0(f, new float[]{f2, f3}, null, false);
        }
    }

    public void setFacing(@NonNull b.o.a.m.e eVar) {
        this.f3176z.e0(eVar);
    }

    public void setFilter(@NonNull b.o.a.o.b bVar) {
        Object obj = this.f3174x;
        if (obj == null) {
            this.r = bVar;
            return;
        }
        boolean z2 = obj instanceof b.o.a.w.b;
        if (!(bVar instanceof b.o.a.o.c) && !z2) {
            StringBuilder sbU = b.d.b.a.a.U("Filters are only supported by the GL_SURFACE preview. Current preview:");
            sbU.append(this.p);
            throw new RuntimeException(sbU.toString());
        }
        if (z2) {
            ((b.o.a.w.b) obj).a(bVar);
        }
    }

    public void setFlash(@NonNull b.o.a.m.f fVar) {
        this.f3176z.f0(fVar);
    }

    public void setFrameProcessingExecutors(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(b.d.b.a.a.q("Need at least 1 executor, got ", i));
        }
        this.f3173s = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.v = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i) {
        this.f3176z.g0(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.f3176z.h0(i);
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.f3176z.i0(i);
    }

    public void setFrameProcessingPoolSize(int i) {
        this.f3176z.j0(i);
    }

    public void setGrid(@NonNull b.o.a.m.g gVar) {
        this.J.setGridMode(gVar);
    }

    public void setGridColor(@ColorInt int i) {
        this.J.setGridColor(i);
    }

    public void setHdr(@NonNull h hVar) {
        this.f3176z.l0(hVar);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Lifecycle lifecycle = this.F;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
                this.F = null;
                return;
            }
            return;
        }
        Lifecycle lifecycle2 = this.F;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
            this.F = null;
        }
        Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
        this.F = lifecycle3;
        lifecycle3.addObserver(this);
    }

    public void setLocation(@Nullable Location location) {
        this.f3176z.m0(location);
    }

    public void setMode(@NonNull b.o.a.m.i iVar) {
        this.f3176z.n0(iVar);
    }

    public void setPictureFormat(@NonNull j jVar) {
        this.f3176z.p0(jVar);
    }

    public void setPictureMetering(boolean z2) {
        this.f3176z.q0(z2);
    }

    public void setPictureSize(@NonNull b.o.a.x.c cVar) {
        this.f3176z.r0(cVar);
    }

    public void setPictureSnapshotMetering(boolean z2) {
        this.f3176z.s0(z2);
    }

    public void setPlaySounds(boolean z2) {
        this.l = z2;
        this.f3176z.t0(z2);
    }

    public void setPreview(@NonNull k kVar) {
        b.o.a.w.a aVar;
        if (kVar != this.p) {
            this.p = kVar;
            if ((getWindowToken() != null) || (aVar = this.f3174x) == null) {
                return;
            }
            aVar.o();
            this.f3174x = null;
        }
    }

    public void setPreviewFrameRate(float f) {
        this.f3176z.v0(f);
    }

    public void setPreviewFrameRateExact(boolean z2) {
        this.f3176z.w0(z2);
    }

    public void setPreviewStreamSize(@NonNull b.o.a.x.c cVar) {
        this.f3176z.x0(cVar);
    }

    public void setRequestPermissions(boolean z2) {
        this.n = z2;
    }

    public void setSnapshotMaxHeight(int i) {
        this.f3176z.y0(i);
    }

    public void setSnapshotMaxWidth(int i) {
        this.f3176z.z0(i);
    }

    public void setUseDeviceOrientation(boolean z2) {
        this.m = z2;
    }

    public void setVideoBitRate(int i) {
        this.f3176z.A0(i);
    }

    public void setVideoCodec(@NonNull b.o.a.m.l lVar) {
        this.f3176z.B0(lVar);
    }

    public void setVideoMaxDuration(int i) {
        this.f3176z.C0(i);
    }

    public void setVideoMaxSize(long j2) {
        this.f3176z.D0(j2);
    }

    public void setVideoSize(@NonNull b.o.a.x.c cVar) {
        this.f3176z.E0(cVar);
    }

    public void setWhiteBalance(@NonNull m mVar) {
        this.f3176z.F0(mVar);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f3176z.G0(f, null, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.M) {
            b.o.a.u.c cVar = this.N;
            Objects.requireNonNull(cVar);
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = cVar.getContext().obtainStyledAttributes(attributeSet, R.c.CameraView_Layout);
                z = typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnPreview) || typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnPictureSnapshot) || typedArrayObtainStyledAttributes.hasValue(R.c.CameraView_Layout_layout_drawOnVideoSnapshot);
                typedArrayObtainStyledAttributes.recycle();
            }
            if (z) {
                return this.N.c(attributeSet);
            }
        }
        return super.generateLayoutParams(attributeSet);
    }
}
