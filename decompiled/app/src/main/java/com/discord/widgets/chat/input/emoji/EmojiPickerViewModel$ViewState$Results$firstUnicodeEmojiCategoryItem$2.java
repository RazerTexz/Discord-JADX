package com.discord.widgets.chat.input.emoji;

import com.discord.widgets.chat.input.emoji.EmojiCategoryItem;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import d0.z.d.Lambda;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* compiled from: EmojiPickerViewModel.kt */
/* loaded from: classes2.dex */
public final class EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2 extends Lambda implements Function0<EmojiCategoryItem.StandardItem> {
    public final /* synthetic */ EmojiPickerViewModel.ViewState.Results this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiPickerViewModel$ViewState$Results$firstUnicodeEmojiCategoryItem$2(EmojiPickerViewModel.ViewState.Results results) {
        super(0);
        this.this$0 = results;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiCategoryItem.StandardItem invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiCategoryItem.StandardItem invoke() {
        Object next;
        Iterator<T> it = this.this$0.getCategoryItems().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((EmojiCategoryItem) next).containsOnlyUnicodeEmoji()) {
                break;
            }
        }
        return (EmojiCategoryItem.StandardItem) (next instanceof EmojiCategoryItem.StandardItem ? next : null);
    }
}
