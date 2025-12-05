package com.discord.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.UserListItemView;

/* loaded from: classes.dex */
public final class WidgetSearchSuggestionsItemUserBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final UserListItemView f17447a;

    /* renamed from: b */
    @NonNull
    public final UserListItemView f17448b;

    public WidgetSearchSuggestionsItemUserBinding(@NonNull UserListItemView userListItemView, @NonNull UserListItemView userListItemView2) {
        this.f17447a = userListItemView;
        this.f17448b = userListItemView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17447a;
    }
}
