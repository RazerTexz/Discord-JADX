package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetGuildScheduledEventCreateSuccessBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16974a;

    /* renamed from: b */
    @NonNull
    public final ImageView f16975b;

    /* renamed from: c */
    @NonNull
    public final TextView f16976c;

    /* renamed from: d */
    @NonNull
    public final CheckedSetting f16977d;

    /* renamed from: e */
    @NonNull
    public final MaterialButton f16978e;

    public WidgetGuildScheduledEventCreateSuccessBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull CheckedSetting checkedSetting, @NonNull MaterialButton materialButton, @NonNull ImageView imageView2, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f16974a = constraintLayout;
        this.f16975b = imageView;
        this.f16976c = textView;
        this.f16977d = checkedSetting;
        this.f16978e = materialButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16974a;
    }
}
