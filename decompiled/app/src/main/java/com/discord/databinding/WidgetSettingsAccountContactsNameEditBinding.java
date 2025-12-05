package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetSettingsAccountContactsNameEditBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17826a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f17827b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f17828c;

    /* renamed from: d */
    @NonNull
    public final FloatingActionButton f17829d;

    public WidgetSettingsAccountContactsNameEditBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull MaterialButton materialButton, @NonNull FloatingActionButton floatingActionButton) {
        this.f17826a = coordinatorLayout;
        this.f17827b = textInputLayout;
        this.f17828c = materialButton;
        this.f17829d = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17826a;
    }
}
