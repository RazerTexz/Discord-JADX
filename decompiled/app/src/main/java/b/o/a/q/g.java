package b.o.a.q;

import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import b.o.a.q.c;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: TapGestureFinder.java */
/* loaded from: classes3.dex */
public class g extends c {
    public GestureDetector d;
    public boolean e;

    /* compiled from: TapGestureFinder.java */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            g gVar = g.this;
            gVar.e = true;
            gVar.f1947b = b.o.a.q.a.l;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            g gVar = g.this;
            gVar.e = true;
            gVar.f1947b = b.o.a.q.a.k;
            return true;
        }
    }

    public g(@NonNull c.a aVar) {
        super(aVar, 1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView.b) aVar).g(), new a());
        this.d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return 0.0f;
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.e = false;
        }
        this.d.onTouchEvent(motionEvent);
        if (!this.e) {
            return false;
        }
        this.c[0].x = motionEvent.getX();
        this.c[0].y = motionEvent.getY();
        return true;
    }
}
