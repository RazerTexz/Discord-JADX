package com.discord.databinding;

import android.view.View;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p008a.p025i.ViewServerSettingsIconNameBinding;
import p007b.p008a.p025i.ViewServerSettingsNotificationsBinding;
import p007b.p008a.p025i.ViewServerSettingsSystemChannelWrapBinding;
import p007b.p008a.p025i.ViewServerSettingsUploadBannerBinding;
import p007b.p008a.p025i.ViewServerSettingsUploadSplashBinding;
import p007b.p008a.p025i.WidgetServerSettingsOverviewSectionAfkChannelBinding;

/* loaded from: classes.dex */
public final class WidgetServerSettingsOverviewBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17730a;

    /* renamed from: b */
    @NonNull
    public final WidgetServerSettingsOverviewSectionAfkChannelBinding f17731b;

    /* renamed from: c */
    @NonNull
    public final ViewServerSettingsIconNameBinding f17732c;

    /* renamed from: d */
    @NonNull
    public final ViewServerSettingsNotificationsBinding f17733d;

    /* renamed from: e */
    @NonNull
    public final FloatingActionButton f17734e;

    /* renamed from: f */
    @NonNull
    public final ScrollView f17735f;

    /* renamed from: g */
    @NonNull
    public final ViewServerSettingsSystemChannelWrapBinding f17736g;

    /* renamed from: h */
    @NonNull
    public final ViewServerSettingsUploadBannerBinding f17737h;

    /* renamed from: i */
    @NonNull
    public final ViewServerSettingsUploadSplashBinding f17738i;

    public WidgetServerSettingsOverviewBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull WidgetServerSettingsOverviewSectionAfkChannelBinding widgetServerSettingsOverviewSectionAfkChannelBinding, @NonNull ViewServerSettingsIconNameBinding viewServerSettingsIconNameBinding, @NonNull ViewServerSettingsNotificationsBinding viewServerSettingsNotificationsBinding, @NonNull FloatingActionButton floatingActionButton, @NonNull ScrollView scrollView, @NonNull ViewServerSettingsSystemChannelWrapBinding viewServerSettingsSystemChannelWrapBinding, @NonNull ViewServerSettingsUploadBannerBinding viewServerSettingsUploadBannerBinding, @NonNull ViewServerSettingsUploadSplashBinding viewServerSettingsUploadSplashBinding) {
        this.f17730a = coordinatorLayout;
        this.f17731b = widgetServerSettingsOverviewSectionAfkChannelBinding;
        this.f17732c = viewServerSettingsIconNameBinding;
        this.f17733d = viewServerSettingsNotificationsBinding;
        this.f17734e = floatingActionButton;
        this.f17735f = scrollView;
        this.f17736g = viewServerSettingsSystemChannelWrapBinding;
        this.f17737h = viewServerSettingsUploadBannerBinding;
        this.f17738i = viewServerSettingsUploadSplashBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17730a;
    }
}
