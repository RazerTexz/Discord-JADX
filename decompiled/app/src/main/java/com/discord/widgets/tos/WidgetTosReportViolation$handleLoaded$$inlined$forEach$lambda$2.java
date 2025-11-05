package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroupKt;
import com.discord.api.report.ReportReason;
import com.discord.views.LoadingButton;
import d0.z.d.m;
import java.util.Objects;

/* compiled from: View.kt */
/* loaded from: classes.dex */
public final class WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ ReportReason $reason$inlined;
    public final /* synthetic */ WidgetTosReportViolationReasonView $reasonView$inlined;
    public final /* synthetic */ WidgetTosReportViolation this$0;

    /* compiled from: WidgetTosReportViolation.kt */
    /* renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!m.areEqual(WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).getReasonSelected(), WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason())) {
                WidgetTosReportViolation.access$getViewModel$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).setReasonSelected(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.getReason());
                LoadingButton loadingButton = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f2675b;
                m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
                loadingButton.setEnabled(false);
                LinearLayout linearLayout = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).d;
                m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                for (View view2 : ViewGroupKt.getChildren(linearLayout)) {
                    Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                    ((WidgetTosReportViolationReasonView) view2).setChecked(false);
                }
                WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.$reasonView$inlined.setChecked(true);
            }
            LoadingButton loadingButton2 = WidgetTosReportViolation.access$getBinding$p(WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.this.this$0).f2675b;
            m.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
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
        m.checkNotNullParameter(view, "view");
        view.removeOnLayoutChangeListener(this);
        this.$reasonView$inlined.setReason(this.$reason$inlined);
        this.$reasonView$inlined.setChecked(m.areEqual(this.$reason$inlined, WidgetTosReportViolation.access$getViewModel$p(this.this$0).getReasonSelected()));
        this.$reasonView$inlined.setOnClickListener(new AnonymousClass1());
    }
}
