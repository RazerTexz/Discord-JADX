package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetGlobalStatusIndicatorBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f16718a;

    /* renamed from: b */
    @NonNull
    public final TextView f16719b;

    /* renamed from: c */
    @NonNull
    public final LinearLayout f16720c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f16721d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f16722e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f16723f;

    /* renamed from: g */
    @NonNull
    public final MaterialButton f16724g;

    /* renamed from: h */
    @NonNull
    public final ImageView f16725h;

    /* renamed from: i */
    @NonNull
    public final TextView f16726i;

    public WidgetGlobalStatusIndicatorBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull MaterialButton materialButton, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull MaterialButton materialButton2, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f16718a = linearLayout;
        this.f16719b = textView;
        this.f16720c = linearLayout2;
        this.f16721d = materialButton;
        this.f16722e = linearLayout3;
        this.f16723f = linearLayout4;
        this.f16724g = materialButton2;
        this.f16725h = imageView;
        this.f16726i = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16718a;
    }
}
