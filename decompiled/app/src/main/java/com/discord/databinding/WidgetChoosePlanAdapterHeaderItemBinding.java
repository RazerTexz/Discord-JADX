package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChoosePlanAdapterHeaderItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f16374a;

    /* renamed from: b */
    @NonNull
    public final TextView f16375b;

    public WidgetChoosePlanAdapterHeaderItemBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f16374a = frameLayout;
        this.f16375b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16374a;
    }
}
