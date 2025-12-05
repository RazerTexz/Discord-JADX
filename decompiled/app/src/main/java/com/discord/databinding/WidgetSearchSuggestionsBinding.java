package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetSearchSuggestionsBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final RecyclerView f17430a;

    /* renamed from: b */
    @NonNull
    public final RecyclerView f17431b;

    public WidgetSearchSuggestionsBinding(@NonNull RecyclerView recyclerView, @NonNull RecyclerView recyclerView2) {
        this.f17430a = recyclerView;
        this.f17431b = recyclerView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17430a;
    }
}
