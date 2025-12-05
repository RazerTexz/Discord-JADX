package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetUserProfileAdapterItemServerBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f18371a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f18372b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f18373c;

    /* renamed from: d */
    @NonNull
    public final TextView f18374d;

    /* renamed from: e */
    @NonNull
    public final TextView f18375e;

    /* renamed from: f */
    @NonNull
    public final TextView f18376f;

    public WidgetUserProfileAdapterItemServerBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView, @NonNull Barrier barrier2, @NonNull SimpleDraweeView simpleDraweeView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView3) {
        this.f18371a = constraintLayout;
        this.f18372b = simpleDraweeView;
        this.f18373c = simpleDraweeView2;
        this.f18374d = textView;
        this.f18375e = textView2;
        this.f18376f = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18371a;
    }
}
