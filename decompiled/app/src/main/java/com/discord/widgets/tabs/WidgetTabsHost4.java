package com.discord.widgets.tabs;

import android.animation.ValueAnimator;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetTabsHost.kt */
/* renamed from: com.discord.widgets.tabs.WidgetTabsHost$updateViews$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTabsHost4 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ WidgetTabsHost this$0;

    public WidgetTabsHost4(WidgetTabsHost widgetTabsHost) {
        this.this$0 = widgetTabsHost;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        TabsHostBottomNavigationView tabsHostBottomNavigationView = WidgetTabsHost.access$getBinding$p(this.this$0).f18219b;
        Intrinsics3.checkNotNullExpressionValue(tabsHostBottomNavigationView, "binding.widgetTabsHostBottomNavigationView");
        Intrinsics3.checkNotNullExpressionValue(valueAnimator, "animator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        tabsHostBottomNavigationView.setTranslationY(((Float) animatedValue).floatValue());
    }
}
