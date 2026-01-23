package com.discord.widgets.mobile_reports;

import androidx.core.app.NotificationCompat;
import com.discord.api.report.ReportNodeElementData;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: com.discord.widgets.mobile_reports.ReportsMenuNode$setupCheckbox$$inlined$forEach$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: ReportsMenuNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportsMenuNode2<T> implements Action1<Boolean> {
    public final /* synthetic */ MobileReportsViewModel.CheckboxElement $checkboxData$inlined;
    public final /* synthetic */ ReportNodeElementData $entry$inlined;
    public final /* synthetic */ ReportsMenuNode this$0;

    public ReportsMenuNode2(ReportNodeElementData reportNodeElementData, ReportsMenuNode reportsMenuNode, MobileReportsViewModel.CheckboxElement checkboxElement) {
        this.$entry$inlined = reportNodeElementData;
        this.this$0 = reportsMenuNode;
        this.$checkboxData$inlined = checkboxElement;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
        if (bool.booleanValue()) {
            this.$checkboxData$inlined.getSelections().add(this.$entry$inlined);
        } else {
            this.$checkboxData$inlined.getSelections().remove(this.$entry$inlined);
        }
    }
}
