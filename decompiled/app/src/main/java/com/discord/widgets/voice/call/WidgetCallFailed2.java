package com.discord.widgets.voice.call;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetCallFailed.kt */
/* renamed from: com.discord.widgets.voice.call.WidgetCallFailed$binding$2, reason: use source file name */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFailed2 extends FunctionReferenceImpl implements Function1<View, ViewDialogConfirmationBinding> {
    public static final WidgetCallFailed2 INSTANCE = new WidgetCallFailed2();

    public WidgetCallFailed2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewDialogConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewDialogConfirmationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.m8393a(view);
    }
}
