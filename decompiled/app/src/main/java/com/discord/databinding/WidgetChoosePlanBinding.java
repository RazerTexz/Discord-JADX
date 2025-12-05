package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.view.text.LinkifiedTextView;

/* loaded from: classes.dex */
public final class WidgetChoosePlanBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CoordinatorLayout f16383a;

    /* renamed from: b */
    @NonNull
    public final LinearLayout f16384b;

    /* renamed from: c */
    @NonNull
    public final LinkifiedTextView f16385c;

    /* renamed from: d */
    @NonNull
    public final RecyclerView f16386d;

    /* renamed from: e */
    @NonNull
    public final DimmerView f16387e;

    public WidgetChoosePlanBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout, @NonNull LinkifiedTextView linkifiedTextView, @NonNull RecyclerView recyclerView, @NonNull DimmerView dimmerView) {
        this.f16383a = coordinatorLayout;
        this.f16384b = linearLayout;
        this.f16385c = linkifiedTextView;
        this.f16386d = recyclerView;
        this.f16387e = dimmerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16383a;
    }
}
