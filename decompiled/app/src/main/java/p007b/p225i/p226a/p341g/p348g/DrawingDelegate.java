package p007b.p225i.p226a.p341g.p348g;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;

/* compiled from: DrawingDelegate.java */
/* renamed from: b.i.a.g.g.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {

    /* renamed from: a */
    public S f11734a;

    /* renamed from: b */
    public DrawableWithAnimatedVisibilityChange f11735b;

    public DrawingDelegate(S s2) {
        this.f11734a = s2;
    }

    /* renamed from: a */
    public abstract void mo6117a(@NonNull Canvas canvas, @FloatRange(from = 0.0d, m75to = 1.0d) float f);

    /* renamed from: b */
    public abstract void mo6118b(@NonNull Canvas canvas, @NonNull Paint paint, @FloatRange(from = 0.0d, m75to = 1.0d) float f, @FloatRange(from = 0.0d, m75to = 1.0d) float f2, @ColorInt int i);

    /* renamed from: c */
    public abstract void mo6119c(@NonNull Canvas canvas, @NonNull Paint paint);

    /* renamed from: d */
    public abstract int mo6120d();

    /* renamed from: e */
    public abstract int mo6121e();
}
