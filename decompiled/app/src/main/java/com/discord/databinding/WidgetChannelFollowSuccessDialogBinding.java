package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetChannelFollowSuccessDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final NestedScrollView f15841a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f15842b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f15843c;

    /* renamed from: d */
    @NonNull
    public final TextView f15844d;

    public WidgetChannelFollowSuccessDialogBinding(@NonNull NestedScrollView nestedScrollView, @NonNull MaterialButton materialButton, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView) {
        this.f15841a = nestedScrollView;
        this.f15842b = materialButton;
        this.f15843c = simpleDraweeView;
        this.f15844d = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15841a;
    }
}
