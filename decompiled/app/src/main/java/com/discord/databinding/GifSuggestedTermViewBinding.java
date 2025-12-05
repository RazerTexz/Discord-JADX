package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* loaded from: classes.dex */
public final class GifSuggestedTermViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15105a;

    /* renamed from: b */
    @NonNull
    public final FlexboxLayout f15106b;

    /* renamed from: c */
    @NonNull
    public final TextView f15107c;

    public GifSuggestedTermViewBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull FlexboxLayout flexboxLayout, @NonNull TextView textView) {
        this.f15105a = linearLayout;
        this.f15106b = flexboxLayout;
        this.f15107c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15105a;
    }
}
