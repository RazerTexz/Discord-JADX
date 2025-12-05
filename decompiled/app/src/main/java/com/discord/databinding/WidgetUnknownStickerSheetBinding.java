package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* loaded from: classes.dex */
public final class WidgetUnknownStickerSheetBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final LinearLayout f18312a;

    /* renamed from: b */
    @NonNull
    public final StickerView f18313b;

    /* renamed from: c */
    @NonNull
    public final TextView f18314c;

    public WidgetUnknownStickerSheetBinding(@NonNull LinearLayout linearLayout, @NonNull StickerView stickerView, @NonNull TextView textView) {
        this.f18312a = linearLayout;
        this.f18313b = stickerView;
        this.f18314c = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f18312a;
    }
}
