package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.g.e.c, reason: use source file name */
/* JADX INFO: compiled from: AutoRotateDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class AutoRotateDrawable extends ForwardingDrawable implements Runnable {

    /* JADX INFO: renamed from: n */
    public int f3335n;

    /* JADX INFO: renamed from: o */
    public boolean f3336o;

    /* JADX INFO: renamed from: p */
    @VisibleForTesting
    public float f3337p;

    /* JADX INFO: renamed from: q */
    public boolean f3338q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoRotateDrawable(Drawable drawable, int i) {
        super(drawable);
        Objects.requireNonNull(drawable);
        this.f3337p = 0.0f;
        this.f3338q = false;
        this.f3335n = i;
        this.f3336o = true;
    }

    @Override // p007b.p109f.p132g.p142e.ForwardingDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        Rect bounds = getBounds();
        int i = bounds.right - bounds.left;
        int i2 = bounds.bottom - bounds.top;
        float f = this.f3337p;
        if (!this.f3336o) {
            f = 360.0f - f;
        }
        canvas.rotate(f, (i / 2) + r3, (i2 / 2) + r1);
        Drawable drawable = this.f3360k;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.restoreToCount(iSave);
        if (this.f3338q) {
            return;
        }
        this.f3338q = true;
        scheduleSelf(this, SystemClock.uptimeMillis() + 20);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3338q = false;
        this.f3337p += (int) ((20.0f / this.f3335n) * 360.0f);
        invalidateSelf();
    }
}
