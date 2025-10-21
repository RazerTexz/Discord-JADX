package androidx.core.transition;

import android.transition.Transition;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: Transition.kt */
/* renamed from: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition8 implements Transition.TransitionListener {
    public final /* synthetic */ Function1 $onStart;

    public Transition8(Function1 function1) {
        this.$onStart = function1;
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
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Intrinsics3.checkNotNullParameter(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
