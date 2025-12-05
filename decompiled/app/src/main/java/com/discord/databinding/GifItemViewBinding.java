package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class GifItemViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f15103a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f15104b;

    public GifItemViewBinding(@NonNull CardView cardView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.f15103a = cardView;
        this.f15104b = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15103a;
    }
}
