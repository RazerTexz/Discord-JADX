package com.discord.utilities.anim;

import android.animation.Animator;
import d0.z.d.Intrinsics3;

/* compiled from: Animator.kt */
/* loaded from: classes2.dex */
public final class RingAnimator$$special$$inlined$apply$lambda$1 implements Animator.AnimatorListener {
    public final /* synthetic */ RingAnimator this$0;

    public RingAnimator$$special$$inlined$apply$lambda$1(RingAnimator ringAnimator) {
        this.this$0 = ringAnimator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        RingAnimator.access$setAnimating$p(this.this$0, false);
        this.this$0.onUpdate();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }
}
