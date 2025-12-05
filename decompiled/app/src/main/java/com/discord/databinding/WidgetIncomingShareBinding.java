package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.user.search.ViewGlobalSearchItem;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetIncomingShareBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17192a;

    /* renamed from: b */
    @NonNull
    public final DimmerView f17193b;

    /* renamed from: c */
    @NonNull
    public final ViewEmbedGameInvite f17194c;

    /* renamed from: d */
    @NonNull
    public final TextInputLayout f17195d;

    /* renamed from: e */
    @NonNull
    public final RecyclerView f17196e;

    /* renamed from: f */
    @NonNull
    public final CardView f17197f;

    /* renamed from: g */
    @NonNull
    public final TextInputLayout f17198g;

    /* renamed from: h */
    @NonNull
    public final RecyclerView f17199h;

    /* renamed from: i */
    @NonNull
    public final AppViewFlipper f17200i;

    /* renamed from: j */
    @NonNull
    public final NestedScrollView f17201j;

    /* renamed from: k */
    @NonNull
    public final AppViewFlipper f17202k;

    /* renamed from: l */
    @NonNull
    public final ViewGlobalSearchItem f17203l;

    /* renamed from: m */
    @NonNull
    public final ImageView f17204m;

    public WidgetIncomingShareBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull DimmerView dimmerView, @NonNull ViewEmbedGameInvite viewEmbedGameInvite, @NonNull TextInputLayout textInputLayout, @NonNull RecyclerView recyclerView, @NonNull CardView cardView, @NonNull TextInputLayout textInputLayout2, @NonNull RecyclerView recyclerView2, @NonNull ImageView imageView, @NonNull AppViewFlipper appViewFlipper, @NonNull NestedScrollView nestedScrollView, @NonNull AppViewFlipper appViewFlipper2, @NonNull ViewGlobalSearchItem viewGlobalSearchItem, @NonNull ImageView imageView2) {
        this.f17192a = coordinatorLayout;
        this.f17193b = dimmerView;
        this.f17194c = viewEmbedGameInvite;
        this.f17195d = textInputLayout;
        this.f17196e = recyclerView;
        this.f17197f = cardView;
        this.f17198g = textInputLayout2;
        this.f17199h = recyclerView2;
        this.f17200i = appViewFlipper;
        this.f17201j = nestedScrollView;
        this.f17202k = appViewFlipper2;
        this.f17203l = viewGlobalSearchItem;
        this.f17204m = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17192a;
    }
}
