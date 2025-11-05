package com.discord.utilities.view.extensions;

import android.view.View;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes2.dex */
public final class ViewExtensions$sam$android_view_View_OnClickListener$0 implements View.OnClickListener {
    private final /* synthetic */ Function1 function;

    public ViewExtensions$sam$android_view_View_OnClickListener$0(Function1 function1) {
        this.function = function1;
    }

    @Override // android.view.View.OnClickListener
    public final /* synthetic */ void onClick(View view) {
        m.checkNotNullExpressionValue(this.function.invoke(view), "invoke(...)");
    }
}
