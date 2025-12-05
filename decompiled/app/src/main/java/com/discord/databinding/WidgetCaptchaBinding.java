package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetCaptchaBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15795a;

    /* renamed from: b */
    @NonNull
    public final TextView f15796b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f15797c;

    /* renamed from: d */
    @NonNull
    public final ScreenTitleView f15798d;

    public WidgetCaptchaBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ScreenTitleView screenTitleView) {
        this.f15795a = coordinatorLayout;
        this.f15796b = textView;
        this.f15797c = materialButton;
        this.f15798d = screenTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15795a;
    }
}
