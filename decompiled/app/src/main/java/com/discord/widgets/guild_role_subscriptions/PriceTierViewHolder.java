package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.DialogSimpleSelectorItemBinding;
import com.discord.utilities.billing.PremiumUtilsKt;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* loaded from: classes2.dex */
public final class PriceTierViewHolder extends RecyclerView.ViewHolder {
    private final DialogSimpleSelectorItemBinding binding;

    /* compiled from: WidgetPriceTierPickerBottomSheet.kt */
    /* renamed from: com.discord.widgets.guild_role_subscriptions.PriceTierViewHolder$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function1 $onItemClickListener;
        public final /* synthetic */ int $priceTier;

        public AnonymousClass1(Function1 function1, int i) {
            this.$onItemClickListener = function1;
            this.$priceTier = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onItemClickListener.invoke(Integer.valueOf(this.$priceTier));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriceTierViewHolder(DialogSimpleSelectorItemBinding dialogSimpleSelectorItemBinding) {
        super(dialogSimpleSelectorItemBinding.a);
        m.checkNotNullParameter(dialogSimpleSelectorItemBinding, "binding");
        this.binding = dialogSimpleSelectorItemBinding;
    }

    public final void configureUI(int priceTier, Function1<? super Integer, Unit> onItemClickListener) {
        m.checkNotNullParameter(onItemClickListener, "onItemClickListener");
        TextView textView = this.binding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        TextView textView2 = this.binding.a;
        m.checkNotNullExpressionValue(textView2, "binding.root");
        Context context = textView2.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView.setText(PremiumUtilsKt.getFormattedPriceUsd(priceTier, context));
        this.binding.a.setOnClickListener(new AnonymousClass1(onItemClickListener, priceTier));
    }
}
