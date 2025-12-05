package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetNoticeDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17295a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f17296b;

    /* renamed from: c */
    @NonNull
    public final LinkifiedTextView f17297c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f17298d;

    /* renamed from: e */
    @NonNull
    public final TextView f17299e;

    /* renamed from: f */
    @NonNull
    public final LinearLayout f17300f;

    /* renamed from: g */
    @NonNull
    public final MaterialButton f17301g;

    public WidgetNoticeDialogBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull MaterialButton materialButton, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull MaterialButton materialButton2) {
        this.f17295a = linearLayout;
        this.f17296b = linearLayout2;
        this.f17297c = linkifiedTextView;
        this.f17298d = materialButton;
        this.f17299e = textView;
        this.f17300f = linearLayout3;
        this.f17301g = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17295a;
    }
}
