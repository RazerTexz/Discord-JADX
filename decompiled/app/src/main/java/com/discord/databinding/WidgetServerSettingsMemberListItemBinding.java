package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.roles.RolesListView;

/* loaded from: classes.dex */
public final class WidgetServerSettingsMemberListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f17702a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f17703b;

    /* renamed from: c */
    @NonNull
    public final ImageView f17704c;

    /* renamed from: d */
    @NonNull
    public final ImageView f17705d;

    /* renamed from: e */
    @NonNull
    public final RolesListView f17706e;

    /* renamed from: f */
    @NonNull
    public final SettingsMemberView f17707f;

    public WidgetServerSettingsMemberListItemBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull RolesListView rolesListView, @NonNull SettingsMemberView settingsMemberView) {
        this.f17702a = frameLayout;
        this.f17703b = frameLayout2;
        this.f17704c = imageView;
        this.f17705d = imageView2;
        this.f17706e = rolesListView;
        this.f17707f = settingsMemberView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17702a;
    }
}
