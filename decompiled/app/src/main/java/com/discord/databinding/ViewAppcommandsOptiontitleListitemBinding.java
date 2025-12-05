package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class ViewAppcommandsOptiontitleListitemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15371a;

    /* renamed from: b */
    @NonNull
    public final TextView f15372b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f15373c;

    public ViewAppcommandsOptiontitleListitemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView) {
        this.f15371a = constraintLayout;
        this.f15372b = textView;
        this.f15373c = simpleDraweeView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15371a;
    }
}
