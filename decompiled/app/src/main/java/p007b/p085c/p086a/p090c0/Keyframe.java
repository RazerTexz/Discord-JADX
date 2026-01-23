package p007b.p085c.p086a.p090c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.LottieComposition;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.c.a.c0.a, reason: use source file name */
/* JADX INFO: compiled from: Keyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class Keyframe<T> {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final LottieComposition f2316a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final T f2317b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public T f2318c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final Interpolator f2319d;

    /* JADX INFO: renamed from: e */
    public final float f2320e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public Float f2321f;

    /* JADX INFO: renamed from: g */
    public float f2322g;

    /* JADX INFO: renamed from: h */
    public float f2323h;

    /* JADX INFO: renamed from: i */
    public int f2324i;

    /* JADX INFO: renamed from: j */
    public int f2325j;

    /* JADX INFO: renamed from: k */
    public float f2326k;

    /* JADX INFO: renamed from: l */
    public float f2327l;

    /* JADX INFO: renamed from: m */
    public PointF f2328m;

    /* JADX INFO: renamed from: n */
    public PointF f2329n;

    public Keyframe(LottieComposition lottieComposition, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.f2322g = -3987645.8f;
        this.f2323h = -3987645.8f;
        this.f2324i = 784923401;
        this.f2325j = 784923401;
        this.f2326k = Float.MIN_VALUE;
        this.f2327l = Float.MIN_VALUE;
        this.f2328m = null;
        this.f2329n = null;
        this.f2316a = lottieComposition;
        this.f2317b = t;
        this.f2318c = t2;
        this.f2319d = interpolator;
        this.f2320e = f;
        this.f2321f = f2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m664a(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        return f >= m666c() && f < m665b();
    }

    /* JADX INFO: renamed from: b */
    public float m665b() {
        if (this.f2316a == null) {
            return 1.0f;
        }
        if (this.f2327l == Float.MIN_VALUE) {
            if (this.f2321f == null) {
                this.f2327l = 1.0f;
            } else {
                this.f2327l = ((this.f2321f.floatValue() - this.f2320e) / this.f2316a.m671c()) + m666c();
            }
        }
        return this.f2327l;
    }

    /* JADX INFO: renamed from: c */
    public float m666c() {
        LottieComposition lottieComposition = this.f2316a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f2326k == Float.MIN_VALUE) {
            this.f2326k = (this.f2320e - lottieComposition.f2346k) / lottieComposition.m671c();
        }
        return this.f2326k;
    }

    /* JADX INFO: renamed from: d */
    public boolean m667d() {
        return this.f2319d == null;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Keyframe{startValue=");
        sbM833U.append(this.f2317b);
        sbM833U.append(", endValue=");
        sbM833U.append(this.f2318c);
        sbM833U.append(", startFrame=");
        sbM833U.append(this.f2320e);
        sbM833U.append(", endFrame=");
        sbM833U.append(this.f2321f);
        sbM833U.append(", interpolator=");
        sbM833U.append(this.f2319d);
        sbM833U.append('}');
        return sbM833U.toString();
    }

    public Keyframe(T t) {
        this.f2322g = -3987645.8f;
        this.f2323h = -3987645.8f;
        this.f2324i = 784923401;
        this.f2325j = 784923401;
        this.f2326k = Float.MIN_VALUE;
        this.f2327l = Float.MIN_VALUE;
        this.f2328m = null;
        this.f2329n = null;
        this.f2316a = null;
        this.f2317b = t;
        this.f2318c = t;
        this.f2319d = null;
        this.f2320e = Float.MIN_VALUE;
        this.f2321f = Float.valueOf(Float.MAX_VALUE);
    }
}
