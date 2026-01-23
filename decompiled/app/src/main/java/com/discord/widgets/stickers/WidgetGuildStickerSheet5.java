package com.discord.widgets.stickers;

import com.discord.api.sticker.Sticker;
import java.io.Serializable;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet5 extends Lambda implements Function0<GuildStickerSheetViewModel> {
    public final /* synthetic */ WidgetGuildStickerSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildStickerSheet5(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        super(0);
        this.this$0 = widgetGuildStickerSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ GuildStickerSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final GuildStickerSheetViewModel invoke() {
        Serializable serializable = WidgetGuildStickerSheet.access$getArgumentsOrDefault$p(this.this$0).getSerializable("com.discord.intent.extra.EXTRA_STICKER");
        Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.discord.api.sticker.Sticker");
        return new GuildStickerSheetViewModel((Sticker) serializable, null, null, null, null, null, 62, null);
    }
}
