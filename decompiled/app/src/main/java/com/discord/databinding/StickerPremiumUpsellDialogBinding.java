package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class StickerPremiumUpsellDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f15277a;

    /* renamed from: b */
    @NonNull
    public final TextView f15278b;

    /* renamed from: c */
    @NonNull
    public final TextView f15279c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f15280d;

    public StickerPremiumUpsellDialogBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton) {
        this.f15277a = relativeLayout;
        this.f15278b = textView;
        this.f15279c = textView2;
        this.f15280d = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15277a;
    }
}
