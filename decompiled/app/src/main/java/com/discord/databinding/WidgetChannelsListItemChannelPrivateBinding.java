package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetChannelsListItemChannelPrivateBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f16017a;

    /* renamed from: b */
    @NonNull
    public final StatusView f16018b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f16019c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f16020d;

    /* renamed from: e */
    @NonNull
    public final TextView f16021e;

    /* renamed from: f */
    @NonNull
    public final TextView f16022f;

    /* renamed from: g */
    @NonNull
    public final TextView f16023g;

    public WidgetChannelsListItemChannelPrivateBinding(@NonNull RelativeLayout relativeLayout, @NonNull StatusView statusView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16017a = relativeLayout;
        this.f16018b = statusView;
        this.f16019c = simpleDraweeView;
        this.f16020d = simpleDraweeSpanTextView;
        this.f16021e = textView;
        this.f16022f = textView2;
        this.f16023g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16017a;
    }
}
