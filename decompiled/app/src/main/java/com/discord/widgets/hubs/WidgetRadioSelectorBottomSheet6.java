package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetRadioSelectorBottomSheetBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

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
        int i = C5419R.id.radio_selector_bottom_sheet_title;
        TextView textView = (TextView) view.findViewById(C5419R.id.radio_selector_bottom_sheet_title);
        if (textView != null) {
            i = C5419R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetRadioSelectorBottomSheetBinding((LinearLayout) view, textView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
