package com.discord.widgets.chat.input.sticker;

import android.view.View;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import kotlin.jvm.functions.Function1;

/* compiled from: StickerCategoryViewHolder.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Pack$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerCategoryViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onPackClicked;
    public final /* synthetic */ StickerCategoryItem.PackItem $packItem;

    public StickerCategoryViewHolder3(Function1 function1, StickerCategoryItem.PackItem packItem) {
        this.$onPackClicked = function1;
        this.$packItem = packItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onPackClicked.invoke(this.$packItem);
    }
}
