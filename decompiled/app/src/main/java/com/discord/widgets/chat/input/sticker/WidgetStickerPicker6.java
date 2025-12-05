package com.discord.widgets.chat.input.sticker;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.MessageManager;
import java.util.Locale;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetStickerPicker.kt */
/* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPicker$viewModelForSheet$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetStickerPicker6 extends Lambda implements Function0<StickerPickerSheetViewModel> {
    public final /* synthetic */ WidgetStickerPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerPicker6(WidgetStickerPicker widgetStickerPicker) {
        super(0);
        this.this$0 = widgetStickerPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StickerPickerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerPickerSheetViewModel invoke() {
        Locale primaryLocale = new LocaleManager().getPrimaryLocale(this.this$0.requireContext());
        MessageManager messageManager = new MessageManager(this.this$0.requireContext(), null, null, null, null, null, null, null, null, 510, null);
        Long lAccess$getInitialStickerPackId$p = WidgetStickerPicker.access$getInitialStickerPackId$p(this.this$0);
        return new StickerPickerSheetViewModel(primaryLocale, messageManager, lAccess$getInitialStickerPackId$p != null ? lAccess$getInitialStickerPackId$p.longValue() : -1L);
    }
}
