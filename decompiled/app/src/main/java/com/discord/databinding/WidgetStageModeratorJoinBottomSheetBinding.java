package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetStageModeratorJoinBottomSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f18162a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f18163b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f18164c;

    public WidgetStageModeratorJoinBottomSheetBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f18162a = coordinatorLayout;
        this.f18163b = materialButton;
        this.f18164c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18162a;
    }
}
