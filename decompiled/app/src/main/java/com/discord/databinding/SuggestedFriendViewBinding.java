package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class SuggestedFriendViewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final View f15288a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f15289b;

    /* renamed from: c */
    @NonNull
    public final AppCompatImageView f15290c;

    /* renamed from: d */
    @NonNull
    public final TextView f15291d;

    /* renamed from: e */
    @NonNull
    public final AppCompatImageView f15292e;

    /* renamed from: f */
    @NonNull
    public final TextView f15293f;

    public SuggestedFriendViewBinding(@NonNull View view, @NonNull SimpleDraweeView simpleDraweeView, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView2) {
        this.f15288a = view;
        this.f15289b = simpleDraweeView;
        this.f15290c = appCompatImageView;
        this.f15291d = textView;
        this.f15292e = appCompatImageView2;
        this.f15293f = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15288a;
    }
}
