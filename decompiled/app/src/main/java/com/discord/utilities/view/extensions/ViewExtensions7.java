package com.discord.utilities.view.extensions;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.view.extensions.ViewExtensions$sam$android_widget_TextView_OnEditorActionListener$0, reason: use source file name */
/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions7 implements TextView.OnEditorActionListener {
    private final /* synthetic */ Function3 function;

    public ViewExtensions7(Function3 function3) {
        this.function = function3;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final /* synthetic */ boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Object objInvoke = this.function.invoke(textView, Integer.valueOf(i), keyEvent);
        Intrinsics3.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Boolean) objInvoke).booleanValue();
    }
}
