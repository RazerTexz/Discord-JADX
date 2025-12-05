package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetServerSettingsMembersBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17708a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f17709b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f17710c;

    /* renamed from: d */
    @NonNull
    public final Spinner f17711d;

    /* renamed from: e */
    @NonNull
    public final AppViewFlipper f17712e;

    public WidgetServerSettingsMembersBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull Spinner spinner, @NonNull AppViewFlipper appViewFlipper) {
        this.f17708a = coordinatorLayout;
        this.f17709b = textInputLayout;
        this.f17710c = recyclerView;
        this.f17711d = spinner;
        this.f17712e = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17708a;
    }
}
