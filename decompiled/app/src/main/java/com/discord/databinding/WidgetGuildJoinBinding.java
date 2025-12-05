package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetGuildJoinBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16851a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f16852b;

    /* renamed from: c */
    @NonNull
    public final TextInputLayout f16853c;

    public WidgetGuildJoinBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull TextInputLayout textInputLayout) {
        this.f16851a = coordinatorLayout;
        this.f16852b = materialButton;
        this.f16853c = textInputLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16851a;
    }
}
