package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class SettingsChannelListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f15233a;

    /* renamed from: b */
    @NonNull
    public final ImageView f15234b;

    /* renamed from: c */
    @NonNull
    public final ImageView f15235c;

    /* renamed from: d */
    @NonNull
    public final TextView f15236d;

    /* renamed from: e */
    @NonNull
    public final View f15237e;

    public SettingsChannelListItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull View view) {
        this.f15233a = relativeLayout;
        this.f15234b = imageView;
        this.f15235c = imageView2;
        this.f15236d = textView;
        this.f15237e = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15233a;
    }
}
