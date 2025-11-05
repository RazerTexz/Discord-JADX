package com.discord.widgets.chat.input.sticker;

import android.view.View;
import com.discord.widgets.chat.input.sticker.StickerCategoryItem;
import kotlin.jvm.functions.Function1;

/* compiled from: StickerCategoryViewHolder.kt */
/* loaded from: classes2.dex */
public final class StickerCategoryViewHolder$Pack$configure$1 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onPackClicked;
    public final /* synthetic */ StickerCategoryItem.PackItem $packItem;

    public StickerCategoryViewHolder$Pack$configure$1(Function1 function1, StickerCategoryItem.PackItem packItem) {
        this.$onPackClicked = function1;
        this.$packItem = packItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onPackClicked.invoke(this.$packItem);
    }
}
