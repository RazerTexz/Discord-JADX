package com.discord.widgets.roles;

import android.annotation.SuppressLint;
import android.content.Context;
import com.discord.utilities.textprocessing.node.EmojiNode;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.roles.RoleIconView$showRoleIconToast$renderContext$1, reason: use source file name */
/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView2 implements EmojiNode.RenderContext {
    public final /* synthetic */ Context $context;

    @SuppressLint({"StaticFieldLeak"})
    private final Context context;
    private final boolean isAnimationEnabled;

    public RoleIconView2(Context context) {
        this.$context = context;
        this.context = context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public Context getContext() {
        return this.context;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
    public boolean getIsAnimationEnabled() {
        return this.isAnimationEnabled;
    }

    @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
    public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
    }
}
