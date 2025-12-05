package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import com.discord.api.report.ReportReason;
import com.discord.views.LoadingButton;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetTosReportViolation.kt */
/* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation4 implements View.OnClickListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    public WidgetTosReportViolation4(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, ReportReason reportReason, WidgetTosReportViolation widgetTosReportViolation) {
        this.$reasonView$inlined = widgetTosReportViolationReasonView;
        this.$reason$inlined = reportReason;
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (!Intrinsics3.areEqual(WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected(), this.$reasonView$inlined.getReason())) {
            WidgetTosReportViolation.access$getViewModel$p(this.this$0).setReasonSelected(this.$reasonView$inlined.getReason());
            LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(this.this$0).f18302b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
            loadingButton.setEnabled(false);
            LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(this.this$0).f18304d;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
            for (View view2 : ViewGroup.getChildren(linearLayout)) {
                Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                ((WidgetTosReportViolationReasonView) view2).setChecked(false);
            }
            this.$reasonView$inlined.setChecked(true);
        }
        LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(this.this$0).f18302b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
        loadingButton2.setEnabled(WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected() != null);
    }
}
