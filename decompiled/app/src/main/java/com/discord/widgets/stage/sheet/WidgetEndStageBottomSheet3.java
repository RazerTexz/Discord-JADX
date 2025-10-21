package com.discord.widgets.stage.sheet;

import android.view.View;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEndStageBottomSheet.kt */
/* renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEndStageBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetEndStageBottomSheetBinding> {
    public static final WidgetEndStageBottomSheet3 INSTANCE = new WidgetEndStageBottomSheet3();

    public WidgetEndStageBottomSheet3() {
        super(1, WidgetEndStageBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEndStageBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEndStageBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        return WidgetEndStageBottomSheetBinding.a(view);
    }
}
