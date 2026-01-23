package com.discord.widgets.home;

import android.view.View;
import com.discord.databinding.ViewDialogConfirmationBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetMainSurveyDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMainSurveyDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMainSurveyDialog2 extends FunctionReferenceImpl implements Function1<View, ViewDialogConfirmationBinding> {
    public static final WidgetMainSurveyDialog2 INSTANCE = new WidgetMainSurveyDialog2();

    public WidgetMainSurveyDialog2() {
        super(1, ViewDialogConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewDialogConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewDialogConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewDialogConfirmationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return ViewDialogConfirmationBinding.m8393a(view);
    }
}
