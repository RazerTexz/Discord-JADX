package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelSearchItemHeaderBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextView f15889a;

    /* renamed from: b */
    @NonNull
    public final TextView f15890b;

    public WidgetChannelSearchItemHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f15889a = textView;
        this.f15890b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15889a;
    }
}
