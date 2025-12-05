package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetChatInputAutocompleteItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16087a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f16088b;

    /* renamed from: c */
    @NonNull
    public final TextView f16089c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeSpanTextView f16090d;

    /* renamed from: e */
    @NonNull
    public final TextView f16091e;

    /* renamed from: f */
    @NonNull
    public final TextView f16092f;

    /* renamed from: g */
    @NonNull
    public final StatusView f16093g;

    public WidgetChatInputAutocompleteItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull Barrier barrier, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull View view, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull StatusView statusView) {
        this.f16087a = constraintLayout;
        this.f16088b = simpleDraweeView;
        this.f16089c = textView;
        this.f16090d = simpleDraweeSpanTextView;
        this.f16091e = textView2;
        this.f16092f = textView3;
        this.f16093g = statusView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16087a;
    }
}
