package com.discord.widgets.mobile_reports;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetMobileReportsBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMobileReports3 extends FunctionReferenceImpl implements Function1<View, WidgetMobileReportsBinding> {
    public static final WidgetMobileReports3 INSTANCE = new WidgetMobileReports3();

    public WidgetMobileReports3() {
        super(1, WidgetMobileReportsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMobileReportsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMobileReportsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMobileReportsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.menu_reports_node_view_holder;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.menu_reports_node_view_holder);
        if (frameLayout != null) {
            i = C5419R.id.mobile_reports_progress_bar;
            ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.mobile_reports_progress_bar);
            if (progressBar != null) {
                return new WidgetMobileReportsBinding((CoordinatorLayout) view, frameLayout, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
