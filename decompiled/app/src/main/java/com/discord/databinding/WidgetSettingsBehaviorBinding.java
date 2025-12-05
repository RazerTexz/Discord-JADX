package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsBehaviorBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17872a;

    /* renamed from: b */
    @NonNull
    public final CheckedSetting f17873b;

    /* renamed from: c */
    @NonNull
    public final TextView f17874c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f17875d;

    /* renamed from: e */
    @NonNull
    public final TextView f17876e;

    /* renamed from: f */
    @NonNull
    public final CheckedSetting f17877f;

    public WidgetSettingsBehaviorBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting3) {
        this.f17872a = coordinatorLayout;
        this.f17873b = checkedSetting;
        this.f17874c = textView;
        this.f17875d = checkedSetting2;
        this.f17876e = textView2;
        this.f17877f = checkedSetting3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17872a;
    }
}
