package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout;
import d0.z.d.m;

/* compiled from: LayoutParamsExtensions.kt */
/* loaded from: classes2.dex */
public final class LayoutParamsExtensionsKt {
    public static final void removeRuleCompat(RelativeLayout.LayoutParams layoutParams, int i) {
        m.checkNotNullParameter(layoutParams, "$this$removeRuleCompat");
        layoutParams.removeRule(i);
    }
}
