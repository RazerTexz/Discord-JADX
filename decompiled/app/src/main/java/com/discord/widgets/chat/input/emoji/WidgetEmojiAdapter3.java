package com.discord.widgets.chat.input.emoji;

import android.view.View;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.Result2;
import p507d0.Result3;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiAdapter$EmojiViewHolder$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetEmojiAdapter.EmojiItem $emojiItem;
    public final /* synthetic */ WidgetEmojiAdapter.EmojiViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter3(WidgetEmojiAdapter.EmojiViewHolder emojiViewHolder, WidgetEmojiAdapter.EmojiItem emojiItem) {
        super(1);
        this.this$0 = emojiViewHolder;
        this.$emojiItem = emojiItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Object objM11474constructorimpl;
        Emoji emoji;
        Intrinsics3.checkNotNullParameter(view, "it");
        try {
            Result2.a aVar = Result2.f25169j;
            emoji = this.$emojiItem.getEmoji();
        } catch (Throwable th) {
            Result2.a aVar2 = Result2.f25169j;
            objM11474constructorimpl = Result2.m11474constructorimpl(Result3.createFailure(th));
        }
        if (emoji == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiCustom");
        }
        objM11474constructorimpl = Result2.m11474constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiCustom) emoji));
        if (Result2.m11476exceptionOrNullimpl(objM11474constructorimpl) != null) {
            try {
                Result2.a aVar3 = Result2.f25169j;
                Emoji emoji2 = this.$emojiItem.getEmoji();
                if (emoji2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.discord.models.domain.emoji.ModelEmojiUnicode");
                }
                objM11474constructorimpl = Result2.m11474constructorimpl(EmojiNode.INSTANCE.generateEmojiIdAndType((ModelEmojiUnicode) emoji2));
            } catch (Throwable th2) {
                Result2.a aVar4 = Result2.f25169j;
                objM11474constructorimpl = Result2.m11474constructorimpl(Result3.createFailure(th2));
            }
        }
        if (Result2.m11479isSuccessimpl(objM11474constructorimpl)) {
            WidgetEmojiAdapter.access$getHideKeyboard$p(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0)).invoke();
            WidgetEmojiSheet.INSTANCE.show(WidgetEmojiAdapter.access$getFragmentManager$p(WidgetEmojiAdapter.EmojiViewHolder.access$getAdapter$p(this.this$0)), (EmojiNode.EmojiIdAndType) objM11474constructorimpl);
        }
    }
}
