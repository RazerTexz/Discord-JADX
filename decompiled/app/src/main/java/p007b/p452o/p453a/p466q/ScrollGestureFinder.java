package p007b.p452o.p453a.p466q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.CameraView;
import p007b.p452o.p453a.CameraLogger;
import p007b.p452o.p453a.p466q.GestureFinder;

/* compiled from: ScrollGestureFinder.java */
/* renamed from: b.o.a.q.f, reason: use source file name */
/* loaded from: classes3.dex */
public class ScrollGestureFinder extends GestureFinder {

    /* renamed from: d */
    public static final CameraLogger f14091d = new CameraLogger(ScrollGestureFinder.class.getSimpleName());

    /* renamed from: e */
    public GestureDetector f14092e;

    /* renamed from: f */
    public boolean f14093f;

    /* renamed from: g */
    public float f14094g;

    /* compiled from: ScrollGestureFinder.java */
    /* renamed from: b.o.a.q.f$a */
    public class a extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: j */
        public final /* synthetic */ GestureFinder.a f14095j;

        public a(GestureFinder.a aVar) {
            this.f14095j = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            Gesture gesture = Gesture.f14069m;
            boolean z2 = false;
            ScrollGestureFinder.f14091d.m7159a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() == ScrollGestureFinder.this.f14083c[0].x) {
                float y2 = motionEvent.getY();
                ScrollGestureFinder scrollGestureFinder = ScrollGestureFinder.this;
                if (y2 != scrollGestureFinder.f14083c[0].y) {
                    boolean z3 = Math.abs(f) >= Math.abs(f2);
                    ScrollGestureFinder scrollGestureFinder2 = ScrollGestureFinder.this;
                    if (!z3) {
                        gesture = Gesture.f14070n;
                    }
                    scrollGestureFinder2.f14082b = gesture;
                    scrollGestureFinder2.f14083c[0].set(motionEvent.getX(), motionEvent.getY());
                    z2 = z3;
                } else if (scrollGestureFinder.f14082b == gesture) {
                    z2 = true;
                }
            }
            ScrollGestureFinder.this.f14083c[1].set(motionEvent2.getX(), motionEvent2.getY());
            ScrollGestureFinder.this.f14094g = z2 ? f / CameraView.this.getWidth() : f2 / CameraView.this.getHeight();
            ScrollGestureFinder scrollGestureFinder3 = ScrollGestureFinder.this;
            scrollGestureFinder3.f14094g = z2 ? -scrollGestureFinder3.f14094g : scrollGestureFinder3.f14094g;
            scrollGestureFinder3.f14093f = true;
            return true;
        }
    }

    public ScrollGestureFinder(@NonNull GestureFinder.a aVar) {
        super(aVar, 2);
        CameraView.C11195b c11195b = (CameraView.C11195b) aVar;
        GestureDetector gestureDetector = new GestureDetector(c11195b.m9317g(), new a(c11195b));
        this.f14092e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // p007b.p452o.p453a.p466q.GestureFinder
    /* renamed from: b */
    public float mo7393b(float f, float f2, float f3) {
        return ((f3 - f2) * this.f14094g * 2.0f) + f;
    }

    /* renamed from: c */
    public boolean m7395c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f14093f = false;
        }
        this.f14092e.onTouchEvent(motionEvent);
        if (this.f14093f) {
            f14091d.m7159a(1, "Notifying a gesture of type", this.f14082b.name());
        }
        return this.f14093f;
    }
}
