package b.p.a;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import java.util.Objects;

/* compiled from: SwipeDismissTouchListener.kt */
/* loaded from: classes3.dex */
public final class n implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ l a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f1976b;

    public n(l lVar, ViewGroup.LayoutParams layoutParams) {
        this.a = lVar;
        this.f1976b = layoutParams;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ViewGroup.LayoutParams layoutParams = this.f1976b;
        d0.z.d.m.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        this.a.t.setLayoutParams(this.f1976b);
    }
}
