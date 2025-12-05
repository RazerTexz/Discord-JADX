package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class WidgetQuickMentionsDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f17398a;

    /* renamed from: b */
    @NonNull
    public final ViewPager2 f17399b;

    /* renamed from: c */
    @NonNull
    public final TabLayout f17400c;

    public WidgetQuickMentionsDialogBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ViewPager2 viewPager2, @NonNull TabLayout tabLayout) {
        this.f17398a = constraintLayout;
        this.f17399b = viewPager2;
        this.f17400c = tabLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17398a;
    }
}
