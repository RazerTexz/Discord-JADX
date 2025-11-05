package b.f.l.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import java.util.Objects;

/* compiled from: AnimatedZoomableController.java */
/* loaded from: classes3.dex */
public class b extends b.f.l.b.a {

    /* renamed from: s, reason: collision with root package name */
    public final ValueAnimator f649s;

    /* compiled from: AnimatedZoomableController.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            b bVar = b.this;
            Matrix matrix = bVar.r;
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                bVar.p[i] = (bVar.o[i] * fFloatValue) + ((1.0f - fFloatValue) * bVar.n[i]);
            }
            matrix.setValues(bVar.p);
            b bVar2 = b.this;
            Matrix matrix2 = bVar2.r;
            b.f.d.e.a.i(c.class, "setTransform");
            bVar2.h.set(matrix2);
            bVar2.i();
        }
    }

    /* compiled from: AnimatedZoomableController.java */
    /* renamed from: b.f.l.b.b$b, reason: collision with other inner class name */
    public class C0077b extends AnimatorListenerAdapter {
        public final /* synthetic */ Runnable a;

        public C0077b(Runnable runnable) {
            this.a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Objects.requireNonNull(b.this);
            b.f.d.e.a.i(b.class, "setTransformAnimated: animation cancelled");
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            b bVar = b.this;
            bVar.m = false;
            bVar.a.d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(b.this);
            b.f.d.e.a.i(b.class, "setTransformAnimated: animation finished");
            Runnable runnable = this.a;
            if (runnable != null) {
                runnable.run();
            }
            b bVar = b.this;
            bVar.m = false;
            bVar.a.d();
        }
    }

    @SuppressLint({"NewApi"})
    public b(b.f.l.a.b bVar) {
        super(bVar);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f649s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
    }

    @Override // b.f.l.b.a
    public Class<?> m() {
        return b.class;
    }

    @Override // b.f.l.b.a
    @SuppressLint({"NewApi"})
    public void n(Matrix matrix, long j, @Nullable Runnable runnable) {
        int i = b.f.d.e.a.a;
        o();
        b.c.a.a0.d.i(Boolean.valueOf(j > 0));
        b.c.a.a0.d.B(!this.m);
        this.m = true;
        this.f649s.setDuration(j);
        this.h.getValues(this.n);
        matrix.getValues(this.o);
        this.f649s.addUpdateListener(new a());
        this.f649s.addListener(new C0077b(runnable));
        this.f649s.start();
    }

    @Override // b.f.l.b.a
    @SuppressLint({"NewApi"})
    public void o() {
        if (this.m) {
            b.f.d.e.a.i(b.class, "stopAnimation");
            this.f649s.cancel();
            this.f649s.removeAllUpdateListeners();
            this.f649s.removeAllListeners();
        }
    }
}
