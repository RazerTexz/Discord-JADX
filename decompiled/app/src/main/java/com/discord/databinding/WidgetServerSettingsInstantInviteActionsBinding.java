package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetServerSettingsInstantInviteActionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final NestedScrollView f17676a;

    /* renamed from: b */
    @NonNull
    public final TextView f17677b;

    /* renamed from: c */
    @NonNull
    public final TextView f17678c;

    /* renamed from: d */
    @NonNull
    public final TextView f17679d;

    /* renamed from: e */
    @NonNull
    public final TextView f17680e;

    public WidgetServerSettingsInstantInviteActionsBinding(@NonNull NestedScrollView nestedScrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4) {
        this.f17676a = nestedScrollView;
        this.f17677b = textView;
        this.f17678c = textView2;
        this.f17679d = textView3;
        this.f17680e = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17676a;
    }
}
