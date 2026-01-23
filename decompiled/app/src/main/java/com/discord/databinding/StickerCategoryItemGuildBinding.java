package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* JADX INFO: loaded from: classes.dex */
public final class StickerCategoryItemGuildBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final FrameLayout f15259a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f15260b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final GuildIcon f15261c;

    public StickerCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding, @NonNull GuildIcon guildIcon) {
        this.f15259a = frameLayout;
        this.f15260b = expressionPickerCategorySelectionOverlineViewBinding;
        this.f15261c = guildIcon;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15259a;
    }
}
