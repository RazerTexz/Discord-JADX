package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetMemberVerificationHeaderItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextView f17244a;

    /* renamed from: b */
    @NonNull
    public final TextView f17245b;

    public WidgetMemberVerificationHeaderItemBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f17244a = textView;
        this.f17245b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17244a;
    }
}
