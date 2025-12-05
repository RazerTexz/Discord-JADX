package com.discord.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public final class WidgetCreationIntentBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16441a;

    /* renamed from: b */
    @NonNull
    public final MaterialCardView f16442b;

    /* renamed from: c */
    @NonNull
    public final TextView f16443c;

    /* renamed from: d */
    @NonNull
    public final MaterialCardView f16444d;

    /* renamed from: e */
    @NonNull
    public final TextView f16445e;

    /* renamed from: f */
    @NonNull
    public final LinkifiedTextView f16446f;

    public WidgetCreationIntentBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull MaterialCardView materialCardView, @NonNull TextView textView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f16441a = coordinatorLayout;
        this.f16442b = materialCardView;
        this.f16443c = textView;
        this.f16444d = materialCardView2;
        this.f16445e = textView2;
        this.f16446f = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16441a;
    }
}
