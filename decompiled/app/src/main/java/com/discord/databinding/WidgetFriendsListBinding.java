package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.widgets.friends.EmptyFriendsStateView;

/* loaded from: classes.dex */
public final class WidgetFriendsListBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f16676a;

    /* renamed from: b */
    @NonNull
    public final EmptyFriendsStateView f16677b;

    /* renamed from: c */
    @NonNull
    public final AppViewFlipper f16678c;

    /* renamed from: d */
    @NonNull
    public final RecyclerView f16679d;

    /* renamed from: e */
    @NonNull
    public final RecyclerView f16680e;

    public WidgetFriendsListBinding(@NonNull RelativeLayout relativeLayout, @NonNull EmptyFriendsStateView emptyFriendsStateView, @NonNull AppViewFlipper appViewFlipper, @NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f16676a = relativeLayout;
        this.f16677b = emptyFriendsStateView;
        this.f16678c = appViewFlipper;
        this.f16679d = recyclerView;
        this.f16680e = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16676a;
    }
}
