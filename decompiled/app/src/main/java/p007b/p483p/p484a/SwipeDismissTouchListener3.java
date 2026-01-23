package p007b.p483p.p484a;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.p.a.n, reason: use source file name */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SwipeDismissTouchListener3 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SwipeDismissTouchListener f14385a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup.LayoutParams f14386b;

    public SwipeDismissTouchListener3(SwipeDismissTouchListener swipeDismissTouchListener, ViewGroup.LayoutParams layoutParams) {
        this.f14385a = swipeDismissTouchListener;
        this.f14386b = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f14386b;
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.f14385a.f14379t.setLayoutParams(this.f14386b);
    }
}
