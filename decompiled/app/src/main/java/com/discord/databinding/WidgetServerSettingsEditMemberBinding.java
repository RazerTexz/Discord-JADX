package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetServerSettingsEditMemberBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17627a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f17628b;

    /* renamed from: c */
    @NonNull
    public final TextView f17629c;

    /* renamed from: d */
    @NonNull
    public final TextView f17630d;

    /* renamed from: e */
    @NonNull
    public final TextInputLayout f17631e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f17632f;

    /* renamed from: g */
    @NonNull
    public final RecyclerView f17633g;

    /* renamed from: h */
    @NonNull
    public final FloatingActionButton f17634h;

    /* renamed from: i */
    @NonNull
    public final TextView f17635i;

    /* renamed from: j */
    @NonNull
    public final TextView f17636j;

    public WidgetServerSettingsEditMemberBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull FloatingActionButton floatingActionButton, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f17627a = coordinatorLayout;
        this.f17628b = linearLayout;
        this.f17629c = textView;
        this.f17630d = textView2;
        this.f17631e = textInputLayout;
        this.f17632f = linearLayout2;
        this.f17633g = recyclerView;
        this.f17634h = floatingActionButton;
        this.f17635i = textView3;
        this.f17636j = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17627a;
    }
}
