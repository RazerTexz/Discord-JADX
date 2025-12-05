package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSettingsItemBackupCodeBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextView f17975a;

    /* renamed from: b */
    @NonNull
    public final TextView f17976b;

    public WidgetSettingsItemBackupCodeBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f17975a = textView;
        this.f17976b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17975a;
    }
}
