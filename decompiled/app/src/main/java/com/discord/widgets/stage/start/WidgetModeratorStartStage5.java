package com.discord.widgets.stage.start;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetModeratorStartStage.kt */
/* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$previewLauncher$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetModeratorStartStage5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetModeratorStartStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetModeratorStartStage5(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(0);
        this.this$0 = widgetModeratorStartStage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
