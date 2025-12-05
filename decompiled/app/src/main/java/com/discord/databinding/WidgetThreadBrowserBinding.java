package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.simple_pager.SimplePager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class WidgetThreadBrowserBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f18272a;

    /* renamed from: b */
    @NonNull
    public final TabLayout f18273b;

    /* renamed from: c */
    @NonNull
    public final SimplePager f18274c;

    public WidgetThreadBrowserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TabLayout tabLayout, @NonNull AppBarLayout appBarLayout, @NonNull SimplePager simplePager) {
        this.f18272a = constraintLayout;
        this.f18273b = tabLayout;
        this.f18274c = simplePager;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18272a;
    }
}
