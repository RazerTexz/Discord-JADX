package p007b.p109f.p132g.p142e;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.g.e.o, reason: use source file name */
/* JADX INFO: compiled from: RoundedNinePatchDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class RoundedNinePatchDrawable extends RoundedDrawable {
    public RoundedNinePatchDrawable(NinePatchDrawable ninePatchDrawable) {
        super(ninePatchDrawable);
    }

    @Override // p007b.p109f.p132g.p142e.RoundedDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        FrescoSystrace.m1527b();
        if (!mo1113d()) {
            super.draw(canvas);
            FrescoSystrace.m1527b();
            return;
        }
        m1117h();
        m1116g();
        canvas.clipPath(this.f3422n);
        super.draw(canvas);
        FrescoSystrace.m1527b();
    }
}
