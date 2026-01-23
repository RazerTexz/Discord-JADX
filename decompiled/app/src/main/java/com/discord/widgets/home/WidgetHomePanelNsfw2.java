package com.discord.widgets.home;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomePanelNsfw$toggleContainerVisibility$1$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomePanelNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
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
