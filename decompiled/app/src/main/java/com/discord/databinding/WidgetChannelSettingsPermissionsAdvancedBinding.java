package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelSettingsPermissionsAdvancedBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15948a;

    /* renamed from: b */
    @NonNull
    public final TextView f15949b;

    /* renamed from: c */
    @NonNull
    public final TextView f15950c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f15951d;

    /* renamed from: e */
    @NonNull
    public final RecyclerView f15952e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f15953f;

    /* renamed from: g */
    @NonNull
    public final RecyclerView f15954g;

    public WidgetChannelSettingsPermissionsAdvancedBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView2) {
        this.f15948a = coordinatorLayout;
        this.f15949b = textView;
        this.f15950c = textView2;
        this.f15951d = linearLayout;
        this.f15952e = recyclerView;
        this.f15953f = linearLayout2;
        this.f15954g = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15948a;
    }
}
