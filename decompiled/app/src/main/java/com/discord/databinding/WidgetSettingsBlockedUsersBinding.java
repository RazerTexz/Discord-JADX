package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* loaded from: classes.dex */
public final class WidgetSettingsBlockedUsersBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17917a;

    /* renamed from: b */
    @NonNull
    public final AppViewFlipper f17918b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f17919c;

    public WidgetSettingsBlockedUsersBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull ImageView imageView) {
        this.f17917a = coordinatorLayout;
        this.f17918b = appViewFlipper;
        this.f17919c = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17917a;
    }
}
