package com.discord.widgets.stage.start;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetModeratorStartStage.kt */
/* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetModeratorStartStage6 extends Lambda implements Function0<ModeratorStartStageViewModel> {
    public final /* synthetic */ WidgetModeratorStartStage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetModeratorStartStage6(WidgetModeratorStartStage widgetModeratorStartStage) {
        super(0);
        this.this$0 = widgetModeratorStartStage;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ModeratorStartStageViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ModeratorStartStageViewModel invoke() {
        return new ModeratorStartStageViewModel(WidgetModeratorStartStage.access$getChannelId$p(this.this$0), null, null, null, null, null, null, 126, null);
    }
}
