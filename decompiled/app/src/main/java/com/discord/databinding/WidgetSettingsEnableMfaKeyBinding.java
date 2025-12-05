package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSettingsEnableMfaKeyBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17947a;

    /* renamed from: b */
    @NonNull
    public final TextView f17948b;

    /* renamed from: c */
    @NonNull
    public final TextView f17949c;

    /* renamed from: d */
    @NonNull
    public final TextView f17950d;

    public WidgetSettingsEnableMfaKeyBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f17947a = linearLayout;
        this.f17948b = textView;
        this.f17949c = textView2;
        this.f17950d = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17947a;
    }
}
