package com.discord.widgets.mobile_reports;

import com.discord.api.report.ReportNodeElementData;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: MobileReportsBreadcrumbs.kt */
/* renamed from: com.discord.widgets.mobile_reports.MobileReportsBreadcrumbs$setup$1$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MobileReportsBreadcrumbs2 extends Lambda implements Function1<ReportNodeElementData, CharSequence> {
    public static final MobileReportsBreadcrumbs2 INSTANCE = new MobileReportsBreadcrumbs2();

    public MobileReportsBreadcrumbs2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(ReportNodeElementData reportNodeElementData) {
        return invoke2(reportNodeElementData);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(ReportNodeElementData reportNodeElementData) {
        Intrinsics3.checkNotNullParameter(reportNodeElementData, "data");
        return reportNodeElementData.getElementValue();
    }
}
