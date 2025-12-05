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
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p452o.p453a.CameraListener;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.CameraOptions;
import p007b.p452o.p453a.CameraUtils2;
import p007b.p452o.p453a.PictureResult;
import p007b.p452o.p453a.p454m.Audio;
import p007b.p452o.p453a.p454m.AudioCodec;
import p007b.p452o.p453a.p454m.Control;
import p007b.p452o.p453a.p454m.Engine;
import p007b.p452o.p453a.p454m.Facing;
import p007b.p452o.p453a.p454m.Flash;
import p007b.p452o.p453a.p454m.Grid;
import p007b.p452o.p453a.p454m.Hdr;
import p007b.p452o.p453a.p454m.Mode3;
import p007b.p452o.p453a.p454m.PictureFormat;
import p007b.p452o.p453a.p454m.Preview;
import p007b.p452o.p453a.p454m.VideoCodec;
import p007b.p452o.p453a.p454m.WhiteBalance;
import p007b.p452o.p453a.p455n.Camera1Engine2;
import p007b.p452o.p453a.p455n.Camera2Engine;
import p007b.p452o.p453a.p455n.CameraEngine;
import p007b.p452o.p453a.p455n.p461t.Angles;
import p007b.p452o.p453a.p455n.p461t.Reference2;
import p007b.p452o.p453a.p455n.p463v.CameraState2;
import p007b.p452o.p453a.p464o.Filter2;
import p007b.p452o.p453a.p464o.NoFilter;
import p007b.p452o.p453a.p464o.OneParameterFilter;
import p007b.p452o.p453a.p464o.TwoParameterFilter;
import p007b.p452o.p453a.p465p.Frame2;
import p007b.p452o.p453a.p465p.FrameProcessor;
import p007b.p452o.p453a.p466q.Gesture;
import p007b.p452o.p453a.p466q.GestureAction;
import p007b.p452o.p453a.p466q.GestureFinder;
import p007b.p452o.p453a.p466q.PinchGestureFinder;
import p007b.p452o.p453a.p466q.ScrollGestureFinder;
import p007b.p452o.p453a.p466q.TapGestureFinder;
import p007b.p452o.p453a.p467r.GridLinesLayout;
import p007b.p452o.p453a.p467r.OrientationHelper2;
import p007b.p452o.p453a.p468s.AutoFocusMarker;
import p007b.p452o.p453a.p468s.AutoFocusTrigger;
import p007b.p452o.p453a.p468s.MarkerLayout;
import p007b.p452o.p453a.p469t.MeteringRegion;
import p007b.p452o.p453a.p469t.MeteringRegions;
import p007b.p452o.p453a.p470u.OverlayLayout;
import p007b.p452o.p453a.p472w.CameraPreview;
import p007b.p452o.p453a.p472w.FilterCameraPreview;
import p007b.p452o.p453a.p472w.GlCameraPreview2;
import p007b.p452o.p453a.p472w.SurfaceCameraPreview2;
import p007b.p452o.p453a.p472w.TextureCameraPreview2;
import p007b.p452o.p453a.p473x.AspectRatio2;
import p007b.p452o.p453a.p473x.Size3;
import p007b.p452o.p453a.p473x.SizeSelector;
import p007b.p452o.p453a.p473x.SizeSelectors;
import p007b.p452o.p453a.p473x.SizeSelectors2;
import p007b.p452o.p453a.p473x.SizeSelectors3;
import p007b.p452o.p453a.p473x.SizeSelectors4;
import p007b.p452o.p453a.p473x.SizeSelectors5;

/* loaded from: classes3.dex */
public class CameraView extends FrameLayout implements LifecycleObserver {

    /* renamed from: j */
    public static final String f22108j;

    /* renamed from: k */
    public static final CameraLogger f22109k;

    /* renamed from: A */
    public Size3 f22110A;

    /* renamed from: B */
    public MediaActionSound f22111B;

    /* renamed from: C */
    public AutoFocusMarker f22112C;

    /* renamed from: D */
    @VisibleForTesting
    public List<CameraListener> f22113D;

    /* renamed from: E */
    @VisibleForTesting
    public List<FrameProcessor> f22114E;

    /* renamed from: F */
    public Lifecycle f22115F;

    /* renamed from: G */
    @VisibleForTesting
    public PinchGestureFinder f22116G;

    /* renamed from: H */
    @VisibleForTesting
    public TapGestureFinder f22117H;

    /* renamed from: I */
    @VisibleForTesting
    public ScrollGestureFinder f22118I;

    /* renamed from: J */
    @VisibleForTesting
    public GridLinesLayout f22119J;

    /* renamed from: K */
    @VisibleForTesting
    public MarkerLayout f22120K;

    /* renamed from: L */
    public boolean f22121L;

    /* renamed from: M */
    public boolean f22122M;

    /* renamed from: N */
    @VisibleForTesting
    public OverlayLayout f22123N;

    /* renamed from: l */
    public boolean f22124l;

    /* renamed from: m */
    public boolean f22125m;

    /* renamed from: n */
    public boolean f22126n;

    /* renamed from: o */
    public HashMap<Gesture, GestureAction> f22127o;

    /* renamed from: p */
    public Preview f22128p;

    /* renamed from: q */
    public Engine f22129q;

    /* renamed from: r */
    public Filter2 f22130r;

    /* renamed from: s */
    public int f22131s;

    /* renamed from: t */
    public int f22132t;

    /* renamed from: u */
    public Handler f22133u;

    /* renamed from: v */
    public Executor f22134v;

    /* renamed from: w */
    @VisibleForTesting
    public C11195b f22135w;

    /* renamed from: x */
    public CameraPreview f22136x;

    /* renamed from: y */
    public OrientationHelper2 f22137y;

    /* renamed from: z */
    public CameraEngine f22138z;

    /* renamed from: com.otaliastudios.cameraview.CameraView$a */
    public class ThreadFactoryC11194a implements ThreadFactory {

        /* renamed from: j */
        public final AtomicInteger f22139j = new AtomicInteger(1);

        public ThreadFactoryC11194a(CameraView cameraView) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            StringBuilder sbM833U = outline.m833U("FrameExecutor #");
            sbM833U.append(this.f22139j.getAndIncrement());
            return new Thread(runnable, sbM833U.toString());
        }
    }

    @VisibleForTesting
    /* renamed from: com.otaliastudios.cameraview.CameraView$b */
    public class C11195b implements CameraEngine.g, OrientationHelper2.c, GestureFinder.a {

        /* renamed from: a */
        public final String f22140a;

        /* renamed from: b */
        public final CameraLogger f22141b;

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$a */
        public class a implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ float f22143j;

            /* renamed from: k */
            public final /* synthetic */ PointF[] f22144k;

            public a(float f, PointF[] pointFArr) {
                this.f22143j = f;
                this.f22144k = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$b */
        public class b implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ float f22146j;

            /* renamed from: k */
            public final /* synthetic */ float[] f22147k;

            /* renamed from: l */
            public final /* synthetic */ PointF[] f22148l;

            public b(float f, float[] fArr, PointF[] pointFArr) {
                this.f22146j = f;
                this.f22147k = fArr;
                this.f22148l = pointFArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$c */
        public class c implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ Frame2 f22150j;

            public c(Frame2 frame2) {
                this.f22150j = frame2;
            }

            @Override // java.lang.Runnable
            public void run() {
                C11195b.this.f22141b.m7159a(0, "dispatchFrame: executing. Passing", Long.valueOf(this.f22150j.m7383a()), "to processors.");
                Iterator<FrameProcessor> it = CameraView.this.f22114E.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().m7387a(this.f22150j);
                    } catch (Exception e) {
                        C11195b.this.f22141b.m7159a(2, "Frame processor crashed:", e);
                    }
                }
                this.f22150j.m7384b();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$d */
        public class d implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ CameraException f22152j;

            public d(CameraException cameraException) {
                this.f22152j = cameraException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    it.next().mo7156b(this.f22152j);
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$e */
        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView.this.requestLayout();
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$f */
        public class f implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ PointF f22155j;

            /* renamed from: k */
            public final /* synthetic */ Gesture f22156k;

            public f(PointF pointF, Gesture gesture) {
                this.f22155j = pointF;
                this.f22156k = gesture;
            }

            @Override // java.lang.Runnable
            public void run() {
                MarkerLayout markerLayout = CameraView.this.f22120K;
                PointF[] pointFArr = {this.f22155j};
                View view = markerLayout.f14139j.get(1);
                if (view != null) {
                    view.clearAnimation();
                    PointF pointF = pointFArr[0];
                    float width = (int) (pointF.x - (view.getWidth() / 2));
                    float height = (int) (pointF.y - (view.getHeight() / 2));
                    view.setTranslationX(width);
                    view.setTranslationY(height);
                }
                AutoFocusMarker autoFocusMarker = CameraView.this.f22112C;
                if (autoFocusMarker != null) {
                    autoFocusMarker.m7405a(this.f22156k != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.f22155j);
                }
                Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        /* renamed from: com.otaliastudios.cameraview.CameraView$b$g */
        public class g implements Runnable {

            /* renamed from: j */
            public final /* synthetic */ boolean f22158j;

            /* renamed from: k */
            public final /* synthetic */ Gesture f22159k;

            /* renamed from: l */
            public final /* synthetic */ PointF f22160l;

            public g(boolean z2, Gesture gesture, PointF pointF) {
                this.f22158j = z2;
                this.f22159k = gesture;
                this.f22160l = pointF;
            }

            @Override // java.lang.Runnable
            public void run() {
                CameraView cameraView;
                boolean z2;
                if (this.f22158j && (z2 = (cameraView = CameraView.this).f22124l) && z2) {
                    if (cameraView.f22111B == null) {
                        cameraView.f22111B = new MediaActionSound();
                    }
                    cameraView.f22111B.play(1);
                }
                AutoFocusMarker autoFocusMarker = CameraView.this.f22112C;
                if (autoFocusMarker != null) {
                    autoFocusMarker.m7407c(this.f22159k != null ? AutoFocusTrigger.GESTURE : AutoFocusTrigger.METHOD, this.f22158j, this.f22160l);
                }
                Iterator<CameraListener> it = CameraView.this.f22113D.iterator();
                while (it.hasNext()) {
                    Objects.requireNonNull(it.next());
                }
            }
        }

        public C11195b() {
            String simpleName = C11195b.class.getSimpleName();
            this.f22140a = simpleName;
            this.f22141b = new CameraLogger(simpleName);
        }

        /* renamed from: a */
        public void m9311a(CameraException cameraException) {
            this.f22141b.m7159a(1, "dispatchError", cameraException);
            CameraView.this.f22133u.post(new d(cameraException));
        }

        /* renamed from: b */
        public void m9312b(@NonNull Frame2 frame2) {
            this.f22141b.m7159a(0, "dispatchFrame:", Long.valueOf(frame2.m7383a()), "processors:", Integer.valueOf(CameraView.this.f22114E.size()));
            if (CameraView.this.f22114E.isEmpty()) {
                frame2.m7384b();
            } else {
                CameraView.this.f22134v.execute(new c(frame2));
            }
        }

        /* renamed from: c */
        public void m9313c(float f2, @NonNull float[] fArr, @Nullable PointF[] pointFArr) {
            this.f22141b.m7159a(1, "dispatchOnExposureCorrectionChanged", Float.valueOf(f2));
            CameraView.this.f22133u.post(new b(f2, fArr, pointFArr));
        }

        /* renamed from: d */
        public void m9314d(@Nullable Gesture gesture, boolean z2, @NonNull PointF pointF) {
            this.f22141b.m7159a(1, "dispatchOnFocusEnd", gesture, Boolean.valueOf(z2), pointF);
            CameraView.this.f22133u.post(new g(z2, gesture, pointF));
        }

        /* renamed from: e */
        public void m9315e(@Nullable Gesture gesture, @NonNull PointF pointF) {
            this.f22141b.m7159a(1, "dispatchOnFocusStart", gesture, pointF);
            CameraView.this.f22133u.post(new f(pointF, gesture));
        }

        /* renamed from: f */
        public void m9316f(float f2, @Nullable PointF[] pointFArr) {
            this.f22141b.m7159a(1, "dispatchOnZoomChanged", Float.valueOf(f2));
            CameraView.this.f22133u.post(new a(f2, pointFArr));
        }

        @NonNull
        /* renamed from: g */
        public Context m9317g() {
            return CameraView.this.getContext();
        }

        /* renamed from: h */
        public void m9318h() {
            Size3 size3Mo7254C = CameraView.this.f22138z.mo7254C(Reference2.VIEW);
            if (size3Mo7254C == null) {
                throw new RuntimeException("Preview stream size should not be null here.");
            }
            if (size3Mo7254C.equals(CameraView.this.f22110A)) {
                this.f22141b.m7159a(1, "onCameraPreviewStreamSizeChanged:", "swallowing because the preview size has not changed.", size3Mo7254C);
            } else {
                this.f22141b.m7159a(1, "onCameraPreviewStreamSizeChanged: posting a requestLayout call.", "Preview stream size:", size3Mo7254C);
                CameraView.this.f22133u.post(new e());
            }
        }
    }

    static {
        String simpleName = CameraView.class.getSimpleName();
        f22108j = simpleName;
        f22109k = new CameraLogger(simpleName);
    }

    public CameraView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        int i3;
        int i4;
        SizeSelector sizeSelector;
        Filter2 noFilter;
        super(context, attributeSet);
        this.f22127o = new HashMap<>(4);
        this.f22113D = new CopyOnWriteArrayList();
        this.f22114E = new CopyOnWriteArrayList();
        boolean zIsInEditMode = isInEditMode();
        this.f22122M = zIsInEditMode;
        if (zIsInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11196R.c.CameraView, 0, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraPreview, Preview.GL_SURFACE.m7185g());
        int i5 = C11196R.c.CameraView_cameraFacing;
        Facing facing = Facing.BACK;
        if (!CameraUtils2.m7164a(facing)) {
            Facing facing2 = Facing.FRONT;
            if (CameraUtils2.m7164a(facing2)) {
                facing = facing2;
            }
        }
        int integer2 = typedArrayObtainStyledAttributes.getInteger(i5, facing.m7173g());
        int integer3 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFlash, Flash.OFF.m7175g());
        int integer4 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGrid, Grid.OFF.m7177g());
        int integer5 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraWhiteBalance, WhiteBalance.AUTO.m7189g());
        int integer6 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraMode, Mode3.PICTURE.m7181g());
        int integer7 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraHdr, Hdr.OFF.m7179g());
        int integer8 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudio, Audio.ON.m7167g());
        int integer9 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoCodec, VideoCodec.DEVICE_DEFAULT.m7187g());
        int integer10 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudioCodec, AudioCodec.DEVICE_DEFAULT.m7169g());
        int integer11 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraEngine, Engine.CAMERA1.m7171g());
        int integer12 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraPictureFormat, PictureFormat.JPEG.m7183g());
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPlaySounds, true);
        boolean z3 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraUseDeviceOrientation, true);
        this.f22121L = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraExperimental, false);
        this.f22126n = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraRequestPermissions, true);
        this.f22128p = Preview.m7184f(integer);
        this.f22129q = Engine.m7170f(integer11);
        int color = typedArrayObtainStyledAttributes.getColor(C11196R.c.CameraView_cameraGridColor, GridLinesLayout.f14110j);
        long j = (long) typedArrayObtainStyledAttributes.getFloat(C11196R.c.CameraView_cameraVideoMaxSize, 0.0f);
        int integer13 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoMaxDuration, 0);
        int integer14 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraVideoBitRate, 0);
        int integer15 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAudioBitRate, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(C11196R.c.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPreviewFrameRateExact, false);
        long integer16 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraAutoFocusResetDelay, PathInterpolatorCompat.MAX_NUM_POINTS);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureMetering, true);
        boolean z6 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSnapshotMetering, false);
        int integer17 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraSnapshotMaxWidth, 0);
        int integer18 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraSnapshotMaxHeight, 0);
        int integer19 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer20 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer21 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingFormat, 0);
        int integer22 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer23 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraFrameProcessingExecutors, 1);
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraDrawHardwareOverlays, false);
        ArrayList arrayList = new ArrayList(3);
        int i6 = C11196R.c.CameraView_cameraPictureSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            i = integer8;
            i2 = 0;
            arrayList.add(C3404f.m4229N0(typedArrayObtainStyledAttributes.getInteger(i6, 0)));
        } else {
            i = integer8;
            i2 = 0;
        }
        int i7 = C11196R.c.CameraView_cameraPictureSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i7)) {
            arrayList.add(C3404f.m4223L0(typedArrayObtainStyledAttributes.getInteger(i7, i2)));
        }
        int i8 = C11196R.c.CameraView_cameraPictureSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i8)) {
            arrayList.add(C3404f.m4226M0(typedArrayObtainStyledAttributes.getInteger(i8, i2)));
        }
        int i9 = C11196R.c.CameraView_cameraPictureSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i9)) {
            arrayList.add(C3404f.m4220K0(typedArrayObtainStyledAttributes.getInteger(i9, i2)));
        }
        int i10 = C11196R.c.CameraView_cameraPictureSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            arrayList.add(C3404f.m4200D1(new SizeSelectors5(typedArrayObtainStyledAttributes.getInteger(i10, i2))));
        }
        int i11 = C11196R.c.CameraView_cameraPictureSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            arrayList.add(C3404f.m4200D1(new SizeSelectors4(typedArrayObtainStyledAttributes.getInteger(i11, 0))));
        }
        int i12 = C11196R.c.CameraView_cameraPictureSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i12)) {
            i3 = integer7;
            arrayList.add(C3404f.m4200D1(new SizeSelectors(AspectRatio2.m7449h(typedArrayObtainStyledAttributes.getString(i12)).m7450i(), 0.0f)));
        } else {
            i3 = integer7;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(new SizeSelectors3());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(new SizeSelectors2());
        }
        SizeSelector sizeSelectorM4291g = !arrayList.isEmpty() ? C3404f.m4291g((SizeSelector[]) arrayList.toArray(new SizeSelector[0])) : new SizeSelectors2();
        ArrayList arrayList2 = new ArrayList(3);
        int i13 = C11196R.c.CameraView_cameraVideoSizeMinWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i13)) {
            i4 = 0;
            arrayList2.add(C3404f.m4229N0(typedArrayObtainStyledAttributes.getInteger(i13, 0)));
        } else {
            i4 = 0;
        }
        int i14 = C11196R.c.CameraView_cameraVideoSizeMaxWidth;
        if (typedArrayObtainStyledAttributes.hasValue(i14)) {
            arrayList2.add(C3404f.m4223L0(typedArrayObtainStyledAttributes.getInteger(i14, i4)));
        }
        int i15 = C11196R.c.CameraView_cameraVideoSizeMinHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i15)) {
            arrayList2.add(C3404f.m4226M0(typedArrayObtainStyledAttributes.getInteger(i15, i4)));
        }
        int i16 = C11196R.c.CameraView_cameraVideoSizeMaxHeight;
        if (typedArrayObtainStyledAttributes.hasValue(i16)) {
            arrayList2.add(C3404f.m4220K0(typedArrayObtainStyledAttributes.getInteger(i16, i4)));
        }
        int i17 = C11196R.c.CameraView_cameraVideoSizeMinArea;
        if (typedArrayObtainStyledAttributes.hasValue(i17)) {
            arrayList2.add(C3404f.m4200D1(new SizeSelectors5(typedArrayObtainStyledAttributes.getInteger(i17, i4))));
        }
        int i18 = C11196R.c.CameraView_cameraVideoSizeMaxArea;
        if (typedArrayObtainStyledAttributes.hasValue(i18)) {
            arrayList2.add(C3404f.m4200D1(new SizeSelectors4(typedArrayObtainStyledAttributes.getInteger(i18, 0))));
        }
        int i19 = C11196R.c.CameraView_cameraVideoSizeAspectRatio;
        if (typedArrayObtainStyledAttributes.hasValue(i19)) {
            sizeSelector = sizeSelectorM4291g;
            arrayList2.add(C3404f.m4200D1(new SizeSelectors(AspectRatio2.m7449h(typedArrayObtainStyledAttributes.getString(i19)).m7450i(), 0.0f)));
        } else {
            sizeSelector = sizeSelectorM4291g;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(new SizeSelectors3());
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C11196R.c.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(new SizeSelectors2());
        }
        SizeSelector sizeSelectorM4291g2 = !arrayList2.isEmpty() ? C3404f.m4291g((SizeSelector[]) arrayList2.toArray(new SizeSelector[0])) : new SizeSelectors2();
        int i20 = C11196R.c.CameraView_cameraGestureTap;
        GestureAction gestureAction = GestureAction.f14072j;
        int integer24 = typedArrayObtainStyledAttributes.getInteger(i20, gestureAction.m7391h());
        int integer25 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureLongTap, gestureAction.m7391h());
        int integer26 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGesturePinch, gestureAction.m7391h());
        int integer27 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureScrollHorizontal, gestureAction.m7391h());
        int integer28 = typedArrayObtainStyledAttributes.getInteger(C11196R.c.CameraView_cameraGestureScrollVertical, gestureAction.m7391h());
        String string = typedArrayObtainStyledAttributes.getString(C11196R.c.CameraView_cameraAutoFocusMarker);
        AutoFocusMarker autoFocusMarker = null;
        if (string != null) {
            try {
                autoFocusMarker = (AutoFocusMarker) Class.forName(string).newInstance();
            } catch (Exception unused) {
            }
        }
        try {
            noFilter = (Filter2) Class.forName(typedArrayObtainStyledAttributes.getString(C11196R.c.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused2) {
            noFilter = new NoFilter();
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f22135w = new C11195b();
        this.f22133u = new Handler(Looper.getMainLooper());
        this.f22116G = new PinchGestureFinder(this.f22135w);
        this.f22117H = new TapGestureFinder(this.f22135w);
        this.f22118I = new ScrollGestureFinder(this.f22135w);
        this.f22119J = new GridLinesLayout(context);
        this.f22123N = new OverlayLayout(context);
        this.f22120K = new MarkerLayout(context);
        addView(this.f22119J);
        addView(this.f22120K);
        addView(this.f22123N);
        m9305b();
        setPlaySounds(z2);
        setUseDeviceOrientation(z3);
        setGrid(Grid.m7176f(integer4));
        setGridColor(color);
        setDrawHardwareOverlays(z7);
        setFacing(Facing.m7172f(integer2));
        setFlash(Flash.m7174f(integer3));
        setMode(Mode3.m7180f(integer6));
        setWhiteBalance(WhiteBalance.m7188f(integer5));
        setHdr(Hdr.m7178f(i3));
        setAudio(Audio.m7166f(i));
        setAudioBitRate(integer15);
        setAudioCodec(AudioCodec.m7168f(integer10));
        setPictureSize(sizeSelector);
        setPictureMetering(z5);
        setPictureSnapshotMetering(z6);
        setPictureFormat(PictureFormat.m7182f(integer12));
        setVideoSize(sizeSelectorM4291g2);
        setVideoCodec(VideoCodec.m7186f(integer9));
        setVideoMaxSize(j);
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
        m9308e(Gesture.f14067k, GestureAction.m7389f(integer24));
        m9308e(Gesture.f14068l, GestureAction.m7389f(integer25));
        m9308e(Gesture.f14066j, GestureAction.m7389f(integer26));
        m9308e(Gesture.f14069m, GestureAction.m7389f(integer27));
        m9308e(Gesture.f14070n, GestureAction.m7389f(integer28));
        setAutoFocusMarker(autoFocusMarker);
        setFilter(noFilter);
        this.f22137y = new OrientationHelper2(context, this.f22135w);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public boolean m9304a(@NonNull Audio audio) {
        Audio audio2 = Audio.STEREO;
        Audio audio3 = Audio.MONO;
        Audio audio4 = Audio.ON;
        if (audio == audio4 || audio == audio3 || audio == audio2) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (!str.equals("android.permission.RECORD_AUDIO")) {
                    }
                }
                throw new IllegalStateException(f22109k.m7159a(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z2 = audio == audio4 || audio == audio3 || audio == audio2;
        boolean z3 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z4 = z2 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z3 && !z4) {
            return true;
        }
        if (this.f22126n) {
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
        if (!this.f22122M) {
            Objects.requireNonNull(this.f22123N);
            if (layoutParams instanceof OverlayLayout.a) {
                this.f22123N.addView(view, layoutParams);
                return;
            }
        }
        super.addView(view, i, layoutParams);
    }

    /* renamed from: b */
    public final void m9305b() {
        CameraEngine camera1Engine2;
        CameraLogger cameraLogger = f22109k;
        cameraLogger.m7159a(2, "doInstantiateEngine:", "instantiating. engine:", this.f22129q);
        Engine engine = this.f22129q;
        C11195b c11195b = this.f22135w;
        if (this.f22121L && engine == Engine.CAMERA2) {
            camera1Engine2 = new Camera2Engine(c11195b);
        } else {
            this.f22129q = Engine.CAMERA1;
            camera1Engine2 = new Camera1Engine2(c11195b);
        }
        this.f22138z = camera1Engine2;
        cameraLogger.m7159a(2, "doInstantiateEngine:", "instantiated. engine:", camera1Engine2.getClass().getSimpleName());
        this.f22138z.mo7297o0(this.f22123N);
    }

    /* renamed from: c */
    public final boolean m9306c() {
        CameraEngine cameraEngine = this.f22138z;
        return cameraEngine.f13922n.f14028f == CameraState2.OFF && !cameraEngine.m7324O();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void close() {
        if (this.f22122M) {
            return;
        }
        OrientationHelper2 orientationHelper2 = this.f22137y;
        if (orientationHelper2.f14124h) {
            orientationHelper2.f14124h = false;
            orientationHelper2.f14120d.disable();
            ((DisplayManager) orientationHelper2.f14118b.getSystemService("display")).unregisterDisplayListener(orientationHelper2.f14122f);
            orientationHelper2.f14123g = -1;
            orientationHelper2.f14121e = -1;
        }
        this.f22138z.m7321L0(false);
        CameraPreview cameraPreview = this.f22136x;
        if (cameraPreview != null) {
            cameraPreview.mo7436p();
        }
    }

    /* renamed from: d */
    public boolean m9307d() {
        CameraState2 cameraState2 = this.f22138z.f13922n.f14028f;
        CameraState2 cameraState22 = CameraState2.ENGINE;
        return cameraState2.m7367f(cameraState22) && this.f22138z.f13922n.f14029g.m7367f(cameraState22);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void destroy() {
        if (this.f22122M) {
            return;
        }
        this.f22113D.clear();
        boolean z2 = this.f22114E.size() > 0;
        this.f22114E.clear();
        if (z2) {
            this.f22138z.mo7217k0(false);
        }
        this.f22138z.m7329d(true, 0);
        CameraPreview cameraPreview = this.f22136x;
        if (cameraPreview != null) {
            cameraPreview.mo7435o();
        }
    }

    /* renamed from: e */
    public boolean m9308e(@NonNull Gesture gesture, @NonNull GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.f14072j;
        if (!gesture.m7388f(gestureAction)) {
            m9308e(gesture, gestureAction2);
            return false;
        }
        this.f22127o.put(gesture, gestureAction);
        int iOrdinal = gesture.ordinal();
        if (iOrdinal == 0) {
            this.f22116G.f14081a = this.f22127o.get(Gesture.f14066j) != gestureAction2;
        } else if (iOrdinal == 1 || iOrdinal == 2) {
            this.f22117H.f14081a = (this.f22127o.get(Gesture.f14067k) == gestureAction2 && this.f22127o.get(Gesture.f14068l) == gestureAction2) ? false : true;
        } else if (iOrdinal == 3 || iOrdinal == 4) {
            this.f22118I.f14081a = (this.f22127o.get(Gesture.f14069m) == gestureAction2 && this.f22127o.get(Gesture.f14070n) == gestureAction2) ? false : true;
        }
        this.f22132t = 0;
        Iterator<GestureAction> it = this.f22127o.values().iterator();
        while (it.hasNext()) {
            this.f22132t += it.next() == gestureAction2 ? 0 : 1;
        }
        return true;
    }

    /* renamed from: f */
    public final String m9309f(int i) {
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

    /* renamed from: g */
    public final void m9310g(@NonNull GestureFinder gestureFinder, @NonNull CameraOptions cameraOptions) {
        Gesture gesture = gestureFinder.f14082b;
        GestureAction gestureAction = this.f22127o.get(gesture);
        PointF[] pointFArr = gestureFinder.f14083c;
        switch (gestureAction.ordinal()) {
            case 1:
                float width = getWidth();
                float height = getHeight();
                RectF rectFM7409a = MeteringRegions.m7409a(pointFArr[0], width * 0.05f, 0.05f * height);
                ArrayList<MeteringRegion> arrayList = new ArrayList();
                PointF pointF = new PointF(rectFM7409a.centerX(), rectFM7409a.centerY());
                float fWidth = rectFM7409a.width();
                float fHeight = rectFM7409a.height();
                arrayList.add(new MeteringRegion(rectFM7409a, 1000));
                arrayList.add(new MeteringRegion(MeteringRegions.m7409a(pointF, fWidth * 1.5f, fHeight * 1.5f), Math.round(1000 * 0.1f)));
                ArrayList arrayList2 = new ArrayList();
                for (MeteringRegion meteringRegion : arrayList) {
                    Objects.requireNonNull(meteringRegion);
                    RectF rectF = new RectF(0.0f, 0.0f, width, height);
                    RectF rectF2 = new RectF();
                    rectF2.set(Math.max(rectF.left, meteringRegion.f14140j.left), Math.max(rectF.top, meteringRegion.f14140j.top), Math.min(rectF.right, meteringRegion.f14140j.right), Math.min(rectF.bottom, meteringRegion.f14140j.bottom));
                    arrayList2.add(new MeteringRegion(rectF2, meteringRegion.f14141k));
                }
                this.f22138z.mo7192I0(gesture, new MeteringRegions(arrayList2), pointFArr[0]);
                break;
            case 2:
                this.f22138z.mo7269O0(new PictureResult.a());
                break;
            case 3:
                this.f22138z.mo7270P0(new PictureResult.a());
                break;
            case 4:
                float fMo7268N = this.f22138z.mo7268N();
                float fM7392a = gestureFinder.m7392a(fMo7268N, 0.0f, 1.0f);
                if (fM7392a != fMo7268N) {
                    this.f22138z.mo7191G0(fM7392a, pointFArr, true);
                }
                break;
            case 5:
                float fMo7291k = this.f22138z.mo7291k();
                float f = cameraOptions.f13694m;
                float f2 = cameraOptions.f13695n;
                float fM7392a2 = gestureFinder.m7392a(fMo7291k, f, f2);
                if (fM7392a2 != fMo7291k) {
                    this.f22138z.mo7207d0(fM7392a2, new float[]{f, f2}, pointFArr, true);
                }
                break;
            case 6:
                if (getFilter() instanceof OneParameterFilter) {
                    OneParameterFilter oneParameterFilter = (OneParameterFilter) getFilter();
                    float fM7377i = oneParameterFilter.m7377i();
                    float fM7392a3 = gestureFinder.m7392a(fM7377i, 0.0f, 1.0f);
                    if (fM7392a3 != fM7377i) {
                        oneParameterFilter.m7376d(fM7392a3);
                    }
                }
                break;
            case 7:
                if (getFilter() instanceof TwoParameterFilter) {
                    TwoParameterFilter twoParameterFilter = (TwoParameterFilter) getFilter();
                    float fM7379g = twoParameterFilter.m7379g();
                    float fM7392a4 = gestureFinder.m7392a(fM7379g, 0.0f, 1.0f);
                    if (fM7392a4 != fM7379g) {
                        twoParameterFilter.m7378b(fM7392a4);
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
    public Audio getAudio() {
        return this.f22138z.mo7283f();
    }

    public int getAudioBitRate() {
        return this.f22138z.mo7284g();
    }

    @NonNull
    public AudioCodec getAudioCodec() {
        return this.f22138z.mo7285h();
    }

    public long getAutoFocusResetDelay() {
        return this.f22138z.mo7287i();
    }

    @Nullable
    public CameraOptions getCameraOptions() {
        return this.f22138z.mo7289j();
    }

    public boolean getDrawHardwareOverlays() {
        return this.f22123N.getHardwareCanvasEnabled();
    }

    @NonNull
    public Engine getEngine() {
        return this.f22129q;
    }

    public float getExposureCorrection() {
        return this.f22138z.mo7291k();
    }

    @NonNull
    public Facing getFacing() {
        return this.f22138z.mo7292l();
    }

    @NonNull
    public Filter2 getFilter() {
        Object obj = this.f22136x;
        if (obj == null) {
            return this.f22130r;
        }
        if (obj instanceof FilterCameraPreview) {
            return ((FilterCameraPreview) obj).mo7444c();
        }
        StringBuilder sbM833U = outline.m833U("Filters are only supported by the GL_SURFACE preview. Current:");
        sbM833U.append(this.f22128p);
        throw new RuntimeException(sbM833U.toString());
    }

    @NonNull
    public Flash getFlash() {
        return this.f22138z.mo7293m();
    }

    public int getFrameProcessingExecutors() {
        return this.f22131s;
    }

    public int getFrameProcessingFormat() {
        return this.f22138z.mo7294n();
    }

    public int getFrameProcessingMaxHeight() {
        return this.f22138z.mo7296o();
    }

    public int getFrameProcessingMaxWidth() {
        return this.f22138z.mo7298p();
    }

    public int getFrameProcessingPoolSize() {
        return this.f22138z.mo7299q();
    }

    @NonNull
    public Grid getGrid() {
        return this.f22119J.getGridMode();
    }

    public int getGridColor() {
        return this.f22119J.getGridColor();
    }

    @NonNull
    public Hdr getHdr() {
        return this.f22138z.mo7301r();
    }

    @Nullable
    public Location getLocation() {
        return this.f22138z.mo7303s();
    }

    @NonNull
    public Mode3 getMode() {
        return this.f22138z.mo7305t();
    }

    @NonNull
    public PictureFormat getPictureFormat() {
        return this.f22138z.mo7306u();
    }

    public boolean getPictureMetering() {
        return this.f22138z.mo7308v();
    }

    @Nullable
    public Size3 getPictureSize() {
        return this.f22138z.mo7309w(Reference2.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.f22138z.mo7313y();
    }

    public boolean getPlaySounds() {
        return this.f22124l;
    }

    @NonNull
    public Preview getPreview() {
        return this.f22128p;
    }

    public float getPreviewFrameRate() {
        return this.f22138z.mo7250A();
    }

    public boolean getPreviewFrameRateExact() {
        return this.f22138z.mo7252B();
    }

    public int getSnapshotMaxHeight() {
        return this.f22138z.mo7256D();
    }

    public int getSnapshotMaxWidth() {
        return this.f22138z.mo7258E();
    }

    @Nullable
    public Size3 getSnapshotSize() {
        Size3 size3 = null;
        if (getWidth() != 0 && getHeight() != 0) {
            CameraEngine cameraEngine = this.f22138z;
            Reference2 reference2 = Reference2.VIEW;
            Size3 size3Mo7260F = cameraEngine.mo7260F(reference2);
            if (size3Mo7260F == null) {
                return null;
            }
            Rect rectM4222L = C3404f.m4222L(size3Mo7260F, AspectRatio2.m7447f(getWidth(), getHeight()));
            size3 = new Size3(rectM4222L.width(), rectM4222L.height());
            if (this.f22138z.mo7281e().m7357b(reference2, Reference2.OUTPUT)) {
                return size3.m7451f();
            }
        }
        return size3;
    }

    public boolean getUseDeviceOrientation() {
        return this.f22125m;
    }

    public int getVideoBitRate() {
        return this.f22138z.mo7261G();
    }

    @NonNull
    public VideoCodec getVideoCodec() {
        return this.f22138z.mo7262H();
    }

    public int getVideoMaxDuration() {
        return this.f22138z.mo7263I();
    }

    public long getVideoMaxSize() {
        return this.f22138z.mo7264J();
    }

    @Nullable
    public Size3 getVideoSize() {
        return this.f22138z.mo7265K(Reference2.OUTPUT);
    }

    @NonNull
    public WhiteBalance getWhiteBalance() {
        return this.f22138z.mo7267M();
    }

    public float getZoom() {
        return this.f22138z.mo7268N();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        CameraPreview surfaceCameraPreview2;
        super.onAttachedToWindow();
        if (!this.f22122M && this.f22136x == null) {
            CameraLogger cameraLogger = f22109k;
            cameraLogger.m7159a(2, "doInstantiateEngine:", "instantiating. preview:", this.f22128p);
            Preview preview = this.f22128p;
            Context context = getContext();
            int iOrdinal = preview.ordinal();
            if (iOrdinal == 0) {
                surfaceCameraPreview2 = new SurfaceCameraPreview2(context, this);
            } else if (iOrdinal == 1 && isHardwareAccelerated()) {
                surfaceCameraPreview2 = new TextureCameraPreview2(context, this);
            } else {
                this.f22128p = Preview.GL_SURFACE;
                surfaceCameraPreview2 = new GlCameraPreview2(context, this);
            }
            this.f22136x = surfaceCameraPreview2;
            cameraLogger.m7159a(2, "doInstantiateEngine:", "instantiated. preview:", surfaceCameraPreview2.getClass().getSimpleName());
            this.f22138z.mo7307u0(this.f22136x);
            Filter2 filter2 = this.f22130r;
            if (filter2 != null) {
                setFilter(filter2);
                this.f22130r = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f22110A = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f22132t > 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f22122M) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), BasicMeasure.EXACTLY));
            return;
        }
        Size3 size3Mo7254C = this.f22138z.mo7254C(Reference2.VIEW);
        this.f22110A = size3Mo7254C;
        if (size3Mo7254C == null) {
            f22109k.m7159a(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        Size3 size3 = this.f22110A;
        float f = size3.f14251j;
        float f2 = size3.f14252k;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f22136x.mo7441u()) {
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
        CameraLogger cameraLogger = f22109k;
        StringBuilder sbM834V = outline.m834V("requested dimensions are (", size, "[");
        sbM834V.append(m9309f(mode));
        sbM834V.append("]x");
        sbM834V.append(size2);
        sbM834V.append("[");
        sbM834V.append(m9309f(mode2));
        sbM834V.append("])");
        cameraLogger.m7159a(1, "onMeasure:", sbM834V.toString());
        cameraLogger.m7159a(1, "onMeasure:", "previewSize is", "(" + f + "x" + f2 + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            cameraLogger.m7159a(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", "(" + size + "x" + size2 + ")");
            super.onMeasure(i, i2);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            cameraLogger.m7159a(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f + "x" + f2 + ")");
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
            cameraLogger.m7159a(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", "(" + size + "x" + size2 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(Math.round(size2 / f3), size);
            } else {
                size2 = Math.min(Math.round(size * f3), size2);
            }
            cameraLogger.m7159a(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", "(" + size + "x" + size2 + ")");
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
        cameraLogger.m7159a(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", "(" + size + "x" + size2 + ")");
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(size2, BasicMeasure.EXACTLY));
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m9307d()) {
            return true;
        }
        CameraOptions cameraOptionsMo7289j = this.f22138z.mo7289j();
        if (cameraOptionsMo7289j == null) {
            throw new IllegalStateException("Options should not be null here.");
        }
        PinchGestureFinder pinchGestureFinder = this.f22116G;
        if (!pinchGestureFinder.f14081a ? false : pinchGestureFinder.m7394c(motionEvent)) {
            f22109k.m7159a(1, "onTouchEvent", "pinch!");
            m9310g(this.f22116G, cameraOptionsMo7289j);
        } else {
            ScrollGestureFinder scrollGestureFinder = this.f22118I;
            if (!scrollGestureFinder.f14081a ? false : scrollGestureFinder.m7395c(motionEvent)) {
                f22109k.m7159a(1, "onTouchEvent", "scroll!");
                m9310g(this.f22118I, cameraOptionsMo7289j);
            } else {
                TapGestureFinder tapGestureFinder = this.f22117H;
                if (!tapGestureFinder.f14081a ? false : tapGestureFinder.m7396c(motionEvent)) {
                    f22109k.m7159a(1, "onTouchEvent", "tap!");
                    m9310g(this.f22117H, cameraOptionsMo7289j);
                }
            }
        }
        return true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void open() {
        if (this.f22122M) {
            return;
        }
        CameraPreview cameraPreview = this.f22136x;
        if (cameraPreview != null) {
            cameraPreview.mo7437q();
        }
        if (m9304a(getAudio())) {
            OrientationHelper2 orientationHelper2 = this.f22137y;
            if (!orientationHelper2.f14124h) {
                orientationHelper2.f14124h = true;
                orientationHelper2.f14123g = orientationHelper2.m7401a();
                ((DisplayManager) orientationHelper2.f14118b.getSystemService("display")).registerDisplayListener(orientationHelper2.f14122f, orientationHelper2.f14117a);
                orientationHelper2.f14120d.enable();
            }
            Angles anglesMo7281e = this.f22138z.mo7281e();
            int i = this.f22137y.f14123g;
            anglesMo7281e.m7360e(i);
            anglesMo7281e.f13998d = i;
            anglesMo7281e.m7359d();
            this.f22138z.m7318H0();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.f22122M && layoutParams != null) {
            Objects.requireNonNull(this.f22123N);
            if (layoutParams instanceof OverlayLayout.a) {
                this.f22123N.removeView(view);
                return;
            }
        }
        super.removeView(view);
    }

    public void set(@NonNull Control control) {
        if (control instanceof Audio) {
            setAudio((Audio) control);
            return;
        }
        if (control instanceof Facing) {
            setFacing((Facing) control);
            return;
        }
        if (control instanceof Flash) {
            setFlash((Flash) control);
            return;
        }
        if (control instanceof Grid) {
            setGrid((Grid) control);
            return;
        }
        if (control instanceof Hdr) {
            setHdr((Hdr) control);
            return;
        }
        if (control instanceof Mode3) {
            setMode((Mode3) control);
            return;
        }
        if (control instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) control);
            return;
        }
        if (control instanceof VideoCodec) {
            setVideoCodec((VideoCodec) control);
            return;
        }
        if (control instanceof AudioCodec) {
            setAudioCodec((AudioCodec) control);
            return;
        }
        if (control instanceof Preview) {
            setPreview((Preview) control);
        } else if (control instanceof Engine) {
            setEngine((Engine) control);
        } else if (control instanceof PictureFormat) {
            setPictureFormat((PictureFormat) control);
        }
    }

    public void setAudio(@NonNull Audio audio) {
        if (audio == getAudio() || m9306c()) {
            this.f22138z.mo7276Z(audio);
        } else if (m9304a(audio)) {
            this.f22138z.mo7276Z(audio);
        } else {
            close();
        }
    }

    public void setAudioBitRate(int i) {
        this.f22138z.mo7277a0(i);
    }

    public void setAudioCodec(@NonNull AudioCodec audioCodec) {
        this.f22138z.mo7279b0(audioCodec);
    }

    public void setAutoFocusMarker(@Nullable AutoFocusMarker autoFocusMarker) {
        View viewM7406b;
        this.f22112C = autoFocusMarker;
        MarkerLayout markerLayout = this.f22120K;
        View view = markerLayout.f14139j.get(1);
        if (view != null) {
            markerLayout.removeView(view);
        }
        if (autoFocusMarker == null || (viewM7406b = autoFocusMarker.m7406b(markerLayout.getContext(), markerLayout)) == null) {
            return;
        }
        markerLayout.f14139j.put(1, viewM7406b);
        markerLayout.addView(viewM7406b);
    }

    public void setAutoFocusResetDelay(long j) {
        this.f22138z.mo7280c0(j);
    }

    public void setDrawHardwareOverlays(boolean z2) {
        this.f22123N.setHardwareCanvasEnabled(z2);
    }

    public void setEngine(@NonNull Engine engine) {
        if (m9306c()) {
            this.f22129q = engine;
            CameraEngine cameraEngine = this.f22138z;
            m9305b();
            CameraPreview cameraPreview = this.f22136x;
            if (cameraPreview != null) {
                this.f22138z.mo7307u0(cameraPreview);
            }
            setFacing(cameraEngine.mo7292l());
            setFlash(cameraEngine.mo7293m());
            setMode(cameraEngine.mo7305t());
            setWhiteBalance(cameraEngine.mo7267M());
            setHdr(cameraEngine.mo7301r());
            setAudio(cameraEngine.mo7283f());
            setAudioBitRate(cameraEngine.mo7284g());
            setAudioCodec(cameraEngine.mo7285h());
            setPictureSize(cameraEngine.mo7311x());
            setPictureFormat(cameraEngine.mo7306u());
            setVideoSize(cameraEngine.mo7266L());
            setVideoCodec(cameraEngine.mo7262H());
            setVideoMaxSize(cameraEngine.mo7264J());
            setVideoMaxDuration(cameraEngine.mo7263I());
            setVideoBitRate(cameraEngine.mo7261G());
            setAutoFocusResetDelay(cameraEngine.mo7287i());
            setPreviewFrameRate(cameraEngine.mo7250A());
            setPreviewFrameRateExact(cameraEngine.mo7252B());
            setSnapshotMaxWidth(cameraEngine.mo7258E());
            setSnapshotMaxHeight(cameraEngine.mo7256D());
            setFrameProcessingMaxWidth(cameraEngine.mo7298p());
            setFrameProcessingMaxHeight(cameraEngine.mo7296o());
            setFrameProcessingFormat(0);
            setFrameProcessingPoolSize(cameraEngine.mo7299q());
            this.f22138z.mo7217k0(!this.f22114E.isEmpty());
        }
    }

    public void setExperimental(boolean z2) {
        this.f22121L = z2;
    }

    public void setExposureCorrection(float f) {
        CameraOptions cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f2 = cameraOptions.f13694m;
            float f3 = cameraOptions.f13695n;
            if (f < f2) {
                f = f2;
            }
            if (f > f3) {
                f = f3;
            }
            this.f22138z.mo7207d0(f, new float[]{f2, f3}, null, false);
        }
    }

    public void setFacing(@NonNull Facing facing) {
        this.f22138z.mo7282e0(facing);
    }

    public void setFilter(@NonNull Filter2 filter2) {
        Object obj = this.f22136x;
        if (obj == null) {
            this.f22130r = filter2;
            return;
        }
        boolean z2 = obj instanceof FilterCameraPreview;
        if (!(filter2 instanceof NoFilter) && !z2) {
            StringBuilder sbM833U = outline.m833U("Filters are only supported by the GL_SURFACE preview. Current preview:");
            sbM833U.append(this.f22128p);
            throw new RuntimeException(sbM833U.toString());
        }
        if (z2) {
            ((FilterCameraPreview) obj).mo7443a(filter2);
        }
    }

    public void setFlash(@NonNull Flash flash) {
        this.f22138z.mo7210f0(flash);
    }

    public void setFrameProcessingExecutors(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(outline.m871q("Need at least 1 executor, got ", i));
        }
        this.f22131s = i;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC11194a(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f22134v = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i) {
        this.f22138z.mo7212g0(i);
    }

    public void setFrameProcessingMaxHeight(int i) {
        this.f22138z.mo7286h0(i);
    }

    public void setFrameProcessingMaxWidth(int i) {
        this.f22138z.mo7288i0(i);
    }

    public void setFrameProcessingPoolSize(int i) {
        this.f22138z.mo7290j0(i);
    }

    public void setGrid(@NonNull Grid grid) {
        this.f22119J.setGridMode(grid);
    }

    public void setGridColor(@ColorInt int i) {
        this.f22119J.setGridColor(i);
    }

    public void setHdr(@NonNull Hdr hdr) {
        this.f22138z.mo7219l0(hdr);
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner == null) {
            Lifecycle lifecycle = this.f22115F;
            if (lifecycle != null) {
                lifecycle.removeObserver(this);
                this.f22115F = null;
                return;
            }
            return;
        }
        Lifecycle lifecycle2 = this.f22115F;
        if (lifecycle2 != null) {
            lifecycle2.removeObserver(this);
            this.f22115F = null;
        }
        Lifecycle lifecycle3 = lifecycleOwner.getLifecycle();
        this.f22115F = lifecycle3;
        lifecycle3.addObserver(this);
    }

    public void setLocation(@Nullable Location location) {
        this.f22138z.mo7221m0(location);
    }

    public void setMode(@NonNull Mode3 mode3) {
        this.f22138z.mo7295n0(mode3);
    }

    public void setPictureFormat(@NonNull PictureFormat pictureFormat) {
        this.f22138z.mo7223p0(pictureFormat);
    }

    public void setPictureMetering(boolean z2) {
        this.f22138z.mo7300q0(z2);
    }

    public void setPictureSize(@NonNull SizeSelector sizeSelector) {
        this.f22138z.mo7302r0(sizeSelector);
    }

    public void setPictureSnapshotMetering(boolean z2) {
        this.f22138z.mo7304s0(z2);
    }

    public void setPlaySounds(boolean z2) {
        this.f22124l = z2;
        this.f22138z.mo7224t0(z2);
    }

    public void setPreview(@NonNull Preview preview) {
        CameraPreview cameraPreview;
        if (preview != this.f22128p) {
            this.f22128p = preview;
            if ((getWindowToken() != null) || (cameraPreview = this.f22136x) == null) {
                return;
            }
            cameraPreview.mo7435o();
            this.f22136x = null;
        }
    }

    public void setPreviewFrameRate(float f) {
        this.f22138z.mo7225v0(f);
    }

    public void setPreviewFrameRateExact(boolean z2) {
        this.f22138z.mo7310w0(z2);
    }

    public void setPreviewStreamSize(@NonNull SizeSelector sizeSelector) {
        this.f22138z.mo7312x0(sizeSelector);
    }

    public void setRequestPermissions(boolean z2) {
        this.f22126n = z2;
    }

    public void setSnapshotMaxHeight(int i) {
        this.f22138z.mo7314y0(i);
    }

    public void setSnapshotMaxWidth(int i) {
        this.f22138z.mo7316z0(i);
    }

    public void setUseDeviceOrientation(boolean z2) {
        this.f22125m = z2;
    }

    public void setVideoBitRate(int i) {
        this.f22138z.mo7251A0(i);
    }

    public void setVideoCodec(@NonNull VideoCodec videoCodec) {
        this.f22138z.mo7253B0(videoCodec);
    }

    public void setVideoMaxDuration(int i) {
        this.f22138z.mo7255C0(i);
    }

    public void setVideoMaxSize(long j) {
        this.f22138z.mo7257D0(j);
    }

    public void setVideoSize(@NonNull SizeSelector sizeSelector) {
        this.f22138z.mo7259E0(sizeSelector);
    }

    public void setWhiteBalance(@NonNull WhiteBalance whiteBalance) {
        this.f22138z.mo7190F0(whiteBalance);
    }

    public void setZoom(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.f22138z.mo7191G0(f, null, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.f22122M) {
            OverlayLayout overlayLayout = this.f22123N;
            Objects.requireNonNull(overlayLayout);
            if (attributeSet != null) {
                TypedArray typedArrayObtainStyledAttributes = overlayLayout.getContext().obtainStyledAttributes(attributeSet, C11196R.c.CameraView_Layout);
                z = typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnPreview) || typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnPictureSnapshot) || typedArrayObtainStyledAttributes.hasValue(C11196R.c.CameraView_Layout_layout_drawOnVideoSnapshot);
                typedArrayObtainStyledAttributes.recycle();
            }
            if (z) {
                return this.f22123N.m7414c(attributeSet);
            }
        }
        return super.generateLayoutParams(attributeSet);
    }
}
