package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemBotComponentRowBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16169a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f16170b;

    /* renamed from: c */
    @NonNull
    public final View f16171c;

    /* renamed from: d */
    @NonNull
    public final View f16172d;

    public WidgetChatListAdapterItemBotComponentRowBinding(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull View view2) {
        this.f16169a = constraintLayout;
        this.f16170b = linearLayout;
        this.f16171c = view;
        this.f16172d = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16169a;
    }
}
