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
public final class WidgetFriendsListAdapterItemFriendBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f16657a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeSpanTextView f16658b;

    /* renamed from: c */
    @NonNull
    public final SimpleDraweeView f16659c;

    /* renamed from: d */
    @NonNull
    public final AppCompatImageView f16660d;

    /* renamed from: e */
    @NonNull
    public final AppCompatImageView f16661e;

    /* renamed from: f */
    @NonNull
    public final TextView f16662f;

    /* renamed from: g */
    @NonNull
    public final StatusView f16663g;

    public WidgetFriendsListAdapterItemFriendBinding(@NonNull RelativeLayout relativeLayout, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull SimpleDraweeView simpleDraweeView, @NonNull LinearLayout linearLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull TextView textView, @NonNull StatusView statusView, @NonNull LinearLayout linearLayout2) {
        this.f16657a = relativeLayout;
        this.f16658b = simpleDraweeSpanTextView;
        this.f16659c = simpleDraweeView;
        this.f16660d = appCompatImageView;
        this.f16661e = appCompatImageView2;
        this.f16662f = textView;
        this.f16663g = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16657a;
    }
}
