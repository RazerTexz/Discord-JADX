package p007b.p452o.p453a.p466q;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;
import p007b.p100d.p104b.p105a.outline;
import p007b.p452o.p453a.p466q.GestureFinder;

/* compiled from: PinchGestureFinder.java */
/* renamed from: b.o.a.q.e, reason: use source file name */
/* loaded from: classes3.dex */
public class PinchGestureFinder extends GestureFinder {

    /* renamed from: d */
    public ScaleGestureDetector f14087d;

    /* renamed from: e */
    public boolean f14088e;

    /* renamed from: f */
    public float f14089f;

    /* compiled from: PinchGestureFinder.java */
    /* renamed from: b.o.a.q.e$a */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            PinchGestureFinder pinchGestureFinder = PinchGestureFinder.this;
            pinchGestureFinder.f14088e = true;
            pinchGestureFinder.f14089f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public PinchGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 2);
        this.f14089f = 0.0f;
        this.f14082b = Gesture.f14066j;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView.C11195b) aVar).m9317g(), new a());
        this.f14087d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    @Override // p007b.p452o.p453a.p466q.GestureFinder
    /* renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return outline.m839a(f3, f2, this.f14089f, f);
    }

    /* renamed from: c */
    public boolean m7394c(@NonNull MotionEvent motionEvent) {
        boolean z2 = false;
        if (motionEvent.getAction() == 0) {
            this.f14088e = false;
        }
        this.f14087d.onTouchEvent(motionEvent);
        if (this.f14088e) {
            this.f14083c[0].x = motionEvent.getX(0);
            this.f14083c[0].y = motionEvent.getY(0);
            z2 = true;
            if (motionEvent.getPointerCount() > 1) {
                this.f14083c[1].x = motionEvent.getX(1);
                this.f14083c[1].y = motionEvent.getY(1);
            }
        }
        return z2;
    }
}
