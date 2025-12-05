package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetGuildsListItemGuildVerticalBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f17115a;

    /* renamed from: b */
    @NonNull
    public final ImageView f17116b;

    /* renamed from: c */
    @NonNull
    public final ImageView f17117c;

    public WidgetGuildsListItemGuildVerticalBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f17115a = relativeLayout;
        this.f17116b = imageView;
        this.f17117c = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17115a;
    }
}
