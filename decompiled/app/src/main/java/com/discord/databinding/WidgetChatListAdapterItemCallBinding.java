package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemCallBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f16173a;

    /* renamed from: b */
    @NonNull
    public final ImageView f16174b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f16175c;

    /* renamed from: d */
    @NonNull
    public final TextView f16176d;

    /* renamed from: e */
    @NonNull
    public final TextView f16177e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f16178f;

    /* renamed from: g */
    @NonNull
    public final TextView f16179g;

    public WidgetChatListAdapterItemCallBinding(@NonNull CardView cardView, @NonNull ImageView imageView, @NonNull RecyclerView recyclerView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3) {
        this.f16173a = cardView;
        this.f16174b = imageView;
        this.f16175c = recyclerView;
        this.f16176d = textView;
        this.f16177e = textView2;
        this.f16178f = linearLayout;
        this.f16179g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16173a;
    }
}
