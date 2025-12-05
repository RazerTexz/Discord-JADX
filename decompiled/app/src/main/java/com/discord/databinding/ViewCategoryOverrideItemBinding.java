package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class ViewCategoryOverrideItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15379a;

    /* renamed from: b */
    @NonNull
    public final TextView f15380b;

    /* renamed from: c */
    @NonNull
    public final TextView f15381c;

    public ViewCategoryOverrideItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Guideline guideline, @NonNull ImageView imageView) {
        this.f15379a = constraintLayout;
        this.f15380b = textView;
        this.f15381c = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15379a;
    }
}
