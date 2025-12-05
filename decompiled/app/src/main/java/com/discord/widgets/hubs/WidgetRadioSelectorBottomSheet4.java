package com.discord.widgets.hubs;

import android.view.View;
import com.discord.C5419R;
import com.discord.databinding.WidgetRadioSelectorViewHolderBinding;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.IconRow;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
/* renamed from: com.discord.widgets.hubs.RadioSelectorViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet4 extends SimpleRecyclerAdapter.ViewHolder<WidgetRadioSelectorBottomSheet2> {
    private final WidgetRadioSelectorViewHolderBinding binding;
    private final Function1<Integer, Unit> onSelected;

    /* compiled from: WidgetRadioSelectorBottomSheet.kt */
    /* renamed from: com.discord.widgets.hubs.RadioSelectorViewHolder$bind$1 */
    public static final class ViewOnClickListenerC89861 implements View.OnClickListener {
        public final /* synthetic */ WidgetRadioSelectorBottomSheet2 $data;

        public ViewOnClickListenerC89861(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2) {
            this.$data = widgetRadioSelectorBottomSheet2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetRadioSelectorBottomSheet4.this.getOnSelected().invoke(Integer.valueOf(this.$data.getId()));
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetRadioSelectorBottomSheet4(WidgetRadioSelectorViewHolderBinding widgetRadioSelectorViewHolderBinding, Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(widgetRadioSelectorViewHolderBinding, "binding");
        Intrinsics3.checkNotNullParameter(function1, "onSelected");
        IconRow iconRow = widgetRadioSelectorViewHolderBinding.f17404a;
        Intrinsics3.checkNotNullExpressionValue(iconRow, "binding.root");
        super(iconRow);
        this.binding = widgetRadioSelectorViewHolderBinding;
        this.onSelected = function1;
    }

    @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
    public /* bridge */ /* synthetic */ void bind(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2) {
        bind2(widgetRadioSelectorBottomSheet2);
    }

    public final WidgetRadioSelectorViewHolderBinding getBinding() {
        return this.binding;
    }

    public final Function1<Integer, Unit> getOnSelected() {
        return this.onSelected;
    }

    /* renamed from: bind, reason: avoid collision after fix types in other method */
    public void bind2(WidgetRadioSelectorBottomSheet2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        this.binding.f17405b.setText(data.getText());
        this.binding.f17405b.setImageRes(Integer.valueOf(data.getSelected() ? C5419R.drawable.ic_check_brand_16dp : 0));
        this.binding.f17405b.setOnClickListener(new ViewOnClickListenerC89861(data));
    }
}
