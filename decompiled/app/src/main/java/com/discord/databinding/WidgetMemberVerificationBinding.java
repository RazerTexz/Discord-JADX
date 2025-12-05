package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CustomAppBarLayout;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.discord.widgets.servers.member_verification.MemberVerificationView;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* loaded from: classes.dex */
public final class WidgetMemberVerificationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17237a;

    /* renamed from: b */
    @NonNull
    public final DimmerView f17238b;

    /* renamed from: c */
    @NonNull
    public final MemberVerificationView f17239c;

    /* renamed from: d */
    @NonNull
    public final MemberVerificationAvatarView f17240d;

    /* renamed from: e */
    @NonNull
    public final LoadingButton f17241e;

    /* renamed from: f */
    @NonNull
    public final RecyclerView f17242f;

    /* renamed from: g */
    @NonNull
    public final NestedScrollView f17243g;

    public WidgetMemberVerificationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull CustomAppBarLayout customAppBarLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull DimmerView dimmerView, @NonNull MemberVerificationView memberVerificationView, @NonNull MemberVerificationAvatarView memberVerificationAvatarView, @NonNull LoadingButton loadingButton, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView) {
        this.f17237a = coordinatorLayout;
        this.f17238b = dimmerView;
        this.f17239c = memberVerificationView;
        this.f17240d = memberVerificationAvatarView;
        this.f17241e = loadingButton;
        this.f17242f = recyclerView;
        this.f17243g = nestedScrollView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17237a;
    }
}
