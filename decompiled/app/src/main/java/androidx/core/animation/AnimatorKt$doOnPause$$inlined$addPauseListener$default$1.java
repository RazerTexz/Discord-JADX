package androidx.core.animation;

import android.animation.Animator;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$doOnPause$$inlined$addPauseListener$default$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ Function1 $onPause;

    public AnimatorKt$doOnPause$$inlined$addPauseListener$default$1(Function1 function1) {
        this.$onPause = function1;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }
}
