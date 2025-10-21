package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import d0.Result2;
import d0.Result3;

/* compiled from: WidgetEmojiAdapter.kt */
/* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiAdapter2 implements View.OnClickListener {
    public final /* synthetic */ Emoji $emoji;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    public WidgetEmojiAdapter2(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, Emoji emoji) {
        this.this$0 = emojiViewHolder;
        this.$emoji = emoji;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.$emoji.isUsable() && this.$emoji.isAvailable()) {
            StoreStream.INSTANCE.getEmojis().onEmojiUsed(this.$emoji);
        }
        WidgetEmojiAdapter.access$getOnEmojiSelectedListener$p(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0)).onEmojiSelected(this.$emoji);
        WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder = this.this$0;
        try {
            Result2.a aVar = Result2.j;
            Result2.m97constructorimpl(Boolean.valueOf(WidgetEmojiAdapter.EmojiViewHolder.access$getBinding$p(emojiViewHolder).f2101b.performHapticFeedback(3)));
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.j;
            Result2.m97constructorimpl(Result3.createFailure(th));
        }
    }
}
