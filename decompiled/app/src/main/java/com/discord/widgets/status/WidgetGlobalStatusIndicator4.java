package com.discord.widgets.status;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetGlobalStatusIndicator.kt */
/* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$connectingVectorReplayCallback$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator4 extends Animatable2Compat.AnimationCallback {
    public final /* synthetic */ WidgetGlobalStatusIndicator this$0;

    public WidgetGlobalStatusIndicator4(WidgetGlobalStatusIndicator widgetGlobalStatusIndicator) {
        this.this$0 = widgetGlobalStatusIndicator;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        Intrinsics3.checkNotNullParameter(drawable, "drawable");
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatAccess$getConnectingVector$p = WidgetGlobalStatusIndicator.access$getConnectingVector$p(this.this$0);
        if (animatedVectorDrawableCompatAccess$getConnectingVector$p != null) {
            animatedVectorDrawableCompatAccess$getConnectingVector$p.start();
        }
    }
}
