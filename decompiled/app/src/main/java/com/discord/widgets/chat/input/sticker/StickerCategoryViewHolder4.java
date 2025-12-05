package com.discord.widgets.chat.input.sticker;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* compiled from: StickerCategoryViewHolder.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.StickerCategoryViewHolder$Recent$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StickerCategoryViewHolder4 implements View.OnClickListener {
    public final /* synthetic */ Function0 $onRecentClicked;

    public StickerCategoryViewHolder4(Function0 function0) {
        this.$onRecentClicked = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onRecentClicked.invoke();
    }
}
