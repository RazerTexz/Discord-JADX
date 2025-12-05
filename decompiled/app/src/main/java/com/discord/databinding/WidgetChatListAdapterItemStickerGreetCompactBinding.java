package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemStickerGreetCompactBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16302a;

    /* renamed from: b */
    @NonNull
    public final StickerView f16303b;

    /* renamed from: c */
    @NonNull
    public final TextView f16304c;

    /* renamed from: d */
    @NonNull
    public final LinearLayout f16305d;

    public WidgetChatListAdapterItemStickerGreetCompactBinding(@NonNull ConstraintLayout constraintLayout, @NonNull StickerView stickerView, @NonNull TextView textView, @NonNull LinearLayout linearLayout) {
        this.f16302a = constraintLayout;
        this.f16303b = stickerView;
        this.f16304c = textView;
        this.f16305d = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16302a;
    }
}
