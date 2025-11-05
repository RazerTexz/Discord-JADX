package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import b.q.a.k.c;
import b.q.a.l.a;
import java.util.Objects;

/* loaded from: classes3.dex */
public class GestureCropImageView extends b.q.a.l.a {
    public ScaleGestureDetector K;
    public b.q.a.k.c L;
    public GestureDetector M;
    public float N;
    public float O;
    public boolean P;
    public boolean Q;
    public int R;

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b(a aVar) {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float doubleTapTargetScale = gestureCropImageView.getDoubleTapTargetScale();
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (doubleTapTargetScale > gestureCropImageView.getMaxScale()) {
                doubleTapTargetScale = gestureCropImageView.getMaxScale();
            }
            float currentScale = gestureCropImageView.getCurrentScale();
            a.b bVar = new a.b(gestureCropImageView, 200L, currentScale, doubleTapTargetScale - currentScale, x2, y2);
            gestureCropImageView.E = bVar;
            gestureCropImageView.post(bVar);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            GestureCropImageView.this.g(-f, -f2);
            return true;
        }
    }

    public class c extends c.b {
        public c(a aVar) {
        }
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d(a aVar) {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            GestureCropImageView gestureCropImageView2 = GestureCropImageView.this;
            gestureCropImageView.f(scaleFactor, gestureCropImageView2.N, gestureCropImageView2.O);
            return true;
        }
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.P = true;
        this.Q = true;
        this.R = 5;
    }

    @Override // b.q.a.l.c
    public void c() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.M = new GestureDetector(getContext(), new b(null), null, true);
        this.K = new ScaleGestureDetector(getContext(), new d(null));
        this.L = new b.q.a.k.c(new c(null));
    }

    public int getDoubleTapScaleSteps() {
        return this.R;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.R));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            i();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.N = (motionEvent.getX(1) + motionEvent.getX(0)) / 2.0f;
            this.O = (motionEvent.getY(1) + motionEvent.getY(0)) / 2.0f;
        }
        this.M.onTouchEvent(motionEvent);
        if (this.Q) {
            this.K.onTouchEvent(motionEvent);
        }
        if (this.P) {
            b.q.a.k.c cVar = this.L;
            Objects.requireNonNull(cVar);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                cVar.c = motionEvent.getX();
                cVar.d = motionEvent.getY();
                cVar.e = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
                cVar.g = 0.0f;
                cVar.h = true;
            } else if (actionMasked == 1) {
                cVar.e = -1;
            } else if (actionMasked != 2) {
                if (actionMasked == 5) {
                    cVar.a = motionEvent.getX();
                    cVar.f1986b = motionEvent.getY();
                    cVar.f = motionEvent.findPointerIndex(motionEvent.getPointerId(motionEvent.getActionIndex()));
                    cVar.g = 0.0f;
                    cVar.h = true;
                } else if (actionMasked == 6) {
                    cVar.f = -1;
                }
            } else if (cVar.e != -1 && cVar.f != -1 && motionEvent.getPointerCount() > cVar.f) {
                float x2 = motionEvent.getX(cVar.e);
                float y2 = motionEvent.getY(cVar.e);
                float x3 = motionEvent.getX(cVar.f);
                float y3 = motionEvent.getY(cVar.f);
                if (cVar.h) {
                    cVar.g = 0.0f;
                    cVar.h = false;
                } else {
                    float f = cVar.a;
                    float degrees = (((float) Math.toDegrees((float) Math.atan2(y3 - y2, x3 - x2))) % 360.0f) - (((float) Math.toDegrees((float) Math.atan2(cVar.f1986b - cVar.d, f - cVar.c))) % 360.0f);
                    cVar.g = degrees;
                    if (degrees < -180.0f) {
                        cVar.g = degrees + 360.0f;
                    } else if (degrees > 180.0f) {
                        cVar.g = degrees - 360.0f;
                    }
                }
                c.a aVar = cVar.i;
                if (aVar != null) {
                    GestureCropImageView gestureCropImageView = GestureCropImageView.this;
                    gestureCropImageView.e(cVar.g, gestureCropImageView.N, gestureCropImageView.O);
                }
                cVar.a = x3;
                cVar.f1986b = y3;
                cVar.c = x2;
                cVar.d = y2;
            }
        }
        if ((motionEvent.getAction() & 255) == 1) {
            setImageToWrapCropBounds(true);
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i) {
        this.R = i;
    }

    public void setRotateEnabled(boolean z2) {
        this.P = z2;
    }

    public void setScaleEnabled(boolean z2) {
        this.Q = z2;
    }
}
