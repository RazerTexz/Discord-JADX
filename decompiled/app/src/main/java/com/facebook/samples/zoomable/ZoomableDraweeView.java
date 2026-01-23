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
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.DraweeView;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p132g.p139c.BaseControllerListener;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p142e.ForwardingDrawable;
import p007b.p109f.p132g.p143f.GenericDraweeHierarchyBuilder;
import p007b.p109f.p187l.p188a.MultiPointerGestureDetector;
import p007b.p109f.p187l.p188a.TransformGestureDetector;
import p007b.p109f.p187l.p189b.AnimatedZoomableController;
import p007b.p109f.p187l.p189b.DefaultZoomableController;
import p007b.p109f.p187l.p189b.GestureListenerWrapper;
import p007b.p109f.p187l.p189b.ZoomableController;

/* JADX INFO: loaded from: classes3.dex */
public class ZoomableDraweeView extends DraweeView<GenericDraweeHierarchy> implements ScrollingView {

    /* JADX INFO: renamed from: j */
    public static final Class<?> f19628j = ZoomableDraweeView.class;

    /* JADX INFO: renamed from: k */
    public boolean f19629k;

    /* JADX INFO: renamed from: l */
    public final RectF f19630l;

    /* JADX INFO: renamed from: m */
    public final RectF f19631m;

    /* JADX INFO: renamed from: n */
    public DraweeController f19632n;

    /* JADX INFO: renamed from: o */
    public ZoomableController f19633o;

    /* JADX INFO: renamed from: p */
    public GestureDetector f19634p;

    /* JADX INFO: renamed from: q */
    public boolean f19635q;

    /* JADX INFO: renamed from: r */
    public final ControllerListener f19636r;

    /* JADX INFO: renamed from: s */
    public final ZoomableController.a f19637s;

    /* JADX INFO: renamed from: t */
    public final GestureListenerWrapper f19638t;

    /* JADX INFO: renamed from: com.facebook.samples.zoomable.ZoomableDraweeView$a */
    public class C10671a extends BaseControllerListener<Object> {
        public C10671a() {
        }

        @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.f19628j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = FLog.f3102a;
            if (((DefaultZoomableController) zoomableDraweeView.f19633o).f4301c) {
                return;
            }
            zoomableDraweeView.m8726b();
            ((DefaultZoomableController) zoomableDraweeView.f19633o).m1564k(true);
        }

        @Override // p007b.p109f.p132g.p139c.BaseControllerListener, com.facebook.drawee.controller.ControllerListener
        public void onRelease(String str) {
            ZoomableDraweeView zoomableDraweeView = ZoomableDraweeView.this;
            Class<?> cls = ZoomableDraweeView.f19628j;
            zoomableDraweeView.getLogTag();
            zoomableDraweeView.hashCode();
            int i = FLog.f3102a;
            ((DefaultZoomableController) zoomableDraweeView.f19633o).m1564k(false);
        }
    }

    /* JADX INFO: renamed from: com.facebook.samples.zoomable.ZoomableDraweeView$b */
    public class C10672b implements ZoomableController.a {
        public C10672b() {
        }
    }

    public ZoomableDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19629k = false;
        this.f19630l = new RectF();
        this.f19631m = new RectF();
        this.f19635q = true;
        this.f19636r = new C10671a();
        C10672b c10672b = new C10672b();
        this.f19637s = c10672b;
        GestureListenerWrapper gestureListenerWrapper = new GestureListenerWrapper();
        this.f19638t = gestureListenerWrapper;
        GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(context.getResources());
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        genericDraweeHierarchyBuilder.f3464n = C1788v.f3446l;
        AnimatableValueParser.m542l2(genericDraweeHierarchyBuilder, context, attributeSet);
        setAspectRatio(genericDraweeHierarchyBuilder.f3455e);
        setHierarchy(genericDraweeHierarchyBuilder.m1122a());
        AnimatedZoomableController animatedZoomableController = new AnimatedZoomableController(new TransformGestureDetector(new MultiPointerGestureDetector()));
        this.f19633o = animatedZoomableController;
        animatedZoomableController.f4300b = c10672b;
        this.f19634p = new GestureDetector(getContext(), gestureListenerWrapper);
    }

    /* JADX INFO: renamed from: a */
    public final void m8725a(@Nullable DraweeController draweeController, @Nullable DraweeController draweeController2) {
        DraweeController controller = getController();
        if (controller instanceof AbstractDraweeController) {
            ((AbstractDraweeController) controller).m8647A(this.f19636r);
        }
        if (draweeController instanceof AbstractDraweeController) {
            ((AbstractDraweeController) draweeController).m8656f(this.f19636r);
        }
        this.f19632n = draweeController2;
        super.setController(draweeController);
    }

    /* JADX INFO: renamed from: b */
    public void m8726b() {
        RectF rectF = this.f19630l;
        ForwardingDrawable forwardingDrawable = getHierarchy().f19511f;
        Matrix matrix = ForwardingDrawable.f3359j;
        forwardingDrawable.m1103n(matrix);
        rectF.set(forwardingDrawable.getBounds());
        matrix.mapRect(rectF);
        this.f19631m.set(0.0f, 0.0f, getWidth(), getHeight());
        ZoomableController zoomableController = this.f19633o;
        RectF rectF2 = this.f19630l;
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) zoomableController;
        if (!rectF2.equals(defaultZoomableController.f4303e)) {
            defaultZoomableController.f4303e.set(rectF2);
            defaultZoomableController.m1563i();
        }
        ((DefaultZoomableController) this.f19633o).f4302d.set(this.f19631m);
        FLog.m982j(getLogTag(), "updateZoomableControllerBounds: view %x, view bounds: %s, image bounds: %s", Integer.valueOf(hashCode()), this.f19631m, this.f19630l);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        return (int) ((DefaultZoomableController) this.f19633o).f4302d.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) this.f19633o;
        return (int) (defaultZoomableController.f4302d.left - defaultZoomableController.f4304f.left);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        return (int) ((DefaultZoomableController) this.f19633o).f4304f.width();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        return (int) ((DefaultZoomableController) this.f19633o).f4302d.height();
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        DefaultZoomableController defaultZoomableController = (DefaultZoomableController) this.f19633o;
        return (int) (defaultZoomableController.f4302d.top - defaultZoomableController.f4304f.top);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        return (int) ((DefaultZoomableController) this.f19633o).f4304f.height();
    }

    public Class<?> getLogTag() {
        return f19628j;
    }

    public ZoomableController getZoomableController() {
        return this.f19633o;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        int iSave = canvas.save();
        canvas.concat(((DefaultZoomableController) this.f19633o).f4306h);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        getLogTag();
        hashCode();
        int i5 = FLog.f3102a;
        super.onLayout(z2, i, i2, i3, i4);
        m8726b();
    }

    @Override // com.facebook.drawee.view.DraweeView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        motionEvent.getActionMasked();
        getLogTag();
        hashCode();
        int i = FLog.f3102a;
        if (this.f19634p.onTouchEvent(motionEvent)) {
            getLogTag();
            hashCode();
            return true;
        }
        if (this.f19629k) {
            if (((DefaultZoomableController) this.f19633o).m1562h(motionEvent)) {
                return true;
            }
        } else if (((DefaultZoomableController) this.f19633o).m1562h(motionEvent)) {
            if ((!this.f19635q && !this.f19633o.mo1551a()) || (this.f19635q && !((DefaultZoomableController) this.f19633o).f4310l)) {
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
        this.f19634p.onTouchEvent(motionEventObtain);
        ((DefaultZoomableController) this.f19633o).m1562h(motionEventObtain);
        motionEventObtain.recycle();
        return false;
    }

    public void setAllowTouchInterceptionWhileZoomed(boolean z2) {
        this.f19635q = z2;
    }

    @Override // com.facebook.drawee.view.DraweeView
    public void setController(@Nullable DraweeController draweeController) {
        m8725a(null, null);
        ((DefaultZoomableController) this.f19633o).m1564k(false);
        m8725a(draweeController, null);
    }

    public void setExperimentalSimpleTouchHandlingEnabled(boolean z2) {
        this.f19629k = z2;
    }

    public void setIsLongpressEnabled(boolean z2) {
        this.f19634p.setIsLongpressEnabled(z2);
    }

    public void setTapListener(@Nullable GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        if (simpleOnGestureListener != null) {
            this.f19638t.f4311j = simpleOnGestureListener;
        } else {
            this.f19638t.f4311j = new GestureDetector.SimpleOnGestureListener();
        }
    }

    public void setZoomableController(ZoomableController zoomableController) {
        Objects.requireNonNull(zoomableController);
        ((DefaultZoomableController) this.f19633o).f4300b = null;
        this.f19633o = zoomableController;
        ((DefaultZoomableController) zoomableController).f4300b = this.f19637s;
    }
}
