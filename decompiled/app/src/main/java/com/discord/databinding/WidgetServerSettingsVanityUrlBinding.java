package com.discord.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetServerSettingsVanityUrlBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17759a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f17760b;

    /* renamed from: c */
    @NonNull
    public final TextView f17761c;

    /* renamed from: d */
    @NonNull
    public final TextView f17762d;

    /* renamed from: e */
    @NonNull
    public final TextView f17763e;

    /* renamed from: f */
    @NonNull
    public final RelativeLayout f17764f;

    /* renamed from: g */
    @NonNull
    public final ProgressBar f17765g;

    /* renamed from: h */
    @NonNull
    public final TextView f17766h;

    /* renamed from: i */
    @NonNull
    public final TextView f17767i;

    /* renamed from: j */
    @NonNull
    public final FloatingActionButton f17768j;

    public WidgetServerSettingsVanityUrlBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull FloatingActionButton floatingActionButton) {
        this.f17759a = coordinatorLayout;
        this.f17760b = textInputLayout;
        this.f17761c = textView;
        this.f17762d = textView2;
        this.f17763e = textView3;
        this.f17764f = relativeLayout;
        this.f17765g = progressBar;
        this.f17766h = textView4;
        this.f17767i = textView5;
        this.f17768j = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17759a;
    }
}
