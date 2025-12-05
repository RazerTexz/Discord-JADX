package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetGuildStickerSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final AppViewFlipper f17057a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f17058b;

    /* renamed from: c */
    @NonNull
    public final TextView f17059c;

    /* renamed from: d */
    @NonNull
    public final AppViewFlipper f17060d;

    /* renamed from: e */
    @NonNull
    public final LinearLayout f17061e;

    /* renamed from: f */
    @NonNull
    public final SimpleDraweeView f17062f;

    /* renamed from: g */
    @NonNull
    public final TextView f17063g;

    /* renamed from: h */
    @NonNull
    public final FrameLayout f17064h;

    /* renamed from: i */
    @NonNull
    public final TextView f17065i;

    /* renamed from: j */
    @NonNull
    public final TextView f17066j;

    /* renamed from: k */
    @NonNull
    public final MaterialButton f17067k;

    /* renamed from: l */
    @NonNull
    public final MaterialButton f17068l;

    /* renamed from: m */
    @NonNull
    public final StickerView f17069m;

    /* renamed from: n */
    @NonNull
    public final TextView f17070n;

    public WidgetGuildStickerSheetBinding(@NonNull AppViewFlipper appViewFlipper, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull AppViewFlipper appViewFlipper2, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull StickerView stickerView, @NonNull TextView textView6) {
        this.f17057a = appViewFlipper;
        this.f17058b = frameLayout;
        this.f17059c = textView;
        this.f17060d = appViewFlipper2;
        this.f17061e = linearLayout;
        this.f17062f = simpleDraweeView;
        this.f17063g = textView3;
        this.f17064h = frameLayout2;
        this.f17065i = textView4;
        this.f17066j = textView5;
        this.f17067k = materialButton;
        this.f17068l = materialButton2;
        this.f17069m = stickerView;
        this.f17070n = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17057a;
    }
}
