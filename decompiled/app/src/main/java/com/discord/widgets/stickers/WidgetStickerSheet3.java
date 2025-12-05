package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetStickerSheet.kt */
/* renamed from: com.discord.widgets.stickers.WidgetStickerSheet$viewModel$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetStickerSheet3 extends Lambda implements Function0<StickerSheetViewModel> {
    public final /* synthetic */ WidgetStickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStickerSheet3(WidgetStickerSheet widgetStickerSheet) {
        super(0);
        this.this$0 = widgetStickerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ StickerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StickerSheetViewModel invoke() {
        Serializable serializable = WidgetStickerSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        return new StickerSheetViewModel((Sticker) serializable, null, null, WidgetStickerSheet.access$getArgumentsOrDefault$p(this.this$0).getString("widget_sticker_sheet_analytics_location"), null, 22, null);
    }
}
