package com.discord.widgets.chat.input.sticker;

import com.discord.widgets.chat.MessageManager;
import d0.z.d.Intrinsics3;
import java.util.Locale;

/* compiled from: StickerPickerInlineViewModel.kt */
/* loaded from: classes2.dex */
public final class StickerPickerInlineViewModel extends StickerPickerViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerInlineViewModel(Locale locale, MessageManager messageManager, long j) {
        super(null, null, locale, messageManager, null, j, null, null, null, null, null, 2003, null);
        Intrinsics3.checkNotNullParameter(locale, "locale");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
    }
}
