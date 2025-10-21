package com.discord.widgets.bugreports;

import com.discord.api.bugreport.BugReportConfig2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetBugReport.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetBugReport$featuresAdapter$1 extends FunctionReferenceImpl implements Function1<BugReportConfig2, Unit> {
    public WidgetBugReport$featuresAdapter$1(WidgetBugReport widgetBugReport) {
        super(1, widgetBugReport, WidgetBugReport.class, "onFeatureClickListener", "onFeatureClickListener(Lcom/discord/api/bugreport/Feature;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(BugReportConfig2 bugReportConfig2) {
        invoke2(bugReportConfig2);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BugReportConfig2 bugReportConfig2) {
        Intrinsics3.checkNotNullParameter(bugReportConfig2, "p1");
        ((WidgetBugReport) this.receiver).onFeatureClickListener(bugReportConfig2);
    }
}
