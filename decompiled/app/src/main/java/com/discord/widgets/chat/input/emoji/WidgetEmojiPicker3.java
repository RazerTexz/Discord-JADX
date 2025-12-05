package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.chat.input.emoji.EmojiPickerViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetEmojiPicker.kt */
/* renamed from: com.discord.widgets.chat.input.emoji.WidgetEmojiPicker$viewModelForInline$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEmojiPicker3 extends Lambda implements Function0<EmojiPickerViewModel.Inline> {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiPicker3(WidgetEmojiPicker widgetEmojiPicker) {
        super(0);
        this.this$0 = widgetEmojiPicker;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ EmojiPickerViewModel.Inline invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final EmojiPickerViewModel.Inline invoke() {
        return new EmojiPickerViewModel.Inline(WidgetEmojiPicker.access$getEmojiPickerContextType$p(this.this$0), new LocaleManager().getPrimaryLocale(this.this$0.getContext()));
    }
}
