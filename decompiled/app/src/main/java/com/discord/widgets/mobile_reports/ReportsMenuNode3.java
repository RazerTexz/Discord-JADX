package com.discord.widgets.mobile_reports;

import android.view.View;
import com.discord.api.report.ReportNodeChild;

/* compiled from: ReportsMenuNode.kt */
/* renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupChildren$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ReportsMenuNode3 implements View.OnClickListener {
    public final /* synthetic */ ReportNodeChild $child$inlined;
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode3(ReportNodeChild reportNodeChild, ReportsMenuNode reportsMenuNode) {
        this.$child$inlined = reportNodeChild;
        this.this$0 = reportsMenuNode;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ReportsMenuNode.access$childClickListener(this.this$0, this.$child$inlined);
    }
}
