package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.chip.Chip;

/* loaded from: classes.dex */
public final class StickerStoreHeaderItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f15281a;

    /* renamed from: b */
    @NonNull
    public final FrameLayout f15282b;

    /* renamed from: c */
    @NonNull
    public final RelativeLayout f15283c;

    /* renamed from: d */
    @NonNull
    public final TextView f15284d;

    /* renamed from: e */
    @NonNull
    public final FrameLayout f15285e;

    /* renamed from: f */
    @NonNull
    public final TextView f15286f;

    /* renamed from: g */
    @NonNull
    public final TextView f15287g;

    public StickerStoreHeaderItemBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull Chip chip, @NonNull FrameLayout frameLayout2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f15281a = linearLayout;
        this.f15282b = frameLayout;
        this.f15283c = relativeLayout;
        this.f15284d = textView;
        this.f15285e = frameLayout2;
        this.f15286f = textView2;
        this.f15287g = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15281a;
    }
}
