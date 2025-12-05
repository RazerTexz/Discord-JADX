package com.discord.widgets.botuikit.views.select;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetSelectComponentBottomSheetBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SelectComponentBottomSheet.kt */
/* renamed from: com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class SelectComponentBottomSheet4 extends FunctionReferenceImpl implements Function1<View, WidgetSelectComponentBottomSheetBinding> {
    public static final SelectComponentBottomSheet4 INSTANCE = new SelectComponentBottomSheet4();

    public SelectComponentBottomSheet4() {
        super(1, WidgetSelectComponentBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSelectComponentBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSelectComponentBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSelectComponentBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.widget_sheet_component_bottom_sheet_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.widget_sheet_component_bottom_sheet_header);
        if (constraintLayout != null) {
            i = C5419R.id.widget_sheet_component_bottom_sheet_placeholder;
            TextView textView = (TextView) view.findViewById(C5419R.id.widget_sheet_component_bottom_sheet_placeholder);
            if (textView != null) {
                i = C5419R.id.widget_sheet_component_bottom_sheet_recycler;
                MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(C5419R.id.widget_sheet_component_bottom_sheet_recycler);
                if (maxHeightRecyclerView != null) {
                    i = C5419R.id.widget_sheet_component_bottom_sheet_select;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.widget_sheet_component_bottom_sheet_select);
                    if (textView2 != null) {
                        i = C5419R.id.widget_sheet_component_bottom_sheet_subtitle;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.widget_sheet_component_bottom_sheet_subtitle);
                        if (textView3 != null) {
                            return new WidgetSelectComponentBottomSheetBinding((ConstraintLayout) view, constraintLayout, textView, maxHeightRecyclerView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
