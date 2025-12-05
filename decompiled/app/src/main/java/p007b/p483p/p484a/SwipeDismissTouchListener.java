package p007b.p483p.p484a;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SwipeDismissTouchListener.kt */
/* renamed from: b.p.a.l, reason: use source file name */
/* loaded from: classes3.dex */
public final class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: j */
    public final int f14369j;

    /* renamed from: k */
    public final int f14370k;

    /* renamed from: l */
    public final long f14371l;

    /* renamed from: m */
    public int f14372m;

    /* renamed from: n */
    public float f14373n;

    /* renamed from: o */
    public float f14374o;

    /* renamed from: p */
    public boolean f14375p;

    /* renamed from: q */
    public int f14376q;

    /* renamed from: r */
    public VelocityTracker f14377r;

    /* renamed from: s */
    public float f14378s;

    /* renamed from: t */
    public final View f14379t;

    /* renamed from: u */
    public final a f14380u;

    /* compiled from: SwipeDismissTouchListener.kt */
    /* renamed from: b.p.a.l$a */
    public interface a {
        /* renamed from: a */
        void mo7463a(View view, boolean z2);

        /* renamed from: b */
        boolean mo7464b();

        void onDismiss(View view);
    }

    /* compiled from: SwipeDismissTouchListener.kt */
    /* renamed from: b.p.a.l$b */
    public static final class b extends AnimatorListenerAdapter {
        public b(MotionEvent motionEvent, View view) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animation");
            SwipeDismissTouchListener swipeDismissTouchListener = SwipeDismissTouchListener.this;
            ViewGroup.LayoutParams layoutParams = swipeDismissTouchListener.f14379t.getLayoutParams();
            int height = swipeDismissTouchListener.f14379t.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(swipeDismissTouchListener.f14371l);
            duration.addListener(new SwipeDismissTouchListener2(swipeDismissTouchListener, layoutParams, height));
            duration.addUpdateListener(new SwipeDismissTouchListener3(swipeDismissTouchListener, layoutParams));
            duration.start();
        }
    }

    public SwipeDismissTouchListener(View view, a aVar) {
        Intrinsics3.checkNotNullParameter(view, "mView");
        Intrinsics3.checkNotNullParameter(aVar, "mCallbacks");
        this.f14379t = view;
        this.f14380u = aVar;
        this.f14372m = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Intrinsics3.checkNotNullExpressionValue(viewConfiguration, "vc");
        this.f14369j = viewConfiguration.getScaledTouchSlop();
        this.f14370k = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        Intrinsics3.checkNotNullExpressionValue(view.getContext(), "mView.context");
        this.f14371l = r2.getResources().getInteger(R.integer.config_shortAnimTime);
    }

    @Override // android.view.View.OnTouchListener
    @RequiresApi(api = 12)
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(motionEvent, "motionEvent");
        motionEvent.offsetLocation(this.f14378s, 0.0f);
        if (this.f14372m < 2) {
            this.f14372m = this.f14379t.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f14373n = motionEvent.getRawX();
            this.f14374o = motionEvent.getRawY();
            if (this.f14380u.mo7464b()) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.f14377r = velocityTrackerObtain;
                Intrinsics3.checkNotNull(velocityTrackerObtain);
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f14380u.mo7463a(view, true);
            return false;
        }
        if (actionMasked == 1) {
            VelocityTracker velocityTracker = this.f14377r;
            if (velocityTracker != null) {
                float rawX = motionEvent.getRawX() - this.f14373n;
                velocityTracker.addMovement(motionEvent);
                velocityTracker.computeCurrentVelocity(1000);
                float xVelocity = velocityTracker.getXVelocity();
                float fAbs = Math.abs(xVelocity);
                float fAbs2 = Math.abs(velocityTracker.getYVelocity());
                if (Math.abs(rawX) > this.f14372m / 2 && this.f14375p) {
                    z2 = rawX > ((float) 0);
                } else if (this.f14370k > fAbs || fAbs2 >= fAbs || !this.f14375p) {
                    z2 = false;
                    z = false;
                } else {
                    float f = 0;
                    boolean z3 = ((xVelocity > f ? 1 : (xVelocity == f ? 0 : -1)) < 0) == ((rawX > f ? 1 : (rawX == f ? 0 : -1)) < 0);
                    z2 = velocityTracker.getXVelocity() > f;
                    z = z3;
                }
                if (z) {
                    this.f14379t.animate().translationX(z2 ? this.f14372m : -this.f14372m).alpha(0.0f).setDuration(this.f14371l).setListener(new b(motionEvent, view));
                } else if (this.f14375p) {
                    this.f14379t.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f14371l).setListener(null);
                    this.f14380u.mo7463a(view, false);
                }
                velocityTracker.recycle();
                this.f14377r = null;
                this.f14378s = 0.0f;
                this.f14373n = 0.0f;
                this.f14374o = 0.0f;
                this.f14375p = false;
            }
        } else if (actionMasked == 2) {
            VelocityTracker velocityTracker2 = this.f14377r;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
                float rawX2 = motionEvent.getRawX() - this.f14373n;
                float rawY = motionEvent.getRawY() - this.f14374o;
                if (Math.abs(rawX2) > this.f14369j && Math.abs(rawY) < Math.abs(rawX2) / 2) {
                    this.f14375p = true;
                    this.f14376q = rawX2 > ((float) 0) ? this.f14369j : -this.f14369j;
                    this.f14379t.getParent().requestDisallowInterceptTouchEvent(true);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    Intrinsics3.checkNotNullExpressionValue(motionEventObtain, "cancelEvent");
                    motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                    this.f14379t.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (this.f14375p) {
                    this.f14378s = rawX2;
                    this.f14379t.setTranslationX(rawX2 - this.f14376q);
                    this.f14379t.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX2) * 2.0f) / this.f14372m))));
                    return true;
                }
            }
        } else {
            if (actionMasked != 3) {
                view.performClick();
                return false;
            }
            VelocityTracker velocityTracker3 = this.f14377r;
            if (velocityTracker3 != null) {
                this.f14379t.animate().translationX(0.0f).alpha(1.0f).setDuration(this.f14371l).setListener(null);
                velocityTracker3.recycle();
                this.f14377r = null;
                this.f14378s = 0.0f;
                this.f14373n = 0.0f;
                this.f14374o = 0.0f;
                this.f14375p = false;
            }
        }
        return false;
    }
}
