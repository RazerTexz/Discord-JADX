package com.discord.utilities.view.extensions;

import kotlin.jvm.functions.Function0;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes2.dex */
public final class ViewExtensions$fadeIn$viewPropertyAnimator$1 implements Runnable {
    public final /* synthetic */ Function0 $onAnimationEnd;

    public ViewExtensions$fadeIn$viewPropertyAnimator$1(Function0 function0) {
        this.$onAnimationEnd = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$onAnimationEnd.invoke();
    }
}
