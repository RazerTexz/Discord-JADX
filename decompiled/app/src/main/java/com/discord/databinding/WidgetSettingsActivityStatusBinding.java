package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsActivityStatusBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17846a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f17847b;

    public WidgetSettingsActivityStatusBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting) {
        this.f17846a = coordinatorLayout;
        this.f17847b = checkedSetting;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17846a;
    }
}
