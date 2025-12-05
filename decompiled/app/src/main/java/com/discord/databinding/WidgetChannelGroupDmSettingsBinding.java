package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.servers.NotificationMuteSettingsView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetChannelGroupDmSettingsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f15845a;

    /* renamed from: b */
    @NonNull
    public final TextInputLayout f15846b;

    /* renamed from: c */
    @NonNull
    public final FloatingActionButton f15847c;

    /* renamed from: d */
    @NonNull
    public final NotificationMuteSettingsView f15848d;

    /* renamed from: e */
    @NonNull
    public final NestedScrollView f15849e;

    /* renamed from: f */
    @NonNull
    public final SimpleDraweeView f15850f;

    /* renamed from: g */
    @NonNull
    public final TextView f15851g;

    /* renamed from: h */
    @NonNull
    public final TextView f15852h;

    public WidgetChannelGroupDmSettingsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull TextInputLayout textInputLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull NotificationMuteSettingsView notificationMuteSettingsView, @NonNull NestedScrollView nestedScrollView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f15845a = coordinatorLayout;
        this.f15846b = textInputLayout;
        this.f15847c = floatingActionButton;
        this.f15848d = notificationMuteSettingsView;
        this.f15849e = nestedScrollView;
        this.f15850f = simpleDraweeView;
        this.f15851g = textView;
        this.f15852h = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15845a;
    }
}
