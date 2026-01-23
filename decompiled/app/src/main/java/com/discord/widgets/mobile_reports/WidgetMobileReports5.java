package com.discord.widgets.mobile_reports;

import java.lang.ref.WeakReference;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports5 extends Lambda implements Function0<MobileReportsViewModel> {
    public final /* synthetic */ WidgetMobileReports this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMobileReports5(WidgetMobileReports widgetMobileReports) {
        super(0);
        this.this$0 = widgetMobileReports;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MobileReportsViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MobileReportsViewModel invoke() {
        return new MobileReportsViewModel(new WeakReference(this.this$0.requireContext()), WidgetMobileReports.access$getArgs$p(this.this$0), null, null, null, 28, null);
    }
}
