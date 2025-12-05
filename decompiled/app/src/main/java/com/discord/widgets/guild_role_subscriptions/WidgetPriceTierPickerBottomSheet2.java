package com.discord.widgets.guild_role_subscriptions;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierPickerAdapter, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet2 extends RecyclerView.Adapter<WidgetPriceTierPickerBottomSheet3> {
    private final Function1<Integer, Unit> itemClickListener;
    private List<Integer> items;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetPriceTierPickerBottomSheet2(Function1<? super Integer, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "itemClickListener");
        this.itemClickListener = function1;
        this.items = Collections2.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((WidgetPriceTierPickerBottomSheet3) viewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<Integer> newItems) {
        Intrinsics3.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(WidgetPriceTierPickerBottomSheet3 holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        holder.configureUI(this.items.get(position).intValue(), this.itemClickListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetPriceTierPickerBottomSheet3 onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBindingM8381a = DialogSimpleSelectorItemBinding.m8381a(LayoutInflater.from(parent.getContext()), parent, false);
        Intrinsics3.checkNotNullExpressionValue(dialogSimpleSelectorItemBindingM8381a, "DialogSimpleSelectorItem…rent,\n        false\n    )");
        return new WidgetPriceTierPickerBottomSheet3(dialogSimpleSelectorItemBindingM8381a);
    }
}
