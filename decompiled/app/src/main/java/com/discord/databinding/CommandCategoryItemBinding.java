package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* loaded from: classes.dex */
public final class CommandCategoryItemBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15018a;

    /* renamed from: b */
    @NonNull
    public final SimpleDraweeView f15019b;

    /* renamed from: c */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f15020c;

    public CommandCategoryItemBinding(@NonNull FrameLayout frameLayout, @NonNull SimpleDraweeView simpleDraweeView, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding) {
        this.f15018a = frameLayout;
        this.f15019b = simpleDraweeView;
        this.f15020c = expressionPickerCategorySelectionOverlineViewBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15018a;
    }
}
