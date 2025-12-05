package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;
import p007b.p008a.p025i.WidgetDirectoryChannelEmptyBinding;

/* loaded from: classes.dex */
public final class WidgetDirectoryChannelBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16461a;

    /* renamed from: b */
    @NonNull
    public final Toolbar f16462b;

    /* renamed from: c */
    @NonNull
    public final ServerDiscoveryHeader f16463c;

    /* renamed from: d */
    @NonNull
    public final TabLayout f16464d;

    /* renamed from: e */
    @NonNull
    public final ViewPager2 f16465e;

    /* renamed from: f */
    @NonNull
    public final WidgetDirectoryChannelEmptyBinding f16466f;

    public WidgetDirectoryChannelBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Toolbar toolbar, @NonNull ServerDiscoveryHeader serverDiscoveryHeader, @NonNull TabLayout tabLayout, @NonNull ViewPager2 viewPager2, @NonNull WidgetDirectoryChannelEmptyBinding widgetDirectoryChannelEmptyBinding) {
        this.f16461a = coordinatorLayout;
        this.f16462b = toolbar;
        this.f16463c = serverDiscoveryHeader;
        this.f16464d = tabLayout;
        this.f16465e = viewPager2;
        this.f16466f = widgetDirectoryChannelEmptyBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16461a;
    }
}
