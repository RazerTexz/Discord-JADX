package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import b.o.a.q.c;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: ScrollGestureFinder.java */
/* loaded from: classes3.dex */
public class f extends c {
    public static final b.o.a.b d = new b.o.a.b(f.class.getSimpleName());
    public GestureDetector e;
    public boolean f;
    public float g;

    /* compiled from: ScrollGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public final /* synthetic */ c.a j;

        public a(c.a aVar) {
            this.j = aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            b.o.a.q.a aVar = b.o.a.q.a.m;
            boolean z2 = false;
            f.d.a(1, "onScroll:", "distanceX=" + f, "distanceY=" + f2);
            if (motionEvent == null || motionEvent2 == null) {
                return false;
            }
            if (motionEvent.getX() == f.this.c[0].x) {
                float y2 = motionEvent.getY();
                f fVar = f.this;
                if (y2 != fVar.c[0].y) {
                    boolean z3 = Math.abs(f) >= Math.abs(f2);
                    f fVar2 = f.this;
                    if (!z3) {
                        aVar = b.o.a.q.a.n;
                    }
                    fVar2.f1947b = aVar;
                    fVar2.c[0].set(motionEvent.getX(), motionEvent.getY());
                    z2 = z3;
                } else if (fVar.f1947b == aVar) {
                    z2 = true;
                }
            }
            f.this.c[1].set(motionEvent2.getX(), motionEvent2.getY());
            f.this.g = z2 ? f / CameraView.this.getWidth() : f2 / CameraView.this.getHeight();
            f fVar3 = f.this;
            fVar3.g = z2 ? -fVar3.g : fVar3.g;
            fVar3.f = true;
            return true;
        }
    }

    public f(@NonNull c.a aVar) {
        super(aVar, 2);
        CameraView.b bVar = (CameraView.b) aVar;
        GestureDetector gestureDetector = new GestureDetector(bVar.g(), new a(bVar));
        this.e = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return ((f3 - f2) * this.g * 2.0f) + f;
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f = false;
        }
        this.e.onTouchEvent(motionEvent);
        if (this.f) {
            d.a(1, "Notifying a gesture of type", this.f1947b.name());
        }
        return this.f;
    }
}
