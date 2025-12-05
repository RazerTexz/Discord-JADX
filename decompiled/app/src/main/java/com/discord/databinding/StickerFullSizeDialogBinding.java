package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;

/* loaded from: classes.dex */
public final class StickerFullSizeDialogBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15267a;

    /* renamed from: b */
    @NonNull
    public final StickerView f15268b;

    public StickerFullSizeDialogBinding(@NonNull FrameLayout frameLayout, @NonNull StickerView stickerView) {
        this.f15267a = frameLayout;
        this.f15268b = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15267a;
    }
}
