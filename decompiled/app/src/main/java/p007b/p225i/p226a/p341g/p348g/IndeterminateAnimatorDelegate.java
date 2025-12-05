package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.IndeterminateDrawable;

/* compiled from: IndeterminateAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.g, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class IndeterminateAnimatorDelegate<T extends Animator> {

    /* renamed from: a */
    public IndeterminateDrawable f11736a;

    /* renamed from: b */
    public final float[] f11737b;

    /* renamed from: c */
    public final int[] f11738c;

    public IndeterminateAnimatorDelegate(int i) {
        this.f11737b = new float[i * 2];
        this.f11738c = new int[i];
    }

    /* renamed from: a */
    public abstract void mo6123a();

    /* renamed from: b */
    public float m6130b(int i, int i2, int i3) {
        return (i - i2) / i3;
    }

    /* renamed from: c */
    public abstract void mo6124c();

    /* renamed from: d */
    public abstract void mo6125d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    /* renamed from: e */
    public abstract void mo6126e();

    /* renamed from: f */
    public abstract void mo6127f();

    /* renamed from: g */
    public abstract void mo6128g();
}
