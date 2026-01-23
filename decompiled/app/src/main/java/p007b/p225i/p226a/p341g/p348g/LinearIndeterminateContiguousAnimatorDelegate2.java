package p007b.p225i.p226a.p341g.p348g;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.LinearProgressIndicatorSpec;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.g.g.j, reason: use source file name */
/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LinearIndeterminateContiguousAnimatorDelegate2 extends IndeterminateAnimatorDelegate<ObjectAnimator> {

    /* JADX INFO: renamed from: d */
    public static final Property<LinearIndeterminateContiguousAnimatorDelegate2, Float> f11743d = new a(Float.class, "animationFraction");

    /* JADX INFO: renamed from: e */
    public ObjectAnimator f11744e;

    /* JADX INFO: renamed from: f */
    public FastOutSlowInInterpolator f11745f;

    /* JADX INFO: renamed from: g */
    public final BaseProgressIndicatorSpec f11746g;

    /* JADX INFO: renamed from: h */
    public int f11747h;

    /* JADX INFO: renamed from: i */
    public boolean f11748i;

    /* JADX INFO: renamed from: j */
    public float f11749j;

    /* JADX INFO: renamed from: b.i.a.g.g.j$a */
    /* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
    public static class a extends Property<LinearIndeterminateContiguousAnimatorDelegate2, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2) {
            return Float.valueOf(linearIndeterminateContiguousAnimatorDelegate2.f11749j);
        }

        @Override // android.util.Property
        public void set(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2, Float f) {
            LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate22 = linearIndeterminateContiguousAnimatorDelegate2;
            float fFloatValue = f.floatValue();
            linearIndeterminateContiguousAnimatorDelegate22.f11749j = fFloatValue;
            linearIndeterminateContiguousAnimatorDelegate22.f11737b[0] = 0.0f;
            float fM6130b = linearIndeterminateContiguousAnimatorDelegate22.m6130b((int) (fFloatValue * 333.0f), 0, 667);
            float[] fArr = linearIndeterminateContiguousAnimatorDelegate22.f11737b;
            float interpolation = linearIndeterminateContiguousAnimatorDelegate22.f11745f.getInterpolation(fM6130b);
            fArr[2] = interpolation;
            fArr[1] = interpolation;
            float[] fArr2 = linearIndeterminateContiguousAnimatorDelegate22.f11737b;
            float interpolation2 = linearIndeterminateContiguousAnimatorDelegate22.f11745f.getInterpolation(fM6130b + 0.49925038f);
            fArr2[4] = interpolation2;
            fArr2[3] = interpolation2;
            float[] fArr3 = linearIndeterminateContiguousAnimatorDelegate22.f11737b;
            fArr3[5] = 1.0f;
            if (linearIndeterminateContiguousAnimatorDelegate22.f11748i && fArr3[3] < 1.0f) {
                int[] iArr = linearIndeterminateContiguousAnimatorDelegate22.f11738c;
                iArr[2] = iArr[1];
                iArr[1] = iArr[0];
                iArr[0] = MaterialColors.compositeARGBWithAlpha(linearIndeterminateContiguousAnimatorDelegate22.f11746g.indicatorColors[linearIndeterminateContiguousAnimatorDelegate22.f11747h], linearIndeterminateContiguousAnimatorDelegate22.f11736a.getAlpha());
                linearIndeterminateContiguousAnimatorDelegate22.f11748i = false;
            }
            linearIndeterminateContiguousAnimatorDelegate22.f11736a.invalidateSelf();
        }
    }

    public LinearIndeterminateContiguousAnimatorDelegate2(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.f11747h = 1;
        this.f11746g = linearProgressIndicatorSpec;
        this.f11745f = new FastOutSlowInInterpolator();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: a */
    public void mo6123a() {
        ObjectAnimator objectAnimator = this.f11744e;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: c */
    public void mo6124c() {
        m6132h();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: d */
    public void mo6125d(@Nullable Animatable2Compat.AnimationCallback animationCallback) {
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: e */
    public void mo6126e() {
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: f */
    public void mo6127f() {
        if (this.f11744e == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f11743d, 0.0f, 1.0f);
            this.f11744e = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(333L);
            this.f11744e.setInterpolator(null);
            this.f11744e.setRepeatCount(-1);
            this.f11744e.addListener(new LinearIndeterminateContiguousAnimatorDelegate(this));
        }
        m6132h();
        this.f11744e.start();
    }

    @Override // p007b.p225i.p226a.p341g.p348g.IndeterminateAnimatorDelegate
    /* JADX INFO: renamed from: g */
    public void mo6128g() {
    }

    @VisibleForTesting
    /* JADX INFO: renamed from: h */
    public void m6132h() {
        this.f11748i = true;
        this.f11747h = 1;
        Arrays.fill(this.f11738c, MaterialColors.compositeARGBWithAlpha(this.f11746g.indicatorColors[0], this.f11736a.getAlpha()));
    }
}
