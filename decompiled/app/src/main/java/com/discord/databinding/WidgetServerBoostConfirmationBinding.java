package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetServerBoostConfirmationBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17461a;

    /* renamed from: b */
    @NonNull
    public final GuildBoostConfirmationView f17462b;

    /* renamed from: c */
    @NonNull
    public final TextView f17463c;

    /* renamed from: d */
    @NonNull
    public final TextView f17464d;

    /* renamed from: e */
    @NonNull
    public final MaterialButton f17465e;

    /* renamed from: f */
    @NonNull
    public final DimmerView f17466f;

    public WidgetServerBoostConfirmationBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull GuildBoostConfirmationView guildBoostConfirmationView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull MaterialButton materialButton, @NonNull DimmerView dimmerView) {
        this.f17461a = coordinatorLayout;
        this.f17462b = guildBoostConfirmationView;
        this.f17463c = textView;
        this.f17464d = textView2;
        this.f17465e = materialButton;
        this.f17466f = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17461a;
    }
}
