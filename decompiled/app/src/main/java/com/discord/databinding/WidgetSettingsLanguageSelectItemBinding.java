package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSettingsLanguageSelectItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f18001a;

    /* renamed from: b */
    @NonNull
    public final ImageView f18002b;

    /* renamed from: c */
    @NonNull
    public final TextView f18003c;

    /* renamed from: d */
    @NonNull
    public final TextView f18004d;

    public WidgetSettingsLanguageSelectItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull Barrier barrier, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f18001a = constraintLayout;
        this.f18002b = imageView;
        this.f18003c = textView;
        this.f18004d = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18001a;
    }
}
