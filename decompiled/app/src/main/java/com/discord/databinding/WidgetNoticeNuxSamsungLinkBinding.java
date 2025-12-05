package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class WidgetNoticeNuxSamsungLinkBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17305a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17306b;

    /* renamed from: c */
    @NonNull
    public final MaterialButton f17307c;

    public WidgetNoticeNuxSamsungLinkBinding(@NonNull LinearLayout linearLayout, @NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f17305a = linearLayout;
        this.f17306b = materialButton;
        this.f17307c = materialButton2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17305a;
    }
}
