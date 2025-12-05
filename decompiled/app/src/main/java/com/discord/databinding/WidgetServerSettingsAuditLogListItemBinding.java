package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetServerSettingsAuditLogListItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final CardView f17521a;

    /* renamed from: b */
    @NonNull
    public final ImageView f17522b;

    /* renamed from: c */
    @NonNull
    public final ImageView f17523c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f17524d;

    /* renamed from: e */
    @NonNull
    public final TextView f17525e;

    /* renamed from: f */
    @NonNull
    public final TextView f17526f;

    /* renamed from: g */
    @NonNull
    public final TextView f17527g;

    /* renamed from: h */
    @NonNull
    public final ImageView f17528h;

    /* renamed from: i */
    @NonNull
    public final RelativeLayout f17529i;

    public WidgetServerSettingsAuditLogListItemBinding(@NonNull CardView cardView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView3, @NonNull RelativeLayout relativeLayout) {
        this.f17521a = cardView;
        this.f17522b = imageView;
        this.f17523c = imageView2;
        this.f17524d = simpleDraweeView;
        this.f17525e = textView;
        this.f17526f = textView2;
        this.f17527g = textView3;
        this.f17528h = imageView3;
        this.f17529i = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17521a;
    }
}
