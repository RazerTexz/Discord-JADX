package com.discord.utilities.animations;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.Result2;

/* compiled from: AnimationCoroutineUtils.kt */
/* renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt$await$$inlined$suspendCancellableCoroutine$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnimationCoroutineUtils3 extends AnimatorListenerAdapter {
    public final /* synthetic */ CancellableContinuation $cont;
    public final /* synthetic */ ViewPropertyAnimator $this_await$inlined;

    public AnimationCoroutineUtils3(CancellableContinuation cancellableContinuation, ViewPropertyAnimator viewPropertyAnimator) {
        this.$cont = cancellableContinuation;
        this.$this_await$inlined = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.mo10900a()) {
            this.$cont.mo10906k(null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$this_await$inlined.setListener(null);
        if (this.$cont.mo10900a()) {
            CancellableContinuation cancellableContinuation = this.$cont;
            Unit unit = Unit.f27425a;
            Result2.a aVar = Result2.f25169j;
            cancellableContinuation.resumeWith(Result2.m11474constructorimpl(unit));
        }
    }
}
