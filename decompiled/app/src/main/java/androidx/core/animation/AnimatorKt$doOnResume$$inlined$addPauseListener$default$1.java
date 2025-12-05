package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$doOnResume$$inlined$addPauseListener$default$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ Function1 $onResume;

    public AnimatorKt$doOnResume$$inlined$addPauseListener$default$1(Function1 function1) {
        this.$onResume = function1;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
