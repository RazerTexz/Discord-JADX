package com.discord.utilities.view.extensions;

import android.view.View;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.ViewExtensions$sam$android_view_View_OnClickListener$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions6 implements View.OnClickListener {
    private final /* synthetic */ Function1 function;

    public ViewExtensions6(Function1 function1) {
        this.function = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
