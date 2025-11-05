package com.discord.utilities.textprocessing.node;

import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.m;

/* compiled from: EmojiNode.kt */
/* loaded from: classes2.dex */
public final class EmojiNode$Companion$renderEmoji$1 implements EmojiNode.RenderContext {
    public final /* synthetic */ boolean $isAnimationEnabled;
    public final /* synthetic */ SimpleDraweeSpanTextView $this_renderEmoji;
    private final Context context;
    private final boolean isAnimationEnabled;

    public EmojiNode$Companion$renderEmoji$1(SimpleDraweeSpanTextView simpleDraweeSpanTextView, boolean z2) {
        this.$this_renderEmoji = simpleDraweeSpanTextView;
        this.$isAnimationEnabled = z2;
        this.context = simpleDraweeSpanTextView.getContext();
        this.isAnimationEnabled = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    /* renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
    }
}
