package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.NodeResult;
import com.discord.api.report.ReportNodeChild;
import com.discord.api.report.ReportNodeElementData;
import com.discord.databinding.ViewMobileReportsBreadcrumbsBinding;
import com.discord.databinding.ViewMobileReportsBreadcrumbsItemBinding;
import d0.t.Collections2;
import d0.t.MutableCollections;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: MobileReportsBreadcrumbs.kt */
/* loaded from: classes2.dex */
public final class MobileReportsBreadcrumbs extends LinearLayout {
    private final ViewMobileReportsBreadcrumbsBinding binding;

    public MobileReportsBreadcrumbs(Context context) {
        this(context, null, 0, 6, null);
    }

    public MobileReportsBreadcrumbs(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MobileReportsBreadcrumbs(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final ViewMobileReportsBreadcrumbsItemBinding getBoundBreadcrumbItem() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        View view = this.binding.a;
        Objects.requireNonNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) view;
        View viewInflate = layoutInflaterFrom.inflate(R.layout.view_mobile_reports_breadcrumbs_item, viewGroup, false);
        viewGroup.addView(viewInflate);
        int i = R.id.reports_breadcrumbs_item_dot;
        View viewFindViewById = viewInflate.findViewById(R.id.reports_breadcrumbs_item_dot);
        if (viewFindViewById != null) {
            i = R.id.reports_breadcrumbs_item_title;
            TextView textView = (TextView) viewInflate.findViewById(R.id.reports_breadcrumbs_item_title);
            if (textView != null) {
                ViewMobileReportsBreadcrumbsItemBinding viewMobileReportsBreadcrumbsItemBinding = new ViewMobileReportsBreadcrumbsItemBinding((ConstraintLayout) viewInflate, viewFindViewById, textView);
                Intrinsics3.checkNotNullExpressionValue(viewMobileReportsBreadcrumbsItemBinding, "ViewMobileReportsBreadcr…ach to parent */ true\n  )");
                return viewMobileReportsBreadcrumbsItemBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setup(List<NodeResult> history) {
        boolean z2;
        List<ReportNodeElementData> list;
        List<ReportNodeElementData> listA;
        View view = this.binding.a;
        if (!(view instanceof LinearLayout)) {
            view = null;
        }
        LinearLayout linearLayout = (LinearLayout) view;
        if (linearLayout != null) {
            if (linearLayout.getChildCount() > 1) {
                linearLayout.removeViewsInLayout(1, linearLayout.getChildCount() - 1);
            }
            if (history != null) {
                ArrayList arrayList = new ArrayList();
                for (NodeResult nodeResult : history) {
                    NodeElementResult elementResult = nodeResult.getElementResult();
                    if (elementResult == null || (listA = elementResult.a()) == null) {
                        list = null;
                    } else {
                        if (listA.isEmpty()) {
                            listA = null;
                        }
                        list = listA;
                    }
                    String[] strArr = new String[2];
                    strArr[0] = list != null ? _Collections.joinToString$default(list, ", ", null, null, 0, null, MobileReportsBreadcrumbs2.INSTANCE, 30, null) : null;
                    ReportNodeChild destination = nodeResult.getDestination();
                    strArr[1] = destination != null ? destination.getName() : null;
                    MutableCollections.addAll(arrayList, Collections2.listOf((Object[]) strArr));
                }
                ArrayList<String> arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    String str = (String) obj;
                    if (str == null) {
                        z2 = false;
                    } else if (str.length() > 0) {
                        z2 = true;
                    }
                    if (z2) {
                        arrayList2.add(obj);
                    }
                }
                for (String str2 : arrayList2) {
                    TextView textView = getBoundBreadcrumbItem().f2203b;
                    Intrinsics3.checkNotNullExpressionValue(textView, "getBoundBreadcrumbItem()…portsBreadcrumbsItemTitle");
                    textView.setText(str2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileReportsBreadcrumbs(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_mobile_reports_breadcrumbs, this);
        ViewMobileReportsBreadcrumbsBinding viewMobileReportsBreadcrumbsBinding = new ViewMobileReportsBreadcrumbsBinding(this);
        Intrinsics3.checkNotNullExpressionValue(viewMobileReportsBreadcrumbsBinding, "ViewMobileReportsBreadcr…ater.from(context), this)");
        this.binding = viewMobileReportsBreadcrumbsBinding;
    }
}
