package com.discord.utilities.display;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;

/* compiled from: DisplayUtils.kt */
/* renamed from: com.discord.utilities.display.DisplayUtils$NO_OP_WINDOW_INSETS_LISTENER$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class DisplayUtils2 implements OnApplyWindowInsetsListener {
    public static final DisplayUtils2 INSTANCE = new DisplayUtils2();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return windowInsetsCompat;
    }
}
