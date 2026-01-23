package com.discord.utilities.animations;

import android.view.ViewPropertyAnimator;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p659s.p660a.CancellableContinuationImpl5;

/* JADX INFO: renamed from: com.discord.utilities.animations.AnimationCoroutineUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: AnimationCoroutineUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AnimationCoroutineUtils {
    public static final Object await(ViewPropertyAnimator viewPropertyAnimator, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        cancellableContinuationImpl5.mo10902f(new AnimationCoroutineUtils2(viewPropertyAnimator));
        viewPropertyAnimator.setListener(new AnimationCoroutineUtils3(cancellableContinuationImpl5, viewPropertyAnimator));
        viewPropertyAnimator.start();
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }
}
