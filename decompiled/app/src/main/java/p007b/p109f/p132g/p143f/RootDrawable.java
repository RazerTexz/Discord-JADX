package p007b.p109f.p132g.p143f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.facebook.drawee.view.DraweeHolder;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p132g.p138b.DraweeEventTracker;
import p007b.p109f.p132g.p142e.ForwardingDrawable;
import p007b.p109f.p132g.p142e.VisibilityAwareDrawable;
import p007b.p109f.p132g.p142e.VisibilityCallback;

/* compiled from: RootDrawable.java */
/* renamed from: b.f.g.f.b, reason: use source file name */
/* loaded from: classes.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {

    /* renamed from: n */
    @VisibleForTesting
    public Drawable f3469n;

    /* renamed from: o */
    public VisibilityCallback f3470o;

    public RootDrawable(Drawable drawable) {
        super(drawable);
        this.f3469n = null;
    }

    @Override // p007b.p109f.p132g.p142e.ForwardingDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.f3470o;
            if (visibilityCallback != null) {
                DraweeHolder draweeHolder = (DraweeHolder) visibilityCallback;
                if (!draweeHolder.f19525a) {
                    FLog.m985m(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.f19529e)), draweeHolder.toString());
                    draweeHolder.f19526b = true;
                    draweeHolder.f19527c = true;
                    draweeHolder.m8688b();
                }
            }
            Drawable drawable = this.f3360k;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.f3469n;
            if (drawable2 != null) {
                drawable2.setBounds(getBounds());
                this.f3469n.draw(canvas);
            }
        }
    }

    @Override // p007b.p109f.p132g.p142e.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // p007b.p109f.p132g.p142e.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // p007b.p109f.p132g.p142e.VisibilityAwareDrawable
    /* renamed from: k */
    public void mo1102k(VisibilityCallback visibilityCallback) {
        this.f3470o = visibilityCallback;
    }

    @Override // p007b.p109f.p132g.p142e.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        VisibilityCallback visibilityCallback = this.f3470o;
        if (visibilityCallback != null) {
            ((DraweeHolder) visibilityCallback).m8692f(z2);
        }
        return super.setVisible(z2, z3);
    }
}
