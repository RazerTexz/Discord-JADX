package com.discord.widgets.chat.managereactions;

import android.view.View;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: ManageReactionsEmojisAdapter.kt */
/* loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ManageReactionsEmojisAdapter.ReactionEmojiItem $data;
    public final /* synthetic */ ManageReactionsEmojisAdapter.ReactionEmojiViewHolder this$0;

    public ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1(ManageReactionsEmojisAdapter.ReactionEmojiViewHolder reactionEmojiViewHolder, ManageReactionsEmojisAdapter.ReactionEmojiItem reactionEmojiItem) {
        this.this$0 = reactionEmojiViewHolder;
        this.$data = reactionEmojiItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<String, Unit> onEmojiSelectedListener = ManageReactionsEmojisAdapter.ReactionEmojiViewHolder.access$getAdapter$p(this.this$0).getOnEmojiSelectedListener();
        if (onEmojiSelectedListener != null) {
            onEmojiSelectedListener.invoke(this.$data.getReaction().getEmoji().c());
        }
    }
}
