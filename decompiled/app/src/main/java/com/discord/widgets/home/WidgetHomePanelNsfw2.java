package com.discord.widgets.home;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.Intrinsics3;

/* compiled from: WidgetHomePanelNsfw.kt */
/* renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomePanelNsfw2 implements OnApplyWindowInsetsListener {
    public static final WidgetHomePanelNsfw2 INSTANCE = new WidgetHomePanelNsfw2();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
