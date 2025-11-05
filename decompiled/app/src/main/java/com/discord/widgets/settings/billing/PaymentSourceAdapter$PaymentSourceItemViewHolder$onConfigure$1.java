package com.discord.widgets.settings.billing;

import android.view.View;
import com.discord.models.domain.ModelPaymentSource;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;

/* compiled from: PaymentSourceAdapter.kt */
/* loaded from: classes2.dex */
public final class PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ModelPaymentSource $paymentSource;
    public final /* synthetic */ PaymentSourceAdapter.PaymentSourceItemViewHolder this$0;

    public PaymentSourceAdapter$PaymentSourceItemViewHolder$onConfigure$1(PaymentSourceAdapter.PaymentSourceItemViewHolder paymentSourceItemViewHolder, ModelPaymentSource modelPaymentSource) {
        this.this$0 = paymentSourceItemViewHolder;
        this.$paymentSource = modelPaymentSource;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaymentSourceAdapter.access$getOnEditPaymentSource$p(PaymentSourceAdapter.PaymentSourceItemViewHolder.access$getAdapter$p(this.this$0)).invoke(this.$paymentSource);
    }
}
