package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.rounded.RoundedCoordinatorLayout;
import com.discord.views.CustomAppBarLayout;
import com.discord.widgets.friends.EmptyFriendsStateView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetChannelsListBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RoundedCoordinatorLayout f15968a;

    /* renamed from: b */
    @NonNull
    public final CustomAppBarLayout f15969b;

    /* renamed from: c */
    @NonNull
    public final RecyclerView f15970c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f15971d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f15972e;

    /* renamed from: f */
    @NonNull
    public final TextView f15973f;

    /* renamed from: g */
    @NonNull
    public final TextView f15974g;

    /* renamed from: h */
    @NonNull
    public final ConstraintLayout f15975h;

    /* renamed from: i */
    @NonNull
    public final MaterialButton f15976i;

    /* renamed from: j */
    @NonNull
    public final Toolbar f15977j;

    /* renamed from: k */
    @NonNull
    public final TextView f15978k;

    /* renamed from: l */
    @NonNull
    public final AppCompatImageView f15979l;

    /* renamed from: m */
    @NonNull
    public final ViewStub f15980m;

    /* renamed from: n */
    @NonNull
    public final CollapsingToolbarLayout f15981n;

    /* renamed from: o */
    @NonNull
    public final RoundedCoordinatorLayout f15982o;

    /* renamed from: p */
    @NonNull
    public final EmptyFriendsStateView f15983p;

    public WidgetChannelsListBinding(@NonNull RoundedCoordinatorLayout roundedCoordinatorLayout, @NonNull CustomAppBarLayout customAppBarLayout, @NonNull RecyclerView recyclerView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ConstraintLayout constraintLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Toolbar toolbar, @NonNull TextView textView5, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull View view2, @NonNull ViewStub viewStub, @NonNull Toolbar toolbar2, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull RoundedCoordinatorLayout roundedCoordinatorLayout2, @NonNull EmptyFriendsStateView emptyFriendsStateView) {
        this.f15968a = roundedCoordinatorLayout;
        this.f15969b = customAppBarLayout;
        this.f15970c = recyclerView;
        this.f15971d = simpleDraweeView;
        this.f15972e = frameLayout;
        this.f15973f = textView;
        this.f15974g = textView2;
        this.f15975h = constraintLayout;
        this.f15976i = materialButton;
        this.f15977j = toolbar;
        this.f15978k = textView5;
        this.f15979l = appCompatImageView;
        this.f15980m = viewStub;
        this.f15981n = collapsingToolbarLayout;
        this.f15982o = roundedCoordinatorLayout2;
        this.f15983p = emptyFriendsStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15968a;
    }
}
