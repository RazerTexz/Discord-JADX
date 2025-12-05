package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.LottieDrawable;
import p007b.p085c.p086a.p091w.p092b.ContentGroup;
import p007b.p085c.p086a.p095y.KeyPath;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;

/* compiled from: ShapeLayer.java */
/* renamed from: b.c.a.y.m.g, reason: use source file name */
/* loaded from: classes.dex */
public class ShapeLayer extends BaseLayer2 {

    /* renamed from: x */
    public final ContentGroup f2898x;

    public ShapeLayer(LottieDrawable lottieDrawable, Layer2 layer2) {
        super(lottieDrawable, layer2);
        ContentGroup contentGroup = new ContentGroup(lottieDrawable, this, new ShapeGroup("__container", layer2.f2868a, false));
        this.f2898x = contentGroup;
        contentGroup.mo710b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2, p007b.p085c.p086a.p091w.p092b.DrawingContent
    /* renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        this.f2898x.mo712d(rectF, this.f2848m, z2);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* renamed from: j */
    public void mo780j(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f2898x.mo713f(canvas, matrix, i);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.BaseLayer2
    /* renamed from: n */
    public void mo784n(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        this.f2898x.mo711c(keyPath, i, list, keyPath2);
    }
}
