package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class ThreadBrowserItemWarningBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15312a;

    /* renamed from: b */
    @NonNull
    public final TextView f15313b;

    public ThreadBrowserItemWarningBinding(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView) {
        this.f15312a = constraintLayout;
        this.f15313b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15312a;
    }
}
