package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* loaded from: classes.dex */
public final class WidgetServerSettingsIntegrationListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f17690a;

    /* renamed from: b */
    @NonNull
    public final RelativeLayout f17691b;

    /* renamed from: c */
    @NonNull
    public final View f17692c;

    /* renamed from: d */
    @NonNull
    public final ImageView f17693d;

    /* renamed from: e */
    @NonNull
    public final TextView f17694e;

    /* renamed from: f */
    @NonNull
    public final TextView f17695f;

    /* renamed from: g */
    @NonNull
    public final ImageView f17696g;

    /* renamed from: h */
    @NonNull
    public final CheckedSetting f17697h;

    /* renamed from: i */
    @NonNull
    public final ProgressBar f17698i;

    public WidgetServerSettingsIntegrationListItemBinding(@NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull CheckedSetting checkedSetting, @NonNull ProgressBar progressBar) {
        this.f17690a = frameLayout;
        this.f17691b = relativeLayout;
        this.f17692c = view;
        this.f17693d = imageView;
        this.f17694e = textView;
        this.f17695f = textView2;
        this.f17696g = imageView2;
        this.f17697h = checkedSetting;
        this.f17698i = progressBar;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17690a;
    }
}
