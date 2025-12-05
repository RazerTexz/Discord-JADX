package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import kotlin.jvm.functions.Function1;

/* compiled from: EmojiCategoryViewHolder.kt */
/* renamed from: com.discord.widgets.chat.input.emoji.EmojiCategoryViewHolder$Guild$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiCategoryViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ EmojiCategoryItem.GuildItem $guildCategoryItem;
    public final /* synthetic */ Function1 $onCategoryClicked;

    public EmojiCategoryViewHolder2(Function1 function1, EmojiCategoryItem.GuildItem guildItem) {
        this.$onCategoryClicked = function1;
        this.$guildCategoryItem = guildItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onCategoryClicked.invoke(this.$guildCategoryItem);
    }
}
