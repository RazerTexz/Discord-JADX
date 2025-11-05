package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
/* renamed from: com.discord.widgets.hubs.WidgetRadioSelectorBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetRadioSelectorBottomSheet6 extends FunctionReferenceImpl implements Function1<View, WidgetRadioSelectorBottomSheetBinding> {
    public static final WidgetRadioSelectorBottomSheet6 INSTANCE = new WidgetRadioSelectorBottomSheet6();

    public WidgetRadioSelectorBottomSheet6() {
        super(1, WidgetRadioSelectorBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetRadioSelectorBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetRadioSelectorBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.radio_selector_bottom_sheet_title;
        TextView textView = (TextView) view.findViewById(R.id.radio_selector_bottom_sheet_title);
        if (textView != null) {
            i = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetRadioSelectorBottomSheetBinding((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
