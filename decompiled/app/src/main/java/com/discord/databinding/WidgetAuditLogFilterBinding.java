package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetAuditLogFilterBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15665a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f15666b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f15667c;

    public WidgetAuditLogFilterBinding(@NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView) {
        this.f15665a = linearLayout;
        this.f15666b = textInputLayout;
        this.f15667c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15665a;
    }
}
