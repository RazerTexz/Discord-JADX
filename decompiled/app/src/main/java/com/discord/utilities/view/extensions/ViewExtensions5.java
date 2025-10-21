package com.discord.utilities.view.extensions;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* compiled from: ViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.ViewExtensions$fadeOut$viewPropertyAnimator$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions5 implements Runnable {
    public final /* synthetic */ Function0 $onAnimationEnd;
    public final /* synthetic */ View $view;

    public ViewExtensions5(View view, Function0 function0) {
        this.$view = view;
        this.$onAnimationEnd = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$view.setVisibility(8);
        this.$onAnimationEnd.invoke();
    }
}
