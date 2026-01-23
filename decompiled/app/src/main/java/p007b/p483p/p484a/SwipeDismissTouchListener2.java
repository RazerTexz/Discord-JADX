package p007b.p483p.p484a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.p.a.m, reason: use source file name */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SwipeDismissTouchListener2 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SwipeDismissTouchListener f14382a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup.LayoutParams f14383b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f14384c;

    public SwipeDismissTouchListener2(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams, int i) {
        this.f14382a = swipeDismissTouchListener;
        this.f14383b = layoutParams;
        this.f14384c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animation");
        SwipeDismissTouchListener swipeDismissTouchListener = this.f14382a;
        swipeDismissTouchListener.f14380u.onDismiss(swipeDismissTouchListener.f14379t);
        this.f14382a.f14379t.setAlpha(1.0f);
        this.f14382a.f14379t.setTranslationX(0.0f);
        ViewGroup.LayoutParams layoutParams = this.f14383b;
        layoutParams.height = this.f14384c;
        this.f14382a.f14379t.setLayoutParams(layoutParams);
    }
}
