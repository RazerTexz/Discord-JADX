package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import com.discord.api.report.ReportReason;
import com.discord.views.LoadingButton;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1 */
    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final class ViewOnClickListenerC101731 implements View.OnClickListener {
        public ViewOnClickListenerC101731() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!Intrinsics3.areEqual(WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).getReasonSelected(), WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason())) {
                WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).setReasonSelected(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason());
                LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f18302b;
                Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
                loadingButton.setEnabled(false);
                LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f18304d;
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                for (View view2 : ViewGroup.getChildren(linearLayout)) {
                    Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                    ((WidgetTosReportViolationReasonView) view2).setChecked(false);
                }
                WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.setChecked(true);
            }
            LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f18302b;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
            loadingButton2.setEnabled(WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).getReasonSelected() != null);
        }
    }

    public WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(WidgetTosReportViolationReasonView widgetTosReportViolationReasonView, ReportReason reportReason, WidgetTosReportViolation widgetTosReportViolation) {
        this.$reasonView$inlined = widgetTosReportViolationReasonView;
        this.$reason$inlined = reportReason;
        this.this$0 = widgetTosReportViolation;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        Intrinsics3.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$reasonView$inlined.setReason(this.$reason$inlined);
        this.$reasonView$inlined.setChecked(Intrinsics3.areEqual(this.$reason$inlined, WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected()));
        this.$reasonView$inlined.setOnClickListener(new ViewOnClickListenerC101731());
    }
}
