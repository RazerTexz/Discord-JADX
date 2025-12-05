package com.discord.databinding;

import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;

/* loaded from: classes.dex */
public final class WidgetServerSettingsEmptyGuildRoleSubscriptionBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17655a;

    /* renamed from: b */
    @NonNull
    public final Button f17656b;

    /* renamed from: c */
    @NonNull
    public final AppViewFlipper f17657c;

    public WidgetServerSettingsEmptyGuildRoleSubscriptionBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button button, @NonNull AppViewFlipper appViewFlipper) {
        this.f17655a = coordinatorLayout;
        this.f17656b = button;
        this.f17657c = appViewFlipper;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17655a;
    }
}
