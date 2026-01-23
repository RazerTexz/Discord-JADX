package androidx.core.animation;

import android.animation.Animator;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$doOnStart$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    public final /* synthetic */ Function1 $onStart;

    public AnimatorKt$doOnStart$$inlined$addListener$default$1(Function1 function1) {
        this.$onStart = function1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
