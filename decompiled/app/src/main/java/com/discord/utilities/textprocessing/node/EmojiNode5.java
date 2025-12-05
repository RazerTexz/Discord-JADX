package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.EmojiNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: EmojiNode.kt */
/* renamed from: com.discord.utilities.textprocessing.node.EmojiNode$render$clickableSpan$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class EmojiNode5 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ EmojiNode.RenderContext $renderContext;
    public final /* synthetic */ EmojiNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode5(EmojiNode emojiNode, EmojiNode.RenderContext renderContext) {
        super(1);
        this.this$0 = emojiNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.$renderContext.onEmojiClicked(EmojiNode.access$getEmojiIdAndType$p(this.this$0));
    }
}
