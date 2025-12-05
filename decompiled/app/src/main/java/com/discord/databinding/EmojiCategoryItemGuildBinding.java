package com.discord.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.chat.input.emoji.GuildIcon;
import p007b.p008a.p025i.ExpressionPickerCategorySelectionOverlineViewBinding;

/* loaded from: classes.dex */
public final class EmojiCategoryItemGuildBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final FrameLayout f15050a;

    /* renamed from: b */
    @NonNull
    public final GuildIcon f15051b;

    /* renamed from: c */
    @NonNull
    public final ExpressionPickerCategorySelectionOverlineViewBinding f15052c;

    public EmojiCategoryItemGuildBinding(@NonNull FrameLayout frameLayout, @NonNull GuildIcon guildIcon, @NonNull ExpressionPickerCategorySelectionOverlineViewBinding expressionPickerCategorySelectionOverlineViewBinding) {
        this.f15050a = frameLayout;
        this.f15051b = guildIcon;
        this.f15052c = expressionPickerCategorySelectionOverlineViewBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f15050a;
    }
}
