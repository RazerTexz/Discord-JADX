package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guildboost.GuildBoostMarketingView;
import com.discord.views.guildboost.GuildBoostSubscriptionUpsellView;
import com.google.android.material.button.MaterialButton;
import p007b.p008a.p025i.ViewSettingsPremiumGuildNoGuildsBinding;

/* loaded from: classes.dex */
public final class WidgetSettingsBoostBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f17920a;

    /* renamed from: b */
    @NonNull
    public final ViewSettingsPremiumGuildNoGuildsBinding f17921b;

    /* renamed from: c */
    @NonNull
    public final AppViewFlipper f17922c;

    /* renamed from: d */
    @NonNull
    public final GuildBoostMarketingView f17923d;

    /* renamed from: e */
    @NonNull
    public final RecyclerView f17924e;

    /* renamed from: f */
    @NonNull
    public final MaterialButton f17925f;

    /* renamed from: g */
    @NonNull
    public final RecyclerView f17926g;

    /* renamed from: h */
    @NonNull
    public final LinkifiedTextView f17927h;

    /* renamed from: i */
    @NonNull
    public final LinearLayout f17928i;

    /* renamed from: j */
    @NonNull
    public final GuildBoostSubscriptionUpsellView f17929j;

    public WidgetSettingsBoostBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ViewSettingsPremiumGuildNoGuildsBinding viewSettingsPremiumGuildNoGuildsBinding, @NonNull AppViewFlipper appViewFlipper, @NonNull GuildBoostMarketingView guildBoostMarketingView, @NonNull RecyclerView recyclerView, @NonNull MaterialButton materialButton, @NonNull RecyclerView recyclerView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull LinearLayout linearLayout, @NonNull GuildBoostSubscriptionUpsellView guildBoostSubscriptionUpsellView) {
        this.f17920a = coordinatorLayout;
        this.f17921b = viewSettingsPremiumGuildNoGuildsBinding;
        this.f17922c = appViewFlipper;
        this.f17923d = guildBoostMarketingView;
        this.f17924e = recyclerView;
        this.f17925f = materialButton;
        this.f17926g = recyclerView2;
        this.f17927h = linkifiedTextView;
        this.f17928i = linearLayout;
        this.f17929j = guildBoostSubscriptionUpsellView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17920a;
    }
}
