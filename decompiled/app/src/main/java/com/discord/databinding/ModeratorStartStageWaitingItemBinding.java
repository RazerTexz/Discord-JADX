package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.UserSummaryView;

/* loaded from: classes.dex */
public final class ModeratorStartStageWaitingItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15186a;

    /* renamed from: b */
    @NonNull
    public final UserSummaryView f15187b;

    /* renamed from: c */
    @NonNull
    public final TextView f15188c;

    public ModeratorStartStageWaitingItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull UserSummaryView userSummaryView, @NonNull TextView textView) {
        this.f15186a = constraintLayout;
        this.f15187b = userSummaryView;
        this.f15188c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15186a;
    }
}
