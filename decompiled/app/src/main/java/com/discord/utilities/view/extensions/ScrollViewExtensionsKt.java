package com.discord.utilities.view.extensions;

import android.widget.ScrollView;
import d0.z.d.m;

/* compiled from: ScrollViewExtensions.kt */
/* loaded from: classes2.dex */
public final class ScrollViewExtensionsKt {
    public static final void flashScrollBars(ScrollView scrollView) {
        m.checkNotNullParameter(scrollView, "$this$flashScrollBars");
        scrollView.scrollBy(0, 1);
        scrollView.scrollBy(0, -1);
    }
}
