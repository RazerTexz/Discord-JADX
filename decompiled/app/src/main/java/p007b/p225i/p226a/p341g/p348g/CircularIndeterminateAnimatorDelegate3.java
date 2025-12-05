package p007b.p225i.p226a.p341g.p348g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.CircularProgressIndicatorSpec;

/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.d, reason: use source file name */
/* loaded from: classes3.dex */
public final class CircularIndeterminateAnimatorDelegate3 extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* renamed from: d */
    public static final int[] f11719d = {0, 1350, 2700, 4050};

    /* renamed from: e */
    public static final int[] f11720e = {667, 2017, 3367, 4717};

    /* renamed from: f */
    public static final int[] f11721f = {1000, 2350, 3700, 5050};

    /* renamed from: g */
    public static final Property<CircularIndeterminateAnimatorDelegate3, Float> f11722g = new a(Float.class, "animationFraction");

    /* renamed from: h */
    public static final Property<CircularIndeterminateAnimatorDelegate3, Float> f11723h = new b(Float.class, "completeEndFraction");

    /* renamed from: i */
    public ObjectAnimator f11724i;

    /* renamed from: j */
    public ObjectAnimator f11725j;

    /* renamed from: k */
    public final FastOutSlowInInterpolator f11726k;

    /* renamed from: l */
    public final BaseProgressIndicatorSpec f11727l;

    /* renamed from: m */
    public int f11728m;

    /* renamed from: n */
    public float f11729n;

    /* renamed from: o */
    public float f11730o;

    /* renamed from: p */
    public Animatable2Compat.AnimationCallback f11731p;

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* renamed from: b.i.a.g.g.d$a */
    public static class a extends Property<CircularIndeterminateAnimatorDelegate3, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate3.f11729n);
        }

        @Override // android.util.Property
        public void set(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3, Float f) {
            CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate32 = circularIndeterminateAnimatorDelegate3;
            float fFloatValue = f.floatValue();
            circularIndeterminateAnimatorDelegate32.f11729n = fFloatValue;
            int i = (int) (5400.0f * fFloatValue);
            float[] fArr = circularIndeterminateAnimatorDelegate32.f11737b;
            float f2 = fFloatValue * 1520.0f;
            fArr[0] = (-20.0f) + f2;
            fArr[1] = f2;
            for (int i2 = 0; i2 < 4; i2++) {
                float fM6130b = circularIndeterminateAnimatorDelegate32.m6130b(i, CircularIndeterminateAnimatorDelegate3.f11719d[i2], 667);
                float[] fArr2 = circularIndeterminateAnimatorDelegate32.f11737b;
                fArr2[1] = (circularIndeterminateAnimatorDelegate32.f11726k.getInterpolation(fM6130b) * 250.0f) + fArr2[1];
                float fM6130b2 = circularIndeterminateAnimatorDelegate32.m6130b(i, CircularIndeterminateAnimatorDelegate3.f11720e[i2], 667);
                float[] fArr3 = circularIndeterminateAnimatorDelegate32.f11737b;
                fArr3[0] = (circularIndeterminateAnimatorDelegate32.f11726k.getInterpolation(fM6130b2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = circularIndeterminateAnimatorDelegate32.f11737b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * circularIndeterminateAnimatorDelegate32.f11730o) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i3 = 0;
            while (true) {
                if (i3 >= 4) {
                    break;
                }
                float fM6130b3 = circularIndeterminateAnimatorDelegate32.m6130b(i, CircularIndeterminateAnimatorDelegate3.f11721f[i3], 333);
                if (fM6130b3 >= 0.0f && fM6130b3 <= 1.0f) {
                    int i4 = i3 + circularIndeterminateAnimatorDelegate32.f11728m;
                    int[] iArr = circularIndeterminateAnimatorDelegate32.f11727l.indicatorColors;
                    int length = i4 % iArr.length;
                    int length2 = (length + 1) % iArr.length;
                    int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], circularIndeterminateAnimatorDelegate32.f11736a.getAlpha());
                    int iCompositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(circularIndeterminateAnimatorDelegate32.f11727l.indicatorColors[length2], circularIndeterminateAnimatorDelegate32.f11736a.getAlpha());
                    circularIndeterminateAnimatorDelegate32.f11738c[0] = ArgbEvaluatorCompat.getInstance().evaluate2(circularIndeterminateAnimatorDelegate32.f11726k.getInterpolation(fM6130b3), Integer.valueOf(iCompositeARGBWithAlpha), Integer.valueOf(iCompositeARGBWithAlpha2)).intValue();
                    break;
                }
                i3++;
            }
            circularIndeterminateAnimatorDelegate32.f11736a.invalidateSelf();
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    /* renamed from: b.i.a.g.g.d$b */
    public static class b extends Property<CircularIndeterminateAnimatorDelegate3, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
            return Float.valueOf(circularIndeterminateAnimatorDelegate3.f11730o);
        }

        @Override // android.util.Property
        public void set(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3, Float f) {
            circularIndeterminateAnimatorDelegate3.f11730o = f.floatValue();
        }
    }

    public CircularIndeterminateAnimatorDelegate3(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.f11728m = 0;
        this.f11731p = null;
        this.f11727l = circularProgressIndicatorSpec;
        this.f11726k = new FastOutSlowInInterpolator();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: a */
    public void mo6123a() {
        ObjectAnimator objectAnimator = this.f11724i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: c */
    public void mo6124c() {
        m6129h();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: d */
    public void mo6125d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.f11731p = animationCallback;
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: e */
    public void mo6126e() {
        if (this.f11725j.isRunning()) {
            return;
        }
        if (this.f11736a.isVisible()) {
            this.f11725j.start();
        } else {
            mo6123a();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: f */
    public void mo6127f() {
        if (this.f11724i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f11722g, 0.0f, 1.0f);
            this.f11724i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.f11724i.setInterpolator(null);
            this.f11724i.setRepeatCount(-1);
            this.f11724i.addListener(new CircularIndeterminateAnimatorDelegate(this));
        }
        if (this.f11725j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f11723h, 0.0f, 1.0f);
            this.f11725j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.f11725j.setInterpolator(this.f11726k);
            this.f11725j.addListener(new CircularIndeterminateAnimatorDelegate2(this));
        }
        m6129h();
        this.f11724i.start();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* renamed from: g */
    public void mo6128g() {
        this.f11731p = null;
    }

    @VisibleForTesting
    /* renamed from: h */
    public void m6129h() {
        this.f11728m = 0;
        this.f11738c[0] = MaterialColors.compositeARGBWithAlpha(this.f11727l.indicatorColors[0], this.f11736a.getAlpha());
        this.f11730o = 0.0f;
    }
}
