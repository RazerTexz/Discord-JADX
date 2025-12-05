package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetHubEventsPageBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f17185a;

    /* renamed from: b */
    @NonNull
    public final RecyclerView f17186b;

    /* renamed from: c */
    @NonNull
    public final TextView f17187c;

    public WidgetHubEventsPageBinding(@NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull TextView textView) {
        this.f17185a = linearLayout;
        this.f17186b = recyclerView;
        this.f17187c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17185a;
    }
}
