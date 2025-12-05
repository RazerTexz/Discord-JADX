package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetServerSettingsBansBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17534a;

    /* renamed from: b */
    @NonNull
    public final RecyclerView f17535b;

    /* renamed from: c */
    @NonNull
    public final TextInputLayout f17536c;

    /* renamed from: d */
    @NonNull
    public final AppViewFlipper f17537d;

    public WidgetServerSettingsBansBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull RecyclerView recyclerView, @NonNull TextInputLayout textInputLayout, @NonNull AppViewFlipper appViewFlipper) {
        this.f17534a = coordinatorLayout;
        this.f17535b = recyclerView;
        this.f17536c = textInputLayout;
        this.f17537d = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17534a;
    }
}
