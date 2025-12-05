package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class WidgetServerSettingsGuildRoleSubscriptionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f17671a;

    /* renamed from: b */
    @NonNull
    public final FloatingActionButton f17672b;

    /* renamed from: c */
    @NonNull
    public final AppViewFlipper f17673c;

    public WidgetServerSettingsGuildRoleSubscriptionsBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FragmentContainerView fragmentContainerView, @NonNull FragmentContainerView fragmentContainerView2, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull AppViewFlipper appViewFlipper) {
        this.f17671a = constraintLayout;
        this.f17672b = floatingActionButton;
        this.f17673c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17671a;
    }
}
