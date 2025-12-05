package com.discord.widgets.chat.input.sticker;

import com.discord.widgets.chat.MessageManager;
import java.util.Locale;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StickerPickerSheetViewModel.kt */
/* loaded from: classes2.dex */
public final class StickerPickerSheetViewModel extends StickerPickerViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerPickerSheetViewModel(Locale locale, MessageManager messageManager, long j) {
        super(null, null, locale, messageManager, null, j, null, null, null, null, null, 2003, null);
        Intrinsics3.checkNotNullParameter(locale, "locale");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
    }
}
