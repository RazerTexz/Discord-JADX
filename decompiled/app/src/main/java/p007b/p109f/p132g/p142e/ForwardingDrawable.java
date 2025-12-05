package p007b.p109f.p132g.p142e;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: ForwardingDrawable.java */
/* renamed from: b.f.g.e.g, reason: use source file name */
/* loaded from: classes.dex */
public class ForwardingDrawable extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {

    /* renamed from: j */
    public static final Matrix f3359j = new Matrix();

    /* renamed from: k */
    public Drawable f3360k;

    /* renamed from: l */
    public final DrawableProperties f3361l = new DrawableProperties();

    /* renamed from: m */
    public TransformCallback f3362m;

    public ForwardingDrawable(Drawable drawable) {
        this.f3360k = drawable;
        AnimatableValueParser.m488X1(drawable, this, this);
    }

    @Override // p007b.p109f.p132g.p142e.TransformAwareDrawable
    /* renamed from: b */
    public void mo1094b(TransformCallback transformCallback) {
        this.f3362m = transformCallback;
    }

    @Override // p007b.p109f.p132g.p142e.TransformCallback
    /* renamed from: d */
    public void mo1096d(Matrix matrix) {
        m1103n(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* renamed from: g */
    public Drawable mo1090g(Drawable drawable) {
        return mo1104o(drawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getConstantState() : drawable.getConstantState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f3360k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getIntrinsicHeight() : drawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getIntrinsicWidth() : drawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            return 0;
        }
        return drawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.getPadding(rect) : drawable.getPadding(rect);
    }

    @Override // p007b.p109f.p132g.p142e.TransformCallback
    /* renamed from: h */
    public void mo1097h(RectF rectF) {
        TransformCallback transformCallback = this.f3362m;
        if (transformCallback != null) {
            transformCallback.mo1097h(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f3360k;
        if (drawable == null) {
            return false;
        }
        return drawable.isStateful();
    }

    @Override // p007b.p109f.p132g.p142e.DrawableParent
    /* renamed from: l */
    public Drawable mo1091l() {
        return this.f3360k;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* renamed from: n */
    public void m1103n(Matrix matrix) {
        TransformCallback transformCallback = this.f3362m;
        if (transformCallback != null) {
            transformCallback.mo1096d(matrix);
        } else {
            matrix.reset();
        }
    }

    /* renamed from: o */
    public Drawable mo1104o(Drawable drawable) {
        Drawable drawable2 = this.f3360k;
        AnimatableValueParser.m488X1(drawable2, null, null);
        AnimatableValueParser.m488X1(drawable, null, null);
        AnimatableValueParser.m494Z1(drawable, this.f3361l);
        AnimatableValueParser.m450L(drawable, this);
        AnimatableValueParser.m488X1(drawable, this, this);
        this.f3360k = drawable;
        invalidateSelf();
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.onLevelChange(i) : drawable.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f3360k;
        return drawable == null ? super.onStateChange(iArr) : drawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f3361l.f3339a = i;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableProperties drawableProperties = this.f3361l;
        drawableProperties.f3341c = colorFilter;
        drawableProperties.f3340b = colorFilter != null;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z2) {
        this.f3361l.f3342d = z2 ? 1 : 0;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setDither(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z2) {
        this.f3361l.f3343e = z2 ? 1 : 0;
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setFilterBitmap(z2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f3360k;
        return drawable == null ? visible : drawable.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
