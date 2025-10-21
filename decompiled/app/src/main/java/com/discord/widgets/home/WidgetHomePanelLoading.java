package com.discord.widgets.home;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.i.WidgetHomePanelCenterBinding;
import b.a.i.WidgetHomePanelLoadingBinding;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHomeBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import d0.a0.MathJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHomePanelLoading.kt */
/* loaded from: classes2.dex */
public final class WidgetHomePanelLoading {
    private static boolean panelInitialized;
    private final WidgetHomeBinding binding;

    /* compiled from: WidgetHomePanelLoading.kt */
    /* renamed from: com.discord.widgets.home.WidgetHomePanelLoading$configure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetHomePanelLoading.access$setLoadingPanelVisibility(WidgetHomePanelLoading.this, z2, true);
        }
    }

    public WidgetHomePanelLoading(WidgetHomeBinding widgetHomeBinding) {
        Intrinsics3.checkNotNullParameter(widgetHomeBinding, "binding");
        this.binding = widgetHomeBinding;
        centerLogoRelativeToLoadingScreen();
    }

    public static final /* synthetic */ void access$setLoadingPanelVisibility(WidgetHomePanelLoading widgetHomePanelLoading, boolean z2, boolean z3) {
        widgetHomePanelLoading.setLoadingPanelVisibility(z2, z3);
    }

    private final void centerLogoRelativeToLoadingScreen() {
        ImageView imageView = this.binding.f2465b.f162b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.loading.logo");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        ImageView imageView2 = this.binding.f2465b.f162b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.loading.logo");
        Intrinsics3.checkNotNullExpressionValue(imageView2.getResources(), "binding.loading.logo.resources");
        layoutParams2.setMargins(((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin, MathJVM.roundToInt(DisplayUtils.getStatusBarHeight(r2) / (-2.0f)), ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        ImageView imageView3 = this.binding.f2465b.f162b;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.loading.logo");
        imageView3.setLayoutParams(layoutParams2);
    }

    private final void setLoadingPanelVisibility(boolean initialized, boolean animate) {
        WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding = this.binding.f2465b;
        Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLoadingBinding, "binding.loading");
        FrameLayout frameLayout = widgetHomePanelLoadingBinding.a;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.loading.root");
        if ((frameLayout.getVisibility() == 0) || !initialized) {
            panelInitialized = initialized;
            if (!initialized) {
                WidgetHomePanelCenterBinding widgetHomePanelCenterBinding = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout = widgetHomePanelCenterBinding.a;
                Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout, "binding.panelCenter.root");
                roundedRelativeLayout.setVisibility(8);
                WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding2 = this.binding.f2465b;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLoadingBinding2, "binding.loading");
                FrameLayout frameLayout2 = widgetHomePanelLoadingBinding2.a;
                Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.loading.root");
                frameLayout2.setVisibility(0);
                return;
            }
            if (animate) {
                WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding3 = this.binding.f2465b;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLoadingBinding3, "binding.loading");
                ViewExtensions.fadeOut$default(widgetHomePanelLoadingBinding3.a, 0L, null, null, 7, null);
                WidgetHomePanelCenterBinding widgetHomePanelCenterBinding2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding2, "binding.panelCenter");
                ViewExtensions.fadeIn$default(widgetHomePanelCenterBinding2.a, 0L, null, null, null, 15, null);
            } else {
                WidgetHomePanelLoadingBinding widgetHomePanelLoadingBinding4 = this.binding.f2465b;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelLoadingBinding4, "binding.loading");
                FrameLayout frameLayout3 = widgetHomePanelLoadingBinding4.a;
                Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.loading.root");
                frameLayout3.setVisibility(8);
                WidgetHomePanelCenterBinding widgetHomePanelCenterBinding3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(widgetHomePanelCenterBinding3, "binding.panelCenter");
                RoundedRelativeLayout roundedRelativeLayout2 = widgetHomePanelCenterBinding3.a;
                Intrinsics3.checkNotNullExpressionValue(roundedRelativeLayout2, "binding.panelCenter.root");
                roundedRelativeLayout2.setVisibility(0);
            }
            StoreStream.INSTANCE.getAnalytics().appUiViewed(WidgetHome.class);
        }
    }

    public final void configure(AppFragment fragment) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetHomeModel.INSTANCE.getInitialized(), fragment, null, 2, null), WidgetHomePanelLoading.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        setLoadingPanelVisibility(panelInitialized, false);
    }
}
