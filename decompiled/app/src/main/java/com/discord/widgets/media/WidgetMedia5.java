package com.discord.widgets.media;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMedia.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMedia5 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia5(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        Intrinsics3.checkNotNullParameter(animation, "animation");
        WidgetMedia.access$setControlsAnimationAction$p(this.this$0, null);
    }
}
