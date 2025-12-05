package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.discord.views.guildboost.GuildBoostProgressView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class ViewSettingsBoostedSampleGuildBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f15582a;

    /* renamed from: b */
    @NonNull
    public final TextView f15583b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f15584c;

    /* renamed from: d */
    @NonNull
    public final TextView f15585d;

    /* renamed from: e */
    @NonNull
    public final GuildBoostProgressView f15586e;

    public ViewSettingsBoostedSampleGuildBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull GuildBoostProgressView guildBoostProgressView) {
        this.f15582a = cardView;
        this.f15583b = textView;
        this.f15584c = simpleDraweeView;
        this.f15585d = textView2;
        this.f15586e = guildBoostProgressView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15582a;
    }
}
