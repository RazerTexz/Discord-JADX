package com.discord.utilities.animations;

import android.view.ViewPropertyAnimator;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.DebugProbes;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import s.a.CancellableContinuationImpl5;

/* compiled from: AnimationCoroutineUtils.kt */
/* renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class AnimationCoroutineUtils {
    public static final Object await(ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.A();
        cancellableContinuationImpl5.f(new AnimationCoroutineUtils2(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimationCoroutineUtils3(cancellableContinuationImpl5, viewPropertyAnimator));
        viewPropertyAnimator.start();
        Object objU = cancellableContinuationImpl5.u();
        if (objU == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objU;
    }
}
