package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

/* loaded from: classes.dex */
public final class WidgetFriendsListAdapterItemHeaderBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f16664a;

    /* renamed from: b */
    @NonNull
    public final TextView f16665b;

    public WidgetFriendsListAdapterItemHeaderBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView) {
        this.f16664a = frameLayout;
        this.f16665b = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16664a;
    }
}
