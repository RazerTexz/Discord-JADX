package p007b.p109f.p187l.p189b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p187l.p188a.TransformGestureDetector;

/* JADX INFO: renamed from: b.f.l.b.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatedZoomableController.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnimatedZoomableController extends AbstractAnimatedZoomableController {

    /* JADX INFO: renamed from: s */
    public final ValueAnimator f4295s;

    /* JADX INFO: renamed from: b.f.l.b.b$a */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            Matrix matrix = animatedZoomableController.f4294r;
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            for (int i = 0; i < 9; i++) {
                animatedZoomableController.f4292p[i] = (animatedZoomableController.f4291o[i] * fFloatValue) + ((1.0f - fFloatValue) * animatedZoomableController.f4290n[i]);
            }
            matrix.setValues(animatedZoomableController.f4292p);
            AnimatedZoomableController animatedZoomableController2 = AnimatedZoomableController.this;
            Matrix matrix2 = animatedZoomableController2.f4294r;
            FLog.m981i(DefaultZoomableController.class, "setTransform");
            animatedZoomableController2.f4306h.set(matrix2);
            animatedZoomableController2.m1563i();
        }
    }

    /* JADX INFO: renamed from: b.f.l.b.b$b */
    /* JADX INFO: compiled from: AnimatedZoomableController.java */
    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Runnable f4297a;

        public b(Runnable runnable) {
            this.f4297a = runnable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Objects.requireNonNull(AnimatedZoomableController.this);
            FLog.m981i(AnimatedZoomableController.class, "setTransformAnimated: animation cancelled");
            Runnable runnable = this.f4297a;
            if (runnable != null) {
                runnable.run();
            }
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            animatedZoomableController.f4289m = false;
            animatedZoomableController.f4299a.m1548d();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(AnimatedZoomableController.this);
            FLog.m981i(AnimatedZoomableController.class, "setTransformAnimated: animation finished");
            Runnable runnable = this.f4297a;
            if (runnable != null) {
                runnable.run();
            }
            AnimatedZoomableController animatedZoomableController = AnimatedZoomableController.this;
            animatedZoomableController.f4289m = false;
            animatedZoomableController.f4299a.m1548d();
        }
    }

    @SuppressLint({"NewApi"})
    public AnimatedZoomableController(TransformGestureDetector transformGestureDetector) {
        super(transformGestureDetector);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f4295s = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator());
    }

    @Override // p007b.p109f.p187l.p189b.AbstractAnimatedZoomableController
    /* JADX INFO: renamed from: m */
    public Class<?> mo1553m() {
        return AnimatedZoomableController.class;
    }

    @Override // p007b.p109f.p187l.p189b.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: n */
    public void mo1554n(Matrix matrix, long j, @Nullable Runnable runnable) {
        int i = FLog.f3102a;
        mo1555o();
        AnimatableValueParser.m527i(Boolean.valueOf(j > 0));
        AnimatableValueParser.m419B(!this.f4289m);
        this.f4289m = true;
        this.f4295s.setDuration(j);
        this.f4306h.getValues(this.f4290n);
        matrix.getValues(this.f4291o);
        this.f4295s.addUpdateListener(new a());
        this.f4295s.addListener(new b(runnable));
        this.f4295s.start();
    }

    @Override // p007b.p109f.p187l.p189b.AbstractAnimatedZoomableController
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: o */
    public void mo1555o() {
        if (this.f4289m) {
            FLog.m981i(AnimatedZoomableController.class, "stopAnimation");
            this.f4295s.cancel();
            this.f4295s.removeAllUpdateListeners();
            this.f4295s.removeAllListeners();
        }
    }
}
