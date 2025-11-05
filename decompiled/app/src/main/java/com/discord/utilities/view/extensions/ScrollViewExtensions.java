package com.discord.utilities.view.extensions;

import android.widget.ScrollView;
import d0.z.d.Intrinsics3;

/* compiled from: ScrollViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.ScrollViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ScrollViewExtensions {
    public static final void flashScrollBars(ScrollView scrollView) {
        Intrinsics3.checkNotNullParameter(scrollView, "$this$flashScrollBars");
        scrollView.scrollBy(0, 1);
        scrollView.scrollBy(0, -1);
    }
}
