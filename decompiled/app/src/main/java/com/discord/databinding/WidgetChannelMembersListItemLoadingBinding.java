package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChannelMembersListItemLoadingBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15859a;

    /* renamed from: b */
    @NonNull
    public final Guideline f15860b;

    public WidgetChannelMembersListItemLoadingBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull Guideline guideline) {
        this.f15859a = constraintLayout;
        this.f15860b = guideline;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15859a;
    }
}
