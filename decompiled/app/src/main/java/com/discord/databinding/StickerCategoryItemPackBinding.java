package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.sticker.StickerView;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* loaded from: classes.dex */
public final class StickerCategoryItemPackBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15262a;

    /* renamed from: b */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f15263b;

    /* renamed from: c */
    @NonNull
    public final StickerView f15264c;

    public StickerCategoryItemPackBinding(@NonNull FrameLayout frameLayout, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding, @NonNull StickerView stickerView) {
        this.f15262a = frameLayout;
        this.f15263b = expressionPickerCategorySelectionOverlineViewBinding;
        this.f15264c = stickerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15262a;
    }
}
