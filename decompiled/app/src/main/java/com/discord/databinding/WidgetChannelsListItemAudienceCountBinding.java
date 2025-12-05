package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelsListItemAudienceCountBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f16005a;

    /* renamed from: b */
    @NonNull
    public final TextView f16006b;

    public WidgetChannelsListItemAudienceCountBinding(@NonNull RelativeLayout relativeLayout, @NonNull ImageView imageView, @NonNull TextView textView) {
        this.f16005a = relativeLayout;
        this.f16006b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16005a;
    }
}
