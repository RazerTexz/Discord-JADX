package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class GifCategoryItemViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f15099a;

    /* renamed from: b */
    @NonNull
    public final ImageView f15100b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f15101c;

    /* renamed from: d */
    @NonNull
    public final TextView f15102d;

    public GifCategoryItemViewBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f15099a = cardView;
        this.f15100b = imageView;
        this.f15101c = simpleDraweeView;
        this.f15102d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15099a;
    }
}
