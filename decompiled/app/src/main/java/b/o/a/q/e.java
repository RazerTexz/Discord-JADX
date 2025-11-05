package b.o.a.q;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import androidx.annotation.NonNull;
import b.o.a.q.c;
import com.otaliastudios.cameraview.CameraView;

/* compiled from: PinchGestureFinder.java */
/* loaded from: classes3.dex */
public class e extends c {
    public ScaleGestureDetector d;
    public boolean e;
    public float f;

    /* compiled from: PinchGestureFinder.java */
    public class a extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            e eVar = e.this;
            eVar.e = true;
            eVar.f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
            return true;
        }
    }

    public e(@NonNull c.a aVar) {
        super(aVar, 2);
        this.f = 0.0f;
        this.f1947b = b.o.a.q.a.j;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView.b) aVar).g(), new a());
        this.d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
    }

    @Override // b.o.a.q.c
    public float b(float f, float f2, float f3) {
        return b.d.b.a.a.a(f3, f2, this.f, f);
    }

    public boolean c(@NonNull MotionEvent motionEvent) {
        boolean z2 = false;
        if (motionEvent.getAction() == 0) {
            this.e = false;
        }
        this.d.onTouchEvent(motionEvent);
        if (this.e) {
            this.c[0].x = motionEvent.getX(0);
            this.c[0].y = motionEvent.getY(0);
            z2 = true;
            if (motionEvent.getPointerCount() > 1) {
                this.c[1].x = motionEvent.getX(1);
                this.c[1].y = motionEvent.getY(1);
            }
        }
        return z2;
    }
}
