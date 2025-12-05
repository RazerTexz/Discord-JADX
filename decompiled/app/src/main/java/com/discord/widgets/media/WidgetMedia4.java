package com.discord.widgets.media;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetMedia.kt */
/* renamed from: com.discord.widgets.media.WidgetMedia$configureAndStartControlsAnimation$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMedia4 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WidgetMedia this$0;

    public WidgetMedia4(WidgetMedia widgetMedia) {
        this.this$0 = widgetMedia;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        AppBarLayout appBarLayout = WidgetMedia.access$getBinding$p(this.this$0).f17229b;
        Intrinsics3.checkNotNullExpressionValue(appBarLayout, "binding.actionBarToolbarLayout");
        appBarLayout.setTranslationY(fFloatValue);
        if (!WidgetMedia.access$isVideo(this.this$0) || WidgetMedia.access$getPlayerControlsHeight$p(this.this$0) <= 0) {
            return;
        }
        PlayerControlView playerControlView = WidgetMedia.access$getBinding$p(this.this$0).f17233f;
        Intrinsics3.checkNotNullExpressionValue(playerControlView, "binding.mediaPlayerControlView");
        playerControlView.setTranslationY((-fFloatValue) / (WidgetMedia.access$getToolbarHeight$p(this.this$0) / WidgetMedia.access$getPlayerControlsHeight$p(this.this$0)));
    }
}
