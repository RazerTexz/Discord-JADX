package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class VoiceUserListItemHeaderBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final TextView f15621a;

    /* renamed from: b */
    @NonNull
    public final TextView f15622b;

    public VoiceUserListItemHeaderBinding(@NonNull TextView textView, @NonNull TextView textView2) {
        this.f15621a = textView;
        this.f15622b = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15621a;
    }
}
