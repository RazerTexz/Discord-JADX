package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetAuthUndeleteAccountBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15719a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f15720b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f15721c;

    /* renamed from: d */
    @NonNull
    public final ScreenTitleView f15722d;

    public WidgetAuthUndeleteAccountBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull ScreenTitleView screenTitleView) {
        this.f15719a = coordinatorLayout;
        this.f15720b = materialButton;
        this.f15721c = materialButton2;
        this.f15722d = screenTitleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15719a;
    }
}
