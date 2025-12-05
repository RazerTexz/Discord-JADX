package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.user.UserSummaryView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

/* loaded from: classes.dex */
public final class WidgetChannelsListItemActiveEventBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f15996a;

    /* renamed from: b */
    @NonNull
    public final ImageView f15997b;

    /* renamed from: c */
    @NonNull
    public final TextView f15998c;

    /* renamed from: d */
    @NonNull
    public final MaterialButton f15999d;

    /* renamed from: e */
    @NonNull
    public final TextView f16000e;

    /* renamed from: f */
    @NonNull
    public final TextView f16001f;

    /* renamed from: g */
    @NonNull
    public final TextView f16002g;

    /* renamed from: h */
    @NonNull
    public final UserSummaryView f16003h;

    /* renamed from: i */
    @NonNull
    public final MaterialTextView f16004i;

    public WidgetChannelsListItemActiveEventBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull TextView textView2, @NonNull ImageView imageView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull UserSummaryView userSummaryView, @NonNull MaterialTextView materialTextView) {
        this.f15996a = constraintLayout;
        this.f15997b = imageView;
        this.f15998c = textView;
        this.f15999d = materialButton;
        this.f16000e = textView2;
        this.f16001f = textView3;
        this.f16002g = textView4;
        this.f16003h = userSummaryView;
        this.f16004i = materialTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15996a;
    }
}
