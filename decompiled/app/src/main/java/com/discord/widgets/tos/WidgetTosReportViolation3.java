package com.discord.widgets.tos;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetTosReportViolation3 extends FunctionReferenceImpl implements Function1<View, WidgetTosReportViolationBinding> {
    public static final WidgetTosReportViolation3 INSTANCE = new WidgetTosReportViolation3();

    public WidgetTosReportViolation3() {
        super(1, WidgetTosReportViolationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetTosReportViolationBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetTosReportViolationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.report_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.report_button);
        if (loadingButton != null) {
            i = C5419R.id.report_header;
            TextView textView = (TextView) view.findViewById(C5419R.id.report_header);
            if (textView != null) {
                i = C5419R.id.report_reasons_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.report_reasons_container);
                if (linearLayout != null) {
                    i = C5419R.id.report_reasons_header;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.report_reasons_header);
                    if (textView2 != null) {
                        i = C5419R.id.report_reasons_loading;
                        ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.report_reasons_loading);
                        if (progressBar != null) {
                            i = C5419R.id.report_tooltip;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.report_tooltip);
                            if (linkifiedTextView != null) {
                                return new WidgetTosReportViolationBinding((CoordinatorLayout) view, loadingButton, textView, linearLayout, textView2, progressBar, linkifiedTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
