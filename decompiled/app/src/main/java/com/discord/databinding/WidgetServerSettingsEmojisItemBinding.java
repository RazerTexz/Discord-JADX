package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetServerSettingsEmojisItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f17646a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f17647b;

    /* renamed from: c */
    @NonNull
    public final ConstraintLayout f17648c;

    /* renamed from: d */
    @NonNull
    public final TextView f17649d;

    /* renamed from: e */
    @NonNull
    public final TextView f17650e;

    /* renamed from: f */
    @NonNull
    public final TextView f17651f;

    /* renamed from: g */
    @NonNull
    public final SimpleDraweeView f17652g;

    public WidgetServerSettingsEmojisItemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull TextView textView3, @NonNull SimpleDraweeView simpleDraweeView2) {
        this.f17646a = constraintLayout;
        this.f17647b = simpleDraweeView;
        this.f17648c = constraintLayout2;
        this.f17649d = textView;
        this.f17650e = textView2;
        this.f17651f = textView3;
        this.f17652g = simpleDraweeView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17646a;
    }
}
