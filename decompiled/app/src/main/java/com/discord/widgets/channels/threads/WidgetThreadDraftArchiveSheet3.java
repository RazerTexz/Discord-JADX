package com.discord.widgets.channels.threads;

import android.view.View;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadDraftArchiveSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadArchiveActionsSheetBinding> {
    public static final WidgetThreadDraftArchiveSheet3 INSTANCE = new WidgetThreadDraftArchiveSheet3();

    public WidgetThreadDraftArchiveSheet3() {
        super(1, WidgetThreadArchiveActionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadArchiveActionsSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadArchiveActionsSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetThreadArchiveActionsSheetBinding.m8420a(view);
    }
}
