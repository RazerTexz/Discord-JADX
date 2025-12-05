package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetFriendsListAdapterItemPendingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f16667a;

    /* renamed from: b */
    @NonNull
    public final AppCompatImageView f16668b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeSpanTextView f16669c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f16670d;

    /* renamed from: e */
    @NonNull
    public final AppCompatImageView f16671e;

    /* renamed from: f */
    @NonNull
    public final TextView f16672f;

    /* renamed from: g */
    @NonNull
    public final StatusView f16673g;

    public WidgetFriendsListAdapterItemPendingBinding(@NonNull RelativeLayout relativeLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull LinearLayout linearLayout2) {
        this.f16667a = relativeLayout;
        this.f16668b = appCompatImageView;
        this.f16669c = simpleDraweeSpanTextView;
        this.f16670d = simpleDraweeView;
        this.f16671e = appCompatImageView2;
        this.f16672f = textView;
        this.f16673g = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16667a;
    }
}
