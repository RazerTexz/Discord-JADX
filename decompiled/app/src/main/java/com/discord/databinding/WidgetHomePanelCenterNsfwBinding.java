package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetHomePanelCenterNsfwBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17132a;

    /* renamed from: b */
    @NonNull
    public final ImageView f17133b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f17134c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f17135d;

    /* renamed from: e */
    @NonNull
    public final LinkifiedTextView f17136e;

    /* renamed from: f */
    @NonNull
    public final TextView f17137f;

    public WidgetHomePanelCenterNsfwBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView) {
        this.f17132a = linearLayout;
        this.f17133b = imageView;
        this.f17134c = materialButton;
        this.f17135d = materialButton2;
        this.f17136e = linkifiedTextView;
        this.f17137f = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17132a;
    }
}
