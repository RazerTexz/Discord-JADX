package com.discord.utilities.view.extensions;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeIn$viewPropertyAnimator$1, reason: use source file name */
/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions4 implements Runnable {
    public final /* synthetic */ Function0 $onAnimationEnd;

    public ViewExtensions4(Function0 function0) {
        this.$onAnimationEnd = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$onAnimationEnd.invoke();
    }
}
