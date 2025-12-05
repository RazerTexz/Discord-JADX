package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class OauthTokenPermissionDetailedListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15201a;

    /* renamed from: b */
    @NonNull
    public final ImageView f15202b;

    /* renamed from: c */
    @NonNull
    public final TextView f15203c;

    public OauthTokenPermissionDetailedListItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f15201a = constraintLayout;
        this.f15202b = imageView;
        this.f15203c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15201a;
    }
}
