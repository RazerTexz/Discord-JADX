package com.discord.widgets.guildscheduledevent;

import android.view.View;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetEndGuildScheduledEventBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetEndStageBottomSheetBinding> {
    public static final WidgetEndGuildScheduledEventBottomSheet3 INSTANCE = new WidgetEndGuildScheduledEventBottomSheet3();

    public WidgetEndGuildScheduledEventBottomSheet3() {
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
