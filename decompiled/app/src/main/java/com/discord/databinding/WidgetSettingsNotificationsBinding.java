package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsNotificationsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f18022a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f18023b;

    /* renamed from: c */
    @NonNull
    public final CheckedSetting f18024c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f18025d;

    /* renamed from: e */
    @NonNull
    public final CheckedSetting f18026e;

    /* renamed from: f */
    @NonNull
    public final CheckedSetting f18027f;

    /* renamed from: g */
    @NonNull
    public final LinearLayout f18028g;

    public WidgetSettingsNotificationsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4, @NonNull CheckedSetting checkedSetting5, @NonNull LinearLayout linearLayout) {
        this.f18022a = coordinatorLayout;
        this.f18023b = checkedSetting;
        this.f18024c = checkedSetting2;
        this.f18025d = checkedSetting3;
        this.f18026e = checkedSetting4;
        this.f18027f = checkedSetting5;
        this.f18028g = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18022a;
    }
}
