package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes.dex */
public final class WidgetServerDeleteDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17479a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17480b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f17481c;

    /* renamed from: d */
    @NonNull
    public final TextView f17482d;

    /* renamed from: e */
    @NonNull
    public final TextInputLayout f17483e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f17484f;

    /* renamed from: g */
    @NonNull
    public final TextView f17485g;

    public WidgetServerDeleteDialogBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull TextView textView, @NonNull TextInputLayout textInputLayout, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f17479a = linearLayout;
        this.f17480b = materialButton;
        this.f17481c = materialButton2;
        this.f17482d = textView;
        this.f17483e = textInputLayout;
        this.f17484f = linearLayout2;
        this.f17485g = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17479a;
    }
}
