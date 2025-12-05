package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* loaded from: classes.dex */
public final class StickerCategoryItemRecentBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15265a;

    /* renamed from: b */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f15266b;

    public StickerCategoryItemRecentBinding(@NonNull FrameLayout frameLayout, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding) {
        this.f15265a = frameLayout;
        this.f15266b = expressionPickerCategorySelectionOverlineViewBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15265a;
    }
}
