package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.flexbox.FlexboxLayout;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemStartBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f16290a;

    /* renamed from: b */
    @NonNull
    public final TextView f16291b;

    /* renamed from: c */
    @NonNull
    public final TextView f16292c;

    /* renamed from: d */
    @NonNull
    public final TextView f16293d;

    /* renamed from: e */
    @NonNull
    public final TextView f16294e;

    /* renamed from: f */
    @NonNull
    public final FlexboxLayout f16295f;

    /* renamed from: g */
    @NonNull
    public final ImageView f16296g;

    public WidgetChatListAdapterItemStartBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull FlexboxLayout flexboxLayout, @NonNull ImageView imageView) {
        this.f16290a = linearLayout;
        this.f16291b = textView;
        this.f16292c = textView2;
        this.f16293d = textView3;
        this.f16294e = textView4;
        this.f16295f = flexboxLayout;
        this.f16296g = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16290a;
    }
}
