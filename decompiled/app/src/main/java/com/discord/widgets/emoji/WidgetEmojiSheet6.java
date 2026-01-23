package com.discord.widgets.emoji;

import android.view.View;

/* JADX INFO: renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet6 implements View.OnClickListener {
    public final /* synthetic */ boolean $isFavorite$inlined;
    public final /* synthetic */ WidgetEmojiSheet this$0;

    public WidgetEmojiSheet6(WidgetEmojiSheet widgetEmojiSheet, boolean z2) {
        this.this$0 = widgetEmojiSheet;
        this.$isFavorite$inlined = z2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetEmojiSheet.access$getViewModel$p(this.this$0).setFavorite(true);
    }
}
