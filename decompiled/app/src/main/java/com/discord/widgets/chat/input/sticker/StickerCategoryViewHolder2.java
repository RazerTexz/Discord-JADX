package com.discord.widgets.chat.input.sticker;

import android.view.View;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Guild$configure$1, reason: use source file name */
/* JADX INFO: compiled from: StickerCategoryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerCategoryViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ StickerCategoryItem.GuildItem $guildItem;
    public final /* synthetic */ Function1 $onGuildClicked;

    public StickerCategoryViewHolder2(Function1 function1, StickerCategoryItem.GuildItem guildItem) {
        this.$onGuildClicked = function1;
        this.$guildItem = guildItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onGuildClicked.invoke(this.$guildItem);
    }
}
