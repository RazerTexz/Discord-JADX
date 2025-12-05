package com.discord.utilities.view.extensions;

import androidx.recyclerview.widget.RecyclerView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RecyclerViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.RecyclerViewExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RecyclerViewExtensions {
    public static final void ignoreCurrentTouch(RecyclerView recyclerView) {
        Intrinsics3.checkNotNullParameter(recyclerView, "$this$ignoreCurrentTouch");
        recyclerView.suppressLayout(true);
        recyclerView.suppressLayout(false);
    }
}
