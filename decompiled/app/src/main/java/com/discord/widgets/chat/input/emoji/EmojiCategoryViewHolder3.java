package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiCategoryViewHolder.kt */
/* renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder$Standard$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiCategoryViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onCategoryClicked;
    public final /* synthetic */ EmojiCategoryItem.StandardItem $standardCategoryItem;

    public EmojiCategoryViewHolder3(Function1 function1, EmojiCategoryItem.StandardItem standardItem) {
        this.$onCategoryClicked = function1;
        this.$standardCategoryItem = standardItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onCategoryClicked.invoke(this.$standardCategoryItem);
    }
}
