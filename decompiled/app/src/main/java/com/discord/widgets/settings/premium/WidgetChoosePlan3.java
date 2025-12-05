package com.discord.widgets.settings.premium;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChoosePlanBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChoosePlan.kt */
/* renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChoosePlan3 extends FunctionReferenceImpl implements Function1<View, WidgetChoosePlanBinding> {
    public static final WidgetChoosePlan3 INSTANCE = new WidgetChoosePlan3();

    public WidgetChoosePlan3() {
        super(1, WidgetChoosePlanBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChoosePlanBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChoosePlanBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChoosePlanBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.choose_plan_empty_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.choose_plan_empty_container);
        if (linearLayout != null) {
            i = C5419R.id.choose_plan_empty_description;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.choose_plan_empty_description);
            if (linkifiedTextView != null) {
                i = C5419R.id.choose_plan_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.choose_plan_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.dimmer_view;
                    DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                    if (dimmerView != null) {
                        return new WidgetChoosePlanBinding((CoordinatorLayout) view, linearLayout, linkifiedTextView, recyclerView, dimmerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
