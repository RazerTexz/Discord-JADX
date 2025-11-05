package b.i.a.g.g;

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
/* loaded from: classes3.dex */
public final class d extends g<ObjectAnimator> {
    public static final int[] d = {0, 1350, 2700, 4050};
    public static final int[] e = {667, 2017, 3367, 4717};
    public static final int[] f = {1000, 2350, 3700, 5050};
    public static final Property<d, Float> g = new a(Float.class, "animationFraction");
    public static final Property<d, Float> h = new b(Float.class, "completeEndFraction");
    public ObjectAnimator i;
    public ObjectAnimator j;
    public final FastOutSlowInInterpolator k;
    public final BaseProgressIndicatorSpec l;
    public int m;
    public float n;
    public float o;
    public Animatable2Compat.AnimationCallback p;

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class a extends Property<d, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.n);
        }

        @Override // android.util.Property
        public void set(d dVar, Float f) {
            d dVar2 = dVar;
            float fFloatValue = f.floatValue();
            dVar2.n = fFloatValue;
            int i = (int) (5400.0f * fFloatValue);
            float[] fArr = dVar2.f1623b;
            float f2 = fFloatValue * 1520.0f;
            fArr[0] = (-20.0f) + f2;
            fArr[1] = f2;
            for (int i2 = 0; i2 < 4; i2++) {
                float fB = dVar2.b(i, d.d[i2], 667);
                float[] fArr2 = dVar2.f1623b;
                fArr2[1] = (dVar2.k.getInterpolation(fB) * 250.0f) + fArr2[1];
                float fB2 = dVar2.b(i, d.e[i2], 667);
                float[] fArr3 = dVar2.f1623b;
                fArr3[0] = (dVar2.k.getInterpolation(fB2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = dVar2.f1623b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * dVar2.o) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i3 = 0;
            while (true) {
                if (i3 >= 4) {
                    break;
                }
                float fB3 = dVar2.b(i, d.f[i3], 333);
                if (fB3 >= 0.0f && fB3 <= 1.0f) {
                    int i4 = i3 + dVar2.m;
                    int[] iArr = dVar2.l.indicatorColors;
                    int length = i4 % iArr.length;
                    int length2 = (length + 1) % iArr.length;
                    int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(iArr[length], dVar2.a.getAlpha());
                    int iCompositeARGBWithAlpha2 = MaterialColors.compositeARGBWithAlpha(dVar2.l.indicatorColors[length2], dVar2.a.getAlpha());
                    dVar2.c[0] = ArgbEvaluatorCompat.getInstance().evaluate2(dVar2.k.getInterpolation(fB3), Integer.valueOf(iCompositeARGBWithAlpha), Integer.valueOf(iCompositeARGBWithAlpha2)).intValue();
                    break;
                }
                i3++;
            }
            dVar2.a.invalidateSelf();
        }
    }

    /* compiled from: CircularIndeterminateAnimatorDelegate.java */
    public static class b extends Property<d, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(d dVar) {
            return Float.valueOf(dVar.o);
        }

        @Override // android.util.Property
        public void set(d dVar, Float f) {
            dVar.o = f.floatValue();
        }
    }

    public d(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.m = 0;
        this.p = null;
        this.l = circularProgressIndicatorSpec;
        this.k = new FastOutSlowInInterpolator();
    }

    @Override // b.i.a.g.g.g
    public void a() {
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // b.i.a.g.g.g
    public void c() {
        h();
    }

    @Override // b.i.a.g.g.g
    public void d(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        this.p = animationCallback;
    }

    @Override // b.i.a.g.g.g
    public void e() {
        if (this.j.isRunning()) {
            return;
        }
        if (this.a.isVisible()) {
            this.j.start();
        } else {
            a();
        }
    }

    @Override // b.i.a.g.g.g
    public void f() {
        if (this.i == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, g, 0.0f, 1.0f);
            this.i = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(5400L);
            this.i.setInterpolator(null);
            this.i.setRepeatCount(-1);
            this.i.addListener(new b.i.a.g.g.b(this));
        }
        if (this.j == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, h, 0.0f, 1.0f);
            this.j = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(333L);
            this.j.setInterpolator(this.k);
            this.j.addListener(new c(this));
        }
        h();
        this.i.start();
    }

    @Override // b.i.a.g.g.g
    public void g() {
        this.p = null;
    }

    @VisibleForTesting
    public void h() {
        this.m = 0;
        this.c[0] = MaterialColors.compositeARGBWithAlpha(this.l.indicatorColors[0], this.a.getAlpha());
        this.o = 0.0f;
    }
}
