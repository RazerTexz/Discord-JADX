package com.discord.widgets.media;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetMedia.kt */
/* renamed from: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
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
