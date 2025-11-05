package androidx.core.transition;

import android.transition.Transition;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: Transition.kt */
/* renamed from: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition7 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onResume;

    public Transition7(Function1 function1) {
        this.$onResume = function1;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
    }
}
