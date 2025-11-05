package com.discord.widgets.settings.billing;

import android.view.View;
import com.discord.widgets.settings.billing.PaymentSourceAdapter;

/* compiled from: PaymentSourceAdapter.kt */
/* renamed from: com.discord.widgets.settings.billing.PaymentSourceAdapter$PaymentSourceAddViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class PaymentSourceAdapter2 implements View.OnClickListener {
    public final /* synthetic */ PaymentSourceAdapter.PaymentSourceAddViewHolder this$0;

    public PaymentSourceAdapter2(PaymentSourceAdapter.PaymentSourceAddViewHolder paymentSourceAddViewHolder) {
        this.this$0 = paymentSourceAddViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PaymentSourceAdapter.access$getOnAddClick$p(PaymentSourceAdapter.PaymentSourceAddViewHolder.access$getAdapter$p(this.this$0)).invoke();
    }
}
