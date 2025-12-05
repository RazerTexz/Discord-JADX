package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetAuthResetPasswordBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15716a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f15717b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f15718c;

    public WidgetAuthResetPasswordBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f15716a = coordinatorLayout;
        this.f15717b = materialButton;
        this.f15718c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15716a;
    }
}
