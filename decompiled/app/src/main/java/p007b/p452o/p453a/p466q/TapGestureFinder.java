package p007b.p452o.p453a.p466q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.p466q.GestureFinder;

/* compiled from: TapGestureFinder.java */
/* renamed from: b.o.a.q.g, reason: use source file name */
/* loaded from: classes3.dex */
public class TapGestureFinder extends GestureFinder {

    /* renamed from: d */
    public GestureDetector f14097d;

    /* renamed from: e */
    public boolean f14098e;

    /* compiled from: TapGestureFinder.java */
    /* renamed from: b.o.a.q.g$a */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.f14098e = true;
            tapGestureFinder.f14082b = Gesture.f14068l;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            TapGestureFinder tapGestureFinder = TapGestureFinder.this;
            tapGestureFinder.f14098e = true;
            tapGestureFinder.f14082b = Gesture.f14067k;
            return true;
        }
    }

    public TapGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView.C11195b) aVar).m9317g(), new a());
        this.f14097d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // p007b.p452o.p453a.p466q.GestureFinder
    /* renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return 0.0f;
    }

    /* renamed from: c */
    public boolean m7396c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14098e = false;
        }
        this.f14097d.onTouchEvent(motionEvent);
        if (!this.f14098e) {
            return false;
        }
        this.f14083c[0].x = motionEvent.getX();
        this.f14083c[0].y = motionEvent.getY();
        return true;
    }
}
