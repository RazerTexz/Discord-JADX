package androidx.core.transition;

import android.transition.Transition;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1, reason: use source file name */
/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Transition5 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onEnd;

    public Transition5(Function1 function1) {
        this.$onEnd = function1;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }
}
