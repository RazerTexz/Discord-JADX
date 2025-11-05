package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.stores.StoreStream;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import d0.k;
import d0.l;

/* compiled from: WidgetEmojiAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ Emoji $emoji;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    public WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, Emoji emoji) {
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
            k.a aVar = k.j;
            k.m97constructorimpl(Boolean.valueOf(WidgetEmojiAdapter.EmojiViewHolder.access$getBinding$p(emojiViewHolder).f2101b.performHapticFeedback(3)));
        } catch (Throwable th) {
            k.a aVar2 = k.j;
            k.m97constructorimpl(l.createFailure(th));
        }
    }
}
