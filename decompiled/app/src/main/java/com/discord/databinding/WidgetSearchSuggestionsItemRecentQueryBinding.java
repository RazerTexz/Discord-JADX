package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemRecentQueryBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f17439a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f17440b;

    /* renamed from: c */
    @NonNull
    public final TextView f17441c;

    public WidgetSearchSuggestionsItemRecentQueryBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f17439a = relativeLayout;
        this.f17440b = relativeLayout2;
        this.f17441c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17439a;
    }
}
