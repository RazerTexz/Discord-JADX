package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$viewModelForSheet$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker4 extends Lambda implements Function0<EmojiPickerViewModel.Sheet> {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker4(WidgetEmojiPicker widgetEmojiPicker) {
        super(0);
        this.this$0 = widgetEmojiPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiPickerViewModel.Sheet invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiPickerViewModel.Sheet invoke() {
        return new EmojiPickerViewModel.Sheet(WidgetEmojiPicker.access$getEmojiPickerContextType$p(this.this$0), new LocaleManager().getPrimaryLocale(this.this$0.getContext()));
    }
}
