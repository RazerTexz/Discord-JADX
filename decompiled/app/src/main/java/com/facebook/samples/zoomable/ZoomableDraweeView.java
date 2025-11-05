package com.facebook.samples.zoomable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.core.view.ScrollingView;
import b.f.g.c.c;
import b.f.g.e.g;
import b.f.g.e.v;
import b.f.l.b.d;
import b.f.l.b.e;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ZoomableDraweeView extends DraweeView<GenericDraweeHierarchy> implements ScrollingView {
    public static final Class<?> j = ZoomableDraweeView.class;
    public boolean k;
    public final RectF l;
    public final RectF m;
    public DraweeController n;
    public e o;
    public GestureDetector p;
    public boolean q;
    public final ControllerListener r;

    /* renamed from: s, reason: collision with root package name */
    public final e.a f2905s;
    public final d t;

    public class a extends c<Object> {
        public a() {
        }

        @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = b.f.d.e.a.a;
            if (((b.f.l.b.c) zoomableDraweeView.o).c) {
                return;
            }
            zoomableDraweeView.b();
            ((b.f.l.b.c) zoomableDraweeView.o).k(true);
        }

        @Override // b.f.g.c.c, com.facebook.drawee.controller.ControllerListener
        public void onRelease(String str) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = b.f.d.e.a.a;
            ((b.f.l.b.c) zoomableDraweeView.o).k(false);
        }
    }

    public class b implements e.a {
        public b() {
        }
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.k = false;
        this.l = new RectF();
        this.m = new RectF();
        this.q = true;
        this.r = new a();
        b bVar = new b();
        this.f2905s = bVar;
        d dVar = new d();
        this.t = dVar;
        b.f.g.f.a aVar = new b.f.g.f.a(context.getResources());
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        aVar.n = v.l;
        b.c.a.a0.d.l2(aVar, context, attributeSet);
        setAspectRatio(aVar.e);
        setHierarchy(aVar.a());
        b.f.l.b.b bVar2 = new b.f.l.b.b(new b.f.l.a.b(new b.f.l.a.a()));
        this.o = bVar2;
        bVar2.f651b = bVar;
        this.p = new GestureDetector(getContext(), dVar);
    }

    public final void a(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        DraweeController controller = getController();
        if (controller instanceof AbstractDraweeController) {
            ((AbstractDraweeController) controller).A(this.r);
        }
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).f(this.r);
        }
        this.n = draweeController2;
        super.setController(draweeController);
    }

    public void b() {
        RectF rectF = this.l;
        g gVar = getHierarchy().f;
        Matrix matrix = g.j;
        gVar.n(matrix);
        rectF.set(gVar.getBounds());
        matrix.mapRect(rectF);
        this.m.set(0.0f, 0.0f, getWidth(), getHeight());
        e eVar = this.o;
        RectF rectF2 = this.l;
        b.f.l.b.c cVar = (b.f.l.b.c) eVar;
        if (!rectF2.equals(cVar.e)) {
            cVar.e.set(rectF2);
            cVar.i();
        }
        ((b.f.l.b.c) this.o).d.set(this.m);
        b.f.d.e.a.j(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.m, this.l);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return (int) ((b.f.l.b.c) this.o).d.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        b.f.l.b.c cVar = (b.f.l.b.c) this.o;
        return (int) (cVar.d.left - cVar.f.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return (int) ((b.f.l.b.c) this.o).f.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (int) ((b.f.l.b.c) this.o).d.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        b.f.l.b.c cVar = (b.f.l.b.c) this.o;
        return (int) (cVar.d.top - cVar.f.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return (int) ((b.f.l.b.c) this.o).f.height();
    }

    public Class<?> getLogTag() {
        return j;
    }

    public e getZoomableController() {
        return this.o;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.concat(((b.f.l.b.c) this.o).h);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        getLogTag();
        hashCode();
        int i5 = b.f.d.e.a.a;
        super.onLayout(z2, i, i2, i3, i4);
        b();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        getLogTag();
        hashCode();
        int i = b.f.d.e.a.a;
        if (this.p.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        if (this.k) {
            if (((b.f.l.b.c) this.o).h(motionEvent)) {
                return true;
            }
        } else if (((b.f.l.b.c) this.o).h(motionEvent)) {
            if ((!this.q && !this.o.a()) || (this.q && !((b.f.l.b.c) this.o).l)) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            getLogTag();
            hashCode();
            return true;
        }
        if (super.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        this.p.onTouchEvent(motionEventObtain);
        ((b.f.l.b.c) this.o).h(motionEventObtain);
        motionEventObtain.recycle();
        return false;
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z2) {
        this.q = z2;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        a(null, null);
        ((b.f.l.b.c) this.o).k(false);
        a(draweeController, null);
    }

    public void setExperimentalSimpleTouchHandlingEnabled(boolean z2) {
        this.k = z2;
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.p.setIsLongpressEnabled(z2);
    }

    public void setTapListener(@Nullable GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (simpleOnGestureListener != null) {
            this.t.j = simpleOnGestureListener;
        } else {
            this.t.j = new GestureDetector.SimpleOnGestureListener();
        }
    }

    public void setZoomableController(e eVar) {
        Objects.requireNonNull(eVar);
        ((b.f.l.b.c) this.o).f651b = null;
        this.o = eVar;
        ((b.f.l.b.c) eVar).f651b = this.f2905s;
    }
}
