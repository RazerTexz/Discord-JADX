package com.discord.widgets.tos;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetTosReportViolation.kt */
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation5 extends Lambda implements Function0<WidgetTosReportViolationViewModel> {
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTosReportViolation5(WidgetTosReportViolation widgetTosReportViolation) {
        super(0);
        this.this$0 = widgetTosReportViolation;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetTosReportViolationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetTosReportViolationViewModel invoke() {
        return new WidgetTosReportViolationViewModel(WidgetTosReportViolation.access$getArgs$p(this.this$0).getChannelId(), WidgetTosReportViolation.access$getArgs$p(this.this$0).getMessageId());
    }
}
