package com.discord.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetMemberVerificationSuccessBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RelativeLayout f17262a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17263b;

    /* renamed from: c */
    @NonNull
    public final TextView f17264c;

    public WidgetMemberVerificationSuccessBinding(@NonNull RelativeLayout relativeLayout, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull CardView cardView) {
        this.f17262a = relativeLayout;
        this.f17263b = materialButton;
        this.f17264c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17262a;
    }
}
