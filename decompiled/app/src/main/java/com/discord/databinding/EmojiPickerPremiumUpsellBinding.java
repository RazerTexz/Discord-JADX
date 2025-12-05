package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class EmojiPickerPremiumUpsellBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15058a;

    /* renamed from: b */
    @NonNull
    public final TextView f15059b;

    public EmojiPickerPremiumUpsellBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView) {
        this.f15058a = linearLayout;
        this.f15059b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15058a;
    }
}
