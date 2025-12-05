package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.settings.billing.PaymentSourceView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class PaymentMethodListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f15204a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f15205b;

    /* renamed from: c */
    @NonNull
    public final PaymentSourceView f15206c;

    public PaymentMethodListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull PaymentSourceView paymentSourceView) {
        this.f15204a = relativeLayout;
        this.f15205b = materialButton;
        this.f15206c = paymentSourceView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15204a;
    }
}
