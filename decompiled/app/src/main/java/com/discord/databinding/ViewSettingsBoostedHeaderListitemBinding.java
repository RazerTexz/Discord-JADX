package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class ViewSettingsBoostedHeaderListitemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextView f15580a;

    /* renamed from: b */
    @NonNull
    public final TextView f15581b;

    public ViewSettingsBoostedHeaderListitemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f15580a = textView;
        this.f15581b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15580a;
    }
}
