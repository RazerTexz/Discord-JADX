package com.discord.widgets.chat.input.gifpicker;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGifPickerSearch.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSearch$gifPickerViewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGifPickerSearch3 extends Lambda implements Function0<GifSearchViewModel> {
    public final /* synthetic */ WidgetGifPickerSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGifPickerSearch3(WidgetGifPickerSearch widgetGifPickerSearch) {
        super(0);
        this.this$0 = widgetGifPickerSearch;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GifSearchViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GifSearchViewModel invoke() {
        return new GifSearchViewModel(this.this$0.requireContext(), null, null, null, null, null, 62, null);
    }
}
