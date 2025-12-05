package com.discord.utilities.animations;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.ranges.Ranges2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LottieAnimationUtils.kt */
/* renamed from: com.discord.utilities.animations.LoopAnimationListener, reason: use source file name */
/* loaded from: classes2.dex */
public final class LottieAnimationUtils implements ValueAnimator.AnimatorUpdateListener {
    private final LottieAnimationView animationView;
    private final Ranges2 loopFrames;
    private final int triggerFrame;

    public LottieAnimationUtils(LottieAnimationView lottieAnimationView, int i, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(lottieAnimationView, "animationView");
        Intrinsics3.checkNotNullParameter(ranges2, "loopFrames");
        this.animationView = lottieAnimationView;
        this.triggerFrame = i;
        this.loopFrames = ranges2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator animation) {
        if (this.animationView.getFrame() >= this.triggerFrame) {
            LottieAnimationView lottieAnimationView = this.animationView;
            lottieAnimationView.f14526p.m696p(this.loopFrames.getFirst(), this.loopFrames.getLast());
            this.animationView.f14526p.f2371l.f2293j.remove(this);
        }
    }
}
