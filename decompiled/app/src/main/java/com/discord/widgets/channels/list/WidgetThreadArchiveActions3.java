package com.discord.widgets.channels.list;

import android.view.View;
import com.discord.databinding.WidgetThreadArchiveActionsSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetThreadArchiveActions.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetThreadArchiveActions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadArchiveActions3 extends FunctionReferenceImpl implements Function1<View, WidgetThreadArchiveActionsSheetBinding> {
    public static final WidgetThreadArchiveActions3 INSTANCE = new WidgetThreadArchiveActions3();

    public WidgetThreadArchiveActions3() {
        super(1, WidgetThreadArchiveActionsSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadArchiveActionsSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadArchiveActionsSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadArchiveActionsSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetThreadArchiveActionsSheetBinding.m8420a(view);
    }
}
