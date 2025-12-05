package com.discord.widgets.guild_role_subscriptions;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetPriceTierPickerBottomSheetBinding;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetPriceTierPickerBottomSheet5 extends FunctionReferenceImpl implements Function1<View, WidgetPriceTierPickerBottomSheetBinding> {
    public static final WidgetPriceTierPickerBottomSheet5 INSTANCE = new WidgetPriceTierPickerBottomSheet5();

    public WidgetPriceTierPickerBottomSheet5() {
        super(1, WidgetPriceTierPickerBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPriceTierPickerBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPriceTierPickerBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPriceTierPickerBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.price_tier_picker_app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(C5419R.id.price_tier_picker_app_bar);
        if (appBarLayout != null) {
            i = C5419R.id.price_tier_picker_app_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.price_tier_picker_app_flipper);
            if (appViewFlipper != null) {
                i = C5419R.id.price_tier_picker_recycler;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.price_tier_picker_recycler);
                if (recyclerView != null) {
                    i = C5419R.id.price_tier_picker_toolbar;
                    Toolbar toolbar = (Toolbar) view.findViewById(C5419R.id.price_tier_picker_toolbar);
                    if (toolbar != null) {
                        return new WidgetPriceTierPickerBottomSheetBinding((CoordinatorLayout) view, appBarLayout, appViewFlipper, recyclerView, toolbar);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
