package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetSettingsLanguageBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17992a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f17993b;

    /* renamed from: c */
    @NonNull
    public final ImageView f17994c;

    /* renamed from: d */
    @NonNull
    public final TextView f17995d;

    /* renamed from: e */
    @NonNull
    public final TextView f17996e;

    /* renamed from: f */
    @NonNull
    public final CheckedSetting f17997f;

    /* renamed from: g */
    @NonNull
    public final TextView f17998g;

    public WidgetSettingsLanguageBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckedSetting checkedSetting, @NonNull TextView textView3) {
        this.f17992a = coordinatorLayout;
        this.f17993b = relativeLayout;
        this.f17994c = imageView;
        this.f17995d = textView;
        this.f17996e = textView2;
        this.f17997f = checkedSetting;
        this.f17998g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17992a;
    }
}
