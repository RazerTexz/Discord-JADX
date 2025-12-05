package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelsListItemThreadBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16068a;

    /* renamed from: b */
    @NonNull
    public final ConstraintLayout f16069b;

    /* renamed from: c */
    @NonNull
    public final TextView f16070c;

    /* renamed from: d */
    @NonNull
    public final TextView f16071d;

    /* renamed from: e */
    @NonNull
    public final ImageView f16072e;

    /* renamed from: f */
    @NonNull
    public final ImageView f16073f;

    public WidgetChannelsListItemThreadBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f16068a = constraintLayout;
        this.f16069b = constraintLayout2;
        this.f16070c = textView;
        this.f16071d = textView2;
        this.f16072e = imageView;
        this.f16073f = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16068a;
    }
}
