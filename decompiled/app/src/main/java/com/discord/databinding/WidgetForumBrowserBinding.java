package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p008a.p025i.ForumBrowserEmptyBinding;
import p007b.p008a.p025i.ForumBrowserLoadingBinding;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetForumBrowserBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final ConstraintLayout f16633a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ExtendedFloatingActionButton f16634b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ForumBrowserEmptyBinding f16635c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final ForumBrowserLoadingBinding f16636d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final ViewStub f16637e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final RecyclerView f16638f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final FloatingActionButton f16639g;

    public WidgetForumBrowserBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Guideline guideline, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull ForumBrowserEmptyBinding forumBrowserEmptyBinding, @NonNull ForumBrowserLoadingBinding forumBrowserLoadingBinding, @NonNull ViewStub viewStub, @NonNull RecyclerView recyclerView, @NonNull AppBarLayout appBarLayout, @NonNull Barrier barrier, @NonNull FloatingActionButton floatingActionButton) {
        this.f16633a = constraintLayout;
        this.f16634b = extendedFloatingActionButton;
        this.f16635c = forumBrowserEmptyBinding;
        this.f16636d = forumBrowserLoadingBinding;
        this.f16637e = viewStub;
        this.f16638f = recyclerView;
        this.f16639g = floatingActionButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16633a;
    }
}
