package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.sticker.StickerView;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemSystemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16306a;

    /* renamed from: b */
    @NonNull
    public final AppCompatImageView f16307b;

    /* renamed from: c */
    @NonNull
    public final ConstraintLayout f16308c;

    /* renamed from: d */
    @NonNull
    public final SimpleDraweeView f16309d;

    /* renamed from: e */
    @NonNull
    public final TextView f16310e;

    /* renamed from: f */
    @NonNull
    public final ImageView f16311f;

    /* renamed from: g */
    @NonNull
    public final ImageView f16312g;

    /* renamed from: h */
    @NonNull
    public final LinkifiedTextView f16313h;

    /* renamed from: i */
    @NonNull
    public final TextView f16314i;

    /* renamed from: j */
    @NonNull
    public final LinearLayout f16315j;

    /* renamed from: k */
    @NonNull
    public final StickerView f16316k;

    public WidgetChatListAdapterItemSystemBinding(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull TextView textView2, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull LinkifiedTextView linkifiedTextView, @NonNull TextView textView3, @NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull Guideline guideline) {
        this.f16306a = constraintLayout;
        this.f16307b = appCompatImageView;
        this.f16308c = constraintLayout2;
        this.f16309d = simpleDraweeView;
        this.f16310e = textView2;
        this.f16311f = imageView;
        this.f16312g = imageView2;
        this.f16313h = linkifiedTextView;
        this.f16314i = textView3;
        this.f16315j = linearLayout;
        this.f16316k = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16306a;
    }
}
