package com.discord.utilities.view.layoutparams;

import android.widget.RelativeLayout;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LayoutParamsExtensions.kt */
/* renamed from: com.discord.utilities.view.layoutparams.LayoutParamsExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class LayoutParamsExtensions {
    public static final void removeRuleCompat(RelativeLayout.LayoutParams layoutParams, int i) {
        Intrinsics3.checkNotNullParameter(layoutParams, "$this$removeRuleCompat");
        layoutParams.removeRule(i);
    }
}
